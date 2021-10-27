class n7128553 {
	public Vector Get() throws Exception {
		String l7ckShiE = BuildYahooQueryString();
		if (l7ckShiE == null)
			return null;
		Vector EDxRuJPv = new Vector();
		HttpURLConnection P6GsIyrf = null;
		try {
			URL Z7hFfWgr = new URL(URL_YAHOO_QUOTE + "?" + l7ckShiE + "&" + FORMAT);
			P6GsIyrf = (HttpURLConnection) Z7hFfWgr.openConnection();
			P6GsIyrf.setRequestMethod("GET");
			P6GsIyrf.setDoOutput(true);
			P6GsIyrf.setDoInput(true);
			P6GsIyrf.setUseCaches(false);
			P6GsIyrf.setAllowUserInteraction(false);
			P6GsIyrf.setRequestProperty("Content-type", "text/html;charset=UTF-8");
			if (P6GsIyrf.getResponseCode() == 200) {
				InputStream dUCHLv01 = P6GsIyrf.getInputStream();
				BufferedReader d0u2NVh2 = null;
				try {
					d0u2NVh2 = new BufferedReader(new InputStreamReader(dUCHLv01, "UTF-8"));
					String iFvxER8Q = null;
					while ((iFvxER8Q = d0u2NVh2.readLine()) != null) {
						ExchangeRate KaOdWfNS = ParseYahooData(iFvxER8Q);
						if (KaOdWfNS != null)
							EDxRuJPv.add(KaOdWfNS);
					}
				} finally {
					if (d0u2NVh2 != null)
						try {
							d0u2NVh2.close();
						} catch (Exception WUjghoe4) {
						}
					if (dUCHLv01 != null)
						try {
							dUCHLv01.close();
						} catch (Exception ZdGxWBXA) {
						}
				}
				return EDxRuJPv;
			}
		} finally {
			if (P6GsIyrf != null)
				try {
					P6GsIyrf.disconnect();
				} catch (Exception ceDiA8KH) {
				}
		}
		return null;
	}

}