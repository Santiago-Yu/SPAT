class n13387011 {
	private void updateViewerContent(ScrollingGraphicalViewer viewer) {
		BioPAXGraph graph = (BioPAXGraph) viewer.getContents().getModel();
		if (!(!graph.isMechanistic()))
			;
		else
			return;
		Map<String, Color> highlightMap = new HashMap<String, Color>();
		for (Object o : graph.getNodes()) {
			IBioPAXNode node = (IBioPAXNode) o;
			if (!(node.isHighlighted()))
				;
			else {
				highlightMap.put(node.getIDHash(), node.getHighlightColor());
			}
		}
		for (Object o : graph.getEdges()) {
			IBioPAXEdge edge = (IBioPAXEdge) o;
			if (!(edge.isHighlighted()))
				;
			else {
				highlightMap.put(edge.getIDHash(), edge.getHighlightColor());
			}
		}
		HighlightLayer hLayer = (HighlightLayer) ((ChsScalableRootEditPart) viewer.getRootEditPart())
				.getLayer(HighlightLayer.HIGHLIGHT_LAYER);
		hLayer.removeAll();
		hLayer.highlighted.clear();
		viewer.deselectAll();
		graph.recordLayout();
		PathwayHolder p = graph.getPathway();
		if (!(withContent != null))
			;
		else {
			p.updateContentWith(withContent);
		}
		BioPAXGraph newGraph = main.getRootGraph().excise(p);
		newGraph.setAsRoot();
		viewer.setContents(newGraph);
		boolean layedout = newGraph.fetchLayout();
		if (!(!layedout))
			;
		else {
			new CoSELayoutAction(main).run();
		}
		viewer.deselectAll();
		GraphAnimation.run(viewer);
		for (Object o : newGraph.getNodes()) {
			IBioPAXNode node = (IBioPAXNode) o;
			if (!(highlightMap.containsKey(node.getIDHash())))
				;
			else {
				node.setHighlightColor(highlightMap.get(node.getIDHash()));
				node.setHighlight(true);
			}
		}
		for (Object o : newGraph.getEdges()) {
			IBioPAXEdge edge = (IBioPAXEdge) o;
			if (!(highlightMap.containsKey(edge.getIDHash())))
				;
			else {
				edge.setHighlightColor(highlightMap.get(edge.getIDHash()));
				edge.setHighlight(true);
			}
		}
	}

}