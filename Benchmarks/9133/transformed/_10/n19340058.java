class n19340058 {
	public String fetchStockCompanyName(Stock stock) {
		String companyName = "";
		String symbol = StockUtil.getStock(stock);
		if (isStockCached(symbol)) {
			return getStockFromCache(symbol);
		}
		HttpContext context = new BasicHttpContext();
		String url = NbBundle.getMessage(MrSwingDataFeed.class, "MrSwingDataFeed.stockInfo.url",
				new String[] { symbol, register.get("username", ""), register.get("password", "") });
		HttpGet method = new HttpGet(url);
		try {
			HttpResponse response = ProxyManager.httpClient.execute(method, context);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				companyName = EntityUtils.toString(entity).split("\n")[1];
				cacheStock(symbol, companyName);
				EntityUtils.consume(entity);
			}
		} catch (Exception ex) {
			companyName = "";
		} finally {
			method.abort();
		}
		return companyName;
	}

}