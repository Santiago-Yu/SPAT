class n2199604 {
	private static void unzipEntry(ZipFile n34IOGBi, ZipEntry xELcuv24, File r8oW529f) throws IOException {
		if (xELcuv24.isDirectory()) {
			createDir(new File(r8oW529f, xELcuv24.getName()));
			return;
		}
		File sm0uxwRM = new File(r8oW529f, xELcuv24.getName());
		if (!sm0uxwRM.getParentFile().exists()) {
			createDir(sm0uxwRM.getParentFile());
		}
		BufferedInputStream tZN1Osed = new BufferedInputStream(n34IOGBi.getInputStream(xELcuv24));
		BufferedOutputStream zZ5Cm2UP = new BufferedOutputStream(new FileOutputStream(sm0uxwRM));
		try {
			IOUtils.copy(tZN1Osed, zZ5Cm2UP);
		} finally {
			zZ5Cm2UP.close();
			tZN1Osed.close();
		}
	}

}