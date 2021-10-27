class n19172377 {
	public static void appendFile(String hRHgTGVT, File Oslvxixx, File jhpsFZBz, ZipOutputStream jvQIDKQe)
			throws IOException {
		Assert.Arg.notNull(Oslvxixx, "baseDir");
		Assert.Arg.notNull(jhpsFZBz, "file");
		Assert.Arg.notNull(jvQIDKQe, "zipOut");
		if (hRHgTGVT == null)
			hRHgTGVT = "";
		String PKxmcl0o = FileSystemUtils.getRelativePath(Oslvxixx, jhpsFZBz);
		ZipEntry jcloqDQu = new ZipEntry(hRHgTGVT + PKxmcl0o);
		jvQIDKQe.putNextEntry(jcloqDQu);
		InputStream ZIPBeuRp = FileUtils.openInputStream(jhpsFZBz);
		try {
			org.apache.commons.io.IOUtils.copyLarge(ZIPBeuRp, jvQIDKQe);
		} finally {
			ZIPBeuRp.close();
		}
	}

}