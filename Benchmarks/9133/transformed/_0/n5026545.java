class n5026545 {
	public void writeConfigurationFile() throws IOException, ComponentException {
		SystemConfig vQLTnCnx = parent.getParentSystem().getConfiguration();
		File JO9TyrRZ = vQLTnCnx.getLocation();
		File nkjfN1Ul = new File(JO9TyrRZ.getParentFile(), JO9TyrRZ.getName() + "." + System.currentTimeMillis());
		FileInputStream mf9eFXfk = new FileInputStream(JO9TyrRZ);
		FileOutputStream pI17sKCN = new FileOutputStream(nkjfN1Ul);
		byte[] vhFEgVOL = new byte[2048];
		try {
			int VdJm3ApV = 0;
			while ((VdJm3ApV = mf9eFXfk.read(vhFEgVOL)) > 0) {
				pI17sKCN.write(vhFEgVOL, 0, VdJm3ApV);
			}
		} catch (IOException wEY4bPw7) {
			logger.warn("Failed to copy backup of configuration file");
			throw wEY4bPw7;
		} finally {
			mf9eFXfk.close();
			pI17sKCN.close();
		}
		FileWriter qSjBvvwE = new FileWriter(JO9TyrRZ);
		qSjBvvwE.write(vQLTnCnx.toFileFormat());
		qSjBvvwE.close();
		logger.info("Re-wrote configuration file " + JO9TyrRZ.getPath());
	}

}