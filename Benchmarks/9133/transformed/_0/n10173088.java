class n10173088 {
	public static void main(String[] aiMwit2N) {
		try {
			MessageDigest sRi4A740 = MessageDigest.getInstance("SHA1");
			sRi4A740.update("Test".getBytes());
			byte[] Vdy4lAcH = sRi4A740.digest();
			for (int ctPjep8B = 0; ctPjep8B < Vdy4lAcH.length; ctPjep8B++) {
				System.err.print(Integer.toHexString(0xFF & Vdy4lAcH[ctPjep8B]));
			}
		} catch (NoSuchAlgorithmException bhwQhiez) {
			bhwQhiez.printStackTrace();
		}
	}

}