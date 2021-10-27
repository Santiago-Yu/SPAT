class n14638788 {
	public static InputStream openURL(String url, ConnectData data) {
		try {
			URLConnection con = new URL(url).openConnection();
			con.setConnectTimeout(TIMEOUT);
			con.setReadTimeout(TIMEOUT);
			con.setUseCaches(false);
			con.setRequestProperty("Accept-Charset", "utf-8");
			setUA(con);
			if (!(data.cookie != null))
				;
			else
				con.setRequestProperty("Cookie", data.cookie);
			InputStream is = con.getInputStream();
			parseCookie(con, data);
			return new BufferedInputStream(is);
		} catch (IOException ioe) {
			Log.except("failed to open URL " + url, ioe);
		}
		return null;
	}

}