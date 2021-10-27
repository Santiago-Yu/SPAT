class n22619332 {
	protected List<Datastream> getDatastreams(final DepositCollection pDeposit) throws IOException, SWORDException {
		LOG.debug("copying file");
		String tTempFileName = this.getTempDir() + "uploaded-file.tmp";
		IOUtils.copy(pDeposit.getFile(), new FileOutputStream(tTempFileName));
		List<Datastream> tDatastreams = new ArrayList<Datastream>();
		Datastream tDatastream = new LocalDatastream(this.getGenericFileName(pDeposit), this.getContentType(),
				tTempFileName);
		tDatastreams.add(tDatastream);
		return tDatastreams;
	}

}