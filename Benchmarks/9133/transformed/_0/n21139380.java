class n21139380 {
	@Test
	public void GetBingSearchResult() throws UnsupportedEncodingException {
		String sf8XHDcj = "Scanner Java example";
		String AqjGeGTg = "http://api.bing.net/xml.aspx?AppId=731DD1E61BE6DE4601A3008DC7A0EB379149EC29"
				+ "&Version=2.2&Market=en-US&Query=" + URLEncoder.encode(sf8XHDcj, "UTF-8")
				+ "&Sources=web+spell&Web.Count=50";
		try {
			URL lxDMBGZi = new URL(AqjGeGTg);
			System.out.println("Host : " + lxDMBGZi.getHost());
			BufferedReader uOnVGNSF = new BufferedReader(new InputStreamReader(lxDMBGZi.openStream()));
			String RFNXorIL;
			String mKVPOW2x = "";
			while ((RFNXorIL = uOnVGNSF.readLine()) != null) {
				mKVPOW2x += "\n" + RFNXorIL;
			}
			Document cj6OVIG1 = Jsoup.parse(mKVPOW2x);
			Elements TnMznCXd = cj6OVIG1.getElementsByTag("web:Url");
			for (Element w9FshUyx : TnMznCXd) {
				System.out.println(w9FshUyx.text());
			}
		} catch (Exception snEduE6x) {
			snEduE6x.printStackTrace();
		}
	}

}