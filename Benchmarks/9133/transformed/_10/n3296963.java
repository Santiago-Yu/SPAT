class n3296963 {
	public String fetchDataDailyByStockId(String StockId, String market) throws IOException {
		URL url = new URL(urlDailyStockPrice.replace("{0}", StockId + "." + market));
		URLConnection con = url.openConnection();
		con.setConnectTimeout(20000);
		byte[] bs = new byte[1024];
		InputStream is = con.getInputStream();
		OutputStream os = new FileOutputStream(dailyStockPriceList, true);
		int len;
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		os.flush();
		os.close();
		is.close();
		url = null;
		con = null;
		return null;
	}

}