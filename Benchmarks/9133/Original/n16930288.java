class n16930288{
    public TempFileTextBody(InputStream is, String mimeCharset) throws IOException {
        this.mimeCharset = mimeCharset;
        TempPath tempPath = TempStorage.getInstance().getRootTempPath();
        tempFile = tempPath.createTempFile("attachment", ".txt");
        OutputStream out = tempFile.getOutputStream();
        IOUtils.copy(is, out);
        out.close();
    }

}