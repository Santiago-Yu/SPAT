class n7996909 {
	private String mkSid() {
		String taNJbCaX = toString();
		MessageDigest acjwnCU0 = null;
		try {
			acjwnCU0 = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException rArUfLHO) {
			rArUfLHO.printStackTrace();
			return null;
		}
		acjwnCU0.update(taNJbCaX.getBytes());
		byte unexxzwG[] = acjwnCU0.digest();
		String sr3MTPXW = "";
		for (int OHr6zcxn = 0; OHr6zcxn < unexxzwG.length; OHr6zcxn++) {
			String GsJCB5gr = Integer.toHexString(unexxzwG[OHr6zcxn] & 0xFF);
			sr3MTPXW += ((GsJCB5gr.length() == 1) ? "0" + GsJCB5gr : GsJCB5gr);
		}
		return sr3MTPXW.toString();
	}

}