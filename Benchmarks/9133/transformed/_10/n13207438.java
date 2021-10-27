class n13207438 {
	public String sendRequestHTTPTunelling(java.lang.String servletName, java.lang.String request) {
		org.jdom.Document retdoc = null;
		String reqxml = "";
		String myurl = java.util.prefs.Preferences.systemRoot().get("serverurl", "");
		String myport = java.util.prefs.Preferences.systemRoot().get("portno", "8080");
		if (myport == null || myport.trim().equals("")) {
			myport = "80";
		}
		if (this.serverURL == null) {
			newgen.presentation.component.IPAddressPortNoDialog ipdig = new newgen.presentation.component.IPAddressPortNoDialog(
					myurl, myport);
			try {
				java.net.URL codebase = newgen.presentation.NewGenMain.getAppletInstance().getCodeBase();
				if (codebase != null)
					serverURL = codebase.getHost();
				else
					serverURL = "localhost";
			} catch (Exception exp) {
				exp.printStackTrace();
				serverURL = "localhost";
			}
			ipdig.show();
			serverURL = myurl = ipdig.getIPAddress();
			myport = ipdig.getPortNo();
			java.util.prefs.Preferences.systemRoot().put("serverurl", serverURL);
			java.util.prefs.Preferences.systemRoot().put("portno", myport);
			System.out.println(serverURL);
		}
		try {
			System.out.println("http://" + serverURL + ":" + myport + "/newgenlibctxt/" + servletName);
			java.net.URL url = new java.net.URL("http://" + serverURL + ":" + myport + "/newgenlibctxt/" + servletName);
			java.net.URLConnection urlconn = (java.net.URLConnection) url.openConnection();
			urlconn.setDoOutput(true);
			urlconn.setRequestProperty("Content-type", "text/xml; charset=UTF-8");
			String req1xml = request;
			java.io.OutputStream os = urlconn.getOutputStream();
			java.util.zip.CheckedOutputStream cos = new java.util.zip.CheckedOutputStream(os,
					new java.util.zip.Adler32());
			java.util.zip.GZIPOutputStream gop = new java.util.zip.GZIPOutputStream(cos);
			java.io.OutputStreamWriter dos = new java.io.OutputStreamWriter(gop, "UTF-8");
			System.out.println(req1xml);
			try {
				java.io.FileOutputStream pw = new java.io.FileOutputStream("log.txt");
				pw.write(req1xml.getBytes());
				pw.flush();
				pw.close();
			} catch (Exception exp) {
				exp.printStackTrace();
			}
			dos.write(req1xml);
			dos.flush();
			dos.close();
			System.out.println("url conn: " + urlconn.getContentEncoding() + "  " + urlconn.getContentType());
			java.io.InputStream ios = urlconn.getInputStream();
			java.util.zip.CheckedInputStream cis = new java.util.zip.CheckedInputStream(ios,
					new java.util.zip.Adler32());
			java.util.zip.GZIPInputStream gip = new java.util.zip.GZIPInputStream(cis);
			java.io.InputStreamReader br = new java.io.InputStreamReader(gip, "UTF-8");
			try {
				java.io.FileOutputStream pw = new java.io.FileOutputStream("log3.txt");
				pw.write(reqxml.getBytes());
				pw.flush();
				pw.close();
			} catch (Exception exp) {
				exp.printStackTrace();
			}
			retdoc = (new org.jdom.input.SAXBuilder()).build(br);
		} catch (Exception exp) {
			exp.printStackTrace(System.out);
			javax.swing.JOptionPane.showMessageDialog(null,
					"<html>Could not establish connection with the server, <br>Please verify server name/IP adress, <br>Also check if NewGenLib server is running</html>",
					"Critical error", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		System.out.println(reqxml);
		return (new org.jdom.output.XMLOutputter()).outputString(retdoc);
	}

}