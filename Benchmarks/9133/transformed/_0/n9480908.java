class n9480908 {
	public Vector Get() throws Exception {
		String Sl3DnwxU = BuildYahooQueryString();
		if (Sl3DnwxU == null)
			return null;
		Vector HCzsDJfz = new Vector();
		HttpURLConnection jXbyTzzh = null;
		try {
			URL g2Sihkl4 = new URL(URL_YAHOO_QUOTE + "?" + Sl3DnwxU + "&" + FORMAT);
			jXbyTzzh = (HttpURLConnection) g2Sihkl4.openConnection();
			jXbyTzzh.setRequestMethod("GET");
			jXbyTzzh.setDoOutput(true);
			jXbyTzzh.setDoInput(true);
			jXbyTzzh.setUseCaches(false);
			jXbyTzzh.setAllowUserInteraction(false);
			jXbyTzzh.setRequestProperty("Content-type", "text/html;charset=UTF-8");
			if (jXbyTzzh.getResponseCode() == 200) {
				InputStream bkzMJwbB = jXbyTzzh.getInputStream();
				BufferedReader qv5GzulT = null;
				try {
					qv5GzulT = new BufferedReader(new InputStreamReader(bkzMJwbB, "UTF-8"));
					String JwAoIicB = null;
					while ((JwAoIicB = qv5GzulT.readLine()) != null) {
						ExchangeRate GZh12AkP = ParseYahooData(JwAoIicB);
						if (GZh12AkP != null)
							HCzsDJfz.add(GZh12AkP);
					}
				} finally {
					if (qv5GzulT != null)
						try {
							qv5GzulT.close();
						} catch (Exception X3oiPlYh) {
						}
					if (bkzMJwbB != null)
						try {
							bkzMJwbB.close();
						} catch (Exception VswoAXSo) {
						}
				}
				return HCzsDJfz;
			}
		} finally {
			if (jXbyTzzh != null)
				try {
					jXbyTzzh.disconnect();
				} catch (Exception OgoiXm48) {
				}
		}
		return null;
	}

}