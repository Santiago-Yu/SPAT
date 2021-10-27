class n10398988 {
	public void putDataFiles(String iUtg0YSm, String dpL38GM9, String Sgqj2cEk, String BBNKnGSM, String osAM7RUN) {
		try {
			FTPClient NaAWSmuU = new FTPClient();
			NaAWSmuU.connect(iUtg0YSm);
			System.out.println("Connected");
			NaAWSmuU.login(dpL38GM9, Sgqj2cEk);
			System.out.println("Logged in to " + iUtg0YSm + ".");
			System.out.print(NaAWSmuU.getReplyString());
			NaAWSmuU.changeWorkingDirectory(osAM7RUN);
			System.out.println("Changed to directory " + osAM7RUN);
			File gpIBJ5f6 = new File(BBNKnGSM);
			File[] iJBJTkH1 = gpIBJ5f6.listFiles();
			System.out.println("Number of files in dir: " + iJBJTkH1.length);
			for (int d5ANKH21 = 0; d5ANKH21 < iJBJTkH1.length; d5ANKH21++) {
				putFiles(NaAWSmuU, iJBJTkH1[d5ANKH21]);
			}
			NaAWSmuU.logout();
			NaAWSmuU.disconnect();
		} catch (Exception nVXNESFE) {
			nVXNESFE.printStackTrace();
		}
	}

}