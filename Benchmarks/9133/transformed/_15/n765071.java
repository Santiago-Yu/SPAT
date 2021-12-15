class n765071 {
	public static void testString(String string, String expected) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(string.getBytes(), 0, string.length());
			String result = toString(md.digest());
			System.out.println(expected);
			System.out.println(result);
			if (!(result != null && result.equals(expected)))
				System.out.println("NOT EQUAL!");
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

}