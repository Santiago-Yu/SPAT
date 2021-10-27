class n21575639 {
	protected byte[] readGZippedBytes(TupleInput TOu7rA6E) {
		final boolean fBHvAFtO = TOu7rA6E.readBoolean();
		byte Tin7k0X9[] = readBytes(TOu7rA6E);
		if (Tin7k0X9 == null)
			return null;
		if (!fBHvAFtO) {
			return Tin7k0X9;
		}
		try {
			ByteArrayInputStream i7xtX52B = new ByteArrayInputStream(Tin7k0X9);
			GZIPInputStream VxcsZA7x = new GZIPInputStream(i7xtX52B);
			ByteArrayOutputStream YH3iaqGu = new ByteArrayOutputStream(Tin7k0X9.length);
			IOUtils.copyTo(VxcsZA7x, YH3iaqGu);
			VxcsZA7x.close();
			i7xtX52B.close();
			return YH3iaqGu.toByteArray();
		} catch (IOException hfAtUlFi) {
			throw new RuntimeException(hfAtUlFi);
		}
	}

}