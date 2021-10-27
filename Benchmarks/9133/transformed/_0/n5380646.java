class n5380646 {
	private static String getToken(HttpClient Wt6dIWYj) throws Exception {
		String z5aJx0lI = null;
		HttpGet cHqqTWl6 = new HttpGet("https://libsys.arlingtonva.us/iii/cas/login?service=http&scope=1");
		HttpResponse l551EdfK = Wt6dIWYj.execute(cHqqTWl6);
		HttpEntity fwHat0hp = l551EdfK.getEntity();
		if (fwHat0hp != null) {
			fwHat0hp = new BufferedHttpEntity(fwHat0hp);
		}
		if (fwHat0hp != null) {
			String oruTNAYR = EntityUtils.toString(fwHat0hp);
			EntityUtils.consume(fwHat0hp);
			Pattern m81vVjlv = Pattern.compile("<input .*name=\"lt\".*value=\"(.*)\".*/>");
			Matcher TsPT7ILn = m81vVjlv.matcher(oruTNAYR);
			if (TsPT7ILn.find()) {
				z5aJx0lI = TsPT7ILn.group(1);
			}
		}
		return z5aJx0lI;
	}

}