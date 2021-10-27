class n2240926 {
	public boolean getFiles(String pRemoteDirectory, String pLocalDirectory) throws IOException {
		FTPClient fc = new FTPClient();
		final String methodSignature = "boolean getFiles(String,String): ";
		fc.connect(getRemoteHost());
		fc.login(getUserName(), getPassword());
		fc.changeWorkingDirectory(pRemoteDirectory);
		boolean retrieved = false;
		FTPFile[] files = fc.listFiles();
		logInfo("Listing Files: ");
		File tmpFile = null;
		int retrieveCount = 0;
		for (int i = 0; i < files.length; i++) {
			tmpFile = new File(files[i].getName());
			if (!tmpFile.isDirectory()) {
				FileOutputStream fos = new FileOutputStream(pLocalDirectory + "/" + files[i].getName());
				retrieved = fc.retrieveFile(files[i].getName(), fos);
				if (false == retrieved) {
					logInfo("Unable to retrieve file: " + files[i].getName());
				} else {
					logInfo("Successfully retrieved file: " + files[i].getName());
					retrieveCount++;
				}
				if (null != fos) {
					fos.flush();
					fos.close();
				}
			}
		}
		logInfo("Retrieve count: " + retrieveCount);
		if (retrieveCount > 0) {
			return true;
		}
		return false;
	}

}