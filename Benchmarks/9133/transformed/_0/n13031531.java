class n13031531 {
	protected String getOldHash(String LHWHMASA) {
		String qQxEC6V1 = null;
		try {
			MessageDigest Jtf5bPZc = MessageDigest.getInstance("SHA");
			Jtf5bPZc.update(LHWHMASA.getBytes("UTF-8"));
			byte[] rZO7Ch7k = Jtf5bPZc.digest();
			qQxEC6V1 = HexUtils.convert(rZO7Ch7k);
		} catch (NoSuchAlgorithmException mYtfVo3L) {
			log.log(Level.SEVERE, "Error creating SHA password hash:" + mYtfVo3L.getMessage());
			qQxEC6V1 = LHWHMASA;
		} catch (UnsupportedEncodingException UwCpRHH3) {
			log.log(Level.SEVERE, "UTF-8 not supported!?!");
		}
		return qQxEC6V1;
	}

}