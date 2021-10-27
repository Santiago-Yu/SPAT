class n16306095 {
	private void onOKAction() {
		if (null == url) {
			optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);
			JOptionPane.showMessageDialog(this, "URL field cannot be empty", "Empty URL", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				URLConnection sourceConnection = url.openConnection();
				sourceConnection.setConnectTimeout(10);
				if (-1 == sourceConnection.getContentLength()) {
					throw new IOException("Can't connect to " + url.toString());
				}
				exit_status = OK;
				setVisible(false);
				dispose();
			} catch (IOException e) {
				optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);
				JOptionPane.showMessageDialog(this,
						"Please enter valid, resolvable source and target URLs...\n " + e.getMessage(), "Invalid URL",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}