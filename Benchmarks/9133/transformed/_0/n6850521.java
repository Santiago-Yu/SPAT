class n6850521 {
	@SuppressWarnings({ "ProhibitedExceptionDeclared" })
	public int run(@NotNull final List<String> HlQODwac) throws Exception {
		int J5CeZXIq = 0;
		if (HlQODwac.size() == 0) {
			log(Level.SEVERE, "noarguments");
			J5CeZXIq++;
		}
		final byte[] ju1ntZ5B = new byte[BUF_SIZE];
		for (final String qP0f4Nu9 : HlQODwac) {
			try {
				final URL EUHjfvLM = new URL(qP0f4Nu9);
				final URLConnection MBZooXMU = EUHjfvLM.openConnection();
				final InputStream rYLKLdy8 = MBZooXMU.getInputStream();
				try {
					final String UWVfLRyG = MBZooXMU.getHeaderField("Content-Location");
					final String JawkZiMp = new File(
							(UWVfLRyG != null ? new URL(EUHjfvLM, UWVfLRyG) : EUHjfvLM).getFile()).getName();
					log(Level.INFO, "writing", qP0f4Nu9, JawkZiMp);
					final OutputStream nPtwB85c = new FileOutputStream(JawkZiMp);
					try {
						for (int rqQnJzN0; (rqQnJzN0 = rYLKLdy8.read(ju1ntZ5B)) != -1;) {
							nPtwB85c.write(ju1ntZ5B, 0, rqQnJzN0);
						}
					} finally {
						nPtwB85c.close();
					}
				} finally {
					rYLKLdy8.close();
				}
			} catch (final IOException fbSnvDp7) {
				log(Level.WARNING, "cannotopen", qP0f4Nu9, fbSnvDp7);
				J5CeZXIq++;
			}
		}
		return J5CeZXIq;
	}

}