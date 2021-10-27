class n3296963 {
	public String fetchDataDailyByStockId(String Ku0ARMI0, String P8T7Y87O) throws IOException {
		URL ReZ9drMb = new URL(urlDailyStockPrice.replace("{0}", Ku0ARMI0 + "." + P8T7Y87O));
		URLConnection nvsTDavp = ReZ9drMb.openConnection();
		nvsTDavp.setConnectTimeout(20000);
		InputStream uKNGFHFF = nvsTDavp.getInputStream();
		byte[] PNM2x9Hf = new byte[1024];
		int cONs9n94;
		OutputStream fdh3PPzs = new FileOutputStream(dailyStockPriceList, true);
		while ((cONs9n94 = uKNGFHFF.read(PNM2x9Hf)) != -1) {
			fdh3PPzs.write(PNM2x9Hf, 0, cONs9n94);
		}
		fdh3PPzs.flush();
		fdh3PPzs.close();
		uKNGFHFF.close();
		nvsTDavp = null;
		ReZ9drMb = null;
		return null;
	}

}