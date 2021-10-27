class n13207438 {
	public String sendRequestHTTPTunelling(java.lang.String sQTFhapU, java.lang.String FU6aXy2k) {
		String Otcedmos = "";
		org.jdom.Document Zw2fdrOX = null;
		String gBdC3Qei = java.util.prefs.Preferences.systemRoot().get("serverurl", "");
		String KdG71syx = java.util.prefs.Preferences.systemRoot().get("portno", "8080");
		if (KdG71syx == null || KdG71syx.trim().equals("")) {
			KdG71syx = "80";
		}
		if (this.serverURL == null) {
			try {
				java.net.URL avw9t4pv = newgen.presentation.NewGenMain.getAppletInstance().getCodeBase();
				if (avw9t4pv != null)
					serverURL = avw9t4pv.getHost();
				else
					serverURL = "localhost";
			} catch (Exception Q1I9l5b2) {
				Q1I9l5b2.printStackTrace();
				serverURL = "localhost";
			}
			newgen.presentation.component.IPAddressPortNoDialog jQDjsvUx = new newgen.presentation.component.IPAddressPortNoDialog(
					gBdC3Qei, KdG71syx);
			jQDjsvUx.show();
			serverURL = gBdC3Qei = jQDjsvUx.getIPAddress();
			KdG71syx = jQDjsvUx.getPortNo();
			java.util.prefs.Preferences.systemRoot().put("serverurl", serverURL);
			java.util.prefs.Preferences.systemRoot().put("portno", KdG71syx);
			System.out.println(serverURL);
		}
		try {
			System.out.println("http://" + serverURL + ":" + KdG71syx + "/newgenlibctxt/" + sQTFhapU);
			java.net.URL wgNYqri3 = new java.net.URL(
					"http://" + serverURL + ":" + KdG71syx + "/newgenlibctxt/" + sQTFhapU);
			java.net.URLConnection WuDO9o3y = (java.net.URLConnection) wgNYqri3.openConnection();
			WuDO9o3y.setDoOutput(true);
			WuDO9o3y.setRequestProperty("Content-type", "text/xml; charset=UTF-8");
			java.io.OutputStream qpdfgtLS = WuDO9o3y.getOutputStream();
			String kUwA5jY1 = FU6aXy2k;
			java.util.zip.CheckedOutputStream InRMVotI = new java.util.zip.CheckedOutputStream(qpdfgtLS,
					new java.util.zip.Adler32());
			java.util.zip.GZIPOutputStream Z1JZg0cX = new java.util.zip.GZIPOutputStream(InRMVotI);
			java.io.OutputStreamWriter W6Og5jTo = new java.io.OutputStreamWriter(Z1JZg0cX, "UTF-8");
			System.out.println(kUwA5jY1);
			try {
				java.io.FileOutputStream ne9Gl8zt = new java.io.FileOutputStream("log.txt");
				ne9Gl8zt.write(kUwA5jY1.getBytes());
				ne9Gl8zt.flush();
				ne9Gl8zt.close();
			} catch (Exception eoItWcj8) {
				eoItWcj8.printStackTrace();
			}
			W6Og5jTo.write(kUwA5jY1);
			W6Og5jTo.flush();
			W6Og5jTo.close();
			System.out.println("url conn: " + WuDO9o3y.getContentEncoding() + "  " + WuDO9o3y.getContentType());
			java.io.InputStream UYYW2z45 = WuDO9o3y.getInputStream();
			java.util.zip.CheckedInputStream NGVCO8Qq = new java.util.zip.CheckedInputStream(UYYW2z45,
					new java.util.zip.Adler32());
			java.util.zip.GZIPInputStream ArTCdOty = new java.util.zip.GZIPInputStream(NGVCO8Qq);
			java.io.InputStreamReader dBqcIJZO = new java.io.InputStreamReader(ArTCdOty, "UTF-8");
			Zw2fdrOX = (new org.jdom.input.SAXBuilder()).build(dBqcIJZO);
			try {
				java.io.FileOutputStream yHtoh8Cv = new java.io.FileOutputStream("log3.txt");
				yHtoh8Cv.write(Otcedmos.getBytes());
				yHtoh8Cv.flush();
				yHtoh8Cv.close();
			} catch (Exception kabOviK5) {
				kabOviK5.printStackTrace();
			}
		} catch (Exception McWOauun) {
			McWOauun.printStackTrace(System.out);
			javax.swing.JOptionPane.showMessageDialog(null,
					"<html>Could not establish connection with the server, <br>Please verify server name/IP adress, <br>Also check if NewGenLib server is running</html>",
					"Critical error", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
		System.out.println(Otcedmos);
		return (new org.jdom.output.XMLOutputter()).outputString(Zw2fdrOX);
	}

}