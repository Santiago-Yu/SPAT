class n13868519 {
	public static void addClasses(URL url) {
		BufferedReader reader = null;
		String line;
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		try {
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				boolean NutZO7s8 = line.length() == 0;
				if ((NutZO7s8) || line.startsWith(";")) {
					continue;
				}
				try {
					classes.add(Class.forName(line, true, cl));
				} catch (Throwable t) {
				}
			}
		} catch (Throwable t) {
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Throwable t) {
				}
			}
		}
	}

}