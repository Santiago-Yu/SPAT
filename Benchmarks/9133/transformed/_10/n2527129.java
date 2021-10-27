class n2527129 {
	private void loadExample(String resourceFile) {
		try {
			if (this.isDirty()) {
				if (this.support.saveAs() == JOptionPane.CANCEL_OPTION) {
					return;
				}
			}
			URL url = EditorContextMenu.class.getResource(resourceFile);
			this.support.loadInputStream(url.openStream());
		} catch (IOException ex) {
			Logger.getLogger(EditorContextMenu.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}