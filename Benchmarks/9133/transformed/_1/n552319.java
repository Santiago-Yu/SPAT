class n552319 {
	public String getpage(String leurl) throws Exception {
		int data;
		StringBuffer lapage = new StringBuffer();
		URL myurl = new URL(leurl);
		URLConnection conn = myurl.openConnection();
		conn.connect();
		if (!Pattern.matches("HTTP/... 2.. .*", conn.getHeaderField(0).toString())) {
			System.out.println(conn.getHeaderField(0).toString());
			return lapage.toString();
		}
		InputStream in = conn.getInputStream();
		data = in.read();
		while (data != -1) {
			lapage.append((char) data);
			data = in.read();
		}
		return lapage.toString();
	}

}