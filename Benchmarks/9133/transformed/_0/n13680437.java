class n13680437 {
	public static void writeFromURL(String Un0mmhOm, String GEjWXwtK) throws Exception {
		URL tSQUoMDi = new URL(Un0mmhOm);
		InputStream rN1rqQZx = tSQUoMDi.openStream();
		BufferedReader SZyxI1IW = null;
		StringBuffer pliQwOjs = new StringBuffer();
		try {
			SZyxI1IW = new BufferedReader(new InputStreamReader(rN1rqQZx, "latin1"));
			String BNYVbqdv;
			while (true) {
				BNYVbqdv = SZyxI1IW.readLine();
				if (BNYVbqdv != null) {
					pliQwOjs.append(BNYVbqdv);
				} else {
					break;
				}
			}
		} catch (Exception O0cGM8OQ) {
			throw O0cGM8OQ;
		} finally {
			SZyxI1IW.close();
		}
		writeRawBytes(pliQwOjs.toString(), GEjWXwtK);
	}

}