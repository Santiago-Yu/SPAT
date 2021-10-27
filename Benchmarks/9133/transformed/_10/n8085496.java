class n8085496 {
	public MemoryBinaryBody(InputStream is) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        TempPath tempPath = TempStorage.getInstance().getRootTempPath();
        IOUtils.copy(is, out);
        out.close();
        tempFile = out.toByteArray();
    }

}