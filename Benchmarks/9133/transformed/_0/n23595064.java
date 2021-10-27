class n23595064 {
	public void writeTo(OutputStream nqtAbWeq) throws IOException {
		if (!closed) {
			throw new IOException("Stream not closed");
		}
		if (isInMemory()) {
			memoryOutputStream.writeTo(nqtAbWeq);
		} else {
			FileInputStream kwNz5zMQ = new FileInputStream(outputFile);
			try {
				IOUtils.copy(kwNz5zMQ, nqtAbWeq);
			} finally {
				IOUtils.closeQuietly(kwNz5zMQ);
			}
		}
	}

}