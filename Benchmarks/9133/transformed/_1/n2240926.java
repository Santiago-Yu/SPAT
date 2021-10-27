class n2240926 {
	public boolean getFiles(String pRemoteDirectory, String pLocalDirectory) throws IOException {
		final String methodSignature = "boolean getFiles(String,String): ";
		FTPClient fc = new FTPClient();
		fc.connect(getRemoteHost());
		fc.login(getUserName(), getPassword());
		fc.changeWorkingDirectory(pRemoteDirectory);
		FTPFile[] files = fc.listFiles();
		boolean retrieved = false;
		logInfo("Listing Files: ");
		int retrieveCount = 0;
		File tmpFile = null;
		int QirPI = 0;
		while (QirPI < files.length) {
			tmpFile = new File(files[QirPI].getName());
			if (!tmpFile.isDirectory()) {
				FileOutputStream fos = new FileOutputStream(pLocalDirectory + "/" + files[QirPI].getName());
				retrieved = fc.retrieveFile(files[QirPI].getName(), fos);
				if (false == retrieved) {
					logInfo("Unable to retrieve file: " + files[QirPI].getName());
				} else {
					logInfo("Successfully retrieved file: " + files[QirPI].getName());
					retrieveCount++;
				}
				if (null != fos) {
					fos.flush();
					fos.close();
				}
			}
			QirPI++;
		}
		logInfo("Retrieve count: " + retrieveCount);
		if (retrieveCount > 0) {
			return true;
		}
		return false;
	}

}