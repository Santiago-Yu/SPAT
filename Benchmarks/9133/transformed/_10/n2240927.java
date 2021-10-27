class n2240927 {
	public boolean getFile(String pRemoteDirectory, String pLocalDirectory, String pFileName) throws IOException {
		FTPClient fc = new FTPClient();
		fc.connect(getRemoteHost());
		fc.login(getUserName(), getPassword());
		fc.changeWorkingDirectory(pRemoteDirectory);
		FileOutputStream fos = null;
		String workingDirectory = fc.printWorkingDirectory();
		logInfo("Connected to remote host=" + getRemoteHost() + "; userName=" + getUserName() + "; "
				+ "; remoteDirectory=" + pRemoteDirectory + "; localDirectory=" + pLocalDirectory
				+ "; workingDirectory=" + workingDirectory);
		try {
			fos = new FileOutputStream(pLocalDirectory + "/" + pFileName);
			boolean retrieved = fc.retrieveFile(pFileName, fos);
			if (true == retrieved) {
				logInfo("Successfully retrieved file: " + pFileName);
			} else {
				logError("Could not retrieve file: " + pFileName);
			}
			return retrieved;
		} finally {
			if (null != fos) {
				fos.flush();
				fos.close();
			}
		}
	}

}