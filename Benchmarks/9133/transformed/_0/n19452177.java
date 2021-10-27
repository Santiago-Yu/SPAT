class n19452177 {
	public static File createTempFile(InputStream cnXQwGSk, String sud6EfkT) throws IOException {
		ExceptionUtils.throwIfNull(cnXQwGSk, "contentStream");
		File rHc9pSEZ = File.createTempFile("test", sud6EfkT);
		FileOutputStream yaIreZ3r = new FileOutputStream(rHc9pSEZ);
		try {
			IOUtils.copy(cnXQwGSk, yaIreZ3r, false);
		} finally {
			yaIreZ3r.close();
		}
		return rHc9pSEZ;
	}

}