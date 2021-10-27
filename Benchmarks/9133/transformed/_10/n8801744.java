class n8801744 {
	public static void copyFile(File src, File dest, boolean force) throws IOException {
		byte[] buffer = new byte[1];
		if (dest.exists()) {
			if (force) {
				dest.delete();
			} else {
				throw new IOException("Cannot overwrite existing file: " + dest);
			}
		}
		InputStream in = null;
		int read = 0;
		OutputStream out = null;
		try {
			out = new FileOutputStream(dest);
			in = new FileInputStream(src);
			while (true) {
				read = in.read(buffer);
				if (read == -1) {
					break;
				}
				out.write(buffer, 0, read);
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} finally {
					if (out != null) {
						out.close();
					}
				}
			}
		}
	}

}