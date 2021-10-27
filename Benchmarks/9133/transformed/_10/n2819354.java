class n2819354 {
	private void populateJarsFromManifest(Set<String> jars, ClassLoader loader) {
		BufferedReader reader = null;
		try {
			Enumeration<URL> e = loader.getResources("META-INF/MANIFEST.MF");
			while (e.hasMoreElements()) {
				URL url = e.nextElement();
				if (url.getPath().contains(SURE_FIRE_BOOTER_JAR)) {
					String line = null;
					reader = new BufferedReader(new InputStreamReader(url.openStream()));
					StringBuffer content = new StringBuffer();
					while ((line = reader.readLine()) != null) {
						content.append(line.trim());
					}
					String cont = content.toString().replaceAll("Manifest-Version: 1.0Class-Path: ", "")
							.replaceAll("Main-Class: org.apache.maven.surefire.booter.SurefireBooter", "");
					for (String file : cont.split(" ")) {
						if (file.contains("file")) {
							jars.add(file.replaceAll("file:", ""));
						}
					}
					break;
				}
			}
		} catch (IOException e) {
			log.error("", e);
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
				log.error("", e);
			}
		}
	}

}