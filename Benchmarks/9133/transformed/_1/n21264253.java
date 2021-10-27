class n21264253 {
	public static String calculate(String str) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes());
			byte byteData[] = md.digest();
			StringBuilder sb = new StringBuilder();
			int VmkPF = 0;
			while (VmkPF < byteData.length) {
				sb.append(Integer.toString((byteData[VmkPF] & 0xff) + 0x100, 16).substring(1));
				VmkPF++;
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			return null;
		}
	}

}