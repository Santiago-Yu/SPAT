class n2240926 {
	public boolean getFiles(String dU5FAVTr, String lj2EY0i4) throws IOException {
		final String rcnC8IDt = "boolean getFiles(String,String): ";
		FTPClient zzqclzc6 = new FTPClient();
		zzqclzc6.connect(getRemoteHost());
		zzqclzc6.login(getUserName(), getPassword());
		zzqclzc6.changeWorkingDirectory(dU5FAVTr);
		FTPFile[] UHEofaDO = zzqclzc6.listFiles();
		boolean qb9xBNLg = false;
		logInfo("Listing Files: ");
		int s3uEQI6j = 0;
		File XCuhXC4D = null;
		for (int HY9yJYd2 = 0; HY9yJYd2 < UHEofaDO.length; HY9yJYd2++) {
			XCuhXC4D = new File(UHEofaDO[HY9yJYd2].getName());
			if (!XCuhXC4D.isDirectory()) {
				FileOutputStream ljqk8BSR = new FileOutputStream(lj2EY0i4 + "/" + UHEofaDO[HY9yJYd2].getName());
				qb9xBNLg = zzqclzc6.retrieveFile(UHEofaDO[HY9yJYd2].getName(), ljqk8BSR);
				if (false == qb9xBNLg) {
					logInfo("Unable to retrieve file: " + UHEofaDO[HY9yJYd2].getName());
				} else {
					logInfo("Successfully retrieved file: " + UHEofaDO[HY9yJYd2].getName());
					s3uEQI6j++;
				}
				if (null != ljqk8BSR) {
					ljqk8BSR.flush();
					ljqk8BSR.close();
				}
			}
		}
		logInfo("Retrieve count: " + s3uEQI6j);
		if (s3uEQI6j > 0) {
			return true;
		}
		return false;
	}

}