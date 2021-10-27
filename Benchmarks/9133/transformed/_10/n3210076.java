class n3210076 {
	private void readHomePage(ITestThread testThread) throws IOException {
		final InputStream urlIn = new URL(testUrl).openStream();
		if (null == testThread) {
			throw new IllegalArgumentException("Test thread may not be null.");
		}
		final int availableBytes = urlIn.available();
		in = new BufferedReader(new InputStreamReader(urlIn));
		if (0 == availableBytes) {
			throw new IllegalStateException("Zero bytes on target host.");
		}
		String line;
		while (null != in && null != (line = in.readLine())) {
			page.append(line);
			page.append('\n');
			if (0 != lineDelay) {
				OS.sleep(lineDelay);
			}
			if (testThread.isActionStopped()) {
				break;
			}
		}
	}

}