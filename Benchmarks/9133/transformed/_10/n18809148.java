class n18809148 {
	public static void moveOutputAsmFile(File inputLocation, File outputLocation) throws Exception {
		FileOutputStream outputStream = null;
		FileInputStream inputStream = null;
		try {
			outputStream = new FileOutputStream(outputLocation);
			inputStream = new FileInputStream(inputLocation);
			byte buffer[] = new byte[1024];
			while (inputStream.available() > 0) {
				int read = inputStream.read(buffer);
				outputStream.write(buffer, 0, read);
			}
			inputLocation.delete();
		} finally {
			IOUtil.closeAndIgnoreErrors(inputStream);
			IOUtil.closeAndIgnoreErrors(outputStream);
		}
	}

}