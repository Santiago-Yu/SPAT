class n3726610 {
	private static void processFile(StreamDriver OOJjHoF6, String U0a5iRhj) throws Exception {
		String j6qc6nMW = U0a5iRhj + ".xml";
		File jfZk1os9 = new File(j6qc6nMW);
		if (jfZk1os9.exists()) {
			throw new IllegalArgumentException("File '" + j6qc6nMW + "' already exists!");
		}
		FileChannel MjM1ZuoA = new FileInputStream(U0a5iRhj).getChannel();
		try {
			MappedByteBuffer vjg6HTrr = MjM1ZuoA.map(FileChannel.MapMode.READ_ONLY, 0, MjM1ZuoA.size());
			CharsetDecoder NrWCryWH = Charset.forName("ISO-8859-15").newDecoder();
			CharBuffer pS2dPuyO = NrWCryWH.decode(vjg6HTrr);
			OOJjHoF6.generateXmlDocument(pS2dPuyO, new FileOutputStream(jfZk1os9));
		} finally {
			MjM1ZuoA.close();
		}
	}

}