class n14757691 {
	protected String getCitations(String eRaCHxPa, String E6isqJJm) throws IOException {
		String rfJc71Vr;
		try {
			rfJc71Vr = "http://www.jstor.org/search/BasicResults?hp=" + MAX_CITATIONS
					+ "&si=1&gw=jtx&jtxsi=1&jcpsi=1&artsi=1&Query=" + URLEncoder.encode(E6isqJJm, "UTF-8")
					+ "&wc=on&citationAction=saveAll";
		} catch (UnsupportedEncodingException j8DXLeTm) {
			throw new RuntimeException(j8DXLeTm);
		}
		URL QqRdjft8 = new URL(rfJc71Vr);
		URLConnection pjmk8v3F = QqRdjft8.openConnection();
		pjmk8v3F.setRequestProperty("Cookie", eRaCHxPa);
		return getCookie(COOKIE_CITATIONS, pjmk8v3F);
	}

}