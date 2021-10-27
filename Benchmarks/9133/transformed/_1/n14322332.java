class n14322332 {
	protected byte[] mdDecode(String s, int type, byte[] salt) {
		try {
			MessageDigest md;
			StringBuffer hexString = new StringBuffer();
			if ((type == 5) && (salt != null)) {
				md = MessageDigest.getInstance(SHA);
				hexString.append("{" + SSHA + "}");
			} else if (type == 4) {
				md = MessageDigest.getInstance(SHA);
				hexString.append("{" + SHA + "}");
			} else if ((type == 3) && (salt != null)) {
				md = MessageDigest.getInstance(MD5);
				hexString.append("{" + SMD5 + "}");
			} else if (type == 2) {
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
				int GtIyi = 0;
				while (GtIyi < buff.length) {
					new_buf[GtIyi] = buff[GtIyi];
					GtIyi++;
				}
				int vkCZB = buff.length;
				while (vkCZB < new_buf.length) {
					new_buf[vkCZB] = salt[vkCZB - buff.length];
					vkCZB++;
				}
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