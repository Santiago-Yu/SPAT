class n18666210 {
	public void executeRequest(OperationContext IaoFaDo2) throws Throwable {
		long msAa5Iuz = System.currentTimeMillis();
		GetPortrayMapCapabilitiesParams gbV1PJbv = IaoFaDo2.getRequestOptions().getGetPortrayMapCapabilitiesOptions();
		String pGjQox6S = IaoFaDo2.getRequestContext().getApplicationConfiguration().getCatalogConfiguration()
				.getParameters().getValue("openls.portrayMap");
		String cSYQLNmc = pGjQox6S + "?f=json&pretty=true";
		URL qVVUyXpo = new URL(cSYQLNmc);
		URLConnection TxDMZrfm = qVVUyXpo.openConnection();
		String VVdX5As4 = "";
		String n6ZZnXHN = "";
		InputStream YAXuJVZu = TxDMZrfm.getInputStream();
		InputStreamReader LdIoHtrS = new InputStreamReader(YAXuJVZu);
		BufferedReader YBIp4JgS = new BufferedReader(LdIoHtrS);
		while ((VVdX5As4 = YBIp4JgS.readLine()) != null) {
			n6ZZnXHN += VVdX5As4;
		}
		YBIp4JgS.close();
		parseResponse(gbV1PJbv, n6ZZnXHN);
		long QIX3Aoov = System.currentTimeMillis();
		LOGGER.info("PERFORMANCE: " + (QIX3Aoov - msAa5Iuz) + " ms spent performing service");
	}

}