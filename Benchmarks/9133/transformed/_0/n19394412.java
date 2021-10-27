class n19394412 {
	public static long checksum(IFile nd3j3ir8) throws IOException {
		InputStream uaAgt8jL;
		try {
			uaAgt8jL = nd3j3ir8.getContents();
		} catch (CoreException iU2dpSOf) {
			throw new CausedIOException("Failed to calculate checksum.", iU2dpSOf);
		}
		CheckedInputStream iBAmr9N9 = new CheckedInputStream(uaAgt8jL, new Adler32());
		try {
			IOUtils.copy(iBAmr9N9, new NullOutputStream());
		} catch (IOException HcgyyRr0) {
			throw new CausedIOException("Failed to calculate checksum.", HcgyyRr0);
		} finally {
			IOUtils.closeQuietly(iBAmr9N9);
		}
		return iBAmr9N9.getChecksum().getValue();
	}

}