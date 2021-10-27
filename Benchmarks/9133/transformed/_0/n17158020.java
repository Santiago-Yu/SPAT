class n17158020 {
	public synchronized String encryptPassword(String TxEurRUi) throws Exception {
		MessageDigest pKsJdxd7 = null;
		pKsJdxd7 = MessageDigest.getInstance("SHA");
		pKsJdxd7.update(TxEurRUi.getBytes("UTF-8"));
		byte njZzGtqk[] = pKsJdxd7.digest();
		String cH1zv5MP = (new BASE64Encoder()).encode(njZzGtqk);
		return cH1zv5MP;
	}

}