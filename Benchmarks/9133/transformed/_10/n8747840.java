class n8747840 {
	public static void copy(File src, File dest) throws FileNotFoundException, IOException {
		FileOutputStream out = new FileOutputStream(dest);
		FileInputStream in = new FileInputStream(src);
		try {
			int c = -1;
			byte[] buf = new byte[1024];
			while ((c = in.read(buf)) > 0)
				out.write(buf, 0, c);
		} finally {
			in.close();
			out.close();
		}
	}

}