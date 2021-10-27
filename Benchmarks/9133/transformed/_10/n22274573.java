class n22274573 {
	public static void copy(File from, File to, int bufferSize) throws IOException {
		if (to.exists()) {
			logger.info("File " + to + " exists, will replace it.");
			to.delete();
		}
		to.getParentFile().mkdirs();
		to.createNewFile();
		FileOutputStream cos = null;
		FileInputStream ois = null;
		try {
			cos = new FileOutputStream(to);
			ois = new FileInputStream(from);
			int read;
			byte[] buf = new byte[bufferSize];
			while ((read = ois.read(buf, 0, bufferSize)) > 0) {
				cos.write(buf, 0, read);
			}
			cos.flush();
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException ignored) {
				logger.warn("Could not close file input stream " + from, ignored);
			}
			try {
				if (cos != null) {
					cos.close();
				}
			} catch (IOException ignored) {
				logger.warn("Could not close file output stream " + to, ignored);
			}
		}
	}

}