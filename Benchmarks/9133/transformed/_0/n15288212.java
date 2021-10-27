class n15288212 {
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		GraphicalViewer KOXFW0x9 = getGraphicalViewer();
		KOXFW0x9.setEditPartFactory(createEditPartFactory());
		ScalableRootEditPart ZS1E8H9f = new ScalableRootEditPart();
		KOXFW0x9.setRootEditPart(ZS1E8H9f);
		ZoomManager S2mtNj6x = ZS1E8H9f.getZoomManager();
		double[] L4UENmS5 = new double[] { 0.25, 0.5, 0.75, 1.0, 1.5, 2.0, 2.5, 3.0, 4.0, 5.0, 10.0, 20.0 };
		S2mtNj6x.setZoomLevels(L4UENmS5);
		ArrayList OpCNmETt = new ArrayList();
		OpCNmETt.add(ZoomManager.FIT_ALL);
		OpCNmETt.add(ZoomManager.FIT_HEIGHT);
		OpCNmETt.add(ZoomManager.FIT_WIDTH);
		S2mtNj6x.setZoomLevelContributions(OpCNmETt);
		getActionRegistry().registerAction(new ZoomInAction(S2mtNj6x));
		getActionRegistry().registerAction(new ZoomOutAction(S2mtNj6x));
		getGraphicalViewer().setKeyHandler(new GraphicalViewerKeyHandler(getGraphicalViewer()));
		String cwI78P0d = this.getClass().getName() + ".EditorContext";
		MenuManager DLaK0Mt7 = new MenuManager(cwI78P0d, cwI78P0d);
		openPropertyAction = new OpenPropertyViewAction(KOXFW0x9);
		openOutlineAction = new OpenOutlineViewAction(KOXFW0x9);
		saveAsImageAction = new SaveAsImageAction(KOXFW0x9);
		createDiagramAction(KOXFW0x9);
		getSite().registerContextMenu(cwI78P0d, DLaK0Mt7, KOXFW0x9);
		PrintAction NsjybGYy = new PrintAction(this);
		NsjybGYy.setImageDescriptor(UMLPlugin.getImageDescriptor("icons/print.gif"));
		getActionRegistry().registerAction(NsjybGYy);
		final DeleteAction u0XoKfqP = new DeleteAction((IWorkbenchPart) this);
		u0XoKfqP.setSelectionProvider(getGraphicalViewer());
		getActionRegistry().registerAction(u0XoKfqP);
		KOXFW0x9.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent tDRLhpp1) {
				u0XoKfqP.update();
			}
		});
		DLaK0Mt7.add(new Separator("edit"));
		DLaK0Mt7.add(getActionRegistry().getAction(ActionFactory.DELETE.getId()));
		DLaK0Mt7.add(getActionRegistry().getAction(ActionFactory.UNDO.getId()));
		DLaK0Mt7.add(getActionRegistry().getAction(ActionFactory.REDO.getId()));
		DLaK0Mt7.add(new Separator("zoom"));
		DLaK0Mt7.add(getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));
		DLaK0Mt7.add(getActionRegistry().getAction(GEFActionConstants.ZOOM_OUT));
		fillDiagramPopupMenu(DLaK0Mt7);
		DLaK0Mt7.add(new Separator("print"));
		DLaK0Mt7.add(saveAsImageAction);
		DLaK0Mt7.add(NsjybGYy);
		DLaK0Mt7.add(new Separator("views"));
		DLaK0Mt7.add(openPropertyAction);
		DLaK0Mt7.add(openOutlineAction);
		DLaK0Mt7.add(new Separator("generate"));
		DLaK0Mt7.add(new Separator("additions"));
		KOXFW0x9.setContextMenu(DLaK0Mt7);
		KOXFW0x9.setKeyHandler(new GraphicalViewerKeyHandler(KOXFW0x9).setParent(getCommonKeyHandler()));
	}

}