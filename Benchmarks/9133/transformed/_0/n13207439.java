class n13207439 {
	public String sendRequestAndGetNormalStringOutPut(java.lang.String JbU1V43s, java.lang.String W679vDQn) {
		String dhNavJ45 = java.util.prefs.Preferences.systemRoot().get("serverurl", "");
		String Ktxrpal0 = java.util.prefs.Preferences.systemRoot().get("portno", "8080");
		if (Ktxrpal0 == null || Ktxrpal0.trim().equals("")) {
			Ktxrpal0 = "80";
		}
		if (this.serverURL == null) {
			try {
				java.net.URL lpPjyb8t = newgen.presentation.NewGenMain.getAppletInstance().getCodeBase();
				if (lpPjyb8t != null)
					serverURL = lpPjyb8t.getHost();
				else
					serverURL = "localhost";
			} catch (Exception iiEd7m3F) {
				iiEd7m3F.printStackTrace();
				serverURL = "localhost";
			}
			newgen.presentation.component.IPAddressPortNoDialog ZIBsFlef = new newgen.presentation.component.IPAddressPortNoDialog(
					dhNavJ45, Ktxrpal0);
			ZIBsFlef.show();
			serverURL = dhNavJ45 = ZIBsFlef.getIPAddress();
			Ktxrpal0 = ZIBsFlef.getPortNo();
			java.util.prefs.Preferences.systemRoot().put("serverurl", serverURL);
			java.util.prefs.Preferences.systemRoot().put("portno", Ktxrpal0);
			System.out.println(serverURL);
		}
		String QrNLLo0M = "";
		try {
			System.out.println("http://" + serverURL + ":" + Ktxrpal0 + "/newgenlibctxt/" + JbU1V43s);
			java.net.URL RYBJ0UU3 = new java.net.URL(
					"http://" + serverURL + ":" + Ktxrpal0 + "/newgenlibctxt/" + JbU1V43s);
			java.net.URLConnection v7oSvyiB = (java.net.URLConnection) RYBJ0UU3.openConnection();
			v7oSvyiB.setDoOutput(true);
			v7oSvyiB.setRequestProperty("Content-type", "text/xml; charset=UTF-8");
			java.io.OutputStream JhUBtHyo = v7oSvyiB.getOutputStream();
			String jg774Vfe = W679vDQn;
			java.util.zip.CheckedOutputStream szfjERcA = new java.util.zip.CheckedOutputStream(JhUBtHyo,
					new java.util.zip.Adler32());
			java.util.zip.GZIPOutputStream zanxInyM = new java.util.zip.GZIPOutputStream(szfjERcA);
			java.io.OutputStreamWriter Jd5VtCkc = new java.io.OutputStreamWriter(zanxInyM, "UTF-8");
			System.out.println(jg774Vfe);
			Jd5VtCkc.write(jg774Vfe);
			Jd5VtCkc.flush();
			Jd5VtCkc.close();
			System.out.println("url conn: " + v7oSvyiB.getContentEncoding() + "  " + v7oSvyiB.getContentType());
			java.io.InputStream rIHQ2vaT = v7oSvyiB.getInputStream();
			java.util.zip.CheckedInputStream ztCjKOrA = new java.util.zip.CheckedInputStream(rIHQ2vaT,
					new java.util.zip.Adler32());
			java.util.zip.GZIPInputStream fjdWbgGl = new java.util.zip.GZIPInputStream(ztCjKOrA);
			java.io.InputStreamReader Wki8eVf1 = new java.io.InputStreamReader(fjdWbgGl, "UTF-8");
			int Kou7lbNX = -1;
			while ((Kou7lbNX = Wki8eVf1.read()) != -1)
				QrNLLo0M += (char) Kou7lbNX;
		} catch (java.net.ConnectException xxpb9nZJ) {
			javax.swing.JOptionPane.showMessageDialog(null,
					"<html>Could not establish connection with the NewGenLib server, "
							+ "<br>These might be the possible reasons."
							+ "<br><li>Check the network connectivity between this machine and the server."
							+ "<br><li>Check whether NewGenLib server is running on the server machine."
							+ "<br><li>NewGenLib server might not have initialized properly. In this case"
							+ "<br>go to server machine, open NewGenLibDesktop Application,"
							+ "<br> utility ->Send log to NewGenLib Customer Support</html>",
					"Critical error", javax.swing.JOptionPane.ERROR_MESSAGE);
		} catch (Exception eXQ8g2Oa) {
			eXQ8g2Oa.printStackTrace(System.out);
			TroubleShootConnectivity pTFHElxI = new TroubleShootConnectivity();
		}
		return QrNLLo0M;
	}

}