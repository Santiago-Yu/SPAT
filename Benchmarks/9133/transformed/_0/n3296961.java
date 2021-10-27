class n3296961 {
	public void fetchDataByID(String Z6zonKbo) throws IOException, SAXException {
		URL yXrkPF4y = new URL(urlHistoryStockPrice + Z6zonKbo);
		URLConnection pNaHYUaD = yXrkPF4y.openConnection();
		pNaHYUaD.setConnectTimeout(20000);
		InputStream szS1yuFD = pNaHYUaD.getInputStream();
		byte[] kJVanXYW = new byte[1024];
		int YYt8zug7;
		OutputStream Xt38uV0g = new FileOutputStream(dataPath + Z6zonKbo + ".csv");
		while ((YYt8zug7 = szS1yuFD.read(kJVanXYW)) != -1) {
			Xt38uV0g.write(kJVanXYW, 0, YYt8zug7);
		}
		Xt38uV0g.flush();
		Xt38uV0g.close();
		szS1yuFD.close();
		pNaHYUaD = null;
		yXrkPF4y = null;
	}

}