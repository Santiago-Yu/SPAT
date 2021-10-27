class n1724014 {
	public Component loadComponent(URI z3Jw39f6, URI c4lHY1YB) throws ComponentException {
		if (usePrivMan)
			PrivilegeManager.enablePrivilege("UniversalConnect");
		ConzillaRDFModel Cfw3kC2F = factory.createModel(c4lHY1YB, z3Jw39f6);
		RDFParser BSc7pnXN = new com.hp.hpl.jena.rdf.arp.StanfordImpl();
		java.net.URL yiqUrqlb = null;
		try {
			yiqUrqlb = z3Jw39f6.getJavaURL();
		} catch (java.net.MalformedURLException cWR3WgnB) {
			throw new ComponentException(
					"Invalid URL " + z3Jw39f6 + " for component " + c4lHY1YB + ":\n " + cWR3WgnB.getMessage());
		}
		try {
			InputSource lrstiEVV = new InputSource(yiqUrqlb.openStream());
			lrstiEVV.setSystemId(c4lHY1YB.toString());
			BSc7pnXN.parse(lrstiEVV, new ModelConsumer(Cfw3kC2F));
			factory.getTotalModel().addModel(Cfw3kC2F);
		} catch (org.xml.sax.SAXException FOX7iJXn) {
			FOX7iJXn.getException().printStackTrace();
			throw new ComponentException("Format error loading URL " + yiqUrqlb + " for component " + c4lHY1YB + ":\n "
					+ FOX7iJXn.getMessage());
		} catch (java.io.IOException spS8gaA0) {
			throw new ComponentException(
					"IO error loading URL " + yiqUrqlb + " for component " + c4lHY1YB + ":\n " + spS8gaA0.getMessage());
		} catch (org.w3c.rdf.model.ModelException TdimSQar) {
			throw new ComponentException("Model error loading URL " + yiqUrqlb + " for component " + c4lHY1YB + ":\n "
					+ TdimSQar.getMessage());
		}
		return Cfw3kC2F;
	}

}