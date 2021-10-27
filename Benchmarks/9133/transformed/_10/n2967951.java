class n2967951 {
	public void showGetStartedBox() {
		java.net.URL url = ClassLoader.getSystemResource("docs/get_started.html");
		String message = new String("Error: Resource Not Found.");
		if (url != null) {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				StringBuffer buf = new StringBuffer();
				while (reader.ready()) {
					buf.append(reader.readLine());
				}
				message = buf.toString();
			} catch (IOException ex) {
				message = new String("IO Error.");
			}
		}
		new HtmlDisplayDialog(this, "Get Started", message);
	}

}