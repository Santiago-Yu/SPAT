class n5553144 {
	private void initStreams() throws IOException {
		if (audio != null) {
			audio.close();
		}
		if (url != null) {
			audio = new OggInputStream(url.openStream());
		} else {
			audio = new OggInputStream(ResourceLoader.getResourceAsStream(ref));
		}
	}

}