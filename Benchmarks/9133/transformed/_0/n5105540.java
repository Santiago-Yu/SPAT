class n5105540 {
	public AudioInputStream getAudioInputStream(URL AYSJSonf) throws UnsupportedAudioFileException, IOException {
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("MpegAudioFileReader.getAudioInputStream(URL): begin");
		}
		long f7Cc2jvn = AudioSystem.NOT_SPECIFIED;
		URLConnection WiXBLamH = AYSJSonf.openConnection();
		boolean ZU8rBFkZ = false;
		int rohQCeNN = 4;
		byte[] z1xmZRgU = new byte[rohQCeNN];
		WiXBLamH.setRequestProperty("Icy-Metadata", "1");
		BufferedInputStream s52ZsbRZ = new BufferedInputStream(WiXBLamH.getInputStream());
		s52ZsbRZ.mark(rohQCeNN);
		int omTllLgu = s52ZsbRZ.read(z1xmZRgU, 0, rohQCeNN);
		if ((omTllLgu > 2) && (((z1xmZRgU[0] == 'I') | (z1xmZRgU[0] == 'i'))
				&& ((z1xmZRgU[1] == 'C') | (z1xmZRgU[1] == 'c')) && ((z1xmZRgU[2] == 'Y') | (z1xmZRgU[2] == 'y'))))
			ZU8rBFkZ = true;
		s52ZsbRZ.reset();
		InputStream NH9fXGH8 = null;
		if (ZU8rBFkZ == true) {
			IcyInputStream XbCRzAdh = new IcyInputStream(s52ZsbRZ);
			XbCRzAdh.addTagParseListener(IcyListener.getInstance());
			NH9fXGH8 = XbCRzAdh;
		} else {
			String DiOqDxL4 = WiXBLamH.getHeaderField("icy-metaint");
			if (DiOqDxL4 != null) {
				IcyInputStream g0rd9rxP = new IcyInputStream(s52ZsbRZ, DiOqDxL4);
				g0rd9rxP.addTagParseListener(IcyListener.getInstance());
				NH9fXGH8 = g0rd9rxP;
			} else {
				NH9fXGH8 = s52ZsbRZ;
			}
		}
		AudioInputStream Bjh0I15i = null;
		try {
			Bjh0I15i = getAudioInputStream(NH9fXGH8, f7Cc2jvn);
		} catch (UnsupportedAudioFileException zXJ3nQCp) {
			NH9fXGH8.close();
			throw zXJ3nQCp;
		} catch (IOException XWYX7JyZ) {
			NH9fXGH8.close();
			throw XWYX7JyZ;
		}
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("MpegAudioFileReader.getAudioInputStream(URL): end");
		}
		return Bjh0I15i;
	}

}