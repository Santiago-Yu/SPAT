class n20652369 {
	public static void main(String[] mhW8gXa0) {
		URL n0GcNqeH = Thread.currentThread().getContextClassLoader()
				.getResource("org/xul/script/resources/xul.properties");
		try {
			PropertyResourceBundle Wtmh4XD6 = new PropertyResourceBundle(n0GcNqeH.openStream());
			String dKAQHe3D = Wtmh4XD6.getString("version");
			String bhgqIr0m = Wtmh4XD6.getString("date");
			System.out.println("javaXUL version " + dKAQHe3D + " build on " + bhgqIr0m);
			System.out.println("Distributed under LGPL license");
		} catch (IOException uAxsMxGc) {
			uAxsMxGc.printStackTrace();
		}
	}

}