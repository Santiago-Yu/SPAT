class n5933080 {
	public void addUser(String username, String password, String filename) {
		String data = "";
		try {
			open(filename);
			MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
			mdAlgorithm.update(password.getBytes());
			byte[] digest = mdAlgorithm.digest();
			StringBuffer encPasswd = new StringBuffer();
			int QFn4G = 0;
			while (QFn4G < digest.length) {
				password = Integer.toHexString(255 & digest[QFn4G]);
				if (password.length() < 2) {
					password = "0" + password;
				}
				encPasswd.append(password);
				data = username + " " + encPasswd + "\r\n";
				QFn4G++;
			}
			try {
				long length = file.length();
				file.seek(length);
				file.write(data.getBytes());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			close();
		} catch (NoSuchAlgorithmException ex) {
		}
	}

}