class n6424563 {
	public static Element retrieveFromCache(String zP0MlXuK, Object XhrP28J1) {
		URL YcHNR6yi = null;
		HttpURLConnection MsPlQ1tM = null;
		InputStream G6ct7XmL = null;
		OutputStream uRncvRvt = null;
		int a11sbopd = 0;
		StringBuilder Q73G9X81 = null;
		Element WofC9Sfo = null;
		try {
			YcHNR6yi = new URL(EHCACHE_SERVER_BASE + "/" + zP0MlXuK + "/" + XhrP28J1);
			MsPlQ1tM = (HttpURLConnection) YcHNR6yi.openConnection();
			MsPlQ1tM.setRequestMethod("GET");
			MsPlQ1tM.connect();
			G6ct7XmL = MsPlQ1tM.getInputStream();
			byte[] v3eu2Z0E = new byte[4096];
			a11sbopd = G6ct7XmL.read(v3eu2Z0E);
			while (a11sbopd != -1) {
				Q73G9X81.append(v3eu2Z0E);
				a11sbopd = G6ct7XmL.read(v3eu2Z0E);
			}
			if (G6ct7XmL != null) {
				try {
					G6ct7XmL.close();
				} catch (Exception NZOcAVNo) {
				}
			}
			if (MsPlQ1tM != null) {
				MsPlQ1tM.disconnect();
			}
			WofC9Sfo = new Element(XhrP28J1, Q73G9X81.toString());
		} catch (Exception XwvgTomZ) {
			XwvgTomZ.printStackTrace();
		} finally {
			if (uRncvRvt != null) {
				try {
					uRncvRvt.close();
				} catch (Exception DEctk0GC) {
				}
			}
			if (G6ct7XmL != null) {
				try {
					G6ct7XmL.close();
				} catch (Exception oru61YbK) {
				}
			}
			if (MsPlQ1tM != null) {
				MsPlQ1tM.disconnect();
			}
		}
		return WofC9Sfo;
	}

}