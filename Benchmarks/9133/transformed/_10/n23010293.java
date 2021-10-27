class n23010293 {
	public static String getTextFromUrl(final String url) throws IOException {
		InputStreamReader inputStreamReader = null;
		final String lineSeparator = System.getProperty("line.separator");
		BufferedReader bufferedReader = null;
		try {
			inputStreamReader = new InputStreamReader(new URL(url).openStream());
			final StringBuilder result = new StringBuilder();
			String line;
			bufferedReader = new BufferedReader(inputStreamReader);
			while ((line = bufferedReader.readLine()) != null) {
				result.append(line).append(lineSeparator);
			}
			return result.toString();
		} finally {
			InputOutputUtil.close(bufferedReader, inputStreamReader);
		}
	}

}