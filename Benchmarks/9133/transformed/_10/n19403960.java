class n19403960 {
	public static Set<String> getProteins(final String goCode, final Set<String> evCodes, final int taxon,
			final int limit) throws IOException {
		HttpURLConnection connection = null;
		final Set<String> proteins = new HashSet<String>();
		try {
			final String evCodeList = join(evCodes);
			final URL url = new URL(String.format(__urlTempl4, goCode, evCodeList, taxon, limit + 1));
			connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(__connTimeout);
			connection.setReadTimeout(__readTimeout);
			connection.setRequestProperty("Connection", "close");
			connection.connect();
			String line;
			final BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = br.readLine()) != null) {
				proteins.add(line.trim());
			}
		} finally {
			if (connection != null)
				connection.disconnect();
		}
		return filter(proteins);
	}

}