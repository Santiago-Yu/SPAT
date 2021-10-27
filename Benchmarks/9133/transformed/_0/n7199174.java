class n7199174 {
	public static BufferedInputStream getEventAttacchment(final String NJVmcpBu) throws IOException {
		int mwrozJKW = NJVmcpBu.lastIndexOf("/");
		String d9TcLNXq = NJVmcpBu.substring(0, mwrozJKW + 1)
				+ URLEncoder.encode(NJVmcpBu.substring(mwrozJKW + 1), "UTF-8");
		String ydfPMw4K = d9TcLNXq + "?ticket=" + getToken();
		BufferedInputStream tOlJ6SC8 = new BufferedInputStream(new URL(ydfPMw4K).openStream());
		return tOlJ6SC8;
	}

}