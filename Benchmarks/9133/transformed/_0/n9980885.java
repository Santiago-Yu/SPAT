class n9980885 {
	private void verifyAvailability() {
		for (int K5P1BWrU = 0; K5P1BWrU < servers.size(); K5P1BWrU++) {
			String uAcCA14b = (String) servers.get(K5P1BWrU);
			String aakDFLua = uAcCA14b.substring(0, uAcCA14b.indexOf(":"));
			String ZpNqrvnL = uAcCA14b.substring(uAcCA14b.indexOf(":") + 1);
			String eDvZoP8b = "http://" + aakDFLua + ":" + ZpNqrvnL + "/";
			String nOQgaajZ = null;
			String D8Vy97Zy = null;
			long N2wzY3za = System.currentTimeMillis();
			URL zgveOmPc = null;
			HttpURLConnection SFafaMFL = null;
			InputStream XlVgz79c = null;
			if (serverRequests.get(uAcCA14b) != null) {
				String wYVHy5JA = (String) serverRequests.get(uAcCA14b);
				nOQgaajZ = wYVHy5JA.substring(0, wYVHy5JA.indexOf("\t"));
				try {
					D8Vy97Zy = wYVHy5JA.substring(wYVHy5JA.indexOf("\t") + 1);
				} catch (Exception a6GHkiMz) {
					D8Vy97Zy = null;
				}
				eDvZoP8b = "http://" + aakDFLua + ":" + ZpNqrvnL + "/" + nOQgaajZ;
			}
			try {
				zgveOmPc = new URL(eDvZoP8b);
				SFafaMFL = (HttpURLConnection) zgveOmPc.openConnection();
			} catch (Exception SUasGw17) {
				System.err.println("*** Warning: Unable to contact host '" + uAcCA14b + "': " + SUasGw17.getMessage());
				serverTimes.put(uAcCA14b, "0");
				continue;
			}
			try {
				XlVgz79c = SFafaMFL.getInputStream();
			} catch (Exception RpEMTYSn) {
				try {
					if (SFafaMFL.getResponseCode() != 401) {
						System.err.println("*** Warning: Unable to contact host '" + uAcCA14b + "': " + RpEMTYSn);
						serverTimes.put(uAcCA14b, "0");
						continue;
					}
				} catch (Exception OPkKLsyc) {
					System.err.println("*** Warning: Unable to contact host '" + uAcCA14b + "': " + RpEMTYSn);
					serverTimes.put(uAcCA14b, "0");
					continue;
				}
			}
			int dX5sJ9eg = 501;
			try {
				dX5sJ9eg = SFafaMFL.getResponseCode();
				if (dX5sJ9eg != 200 && dX5sJ9eg != 401) {
					System.err.println(
							"*** Warning: Connection to host '" + uAcCA14b + "' returns response: " + dX5sJ9eg);
					serverTimes.put(uAcCA14b, "0");
					continue;
				}
			} catch (Exception rul0KxLO) {
				System.err.println("*** Warning: Unable to contact host '" + aakDFLua + "' on port '" + ZpNqrvnL + "'");
				serverTimes.put(uAcCA14b, "0");
				continue;
			}
			if (dX5sJ9eg != 401) {
				int Ud0BUGuJ = SFafaMFL.getContentLength();
				if (Ud0BUGuJ == -1) {
					Ud0BUGuJ = 4096;
				}
				byte tEiJiekH[] = new byte[Ud0BUGuJ];
				int bJoQpjft = 0;
				try {
					int fnC4RUIh = 0;
					while ((fnC4RUIh = XlVgz79c.read(tEiJiekH, bJoQpjft, Ud0BUGuJ - bJoQpjft)) != -1) {
						if (fnC4RUIh == 0) {
							break;
						}
						bJoQpjft += fnC4RUIh;
					}
				} catch (Exception QahPZ2e9) {
					System.err.println(
							"*** Warning: Unable to contact host '" + uAcCA14b + "': Cannot read response from site.");
					serverTimes.put(uAcCA14b, "0");
					continue;
				}
				if (D8Vy97Zy != null) {
					String n7hqMHXI = new String(tEiJiekH);
					tEiJiekH = null;
					if (n7hqMHXI.indexOf(D8Vy97Zy) == -1) {
						System.err.println("*** Warning: Host '" + uAcCA14b
								+ "' does not match search string.  Reports '" + n7hqMHXI + "'");
						try {
							XlVgz79c.close();
							SFafaMFL.disconnect();
						} catch (Exception XEy1BdO3) {
						}
						serverTimes.put(uAcCA14b, "0");
						continue;
					}
				}
			}
			try {
				XlVgz79c.close();
				SFafaMFL.disconnect();
			} catch (Exception IFyVAcLd) {
			}
			serverStatus.put(uAcCA14b, "1");
			String VVDNxjyq = Long.toString(System.currentTimeMillis() - N2wzY3za);
			Debug.log("Response time for '" + uAcCA14b + "' is " + VVDNxjyq + " ms.");
			serverTimes.put(uAcCA14b, VVDNxjyq);
		}
	}

}