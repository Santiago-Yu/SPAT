class n7802218 {
	private static List retrieveQuotes(Report av1ZiNUs, Symbol UAXNhUh2, String ZO20m2mK, TradingDate nqBGIs0T,
			TradingDate FN7nSfB7) throws ImportExportException {
		List h2uy8ANp = new ArrayList();
		String m9vNEf1N = constructURL(UAXNhUh2, ZO20m2mK, nqBGIs0T, FN7nSfB7);
		EODQuoteFilter zEYJbdP4 = new YahooEODQuoteFilter(UAXNhUh2);
		PreferencesManager.ProxyPreferences mspv206k = PreferencesManager.getProxySettings();
		try {
			URL kVCfji8Z = new URL(m9vNEf1N);
			InputStreamReader vQO62OIe = new InputStreamReader(kVCfji8Z.openStream());
			BufferedReader TIvKmR7J = new BufferedReader(vQO62OIe);
			String UbK9bz7S = TIvKmR7J.readLine();
			while (UbK9bz7S != null) {
				UbK9bz7S = TIvKmR7J.readLine();
				if (UbK9bz7S != null) {
					try {
						EODQuote EabFcK2o = zEYJbdP4.toEODQuote(UbK9bz7S);
						h2uy8ANp.add(EabFcK2o);
						verify(av1ZiNUs, EabFcK2o);
					} catch (QuoteFormatException otiz3s46) {
						av1ZiNUs.addError(Locale.getString("YAHOO_DISPLAY_URL") + ":" + UAXNhUh2 + ":"
								+ Locale.getString("ERROR") + ": " + otiz3s46.getMessage());
					}
				}
			}
			TIvKmR7J.close();
		} catch (BindException WSQrH84b) {
			throw new ImportExportException(Locale.getString("UNABLE_TO_CONNECT_ERROR", WSQrH84b.getMessage()));
		} catch (ConnectException WJTeXAVd) {
			throw new ImportExportException(Locale.getString("UNABLE_TO_CONNECT_ERROR", WJTeXAVd.getMessage()));
		} catch (UnknownHostException S23Vr9AV) {
			throw new ImportExportException(Locale.getString("UNKNOWN_HOST_ERROR", S23Vr9AV.getMessage()));
		} catch (NoRouteToHostException eqiR0dNh) {
			throw new ImportExportException(Locale.getString("DESTINATION_UNREACHABLE_ERROR", eqiR0dNh.getMessage()));
		} catch (MalformedURLException gAc9D3cJ) {
			throw new ImportExportException(Locale.getString("INVALID_PROXY_ERROR", mspv206k.host, mspv206k.port));
		} catch (FileNotFoundException z86hLTDV) {
		} catch (IOException sdZ97wtG) {
			throw new ImportExportException(Locale.getString("ERROR_DOWNLOADING_QUOTES"));
		}
		return h2uy8ANp;
	}

}