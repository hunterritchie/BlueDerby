#!/bin/sh 
DEMO="Blue Derby"

# XXX set this in your environment
#TORQUEBOX_HOME=/home/hunter/.rvm/gems/jruby-1.7.4@global/gems/torquebox-server-2.3.1-java

JBOSS_HOME=$TORQUEBOX_HOME/jboss/
SERVER_DIR=$JBOSS_HOME/standalone/deployments/
SERVER_CONF=$JBOSS_HOME/standalone/configuration/
SRC_DIR=./installs
#PRJ_DIR=./projects/brms-customer-evaluation-demo
EAP=jboss-eap-6.1.0.zip
BRMS=brms-p-5.3.1.GA-deployable-ee6.zip
DESIGNER=designer-patched.war
VERSION=5.3.1
MAVENIZE_VERSION=5.3.1.BRMS

# wipe screen.
clear 

##
# Installation mavanization functions.
##
installPom() {
		mvn -q install:install-file -Dfile=../support/$2-$MAVENIZE_VERSION.pom.xml -DgroupId=$1 -DartifactId=$2 -Dversion=$MAVENIZE_VERSION -Dpackaging=pom;
}

	installBinary() {
			unzip -q $2-$MAVENIZE_VERSION.jar META-INF/maven/$1/$2/pom.xml;
			mvn -q install:install-file -DpomFile=./META-INF/maven/$1/$2/pom.xml -Dfile=$2-$MAVENIZE_VERSION.jar -DgroupId=$1 -DartifactId=$2 -Dversion=$MAVENIZE_VERSION -Dpackaging=jar;
}

echo
echo "Setting up the JBoss Enterprise EAP 6 ${DEMO} environment..."
echo

# make some checks first before proceeding.	
#if [[ -r $SRC_DIR/$EAP || -L $SRC_DIR/$EAP ]]; then
#		echo EAP sources are present...
#		echo
#else
#		echo Need to download $EAP package from the Customer Support Portal 
#		echo and place it in the $SRC_DIR directory to proceed...
#		echo
#		exit
#fi

# Create the target directory if it does not already exist.
if [ ! -x target ]; then
		echo "  - creating the target directory..."
		echo
		mkdir target
else
		echo "  - detected target directory, moving on..."
		echo
fi

# Move the old JBoss instance, if it exists, to the OLD position.
#if [ -x $JBOSS_HOME ]; then
		#echo "  - existing JBoss Enterprise EAP 6 detected..."
		#echo
		#echo "  - moving existing JBoss Enterprise EAP 6 aside..."
		#echo
		#rm -rf $JBOSS_HOME.OLD
		#mv $JBOSS_HOME $JBOSS_HOME.OLD
#
		## Unzip the JBoss EAP instance.
		#echo Unpacking JBoss Enterprise EAP 6...
		#echo
		#unzip -q -d $JBOSS_DIR $SRC_DIR/$EAP
#else
		## Unzip the JBoss EAP instance.
		#echo Unpacking new JBoss Enterprise EAP 6...
		#echo
		#unzip -q -d $JBOSS_DIR $SRC_DIR/$EAP
#fi

# Unzip the required files from JBoss BRMS Deployable
echo Unpacking JBoss Enterprise BRMS $VERSION...
echo
cd installs
unzip -q $BRMS

echo "  - deploying JBoss Enterprise BRMS Manager WAR..."
echo
unzip -q -d $SERVER_DIR jboss-brms-manager-ee6.zip
rm jboss-brms-manager-ee6.zip 

echo "  - deploying jBPM Console WARs..."
echo
unzip -q -d $SERVER_DIR jboss-jbpm-console-ee6.zip
rm jboss-jbpm-console-ee6.zip

unzip -q jboss-jbpm-engine.zip 
echo "  - copying jBPM client JARs..."
echo
unzip -q -d $SERVER_DIR jboss-jbpm-engine.zip lib/netty.jar
rm jboss-jbpm-engine.zip
rm -rf *.jar modeshape.zip *.RSA lib
rm jboss-brms-engine.zip

echo Rounding up, setting permissions and copying support files...
echo
cd ../

