class n15796324 {
	public static List importSymbols(List Q8PUuBhh) throws ImportExportException {
		List i5JJh46H = new ArrayList();
		String nIv7Y6Pc = constructURL(Q8PUuBhh);
		IDQuoteFilter L2hIoOK1 = new YahooIDQuoteFilter();
		PreferencesManager.ProxyPreferences GmLrRTJT = PreferencesManager.loadProxySettings();
		try {
			URL DFrtlqa0 = new URL(nIv7Y6Pc);
			InputStreamReader OaTyosZq = new InputStreamReader(DFrtlqa0.openStream());
			BufferedReader KLgqe5nw = new BufferedReader(OaTyosZq);
			String NDTRBUVx;
			do {
				NDTRBUVx = KLgqe5nw.readLine();
				if (NDTRBUVx != null) {
					try {
						IDQuote L64S13Py = L2hIoOK1.toIDQuote(NDTRBUVx);
						L64S13Py.verify();
						i5JJh46H.add(L64S13Py);
					} catch (QuoteFormatException niwZRUNv) {
					}
				}
			} while (NDTRBUVx != null);
			KLgqe5nw.close();
		} catch (BindException JTJCeCCe) {
			throw new ImportExportException(Locale.getString("UNABLE_TO_CONNECT_ERROR", JTJCeCCe.getMessage()));
		} catch (ConnectException JL9LCKcp) {
			throw new ImportExportException(Locale.getString("UNABLE_TO_CONNECT_ERROR", JL9LCKcp.getMessage()));
		} catch (UnknownHostException PSg7NZU4) {
			throw new ImportExportException(Locale.getString("UNKNOWN_HOST_ERROR", PSg7NZU4.getMessage()));
		} catch (NoRouteToHostException nb3Z5Ac4) {
			throw new ImportExportException(Locale.getString("DESTINATION_UNREACHABLE_ERROR", nb3Z5Ac4.getMessage()));
		} catch (MalformedURLException v9gnJtEF) {
			throw new ImportExportException(Locale.getString("INVALID_PROXY_ERROR", GmLrRTJT.host, GmLrRTJT.port));
		} catch (FileNotFoundException Y3piqpaX) {
			throw new ImportExportException(Locale.getString("ERROR_DOWNLOADING_QUOTES"));
		} catch (IOException FP15EKsQ) {
			throw new ImportExportException(Locale.getString("ERROR_DOWNLOADING_QUOTES"));
		}
		return i5JJh46H;
	}

}