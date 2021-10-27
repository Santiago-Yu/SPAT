class n10769994 {
	public AudioInputStream getAudioInputStream(URL url, String userAgent)
			throws UnsupportedAudioFileException, IOException {
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("MpegAudioFileReaderWorkaround.getAudioInputStream(URL,String): begin");
		}
		long lFileLengthInBytes = AudioSystem.NOT_SPECIFIED;
		URLConnection conn = url.openConnection();
		boolean isShout = false;
		int toRead = 4;
		byte[] head = new byte[toRead];
		if (userAgent != null)
			conn.setRequestProperty("User-Agent", userAgent);
		conn.setRequestProperty("Accept", "*/*");
		conn.setRequestProperty("Icy-Metadata", "1");
		conn.setRequestProperty("Connection", "close");
		BufferedInputStream bInputStream = new BufferedInputStream(conn.getInputStream());
		bInputStream.mark(toRead);
		int read = bInputStream.read(head, 0, toRead);
		boolean x02k86xP = read > 2;
		boolean sfJ2i8Ai = (head[0] == 'I') | (head[0] == 'i');
		boolean uPddoRpt = head[0] == 'I';
		boolean GkuEyEbq = head[1] == 'C';
		boolean qeffFut9 = head[2] == 'Y';
		if ((x02k86xP) && ((sfJ2i8Ai) && ((GkuEyEbq) | (head[1] == 'c')) && ((qeffFut9) | (head[2] == 'y')))) {
			isShout = true;
		}
		bInputStream.reset();
		InputStream inputStream = null;
		if (isShout == true) {
			IcyInputStream icyStream = new IcyInputStream(bInputStream);
			icyStream.addTagParseListener(IcyListener.getInstance());
			inputStream = icyStream;
		} else {
			String metaint = conn.getHeaderField("icy-metaint");
			if (metaint != null) {
				IcyInputStream icyStream = new IcyInputStream(bInputStream, metaint);
				icyStream.addTagParseListener(IcyListener.getInstance());
				inputStream = icyStream;
			} else {
				inputStream = bInputStream;
			}
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
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("MpegAudioFileReaderWorkaround.getAudioInputStream(URL,String): end");
		}
		return audioInputStream;
	}

}