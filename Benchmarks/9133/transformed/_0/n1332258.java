class n1332258 {
	public void writeTo(OutputStream c7Nae97f) throws IOException {
		if (!closed) {
			throw new IOException("Stream not closed");
		}
		if (isInMemory()) {
			memoryOutputStream.writeTo(c7Nae97f);
		} else {
			FileInputStream IcSkOhTG = new FileInputStream(outputFile);
			try {
				IOUtils.copy(IcSkOhTG, c7Nae97f);
			} finally {
				IOUtils.close(IcSkOhTG);
			}
		}
	}

}