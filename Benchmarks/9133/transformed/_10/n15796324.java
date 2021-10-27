class n15796324 {
	public static List importSymbols(List symbols) throws ImportExportException {
		String URLString = constructURL(symbols);
		List quotes = new ArrayList();
		PreferencesManager.ProxyPreferences proxyPreferences = PreferencesManager.loadProxySettings();
		IDQuoteFilter filter = new YahooIDQuoteFilter();
		try {
			URL url = new URL(URLString);
			InputStreamReader input = new InputStreamReader(url.openStream());
			String line;
			BufferedReader bufferedInput = new BufferedReader(input);
			do {
				line = bufferedInput.readLine();
				if (line != null) {
					try {
						IDQuote quote = filter.toIDQuote(line);
						quote.verify();
						quotes.add(quote);
					} catch (QuoteFormatException e) {
					}
				}
			} while (line != null);
			bufferedInput.close();
		} catch (BindException e) {
			throw new ImportExportException(Locale.getString("UNABLE_TO_CONNECT_ERROR", e.getMessage()));
		} catch (ConnectException e) {
			throw new ImportExportException(Locale.getString("UNABLE_TO_CONNECT_ERROR", e.getMessage()));
		} catch (UnknownHostException e) {
			throw new ImportExportException(Locale.getString("UNKNOWN_HOST_ERROR", e.getMessage()));
		} catch (NoRouteToHostException e) {
			throw new ImportExportException(Locale.getString("DESTINATION_UNREACHABLE_ERROR", e.getMessage()));
		} catch (MalformedURLException e) {
			throw new ImportExportException(
					Locale.getString("INVALID_PROXY_ERROR", proxyPreferences.host, proxyPreferences.port));
		} catch (FileNotFoundException e) {
			throw new ImportExportException(Locale.getString("ERROR_DOWNLOADING_QUOTES"));
		} catch (IOException e) {
			throw new ImportExportException(Locale.getString("ERROR_DOWNLOADING_QUOTES"));
		}
		return quotes;
	}

}