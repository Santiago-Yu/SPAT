class n7564559 {
	public static String SHAEncrypt(String o4KOedF5) {
		String frycT4rX = new String("");
		try {
			MessageDigest u1kakmxF = MessageDigest.getInstance("SHA-1");
			u1kakmxF.update(o4KOedF5.getBytes());
			byte pYrpCind[] = u1kakmxF.digest();
			for (int UmUsfMYB = 0; UmUsfMYB < pYrpCind.length; UmUsfMYB++) {
				char[] X15xbcaN = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
				char[] LNI0WUWa = new char[2];
				LNI0WUWa[0] = X15xbcaN[(pYrpCind[UmUsfMYB] >>> 4) & 0X0F];
				LNI0WUWa[1] = X15xbcaN[pYrpCind[UmUsfMYB] & 0X0F];
				frycT4rX += new String(LNI0WUWa);
			}
		} catch (NoSuchAlgorithmException BEo0jt8J) {
			System.out.println("the algorithm doesn't exist");
		}
		return frycT4rX;
	}

}