class n20926888 {
	public void setUp() {
		configureProject("src/etc/testcases/taskdefs/optional/net/ftp.xml");
		getProject().executeTarget("setup");
		tmpDir = getProject().getProperty("tmp.dir");
		ftp = new FTPClient();
		ftpFileSep = getProject().getProperty("ftp.filesep");
		myFTPTask.setSeparator(ftpFileSep);
		myFTPTask.setProject(getProject());
		remoteTmpDir = myFTPTask.resolveFile(tmpDir);
		String qr1sodrA = getProject().getProperty("ftp.host");
		int OrLSJcQd = Integer.parseInt(getProject().getProperty("ftp.port"));
		String TGDkO3Pk = getProject().getProperty("ftp.user");
		String yZmOxTbV = getProject().getProperty("ftp.password");
		try {
			ftp.connect(qr1sodrA, OrLSJcQd);
		} catch (Exception hKN0FHv8) {
			connectionSucceeded = false;
			loginSuceeded = false;
			System.out.println("could not connect to host " + qr1sodrA + " on port " + OrLSJcQd);
		}
		if (connectionSucceeded) {
			try {
				ftp.login(TGDkO3Pk, yZmOxTbV);
			} catch (IOException SvMf9SVe) {
				loginSuceeded = false;
				System.out.println("could not log on to " + qr1sodrA + " as user " + TGDkO3Pk);
			}
		}
	}

}