echo Updating to the newest web designer...
echo
rm -rf $SERVER_DIR/designer.war/*
unzip -q support/$DESIGNER -d $SERVER_DIR/designer.war

echo "  - set designer to jboss-brms in profile..."
echo
cp support/designer-jbpm.xml $SERVER_DIR/designer.war/profiles/jbpm.xml

echo "  - enabling demo accounts logins in brms-users.properties file..."
echo
cp support/brms-users.properties $SERVER_CONF

echo "  - enabling demo accounts role setup in brms-roles.properties file..."
echo
cp support/brms-roles.properties $SERVER_CONF

echo "  - adding dodeploy files to deploy all brms components..."
echo 
touch $SERVER_DIR/business-central-server.war.dodeploy
touch $SERVER_DIR/business-central.war.dodeploy
touch $SERVER_DIR/designer.war.dodeploy
touch $SERVER_DIR/jboss-brms.war.dodeploy
touch $SERVER_DIR/jbpm-human-task.war.dodeploy

echo "  - configuring security authentication, copying updated components.xml file to jboss-brms.war..."
echo
cp support/components.xml $SERVER_DIR/jboss-brms.war/WEB-INF/

echo "  - configuring deployment timeout extention and added security domain brms in standalone.xml..."
echo
cp support/standalone.xml $SERVER_CONF

# Add execute permissions to the standalone.sh script.
echo "  - making sure standalone.sh for server is executable..."
echo
chmod u+x $JBOSS_HOME/bin/standalone.sh

echo "  - enabling demo users for human tasks in jbpm-human-task.war web.xml file..."
echo
cp support/jbpm-human-task-war-web.xml $SERVER_DIR/jbpm-human-task.war/WEB-INF/web.xml

echo "  - enabling work items by registering Email and Log nodes..."
echo
cp support/drools.session.conf $SERVER_DIR/business-central-server.war/WEB-INF/classes/META-INF
cp support/CustomWorkItemHandlers.conf $SERVER_DIR/business-central-server.war/WEB-INF/classes/META-INF
chmod 644 $SERVER_DIR/business-central-server.war/WEB-INF/classes/META-INF/drools.session.conf
chmod 644 $SERVER_DIR/business-central-server.war/WEB-INF/classes/META-INF/CustomWorkItemHandlers.conf

#echo "  - adding model jar to business central admin console classpath..." 
#echo
#cp support/customereval-model.jar $SERVER_DIR/business-central-server.war/WEB-INF/lib

echo "  - adding netty dep to business-central-server.war and jbpm-human-task.war..."
echo
cp support/MANIFEST.MF $SERVER_DIR/business-central-server.war/WEB-INF/classes/META-INF/
cp support/MANIFEST.MF $SERVER_DIR/jbpm-human-task.war/WEB-INF/classes/META-INF/

echo "  - mavenizing your repo with BRMS components."
echo
echo
echo Installing the BRMS binaries into the Maven repository...
echo
unzip -q $SRC_DIR/$BRMS jboss-brms-engine.zip
unzip -q jboss-brms-engine.zip binaries/*
unzip -q $SRC_DIR/$BRMS jboss-jbpm-engine.zip
unzip -q -o -d ./binaries jboss-jbpm-engine.zip
cd binaries

echo Installing parent POMs...
echo
installPom org.drools droolsjbpm-parent
installPom org.drools droolsjbpm-knowledge
installPom org.drools drools-multiproject
installPom org.drools droolsjbpm-tools
installPom org.drools droolsjbpm-integration
installPom org.drools guvnor
installPom org.jbpm jbpm

echo Installing Rules dependencies into your Maven repository...
echo
#
# droolsjbpm-knowledge
installBinary org.drools knowledge-api

#
# drools-multiproject
installBinary org.drools drools-core
installBinary org.drools drools-compiler
installBinary org.drools drools-jsr94
installBinary org.drools drools-verifier
installBinary org.drools drools-persistence-jpa
installBinary org.drools drools-templates
installBinary org.drools drools-decisiontables

#
# droolsjbpm-tools
installBinary org.drools drools-ant

#
# droolsjbpm-integration
installBinary org.drools drools-camel

#
# guvnor
installBinary org.drools droolsjbpm-ide-common

echo Installing BPM dependencies into your Maven repository...
echo
installBinary org.jbpm jbpm-flow
installBinary org.jbpm jbpm-flow-builder
installBinary org.jbpm jbpm-persistence-jpa
installBinary org.jbpm jbpm-bam
installBinary org.jbpm jbpm-bpmn2
installBinary org.jbpm jbpm-workitems
installBinary org.jbpm jbpm-human-task
installBinary org.jbpm jbpm-test

cd ..
rm -rf binaries jboss-jbpm-engine.zip jboss-brms-engine.zip 

echo Installation of binaries for BRMS $MAVENIZE_VERSION complete.
echo

#echo Now going to build the model jars by generating classes in your project.
#echo
#cd $PRJ_DIR
#mvn clean install -DskipTests
#cd ../..

#echo "  - copying model jars and configuration to Business Central server..."
#echo 
#cp $PRJ_DIR/target/customereval-model.jar $SERVER_DIR/business-central-server.war/WEB-INF/lib

echo "JBoss Enterprise BRMS ${VERSION} ${DEMO} Setup Complete."
echo

