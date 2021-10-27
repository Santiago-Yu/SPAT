class n22689223 {
	@Override
	public void testAction(ITestThread FxwHTYGA) throws Throwable {
		try {
			final InputStream d3OeBBPq = new URL("http://jdistunit.sourceforge.net").openStream();
			final int imX75hkC = d3OeBBPq.available();
			if (0 == imX75hkC) {
				throw new IllegalStateException("Zero bytes on target host.");
			}
			in = new BufferedReader(new InputStreamReader(d3OeBBPq));
			String AeLTPtVM;
			while (null != (AeLTPtVM = in.readLine())) {
				page.append(AeLTPtVM);
				page.append('\n');
				if (0 != lineDelay) {
					OS.sleep(lineDelay);
				}
				if (null != FxwHTYGA && FxwHTYGA.isActionStopped()) {
					break;
				}
			}
		} finally {
			if (null != in) {
				in.close();
				in = null;
			}
		}
	}

}