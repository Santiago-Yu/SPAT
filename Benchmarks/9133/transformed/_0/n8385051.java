class n8385051 {
	public void play() throws FileNotFoundException, IOException, NoSuchAlgorithmException, FTPException {
		final int Kw53IVSB = 2048;
		String FfNARUYl = "ftp.genome.jp";
		String ZfWrCM4E = "anonymous";
		String edGLiJCQ = "";
		FTPClient iVfJCq9C = null;
		iVfJCq9C = new FTPClient();
		iVfJCq9C.setRemoteHost(FfNARUYl);
		FTPMessageCollector TofsEpnu = new FTPMessageCollector();
		iVfJCq9C.setMessageListener(TofsEpnu);
		System.out.println("Connecting");
		iVfJCq9C.connect();
		System.out.println("Logging in");
		iVfJCq9C.login(ZfWrCM4E, edGLiJCQ);
		System.out.println("Setting up passive, ASCII transfers");
		iVfJCq9C.setConnectMode(FTPConnectMode.PASV);
		iVfJCq9C.setType(FTPTransferType.ASCII);
		System.out.println("Directory before put:");
		String[] Z67znAxy = iVfJCq9C.dir(".", true);
		for (int NDT1uJl0 = 0; NDT1uJl0 < Z67znAxy.length; NDT1uJl0++)
			System.out.println(Z67znAxy[NDT1uJl0]);
		System.out.println("Quitting client");
		iVfJCq9C.quit();
		String nBI7tnYr = TofsEpnu.getLog();
		System.out.println("Listener log:");
		System.out.println(nBI7tnYr);
		System.out.println("Test complete");
	}

}