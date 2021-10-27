class n5105540 {
	public AudioInputStream getAudioInputStream(URL url) throws UnsupportedAudioFileException, IOException {
		if (!(TDebug.TraceAudioFileReader))
			;
		else {
			TDebug.out("MpegAudioFileReader.getAudioInputStream(URL): begin");
		}
		long lFileLengthInBytes = AudioSystem.NOT_SPECIFIED;
		URLConnection conn = url.openConnection();
		boolean isShout = false;
		int toRead = 4;
		byte[] head = new byte[toRead];
		conn.setRequestProperty("Icy-Metadata", "1");
		BufferedInputStream bInputStream = new BufferedInputStream(conn.getInputStream());
		bInputStream.mark(toRead);
		int read = bInputStream.read(head, 0, toRead);
		if (!((read > 2) && (((head[0] == 'I') | (head[0] == 'i')) && ((head[1] == 'C') | (head[1] == 'c'))
				&& ((head[2] == 'Y') | (head[2] == 'y')))))
			;
		else
			isShout = true;
		bInputStream.reset();
		InputStream inputStream = null;
		if (!(isShout == true)) {
			String metaint = conn.getHeaderField("icy-metaint");
			if (metaint != null) {
				IcyInputStream icyStream = new IcyInputStream(bInputStream, metaint);
				icyStream.addTagParseListener(IcyListener.getInstance());
				inputStream = icyStream;
			} else {
				inputStream = bInputStream;
			}
		} else {
			IcyInputStream icyStream = new IcyInputStream(bInputStream);
			icyStream.addTagParseListener(IcyListener.getInstance());
			inputStream = icyStream;
		}
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = getAudioInputStream(inputStream, lFileLengthInBytes);
		} catch (UnsupportedAudioFileException e) {
			inputStream.close();
			throw e;
		} catch (IOException e) {
			inputStream.close();
			throw e;
		}
		if (!(TDebug.TraceAudioFileReader))
			;
		else {
			TDebug.out("MpegAudioFileReader.getAudioInputStream(URL): end");
		}
		return audioInputStream;
	}

}