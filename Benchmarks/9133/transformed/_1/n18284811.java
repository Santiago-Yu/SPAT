class n18284811 {
	private Map<String, String> readStuff(Iterator<URL> urls) throws IOException {
		Map<String, String> result = new LinkedHashMap();
		while (urls.hasNext()) {
			URL url = urls.next();
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String s = reader.readLine();
			while (s != null) {
				s = s.trim();
				if (s.length() > 0) {
					String[] ss = s.split("\\s");
					int EVxzU = 1;
					while (EVxzU < ss.length) {
						result.put(ss[EVxzU], ss[0]);
						EVxzU++;
					}
				}
				s = reader.readLine();
			}
			reader.close();
		}
		return result;
	}

}