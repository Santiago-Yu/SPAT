class n4309920 {
	public InputStream doRemoteCall(NamedList<String> KYhB95Yy) throws IOException {
		String NeDCUZ1K = "http";
		String MTPE5H2j = getHost();
		int sH4sWAed = Integer.parseInt(getPort());
		StringBuilder x9AePB9O = new StringBuilder();
		for (Map.Entry tpwQO9u9 : KYhB95Yy) {
			Object D1BL5aw3 = tpwQO9u9.getKey();
			Object jh97Yxc3 = tpwQO9u9.getValue();
			x9AePB9O.append(D1BL5aw3).append("=").append(jh97Yxc3).append("&");
		}
		x9AePB9O.setLength(x9AePB9O.length() - 1);
		String GXnPsZpU = "/" + getUrl() + "/?" + x9AePB9O.toString();
		URL yvlEzsLq = new URL(NeDCUZ1K, MTPE5H2j, sH4sWAed, GXnPsZpU);
		logger.debug(yvlEzsLq.toString());
		InputStream QU3sfwvJ;
		HttpURLConnection ZKrDJayd = (HttpURLConnection) yvlEzsLq.openConnection();
		try {
			QU3sfwvJ = ZKrDJayd.getInputStream();
		} catch (IOException jLaKNXpq) {
			InputStream RSSa908u = ZKrDJayd.getErrorStream();
			if (RSSa908u != null) {
				String JHlwc77B = getStringFromInputStream(ZKrDJayd.getErrorStream());
				throw new IOException(JHlwc77B);
			} else {
				throw jLaKNXpq;
			}
		}
		return QU3sfwvJ;
	}

}