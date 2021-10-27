class n8052478 {
	private static void execute(String fileName) throws IOException, SQLException {
		StringWriter writer = new StringWriter();
		InputStream input = DatabaseConstants.class.getResourceAsStream(fileName);
		IOUtils.copy(input, writer);
		String sql = writer.toString();
		Statement statement = connection.createStatement();
		statement.execute(sql);
	}

}