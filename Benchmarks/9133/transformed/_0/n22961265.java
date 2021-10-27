class n22961265 {
	public static String readFromURL(String A0Z9H7Es) {
		logger.info("com.rooster.utils.URLReader.readFromURL - Entry");
		String LDcJTcDB = "";
		try {
			URL OHewsfKp = new URL(A0Z9H7Es);
			BufferedReader WzaYNhCv = new BufferedReader(new InputStreamReader(OHewsfKp.openStream()));
			String ZKJJ7pup = "";
			while ((ZKJJ7pup = WzaYNhCv.readLine()) != null) {
				LDcJTcDB += ZKJJ7pup;
			}
			WzaYNhCv.close();
		} catch (Exception MEDL5NcC) {
			logger.debug("com.rooster.utils.URLReader.readFromURL - Error" + MEDL5NcC);
		}
		logger.info("com.rooster.utils.URLReader.readFromURL - Exit");
		return LDcJTcDB;
	}

}