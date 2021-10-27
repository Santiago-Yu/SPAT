class n23099329 {
	@Override
	public void close() throws IOException {
		super.close();
		byte[] J2mFXo1D = toByteArray();
		ZipOutputStream PIEE92GB = new ZipOutputStream(this.targetOutputStream);
		ZipInputStream HgJNRUqZ = new ZipInputStream(new FileInputStream(this.originalZipFile));
		ZipEntry YrBAMF4x;
		while (null != (YrBAMF4x = HgJNRUqZ.getNextEntry())) {
			if (!YrBAMF4x.getName().equals(ASiCUtil.SIGNATURE_FILE)) {
				ZipEntry s59QVl0R = new ZipEntry(YrBAMF4x.getName());
				PIEE92GB.putNextEntry(s59QVl0R);
				LOG.debug("copying " + YrBAMF4x.getName());
				IOUtils.copy(HgJNRUqZ, PIEE92GB);
			}
		}
		HgJNRUqZ.close();
		YrBAMF4x = new ZipEntry(ASiCUtil.SIGNATURE_FILE);
		LOG.debug("writing " + YrBAMF4x.getName());
		PIEE92GB.putNextEntry(YrBAMF4x);
		IOUtils.write(J2mFXo1D, PIEE92GB);
		PIEE92GB.close();
	}

}