class n21952250 {
	protected void initializeGraphicalViewer() {
		getGraphicalViewer().setContents(loadModel());
		getGraphicalViewer().addDropTargetListener(createTransferDropTargetListener());
		getGraphicalViewer().addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent GMWZNF6X) {
				if (GMWZNF6X.getSelection().isEmpty()) {
					return;
				}
				loadProperties(((StructuredSelection) GMWZNF6X.getSelection()).getFirstElement());
			}
		});
	}

}