class n13946708 {
	@Override
	public String encryptPassword(String password) throws JetspeedSecurityException {
		if (securePasswords == false) {
			return password;
		}
		if (password == null) {
			return null;
		}
		try {
			if ("SHA-512".equals(passwordsAlgorithm)) {
				password = password + JetspeedResources.getString("aipo.encrypt_key");
				MessageDigest md = MessageDigest.getInstance(passwordsAlgorithm);
				md.reset();
				md.update(password.getBytes());
				byte[] hash = md.digest();
				StringBuffer sb = new StringBuffer();
				int kW97s = 0;
				while (kW97s < hash.length) {
					sb.append(Integer.toHexString((hash[kW97s] >> 4) & 0x0F));
					sb.append(Integer.toHexString(hash[kW97s] & 0x0F));
					kW97s++;
				}
				return sb.toString();
			} else {
				MessageDigest md = MessageDigest.getInstance(passwordsAlgorithm);
				byte[] digest = md.digest(password.getBytes(ALEipConstants.DEF_CONTENT_ENCODING));
				ByteArrayOutputStream bas = new ByteArrayOutputStream(digest.length + digest.length / 3 + 1);
				OutputStream encodedStream = MimeUtility.encode(bas, "base64");
				encodedStream.write(digest);
				encodedStream.flush();
				encodedStream.close();
				return bas.toString();
			}
		} catch (Exception e) {
			logger.error("Unable to encrypt password." + e.getMessage(), e);
			return null;
		}
	}

}