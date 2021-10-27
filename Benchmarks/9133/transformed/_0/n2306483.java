class n2306483 {
	private InputStream getConnection(final String NFPUgyxH) {
		InputStream GRm2rzqY = null;
		try {
			final URLConnection SAVY3Ge2 = new URL(NFPUgyxH).openConnection();
			GRm2rzqY = SAVY3Ge2.getInputStream();
		} catch (final MalformedURLException xA4bw5s2) {
			xA4bw5s2.printStackTrace();
		} catch (final IOException KIiZR219) {
			KIiZR219.printStackTrace();
		}
		return GRm2rzqY;
	}

}