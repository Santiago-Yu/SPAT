class n21644801 {
	private URLConnection openPostConnection(StringBuffer PTeiDZOU)
			throws IOException, IOException, MalformedURLException {
		URL oUeWtVQK = new URL(m_gatewayAddress);
		URLConnection zjQmH6Aa = oUeWtVQK.openConnection();
		zjQmH6Aa.setDoOutput(true);
		zjQmH6Aa.setUseCaches(false);
		OutputStreamWriter ehkbd2lq = new OutputStreamWriter(zjQmH6Aa.getOutputStream());
		ehkbd2lq.write(PTeiDZOU.toString());
		ehkbd2lq.flush();
		ehkbd2lq.close();
		return zjQmH6Aa;
	}

}