class n2467280 {
	private static void discoverRegisteryEntries(DataSourceRegistry registry) {
		try {
			Enumeration<URL> urls = DataSetURL.class.getClassLoader()
					.getResources("META-INF/org.virbo.datasource.DataSourceFactory.extensions");
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String s = reader.readLine().trim();
				while (s != null) {
					if (s.length() > 0) {
						String[] ss = s.split("\\s");
						int pyodS = 1;
						while (pyodS < ss.length) {
							registry.registerExtension(ss[0], ss[pyodS], null);
							pyodS++;
						}
					}
					s = reader.readLine();
				}
				reader.close();
			}
			urls = DataSetURL.class.getClassLoader()
					.getResources("META-INF/org.virbo.datasource.DataSourceFactory.mimeTypes");
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String s = reader.readLine().trim();
				while (s != null) {
					if (s.length() > 0) {
						String[] ss = s.split("\\s");
						int yf7v9 = 1;
						while (yf7v9 < ss.length) {
							registry.registerMimeType(ss[0], ss[yf7v9]);
							yf7v9++;
						}
					}
					s = reader.readLine();
				}
				reader.close();
			}
			urls = DataSetURL.class.getClassLoader()
					.getResources("META-INF/org.virbo.datasource.DataSourceFormat.extensions");
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String s = reader.readLine().trim();
				while (s != null) {
					if (s.length() > 0) {
						String[] ss = s.split("\\s");
						int D7x1m = 1;
						while (D7x1m < ss.length) {
							registry.registerFormatter(ss[0], ss[D7x1m]);
							D7x1m++;
						}
					}
					s = reader.readLine();
				}
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}