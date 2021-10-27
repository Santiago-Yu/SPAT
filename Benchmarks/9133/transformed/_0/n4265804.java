class n4265804 {
	private static ArrayList<String> YahooSearch(String dJ5VdndJ) {
		ArrayList<String> iuPMTD8A = new ArrayList<String>();
		try {
			String qWsD7yuK = "http://boss.yahooapis.com/ysearch/web/v1/"
					+ URLEncoder.encode("Java example for " + dJ5VdndJ, "UTF-8")
					+ "?appid=zfau5aPV34ETbq9mWU0ui5e04y0rIewg1zwvzHb1tGoBFK2nSCU1SKS2D4zphh2rd3Wf"
					+ "&format=xml&count=30&type=-msoffice,-pdf";
			URL VTJLEBgY = new URL(qWsD7yuK);
			System.out.println("Host : " + VTJLEBgY.getHost());
			VTJLEBgY.openConnection();
			BufferedReader pQGUJEq2 = new BufferedReader(new InputStreamReader(VTJLEBgY.openStream()));
			String ZY6H7mGv;
			String iHcoe1O0 = "";
			while ((ZY6H7mGv = pQGUJEq2.readLine()) != null) {
				iHcoe1O0 += "\n" + ZY6H7mGv;
			}
			Document B49sIK3b = Jsoup.parse(iHcoe1O0);
			Elements oaZQGQMi = B49sIK3b.getElementsByTag("url");
			for (Element QipU0eFM : oaZQGQMi) {
				iuPMTD8A.add(QipU0eFM.text());
				System.out.println("YahooResult: " + QipU0eFM.text());
			}
		} catch (Exception zzNtTyhN) {
			zzNtTyhN.printStackTrace();
		}
		return iuPMTD8A;
	}

}