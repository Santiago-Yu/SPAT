class n21544322 {
	public static String generate(String wHn0tcM0) {
		byte[] RX65U2us = new byte[20];
		String Blp2dLK4 = "";
		try {
			MessageDigest HVmRefi9 = MessageDigest.getInstance("SHA-1");
			HVmRefi9.update(wHn0tcM0.getBytes());
			RX65U2us = HVmRefi9.digest();
			for (int FZVehGeU = 0; FZVehGeU < RX65U2us.length; FZVehGeU++)
				Blp2dLK4 += (char) RX65U2us[FZVehGeU];
		} catch (NoSuchAlgorithmException uN6njM3d) {
			System.out.println("NO SUCH ALGORITHM EXCEPTION: " + uN6njM3d.getMessage());
		}
		return Blp2dLK4;
	}

}