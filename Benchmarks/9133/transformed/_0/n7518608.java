class n7518608 {
	private ArrayList<String> getYearsAndMonths() {
		String ZV3fA8gu = "";
		ArrayList<String> mZHopXZd = new ArrayList<String>();
		try {
			obtainServerFilesView.setLblProcessText(java.util.ResourceBundle.getBundle("bgpanalyzer/resources/Bundle")
					.getString("ObtainServerFilesView.Label.Progress.Obtaining_Data"));
			URL cM4jDeO0 = new URL(URL_ROUTE_VIEWS);
			URLConnection c9WbGFoY = cM4jDeO0.openConnection();
			c9WbGFoY.setDoOutput(false);
			BufferedReader tEYOYzqw = new BufferedReader(new InputStreamReader(c9WbGFoY.getInputStream()));
			String A23jINpL;
			while ((A23jINpL = tEYOYzqw.readLine()) != null) {
				if (!A23jINpL.equals(""))
					ZV3fA8gu += A23jINpL + "%";
			}
			obtainServerFilesView.setLblProcessText(java.util.ResourceBundle.getBundle("bgpanalyzer/resources/Bundle")
					.getString("ObtainServerFilesView.Label.Progress.Processing_Data"));
			ZV3fA8gu = Patterns.removeTags(ZV3fA8gu);
			StringTokenizer jnAMnNSp = new StringTokenizer(ZV3fA8gu, "%");
			ZV3fA8gu = "";
			boolean osMwBQsN = false;
			int KdTvcKQg = 1;
			while (jnAMnNSp.hasMoreTokens()) {
				String NU3cXrFp = jnAMnNSp.nextToken();
				if (!NU3cXrFp.trim().equals("")) {
					int QjN3K85p = NU3cXrFp.indexOf("/");
					if (QjN3K85p != -1) {
						NU3cXrFp = NU3cXrFp.substring(1, QjN3K85p);
						if (Patterns.hasFormatYYYYdotMM(NU3cXrFp)) {
							mZHopXZd.add(NU3cXrFp);
						}
					}
				}
			}
			tEYOYzqw.close();
		} catch (Exception YvdWBLkY) {
			YvdWBLkY.printStackTrace();
		}
		return mZHopXZd;
	}

}