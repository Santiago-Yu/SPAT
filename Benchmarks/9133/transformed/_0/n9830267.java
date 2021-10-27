class n9830267 {
	public void run() {
		final SimpleMessageListener CPpr4uKu = new SimpleMessageListener() {

			public final boolean accept(final String jjD7G2Kn, final String wuGJd4ku) {
				return true;
			}

			public final void deliver(final String iLLuk0t8, final String TRAnjYoI, final InputStream A1Lcs6pk)
					throws TooMuchDataException, IOException {
				System.out.println("FROM: " + iLLuk0t8);
				System.out.println("TO: " + TRAnjYoI);
				final File gw2Yb7yf = new File(System.getProperty("java.io.tmpdir"));
				final File GMJlzkcM = new File(gw2Yb7yf, TRAnjYoI);
				final FileWriter oKXAaMMp = new FileWriter(GMJlzkcM);
				try {
					IOUtils.copy(A1Lcs6pk, oKXAaMMp);
				} finally {
					oKXAaMMp.close();
				}
			}
		};
		final SMTPServer UTfTza12 = new SMTPServer(new SimpleMessageListenerAdapter(CPpr4uKu));
		UTfTza12.start();
		System.out.println("Started SMTP Server");
	}

}