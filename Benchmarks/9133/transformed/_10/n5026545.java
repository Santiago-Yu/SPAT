class n5026545 {
	public void writeConfigurationFile() throws IOException, ComponentException {
		SystemConfig config = parent.getParentSystem().getConfiguration();
		File original = config.getLocation();
		File backup = new File(original.getParentFile(), original.getName() + "." + System.currentTimeMillis());
		FileOutputStream out = new FileOutputStream(backup);
		FileInputStream in = new FileInputStream(original);
		byte[] buffer = new byte[2048];
		FileWriter replace = new FileWriter(original);
		try {
			int bytesread = 0;
			while ((bytesread = in.read(buffer)) > 0) {
				out.write(buffer, 0, bytesread);
			}
		} catch (IOException e) {
			logger.warn("Failed to copy backup of configuration file");
			throw e;
		} finally {
			in.close();
			out.close();
		}
		replace.write(config.toFileFormat());
		replace.close();
		logger.info("Re-wrote configuration file " + original.getPath());
	}

}