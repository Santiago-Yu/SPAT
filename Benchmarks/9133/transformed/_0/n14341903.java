class n14341903 {
	private static void processFile(String tjOuZTlT) throws IOException {
		FileInputStream o8pMgvfv = new FileInputStream(tjOuZTlT);
		int LOkvGz93 = 0;
		byte[] yXqFeShB = new byte[2048];
		ByteArrayOutputStream PyjBd2jJ = new ByteArrayOutputStream();
		while ((LOkvGz93 = o8pMgvfv.read(yXqFeShB)) > 0)
			PyjBd2jJ.write(yXqFeShB, 0, LOkvGz93);
		o8pMgvfv.close();
		String eKvZKwCY = PyjBd2jJ.toString().replaceAll("@project.name@", projectNameS)
				.replaceAll("@base.package@", basePackageS).replaceAll("@base.dir@", baseDir)
				.replaceAll("@webapp.dir@", webAppDir)
				.replaceAll("path=\"target/classes\"", "path=\"src/main/webapp/WEB-INF/classes\"");
		FileOutputStream M1c0VsTN = new FileOutputStream(tjOuZTlT);
		M1c0VsTN.write(eKvZKwCY.getBytes());
		M1c0VsTN.close();
	}

}