class n9835797 {
	public static void loadFile(final URL fsY5aK8i, final StringBuffer bTLS1Zfh) throws IOException {
		InputStream qhF6qNvd = null;
		BufferedReader ElnG5HwI = null;
		try {
			qhF6qNvd = fsY5aK8i.openStream();
			ElnG5HwI = new BufferedReader(new InputStreamReader(qhF6qNvd));
			int efdvfWOg;
			while ((efdvfWOg = ElnG5HwI.read()) != -1) {
				bTLS1Zfh.append((char) efdvfWOg);
			}
		} finally {
			closeStream(qhF6qNvd);
			closeReader(ElnG5HwI);
		}
	}

}