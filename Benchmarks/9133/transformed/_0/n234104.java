class n234104 {
	public static void main(String[] qIMpOpTu) {
		MessageDigest IMeMd5Q4 = null;
		try {
			IMeMd5Q4 = MessageDigest.getInstance("SHA-1");
		} catch (Exception Mkeetm3d) {
			Mkeetm3d.printStackTrace();
		}
		IMeMd5Q4.update("abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlmnomnopnopq".getBytes(), 0, 56);
		String pnShLmsC = "84983E441C3BD26EBAAE4AA1F95129E5E54670F1";
		String aQTwyN7l = toString(IMeMd5Q4.digest());
		System.out.println(pnShLmsC);
		System.out.println(aQTwyN7l);
		if (!pnShLmsC.equals(aQTwyN7l))
			System.out.println("NOT EQUAL!");
	}

}