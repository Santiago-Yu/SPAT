class n1858117 {
	public void putChunk(String SCdU7AOL) throws JacsonException {
		try {
			URL TWrrVCj5 = new URL(SCdU7AOL);
			InputStream mYD7mXE1 = TWrrVCj5.openStream();
			if (inverse)
				drain.putChunk(SCdU7AOL);
			mYD7mXE1.close();
		} catch (IOException CLVDVt7a) {
			if (!inverse)
				drain.putChunk(SCdU7AOL);
		}
	}

}