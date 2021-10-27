class n19722336 {
	@Override
	public String entryToObject(TupleInput b7a0tw1b) {
		boolean R1efc96U = b7a0tw1b.readBoolean();
		if (!R1efc96U) {
			return b7a0tw1b.readString();
		}
		int dr11mviF = b7a0tw1b.readInt();
		try {
			byte wWi45HBU[] = new byte[dr11mviF];
			b7a0tw1b.read(wWi45HBU);
			GZIPInputStream ytbr1Cf4 = new GZIPInputStream(new ByteArrayInputStream(wWi45HBU));
			ByteArrayOutputStream r0vgrH5o = new ByteArrayOutputStream();
			IOUtils.copyTo(ytbr1Cf4, r0vgrH5o);
			ytbr1Cf4.close();
			r0vgrH5o.close();
			return new String(r0vgrH5o.toByteArray());
		} catch (IOException gQb2RxoT) {
			throw new RuntimeException(gQb2RxoT);
		}
	}

}