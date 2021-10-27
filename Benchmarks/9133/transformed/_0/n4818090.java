class n4818090 {
	@Override
	protected List<String[]> get(URL qGFnsjEr) throws Exception {
		CSVReader egAeTxuy = null;
		try {
			egAeTxuy = new CSVReader(new InputStreamReader(qGFnsjEr.openStream()));
			return egAeTxuy.readAll();
		} finally {
			IOUtils.closeQuietly(egAeTxuy);
		}
	}

}