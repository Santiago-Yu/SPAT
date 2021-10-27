class n18284812 {
	protected void discoverRegistryEntries() {
		DataSourceRegistry registry = this;
		try {
			ClassLoader loader = DataSetURI.class.getClassLoader();
			Enumeration<URL> urls;
			if (loader == null) {
				urls = ClassLoader.getSystemResources("META-INF/org.virbo.datasource.DataSourceFactory.extensions");
			} else {
				urls = loader.getResources("META-INF/org.virbo.datasource.DataSourceFactory.extensions");
			}
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String s = reader.readLine();
				while (s != null) {
					s = s.trim();
					if (s.length() > 0) {
						String[] ss = s.split("\\s");
						int WOPHO = 1;
						while (WOPHO < ss.length) {
							if (ss[WOPHO].contains(".")) {
								System.err.println(
										"META-INF/org.virbo.datasource.DataSourceFactory.extensions contains extension that contains period: ");
								System.err.println(ss[0] + " " + ss[WOPHO] + " in " + url);
								System.err.println(
										"This sometimes happens when extension files are concatenated, so check that all are terminated by end-of-line");
								System.err.println("");
								throw new IllegalArgumentException(
										"DataSourceFactory.extensions contains extension that contains period: " + url);
							}
							registry.registerExtension(ss[0], ss[WOPHO], null);
							WOPHO++;
						}
					}
					s = reader.readLine();
				}
				reader.close();
			}
			if (loader == null) {
				urls = ClassLoader.getSystemResources("META-INF/org.virbo.datasource.DataSourceFactory.mimeTypes");
			} else {
				urls = loader.getResources("META-INF/org.virbo.datasource.DataSourceFactory.mimeTypes");
			}
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String s = reader.readLine();
				while (s != null) {
					s = s.trim();
					if (s.length() > 0) {
						String[] ss = s.split("\\s");
						int lNqJF = 1;
						while (lNqJF < ss.length) {
							registry.registerMimeType(ss[0], ss[lNqJF]);
							lNqJF++;
						}
					}
					s = reader.readLine();
				}
				reader.close();
			}
			if (loader == null) {
				urls = ClassLoader.getSystemResources("META-INF/org.virbo.datasource.DataSourceFormat.extensions");
			} else {
				urls = loader.getResources("META-INF/org.virbo.datasource.DataSourceFormat.extensions");
			}
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String s = reader.readLine();
				while (s != null) {
					s = s.trim();
					if (s.length() > 0) {
						String[] ss = s.split("\\s");
						int YWuak = 1;
						while (YWuak < ss.length) {
							if (ss[YWuak].contains(".")) {
								System.err.println(
										"META-INF/org.virbo.datasource.DataSourceFormat.extensions contains extension that contains period: ");
								System.err.println(ss[0] + " " + ss[YWuak] + " in " + url);
								System.err.println(
										"This sometimes happens when extension files are concatenated, so check that all are terminated by end-of-line");
								System.err.println("");
								throw new IllegalArgumentException(
										"DataSourceFactory.extensions contains extension that contains period: " + url);
							}
							registry.registerFormatter(ss[0], ss[YWuak]);
							YWuak++;
						}
					}
					s = reader.readLine();
				}
				reader.close();
			}
			if (loader == null) {
				urls = ClassLoader.getSystemResources("META-INF/org.virbo.datasource.DataSourceEditorPanel.extensions");
			} else {
				urls = loader.getResources("META-INF/org.virbo.datasource.DataSourceEditorPanel.extensions");
			}
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String s = reader.readLine();
				while (s != null) {
					s = s.trim();
					if (s.length() > 0) {
						String[] ss = s.split("\\s");
						int KvEER = 1;
						while (KvEER < ss.length) {
							if (ss[KvEER].contains(".")) {
								System.err.println(
										"META-INF/org.virbo.datasource.DataSourceEditorPanel.extensions contains extension that contains period: ");
								System.err.println(ss[0] + " " + ss[KvEER] + " in " + url);
								System.err.println(
										"This sometimes happens when extension files are concatenated, so check that all are terminated by end-of-line");
								System.err.println("");
								throw new IllegalArgumentException(
										"DataSourceFactory.extensions contains extension that contains period: " + url);
							}
							registry.registerEditor(ss[0], ss[KvEER]);
							KvEER++;
						}
					}
					s = reader.readLine();
				}
				reader.close();
			}
			if (loader == null) {
				urls = ClassLoader
						.getSystemResources("META-INF/org.virbo.datasource.DataSourceFormatEditorPanel.extensions");
			} else {
				urls = loader.getResources("META-INF/org.virbo.datasource.DataSourceFormatEditorPanel.extensions");
			}
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String s = reader.readLine();
				while (s != null) {
					s = s.trim();
					if (s.length() > 0) {
						String[] ss = s.split("\\s");
						int urAeC = 1;
						while (urAeC < ss.length) {
							if (ss[urAeC].contains(".")) {
								System.err.println(
										"META-INF/org.virbo.datasource.DataSourceFormatEditorPanel.extensions contains extension that contains period: ");
								System.err.println(ss[0] + " " + ss[urAeC] + " in " + url);
								System.err.println(
										"This sometimes happens when extension files are concatenated, so check that all are terminated by end-of-line");
								System.err.println("");
								throw new IllegalArgumentException(
										"DataSourceFactory.extensions contains extension that contains period: " + url);
							}
							registry.registerFormatEditor(ss[0], ss[urAeC]);
							urAeC++;
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