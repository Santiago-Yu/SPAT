class n15718136 {
	protected URLConnection getConnection(String j5Yb50GH, String TUyLupL1) throws MalformedURLException, IOException {
		URL MbDT7top = new URL(j5Yb50GH);
		URLConnection jRapmwGP = MbDT7top.openConnection();
		jRapmwGP.setConnectTimeout((int) MINUTE / 2);
		jRapmwGP.setReadTimeout((int) MINUTE / 2);
		return jRapmwGP;
	}

}