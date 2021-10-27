class n10634007 {
	public static EXISchema getEXISchema(String HR6oLlN9, Class<?> LJY9a7VX, EXISchemaFactoryErrorHandler ZIKOClEc)
			throws IOException, ClassNotFoundException, EXISchemaFactoryException {
		EXISchemaFactory rhuz1dfb = new EXISchemaFactory();
		rhuz1dfb.setCompilerErrorHandler(ZIKOClEc);
		InputSource AXzFRHnw = null;
		if (HR6oLlN9 != null) {
			URL rRPseXgB;
			if ((rRPseXgB = LJY9a7VX.getResource(HR6oLlN9)) != null) {
				AXzFRHnw = new InputSource(rRPseXgB.openStream());
				AXzFRHnw.setSystemId(rRPseXgB.toString());
			} else
				throw new RuntimeException("File '" + HR6oLlN9 + "' not found.");
		}
		EXISchema L1hldIkH = rhuz1dfb.compile(AXzFRHnw);
		InputStream FPHyUNPN = serializeSchema(L1hldIkH);
		return loadSchema(FPHyUNPN);
	}

}