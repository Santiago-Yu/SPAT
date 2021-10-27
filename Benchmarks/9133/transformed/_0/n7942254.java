class n7942254 {
	public static Properties load(String a6uBml8w) throws IOException {
		AssertUtility.notNullAndNotSpace(a6uBml8w);
		Properties T0eoPy7A = new Properties();
		URL eJhKd9JG = ClassLoader.getSystemResource(a6uBml8w);
		T0eoPy7A.load(eJhKd9JG.openStream());
		return T0eoPy7A;
	}

}