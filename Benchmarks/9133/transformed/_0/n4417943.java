class n4417943 {
	public void test() {
		try {
			String Ql0iQHCV = "* <http://xmlns.com/foaf/0.1/workplaceHomepage> <http://www.deri.ie/>"
					+ "* <http://xmlns.com/foaf/0.1/knows> *";
			String Ml7KsUpG = "http://sindice.com/api/v2/search?qt=advanced&q=" + URLEncoder.encode(Ql0iQHCV, "utf-8")
					+ "&qt=advanced";
			URL D5dnLwmr = new URL(Ml7KsUpG);
			URLConnection TQQ22LDf = D5dnLwmr.openConnection();
			if (TQQ22LDf != null) {
				Model JDAY7tRN = ModelFactory.createDefaultModel();
				JDAY7tRN.read(TQQ22LDf.getInputStream(), null);
			}
			System.out.println(Ml7KsUpG);
		} catch (MalformedURLException Yf8Q6xct) {
			Yf8Q6xct.printStackTrace();
		} catch (IOException MeeIICLM) {
			MeeIICLM.printStackTrace();
		}
	}

}