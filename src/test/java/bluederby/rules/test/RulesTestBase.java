package bluederby.rules.test;

import java.util.Map.Entry;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;

public abstract class RulesTestBase implements IBaseRulesTestHelper {
	private KnowledgeBase knowledgeBase;

	public RulesTestBase() {
		try{
			KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

			for (Entry<String, ResourceType> entry : getResourceList().entrySet()) {
				kbuilder.add(ResourceFactory.newClassPathResource(entry.getKey()), entry.getValue());
				hasErrors(kbuilder);
			}
			knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
			hasErrors(kbuilder);
			knowledgeBase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		}catch(Exception e){
			System.err.println("Error initializing KnowledgeBaseServerce:");
			e.printStackTrace(System.err);
		}
	}

	private void hasErrors(KnowledgeBuilder kbuilder) throws Exception {
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error: errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}
	}

	public StatelessKnowledgeSession newStatelessSession(){
		return knowledgeBase.newStatelessKnowledgeSession();
	}
	public StatefulKnowledgeSession newStatefulSession() {
		return knowledgeBase.newStatefulKnowledgeSession();
	}
}
