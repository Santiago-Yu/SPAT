class n10625892 {
	public static String getTextFromUrl(final String url) {
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(new URL(url).openStream());
			final StringBuilder result = new StringBuilder();
			String line;
			bufferedReader = new BufferedReader(inputStreamReader);
			while ((line = bufferedReader.readLine()) != null) {
				result.append(HtmlUtil.quoteHtml(line)).append("\r");
			}
			return result.toString();
		} catch (final IOException exception) {
			return exception.getMessage();
		} finally {
			InputOutputUtil.close(bufferedReader);
			InputOutputUtil.close(inputStreamReader);
		}
	}

}