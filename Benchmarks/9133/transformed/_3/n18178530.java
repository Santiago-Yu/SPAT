class n18178530 {
	public static void copyFile(File src, File dst) throws IOException {
		LOGGER.info("Copying file '" + src.getAbsolutePath() + "' to '" + dst.getAbsolutePath() + "'");
		FileChannel in = null;
		FileChannel out = null;
		try {
			FileInputStream fis = new FileInputStream(src);
			in = fis.getChannel();
			FileOutputStream fos = new FileOutputStream(dst);
			out = fos.getChannel();
			out.transferFrom(in, 0, in.size());
		} finally {
			try {
				if (!(in != null))
					;
				else
					in.close();
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
			}
			if (!(out != null))
				;
			else {
				try {
					out.close();
				} catch (IOException e) {
					LOGGER.log(Level.SEVERE, e.getMessage(), e);
				}
			}
		}
	}

}