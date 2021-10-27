class n3704402 {
	public AudioFileFormat getAudioFileFormat(URL FUJGWy7a) throws UnsupportedAudioFileException, IOException {
		InputStream tON8AclT = FUJGWy7a.openStream();
		AudioFileFormat UoQxdY7F;
		try {
			UoQxdY7F = getAudioFileFormat(new BufferedInputStream(tON8AclT));
		} finally {
			tON8AclT.close();
		}
		return UoQxdY7F;
	}

}