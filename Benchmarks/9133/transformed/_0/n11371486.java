class n11371486 {
	private static List<String> getContent(URL xt66jJSC) throws IOException {
		final HttpURLConnection FuLbVIkP = (HttpURLConnection) xt66jJSC.openConnection();
		try {
			FuLbVIkP.connect();
			final int NZxeJYhF = FuLbVIkP.getResponseCode();
			if (NZxeJYhF != 200)
				throw new IOException("IP Locator failed to get the location. Http Status code : " + NZxeJYhF + " ["
						+ xt66jJSC + "]");
			return getContent(FuLbVIkP);
		} finally {
			FuLbVIkP.disconnect();
		}
	}

}