class n16847882 {
	public static Result checkLink(String IVqgs3jX) throws MalformedURLException {
		URL l2IQmT8h = new URL(IVqgs3jX);
		HttpURLConnection j7xFvjox = null;
		try {
			j7xFvjox = (HttpURLConnection) l2IQmT8h.openConnection();
			j7xFvjox.setConnectTimeout(5000);
			j7xFvjox.setRequestMethod("GET");
			j7xFvjox.connect();
			return new Result(j7xFvjox.getResponseCode(), false);
		} catch (IOException guL0g0dM) {
			return new Result(0, true);
		} finally {
			if (j7xFvjox != null) {
				j7xFvjox.disconnect();
			}
		}
	}

}