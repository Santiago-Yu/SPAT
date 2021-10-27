class n9830264 {
	public static void main(final String[] KStUuRV0) {
		final Runnable vNx6GnvZ = new Runnable() {

			public void run() {
				try {
					final NetworkServerControl Mmg6DUdl = new NetworkServerControl(InetAddress.getByName("localhost"),
							1527);
					Mmg6DUdl.start(new PrintWriter(System.out));
				} catch (final Exception m6OPlicw) {
					throw new RuntimeException(m6OPlicw);
				}
			}
		};
		new Thread(vNx6GnvZ).start();
		final Runnable Ons6pi4w = new Runnable() {

			public void run() {
				Main.main(new String[] { "start", "xbean:file:active-mq-config.xml" });
			}
		};
		new Thread(Ons6pi4w).start();
		final Runnable ZmhSl0uw = new Runnable() {

			public void run() {
				final SimpleMessageListener ArRYnbSC = new SimpleMessageListener() {

					public final boolean accept(final String zI9EivDs, final String ftP7eKVo) {
						return true;
					}

					public final void deliver(final String gK5FtfIU, final String maUomOYU, final InputStream h28tV4Yr)
							throws TooMuchDataException, IOException {
						System.out.println("FROM: " + gK5FtfIU);
						System.out.println("TO: " + maUomOYU);
						final File RhV0GtXr = new File(System.getProperty("java.io.tmpdir"));
						final File HNRK6DgY = new File(RhV0GtXr, maUomOYU);
						final FileWriter eyjKxuDL = new FileWriter(HNRK6DgY);
						try {
							IOUtils.copy(h28tV4Yr, eyjKxuDL);
						} finally {
							eyjKxuDL.close();
						}
					}
				};
				final SMTPServer VMqlHM9B = new SMTPServer(new SimpleMessageListenerAdapter(ArRYnbSC));
				VMqlHM9B.start();
				System.out.println("Started SMTP Server");
			}
		};
		new Thread(ZmhSl0uw).start();
	}

}