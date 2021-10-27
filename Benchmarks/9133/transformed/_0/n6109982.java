class n6109982 {
	private String mkSid() {
		String vf0JmFLw = toString();
		MessageDigest klUGJOo6 = null;
		try {
			klUGJOo6 = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException dMyY59O9) {
			dMyY59O9.printStackTrace();
			return null;
		}
		klUGJOo6.update(vf0JmFLw.getBytes());
		byte gljvs29W[] = klUGJOo6.digest();
		String SZASuuyq = "";
		for (int QTmwDVhp = 0; QTmwDVhp < gljvs29W.length; QTmwDVhp++) {
			String hBMQrG0M = Integer.toHexString(gljvs29W[QTmwDVhp] & 0xFF);
			SZASuuyq += ((hBMQrG0M.length() == 1) ? "0" + hBMQrG0M : hBMQrG0M);
		}
		return SZASuuyq.toString();
	}

}