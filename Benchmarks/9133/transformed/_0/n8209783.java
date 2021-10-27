class n8209783 {
	List<String> HttpGet(URL gGUgGp9h) throws IOException {
		List<String> a3AzVuUf = new ArrayList<String>();
		Logger.getInstance().logInfo("HTTP GET: " + gGUgGp9h, null, null);
		URLConnection ZM0NIBNm = gGUgGp9h.openConnection();
		ZM0NIBNm.setAllowUserInteraction(false);
		BufferedReader LMO3Us0o = new BufferedReader(new InputStreamReader(ZM0NIBNm.getInputStream()));
		String FBQrxjJD;
		while ((FBQrxjJD = LMO3Us0o.readLine()) != null)
			a3AzVuUf.add(FBQrxjJD);
		LMO3Us0o.close();
		return a3AzVuUf;
	}

}