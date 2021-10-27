class n19361396 {
	public static void main(String[] args) throws Exception {
		String ftpHostIP = System.getProperty(RuntimeConstants.FTP_HOST_IP.toString());
		String ftpUsername = System.getProperty(RuntimeConstants.FTP_USERNAME.toString());
		String ftpPassword = System.getProperty(RuntimeConstants.FTP_PASSWORD.toString());
		String ftpWorkingDirectory = System.getProperty(RuntimeConstants.FTP_WORKING_DIRECTORY_PATH.toString());
		String ftpSenderDirectory = System.getProperty(RuntimeConstants.FTP_SENDER_DIRECTORY_FULL_PATH.toString());
		if (null == ftpHostIP) {
			System.err.println("The FTP_HOST_IP system property must be filled out.");
			System.exit(1);
		}
		if (null == ftpUsername) {
			System.err.println("The FTP_USERNAME system property must be filled out.");
			System.exit(1);
		}
		if (null == ftpPassword) {
			System.err.println("The FTP_PASSWORD system property must be filled out.");
			System.exit(1);
		}
		if (null == ftpWorkingDirectory) {
			System.err.println("The FTP_WORKING_DIRECTORY_PATH system property must be filled out.");
			System.exit(1);
		}
		if (null == ftpSenderDirectory) {
			System.err.println("The FTP_SENDER_DIRECTORY_FULL_PATH system property must be filled out.");
			System.exit(1);
		}
		FTPClient ftp = new FTPClient();
		ftp.connect(ftpHostIP);
		ftp.login(ftpUsername, ftpPassword);
		ftp.changeWorkingDirectory(ftpWorkingDirectory);
		ByteArrayInputStream bais = new ByteArrayInputStream(new byte[1024]);
		ftp.storeFile("sampleFile.txt", bais);
		IFileDescriptor fileDescriptor = FileTransferUtil.readAFile(ftpSenderDirectory);
		bais = new ByteArrayInputStream(fileDescriptor.getFileContent());
		long initTime = System.currentTimeMillis();
		ftp.storeFile(fileDescriptor.getFileName(), bais);
		long endTime = System.currentTimeMillis();
		System.out.println("File " + fileDescriptor.getFileName() + " transfer by FTP in " + (endTime - initTime)
				+ " miliseconds.");
	}

}