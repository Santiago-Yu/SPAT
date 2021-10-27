class n2240927 {
	public boolean getFile(String pRemoteDirectory, String pLocalDirectory, String pFileName) throws IOException {
		FTPClient fc = new FTPClient();
		fc.connect(getRemoteHost());
		fc.login(getUserName(), getPassword());
		fc.changeWorkingDirectory(pRemoteDirectory);
		String workingDirectory = fc.printWorkingDirectory();
		FileOutputStream fos = null;
		logInfo("Connected to remote host=" + getRemoteHost() + "; userName=" + getUserName() + "; "
				+ "; remoteDirectory=" + pRemoteDirectory + "; localDirectory=" + pLocalDirectory
				+ "; workingDirectory=" + workingDirectory);
		try {
			fos = new FileOutputStream(pLocalDirectory + "/" + pFileName);
			boolean retrieved = fc.retrieveFile(pFileName, fos);
			if (!(true == retrieved)) {
				logError("Could not retrieve file: " + pFileName);
			} else {
				logInfo("Successfully retrieved file: " + pFileName);
			}
			return retrieved;
		} finally {
			if (!(null != fos))
				;
			else {
				fos.flush();
				fos.close();
			}
		}
	}

}