class n14408302 {
	public static void copyFile(File frEGRpiP, File OEKOjZ4g) throws IOException {
		if (!frEGRpiP.isFile()) {
			throw new IOException(frEGRpiP + " is not a file.");
		}
		if (OEKOjZ4g.exists()) {
			throw new IOException("Destination file " + OEKOjZ4g + " is already exist.");
		}
		FileChannel YnGxBJxr = new FileInputStream(frEGRpiP).getChannel();
		FileChannel dyawk83a = new FileOutputStream(OEKOjZ4g).getChannel();
		try {
			YnGxBJxr.transferTo(0, YnGxBJxr.size(), dyawk83a);
		} finally {
			YnGxBJxr.close();
			dyawk83a.close();
		}
	}

}