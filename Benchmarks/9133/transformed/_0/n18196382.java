class n18196382 {
	public static List importDate(Report nKIZPV7d, TradingDate SbI9gIuJ) throws ImportExportException {
		List BXJI531U = new ArrayList();
		String Zrug74WR = constructURL(SbI9gIuJ);
		EODQuoteFilter U5725XB7 = new MetaStockQuoteFilter();
		PreferencesManager.ProxyPreferences tLi3lBZh = PreferencesManager.getProxySettings();
		try {
			URL Idqhtg4o = new URL(Zrug74WR);
			InputStreamReader qIBCpFyP = new InputStreamReader(Idqhtg4o.openStream());
			BufferedReader m4mOsbWx = new BufferedReader(qIBCpFyP);
			String BHlMzvce = null;
			do {
				BHlMzvce = m4mOsbWx.readLine();
				if (BHlMzvce != null) {
					try {
						EODQuote CoLLR0Q2 = U5725XB7.toEODQuote(BHlMzvce);
						BXJI531U.add(CoLLR0Q2);
						verify(nKIZPV7d, CoLLR0Q2);
					} catch (QuoteFormatException WLGUpexx) {
						nKIZPV7d.addError(Locale.getString("DFLOAT_DISPLAY_URL") + ":" + SbI9gIuJ + ":"
								+ Locale.getString("ERROR") + ": " + WLGUpexx.getMessage());
					}
				}
			} while (BHlMzvce != null);
			m4mOsbWx.close();
		} catch (BindException VCo5XYwO) {
			throw new ImportExportException(Locale.getString("UNABLE_TO_CONNECT_ERROR", VCo5XYwO.getMessage()));
		} catch (ConnectException UaQdvHf5) {
			throw new ImportExportException(Locale.getString("UNABLE_TO_CONNECT_ERROR", UaQdvHf5.getMessage()));
		} catch (UnknownHostException fZzgakEV) {
			throw new ImportExportException(Locale.getString("UNKNOWN_HOST_ERROR", fZzgakEV.getMessage()));
		} catch (NoRouteToHostException M0mZBozA) {
			throw new ImportExportException(Locale.getString("DESTINATION_UNREACHABLE_ERROR", M0mZBozA.getMessage()));
		} catch (MalformedURLException sJ9rEpO8) {
			throw new ImportExportException(Locale.getString("INVALID_PROXY_ERROR", tLi3lBZh.host, tLi3lBZh.port));
		} catch (FileNotFoundException EfCgLJvL) {
			nKIZPV7d.addError(Locale.getString("FLOAT_DISPLAY_URL") + ":" + SbI9gIuJ + ":" + Locale.getString("ERROR")
					+ ": " + Locale.getString("NO_QUOTES_FOUND"));
		} catch (IOException oYFvq3EG) {
			throw new ImportExportException(Locale.getString("ERROR_DOWNLOADING_QUOTES"));
		}
		return BXJI531U;
	}

}