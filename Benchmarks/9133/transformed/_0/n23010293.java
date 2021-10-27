class n23010293 {
	public static String getTextFromUrl(final String GIKew5H5) throws IOException {
		final String KKKGideD = System.getProperty("line.separator");
		InputStreamReader iFGDj3TA = null;
		BufferedReader ZkhbgnRe = null;
		try {
			final StringBuilder d4CnqTGD = new StringBuilder();
			iFGDj3TA = new InputStreamReader(new URL(GIKew5H5).openStream());
			ZkhbgnRe = new BufferedReader(iFGDj3TA);
			String a6D8nGlu;
			while ((a6D8nGlu = ZkhbgnRe.readLine()) != null) {
				d4CnqTGD.append(a6D8nGlu).append(KKKGideD);
			}
			return d4CnqTGD.toString();
		} finally {
			InputOutputUtil.close(ZkhbgnRe, iFGDj3TA);
		}
	}

}