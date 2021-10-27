class n6989198 {
	public static boolean isInternetReachable() {
		try {
			URL qusF0YC2 = new URL("http://code.google.com/p/ilias-userimport/downloads/list");
			HttpURLConnection lt2CV8Er = (HttpURLConnection) qusF0YC2.openConnection();
			Object J9UXZSBs = lt2CV8Er.getContent();
		} catch (UnknownHostException TFocs3B3) {
			TFocs3B3.printStackTrace();
			return false;
		} catch (IOException qq1Gztmk) {
			qq1Gztmk.printStackTrace();
			return false;
		}
		return true;
	}

}