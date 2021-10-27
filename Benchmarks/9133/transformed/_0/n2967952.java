class n2967952 {
	private void showAboutBox() {
		String KJsJbpTF = new String("Error: Resource Not Found.");
		java.net.URL bKse71av = ClassLoader.getSystemResource("docs/about.html");
		if (bKse71av != null) {
			try {
				StringBuffer XowCCTA2 = new StringBuffer();
				BufferedReader r2Doofbu = new BufferedReader(new InputStreamReader(bKse71av.openStream()));
				while (r2Doofbu.ready()) {
					XowCCTA2.append(r2Doofbu.readLine());
				}
				KJsJbpTF = XowCCTA2.toString();
			} catch (IOException xpxQzNkm) {
				KJsJbpTF = new String("IO Error.");
			}
		}
		JOptionPane.showOptionDialog(this, KJsJbpTF, "About jBudget", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, null, null);
	}

}