class n17468430 {
	private String mkSid() {
		String XtmCofdD = toString();
		MessageDigest ZXvjUVNz = null;
		try {
			ZXvjUVNz = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException WAI3JsTJ) {
			WAI3JsTJ.printStackTrace();
			return null;
		}
		ZXvjUVNz.update(XtmCofdD.getBytes());
		byte Vg5Lm5xQ[] = ZXvjUVNz.digest();
		String mbao4s6a = "";
		for (int wMO4kZo0 = 0; wMO4kZo0 < Vg5Lm5xQ.length; wMO4kZo0++) {
			String CorDBpeB = Integer.toHexString(Vg5Lm5xQ[wMO4kZo0] & 0xFF);
			mbao4s6a += ((CorDBpeB.length() == 1) ? "0" + CorDBpeB : CorDBpeB);
		}
		return mbao4s6a.toString();
	}

}