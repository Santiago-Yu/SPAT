class n22415294 {
	private String getRenderedBody(String V10i49hR) throws Exception {
		log.entering(Rss2MailTask.class.getName(), "getRenderedBody");
		final URL EEIuQ7fL = new URL(V10i49hR);
		final HttpURLConnection AWD87jTs = (HttpURLConnection) EEIuQ7fL.openConnection();
		AWD87jTs.connect();
		final InputStream HhZfqn4V = AWD87jTs.getInputStream();
		final BufferedReader n1d5PGbv = new BufferedReader(new InputStreamReader(HhZfqn4V));
		String EUEcYDKl = "";
		final StringBuffer DXzCJ6Hs = new StringBuffer();
		while (EUEcYDKl != null) {
			EUEcYDKl = n1d5PGbv.readLine();
			if (EUEcYDKl != null) {
				DXzCJ6Hs.append(EUEcYDKl);
			}
		}
		log.exiting(Rss2MailTask.class.getName(), "getRenderedBody");
		return DXzCJ6Hs.toString();
	}

}