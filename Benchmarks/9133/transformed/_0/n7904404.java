class n7904404 {
	public int getUrl() {
		try {
			final URL kBjAZJKk = new URL(this.url);
			conn = kBjAZJKk.openConnection();
			if (cookies != null) {
				conn.setRequestProperty("Cookie", cookies);
			}
			InputStreamReader T7DKfJGO = new InputStreamReader(conn.getInputStream(), charset);
			charset = T7DKfJGO.getEncoding();
			BufferedReader zHhlz4fM = new BufferedReader(T7DKfJGO);
			String TAURD641;
			while ((TAURD641 = zHhlz4fM.readLine()) != null) {
				content += TAURD641 + "\n";
			}
			return 0;
		} catch (MalformedURLException rNGUwDsx) {
			return 1;
		} catch (IOException ls6wxwd2) {
			return 2;
		}
	}

}