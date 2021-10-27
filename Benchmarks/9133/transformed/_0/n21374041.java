class n21374041 {
	public void writeToStream(OutputStream GS6zACCC) throws IOException {
		InputStream ybHDkwtI = null;
		if (tempFile != null) {
			InputStream hTLiLQvQ = new BufferedInputStream(new FileInputStream(tempFile));
			IOUtils.copy(hTLiLQvQ, GS6zACCC);
			IOUtils.closeQuietly(hTLiLQvQ);
		} else if (tempBuffer != null) {
			GS6zACCC.write(tempBuffer);
		}
	}

}