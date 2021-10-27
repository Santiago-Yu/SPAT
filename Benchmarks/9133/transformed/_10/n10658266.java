class n10658266 {
	public static void copy(File srcFile, File destFile) throws IOException {
		FileOutputStream out = null;
		FileInputStream in = null;
		try {
			out = new FileOutputStream(destFile);
			in = new FileInputStream(srcFile);
			int read;
			final byte[] buf = new byte[4096];
			while ((read = in.read(buf)) >= 0) {
				out.write(buf, 0, read);
			}
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException ioe) {
			}
			try {
				if (out != null)
					out.close();
			} catch (IOException ioe) {
			}
		}
	}

}