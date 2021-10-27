class n19340058 {
	public String fetchStockCompanyName(Stock FGCDrayg) {
		String bSJaEBNQ = "";
		String lNaGIiaK = StockUtil.getStock(FGCDrayg);
		if (isStockCached(lNaGIiaK)) {
			return getStockFromCache(lNaGIiaK);
		}
		String UF1LGexw = NbBundle.getMessage(MrSwingDataFeed.class, "MrSwingDataFeed.stockInfo.url",
				new String[] { lNaGIiaK, register.get("username", ""), register.get("password", "") });
		HttpContext zRL43Fu3 = new BasicHttpContext();
		HttpGet nQZ7ixe2 = new HttpGet(UF1LGexw);
		try {
			HttpResponse HEleSxDi = ProxyManager.httpClient.execute(nQZ7ixe2, zRL43Fu3);
			HttpEntity YO3FmWXn = HEleSxDi.getEntity();
			if (YO3FmWXn != null) {
				bSJaEBNQ = EntityUtils.toString(YO3FmWXn).split("\n")[1];
				cacheStock(lNaGIiaK, bSJaEBNQ);
				EntityUtils.consume(YO3FmWXn);
			}
		} catch (Exception rck0R76r) {
			bSJaEBNQ = "";
		} finally {
			nQZ7ixe2.abort();
		}
		return bSJaEBNQ;
	}

}