class n9956095 {
	public void exportNotesToServer() {
		boolean Fejb0AzI = true;
		try {
			File qDALv4Ln = new File(UserSettings.getInstance().getNotesFile());
			FileInputStream YYPWDCCM = new FileInputStream(qDALv4Ln);
			String a75YZnF8 = protocol + "://" + UserSettings.getInstance().getServerAddress()
					+ UserSettings.getInstance().getServerDir() + qDALv4Ln.getName();
			setDefaultAuthenticator();
			URL BXmsW71d = new URL(a75YZnF8);
			HttpURLConnection qgbQUyZE = (HttpURLConnection) BXmsW71d.openConnection();
			qgbQUyZE.setDoOutput(true);
			qgbQUyZE.setRequestMethod("PUT");
			OutputStream n0BAFrL3 = qgbQUyZE.getOutputStream();
			int nK7CAiol = YYPWDCCM.read();
			while (nK7CAiol != -1) {
				n0BAFrL3.write(nK7CAiol);
				nK7CAiol = YYPWDCCM.read();
			}
			YYPWDCCM.close();
			n0BAFrL3.close();
			if (qgbQUyZE.getResponseCode() != HttpURLConnection.HTTP_CREATED
					&& qgbQUyZE.getResponseCode() != HttpURLConnection.HTTP_NO_CONTENT) {
				Fejb0AzI = false;
			}
		} catch (SSLHandshakeException LJniV0l5) {
			JOptionPane.showMessageDialog(null, I18N.getInstance().getString("error.sslcertificateerror"),
					I18N.getInstance().getString("error.title"), JOptionPane.ERROR_MESSAGE);
			Fejb0AzI = false;
		} catch (Exception XnbrHjBS) {
			Fejb0AzI = false;
		}
		if (Fejb0AzI) {
			JOptionPane.showMessageDialog(null, I18N.getInstance().getString("info.notesfileuploaded"),
					I18N.getInstance().getString("info.title"), JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, I18N.getInstance().getString("error.notesfilenotuploaded"),
					I18N.getInstance().getString("error.title"), JOptionPane.ERROR_MESSAGE);
		}
	}

}