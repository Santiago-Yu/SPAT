class n19687729 {
	public static void readShaderSource(ClassLoader context, String path, URL url, StringBuffer result) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (!(line.startsWith("#include "))) {
					result.append(line + "\n");
				} else {
					String includeFile = line.substring(9).trim();
					String next = Locator.getRelativeOf(path, includeFile);
					URL nextURL = Locator.getResource(next, context);
					if (nextURL == null) {
						next = includeFile;
						nextURL = Locator.getResource(next, context);
					}
					if (nextURL == null) {
						throw new FileNotFoundException("Can't find include file " + includeFile);
					}
					readShaderSource(context, next, nextURL, result);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}