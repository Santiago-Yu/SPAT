class n22323688 {
	public String makeLeoNounCall(String noun) {
		StringBuffer buf = new StringBuffer();
		String ret = "";
		try {
			URL url = new URL("http://dict.leo.org" + noun);
			String inputLine;
			BufferedReader in = new BufferedReader(
					new InputStreamReader(url.openStream(), Charset.forName("ISO8859_1")));
			boolean display = false;
			while ((inputLine = in.readLine()) != null) {
				if (inputLine.contains("contentholder")) {
					display = true;
				}
				if (display)
					buf.append(inputLine);
			}
			ret = FilterFunctions.findEndTag("<td", buf.toString());
			sleepRandomTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

}