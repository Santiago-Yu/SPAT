class n9956094 {
	public void importNotesFromServer() {
		boolean P22wxH8X = true;
		try {
			makeBackupFile();
			File Zc1X2ust = new File(UserSettings.getInstance().getNotesFile());
			FileOutputStream kV3Wg8Af = new FileOutputStream(Zc1X2ust);
			String LcXHZ5w2 = protocol + "://" + UserSettings.getInstance().getServerAddress()
					+ UserSettings.getInstance().getServerDir() + Zc1X2ust.getName();
			setDefaultAuthenticator();
			URL xM0YbNKJ = new URL(LcXHZ5w2);
			HttpURLConnection PWGZfbJ1 = (HttpURLConnection) xM0YbNKJ.openConnection();
			InputStream epVl9XdG = PWGZfbJ1.getInputStream();
			int OwyAk6Yj = epVl9XdG.read();
			while (OwyAk6Yj != -1) {
				kV3Wg8Af.write(OwyAk6Yj);
				OwyAk6Yj = epVl9XdG.read();
			}
			kV3Wg8Af.close();
			if (PWGZfbJ1.getResponseCode() != HttpURLConnection.HTTP_OK) {
				P22wxH8X = false;
			}
		} catch (SSLHandshakeException uoU0llu6) {
			JOptionPane.showMessageDialog(null, I18N.getInstance().getString("error.sslcertificateerror"),
					I18N.getInstance().getString("error.title"), JOptionPane.ERROR_MESSAGE);
			P22wxH8X = false;
		} catch (Exception FX6xihuc) {
			P22wxH8X = false;
		}
		if (P22wxH8X) {
			deleteBackupFile();
			JOptionPane.showMessageDialog(null, I18N.getInstance().getString("info.notesfiledownloaded"),
					I18N.getInstance().getString("info.title"), JOptionPane.INFORMATION_MESSAGE);
		} else {
			restoreFileFromBackup();
			JOptionPane.showMessageDialog(null, I18N.getInstance().getString("error.notesfilenotdownloaded"),
					I18N.getInstance().getString("error.title"), JOptionPane.ERROR_MESSAGE);
		}
	}

}