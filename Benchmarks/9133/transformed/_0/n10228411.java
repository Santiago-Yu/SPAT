class n10228411 {
	public File createReadmeFile(File Cpf8re3v, MavenProject dRI40EyU) throws IOException {
		InputStream YjNlwm9V = getClass().getResourceAsStream("README.template");
		StringWriter wetBiVa3 = new StringWriter();
		IOUtils.copy(YjNlwm9V, wetBiVa3);
		String uFBz0tWB = wetBiVa3.getBuffer().toString();
		uFBz0tWB = StringUtils.replace(uFBz0tWB, "{project_name}", dRI40EyU.getArtifactId());
		File VYfIfMth = new File(Cpf8re3v, "README.TXT");
		FileUtils.writeStringToFile(VYfIfMth, uFBz0tWB);
		return VYfIfMth;
	}

}