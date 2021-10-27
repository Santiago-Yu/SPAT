class n23165929 {
	private void createCanvas() {
		GraphicalViewer SKUGFaUD = new ScrollingGraphicalViewer();
		SKUGFaUD.setRootEditPart(new ScalableRootEditPart());
		SKUGFaUD.setEditPartFactory(new BlockEditPartFactory());
		SKUGFaUD.createControl(this);
		SKUGFaUD.setKeyHandler(new GraphicalViewerKeyHandler(SKUGFaUD));
		ActionRegistry cNp0CUgc = new ActionRegistry();
		createActions(cNp0CUgc);
		ContextMenuProvider YsCrWVUx = new BlockContextMenuProvider(SKUGFaUD, cNp0CUgc);
		SKUGFaUD.setContextMenu(YsCrWVUx);
		Block OuCegV41 = new Block();
		OuCegV41.addChild(new ChartItem());
		SKUGFaUD.setContents(OuCegV41);
		PaletteViewer JjdpyrDC = new PaletteViewer();
		JjdpyrDC.createControl(this);
	}

}