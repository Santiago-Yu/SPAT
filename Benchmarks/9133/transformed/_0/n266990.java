class n266990 {
	public static void copyFile(File LQey7Huq, File hK92njqA) throws IOException {
		if (!hK92njqA.exists()) {
			hK92njqA.createNewFile();
		}
		FileChannel ropAlSsC = null;
		FileChannel XXWsE6hN = null;
		try {
			ropAlSsC = new FileInputStream(LQey7Huq).getChannel();
			XXWsE6hN = new FileOutputStream(hK92njqA).getChannel();
			XXWsE6hN.transferFrom(ropAlSsC, 0, ropAlSsC.size());
		} finally {
			if (ropAlSsC != null) {
				ropAlSsC.close();
			}
			if (XXWsE6hN != null) {
				XXWsE6hN.close();
			}
		}
	}

}