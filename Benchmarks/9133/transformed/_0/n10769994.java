class n10769994 {
	public AudioInputStream getAudioInputStream(URL CB2TXoLS, String YGz8r4fT)
			throws UnsupportedAudioFileException, IOException {
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("MpegAudioFileReaderWorkaround.getAudioInputStream(URL,String): begin");
		}
		long ZuCBuVTW = AudioSystem.NOT_SPECIFIED;
		URLConnection xSwgiWOm = CB2TXoLS.openConnection();
		boolean tgIZaxMK = false;
		int lEqQKnbK = 4;
		byte[] xKBT6Dmm = new byte[lEqQKnbK];
		if (YGz8r4fT != null)
			xSwgiWOm.setRequestProperty("User-Agent", YGz8r4fT);
		xSwgiWOm.setRequestProperty("Accept", "*/*");
		xSwgiWOm.setRequestProperty("Icy-Metadata", "1");
		xSwgiWOm.setRequestProperty("Connection", "close");
		BufferedInputStream kdZaRjkv = new BufferedInputStream(xSwgiWOm.getInputStream());
		kdZaRjkv.mark(lEqQKnbK);
		int BU810M2L = kdZaRjkv.read(xKBT6Dmm, 0, lEqQKnbK);
		if ((BU810M2L > 2) && (((xKBT6Dmm[0] == 'I') | (xKBT6Dmm[0] == 'i'))
				&& ((xKBT6Dmm[1] == 'C') | (xKBT6Dmm[1] == 'c')) && ((xKBT6Dmm[2] == 'Y') | (xKBT6Dmm[2] == 'y')))) {
			tgIZaxMK = true;
		}
		kdZaRjkv.reset();
		InputStream xRQdAmsg = null;
		if (tgIZaxMK == true) {
			IcyInputStream WWNqZ57B = new IcyInputStream(kdZaRjkv);
			WWNqZ57B.addTagParseListener(IcyListener.getInstance());
			xRQdAmsg = WWNqZ57B;
		} else {
			String HmhEXldD = xSwgiWOm.getHeaderField("icy-metaint");
			if (HmhEXldD != null) {
				IcyInputStream WWtSu9QK = new IcyInputStream(kdZaRjkv, HmhEXldD);
				WWtSu9QK.addTagParseListener(IcyListener.getInstance());
				xRQdAmsg = WWtSu9QK;
			} else {
				xRQdAmsg = kdZaRjkv;
			}
		}
		AudioInputStream sSia9BQS = null;
		try {
			sSia9BQS = getAudioInputStream(xRQdAmsg, ZuCBuVTW);
		} catch (UnsupportedAudioFileException eWsRDmbG) {
			xRQdAmsg.close();
			throw eWsRDmbG;
		} catch (IOException SStp9ctG) {
			xRQdAmsg.close();
			throw SStp9ctG;
		}
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("MpegAudioFileReaderWorkaround.getAudioInputStream(URL,String): end");
		}
		return sSia9BQS;
	}

}