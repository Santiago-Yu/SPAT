class n18157910 {
	private static ArrayList<String> YahooSearch(String weMsUdAG) {
		ArrayList<String> ipfxZ7nQ = new ArrayList<String>();
		try {
			String FJPMcFD2 = "http://boss.yahooapis.com/ysearch/web/v1/"
					+ URLEncoder.encode("Java example for " + weMsUdAG, "UTF-8")
					+ "?appid=zfau5aPV34ETbq9mWU0ui5e04y0rIewg1zwvzHb1tGoBFK2nSCU1SKS2D4zphh2rd3Wf"
					+ "&format=xml&count=30&type=-msoffice,-pdf";
			URL KprEy20C = new URL(FJPMcFD2);
			System.out.println("Host : " + KprEy20C.getHost());
			KprEy20C.openConnection();
			BufferedReader EWawDSgk = new BufferedReader(new InputStreamReader(KprEy20C.openStream()));
			String Prnl8t8h;
			String UYgWhrFE = "";
			while ((Prnl8t8h = EWawDSgk.readLine()) != null) {
				UYgWhrFE += "\n" + Prnl8t8h;
			}
			Document oUYZkQ2C = Jsoup.parse(UYgWhrFE);
			Elements aDeab2Ni = oUYZkQ2C.getElementsByTag("url");
			for (Element XGSja12F : aDeab2Ni) {
				ipfxZ7nQ.add(XGSja12F.text());
				System.out.println("YahooResult: " + XGSja12F.text());
			}
		} catch (Exception Ap8PHFyU) {
			Ap8PHFyU.printStackTrace();
		}
		return ipfxZ7nQ;
	}

}