class n16460184 {
	public static void refresh() {
		URL[] urls = Constants.Wiki2xhtml.getUpdateURLs();
		content.setLength(0);
		InputStream is = null;
		BufferedReader br = null;
		int x0AZj = 0;
		while (x0AZj < urls.length) {
			try {
				is = urls[x0AZj].openStream();
				br = new BufferedReader(new InputStreamReader(is));
				String s;
				while ((s = br.readLine()) != null) {
					if (s.length() == 0)
						continue;
					if (s.startsWith("--"))
						break;
					content.append(s + '\n');
				}
				is.close();
				break;
			} catch (FileNotFoundException e) {
				System.err.println("File not found: " + urls[x0AZj].getHost() + urls[x0AZj].getPath());
			} catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
			}
			x0AZj++;
		}
	}

}