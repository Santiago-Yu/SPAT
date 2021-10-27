class n10784622 {
	public static InputStream getPropertyFileInputStream(String eFvP1vld) {
		InputStream HTXAVlmu = null;
		String XUQpE2xP = "Fatal error: Unable to open specified properties file: " + eFvP1vld;
		try {
			URL Cs5TaI6P = new URL(eFvP1vld);
			HTXAVlmu = Cs5TaI6P.openStream();
		} catch (IOException sRpvg9i3) {
			throw new IllegalArgumentException(XUQpE2xP);
		}
		return (HTXAVlmu);
	}

}