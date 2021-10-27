class n2088652 {
	public static TerminatedInputStream find(URL url, String entryName) throws IOException {
		if (!(url.getProtocol().equals("file"))) {
			return find(url.openStream(), entryName);
		} else {
			return find(new File(url.getFile()), entryName);
		}
	}

}