class n8587541 {
	public static List importSymbol(Report BiPbRpDC, Symbol ZWjD9Cgv, TradingDate T0DLfpsz, TradingDate IaqnlV49)
			throws IOException {
		List OTxjY7Vp = new ArrayList();
		String JNrMrk2S = constructURL(ZWjD9Cgv, T0DLfpsz, IaqnlV49);
		QuoteFilter bMgk7rlh = new YahooQuoteFilter(ZWjD9Cgv);
		PreferencesManager.ProxyPreferences pAqPJTD7 = PreferencesManager.loadProxySettings();
		try {
			URL TZoFQaFC = new URL(JNrMrk2S);
			InputStreamReader bDKhRMjk = new InputStreamReader(TZoFQaFC.openStream());
			BufferedReader mEg6M4j7 = new BufferedReader(bDKhRMjk);
			String BjGKzOuR = mEg6M4j7.readLine();
			while (BjGKzOuR != null) {
				BjGKzOuR = mEg6M4j7.readLine();
				if (BjGKzOuR != null) {
					try {
						Quote sZzGZFPh = bMgk7rlh.toQuote(BjGKzOuR);
						OTxjY7Vp.add(sZzGZFPh);
						verify(BiPbRpDC, sZzGZFPh);
					} catch (QuoteFormatException SGcj6Tpo) {
						BiPbRpDC.addError(Locale.getString("YAHOO") + ":" + ZWjD9Cgv + ":" + Locale.getString("ERROR")
								+ ": " + SGcj6Tpo.getMessage());
					}
				}
			}
			mEg6M4j7.close();
		} catch (BindException swjQ945s) {
			DesktopManager.showErrorMessage(Locale.getString("UNABLE_TO_CONNECT_ERROR", swjQ945s.getMessage()));
			throw new IOException();
		} catch (ConnectException mX9lu79W) {
			DesktopManager.showErrorMessage(Locale.getString("UNABLE_TO_CONNECT_ERROR", mX9lu79W.getMessage()));
			throw new IOException();
		} catch (UnknownHostException JPBdkBcC) {
			DesktopManager.showErrorMessage(Locale.getString("UNKNOWN_HOST_ERROR", JPBdkBcC.getMessage()));
			throw new IOException();
		} catch (NoRouteToHostException l5KEh4Bv) {
			DesktopManager.showErrorMessage(Locale.getString("DESTINATION_UNREACHABLE_ERROR", l5KEh4Bv.getMessage()));
			throw new IOException();
		} catch (MalformedURLException nzZJ4gZo) {
			DesktopManager.showErrorMessage(Locale.getString("INVALID_PROXY_ERROR", pAqPJTD7.host, pAqPJTD7.port));
			throw new IOException();
		} catch (FileNotFoundException BxVbD7jg) {
			BiPbRpDC.addError(Locale.getString("YAHOO") + ":" + ZWjD9Cgv + ":" + Locale.getString("ERROR") + ": "
					+ Locale.getString("NO_QUOTES_FOUND"));
		} catch (IOException ZVYNXgfM) {
			DesktopManager.showErrorMessage(Locale.getString("ERROR_DOWNLOADING_QUOTES"));
			throw new IOException();
		}
		return OTxjY7Vp;
	}

}