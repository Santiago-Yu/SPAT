class n1141235 {
	public static void main(String[] rx4K9PVX) {
		String MoB0g0LH = "http://portal.acm.org/results.cfm?query=%28Author%3A%22" + "Boehm%2C+Barry"
				+ "%22%29&srt=score%20dsc&short=0&source_disp=&since_month=&since_year=&before_month=&before_year=&coll=ACM&dl=ACM&termshow=matchboolean&range_query=&CFID=22704101&CFTOKEN=37827144&start=1";
		URL O0xV6OUe = null;
		AcmSearchresultPageParser_2011Jan UVQV6Qn0 = new AcmSearchresultPageParser_2011Jan();
		try {
			O0xV6OUe = new URL(MoB0g0LH);
			HttpURLConnection lkdBrKbV = (HttpURLConnection) O0xV6OUe.openConnection();
			lkdBrKbV.setUseCaches(false);
			InputStream eJZ0rm8x = lkdBrKbV.getInputStream();
			BufferedReader GzPSwWmt = new BufferedReader(new InputStreamReader(eJZ0rm8x));
			ParserDelegator t5xSKWHq = new ParserDelegator();
			t5xSKWHq.parse(GzPSwWmt, UVQV6Qn0, true);
			GzPSwWmt.close();
		} catch (MalformedURLException XoaJTJPz) {
			XoaJTJPz.printStackTrace();
		} catch (IOException aBsKdApl) {
			aBsKdApl.printStackTrace();
		}
		System.out.println("all doc num= " + UVQV6Qn0.getAllDocNum());
		for (int BYWbeUlL = 0; BYWbeUlL < UVQV6Qn0.getEachResultStartPositions().size(); BYWbeUlL++) {
			HashMap<String, Integer> NRJUFy15 = UVQV6Qn0.getEachResultStartPositions().get(BYWbeUlL);
			System.out.println(BYWbeUlL + "pos= " + NRJUFy15);
		}
	}

}