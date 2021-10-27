class n19800554 {
	public MemoryTextBody(InputStream hWd8DP9E, String rM7dfQWW) throws IOException {
        this.mimeCharset = rM7dfQWW;
        TempPath XPjdlP0K = TempStorage.getInstance().getRootTempPath();
        ByteArrayOutputStream f7pR9jgN = new ByteArrayOutputStream();
        IOUtils.copy(hWd8DP9E, f7pR9jgN);
        f7pR9jgN.close();
        tempFile = f7pR9jgN.toByteArray();
    }

}