class n708047 {
	public static void main(String args[]) {
		try {
			URL url = new URL("http://www.hungry.com/");
			int size = 0;
			InputStream stream = url.openStream();
			while (-1 != stream.read()) {
				size++;
			}
			stream.close();
			System.out.println("PASSED: new URL() size=" + size);
		} catch (Exception e) {
			System.out.println("FAILED: " + e);
		}
	}

}