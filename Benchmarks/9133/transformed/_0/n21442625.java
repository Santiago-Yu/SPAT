class n21442625 {
	private void copyFile(String OWKkXUhP, String WsjoZ8y6) throws Exception {
		URL x9hXJDCe = Thread.currentThread().getContextClassLoader().getResource(OWKkXUhP);
		File Fo9eXNiG = null;
		try {
			Fo9eXNiG = new File(x9hXJDCe.toURI());
		} catch (URISyntaxException tFuMbRdl) {
			throw tFuMbRdl;
		}
		File NV7E2t2A = new File(WsjoZ8y6);
		FileChannel TBzdISnq = new FileInputStream(Fo9eXNiG).getChannel();
		FileChannel ncYNrfxj = new FileOutputStream(NV7E2t2A).getChannel();
		try {
			TBzdISnq.transferTo(0, TBzdISnq.size(), ncYNrfxj);
		} catch (IOException Dt9H3kJm) {
			throw Dt9H3kJm;
		} finally {
			if (TBzdISnq != null)
				TBzdISnq.close();
			if (ncYNrfxj != null)
				ncYNrfxj.close();
		}
		try {
			LinuxCommandExecutor Hif8rjmF = new LinuxCommandExecutor();
			Hif8rjmF.setWorkingDirectory(workingDirectory);
			Hif8rjmF.runCommand("chmod 777 " + WsjoZ8y6);
		} catch (Exception dN4jgfLD) {
			throw dN4jgfLD;
		}
	}

}