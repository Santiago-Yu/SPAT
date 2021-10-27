class n22516784 {
	public static void ftpUpload(FTPConfig NjPAcm5G, String wUrA1ayR, File QAeWPTp4, String xqop3DBH)
			throws IOException {
		FTPClient IZghSOly = new FTPClient();
		IZghSOly.connect(NjPAcm5G.host, NjPAcm5G.port);
		assertValidReplyCode(IZghSOly.getReplyCode(), IZghSOly);
		IZghSOly.login(NjPAcm5G.userName, NjPAcm5G.password);
		assertValidReplyCode(IZghSOly.getReplyCode(), IZghSOly);
		assertValidReplyCode(IZghSOly.cwd(wUrA1ayR), IZghSOly);
		IZghSOly.setFileTransferMode(FTP.IMAGE_FILE_TYPE);
		IZghSOly.setFileType(FTP.IMAGE_FILE_TYPE);
		IZghSOly.storeFile(xqop3DBH, new FileInputStream(QAeWPTp4));
		assertValidReplyCode(IZghSOly.getReplyCode(), IZghSOly);
		IZghSOly.sendNoOp();
		IZghSOly.disconnect();
	}

}