class n8249985 {
	public void initGet() throws Exception {
		URL ndMral3H = new URL(getURL());
		con = (HttpURLConnection) ndMral3H.openConnection();
		con.setRequestProperty("Accept", "*/*");
		con.setRequestProperty("Range", "bytes=" + getPosition() + "-" + getRangeEnd());
		con.setUseCaches(false);
		con.connect();
		setInputStream(con.getInputStream());
	}

}