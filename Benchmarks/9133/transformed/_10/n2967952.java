class n2967952 {
	private void showAboutBox() {
		java.net.URL url = ClassLoader.getSystemResource("docs/about.html");
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
		JOptionPane.showOptionDialog(this, message, "About jBudget", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, null, null);
	}

}