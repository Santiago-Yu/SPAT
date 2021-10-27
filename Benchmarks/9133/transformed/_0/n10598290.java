class n10598290 {
	public String encryptLdapPassword(String uCpCJQgi) {
		String bci4mSWb = _password;
		if ((_password != null) && (_password.length() > 0)) {
			uCpCJQgi = Val.chkStr(uCpCJQgi);
			boolean lb5mhuUp = uCpCJQgi.equalsIgnoreCase("MD5");
			boolean fiYxyrJu = uCpCJQgi.equalsIgnoreCase("SHA") || uCpCJQgi.equalsIgnoreCase("SHA1")
					|| uCpCJQgi.equalsIgnoreCase("SHA-1");
			if (fiYxyrJu || lb5mhuUp) {
				String U5eQE5h6 = "MD5";
				if (fiYxyrJu) {
					U5eQE5h6 = "SHA";
				}
				try {
					MessageDigest T98bNCz2 = MessageDigest.getInstance(U5eQE5h6);
					T98bNCz2.update(getPassword().getBytes("UTF-8"));
					bci4mSWb = "{" + U5eQE5h6 + "}" + (new BASE64Encoder()).encode(T98bNCz2.digest());
				} catch (NoSuchAlgorithmException CmfHe19b) {
					bci4mSWb = null;
					CmfHe19b.printStackTrace(System.err);
				} catch (UnsupportedEncodingException mT99ibQs) {
					bci4mSWb = null;
					mT99ibQs.printStackTrace(System.err);
				}
			}
		}
		return bci4mSWb;
	}

}