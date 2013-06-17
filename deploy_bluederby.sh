#!/bin/sh

JBOSS_HOME=$TORQUEBOX_HOME/jboss/
SERVER_DIR=$JBOSS_HOME/standalone/deployments/


echo "Create BlueDerby.jar"
echo
ant jar

echo
echo "Copy jar to Business Central server"
echo
cp ./build/jar/BlueDerby.jar  $SERVER_DIR/business-central-server.war/WEB-INF/lib


