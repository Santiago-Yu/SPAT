class n18239637 {
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().setEditPartFactory(fact);
		ITypeRoot cq1pYISQ = sourceEditor.getInputElement();
		try {
			getGraphicalViewer().setContents(cq1pYISQ);
			((DesignTimeComponent) fact.getTopPart().getModelChildren().get(0)).addListener(new DesignTimeListener() {

				public void handleUpdate(DesignTimeComponent AHlxhTMM) {
					updateSourceWithComponent(AHlxhTMM.getTopLevel());
				}
			});
		} catch (Throwable lkuEvcCG) {
			lkuEvcCG.printStackTrace();
		}
		getGraphicalViewer().addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent rCHXh1cj) {
				if (getSelectedComponent() == null) {
					return;
				}
				PropertySheetPage mLs5MjXp = ((PropertySheetPage) getAdapter(IPropertySheetPage.class));
				mLs5MjXp.selectionChanged(getSite().getPart(), new StructuredSelection(getSelectedComponent()));
				try {
				} catch (Throwable g7ZogfKd) {
					g7ZogfKd.printStackTrace();
				}
			}
		});
		getGraphicalViewer().setContextMenu(contextMenu);
		contextMenu.addMenuListener(this);
	}

}