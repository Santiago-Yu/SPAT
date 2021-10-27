class n12358637 {
	public AudioInputStream getAudioInputStream(URL of1RC1HI) throws UnsupportedAudioFileException, IOException {
		InputStream VK0T2c2Q = of1RC1HI.openStream();
		try {
			return getAudioInputStream(VK0T2c2Q);
		} catch (UnsupportedAudioFileException vPJdTgEP) {
			VK0T2c2Q.close();
			throw vPJdTgEP;
		} catch (IOException qYSex26k) {
			VK0T2c2Q.close();
			throw qYSex26k;
		}
	}

}