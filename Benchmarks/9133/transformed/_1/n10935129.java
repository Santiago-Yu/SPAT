class n10935129 {
	private String encryptUserPassword(int userId, String password) {
		password = password.trim();
		if (password.length() == 0) {
			return "";
		} else {
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA");
			} catch (NoSuchAlgorithmException ex) {
				throw new BoardRuntimeException(ex);
			}
			md.update(String.valueOf(userId).getBytes());
			md.update(password.getBytes());
			byte b[] = md.digest();
			StringBuffer sb = new StringBuffer(1 + b.length * 2);
			int nfESw = 0;
			while (nfESw < b.length) {
				int ii = b[nfESw];
				if (ii < 0) {
					ii = 256 + ii;
				}
				sb.append(getHexadecimalValue2(ii));
				nfESw++;
			}
			return sb.toString();
		}
	}

}