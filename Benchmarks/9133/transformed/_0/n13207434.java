class n13207434 {
	public String sendRequest(java.lang.String DmZus2oh, java.lang.String avvKqlpz) {
		String nuvW4EfZ = "";
		org.jdom.Document l6pxGsRw = null;
		String tTON8ulK = java.util.prefs.Preferences.systemRoot().get("serverurl", "");
		String PFTx0yCV = "";
		PFTx0yCV = java.util.prefs.Preferences.systemRoot().get("portno", "8080");
		if (PFTx0yCV == null || PFTx0yCV.trim().equals("")) {
			PFTx0yCV = "80";
		}
		if (this.serverURL == null) {
			try {
				java.net.URL i9KyLboA = newgen.presentation.NewGenMain.getAppletInstance().getCodeBase();
				if (i9KyLboA != null)
					serverURL = i9KyLboA.getHost();
				else
					serverURL = "localhost";
			} catch (Exception neGek7BV) {
				neGek7BV.printStackTrace();
				serverURL = "localhost";
			}
			newgen.presentation.component.IPAddressPortNoDialog kVB5qszG = new newgen.presentation.component.IPAddressPortNoDialog(
					tTON8ulK, PFTx0yCV);
			kVB5qszG.show();
			serverURL = tTON8ulK = kVB5qszG.getIPAddress();
			PFTx0yCV = kVB5qszG.getPortNo();
			java.util.prefs.Preferences.systemRoot().put("serverurl", serverURL);
			java.util.prefs.Preferences.systemRoot().put("portno", PFTx0yCV);
			System.out.println(serverURL);
		}
		try {
			System.out.println("http://" + serverURL + ":" + PFTx0yCV + "/newgenlibctxt/" + DmZus2oh);
			java.net.URL NDWWZuvw = new java.net.URL(
					"http://" + serverURL + ":" + PFTx0yCV + "/newgenlibctxt/" + DmZus2oh);
			java.net.URLConnection bTZQXhUk = (java.net.URLConnection) NDWWZuvw.openConnection();
			bTZQXhUk.setDoOutput(true);
			bTZQXhUk.setRequestProperty("Content-type", "text/xml; charset=UTF-8");
			java.io.OutputStream jpuusBaL = bTZQXhUk.getOutputStream();
			String CKpbOk9Z = avvKqlpz;
			java.util.zip.CheckedOutputStream rG9lzPoQ = new java.util.zip.CheckedOutputStream(jpuusBaL,
					new java.util.zip.Adler32());
			java.util.zip.GZIPOutputStream vscvzW50 = new java.util.zip.GZIPOutputStream(rG9lzPoQ);
			java.io.OutputStreamWriter HmFoBpe1 = new java.io.OutputStreamWriter(vscvzW50, "UTF-8");
			System.out.println("#########***********$$$$$$$$##########" + CKpbOk9Z);
			HmFoBpe1.write(CKpbOk9Z);
			HmFoBpe1.flush();
			HmFoBpe1.close();
			System.out.println("url conn: " + bTZQXhUk.getContentEncoding() + "  " + bTZQXhUk.getContentType());
			java.io.InputStream RxzlGsKo = bTZQXhUk.getInputStream();
			java.util.zip.CheckedInputStream qMFUlIO4 = new java.util.zip.CheckedInputStream(RxzlGsKo,
					new java.util.zip.Adler32());
			java.util.zip.GZIPInputStream kWgnjFU2 = new java.util.zip.GZIPInputStream(qMFUlIO4);
			java.io.InputStreamReader VZTgxfVF = new java.io.InputStreamReader(kWgnjFU2, "UTF-8");
			l6pxGsRw = (new org.jdom.input.SAXBuilder()).build(VZTgxfVF);
		} catch (java.net.ConnectException ag9y0xmu) {
			javax.swing.JOptionPane
					.showMessageDialog(null,
							newgen.presentation.NewGenMain.getAppletInstance().getMyResource()
									.getString("ConnectExceptionMessage"),
							"Critical error", javax.swing.JOptionPane.ERROR_MESSAGE);
		} catch (Exception WblCFG1H) {
			WblCFG1H.printStackTrace(System.out);
			TroubleShootConnectivity if64VTFK = new TroubleShootConnectivity();
		}
		System.out.println(nuvW4EfZ);
		return (new org.jdom.output.XMLOutputter()).outputString(l6pxGsRw);
	}

}