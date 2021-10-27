class n14341903 {
	private static void processFile(String file) throws IOException {
		int read = 0;
		FileInputStream in = new FileInputStream(file);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		byte[] buf = new byte[2048];
		while ((read = in.read(buf)) > 0)
			bout.write(buf, 0, read);
		in.close();
		FileOutputStream out = new FileOutputStream(file);
		String converted = bout.toString().replaceAll("@project.name@", projectNameS)
				.replaceAll("@base.package@", basePackageS).replaceAll("@base.dir@", baseDir)
				.replaceAll("@webapp.dir@", webAppDir)
				.replaceAll("path=\"target/classes\"", "path=\"src/main/webapp/WEB-INF/classes\"");
		out.write(converted.getBytes());
		out.close();
	}

}