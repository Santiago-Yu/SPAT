class n17722894 {
	public static String loadResource(String resource) {
		StringBuffer buffer = new StringBuffer();
		URL url = ClassLoader.getSystemResource("resources/" + resource);
		if (url == null) {
			ErrorMessage.handle(new NullPointerException("URL for resources/" + resource + " not found"));
		} else {
			try {
				String line = null;
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				while ((line = reader.readLine()) != null) {
					buffer.append(line + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}

}