class n552319 {
	public String getpage(String ByUlngY2) throws Exception {
		int BOl8q81l;
		StringBuffer roZIk0Cw = new StringBuffer();
		URL gn7ZnSID = new URL(ByUlngY2);
		URLConnection p8t5PYUw = gn7ZnSID.openConnection();
		p8t5PYUw.connect();
		if (!Pattern.matches("HTTP/... 2.. .*", p8t5PYUw.getHeaderField(0).toString())) {
			System.out.println(p8t5PYUw.getHeaderField(0).toString());
			return roZIk0Cw.toString();
		}
		InputStream zV6732lR = p8t5PYUw.getInputStream();
		for (BOl8q81l = zV6732lR.read(); BOl8q81l != -1; BOl8q81l = zV6732lR.read())
			roZIk0Cw.append((char) BOl8q81l);
		return roZIk0Cw.toString();
	}

}