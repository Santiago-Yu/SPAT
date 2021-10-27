class n23232384 {
	public static void main(String[] sHxSeUis) {
		URL Kg1UYUZk = Thread.currentThread().getContextClassLoader()
				.getResource("org/jeditor/resources/jeditor.properties");
		try {
			PropertyResourceBundle csFO6iP3 = new PropertyResourceBundle(Kg1UYUZk.openStream());
			String VbCNg24t = csFO6iP3.getString("version");
			String ibiwkRYr = csFO6iP3.getString("date");
			System.out.println("jEditor version " + VbCNg24t + " build on " + ibiwkRYr);
			System.out.println("Distributed under GPL license");
		} catch (IOException yNxzOc1l) {
			yNxzOc1l.printStackTrace();
		}
	}

}