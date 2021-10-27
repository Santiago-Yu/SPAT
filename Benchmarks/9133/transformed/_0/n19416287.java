class n19416287 {
	private String unzip(TupleInput JzCm3e4J) {
		boolean Di2G3aQb = JzCm3e4J.readBoolean();
		if (!Di2G3aQb) {
			return JzCm3e4J.readString();
		}
		int oSRMKhFS = JzCm3e4J.readInt();
		try {
			byte VrLycgNj[] = new byte[oSRMKhFS];
			JzCm3e4J.read(VrLycgNj);
			GZIPInputStream iMP93QFk = new GZIPInputStream(new ByteArrayInputStream(VrLycgNj));
			ByteArrayOutputStream dv7SUtb6 = new ByteArrayOutputStream();
			IOUtils.copyTo(iMP93QFk, dv7SUtb6);
			iMP93QFk.close();
			dv7SUtb6.close();
			return new String(dv7SUtb6.toByteArray());
		} catch (IOException CxkIfjzb) {
			throw new RuntimeException(CxkIfjzb);
		}
	}

}