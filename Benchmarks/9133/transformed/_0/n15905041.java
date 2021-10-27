class n15905041 {
	public void createPartControl(Composite eWMMOdTG) {
		viewer = new ScrollingGraphicalViewer();
		viewer.setRootEditPart(new ScalableRootEditPart());
		viewer.setEditPartFactory(new BlockEditPartFactory());
		viewer.setEditDomain(new EditDomain());
		viewer.createControl(eWMMOdTG);
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));
		ActionRegistry q9KbcDjh = new ActionRegistry();
		createActions(q9KbcDjh);
		ContextMenuProvider s2mqhNNw = new BlockContextMenuProvider(viewer, q9KbcDjh);
		viewer.setContextMenu(s2mqhNNw);
		Block YRQyWthL = new Block();
		YRQyWthL.addChild(new ChartItem());
		viewer.setContents(YRQyWthL);
		System.err.println("!!! " + viewer.getContents().getChildren().get(0));
		viewer.select((EditPart) viewer.getContents().getChildren().get(0));
		PaletteRoot ChJVHA3s = new PaletteRoot();
		PaletteGroup um1VJQKF = new PaletteGroup("Chart Tools");
		List xEr6v26a = new ArrayList();
		ToolEntry q7W0z0IW = new SelectionToolEntry();
		xEr6v26a.add(q7W0z0IW);
		ChJVHA3s.setDefaultEntry(q7W0z0IW);
		q7W0z0IW = new MarqueeToolEntry();
		xEr6v26a.add(q7W0z0IW);
		um1VJQKF.addAll(xEr6v26a);
		PaletteGroup mGWbg4iD = new PaletteGroup("Templates");
		List fjbzGdKc = new ArrayList();
		CombinedTemplateCreationEntry k3AQmmn0 = new CombinedTemplateCreationEntry("Rect", "Rect", new ChartItem(),
				new SimpleFactory(ChartItem.class), ImageDescriptor.getMissingImageDescriptor(),
				ImageDescriptor.getMissingImageDescriptor());
		CombinedTemplateCreationEntry Y1FkncYS = new CombinedTemplateCreationEntry("Line", "Line", new ChartLine(),
				new SimpleFactory(ChartLine.class), ImageDescriptor.getMissingImageDescriptor(),
				ImageDescriptor.getMissingImageDescriptor());
		fjbzGdKc.add(k3AQmmn0);
		fjbzGdKc.add(Y1FkncYS);
		mGWbg4iD.addAll(fjbzGdKc);
		List EthozxTr = new ArrayList();
		EthozxTr.add(um1VJQKF);
		EthozxTr.add(mGWbg4iD);
		ChJVHA3s.addAll(EthozxTr);
		final PaletteViewer HVrlBFzg = new PaletteViewer();
		HVrlBFzg.setPaletteRoot(ChJVHA3s);
		HVrlBFzg.createControl(eWMMOdTG);
		HVrlBFzg.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent q4Q6RjNP) {
				System.err.println("selectionChanged " + HVrlBFzg.getActiveTool());
			}
		});
		deleteAction.setSelectionProvider(viewer);
		viewer.getEditDomain().setPaletteViewer(HVrlBFzg);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent ar9a0Lt9) {
				System.err.println(ar9a0Lt9.getSelection());
				deleteAction.update();
			}
		});
		viewer.getEditDomain().getCommandStack().addCommandStackEventListener(new CommandStackEventListener() {

			public void stackChanged(CommandStackEvent x9WvUUZm) {
				undoAction.setEnabled(viewer.getEditDomain().getCommandStack().canUndo());
				redoAction.setEnabled(viewer.getEditDomain().getCommandStack().canRedo());
			}
		});
	}

}