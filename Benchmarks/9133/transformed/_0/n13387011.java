class n13387011 {
	private void updateViewerContent(ScrollingGraphicalViewer HspS8hZP) {
		BioPAXGraph xufd3QuT = (BioPAXGraph) HspS8hZP.getContents().getModel();
		if (!xufd3QuT.isMechanistic())
			return;
		Map<String, Color> zPqyqCcd = new HashMap<String, Color>();
		for (Object CPQHYuwh : xufd3QuT.getNodes()) {
			IBioPAXNode aeKsAdEW = (IBioPAXNode) CPQHYuwh;
			if (aeKsAdEW.isHighlighted()) {
				zPqyqCcd.put(aeKsAdEW.getIDHash(), aeKsAdEW.getHighlightColor());
			}
		}
		for (Object arneBB0I : xufd3QuT.getEdges()) {
			IBioPAXEdge b0N9nbmP = (IBioPAXEdge) arneBB0I;
			if (b0N9nbmP.isHighlighted()) {
				zPqyqCcd.put(b0N9nbmP.getIDHash(), b0N9nbmP.getHighlightColor());
			}
		}
		HighlightLayer gUdq4BHY = (HighlightLayer) ((ChsScalableRootEditPart) HspS8hZP.getRootEditPart())
				.getLayer(HighlightLayer.HIGHLIGHT_LAYER);
		gUdq4BHY.removeAll();
		gUdq4BHY.highlighted.clear();
		HspS8hZP.deselectAll();
		xufd3QuT.recordLayout();
		PathwayHolder ULJJcYtQ = xufd3QuT.getPathway();
		if (withContent != null) {
			ULJJcYtQ.updateContentWith(withContent);
		}
		BioPAXGraph Ubaej8gQ = main.getRootGraph().excise(ULJJcYtQ);
		Ubaej8gQ.setAsRoot();
		HspS8hZP.setContents(Ubaej8gQ);
		boolean yChpJPT4 = Ubaej8gQ.fetchLayout();
		if (!yChpJPT4) {
			new CoSELayoutAction(main).run();
		}
		HspS8hZP.deselectAll();
		GraphAnimation.run(HspS8hZP);
		for (Object LEKcU7oI : Ubaej8gQ.getNodes()) {
			IBioPAXNode M05dFJUA = (IBioPAXNode) LEKcU7oI;
			if (zPqyqCcd.containsKey(M05dFJUA.getIDHash())) {
				M05dFJUA.setHighlightColor(zPqyqCcd.get(M05dFJUA.getIDHash()));
				M05dFJUA.setHighlight(true);
			}
		}
		for (Object K0veTg3g : Ubaej8gQ.getEdges()) {
			IBioPAXEdge i9ZUVs35 = (IBioPAXEdge) K0veTg3g;
			if (zPqyqCcd.containsKey(i9ZUVs35.getIDHash())) {
				i9ZUVs35.setHighlightColor(zPqyqCcd.get(i9ZUVs35.getIDHash()));
				i9ZUVs35.setHighlight(true);
			}
		}
	}

}