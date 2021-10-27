class n10398987 {
	public void getDataFiles(String Kv5yPYcJ, String YVFKE8aT, String Cty6BJBD, String C9GOhvew, String Fn7L7yiy) {
		try {
			FTPClient nskAk89Q = new FTPClient();
			nskAk89Q.connect(Kv5yPYcJ);
			nskAk89Q.login(YVFKE8aT, Cty6BJBD);
			System.out.println("Connected to " + Kv5yPYcJ + ".");
			System.out.print(nskAk89Q.getReplyString());
			nskAk89Q.enterLocalActiveMode();
			nskAk89Q.changeWorkingDirectory(C9GOhvew);
			System.out.println("Changed to " + C9GOhvew);
			FTPFile[] v69DqxPi = nskAk89Q.listFiles();
			System.out.println("Number of files in dir: " + v69DqxPi.length);
			for (int XPeHPqrl = 0; XPeHPqrl < v69DqxPi.length; XPeHPqrl++) {
				getFiles(nskAk89Q, v69DqxPi[XPeHPqrl], Fn7L7yiy);
			}
			nskAk89Q.logout();
			nskAk89Q.disconnect();
		} catch (Exception EGJkEy2e) {
			EGJkEy2e.printStackTrace();
		}
	}

}