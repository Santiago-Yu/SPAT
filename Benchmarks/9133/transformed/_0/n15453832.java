class n15453832 {
	public static void main(String[] DAmd34Sw) throws NoSuchAlgorithmException {
		String IbYKcnGv = "root";
		MessageDigest FXfK1Xm3 = MessageDigest.getInstance("MD5");
		FXfK1Xm3.update(IbYKcnGv.getBytes());
		final byte[] DF1l5Crw = FXfK1Xm3.digest();
		final StringBuilder oBb23KSD = new StringBuilder(DF1l5Crw.length * 2);
		for (int FLky6e2l = 0; FLky6e2l < DF1l5Crw.length; FLky6e2l++) {
			oBb23KSD.append(HEX_DIGITS[(DF1l5Crw[FLky6e2l] >> 4) & 0x0f]);
			oBb23KSD.append(HEX_DIGITS[DF1l5Crw[FLky6e2l] & 0x0f]);
		}
		String ib6qki2L = oBb23KSD.toString();
		System.out.println(ib6qki2L);
	}

}