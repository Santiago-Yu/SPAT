class n15241397 {
	@Override
	protected void doGet(HttpServletRequest EQhExR5j, HttpServletResponse EX0mECM6)
			throws ServletException, IOException {
		String CTcxe2EK = URLDecoder.decode(EQhExR5j.getRequestURI(), "UTF-8").replaceFirst("^.*?\\/(id:.*)\\/.*?$",
				"$1");
		logger.debug("rewrittenQueryString: " + CTcxe2EK);
		URL eKfV1L8t = new URL(fedoraUrl + CTcxe2EK);
		logger.debug("rewrittenUrl: " + eKfV1L8t.getProtocol() + "://" + eKfV1L8t.getHost() + ":" + eKfV1L8t.getPort()
				+ eKfV1L8t.getFile());
		HttpURLConnection lbVAZkU8 = (HttpURLConnection) eKfV1L8t.openConnection();
		HttpURLConnection.setFollowRedirects(false);
		lbVAZkU8.connect();
		EX0mECM6.setStatus(lbVAZkU8.getResponseCode());
		logger.debug("[status=" + lbVAZkU8.getResponseCode() + "]");
		logger.debug("[headers]");
		for (Entry<String, List<String>> U4U5ya9n : lbVAZkU8.getHeaderFields().entrySet()) {
			if (U4U5ya9n.getKey() != null) {
				for (String iiAVgEeC : U4U5ya9n.getValue()) {
					if (iiAVgEeC != null) {
						logger.debug(U4U5ya9n.getKey() + ": " + iiAVgEeC);
						if (!U4U5ya9n.getKey().equals("Server") && !U4U5ya9n.getKey().equals("Transfer-Encoding")) {
							EX0mECM6.addHeader(U4U5ya9n.getKey(), iiAVgEeC);
						}
					}
				}
			}
		}
		logger.debug("[/headers]");
		InputStream sNACbzDK = lbVAZkU8.getInputStream();
		OutputStream Syqt3MzX = EX0mECM6.getOutputStream();
		IOUtils.copy(sNACbzDK, Syqt3MzX);
	}

}