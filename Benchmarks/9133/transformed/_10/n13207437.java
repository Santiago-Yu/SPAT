class n13207437 {
	public Object sendRequestObjectResponse(java.lang.String servletName, java.lang.String request) {
		String osRoot = OSRoot.getRoot();
		Object retobj = null;
		String fname = "";
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
			java.io.File f1 = new java.io.File(osRoot + "/localattachments/Reports");
			java.io.File file = null;
			if (!f1.exists())
				f1.mkdirs();
			if (urlconn.getContentType() != null
					&& urlconn.getContentType().trim().equals("application/vnd.oasis.opendocument.text")) {
				file = new java.io.File(osRoot + "/localattachments/Reports/" + System.currentTimeMillis() + ".odt");
			} else if (urlconn.getContentType() != null && urlconn.getContentType().trim().equals("text/html")) {
				file = new java.io.File(osRoot + "/localattachments/Reports/" + System.currentTimeMillis() + ".html");
			} else {
				file = new java.io.File(osRoot + "/localattachments/Reports/" + System.currentTimeMillis() + ".xls");
			}
			file = new java.io.File(file.getAbsolutePath());
			int c;
			java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
			while ((c = ios.read()) != -1)
				fos.write(c);
			fos.close();
			ios.close();
			fname = file.getAbsolutePath();
			System.out.println(fname);
			newgen.presentation.component.Utility.getInstance().showBrowser("file://" + fname);
		} catch (Exception exp) {
			exp.printStackTrace(System.out);
			javax.swing.JOptionPane.showMessageDialog(null,
					"<html>Could not establish connection with the server, <br>Please verify server name/IP adress, <br>Also check if NewGenLib server is running</html>",
					"Critical error", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		return fname;
	}

}