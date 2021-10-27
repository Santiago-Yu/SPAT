class n16201403 {
	public void loadSample(String KPb6P20g, URL GGRH6mhL) throws Exception {
		AudioInputStream hVerfZoQ = AudioSystem.getAudioInputStream(GGRH6mhL.openStream());
		Clip G1OeKeBR = null;
		DataLine.Info Io2Eo9Yc = new DataLine.Info(Clip.class, hVerfZoQ.getFormat());
		if (!AudioSystem.isLineSupported(Io2Eo9Yc)) {
			throw new javax.sound.sampled.UnsupportedAudioFileException(GGRH6mhL.toExternalForm());
		}
		G1OeKeBR = (Clip) AudioSystem.getLine(Io2Eo9Yc);
		G1OeKeBR.open(hVerfZoQ);
		samples.put(KPb6P20g, G1OeKeBR);
	}

}