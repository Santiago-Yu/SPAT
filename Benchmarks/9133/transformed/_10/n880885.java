class n880885 {
	public static void main(final String... args) {
		int returnCode = 0;
		final byte[] buf = new byte[8192];
		if (args.length == 0) {
			System.err.println("Usage: JWGet url...");
			returnCode++;
		}
		for (final String arg : args) {
			try {
				OutputStream out = null;
				final URL url = new URL(arg);
				InputStream in = null;
				try {
					final URLConnection con = url.openConnection();
					in = con.getInputStream();
					final String location = con.getHeaderField("Content-Location");
					final String outputFilename = new File((location != null ? new URL(url, location) : url).getFile())
							.getName();
					System.err.println(outputFilename);
					out = new FileOutputStream(outputFilename);
					for (int bytesRead; (bytesRead = in.read(buf)) != -1; out.write(buf, 0, bytesRead))
						;
				} catch (final IOException e) {
					System.err.println(e);
					returnCode++;
				} finally {
					try {
						in.close();
					} catch (final Exception ignore) {
					}
					try {
						out.close();
					} catch (final Exception ignore) {
					}
				}
			} catch (final MalformedURLException e) {
				System.err.println(e);
				returnCode++;
			}
		}
		System.exit(returnCode);
	}

}