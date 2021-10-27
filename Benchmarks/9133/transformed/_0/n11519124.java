class n11519124 {
	protected static void copyFile(File MFYh1KFR, File xgPAo8XD) throws IOException {
		java.io.FileWriter NPO4M1Y0 = null;
		java.io.FileReader adQH8srx = null;
		try {
			NPO4M1Y0 = new java.io.FileWriter(xgPAo8XD);
			adQH8srx = new java.io.FileReader(MFYh1KFR);
			char[] JWwLFE1R = new char[4096];
			int Md1A89Y5 = adQH8srx.read(JWwLFE1R, 0, 4096);
			while (Md1A89Y5 >= 0) {
				NPO4M1Y0.write(JWwLFE1R, 0, Md1A89Y5);
				Md1A89Y5 = adQH8srx.read(JWwLFE1R, 0, 4096);
			}
			JWwLFE1R = null;
		} finally {
			try {
				adQH8srx.close();
			} catch (Throwable bMR6slDQ) {
			}
			try {
				NPO4M1Y0.close();
			} catch (Throwable fCbHRmRW) {
			}
		}
	}

}