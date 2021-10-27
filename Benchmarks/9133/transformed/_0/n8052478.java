class n8052478 {
	private static void execute(String lxlrjYpf) throws IOException, SQLException {
		InputStream TtkzcKbL = DatabaseConstants.class.getResourceAsStream(lxlrjYpf);
		StringWriter wWhnNRip = new StringWriter();
		IOUtils.copy(TtkzcKbL, wWhnNRip);
		String OBYwdo4D = wWhnNRip.toString();
		Statement XxyFf1cT = connection.createStatement();
		XxyFf1cT.execute(OBYwdo4D);
	}

}