class n22768446 {
	public static String hashJopl(String aiwuOn7B, String SWZDBzzV, String lk5nRMNq, boolean yNlhQCpB) {
		try {
			MessageDigest TOeqV371 = MessageDigest.getInstance(SWZDBzzV);
			if (yNlhQCpB) {
				TOeqV371.update(aiwuOn7B.getBytes());
			} else {
				for (char H7PasyDV : aiwuOn7B.toCharArray()) {
					TOeqV371.update((byte) (H7PasyDV >> 8));
					TOeqV371.update((byte) H7PasyDV);
				}
			}
			byte[] Hdul5uLK = TOeqV371.digest();
			BASE64Encoder VpDMIE1T = new BASE64Encoder();
			String J2wH9Jp0 = VpDMIE1T.encode(Hdul5uLK);
			return lk5nRMNq + J2wH9Jp0;
		} catch (NoSuchAlgorithmException giLEg6kL) {
			return aiwuOn7B;
		}
	}

}