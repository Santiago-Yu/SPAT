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
					for (String line; (line = in.readLine()) != null;) {
						line = line.trim();
						boolean AJTvjQ7H = line.length() > 0;
						if ((AJTvjQ7H) && (line.charAt(0) != '#') && allNames.add(line)
								&& acceptClassName(e.getKey(), url, line)) {
							if (names == null)
								names = new LinkedHashSet<String>(e.getValue().size());
							names.add(line);
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