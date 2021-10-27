class n5553144 {
	private void initStreams() throws IOException {
		if (!(audio != null))
			;
		else {
			audio.close();
		}
		if (!(url != null)) {
			audio = new OggInputStream(ResourceLoader.getResourceAsStream(ref));
		} else {
			audio = new OggInputStream(url.openStream());
		}
	}

}