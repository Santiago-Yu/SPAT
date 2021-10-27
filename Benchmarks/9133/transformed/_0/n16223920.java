class n16223920 {
	public AudioFileFormat getAudioFileFormat(URL Sjf4tNLA) throws UnsupportedAudioFileException, IOException {
		InputStream OnIshFd4 = Sjf4tNLA.openStream();
		AudioFileFormat IhrxdhUF = null;
		try {
			IhrxdhUF = getFMT(OnIshFd4, false);
		} finally {
			OnIshFd4.close();
		}
		return IhrxdhUF;
	}

}