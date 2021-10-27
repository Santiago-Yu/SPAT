class n18666210 {
	public void executeRequest(OperationContext context) throws Throwable {
		long t1 = System.currentTimeMillis();
		GetPortrayMapCapabilitiesParams params = context.getRequestOptions().getGetPortrayMapCapabilitiesOptions();
		String srvCfg = context.getRequestContext().getApplicationConfiguration().getCatalogConfiguration()
				.getParameters().getValue("openls.portrayMap");
		String sUrl = srvCfg + "?f=json&pretty=true";
		URL url = new URL(sUrl);
		URLConnection conn = url.openConnection();
		String line = "";
		String sResponse = "";
		InputStream is = conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader rd = new BufferedReader(isr);
		while ((line = rd.readLine()) != null) {
			sResponse = sResponse + (line);
		}
		rd.close();
		parseResponse(params, sResponse);
		long t2 = System.currentTimeMillis();
		LOGGER.info("PERFORMANCE: " + (t2 - t1) + " ms spent performing service");
	}

}