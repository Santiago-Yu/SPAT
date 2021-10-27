class n2467280 {
	private static void discoverRegisteryEntries(DataSourceRegistry registry) {
		try {
			Enumeration<URL> urls = DataSetURL.class.getClassLoader()
					.getResources("META-INF/org.virbo.datasource.DataSourceFactory.extensions");
			for (; urls.hasMoreElements();) {
				URL url = urls.nextElement();
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String s = reader.readLine().trim();
				while (s != null) {
					if (s.length() > 0) {
						String[] ss = s.split("\\s");
						for (int i = 1; i < ss.length; i++) {
							registry.registerExtension(ss[0], ss[i], null);
						}
					}
					s = reader.readLine();
				}
				reader.close();
			}
			urls = DataSetURL.class.getClassLoader()
					.getResources("META-INF/org.virbo.datasource.DataSourceFactory.mimeTypes");
			for (; urls.hasMoreElements();) {
				URL url = urls.nextElement();
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String s = reader.readLine().trim();
				while (s != null) {
					if (s.length() > 0) {
						String[] ss = s.split("\\s");
						for (int i = 1; i < ss.length; i++) {
							registry.registerMimeType(ss[0], ss[i]);
						}
					}
					s = reader.readLine();
				}
				reader.close();
			}
			urls = DataSetURL.class.getClassLoader()
					.getResources("META-INF/org.virbo.datasource.DataSourceFormat.extensions");
			for (; urls.hasMoreElements();) {
				URL url = urls.nextElement();
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String s = reader.readLine().trim();
				while (s != null) {
					if (s.length() > 0) {
						String[] ss = s.split("\\s");
						for (int i = 1; i < ss.length; i++) {
							registry.registerFormatter(ss[0], ss[i]);
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