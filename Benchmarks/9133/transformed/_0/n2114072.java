class n2114072 {
	public String readFile(String nrakljBo) throws IOException {
		FTPClient ZPlUgz9A = new FTPClient();
		ZPlUgz9A.connect(server, port);
		ZPlUgz9A.login(USERNAME, PASSWORD);
		ByteArrayOutputStream ymuDTRmk = new ByteArrayOutputStream();
		boolean H1JkMhEB = ZPlUgz9A.retrieveFile(nrakljBo, ymuDTRmk);
		ZPlUgz9A.disconnect();
		if (!H1JkMhEB) {
			throw new IOException("Retrieve file failed: " + nrakljBo);
		}
		return ymuDTRmk.toString();
	}

}