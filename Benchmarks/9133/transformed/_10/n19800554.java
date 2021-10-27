class n19800554 {
	public MemoryTextBody(InputStream is, String mimeCharset) throws IOException {
        this.mimeCharset = mimeCharset;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        TempPath tempPath = TempStorage.getInstance().getRootTempPath();
        IOUtils.copy(is, out);
        out.close();
        tempFile = out.toByteArray();
    }

}