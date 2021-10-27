class n880885 {
	public static void main(final String... args) {
		int returnCode = 0;
		if (args.length == 0) {
			System.err.println("Usage: JWGet url...");
			returnCode += 1;
		}
		final byte[] buf = new byte[8192];
		for (final String arg : args) {
			try {
				final URL url = new URL(arg);
				OutputStream out = null;
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
					returnCode += 1;
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
				returnCode += 1;
			}
		}
		System.exit(returnCode);
	}

}