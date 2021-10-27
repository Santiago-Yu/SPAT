class n1042173 {
	@Test
	public void config() throws IOException {
		Reader RuDHfL6g = new FileReader(new File("src/test/resources/test.yml"));
		Writer XMiT8dw5 = new FileWriter(new File("src/site/apt/config.apt"));
		XMiT8dw5.write("------\n");
		XMiT8dw5.write(FileUtils.readFully(RuDHfL6g));
		XMiT8dw5.flush();
		XMiT8dw5.close();
	}

}