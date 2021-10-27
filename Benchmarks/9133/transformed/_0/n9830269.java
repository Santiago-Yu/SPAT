class n9830269 {
	public final void deliver(final String kiYBKBAT, final String Fj5ge6YG, final InputStream psJ1eDNA)
			throws TooMuchDataException, IOException {
		System.out.println("FROM: " + kiYBKBAT);
		System.out.println("TO: " + Fj5ge6YG);
		final File A4IjtPjB = new File(System.getProperty("java.io.tmpdir"));
		final File D9RkEzGt = new File(A4IjtPjB, Fj5ge6YG);
		final FileWriter w5afvrEQ = new FileWriter(D9RkEzGt);
		try {
			IOUtils.copy(psJ1eDNA, w5afvrEQ);
		} finally {
			w5afvrEQ.close();
		}
	}

}