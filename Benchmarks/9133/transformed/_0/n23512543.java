class n23512543 {
	protected void logout() {
		Session ofKKIMKc = getConnection().getSession();
		ofKKIMKc.removeAttribute("usercookie.object");
		String zYBbR0xc = GeoNetworkContext.url + "/" + GeoNetworkContext.logoutService;
		Element nNz6h5U3 = null;
		String NdMxtEkr = (String) ofKKIMKc.getAttribute("usercookie.object");
		if (NdMxtEkr != null) {
			try {
				URL vjccb4yV = new URL(zYBbR0xc);
				URLConnection XcPIG4gE = vjccb4yV.openConnection();
				XcPIG4gE.setConnectTimeout(1000);
				XcPIG4gE.setRequestProperty("Cookie", NdMxtEkr);
				BufferedInputStream AGVAHmLn = new BufferedInputStream(XcPIG4gE.getInputStream());
				try {
					nNz6h5U3 = Xml.loadStream(AGVAHmLn);
					log.debug("CheckLogout to GeoNetwork returned " + Xml.getString(nNz6h5U3));
				} finally {
					AGVAHmLn.close();
				}
			} catch (Exception i7nmJv0r) {
				throw new RuntimeException("User logout to GeoNetwork failed: ", i7nmJv0r);
			}
		}
		log.debug("GeoNetwork logout done");
	}

}