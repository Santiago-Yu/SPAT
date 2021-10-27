class n5049453 {
	private BingResponse queryBing(BingRequest CJd4L6Nw) throws BingException {
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("Searching through bing...");
			}
			String rQ3fUPcF = CJd4L6Nw.getQuery();
			rQ3fUPcF = URLEncoder.encode(rQ3fUPcF, "UTF-8");
			URL xK2BHwOh = new URL("http://api.bing.net/json.aspx?" + "AppId=" + CJd4L6Nw.getAppId() + "&Query="
					+ rQ3fUPcF + "&Sources=" + CJd4L6Nw.getType().toString());
			URLConnection uGAxyviV = null;
			if (useProxy) {
				if (proxyType == null) {
					throw new BingException("Please set a proxy first before trying to connect through a proxy",
							new Throwable());
				}
				uGAxyviV = ProxyWrapper.getURLConnection(xK2BHwOh.toString(), proxyType.toString(), proxyHost,
						proxyPort);
			} else {
				uGAxyviV = new URL(xK2BHwOh.toString()).openConnection();
			}
			String qILWkYaG;
			StringBuilder dK43aQW1 = new StringBuilder();
			BufferedReader uHG5zoW4 = new BufferedReader(new InputStreamReader(uGAxyviV.getInputStream()));
			while ((qILWkYaG = uHG5zoW4.readLine()) != null) {
				dK43aQW1.append(qILWkYaG);
			}
			String wMRG6MbN = dK43aQW1.toString();
			ResponseParser dVYms7Sh = new ResponseParser();
			dVYms7Sh.getError(wMRG6MbN);
			return dVYms7Sh.getResults(wMRG6MbN);
		} catch (MalformedURLException iWaPRqt6) {
			logger.error(iWaPRqt6);
			throw new ConnectionException("Could not connect to host", iWaPRqt6);
		} catch (IOException f7SUUPpX) {
			logger.error(f7SUUPpX);
			throw new ConnectionException("Could not connect to host", f7SUUPpX);
		}
	}

}