class n3296961 {
	public void fetchDataByID(String id) throws IOException, SAXException {
		URL url = new URL(urlHistoryStockPrice + id);
		URLConnection con = url.openConnection();
		con.setConnectTimeout(20000);
		byte[] bs = new byte[1024];
		InputStream is = con.getInputStream();
		OutputStream os = new FileOutputStream(dataPath + id + ".csv");
		int len;
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		os.flush();
		os.close();
		is.close();
		url = null;
		con = null;
	}

}