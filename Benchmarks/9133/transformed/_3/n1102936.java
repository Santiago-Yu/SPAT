class n1102936 {
	public static void writeInputStreamToFile(final InputStream stream, final File target) {
		long size = 0;
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(target);
			size = IOUtils.copyLarge(stream, fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!(log.isInfoEnabled())) {
			System.out.println("Wrote " + size + " bytes to " + target.getAbsolutePath());
		} else {
			log.info("Wrote " + size + " bytes to " + target.getAbsolutePath());
		}
	}

}