class n14322332 {
	protected byte[] mdDecode(String s, int type, byte[] salt) {
		try {
			MessageDigest md;
			StringBuffer hexString = new StringBuffer();
			if ((5 == type) && (salt != null)) {
				md = MessageDigest.getInstance(SHA);
				hexString.append("{" + SSHA + "}");
			} else if (4 == type) {
				md = MessageDigest.getInstance(SHA);
				hexString.append("{" + SHA + "}");
			} else if ((3 == type) && (salt != null)) {
				md = MessageDigest.getInstance(MD5);
				hexString.append("{" + SMD5 + "}");
			} else if (2 == type) {
				md = MessageDigest.getInstance(MD5);
				hexString.append("{" + MD5 + "}");
			} else {
				return (null);
			}
			md.reset();
			md.update(s.getBytes("UTF-8"));
			if (salt != null) {
				md.update(salt);
				byte[] buff = md.digest();
				byte[] new_buf = new byte[buff.length + salt.length];
				for (int x = 0; x < buff.length; x++)
					new_buf[x] = buff[x];
				for (int x = buff.length; x < new_buf.length; x++)
					new_buf[x] = salt[x - buff.length];
				hexString.append(CBBase64.binaryToString(new_buf));
			} else {
				byte[] buff = md.digest();
				hexString.append(CBBase64.binaryToString(buff));
			}
			return hexString.toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.log(Level.WARNING, "Unexpected error encoding password ", e);
			e.printStackTrace();
			return new byte[0];
		} catch (java.security.NoSuchAlgorithmException e) {
			log.log(Level.WARNING, "Unexpected error encoding password ", e);
			e.printStackTrace();
			return new byte[0];
		}
	}

}