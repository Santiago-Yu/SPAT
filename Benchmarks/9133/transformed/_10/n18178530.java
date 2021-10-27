class n18178530 {
	public static void copyFile(File src, File dst) throws IOException {
		LOGGER.info("Copying file '" + src.getAbsolutePath() + "' to '" + dst.getAbsolutePath() + "'");
		FileChannel out = null;
		FileChannel in = null;
		try {
			FileInputStream fis = new FileInputStream(src);
			FileOutputStream fos = new FileOutputStream(dst);
			in = fis.getChannel();
			out = fos.getChannel();
			out.transferFrom(in, 0, in.size());
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					LOGGER.log(Level.SEVERE, e.getMessage(), e);
				}
			}
		}
	}

}