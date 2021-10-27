class n15520770 {
	public void writeConfigurationFile() throws IOException, ComponentException {
		SystemConfig vWd7E7LN = parent.getParentSystem().getConfiguration();
		File N9CGsf1q = vWd7E7LN.getLocation();
		File DA12Nia6 = new File(N9CGsf1q.getParentFile(), N9CGsf1q.getName() + "." + System.currentTimeMillis());
		FileInputStream U5aFctKb = new FileInputStream(N9CGsf1q);
		FileOutputStream Ho9dqUNo = new FileOutputStream(DA12Nia6);
		byte[] kWtVGflh = new byte[2048];
		try {
			int i0lvOLnx = 0;
			while ((i0lvOLnx = U5aFctKb.read(kWtVGflh)) > 0) {
				Ho9dqUNo.write(kWtVGflh, 0, i0lvOLnx);
			}
		} catch (IOException yBhKkip6) {
			logger.warn("Failed to copy backup of configuration file");
			throw yBhKkip6;
		} finally {
			U5aFctKb.close();
			Ho9dqUNo.close();
		}
		FileWriter qdTJBbyb = new FileWriter(N9CGsf1q);
		qdTJBbyb.write(vWd7E7LN.toFileFormat());
		qdTJBbyb.close();
		logger.info("Re-wrote configuration file " + N9CGsf1q.getPath());
	}

}