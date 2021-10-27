class n17947246 {
	public String readURL(String bIOfvaJq, ArrayList cCu2CCZP, RenderEngine Pq68URmB) throws Exception {
		URL Eomxo1aN = null;
		HttpURLConnection yncsdIIc = null;
		InputStream jbPJMHxO = null;
		try {
			Eomxo1aN = new URL(bIOfvaJq);
			yncsdIIc = (HttpURLConnection) Eomxo1aN.openConnection();
		} catch (Exception vAU76G2M) {
			throw new Exception("Soap is unable to retrieve URL for '" + bIOfvaJq + "': " + vAU76G2M.getMessage());
		}
		loadCookies(bIOfvaJq, yncsdIIc, Pq68URmB);
		if (cCu2CCZP != null) {
			for (int Fg6WTP3J = 0; Fg6WTP3J < cCu2CCZP.size(); Fg6WTP3J++) {
				String QlNEWPwF = (String) cCu2CCZP.get(Fg6WTP3J);
				String Jm2Sm22g = QlNEWPwF.substring(0, QlNEWPwF.indexOf(":"));
				String fHS3wcbh = QlNEWPwF.substring(QlNEWPwF.indexOf(":") + 2);
				Debug.log("Adding new request header '" + Jm2Sm22g + "'='" + fHS3wcbh + "'");
				yncsdIIc.setRequestProperty(Jm2Sm22g, fHS3wcbh);
			}
		}
		Debug.debug("Set to use GET, URL=" + bIOfvaJq);
		try {
			jbPJMHxO = yncsdIIc.getInputStream();
		} catch (Exception ozVeePGJ) {
			Debug.debug("Unable to capture input stream: " + ozVeePGJ.getMessage());
			throw new Exception("Unable to capture input stream from URL '" + bIOfvaJq + "': " + ozVeePGJ.getMessage());
		}
		Debug.debug("'GET' - Got input stream.");
		if (yncsdIIc.getContentLength() == -1) {
			Debug.debug("Content length = unknown");
		} else {
			Debug.debug("Content length = " + yncsdIIc.getContentLength());
		}
		byte O1HFIWip[] = null;
		int YN9TxyJQ = 0, WsYGOc25 = yncsdIIc.getContentLength();
		if (yncsdIIc.getContentLength() == -1) {
			String RIFzw3SL = NodeUtil.walkNodeTree(Server.getConfig(),
					"//configuration/object[@type='engine.tunable']/property[@type='engine.unknowncontentsize']/@value");
			if (RIFzw3SL == null) {
				WsYGOc25 = 4096;
			} else {
				WsYGOc25 = Integer.parseInt(RIFzw3SL);
			}
			Debug.debug("Content length unknown.  Allowing fuzz of " + WsYGOc25 + " bytes.");
		}
		O1HFIWip = new byte[WsYGOc25];
		try {
			int KOEV5fOw = 0;
			while ((KOEV5fOw = jbPJMHxO.read(O1HFIWip, YN9TxyJQ, WsYGOc25 - YN9TxyJQ)) != -1) {
				if (KOEV5fOw == 0) {
					break;
				}
				YN9TxyJQ += KOEV5fOw;
			}
		} catch (Exception UjGkojV4) {
			throw new Exception("Soap is unable to read data from HTTP connection: " + UjGkojV4.getMessage());
		}
		try {
			jbPJMHxO.close();
			yncsdIIc.disconnect();
		} catch (MalformedURLException XajkxEW3) {
			throw new Exception("Soap request to site '" + bIOfvaJq + "' is invalid: " + XajkxEW3.getMessage());
		} catch (IOException ty9zcLo6) {
			throw new Exception("Soap request to site '" + bIOfvaJq + "' failed to connect.");
		}
		String wyEL7vlm = new String(O1HFIWip);
		int ozu7XfXJ = 0;
		O1HFIWip = null;
		jbPJMHxO = null;
		yncsdIIc = null;
		Eomxo1aN = null;
		return wyEL7vlm.trim();
	}

}