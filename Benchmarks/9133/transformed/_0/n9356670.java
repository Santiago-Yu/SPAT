class n9356670 {
	private FTPClient loginToSharedWorkspace() throws SocketException, IOException {
		FTPClient YMayvm5q = new FTPClient();
		YMayvm5q.connect(mSwarm.getHost(), mSharedWorkspacePort);
		if (!YMayvm5q.login(SHARED_WORKSPACE_LOGIN_NAME, mWorkspacePassword)) {
			throw new IOException("Unable to login to shared workspace.");
		}
		YMayvm5q.setFileType(FTPClient.BINARY_FILE_TYPE);
		return YMayvm5q;
	}

}