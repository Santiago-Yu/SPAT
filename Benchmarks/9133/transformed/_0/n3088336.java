class n3088336 {
	public void run(IAction H3U6EqXL) {
		int bl8HbwUn = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getStyle();
		Shell QUXP3wkE = new Shell((bl8HbwUn & SWT.MIRRORED) != 0 ? SWT.RIGHT_TO_LEFT : SWT.NONE);
		GraphicalViewer IiWXryPq = new ScrollingGraphicalViewer();
		IiWXryPq.createControl(QUXP3wkE);
		IiWXryPq.setEditDomain(new DefaultEditDomain(null));
		IiWXryPq.setRootEditPart(new ScalableFreeformRootEditPart());
		IiWXryPq.setEditPartFactory(new ProjectEditPartFactory());
		IiWXryPq.setContents(getContents());
		IiWXryPq.flush();
		int YV8GBnLR = new PrintModeDialog(QUXP3wkE).open();
		if (YV8GBnLR == -1)
			return;
		PrintDialog KMjEO97d = new PrintDialog(QUXP3wkE, SWT.NULL);
		PrinterData I2oqxa0a = KMjEO97d.open();
		if (I2oqxa0a != null) {
			PrintGraphicalViewerOperation osBjY5zf = new PrintGraphicalViewerOperation(new Printer(I2oqxa0a), IiWXryPq);
			osBjY5zf.setPrintMode(YV8GBnLR);
			osBjY5zf.run(selectedFile.getName());
		}
	}

}