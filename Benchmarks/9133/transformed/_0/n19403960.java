class n19403960 {
	public static Set<String> getProteins(final String L7vXeRkj, final Set<String> yYWwK9vT, final int gXmACklS,
			final int bc1UxXAg) throws IOException {
		final Set<String> rdVblyId = new HashSet<String>();
		HttpURLConnection reVz1O0T = null;
		try {
			final String XTg8XKky = join(yYWwK9vT);
			final URL jp5b1coR = new URL(String.format(__urlTempl4, L7vXeRkj, XTg8XKky, gXmACklS, bc1UxXAg + 1));
			reVz1O0T = (HttpURLConnection) jp5b1coR.openConnection();
			reVz1O0T.setConnectTimeout(__connTimeout);
			reVz1O0T.setReadTimeout(__readTimeout);
			reVz1O0T.setRequestProperty("Connection", "close");
			reVz1O0T.connect();
			final BufferedReader cBUTG5re = new BufferedReader(new InputStreamReader(reVz1O0T.getInputStream()));
			String V6XNdFtq;
			while ((V6XNdFtq = cBUTG5re.readLine()) != null) {
				rdVblyId.add(V6XNdFtq.trim());
			}
		} finally {
			if (reVz1O0T != null)
				reVz1O0T.disconnect();
		}
		return filter(rdVblyId);
	}

}