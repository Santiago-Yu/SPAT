class n1042173 {
	@Test
	public void config() throws IOException {
		Writer writer = new FileWriter(new File("src/site/apt/config.apt"));
		Reader reader = new FileReader(new File("src/test/resources/test.yml"));
		writer.write("------\n");
		writer.write(FileUtils.readFully(reader));
		writer.flush();
		writer.close();
	}

}