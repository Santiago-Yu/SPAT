class n13207437 {
	public Object sendRequestObjectResponse(java.lang.String YlMqTd15, java.lang.String TpP17KQc) {
		String EbLWS2EM = OSRoot.getRoot();
		String xuXTSuuu = "";
		Object Bsj8SmRm = null;
		String fe47evAa = java.util.prefs.Preferences.systemRoot().get("serverurl", "");
		String yEiLhdOE = java.util.prefs.Preferences.systemRoot().get("portno", "8080");
		if (yEiLhdOE == null || yEiLhdOE.trim().equals("")) {
			yEiLhdOE = "80";
		}
		if (this.serverURL == null) {
			try {
				java.net.URL SbXgDfKN = newgen.presentation.NewGenMain.getAppletInstance().getCodeBase();
				if (SbXgDfKN != null)
					serverURL = SbXgDfKN.getHost();
				else
					serverURL = "localhost";
			} catch (Exception WWyTxbyf) {
				WWyTxbyf.printStackTrace();
				serverURL = "localhost";
			}
			newgen.presentation.component.IPAddressPortNoDialog EkI5S4Px = new newgen.presentation.component.IPAddressPortNoDialog(
					fe47evAa, yEiLhdOE);
			EkI5S4Px.show();
			serverURL = fe47evAa = EkI5S4Px.getIPAddress();
			yEiLhdOE = EkI5S4Px.getPortNo();
			java.util.prefs.Preferences.systemRoot().put("serverurl", serverURL);
			java.util.prefs.Preferences.systemRoot().put("portno", yEiLhdOE);
			System.out.println(serverURL);
		}
		try {
			System.out.println("http://" + serverURL + ":" + yEiLhdOE + "/newgenlibctxt/" + YlMqTd15);
			java.net.URL YlxgoUrU = new java.net.URL(
					"http://" + serverURL + ":" + yEiLhdOE + "/newgenlibctxt/" + YlMqTd15);
			java.net.URLConnection sm8iaTGH = (java.net.URLConnection) YlxgoUrU.openConnection();
			sm8iaTGH.setDoOutput(true);
			sm8iaTGH.setRequestProperty("Content-type", "text/xml; charset=UTF-8");
			java.io.OutputStream rz3rQgNm = sm8iaTGH.getOutputStream();
			String tBjVdHwZ = TpP17KQc;
			java.util.zip.CheckedOutputStream m98WLN5a = new java.util.zip.CheckedOutputStream(rz3rQgNm,
					new java.util.zip.Adler32());
			java.util.zip.GZIPOutputStream tEZoVyqo = new java.util.zip.GZIPOutputStream(m98WLN5a);
			java.io.OutputStreamWriter XsxNiq8S = new java.io.OutputStreamWriter(tEZoVyqo, "UTF-8");
			System.out.println(tBjVdHwZ);
			try {
				java.io.FileOutputStream K3kemrnx = new java.io.FileOutputStream("log.txt");
				K3kemrnx.write(tBjVdHwZ.getBytes());
				K3kemrnx.flush();
				K3kemrnx.close();
			} catch (Exception peERtpip) {
				peERtpip.printStackTrace();
			}
			XsxNiq8S.write(tBjVdHwZ);
			XsxNiq8S.flush();
			XsxNiq8S.close();
			System.out.println("url conn: " + sm8iaTGH.getContentEncoding() + "  " + sm8iaTGH.getContentType());
			java.io.InputStream nLd8XMit = sm8iaTGH.getInputStream();
			java.io.File FPU339Vp = new java.io.File(EbLWS2EM + "/localattachments/Reports");
			if (!FPU339Vp.exists())
				FPU339Vp.mkdirs();
			java.io.File AlIjUSQu = null;
			if (sm8iaTGH.getContentType() != null
					&& sm8iaTGH.getContentType().trim().equals("application/vnd.oasis.opendocument.text")) {
				AlIjUSQu = new java.io.File(
						EbLWS2EM + "/localattachments/Reports/" + System.currentTimeMillis() + ".odt");
			} else if (sm8iaTGH.getContentType() != null && sm8iaTGH.getContentType().trim().equals("text/html")) {
				AlIjUSQu = new java.io.File(
						EbLWS2EM + "/localattachments/Reports/" + System.currentTimeMillis() + ".html");
			} else {
				AlIjUSQu = new java.io.File(
						EbLWS2EM + "/localattachments/Reports/" + System.currentTimeMillis() + ".xls");
			}
			AlIjUSQu = new java.io.File(AlIjUSQu.getAbsolutePath());
			java.io.FileOutputStream FC1JDhYm = new java.io.FileOutputStream(AlIjUSQu);
			int IGWO9BY5;
			while ((IGWO9BY5 = nLd8XMit.read()) != -1)
				FC1JDhYm.write(IGWO9BY5);
			FC1JDhYm.close();
			nLd8XMit.close();
			xuXTSuuu = AlIjUSQu.getAbsolutePath();
			System.out.println(xuXTSuuu);
			newgen.presentation.component.Utility.getInstance().showBrowser("file://" + xuXTSuuu);
		} catch (Exception uHyaFzTg) {
			uHyaFzTg.printStackTrace(System.out);
			javax.swing.JOptionPane.showMessageDialog(null,
					"<html>Could not establish connection with the server, <br>Please verify server name/IP adress, <br>Also check if NewGenLib server is running</html>",
					"Critical error", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		return xuXTSuuu;
	}

}