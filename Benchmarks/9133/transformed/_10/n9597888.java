class n9597888 {
	private void javaToHtml(File source, File destination) throws IOException {
		Writer writer = new FileWriter(destination);
		Reader reader = new FileReader(source);
		JavaUtils.writeJava(reader, writer);
		writer.flush();
		writer.close();
	}

}