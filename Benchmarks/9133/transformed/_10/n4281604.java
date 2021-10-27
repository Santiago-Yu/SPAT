class n4281604 {
	private void executeRequest(OperationContext context) throws java.lang.Throwable {
		DirectoryParams params = context.getRequestOptions().getDirectoryOptions();
		long t1 = System.currentTimeMillis();
		try {
			String srvCfg = context.getRequestContext().getApplicationConfiguration().getCatalogConfiguration()
					.getParameters().getValue("openls.directory");
			HashMap<String, String> poiProperties = params.getPoiProperties();
			Set<String> keys = poiProperties.keySet();
			StringBuffer filter = new StringBuffer();
			Iterator<String> iter = keys.iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				QueryFilter queryFilter = new QueryFilter(key, poiProperties.get(key));
				filter.append(makePOIRequest(queryFilter));
			}
			String sUrl = srvCfg + "/query?" + filter.toString();
			LOGGER.info("REQUEST=\n" + sUrl);
			URL url = new URL(sUrl);
			String line = "";
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			String sResponse = "";
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader rd = new BufferedReader(isr);
			while ((line = rd.readLine()) != null) {
				sResponse += line;
			}
			rd.close();
			url = null;
			parsePOIResponse(sResponse, params);
		} catch (Exception p_e) {
			LOGGER.severe("Throwing exception" + p_e.getMessage());
			throw p_e;
		} finally {
			long t2 = System.currentTimeMillis();
			LOGGER.info("PERFORMANCE: " + (t2 - t1) + " ms spent performing service");
		}
	}

}