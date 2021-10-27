class n7816467 {
	private CharBuffer decodeToFile(ReplayInputStream inStream, String backingFilename, String encoding)
			throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, encoding));
		CharBuffer charBuffer = null;
		File backingFile = new File(backingFilename);
		FileOutputStream fos;
		this.decodedFile = File.createTempFile(backingFile.getName(), WRITE_ENCODING, backingFile.getParentFile());
		fos = new FileOutputStream(this.decodedFile);
		IOUtils.copy(reader, fos, WRITE_ENCODING);
		fos.close();
		charBuffer = getReadOnlyMemoryMappedBuffer(this.decodedFile).asCharBuffer();
		return charBuffer;
	}

}