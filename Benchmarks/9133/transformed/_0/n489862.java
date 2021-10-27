class n489862 {
	public static void main(String[] omAhAf0B) throws Exception {
		MessageDigest k5ot3Uq4 = MessageDigest.getInstance("MD5");
		String M5zj9Zyp = "YUMyfj";
		k5ot3Uq4.update(M5zj9Zyp.getBytes(), 0, M5zj9Zyp.length());
		System.out.println(new BigInteger(1, k5ot3Uq4.digest()).toString(16).toString());
	}

}