class n16460184 {
	public static void refresh() {
		URL[] urls = Constants.Wiki2xhtml.getUpdateURLs();
		content.setLength(0);
		BufferedReader br = null;
		InputStream is = null;
		for (int i = 0; i < urls.length; i++) {
			try {
				is = urls[i].openStream();
				String s;
				br = new BufferedReader(new InputStreamReader(is));
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
				System.err.println("File not found: " + urls[i].getHost() + urls[i].getPath());
			} catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

}