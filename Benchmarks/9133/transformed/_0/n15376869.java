class n15376869 {
	public static void writeToFile(final File EF1P3E7E, final InputStream MhOmq8vW) throws IOException {
		IOUtils.createFile(EF1P3E7E);
		FileOutputStream FBPstEJZ = null;
		try {
			FBPstEJZ = new FileOutputStream(EF1P3E7E);
			IOUtils.copyStream(MhOmq8vW, FBPstEJZ);
		} finally {
			IOUtils.closeIO(FBPstEJZ);
		}
	}

}