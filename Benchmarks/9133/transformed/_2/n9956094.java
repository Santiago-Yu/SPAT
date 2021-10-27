class n9956094 {
	public void importNotesFromServer() {
		boolean downloaded = true;
		try {
			makeBackupFile();
			File f = new File(UserSettings.getInstance().getNotesFile());
			FileOutputStream fos = new FileOutputStream(f);
			String urlString = protocol + "://" + UserSettings.getInstance().getServerAddress()
					+ UserSettings.getInstance().getServerDir() + f.getName();
			setDefaultAuthenticator();
			URL url = new URL(urlString);
			HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
			InputStream is = urlc.getInputStream();
			int nextByte = is.read();
			for (; nextByte != -1;) {
				fos.write(nextByte);
				nextByte = is.read();
			}
			fos.close();
			if (urlc.getResponseCode() != HttpURLConnection.HTTP_OK) {
				downloaded = false;
			}
		} catch (SSLHandshakeException e) {
			JOptionPane.showMessageDialog(null, I18N.getInstance().getString("error.sslcertificateerror"),
					I18N.getInstance().getString("error.title"), JOptionPane.ERROR_MESSAGE);
			downloaded = false;
		} catch (Exception e) {
			downloaded = false;
		}
		if (downloaded) {
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