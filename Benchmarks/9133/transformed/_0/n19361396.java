class n19361396 {
	public static void main(String[] d8CMc6nt) throws Exception {
		String LLVu5Njy = System.getProperty(RuntimeConstants.FTP_HOST_IP.toString());
		String mLuZaeYK = System.getProperty(RuntimeConstants.FTP_USERNAME.toString());
		String dfOQfM9A = System.getProperty(RuntimeConstants.FTP_PASSWORD.toString());
		String cHbTkqyW = System.getProperty(RuntimeConstants.FTP_WORKING_DIRECTORY_PATH.toString());
		String KjSHsAXG = System.getProperty(RuntimeConstants.FTP_SENDER_DIRECTORY_FULL_PATH.toString());
		if (LLVu5Njy == null) {
			System.err.println("The FTP_HOST_IP system property must be filled out.");
			System.exit(1);
		}
		if (mLuZaeYK == null) {
			System.err.println("The FTP_USERNAME system property must be filled out.");
			System.exit(1);
		}
		if (dfOQfM9A == null) {
			System.err.println("The FTP_PASSWORD system property must be filled out.");
			System.exit(1);
		}
		if (cHbTkqyW == null) {
			System.err.println("The FTP_WORKING_DIRECTORY_PATH system property must be filled out.");
			System.exit(1);
		}
		if (KjSHsAXG == null) {
			System.err.println("The FTP_SENDER_DIRECTORY_FULL_PATH system property must be filled out.");
			System.exit(1);
		}
		FTPClient TyN5xxGh = new FTPClient();
		TyN5xxGh.connect(LLVu5Njy);
		TyN5xxGh.login(mLuZaeYK, dfOQfM9A);
		TyN5xxGh.changeWorkingDirectory(cHbTkqyW);
		ByteArrayInputStream mUyf0PMr = new ByteArrayInputStream(new byte[1024]);
		TyN5xxGh.storeFile("sampleFile.txt", mUyf0PMr);
		IFileDescriptor MqdMZvRc = FileTransferUtil.readAFile(KjSHsAXG);
		mUyf0PMr = new ByteArrayInputStream(MqdMZvRc.getFileContent());
		long CwUmHKfp = System.currentTimeMillis();
		TyN5xxGh.storeFile(MqdMZvRc.getFileName(), mUyf0PMr);
		long DzoufZdA = System.currentTimeMillis();
		System.out.println(
				"File " + MqdMZvRc.getFileName() + " transfer by FTP in " + (DzoufZdA - CwUmHKfp) + " miliseconds.");
	}

}