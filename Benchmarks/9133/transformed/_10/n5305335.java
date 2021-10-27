class n5305335 {
	public void testRenderRules() {
		try {
			OWLOntologyManager omanager = OWLManager.createOWLOntologyManager();
			MappingManager manager = new MappingManager();
			OWLOntology targetOntology;
			OWLOntology srcOntology;
			manager.loadMapping(rulesDoc.toURL());
			srcOntology = omanager.loadOntologyFromPhysicalURI(srcURI);
			targetOntology = omanager.loadOntologyFromPhysicalURI(targetURI);
			manager.setSourceOntology(srcOntology);
			manager.setTargetOntology(targetOntology);
			Graph srcGraph = manager.getSourceGraph();
			Graph targetGraph = manager.getTargetGraph();
			System.out.println("Starting to render...");
			FlexGraphViewFactory factory = new FlexGraphViewFactory();
			factory.setColorScheme(ColorSchemes.BLUES);
			factory.visit(srcGraph);
			GraphViewRenderer renderer = new FlexGraphViewRenderer();
			GraphView view = factory.getGraphView();
			renderer.setGraphView(view);
			System.out.println("View updated with graph...");
			StringWriter writer = new StringWriter();
			InputStream xmlStream = renderer.renderGraphView();
			IOUtils.copy(xmlStream, writer);
			System.out.println("Finished writing");
			writer.close();
			System.out.println("Finished render... XML is:");
			System.out.println(writer.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		}
	}

}