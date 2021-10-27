class n2023117 {
	public static void main(String[] m3pBB9Gs) {
		String bbPQPNYg = "http://portal.acm.org/results.cfm?query=%28Author%3A%22" + "Boehm%2C+Barry"
				+ "%22%29&srt=score%20dsc&short=0&source_disp=&since_month=&since_year=&before_month=&before_year=&coll=ACM&dl=ACM&termshow=matchboolean&range_query=&CFID=22704101&CFTOKEN=37827144&start=1";
		URL HaXDF0if = null;
		AcmSearchresultPageParser_2008Apr GMxkl9rL = new AcmSearchresultPageParser_2008Apr();
		try {
			HaXDF0if = new URL(bbPQPNYg);
			HttpURLConnection RPG7xFv8 = (HttpURLConnection) HaXDF0if.openConnection();
			RPG7xFv8.setUseCaches(false);
			InputStream gZOaL9jP = RPG7xFv8.getInputStream();
			BufferedReader JcCOOAmA = new BufferedReader(new InputStreamReader(gZOaL9jP));
			ParserDelegator HDSBKZef = new ParserDelegator();
			HDSBKZef.parse(JcCOOAmA, GMxkl9rL, true);
			JcCOOAmA.close();
		} catch (MalformedURLException a8ri00LR) {
			a8ri00LR.printStackTrace();
		} catch (IOException vedoQtPz) {
			vedoQtPz.printStackTrace();
		}
		System.out.println("all doc num= " + GMxkl9rL.getAllDocNum());
		for (int l46JLPp2 = 0; l46JLPp2 < GMxkl9rL.getEachResultStartposisions().size(); l46JLPp2++) {
			HashMap<String, Integer> L8s6Ckm2 = GMxkl9rL.getEachResultStartposisions().get(l46JLPp2);
			System.out.println(l46JLPp2 + "pos= " + L8s6Ckm2);
		}
	}

}