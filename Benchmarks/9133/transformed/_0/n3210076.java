class n3210076 {
	private void readHomePage(ITestThread XyEWvsyQ) throws IOException {
		if (null == XyEWvsyQ) {
			throw new IllegalArgumentException("Test thread may not be null.");
		}
		final InputStream fobgLdiT = new URL(testUrl).openStream();
		final int hD6A4Eeb = fobgLdiT.available();
		if (0 == hD6A4Eeb) {
			throw new IllegalStateException("Zero bytes on target host.");
		}
		in = new BufferedReader(new InputStreamReader(fobgLdiT));
		String adEYZxhm;
		while (null != in && null != (adEYZxhm = in.readLine())) {
			page.append(adEYZxhm);
			page.append('\n');
			if (0 != lineDelay) {
				OS.sleep(lineDelay);
			}
			if (XyEWvsyQ.isActionStopped()) {
				break;
			}
		}
	}

}