class n880885 {
	public static void main(final String... xPtOQyAL) {
		int sXZMe6bF = 0;
		if (xPtOQyAL.length == 0) {
			System.err.println("Usage: JWGet url...");
			sXZMe6bF++;
		}
		final byte[] WynZ7yME = new byte[8192];
		for (final String Xfk3abhx : xPtOQyAL) {
			try {
				final URL iUUnp3t2 = new URL(Xfk3abhx);
				OutputStream wOzNSXdQ = null;
				InputStream sf53tZhU = null;
				try {
					final URLConnection zBrizrGh = iUUnp3t2.openConnection();
					sf53tZhU = zBrizrGh.getInputStream();
					final String bluMaGxp = zBrizrGh.getHeaderField("Content-Location");
					final String uiD4AbVO = new File(
							(bluMaGxp != null ? new URL(iUUnp3t2, bluMaGxp) : iUUnp3t2).getFile()).getName();
					System.err.println(uiD4AbVO);
					wOzNSXdQ = new FileOutputStream(uiD4AbVO);
					for (int lbzEM2v3; (lbzEM2v3 = sf53tZhU.read(WynZ7yME)) != -1; wOzNSXdQ.write(WynZ7yME, 0,
							lbzEM2v3))
						;
				} catch (final IOException gMqAZV8O) {
					System.err.println(gMqAZV8O);
					sXZMe6bF++;
				} finally {
					try {
						sf53tZhU.close();
					} catch (final Exception zdd5fHdQ) {
					}
					try {
						wOzNSXdQ.close();
					} catch (final Exception VGiOpnq0) {
					}
				}
			} catch (final MalformedURLException dHnVAgC5) {
				System.err.println(dHnVAgC5);
				sXZMe6bF++;
			}
		}
		System.exit(sXZMe6bF);
	}

}