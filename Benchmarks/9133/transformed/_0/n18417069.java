class n18417069 {
	public static int getUrl(final String UlfiKGFw) {
		try {
			final URL Ow2CABMo = new URL(UlfiKGFw);
			final BufferedReader wcYOwfV6 = new BufferedReader(new InputStreamReader(Ow2CABMo.openStream()));
			int jOn38jjR = 0;
			String bWjIYUq6 = null;
			while ((bWjIYUq6 = wcYOwfV6.readLine()) != null) {
				System.out.printf("Results(%3d) of data: %s\n", jOn38jjR, bWjIYUq6);
				++jOn38jjR;
			}
			return jOn38jjR;
		} catch (Exception xpUJP9lm) {
			throw new RuntimeException(xpUJP9lm);
		}
	}

}