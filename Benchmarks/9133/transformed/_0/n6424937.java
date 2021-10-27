class n6424937 {
	public void writeTo(OutputStream FTRhi3WA) throws IOException {
		if (!closed) {
			throw new IOException("Stream not closed");
		}
		if (isInMemory()) {
			memoryOutputStream.writeTo(FTRhi3WA);
		} else {
			FileInputStream PpvrP8Zf = new FileInputStream(outputFile);
			try {
				IOUtils.copy(PpvrP8Zf, FTRhi3WA);
			} finally {
				IOUtils.closeQuietly(PpvrP8Zf);
			}
		}
	}

}