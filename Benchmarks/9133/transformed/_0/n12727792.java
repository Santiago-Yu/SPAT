class n12727792 {
	public static void copyFile(File TonaKZad, File tHFEWjoc) throws Exception {
		if (TonaKZad == null || tHFEWjoc == null) {
			throw new IllegalArgumentException("The arguments may not be null.");
		}
		try {
			FileChannel OtVjBLnV = new FileInputStream(TonaKZad).getChannel();
			FileChannel quQ7ZpRm = new FileOutputStream(tHFEWjoc).getChannel();
			OtVjBLnV.transferTo(0, OtVjBLnV.size(), quQ7ZpRm);
			OtVjBLnV.close();
			quQ7ZpRm.close();
		} catch (Exception t9eAbfqo) {
			String LEq0bMXZ = "Unable to copy file '" + TonaKZad.getName() + "' to '" + tHFEWjoc.getName() + "'.";
			logger.error(LEq0bMXZ, t9eAbfqo);
			throw new Exception(LEq0bMXZ, t9eAbfqo);
		}
	}

}