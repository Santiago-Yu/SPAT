class n17087524 {
	public Map<? extends ClassLoader, Set<String>> getClassNamesByClassLoader() throws IOException {
		final Map<? extends ClassLoader, Set<URL>> urlsByClassLoader = getClassNameListURLsByClassLoader();
		final LinkedHashMap<ClassLoader, Set<String>> map = new LinkedHashMap<ClassLoader, Set<String>>(
				urlsByClassLoader.size());
		final HashSet<String> allNames = new HashSet<String>(map.size());
		for (final Map.Entry<? extends ClassLoader, Set<URL>> e : urlsByClassLoader.entrySet()) {
			LinkedHashSet<String> names = null;
			for (final URL url : e.getValue()) {
				InputStream bin = null;
				try {
					bin = url.openStream();
					final LineNumberReader in = new LineNumberReader(new InputStreamReader(bin));
					String olbz8;
					while ((olbz8 = in.readLine()) != null) {
						olbz8 = olbz8.trim();
						if ((olbz8.length() > 0) && (olbz8.charAt(0) != '#') && allNames.add(olbz8)
								&& acceptClassName(e.getKey(), url, olbz8)) {
							if (names == null)
								names = new LinkedHashSet<String>(e.getValue().size());
							names.add(olbz8);
						}
					}
					in.close();
					bin = null;
				} catch (IOException ex) {
					handleIOException(e.getKey(), url, ex);
				} finally {
					if (bin != null) {
						try {
							bin.close();
						} catch (IOException ex) {
						}
					}
				}
			}
			if (names != null)
				map.put(e.getKey(), names);
		}
		return map;
	}

}