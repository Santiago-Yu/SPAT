class n4277520 {
	private void loadMap(URI uri) throws IOException {
		InputStream stream = null;
		BufferedReader reader = null;
		try {
			URL url = uri.toURL();
			stream = url.openStream();
			if (url.getFile().endsWith(".gz")) {
				stream = new GZIPInputStream(stream);
			}
			String line;
			reader = new BufferedReader(new InputStreamReader(stream));
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.length() > 0) {
					String[] parts = line.split(" ");
					if (parts.length == 2) {
						pinyinZhuyinMap.put(parts[0], parts[1]);
						zhuyinPinyinMap.put(parts[1], parts[0]);
					}
				}
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

}