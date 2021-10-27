class n13207436 {
	public Object sendObjectRequestToSpecifiedServer(java.lang.String serverName, java.lang.String servletName,
			java.lang.Object request) {
		Object reqxml = null;
		org.jdom.Document retdoc = null;
		String myurl = java.util.prefs.Preferences.systemRoot().get("serverurl", ""),
				myport = java.util.prefs.Preferences.systemRoot().get("portno", "8080");
		if (myport == null || myport.trim().equals("")) {
			myport = "80";
		}
		if (this.serverURL == null) {
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
			newgen.presentation.component.IPAddressPortNoDialog ipdig = new newgen.presentation.component.IPAddressPortNoDialog(
					myurl, myport);
			ipdig.show();
			serverURL = myurl = ipdig.getIPAddress();
			myport = ipdig.getPortNo();
			java.util.prefs.Preferences.systemRoot().put("serverurl", serverURL);
			java.util.prefs.Preferences.systemRoot().put("portno", myport);
			System.out.println(serverURL);
		}
		try {
			java.net.URL url = new java.net.URL(
					"http://" + serverName + ":" + myport + "/newgenlibctxt/" + servletName);
			java.net.URLConnection urlconn = (java.net.URLConnection) url.openConnection();
			urlconn.setDoOutput(true);
			java.io.OutputStream os = urlconn.getOutputStream();
			java.util.zip.CheckedOutputStream cos = new java.util.zip.CheckedOutputStream(os,
					new java.util.zip.Adler32());
			java.util.zip.GZIPOutputStream gop = new java.util.zip.GZIPOutputStream(cos);
			java.io.ObjectOutputStream dos = new java.io.ObjectOutputStream(gop);
			dos.writeObject(request);
			dos.flush();
			dos.close();
			java.io.InputStream ios = urlconn.getInputStream();
			java.util.zip.CheckedInputStream cis = new java.util.zip.CheckedInputStream(ios,
					new java.util.zip.Adler32());
			java.util.zip.GZIPInputStream gip = new java.util.zip.GZIPInputStream(cis);
			java.io.ObjectInputStream br = new java.io.ObjectInputStream(gip);
			reqxml = br.readObject();
		} catch (Exception exp) {
			exp.printStackTrace(System.out);
			System.out.println("Exception in Servlet Connector: " + exp);
		}
		return reqxml;
	}

}