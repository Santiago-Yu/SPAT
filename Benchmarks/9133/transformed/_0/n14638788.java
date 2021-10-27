class n14638788 {
	public static InputStream openURL(String MbJNrsJw, ConnectData Zo7Ho9JM) {
		try {
			URLConnection xsZVjx6G = new URL(MbJNrsJw).openConnection();
			xsZVjx6G.setConnectTimeout(TIMEOUT);
			xsZVjx6G.setReadTimeout(TIMEOUT);
			xsZVjx6G.setUseCaches(false);
			xsZVjx6G.setRequestProperty("Accept-Charset", "utf-8");
			setUA(xsZVjx6G);
			if (Zo7Ho9JM.cookie != null)
				xsZVjx6G.setRequestProperty("Cookie", Zo7Ho9JM.cookie);
			InputStream JhK5P3j1 = xsZVjx6G.getInputStream();
			parseCookie(xsZVjx6G, Zo7Ho9JM);
			return new BufferedInputStream(JhK5P3j1);
		} catch (IOException IOJgn9kD) {
			Log.except("failed to open URL " + MbJNrsJw, IOJgn9kD);
		}
		return null;
	}

}