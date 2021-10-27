class n13207436 {
	public Object sendObjectRequestToSpecifiedServer(java.lang.String P0HbObYZ, java.lang.String h7JHxwOW,
			java.lang.Object ZNwEq4dJ) {
		Object UokMsuih = null;
		org.jdom.Document H42KPPu1 = null;
		String RjxtuDyj = java.util.prefs.Preferences.systemRoot().get("serverurl", "");
		String VM6yLtxj = java.util.prefs.Preferences.systemRoot().get("portno", "8080");
		if (VM6yLtxj == null || VM6yLtxj.trim().equals("")) {
			VM6yLtxj = "80";
		}
		if (this.serverURL == null) {
			try {
				java.net.URL otIHEV3e = newgen.presentation.NewGenMain.getAppletInstance().getCodeBase();
				if (otIHEV3e != null)
					serverURL = otIHEV3e.getHost();
				else
					serverURL = "localhost";
			} catch (Exception siEcHZkf) {
				siEcHZkf.printStackTrace();
				serverURL = "localhost";
			}
			newgen.presentation.component.IPAddressPortNoDialog j7CbRLQn = new newgen.presentation.component.IPAddressPortNoDialog(
					RjxtuDyj, VM6yLtxj);
			j7CbRLQn.show();
			serverURL = RjxtuDyj = j7CbRLQn.getIPAddress();
			VM6yLtxj = j7CbRLQn.getPortNo();
			java.util.prefs.Preferences.systemRoot().put("serverurl", serverURL);
			java.util.prefs.Preferences.systemRoot().put("portno", VM6yLtxj);
			System.out.println(serverURL);
		}
		try {
			java.net.URL ZoO6OZ4u = new java.net.URL(
					"http://" + P0HbObYZ + ":" + VM6yLtxj + "/newgenlibctxt/" + h7JHxwOW);
			java.net.URLConnection prCKJfSt = (java.net.URLConnection) ZoO6OZ4u.openConnection();
			prCKJfSt.setDoOutput(true);
			java.io.OutputStream GRu2X3Zp = prCKJfSt.getOutputStream();
			java.util.zip.CheckedOutputStream rSOr9JAQ = new java.util.zip.CheckedOutputStream(GRu2X3Zp,
					new java.util.zip.Adler32());
			java.util.zip.GZIPOutputStream YCfdLbLt = new java.util.zip.GZIPOutputStream(rSOr9JAQ);
			java.io.ObjectOutputStream vodYwLTF = new java.io.ObjectOutputStream(YCfdLbLt);
			vodYwLTF.writeObject(ZNwEq4dJ);
			vodYwLTF.flush();
			vodYwLTF.close();
			java.io.InputStream v9WGpouc = prCKJfSt.getInputStream();
			java.util.zip.CheckedInputStream tVPb9QID = new java.util.zip.CheckedInputStream(v9WGpouc,
					new java.util.zip.Adler32());
			java.util.zip.GZIPInputStream ov9Gxr87 = new java.util.zip.GZIPInputStream(tVPb9QID);
			java.io.ObjectInputStream UaqH3R9C = new java.io.ObjectInputStream(ov9Gxr87);
			UokMsuih = UaqH3R9C.readObject();
		} catch (Exception tb4Tt5RY) {
			tb4Tt5RY.printStackTrace(System.out);
			System.out.println("Exception in Servlet Connector: " + tb4Tt5RY);
		}
		return UokMsuih;
	}

}