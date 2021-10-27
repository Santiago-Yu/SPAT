class n5375381 {
	public TempFileBinaryBody(InputStream sp2CQTBG) throws IOException {
        TempPath hkOt92iY = TempStorage.getInstance().getRootTempPath();
        tempFile = hkOt92iY.createTempFile("attachment", ".bin");
        OutputStream K9uioLdB = tempFile.getOutputStream();
        IOUtils.copy(sp2CQTBG, K9uioLdB);
        K9uioLdB.close();
    }

}