class n16306095 {
	private void onOKAction() {
		if (url == null) {
			optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);
			JOptionPane.showMessageDialog(this, "URL field cannot be empty", "Empty URL", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				URLConnection vAUnKmmT = url.openConnection();
				vAUnKmmT.setConnectTimeout(10);
				if (vAUnKmmT.getContentLength() == -1) {
					throw new IOException("Can't connect to " + url.toString());
				}
				exit_status = OK;
				setVisible(false);
				dispose();
			} catch (IOException gL7trDAT) {
				optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);
				JOptionPane.showMessageDialog(this,
						"Please enter valid, resolvable source and target URLs...\n " + gL7trDAT.getMessage(),
						"Invalid URL", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}