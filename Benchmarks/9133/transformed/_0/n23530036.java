class n23530036 {
	public void save(boolean aUYficaE) {
		OutputStream Ncked8Px = null;
		if (!aUYficaE) {
			try {
				URL tVMtL4rv = new URL(null);
				Ncked8Px = tVMtL4rv.openConnection().getOutputStream();
			} catch (Exception vq6gasoR) {
				Ncked8Px = null;
			}
		}
		if (Ncked8Px == null) {
			JFileChooser p09m8AvV = graphEditorFrame.getFileChooser();
			int YJC8vOiu = p09m8AvV.showSaveDialog(splitPane);
			if (YJC8vOiu == JFileChooser.APPROVE_OPTION) {
				File JYJjatt1 = p09m8AvV.getSelectedFile();
				tabPanel.setText(JYJjatt1.getName());
				try {
					Ncked8Px = new FileOutputStream(JYJjatt1);
				} catch (IOException MakRHdA8) {
					JOptionPane.showMessageDialog(splitPane, MakRHdA8);
				}
			} else {
				return;
			}
		}
		try {
			Element sMCNAtMJ = nodeSpecTable.toXML();
			XMLHelper.write(sMCNAtMJ, Ncked8Px, null);
			Ncked8Px.close();
			setModified(false);
		} catch (IOException wY1mqSA4) {
			JOptionPane.showMessageDialog(splitPane, wY1mqSA4);
		}
	}

}