class n13329811 {
	@Deprecated
	public void test() {
		try {
			String BKqYkIlZ = "* <http://xmlns.com/foaf/0.1/workplaceHomepage> <http://www.deri.ie/>"
					+ "* <http://xmlns.com/foaf/0.1/knows> *";
			String pKSv2bFr = "http://sindice.com/api/v2/search?qt=advanced&q=" + URLEncoder.encode(BKqYkIlZ, "utf-8")
					+ "&qt=advanced";
			URL JzK3RA1t = new URL(pKSv2bFr);
			URLConnection tUrhXz97 = JzK3RA1t.openConnection();
			if (tUrhXz97 != null) {
				Model Tv7ndYGI = ModelFactory.createDefaultModel();
				Tv7ndYGI.read(tUrhXz97.getInputStream(), null);
			}
			System.out.println(pKSv2bFr);
		} catch (MalformedURLException n8iCiW2g) {
			n8iCiW2g.printStackTrace();
		} catch (IOException HatNnLFl) {
			HatNnLFl.printStackTrace();
		}
	}

}