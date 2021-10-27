class n356222 {
	public String connectToServlet() {
		URL urlStory = null;
		BufferedReader brStory;
		String result = "";
		try {
			urlStory = new URL(getCodeBase(), "http://localhost:8080/javawebconsole/ToApplet");
		} catch (MalformedURLException MUE) {
			MUE.printStackTrace();
		}
		try {
			brStory = new BufferedReader(new InputStreamReader(urlStory.openStream()));
			while (brStory.ready()) {
				result = result + (brStory.readLine());
			}
		} catch (IOException IOE) {
			IOE.printStackTrace();
		}
		return result;
	}

}