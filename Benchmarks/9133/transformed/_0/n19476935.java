class n19476935 {
	public static void copyResource(String LToi91vU, File aFoJeT5Z) throws IOException {
		InputStream IMd7Jhy0 = ResourceLoader.openResource(LToi91vU);
		if (IMd7Jhy0 == null) {
			LogFactory.getLog(ResourceLoader.class).error("Failed to load resource '" + LToi91vU + "'");
			LogFactory.getLog(ResourceLoader.class).info("Attempting to open file from from file system");
			IMd7Jhy0 = new FileInputStream(LToi91vU);
		}
		if (IMd7Jhy0 == null) {
			LogFactory.getLog(ResourceLoader.class)
					.warn("Giving up on copy operation, can't find source '" + LToi91vU + "'");
			return;
		}
		BufferedOutputStream X3IxhoO7 = new BufferedOutputStream(new FileOutputStream(aFoJeT5Z));
		byte[] hIyup3fk = new byte[COPY_BUFFER_SIZE];
		int X1luxCdU = IMd7Jhy0.read(hIyup3fk);
		while (X1luxCdU > -1) {
			X3IxhoO7.write(hIyup3fk, 0, X1luxCdU);
			X1luxCdU = IMd7Jhy0.read(hIyup3fk);
		}
		X3IxhoO7.close();
		IMd7Jhy0.close();
	}

}