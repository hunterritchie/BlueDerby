package bluederby.service;

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

public class KnowledgeBaseService {

	private KnowledgeBase knowledgeBase;
	private static KnowledgeBaseService instance;
	
	public  static KnowledgeBaseService getInstance(){
		if(instance == null)
			instance = new KnowledgeBaseService();
		return instance;
	}
	private KnowledgeBaseService() {
		try{
			KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//			kbuilder.add(ResourceFactory.newClassPathResource("policyquote.package"), ResourceType.DRL);
//			hasErrors(kbuilder);
			kbuilder.add(ResourceFactory.newClassPathResource("PremiumCustomer.drl"), ResourceType.DRL);
			hasErrors(kbuilder);
			kbuilder.add(ResourceFactory.newClassPathResource("RoomType.drl"), ResourceType.DRL);
			hasErrors(kbuilder);
			kbuilder.add(ResourceFactory.newClassPathResource("GroupRates.drl"), ResourceType.DRL);
			hasErrors(kbuilder);
			knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
			hasErrors(kbuilder);
			knowledgeBase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		}catch(Exception e){
			System.err.println("Error initializing KnowledgeBaseServerce:");
			e.printStackTrace(System.err);
		}
	}
	
	public StatelessKnowledgeSession newStatelessSession(){
		return knowledgeBase.newStatelessKnowledgeSession();
	}
	public StatefulKnowledgeSession newStatefulSession() {
		return knowledgeBase.newStatefulKnowledgeSession();
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

	
}
