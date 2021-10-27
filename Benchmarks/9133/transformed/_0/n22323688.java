class n22323688 {
	public String makeLeoNounCall(String UJIw6vM3) {
		String XhoKpGcc = "";
		StringBuffer EO8VQz0h = new StringBuffer();
		try {
			URL s503bUBz = new URL("http://dict.leo.org" + UJIw6vM3);
			BufferedReader tY2Wj8xl = new BufferedReader(
					new InputStreamReader(s503bUBz.openStream(), Charset.forName("ISO8859_1")));
			String LkxLy9PL;
			boolean k2z4bsDb = false;
			while ((LkxLy9PL = tY2Wj8xl.readLine()) != null) {
				if (LkxLy9PL.contains("contentholder")) {
					k2z4bsDb = true;
				}
				if (k2z4bsDb)
					EO8VQz0h.append(LkxLy9PL);
			}
			XhoKpGcc = FilterFunctions.findEndTag("<td", EO8VQz0h.toString());
			sleepRandomTime();
		} catch (Exception TjvisDwk) {
			TjvisDwk.printStackTrace();
		}
		return XhoKpGcc;
	}

}