class n22619332 {
	protected List<Datastream> getDatastreams(final DepositCollection MUJX23ie) throws IOException, SWORDException {
		LOG.debug("copying file");
		String vlaV06F0 = this.getTempDir() + "uploaded-file.tmp";
		IOUtils.copy(MUJX23ie.getFile(), new FileOutputStream(vlaV06F0));
		Datastream qSXW5o1N = new LocalDatastream(this.getGenericFileName(MUJX23ie), this.getContentType(), vlaV06F0);
		List<Datastream> TX4ueWYZ = new ArrayList<Datastream>();
		TX4ueWYZ.add(qSXW5o1N);
		return TX4ueWYZ;
	}

}