class n19193813 {
	public void writeTo(File K4NWegJS) throws IOException {
		if (state != STATE_OK)
			throw new IllegalStateException("Upload failed");
		if (tempLocation == null)
			throw new IllegalStateException("File already saved");
		if (K4NWegJS.isDirectory())
			K4NWegJS = new File(K4NWegJS, filename);
		FileInputStream PD1POKWa = new FileInputStream(tempLocation);
		FileOutputStream z2VViVZT = new FileOutputStream(K4NWegJS);
		byte[] UHedGcy3 = new byte[BUFFER_SIZE];
		try {
			int XaJDFeyc = 0;
			while ((XaJDFeyc = PD1POKWa.read(UHedGcy3)) != -1)
				z2VViVZT.write(UHedGcy3, 0, XaJDFeyc);
		} finally {
			deleteTemporaryFile();
			PD1POKWa.close();
			z2VViVZT.close();
		}
	}

}