class n15512556 {
	private String load(URL NC7HXY4J) {
		BufferedReader XqppUibA = null;
		try {
			XqppUibA = new BufferedReader(new InputStreamReader(NC7HXY4J.openStream()));
			StringBuffer r7oWyA2Z = new StringBuffer();
			while (XqppUibA.ready()) {
				r7oWyA2Z.append(XqppUibA.readLine()).append('\n');
			}
			XqppUibA.close();
			return r7oWyA2Z.toString();
		} catch (IOException d4fv0Usd) {
			d4fv0Usd.printStackTrace();
			return null;
		}
	}

}