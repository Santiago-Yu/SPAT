class n6597125 {
	public static void writeToFile(final File MDyqLy4v, final InputStream aqCnRn9F) throws IOException {
		IOUtils.createFile(MDyqLy4v);
		FileOutputStream YRSLImGZ = null;
		try {
			YRSLImGZ = new FileOutputStream(MDyqLy4v);
			IOUtils.copyStream(aqCnRn9F, YRSLImGZ);
		} finally {
			IOUtils.closeIO(YRSLImGZ);
		}
	}

}