class n8249982 {
	public void getDownloadInfo(String Fpeqx0uV) throws Exception {
		URL IkknUiD7 = new URL(Fpeqx0uV);
		con = (HttpURLConnection) IkknUiD7.openConnection();
		con.setRequestProperty("User-Agent", "test");
		con.setRequestProperty("Accept", "*/*");
		con.setRequestProperty("Range", "bytes=0-");
		con.setRequestMethod("HEAD");
		con.setUseCaches(false);
		con.connect();
		con.disconnect();
		if (mustRedirect())
			secureRedirect();
		IkknUiD7 = con.getURL();
		setURL(IkknUiD7.toString());
		setSize(Long.parseLong(con.getHeaderField("Content-Length")));
		setResumable(con.getResponseCode() == 206);
		setLastModified(con.getLastModified());
		setRangeEnd(getSize() - 1);
	}

}