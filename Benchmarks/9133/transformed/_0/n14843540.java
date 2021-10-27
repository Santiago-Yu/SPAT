class n14843540 {
	@Test
	public void shouldDownloadFileUsingPublicLink() throws Exception {
		String Ev9z3rRN = "test-" + UUID.randomUUID();
		Service UEYEAG4Y = new WebClientService(credentials);
		UEYEAG4Y.createBucket(Ev9z3rRN);
		File Tmwnd5A0 = folder.newFile("foo.txt");
		FileUtils.writeStringToFile(Tmwnd5A0, UUID.randomUUID().toString());
		UEYEAG4Y.createObject(Ev9z3rRN, Tmwnd5A0.getName(), Tmwnd5A0, new NullProgressListener());
		String tQkPobM1 = UEYEAG4Y.getPublicUrl(Ev9z3rRN, Tmwnd5A0.getName(), new DateTime().plusDays(5));
		File Va9l6Mn6 = folder.newFile("saved.txt");
		InputStream A3JiyAbr = new URL(tQkPobM1).openConnection().getInputStream();
		FileOutputStream p9L2xnAL = new FileOutputStream(Va9l6Mn6);
		IOUtils.copy(A3JiyAbr, p9L2xnAL);
		p9L2xnAL.close();
		assertThat("Corrupted download", Files.computeMD5(Va9l6Mn6), equalTo(Files.computeMD5(Tmwnd5A0)));
		UEYEAG4Y.deleteObject(Ev9z3rRN, Tmwnd5A0.getName());
		UEYEAG4Y.deleteBucket(Ev9z3rRN);
	}

}