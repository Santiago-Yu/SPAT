class n18648407 {
	public static void copyFile(File file, File destination) throws Exception {
		BufferedOutputStream out = null;
		BufferedInputStream in = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(destination));
			in = new BufferedInputStream(new FileInputStream(file));
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (Exception e) {
			}
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {
			}
		}
	}

}