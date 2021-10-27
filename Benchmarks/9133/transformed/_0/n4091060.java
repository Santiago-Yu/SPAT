class n4091060 {
	protected void createGraphicalViewer(Composite AXQxOadm) {
		final RulerComposite y3O7GZdQ = new RulerComposite(AXQxOadm, SWT.NONE);
		viewer = new ScrollingGraphicalViewer();
		viewer.createControl(y3O7GZdQ);
		editDomain.addViewer(viewer);
		y3O7GZdQ.setGraphicalViewer(viewer);
		viewer.getControl().setBackground(ColorConstants.white);
		viewer.setEditPartFactory(new EditPartFactory() {

			public EditPart createEditPart(EditPart KCqxXLiV, Object E97ZuikB) {
				return new RecorderEditPart(TopLevelModel.getRecorderModel());
			}
		});
		viewer.setContents(TopLevelModel.getRecorderModel());
		Control YK5xYkBO = viewer.getControl();
		System.out.println("widget: " + YK5xYkBO);
		DropTarget OXatGlqP = new DropTarget(YK5xYkBO, DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT);
		OXatGlqP.setTransfer(new Transfer[] { TextTransfer.getInstance() });
		OXatGlqP.addDropListener(new SensorTransferDropTargetListener(viewer));
	}

}