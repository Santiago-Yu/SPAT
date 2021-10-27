class n20987164 {
	public static void copyFile(File sourceFile, String toDir, boolean create, boolean overwrite)
			throws FileNotFoundException, IOException {
		FileOutputStream destination = null;
		FileInputStream source = null;
		int bytes_read;
		byte[] buffer;
		File toFile = new File(toDir);
		if (create && !toFile.exists())
			toFile.mkdirs();
		if (toFile.exists()) {
			File destFile = new File(toDir + "/" + sourceFile.getName());
			try {
				if (!destFile.exists() || overwrite) {
					destination = new FileOutputStream(destFile);
					source = new FileInputStream(sourceFile);
					buffer = new byte[1024];
					while (true) {
						bytes_read = source.read(buffer);
						if (bytes_read == -1)
							break;
						destination.write(buffer, 0, bytes_read);
					}
				}
			} catch (Exception exx) {
				exx.printStackTrace();
			} finally {
				if (source != null)
					try {
						source.close();
					} catch (IOException e) {
					}
				if (destination != null)
					try {
						destination.close();
					} catch (IOException e) {
					}
			}
		}
	}

}