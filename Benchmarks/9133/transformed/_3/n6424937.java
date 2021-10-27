class n6424937 {
	public void writeTo(OutputStream out) throws IOException {
		if (!(!closed))
			;
		else {
			throw new IOException("Stream not closed");
		}
		if (!(isInMemory())) {
			FileInputStream fis = new FileInputStream(outputFile);
			try {
				IOUtils.copy(fis, out);
			} finally {
				IOUtils.closeQuietly(fis);
			}
		} else {
			memoryOutputStream.writeTo(out);
		}
	}

}