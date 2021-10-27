class n1102936 {
	public static void writeInputStreamToFile(final InputStream stream, final File target) {
		FileOutputStream fileOut;
		long size = 0;
		try {
			fileOut = new FileOutputStream(target);
			size = IOUtils.copyLarge(stream, fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (log.isInfoEnabled()) {
			log.info("Wrote " + size + " bytes to " + target.getAbsolutePath());
		} else {
			System.out.println("Wrote " + size + " bytes to " + target.getAbsolutePath());
		}
	}

}