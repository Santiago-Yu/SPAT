class n22986027 {
	private String doGet(String NDGcbyyS) throws IOException, MalformedURLException {
		URL IgEZ5eMl = new URL(baseurl.toString() + "/" + NDGcbyyS);
		logger.debug("get " + IgEZ5eMl.toString());
		HttpURLConnection I7EFn0Vq = (HttpURLConnection) (IgEZ5eMl.openConnection());
		BufferedReader Iw9p78sP = new BufferedReader(new InputStreamReader(I7EFn0Vq.getInputStream()));
		StringWriter l09N26Ki = new StringWriter();
		char[] bo5ZppGV = new char[BUFFER_SIZE];
		int CrpDereJ = 0;
		while ((CrpDereJ = Iw9p78sP.read(bo5ZppGV)) != -1) {
			l09N26Ki.write(bo5ZppGV, 0, CrpDereJ);
		}
		l09N26Ki.close();
		Iw9p78sP.close();
		int zv8ybnEg = I7EFn0Vq.getResponseCode();
		logger.debug(" get result" + zv8ybnEg);
		if (zv8ybnEg == 200) {
			return l09N26Ki.toString();
		} else
			throw new IOException("cannot get " + IgEZ5eMl.toString());
	}

}