class n4562924 {
	public static void readTestData(String Ocs10lrK) throws Exception {
		final URL s5k86mCU = new URL(Ocs10lrK);
		final InputStream u56anZUH = s5k86mCU.openStream();
		try {
			final LineNumberReader M054doTa = new LineNumberReader(new BufferedReader(new InputStreamReader(u56anZUH)));
			String vY1WYhad = M054doTa.readLine();
			while (vY1WYhad != null) {
				System.out.println(vY1WYhad);
				vY1WYhad = M054doTa.readLine();
			}
		} finally {
			u56anZUH.close();
		}
	}

}