class n16163062 {
	public ImageData getJPEGDiagram() {
		Shell fudZ0vis = new Shell();
		GraphicalViewer SuzpOytF = new ScrollingGraphicalViewer();
		SuzpOytF.createControl(fudZ0vis);
		SuzpOytF.setEditDomain(new DefaultEditDomain(null));
		SuzpOytF.setRootEditPart(new ScalableFreeformRootEditPart());
		SuzpOytF.setEditPartFactory(new CsdeEditPartFactory());
		SuzpOytF.setContents(getDiagram());
		SuzpOytF.flush();
		LayerManager xK0A8XeN = (LayerManager) SuzpOytF.getEditPartRegistry().get(LayerManager.ID);
		IFigure UedGIAuQ = xK0A8XeN.getLayer(LayerConstants.PRINTABLE_LAYERS);
		Dimension FfE7cuN5 = UedGIAuQ.getSize();
		Image ENrgpdEV = new Image(null, FfE7cuN5.width, FfE7cuN5.height);
		GC QXEmcH0f = new GC(ENrgpdEV);
		SWTGraphics nixTeuE1 = new SWTGraphics(QXEmcH0f);
		UedGIAuQ.paint(nixTeuE1);
		fudZ0vis.dispose();
		return ENrgpdEV.getImageData();
	}

}