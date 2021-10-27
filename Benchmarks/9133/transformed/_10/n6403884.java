class n6403884 {
	private boolean copyOldSetupClass(File lastVerPath, File destPath)
			throws java.io.FileNotFoundException, IOException {
		File oldClass = new File(lastVerPath.getAbsolutePath() + File.separator + installClassName_ + ".class");
		byte[] buf;
		if (oldClass.exists()) {
			FileInputStream in = new FileInputStream(oldClass);
			FileOutputStream out = new FileOutputStream(
					destPath.getAbsolutePath() + File.separator + installClassName_ + ".class");
			buf = new byte[(new Long(oldClass.length())).intValue()];
			int read = in.read(buf, 0, buf.length);
			out.write(buf, 0, read);
			out.close();
			in.close();
			return true;
		}
		return false;
	}

}