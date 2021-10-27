class n7066835 {
	protected List<Datastream> getDatastreams(final DepositCollection ZXwWWa1o) throws IOException, SWORDException {
		List<Datastream> xBX4OJY5 = new ArrayList<Datastream>();
		LOG.debug("copying file");
		String xHMbUCto = super.getTempDir() + "uploaded-file.tmp";
		IOUtils.copy(ZXwWWa1o.getFile(), new FileOutputStream(xHMbUCto));
		Datastream dBWM7ych = new LocalDatastream(super.getGenericFileName(ZXwWWa1o), this.getContentType(), xHMbUCto);
		xBX4OJY5.add(dBWM7ych);
		xBX4OJY5.addAll(_zipFile.getFiles(xHMbUCto));
		return xBX4OJY5;
	}

}