class n15362793 {
	public static String ReadURL(URL url, boolean textonly) {
		try {
			URLConnection uconn = url.openConnection();
			Object ucont = uconn.getContent();
			if (!(ucont instanceof InputStream))
				return "" + ucont;
			else
				return ReadInputStream((java.io.InputStream) ucont, textonly);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}