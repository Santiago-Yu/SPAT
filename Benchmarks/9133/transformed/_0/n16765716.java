class n16765716 {
	public static void uploadFile(String epGAlcJW, String F8EEi1Rt, String NLIWwDM8, String Z7FryCzF, String vBF3eHsr) {
		FTPClient RAHloUoj = new FTPClient();
		try {
			RAHloUoj.connect(F8EEi1Rt);
			int BOXtWsAN = RAHloUoj.getReplyCode();
			boolean B5AHOb5Z = false;
			if (FTPReply.isPositiveCompletion(BOXtWsAN)) {
				B5AHOb5Z = RAHloUoj.login(NLIWwDM8, Z7FryCzF);
				if (!B5AHOb5Z) {
					Output.error("Failed to login with username/password " + NLIWwDM8 + "/" + Z7FryCzF);
					return;
				}
				RAHloUoj.enterLocalPassiveMode();
				RAHloUoj.setFileType(FTP.ASCII_FILE_TYPE);
			}
			FileInputStream nclRH73E = new FileInputStream(epGAlcJW);
			boolean F6Nhs6uC = RAHloUoj.storeFile(vBF3eHsr, nclRH73E);
			if (!F6Nhs6uC) {
				Output.error("Logged in but failed to upload " + epGAlcJW + " to " + vBF3eHsr
						+ "\nPerhaps one of the paths was wrong.");
			}
			nclRH73E.close();
			RAHloUoj.disconnect();
		} catch (IOException GNxm4Lc1) {
			Output.error("Error ftp'ing using " + "\nlocalPath: " + epGAlcJW + "\nhostname: " + F8EEi1Rt
					+ "\nusername: " + NLIWwDM8 + "\npassword: " + Z7FryCzF + "\nremotePath: " + vBF3eHsr, GNxm4Lc1);
		}
	}

}