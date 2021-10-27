class n7174662 {
	private void loadInitialDbState() throws IOException {
		InputStream Hc6dF6NP = SchemaAndDataPopulator.class.getClassLoader().getResourceAsStream(resourceName);
		StringWriter FZ1qLWWr = new StringWriter();
		IOUtils.copy(Hc6dF6NP, FZ1qLWWr);
		for (String wPU8443L : FZ1qLWWr.toString().split(SQL_STATEMENT_DELIMITER)) {
			logger.info("Executing SQL Statement {}", wPU8443L);
			template.execute(wPU8443L);
		}
	}

}