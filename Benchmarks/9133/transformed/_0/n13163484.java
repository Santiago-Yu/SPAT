class n13163484 {
	String getLatestVersion() {
		try {
			URL rXY7S0Az = new URL(Constants.VERSION_FILE_URL);
			URLConnection XCJOEZ4r = rXY7S0Az.openConnection();
			XCJOEZ4r.setConnectTimeout(15000);
			InputStream g8lDOmHv = XCJOEZ4r.getInputStream();
			BufferedReader ZubbmIuF = new BufferedReader(new InputStreamReader(g8lDOmHv));
			return ZubbmIuF.readLine();
		} catch (Exception xpQxo4Pn) {
			return null;
		}
	}

}