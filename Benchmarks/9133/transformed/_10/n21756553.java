class n21756553 {
	public static List<String> list() throws IOException {
		Enumeration<URL> urls = ClassLoader.getSystemResources("sentrick.classifiers");
		List<String> providers = new ArrayList<String>();
		while (urls.hasMoreElements()) {
			String provider = null;
			URL url = urls.nextElement();
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((provider = in.readLine()) != null) {
				provider = provider.trim();
				if (provider.length() > 0)
					providers.add(provider);
			}
			in.close();
		}
		return providers;
	}

}