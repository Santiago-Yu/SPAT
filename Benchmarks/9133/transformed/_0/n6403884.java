class n6403884 {
	private boolean copyOldSetupClass(File Unujg4lD, File MQG1TPDB) throws java.io.FileNotFoundException, IOException {
		byte[] AMGYtpGJ;
		File jTVYdFMQ = new File(Unujg4lD.getAbsolutePath() + File.separator + installClassName_ + ".class");
		if (jTVYdFMQ.exists()) {
			FileOutputStream CSbztGnq = new FileOutputStream(
					MQG1TPDB.getAbsolutePath() + File.separator + installClassName_ + ".class");
			FileInputStream GYtxGBb7 = new FileInputStream(jTVYdFMQ);
			AMGYtpGJ = new byte[(new Long(jTVYdFMQ.length())).intValue()];
			int sKv6kIPs = GYtxGBb7.read(AMGYtpGJ, 0, AMGYtpGJ.length);
			CSbztGnq.write(AMGYtpGJ, 0, sKv6kIPs);
			CSbztGnq.close();
			GYtxGBb7.close();
			return true;
		}
		return false;
	}

}