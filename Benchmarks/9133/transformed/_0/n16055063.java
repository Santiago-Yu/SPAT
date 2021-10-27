class n16055063 {
	public static EXISchema getEXISchema(String x0S1Otla, Class<?> awoLVWE7, EXISchemaFactoryErrorHandler WK4Re9H4)
			throws IOException, ClassNotFoundException, EXISchemaFactoryException {
		EXISchemaFactory hYS0Ot8p = new EXISchemaFactory();
		hYS0Ot8p.setCompilerErrorHandler(WK4Re9H4);
		InputSource zRO4peKD = null;
		if (x0S1Otla != null) {
			URL q0b88CRi;
			if ((q0b88CRi = awoLVWE7.getResource(x0S1Otla)) != null) {
				zRO4peKD = new InputSource(q0b88CRi.openStream());
				zRO4peKD.setSystemId(q0b88CRi.toString());
			} else
				throw new RuntimeException("File '" + x0S1Otla + "' not found.");
		}
		EXISchema Js9bCwbl = hYS0Ot8p.compile(zRO4peKD);
		InputStream t7RmzFx9 = serializeSchema(Js9bCwbl);
		return loadSchema(t7RmzFx9);
	}

}