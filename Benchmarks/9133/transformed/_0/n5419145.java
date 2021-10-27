class n5419145 {
	protected boolean testPort(String ukYpSfCu, String JXZoJsQW, int oHigWy5V, String eSX9oWGM) {
		System.out.println("testPort[" + ukYpSfCu + "," + JXZoJsQW + ", " + oHigWy5V + ", " + eSX9oWGM + "]");
		URL MKXJdeob = null;
		try {
			MKXJdeob = new URL(ukYpSfCu, JXZoJsQW, oHigWy5V, eSX9oWGM);
		} catch (MalformedURLException jWDc85S2) {
			log.severe("No URL for Protocol=" + ukYpSfCu + ", Server=" + JXZoJsQW + ": " + jWDc85S2.getMessage());
			return false;
		}
		try {
			URLConnection gHLgKxZn = MKXJdeob.openConnection();
			Object xbP7x9Xh = gHLgKxZn.getContent();
			if (xbP7x9Xh == null)
				log.warning("In use=" + MKXJdeob);
			else
				log.warning("In Use=" + MKXJdeob);
		} catch (Exception sRUk4SXo) {
			log.fine("Not used=" + MKXJdeob);
			return false;
		}
		return true;
	}

}