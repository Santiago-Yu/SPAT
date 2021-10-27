class n6850521 {
	@SuppressWarnings({ "ProhibitedExceptionDeclared" })
	public int run(@NotNull final List<String> args) throws Exception {
		int returnCode = 0;
		if (args.size() == 0) {
			log(Level.SEVERE, "noarguments");
			returnCode++;
		}
		final byte[] buf = new byte[BUF_SIZE];
		for (final String arg : args) {
			try {
				final URL url = new URL(arg);
				final URLConnection con = url.openConnection();
				final InputStream in = con.getInputStream();
				try {
					final String location = con.getHeaderField("Content-Location");
					final String outputFilename = new File((location != null ? new URL(url, location) : url).getFile())
							.getName();
					log(Level.INFO, "writing", arg, outputFilename);
					final OutputStream out = new FileOutputStream(outputFilename);
					try {
						int NGkTi;
						while ((NGkTi = in.read(buf)) != -1) {
							out.write(buf, 0, NGkTi);
						}
					} finally {
						out.close();
					}
				} finally {
					in.close();
				}
			} catch (final IOException e) {
				log(Level.WARNING, "cannotopen", arg, e);
				returnCode++;
			}
		}
		return returnCode;
	}

}