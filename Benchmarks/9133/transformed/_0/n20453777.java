class n20453777 {
	private static List retrieveQuotes(Report RWcUCb1e, Symbol JWPZRiHh, TradingDate Y6wurLjw, TradingDate dmaUEljc)
			throws ImportExportException {
		List pvRvx0HO = new ArrayList();
		String fZskeRBP = constructURL(JWPZRiHh, Y6wurLjw, dmaUEljc);
		EODQuoteFilter pjD3Bptn = new YahooEODQuoteFilter(JWPZRiHh);
		PreferencesManager.ProxyPreferences ZHce1cct = PreferencesManager.loadProxySettings();
		try {
			URL ElyzRH00 = new URL(fZskeRBP);
			InputStreamReader XmLaE6rQ = new InputStreamReader(ElyzRH00.openStream());
			BufferedReader YUTp5J9S = new BufferedReader(XmLaE6rQ);
			String AsFUbVcp = YUTp5J9S.readLine();
			while (AsFUbVcp != null) {
				AsFUbVcp = YUTp5J9S.readLine();
				if (AsFUbVcp != null) {
					try {
						EODQuote emikLDG5 = pjD3Bptn.toEODQuote(AsFUbVcp);
						pvRvx0HO.add(emikLDG5);
						verify(RWcUCb1e, emikLDG5);
					} catch (QuoteFormatException WIhz5xbX) {
						RWcUCb1e.addError(Locale.getString("YAHOO") + ":" + JWPZRiHh + ":" + Locale.getString("ERROR")
								+ ": " + WIhz5xbX.getMessage());
					}
				}
			}
			YUTp5J9S.close();
		} catch (BindException KMY1R0nE) {
			throw new ImportExportException(Locale.getString("UNABLE_TO_CONNECT_ERROR", KMY1R0nE.getMessage()));
		} catch (ConnectException IIN39PAI) {
			throw new ImportExportException(Locale.getString("UNABLE_TO_CONNECT_ERROR", IIN39PAI.getMessage()));
		} catch (UnknownHostException DBMatdYP) {
			throw new ImportExportException(Locale.getString("UNKNOWN_HOST_ERROR", DBMatdYP.getMessage()));
		} catch (NoRouteToHostException woosR4H9) {
			throw new ImportExportException(Locale.getString("DESTINATION_UNREACHABLE_ERROR", woosR4H9.getMessage()));
		} catch (MalformedURLException eJ6SVnbw) {
			throw new ImportExportException(Locale.getString("INVALID_PROXY_ERROR", ZHce1cct.host, ZHce1cct.port));
		} catch (FileNotFoundException EfioihxF) {
		} catch (IOException pIHcnkCT) {
			throw new ImportExportException(Locale.getString("ERROR_DOWNLOADING_QUOTES"));
		}
		return pvRvx0HO;
	}

}