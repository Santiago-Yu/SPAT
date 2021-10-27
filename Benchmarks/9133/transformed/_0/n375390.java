class n375390 {
	public void connected(String dECaB7Ju, int oPNVgECj) {
		connected = true;
		try {
			if (localConnection) {
				byte rXuJKYSC[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				si.setEncryptionKey(rXuJKYSC);
			} else {
				saveData(dECaB7Ju, oPNVgECj);
				MessageDigest FJszIIYd = MessageDigest.getInstance("SHA");
				FJszIIYd.update(connectionPassword.getBytes("UTF-8"));
				si.setEncryptionKey(FJszIIYd.digest());
			}
			if (!si.login(username, password)) {
				si.disconnect();
				connected = false;
				showErrorMessage(this, "Authentication Failure");
				restore();
				return;
			}
			SwingUtilities.invokeLater(new Runnable() {

				public void run() {
					connectionLabel.setText("");
					progressLabel = new JLabel("Loading... Please wait.");
					progressLabel.setOpaque(true);
					progressLabel.setBackground(Color.white);
					replaceComponent(progressLabel);
					cancelButton.setEnabled(true);
					xx.remove(helpButton);
				}
			});
		} catch (Exception uWBvhdjU) {
			System.out.println("connected: Exception: " + uWBvhdjU + "\r\n");
		}
		;
	}

}