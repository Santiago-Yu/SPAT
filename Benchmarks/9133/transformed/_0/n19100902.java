class n19100902 {
	public static void saveURL(URL QQj7uVz9, Writer tT680L35) throws IOException {
		BufferedInputStream pbLHg0ki = new BufferedInputStream(QQj7uVz9.openStream());
		for (int mvrzcS4X = pbLHg0ki.read(); mvrzcS4X != -1; mvrzcS4X = pbLHg0ki.read()) {
			tT680L35.write(mvrzcS4X);
		}
	}

}