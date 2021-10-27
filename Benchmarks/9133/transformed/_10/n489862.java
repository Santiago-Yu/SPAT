class n489862 {
	public static void main(String[] args) throws Exception {
		String text = "YUMyfj";
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(text.getBytes(), 0, text.length());
		System.out.println(new BigInteger(1, md.digest()).toString(16).toString());
	}

}