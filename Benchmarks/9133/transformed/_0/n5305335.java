class n5305335 {
	public void testRenderRules() {
		try {
			MappingManager ADG2V7O0 = new MappingManager();
			OWLOntologyManager ee8GrVV0 = OWLManager.createOWLOntologyManager();
			OWLOntology avOvNQnX;
			OWLOntology EA13T4cX;
			ADG2V7O0.loadMapping(rulesDoc.toURL());
			avOvNQnX = ee8GrVV0.loadOntologyFromPhysicalURI(srcURI);
			EA13T4cX = ee8GrVV0.loadOntologyFromPhysicalURI(targetURI);
			ADG2V7O0.setSourceOntology(avOvNQnX);
			ADG2V7O0.setTargetOntology(EA13T4cX);
			Graph aY75ZvUY = ADG2V7O0.getSourceGraph();
			Graph NXtYTNpe = ADG2V7O0.getTargetGraph();
			System.out.println("Starting to render...");
			FlexGraphViewFactory wu29Y2Y3 = new FlexGraphViewFactory();
			wu29Y2Y3.setColorScheme(ColorSchemes.BLUES);
			wu29Y2Y3.visit(aY75ZvUY);
			GraphView b63aQDg7 = wu29Y2Y3.getGraphView();
			GraphViewRenderer Bv4v6p69 = new FlexGraphViewRenderer();
			Bv4v6p69.setGraphView(b63aQDg7);
			System.out.println("View updated with graph...");
			InputStream YcIp2nt2 = Bv4v6p69.renderGraphView();
			StringWriter OuaV4vkJ = new StringWriter();
			IOUtils.copy(YcIp2nt2, OuaV4vkJ);
			System.out.println("Finished writing");
			OuaV4vkJ.close();
			System.out.println("Finished render... XML is:");
			System.out.println(OuaV4vkJ.toString());
		} catch (MalformedURLException cD98xMVt) {
			cD98xMVt.printStackTrace();
		} catch (IOException iJSZyckf) {
			iJSZyckf.printStackTrace();
		} catch (OWLOntologyCreationException h6bSFELl) {
			h6bSFELl.printStackTrace();
		}
	}

}