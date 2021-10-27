class n22401746 {
	public String sendRequest(java.lang.String nrjdfJHO, java.lang.String H82iiof6) {
		String PZyRg56R = "";
		org.jdom.Document YCWaeJCR = null;
		String KrvTx7if = java.util.prefs.Preferences.systemRoot().get("serverurl", "");
		String I2adzUr9 = java.util.prefs.Preferences.systemRoot().get("portno", "8080");
		if (this.serverURL == null) {
			try {
				java.net.URL OdrfvTIq = newgen.presentation.NewGenMain.getAppletInstance().getCodeBase();
				if (OdrfvTIq != null)
					serverURL = OdrfvTIq.getHost();
				else
					serverURL = "localhost";
			} catch (Exception egC5oNWZ) {
				egC5oNWZ.printStackTrace();
				serverURL = "localhost";
			}
			newgen.presentation.component.IPAddressPortNoDialog uftDTt1u = new newgen.presentation.component.IPAddressPortNoDialog(
					KrvTx7if, I2adzUr9);
			uftDTt1u.show();
			serverURL = KrvTx7if = uftDTt1u.getIPAddress();
			I2adzUr9 = uftDTt1u.getPortNo();
			java.util.prefs.Preferences.systemRoot().put("serverurl", serverURL);
			java.util.prefs.Preferences.systemRoot().put("portno", I2adzUr9);
			System.out.println(serverURL);
		}
		try {
			System.out.println("http://" + serverURL + ":" + I2adzUr9 + "/newgenlibctxt/" + nrjdfJHO);
			java.net.URL COoBMhMP = new java.net.URL(
					"http://" + serverURL + ":" + I2adzUr9 + "/newgenlibctxt/" + nrjdfJHO);
			java.net.URLConnection H1lEeUPu = (java.net.URLConnection) COoBMhMP.openConnection();
			H1lEeUPu.setDoOutput(true);
			H1lEeUPu.setRequestProperty("Content-type", "text/xml; charset=UTF-8");
			java.io.OutputStream BPjgSR9Z = H1lEeUPu.getOutputStream();
			String PL6XnkAt = H82iiof6;
			java.util.zip.CheckedOutputStream VbTPQbLY = new java.util.zip.CheckedOutputStream(BPjgSR9Z,
					new java.util.zip.Adler32());
			java.util.zip.GZIPOutputStream nQYYhDkC = new java.util.zip.GZIPOutputStream(VbTPQbLY);
			java.io.OutputStreamWriter txcldKYt = new java.io.OutputStreamWriter(nQYYhDkC, "UTF-8");
			System.out.println(PL6XnkAt);
			txcldKYt.write(PL6XnkAt);
			txcldKYt.flush();
			txcldKYt.close();
			System.out.println("url conn: " + H1lEeUPu.getContentEncoding() + "  " + H1lEeUPu.getContentType());
			java.io.InputStream NRRPmuy2 = H1lEeUPu.getInputStream();
			java.util.zip.CheckedInputStream F1hy5qsQ = new java.util.zip.CheckedInputStream(NRRPmuy2,
					new java.util.zip.Adler32());
			java.util.zip.GZIPInputStream w7CzTAXh = new java.util.zip.GZIPInputStream(F1hy5qsQ);
			java.io.InputStreamReader OMfSH39x = new java.io.InputStreamReader(w7CzTAXh, "UTF-8");
			YCWaeJCR = (new org.jdom.input.SAXBuilder()).build(OMfSH39x);
		} catch (java.net.ConnectException xC1jd941) {
			javax.swing.JOptionPane
					.showMessageDialog(null,
							newgen.presentation.NewGenMain.getAppletInstance().getMyResource()
									.getString("ConnectExceptionMessage"),
							"Critical error", javax.swing.JOptionPane.ERROR_MESSAGE);
		} catch (Exception Wb45Md26) {
			Wb45Md26.printStackTrace(System.out);
		}
		System.out.println(PZyRg56R);
		return "";
	}

}