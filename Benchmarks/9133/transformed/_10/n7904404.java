class n7904404 {
	public int getUrl() {
		try {
			final URL url = new URL(this.url);
			conn = url.openConnection();
			if (cookies != null) {
				conn.setRequestProperty("Cookie", cookies);
			}
			InputStreamReader inputstream = new InputStreamReader(conn.getInputStream(), charset);
			charset = inputstream.getEncoding();
			String line;
			BufferedReader input = new BufferedReader(inputstream);
			while ((line = input.readLine()) != null) {
				content += line + "\n";
			}
			return 0;
		} catch (MalformedURLException e) {
			return 1;
		} catch (IOException e2) {
			return 2;
		}
	}

}