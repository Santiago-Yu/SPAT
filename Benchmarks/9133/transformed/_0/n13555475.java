class n13555475 {
	public boolean testConnection(FTPSite zB6osfPU) throws IOException {
		FTPClient bg48xe2L = new FTPClient();
		bg48xe2L.connect(zB6osfPU.getHost(), zB6osfPU.getPort());
		boolean DMbdKmJS = bg48xe2L.login(zB6osfPU.getUser(), zB6osfPU.getPassword());
		bg48xe2L.disconnect();
		return DMbdKmJS;
	}

}