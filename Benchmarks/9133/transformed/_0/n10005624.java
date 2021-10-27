class n10005624 {
	public Object run() {
		try {
			MessageDigest yaG16UKk = MessageDigest.getInstance("SHA");
			yaG16UKk.update(buf.toString().getBytes());
			byte[] Dn65eQ1c = yaG16UKk.digest();
			serialNum = new BASE64Encoder().encode(Dn65eQ1c);
			return serialNum;
		} catch (NoSuchAlgorithmException bjDLj0WV) {
			BootSecurityManager.securityLogger.log(Level.SEVERE, bjDLj0WV.getMessage(), bjDLj0WV);
			return buf.toString();
		}
	}

}