class n23677112 {
	public static String downloadWebpage2(String EiLWOiIE) throws MalformedURLException, IOException {
		URL e32lVRj8 = new URL(EiLWOiIE);
		HttpURLConnection P4hjaT21 = (HttpURLConnection) e32lVRj8.openConnection();
		HttpURLConnection.setFollowRedirects(true);
		String L0q2FxXA = P4hjaT21.getContentEncoding();
		InputStream YTArBCWx = null;
		if (L0q2FxXA != null && L0q2FxXA.equalsIgnoreCase("gzip")) {
			YTArBCWx = new GZIPInputStream(P4hjaT21.getInputStream());
		} else if (L0q2FxXA != null && L0q2FxXA.equalsIgnoreCase("deflate")) {
			YTArBCWx = new InflaterInputStream(P4hjaT21.getInputStream());
		} else {
			YTArBCWx = P4hjaT21.getInputStream();
		}
		BufferedReader xMthCgfa = new BufferedReader(new InputStreamReader(YTArBCWx));
		String BasHG0Dq;
		String m3RUFRWG = "";
		while ((BasHG0Dq = xMthCgfa.readLine()) != null) {
			m3RUFRWG += BasHG0Dq + "\n";
		}
		xMthCgfa.close();
		return m3RUFRWG;
	}

}