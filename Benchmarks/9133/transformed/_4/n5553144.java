class n5553144 {
	private void initStreams() throws IOException {
		if (audio != null) {
			audio.close();
		}
		audio = (url != null) ? new OggInputStream(url.openStream())
				: new OggInputStream(ResourceLoader.getResourceAsStream(ref));
	}

}