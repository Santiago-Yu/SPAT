class n7518607 {
	private ArrayList<String> getFiles(String AxUSuplV) {
		ArrayList<String> Yw6y4wUV = new ArrayList<String>();
		String gxKWoozg = "";
		try {
			obtainServerFilesView.setLblProcessText(java.util.ResourceBundle.getBundle("bgpanalyzer/resources/Bundle")
					.getString("ObtainServerFilesView.Label.Progress.Obtaining_Data"));
			URL n57UBmqa = new URL(URL_ROUTE_VIEWS + AxUSuplV + "/");
			URLConnection hK45MTDp = n57UBmqa.openConnection();
			hK45MTDp.setDoOutput(false);
			BufferedReader y8WTJDuo = new BufferedReader(new InputStreamReader(hK45MTDp.getInputStream()));
			String uBi5UzPC;
			while ((uBi5UzPC = y8WTJDuo.readLine()) != null) {
				if (!uBi5UzPC.equals(""))
					gxKWoozg += uBi5UzPC + "%";
			}
			obtainServerFilesView.setLblProcessText(java.util.ResourceBundle.getBundle("bgpanalyzer/resources/Bundle")
					.getString("ObtainServerFilesView.Label.Progress.Processing_Data"));
			gxKWoozg = Patterns.removeTags(gxKWoozg);
			StringTokenizer KQhtYLzb = new StringTokenizer(gxKWoozg, "%");
			gxKWoozg = "";
			boolean KgVpg8Hd = false;
			int EJDcD3ko = 1;
			while (KQhtYLzb.hasMoreTokens()) {
				String ADwoSGaR = KQhtYLzb.nextToken();
				if (!ADwoSGaR.trim().equals("")) {
					int NwN1Q8k4 = ADwoSGaR.indexOf(".bz2");
					if (NwN1Q8k4 != -1) {
						ADwoSGaR = ADwoSGaR.substring(1, NwN1Q8k4 + 4);
						Yw6y4wUV.add(ADwoSGaR);
					}
				}
			}
			y8WTJDuo.close();
		} catch (Exception xvmN9Hgj) {
			xvmN9Hgj.printStackTrace();
		}
		return Yw6y4wUV;
	}

}