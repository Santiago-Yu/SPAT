class n10228411 {
	public File createReadmeFile(File dir, MavenProject mavenProject) throws IOException {
		StringWriter sw = new StringWriter();
		InputStream is = getClass().getResourceAsStream("README.template");
		IOUtils.copy(is, sw);
		String content = sw.getBuffer().toString();
		File readme = new File(dir, "README.TXT");
		content = StringUtils.replace(content, "{project_name}", mavenProject.getArtifactId());
		FileUtils.writeStringToFile(readme, content);
		return readme;
	}

}