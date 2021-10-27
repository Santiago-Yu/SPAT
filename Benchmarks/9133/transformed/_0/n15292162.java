class n15292162 {
	private static List retrieveQuotes(Report KpP7ZNd9, Symbol LfU8aUcJ, String thUZIdBc, TradingDate cFuyNFcf,
			TradingDate o48gGvOn) throws ImportExportException {
		List zjIGn7JX = new ArrayList();
		String T5u0YTuX = constructURL(LfU8aUcJ, thUZIdBc, cFuyNFcf, o48gGvOn);
		EODQuoteFilter YeTE9Eqj = new GoogleEODQuoteFilter(LfU8aUcJ);
		PreferencesManager.ProxyPreferences zuzRRI6z = PreferencesManager.getProxySettings();
		try {
			URL BNRKoA9Y = new URL(T5u0YTuX);
			InputStreamReader CTc1xJ6h = new InputStreamReader(BNRKoA9Y.openStream());
			BufferedReader beYRaeUv = new BufferedReader(CTc1xJ6h);
			String WS36xEbo = beYRaeUv.readLine();
			while (WS36xEbo != null) {
				WS36xEbo = beYRaeUv.readLine();
				if (WS36xEbo != null) {
					try {
						EODQuote rdKOjKdx = YeTE9Eqj.toEODQuote(WS36xEbo);
						zjIGn7JX.add(rdKOjKdx);
						verify(KpP7ZNd9, rdKOjKdx);
					} catch (QuoteFormatException kMd2FuXh) {
						KpP7ZNd9.addError(Locale.getString("GOOGLE_DISPLAY_URL") + ":" + LfU8aUcJ + ":"
								+ Locale.getString("ERROR") + ": " + kMd2FuXh.getMessage());
					}
				}
			}
			beYRaeUv.close();
		} catch (BindException iNbIP2Gu) {
			throw new ImportExportException(Locale.getString("UNABLE_TO_CONNECT_ERROR", iNbIP2Gu.getMessage()));
		} catch (ConnectException ccpmFIxA) {
			throw new ImportExportException(Locale.getString("UNABLE_TO_CONNECT_ERROR", ccpmFIxA.getMessage()));
		} catch (UnknownHostException j1XcaPXJ) {
			throw new ImportExportException(Locale.getString("UNKNOWN_HOST_ERROR", j1XcaPXJ.getMessage()));
		} catch (NoRouteToHostException iiHpwVWB) {
			throw new ImportExportException(Locale.getString("DESTINATION_UNREACHABLE_ERROR", iiHpwVWB.getMessage()));
		} catch (MalformedURLException adaJItfH) {
			throw new ImportExportException(Locale.getString("INVALID_PROXY_ERROR", zuzRRI6z.host, zuzRRI6z.port));
		} catch (FileNotFoundException QhiMgSwG) {
		} catch (IOException yJpYgB2f) {
			throw new ImportExportException(Locale.getString("ERROR_DOWNLOADING_QUOTES"));
		}
		return zjIGn7JX;
	}

}