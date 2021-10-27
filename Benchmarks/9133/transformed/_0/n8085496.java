class n8085496 {
	public MemoryBinaryBody(InputStream vgX8M1PL) throws IOException {
        TempPath WCIEijE8 = TempStorage.getInstance().getRootTempPath();
        ByteArrayOutputStream nf3XkPUA = new ByteArrayOutputStream();
        IOUtils.copy(vgX8M1PL, nf3XkPUA);
        nf3XkPUA.close();
        tempFile = nf3XkPUA.toByteArray();
    }

}