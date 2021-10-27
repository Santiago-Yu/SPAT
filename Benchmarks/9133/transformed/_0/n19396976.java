class n19396976 {
	public void createPartControl(Composite jsI5YD6M) {
		splitter = new FlyoutPaletteComposite(jsI5YD6M, SWT.NONE, getSite().getPage(), getPaletteViewerProvider(),
				new PaletteFlyoutPreferences());
		viewer = new ScrollingGraphicalViewer();
		viewer.createControl(splitter);
		editDomain.addViewer(viewer);
		viewer.getControl().setBackground(ColorConstants.listBackground);
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_SPACING, new Dimension(45, 45));
		ScalableFreeformRootEditPart ZB9KQ2m9 = new CustomRootEditPart();
		viewer.setRootEditPart(ZB9KQ2m9);
		viewer.setEditPartFactory(new CustomEditPartFactory());
		getSelectionSynchronizer().addViewer(viewer);
		getSite().setSelectionProvider(viewer);
		splitter.hookDropTargetListener(viewer);
		splitter.setGraphicalControl(viewer.getControl());
		configureViewerActions(ZB9KQ2m9);
		configureKeyHandler();
		ContextMenuProvider mxmoqFVR = new DiagramContextMenuProvider(viewer, actionRegistry, undoRedoGroup);
		viewer.setContextMenu(mxmoqFVR);
		viewer.addDropTargetListener(DiagramDropTargetListener.forImport(viewer));
		viewer.addDropTargetListener(DiagramDropTargetListener.forModel(viewer));
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent gtXeo80X) {
				IStructuredSelection l1yz5ZGm = (IStructuredSelection) gtXeo80X.getSelection();
				if (l1yz5ZGm.size() == 1) {
					EditPart w980Zgw3 = (EditPart) l1yz5ZGm.getFirstElement();
					if (w980Zgw3 instanceof TableEditPart) {
						Table GkfXwg39 = ((TableEditPart) w980Zgw3).getTable();
						RMBenchPlugin.getEventManager().fireTableSelected(DiagramEditor.this, GkfXwg39);
					} else if (w980Zgw3 instanceof ColumnEditPart) {
						Column k5pRXj1T = ((ColumnEditPart) w980Zgw3).getColumn();
						RMBenchPlugin.getEventManager().fireColumnSelected(DiagramEditor.this, k5pRXj1T);
					} else if (w980Zgw3 instanceof ForeignKeyEditPart) {
						ForeignKey hCbpJrEL = ((ForeignKeyEditPart) w980Zgw3).getForeignKey();
						RMBenchPlugin.getEventManager().fireForeignKeySelected(DiagramEditor.this, hCbpJrEL);
					} else {
						RMBenchPlugin.getEventManager().fireTableSelected(DiagramEditor.this, null);
					}
				}
				updateActions(selectionActionIDs);
			}
		});
		viewer.setContents(getDiagram());
		if (RMBenchPlugin.getModelManager().isDirty())
			firePropertyChange(IWorkbenchPartConstants.PROP_DIRTY);
		pasteTablesAction.hookEvents();
	}

}