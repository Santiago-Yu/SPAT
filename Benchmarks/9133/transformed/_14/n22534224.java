class n22534224 {
	public void openUrlActionPerformed(ActionEvent event) {
		RemoteFileChooser fileChooser = new RemoteFileChooser(this, getAppName());
		fileChooser.getDialog().setVisible(true);
		if (JOptionPane.OK_OPTION == fileChooser.getResult()) {
			setCursorBusy(true);
			URL url = fileChooser.getSelectedUrl();
			String filename = fileChooser.getSelectedFilename();
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				openFile(filename, reader);
			} catch (IOException e) {
				handleException(e);
			}
			setCursorBusy(false);
		}
		checkActions();
	}

}