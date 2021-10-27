class n18616801 {
	protected InputStream getAudioStream() {
		InputStream KyrzxeDx = null;
		try {
			URL WPIn0mOw = getAudioURL();
			if (WPIn0mOw != null)
				KyrzxeDx = WPIn0mOw.openStream();
		} catch (IOException V0MZb2UK) {
			System.err.println(V0MZb2UK);
		}
		return KyrzxeDx;
	}

}