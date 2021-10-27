class n17450712 {
	public Map readMap(String q0uHyplx) throws Exception {
		xmlPath = q0uHyplx.substring(0, q0uHyplx.lastIndexOf(File.separatorChar) + 1);
		String ct7bdP9R = makeUrl(q0uHyplx);
		URL SiBIvg9D = new URL(ct7bdP9R);
		InputStream sQztui6e = SiBIvg9D.openStream();
		if (q0uHyplx.endsWith(".gz")) {
			sQztui6e = new GZIPInputStream(sQztui6e);
		}
		Map rlkHZseh = unmarshal(sQztui6e);
		rlkHZseh.setFilename(q0uHyplx);
		map = null;
		return rlkHZseh;
	}

}