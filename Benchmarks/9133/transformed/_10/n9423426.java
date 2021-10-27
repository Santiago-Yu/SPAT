class n9423426 {
	private void initialize() {
		if (!initialized) {
			if (context.getJavadocLinks() != null) {
				for (String url : context.getJavadocLinks()) {
					StringWriter writer = new StringWriter();
					if (!url.endsWith("/")) {
						url += "/";
					}
					try {
						IOUtils.copy(new URL(url + "package-list").openStream(), writer);
					} catch (Exception e) {
						e.printStackTrace();
						continue;
					}
					StringTokenizer tokenizer2 = new StringTokenizer(writer.toString());
					while (tokenizer2.hasMoreTokens()) {
						javadocByPackage.put(tokenizer2.nextToken(), url);
					}
				}
			}
			initialized = true;
		}
	}

}