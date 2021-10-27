class n9819955 {
	@Override
	public void write(OutputStream Qb6jQXgP) throws IOException, WebApplicationException {
		final ByteArrayOutputStream h7o1OH6o = new ByteArrayOutputStream();
		final GZIPOutputStream ZTCpaCqe = new GZIPOutputStream(h7o1OH6o);
		IOUtils.copy(is, ZTCpaCqe);
		h7o1OH6o.close();
		ZTCpaCqe.close();
		Qb6jQXgP.write(h7o1OH6o.toByteArray());
	}

}