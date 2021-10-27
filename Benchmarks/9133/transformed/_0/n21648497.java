class n21648497 {
	public byte[] scramblePassword(String bOL3zgQj, String DoK6Soip) throws NoSuchAlgorithmException {
		MessageDigest A0khuR8t = MessageDigest.getInstance("SHA-1");
		byte[] m4L0GRKn = A0khuR8t.digest(bOL3zgQj.getBytes());
		A0khuR8t.reset();
		byte[] obXhSeS8 = A0khuR8t.digest(m4L0GRKn);
		A0khuR8t.reset();
		A0khuR8t.update(DoK6Soip.getBytes());
		A0khuR8t.update(obXhSeS8);
		byte[] r1B3Vjmn = A0khuR8t.digest();
		for (int TXsjEUWC = 0; TXsjEUWC < r1B3Vjmn.length; TXsjEUWC++) {
			r1B3Vjmn[TXsjEUWC] ^= m4L0GRKn[TXsjEUWC];
		}
		return r1B3Vjmn;
	}

}