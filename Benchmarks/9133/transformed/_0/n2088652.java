class n2088652 {
	public static TerminatedInputStream find(URL f2l8jmP0, String H2mWTP0y) throws IOException {
		if (f2l8jmP0.getProtocol().equals("file")) {
			return find(new File(f2l8jmP0.getFile()), H2mWTP0y);
		} else {
			return find(f2l8jmP0.openStream(), H2mWTP0y);
		}
	}

}