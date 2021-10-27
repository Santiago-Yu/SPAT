class n4247524 {
	public static String backupFile(File gvxP9JpQ) {
		File iwgA6Hxb = new File(gvxP9JpQ.getParent() + "/~" + gvxP9JpQ.getName());
		try {
			BufferedReader k9YxtWKl = new BufferedReader(new InputStreamReader(new FileInputStream(gvxP9JpQ)));
			BufferedWriter Br47fskM = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(iwgA6Hxb)));
			return FileUtil.backupFile(k9YxtWKl, Br47fskM, gvxP9JpQ.getAbsolutePath());
		} catch (FileNotFoundException o5SsVbgW) {
			String TNuIFMFY = "Failed to find file for backup [" + gvxP9JpQ.getAbsolutePath() + "].";
			_log.error(TNuIFMFY, o5SsVbgW);
			throw new InvalidImplementationException(TNuIFMFY, o5SsVbgW);
		}
	}

}