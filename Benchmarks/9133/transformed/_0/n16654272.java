class n16654272 {
	public AudioInputStream getAudioInputStream(URL K9kL13w3, String RjaGtfoj)
			throws UnsupportedAudioFileException, IOException {
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("MpegAudioFileReaderWorkaround.getAudioInputStream(URL,String): begin");
		}
		long kBoHJ6YA = AudioSystem.NOT_SPECIFIED;
		URLConnection ROWrh7kB = K9kL13w3.openConnection();
		boolean BYJWR7xj = false;
		int FG88rQYK = 4;
		byte[] C9REy9Gu = new byte[FG88rQYK];
		if (RjaGtfoj != null)
			ROWrh7kB.setRequestProperty("User-Agent", RjaGtfoj);
		ROWrh7kB.setRequestProperty("Accept", "*/*");
		ROWrh7kB.setRequestProperty("Icy-Metadata", "1");
		ROWrh7kB.setRequestProperty("Connection", "close");
		BufferedInputStream FC3Lvqw8 = new BufferedInputStream(ROWrh7kB.getInputStream());
		FC3Lvqw8.mark(FG88rQYK);
		int OaYavTfa = FC3Lvqw8.read(C9REy9Gu, 0, FG88rQYK);
		if ((OaYavTfa > 2) && (((C9REy9Gu[0] == 'I') | (C9REy9Gu[0] == 'i'))
				&& ((C9REy9Gu[1] == 'C') | (C9REy9Gu[1] == 'c')) && ((C9REy9Gu[2] == 'Y') | (C9REy9Gu[2] == 'y')))) {
			BYJWR7xj = true;
		}
		FC3Lvqw8.reset();
		InputStream KdIJa6Fu = null;
		if (BYJWR7xj == true) {
			IcyInputStream g0wBoz7Q = new IcyInputStream(FC3Lvqw8);
			g0wBoz7Q.addTagParseListener(IcyListener.getInstance());
			KdIJa6Fu = g0wBoz7Q;
		} else {
			String T4bVvfyG = ROWrh7kB.getHeaderField("icy-metaint");
			if (T4bVvfyG != null) {
				IcyInputStream QGiWQgyd = new IcyInputStream(FC3Lvqw8, T4bVvfyG);
				QGiWQgyd.addTagParseListener(IcyListener.getInstance());
				KdIJa6Fu = QGiWQgyd;
			} else {
				KdIJa6Fu = FC3Lvqw8;
			}
		}
		AudioInputStream p0veMF53 = null;
		try {
			p0veMF53 = getAudioInputStream(KdIJa6Fu, kBoHJ6YA);
		} catch (UnsupportedAudioFileException MsJ7gdhI) {
			KdIJa6Fu.close();
			throw MsJ7gdhI;
		} catch (IOException KbOZSPr5) {
			KdIJa6Fu.close();
			throw KbOZSPr5;
		}
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("MpegAudioFileReaderWorkaround.getAudioInputStream(URL,String): end");
		}
		return p0veMF53;
	}

}