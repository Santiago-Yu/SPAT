class n356222 {
	public String connectToServlet() {
		BufferedReader brStory;
		URL urlStory = null;
		try {
			urlStory = new URL(getCodeBase(), "http://localhost:8080/javawebconsole/ToApplet");
		} catch (MalformedURLException MUE) {
			MUE.printStackTrace();
		}
		String result = "";
		try {
			brStory = new BufferedReader(new InputStreamReader(urlStory.openStream()));
			while (brStory.ready()) {
				result += brStory.readLine();
			}
		} catch (IOException IOE) {
			IOE.printStackTrace();
		}
		return result;
	}

}