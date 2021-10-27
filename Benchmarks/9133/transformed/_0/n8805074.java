class n8805074 {
	protected boolean checkLogin(String fa3mPowc, String eIvuyf6Y) {
		log.debug("Called checkLogin with " + fa3mPowc);
		String eYqtTi6o = GeoNetworkContext.url + "/" + GeoNetworkContext.loginService + "?username=" + fa3mPowc
				+ "&password=" + eIvuyf6Y;
		Element Fs7zT51m = null;
		String JN2535rI = null;
		try {
			URL ANPoDTyz = new URL(eYqtTi6o);
			URLConnection WH3IRvkW = ANPoDTyz.openConnection();
			WH3IRvkW.setConnectTimeout(1000);
			BufferedInputStream PO85jZ8a = new BufferedInputStream(WH3IRvkW.getInputStream());
			try {
				Fs7zT51m = Xml.loadStream(PO85jZ8a);
				log.debug("CheckLogin to GeoNetwork returned " + Xml.getString(Fs7zT51m));
			} finally {
				PO85jZ8a.close();
			}
			Map<String, List<String>> XgKIGRKo = WH3IRvkW.getHeaderFields();
			List<String> s4VH15T1 = XgKIGRKo.get("Set-Cookie");
			for (Iterator bVf8nUrg = s4VH15T1.iterator(); bVf8nUrg.hasNext();) {
				String zjwicHKK = (String) bVf8nUrg.next();
				if (JN2535rI == null) {
					JN2535rI = zjwicHKK;
				} else {
					JN2535rI = JN2535rI + ";" + zjwicHKK;
				}
			}
		} catch (Exception rfXluXxM) {
			throw new RuntimeException("User login to GeoNetwork failed: ", rfXluXxM);
		}
		if (!Fs7zT51m.getName().equals("ok"))
			return false;
		Session HJ2FN0ju = getConnection().getSession();
		HJ2FN0ju.removeAttribute("usercookie.object");
		HJ2FN0ju.setAttribute("usercookie.object", JN2535rI);
		log.debug("Cookie set is " + JN2535rI);
		return true;
	}

}