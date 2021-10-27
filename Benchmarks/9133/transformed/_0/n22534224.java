class n22534224 {
	public void openUrlActionPerformed(ActionEvent QtsqwqaX) {
		RemoteFileChooser j1rhvTI5 = new RemoteFileChooser(this, getAppName());
		j1rhvTI5.getDialog().setVisible(true);
		if (j1rhvTI5.getResult() == JOptionPane.OK_OPTION) {
			setCursorBusy(true);
			URL UqqaNzng = j1rhvTI5.getSelectedUrl();
			String daco0JtF = j1rhvTI5.getSelectedFilename();
			try {
				BufferedReader rt8Dxn9L = new BufferedReader(new InputStreamReader(UqqaNzng.openStream()));
				openFile(daco0JtF, rt8Dxn9L);
			} catch (IOException HB2zISlQ) {
				handleException(HB2zISlQ);
			}
			setCursorBusy(false);
		}
		checkActions();
	}

}