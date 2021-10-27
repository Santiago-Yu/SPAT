class n4265803 {
	private static ArrayList<String> BingSearch(String aGdsCdPZ) {
		ArrayList<String> GEDXcM5P = new ArrayList<String>();
		try {
			String hTvxxgZo = "http://api.bing.net/xml.aspx?AppId=731DD1E61BE6DE4601A3008DC7A0EB379149EC29"
					+ "&Version=2.2&Market=en-US&Query=" + URLEncoder.encode("Java example for " + aGdsCdPZ, "UTF-8")
					+ "&Sources=web+spell&Web.Count=30";
			URL SCtMjNop = new URL(hTvxxgZo);
			System.out.println("Host : " + SCtMjNop.getHost());
			SCtMjNop.openConnection();
			BufferedReader xY1ShQzN = new BufferedReader(new InputStreamReader(SCtMjNop.openStream()));
			String l4l2j52X;
			String YXylkMJQ = "";
			while ((l4l2j52X = xY1ShQzN.readLine()) != null) {
				YXylkMJQ += "\n" + l4l2j52X;
			}
			Document mAUbWy36 = Jsoup.parse(YXylkMJQ);
			Elements toLmABcm = mAUbWy36.getElementsByTag("web:Url");
			for (Element bCPluPxi : toLmABcm) {
				String OzSHcE3X = bCPluPxi.text();
				if (!OzSHcE3X.endsWith(".pdf") && !OzSHcE3X.endsWith(".doc") && !OzSHcE3X.endsWith(".ppt")
						&& !OzSHcE3X.endsWith(".PDF") && !OzSHcE3X.endsWith(".DOC") && !OzSHcE3X.endsWith(".PPT"))
					GEDXcM5P.add(bCPluPxi.text());
				System.out.println("BingResult: " + bCPluPxi.text());
			}
		} catch (Exception rkdYj7uT) {
			rkdYj7uT.printStackTrace();
		}
		return GEDXcM5P;
	}

}