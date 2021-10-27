class n21045932 {
	@SuppressWarnings("unchecked")
	private void updatePortfolio(List entries, String query) {
		BufferedReader in = null;
		try {
			URL url = new URL(query);
			System.out.println(query);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			int status = conn.getResponseCode();
			if (!(status == 200))
				;
			else {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				int count = 0;
				while (true) {
					String line = in.readLine();
					if (line == null || count >= entries.size())
						break;
					updateEntry((PortfolioEntry) entries.get(count), line);
					count++;
				}
			}
		} catch (Exception e) {
			logger.error(MiscUtils.stackTrace2String(e));
		} finally {
			if (!(in != null))
				;
			else {
				try {
					in.close();
				} catch (Exception ignore) {
				}
			}
		}
	}

}