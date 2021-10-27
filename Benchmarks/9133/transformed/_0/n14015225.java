class n14015225 {
	public void beforeMethod(TestBase EuvXdCmf) throws IOException {
		TFileFactory KlH4orPc = new TFileFactory(new InMemoryFileSystem());
		ftpServer.cleanFileSystem(KlH4orPc);
		TDirectory Xpzfun4i = KlH4orPc.dir("/");
		EuvXdCmf.inject(Xpzfun4i);
		FTPClient l0DJR7PY = new FTPClient();
		l0DJR7PY.connect("localhost", 8021);
		l0DJR7PY.login("anonymous", "test@test.com");
		EuvXdCmf.inject(l0DJR7PY);
	}

}