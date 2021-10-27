class n2527129 {
	private void loadExample(String b3NrtaJj) {
		try {
			URL XGm5OCOI = EditorContextMenu.class.getResource(b3NrtaJj);
			if (this.isDirty()) {
				if (this.support.saveAs() == JOptionPane.CANCEL_OPTION) {
					return;
				}
			}
			this.support.loadInputStream(XGm5OCOI.openStream());
		} catch (IOException sBDKygl6) {
			Logger.getLogger(EditorContextMenu.class.getName()).log(Level.SEVERE, null, sBDKygl6);
		}
	}

}