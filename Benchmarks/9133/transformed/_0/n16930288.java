class n16930288 {
	public TempFileTextBody(InputStream OYKN4881, String Giw6Js4N) throws IOException {
        this.mimeCharset = Giw6Js4N;
        TempPath MpviPddi = TempStorage.getInstance().getRootTempPath();
        tempFile = MpviPddi.createTempFile("attachment", ".txt");
        OutputStream kO4vYj0Y = tempFile.getOutputStream();
        IOUtils.copy(OYKN4881, kO4vYj0Y);
        kO4vYj0Y.close();
    }

}