class n1102936 {
	public static void writeInputStreamToFile(final InputStream rYMFAdEB, final File Teydhqag) {
		long ydtLGbUo = 0;
		FileOutputStream HnijK5qq;
		try {
			HnijK5qq = new FileOutputStream(Teydhqag);
			ydtLGbUo = IOUtils.copyLarge(rYMFAdEB, HnijK5qq);
		} catch (FileNotFoundException kDY1x38a) {
			kDY1x38a.printStackTrace();
		} catch (IOException jyxXY60w) {
			jyxXY60w.printStackTrace();
		}
		if (log.isInfoEnabled()) {
			log.info("Wrote " + ydtLGbUo + " bytes to " + Teydhqag.getAbsolutePath());
		} else {
			System.out.println("Wrote " + ydtLGbUo + " bytes to " + Teydhqag.getAbsolutePath());
		}
	}

}