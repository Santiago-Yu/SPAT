class n3857069 {
	public void run(IAction p8I7cd7z) {
		int RfOr2b0R = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getStyle();
		Shell ojRCV1ky = new Shell((RfOr2b0R & SWT.MIRRORED) != 0 ? SWT.RIGHT_TO_LEFT : SWT.NONE);
		GraphicalViewer ZfRNDxNf = new ScrollingGraphicalViewer();
		ZfRNDxNf.createControl(ojRCV1ky);
		ZfRNDxNf.setEditDomain(new DefaultEditDomain(null));
		ZfRNDxNf.setRootEditPart(new ScalableFreeformRootEditPart());
		ZfRNDxNf.setEditPartFactory(new GraphicalPartFactory());
		ZfRNDxNf.setContents(getContents());
		ZfRNDxNf.flush();
		int YbUNbdfu = new PrintModeDialog(ojRCV1ky).open();
		if (YbUNbdfu == -1)
			return;
		PrintDialog T8oM2deV = new PrintDialog(ojRCV1ky, SWT.NULL);
		PrinterData X7o99MOu = T8oM2deV.open();
		if (X7o99MOu != null) {
			PrintGraphicalViewerOperation RlOzpFXp = new PrintGraphicalViewerOperation(new Printer(X7o99MOu), ZfRNDxNf);
			RlOzpFXp.setPrintMode(YbUNbdfu);
			RlOzpFXp.run(selectedFile.getName());
		}
	}

}