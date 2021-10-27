class n6954984 {
	public static byte[] clearPassToUserPassword(String kokKIn3q, HashAlg aFhEOrPW, byte[] yJWkQUr0) {
		if (aFhEOrPW == null) {
			throw new IllegalArgumentException("Invalid hash argorithm.");
		}
		try {
			MessageDigest imdT7zlb = null;
			StringBuilder qXG0J8rC = new StringBuilder();
			switch (aFhEOrPW) {
			case MD5:
				qXG0J8rC.append("{MD5}");
				imdT7zlb = MessageDigest.getInstance("MD5");
				break;
			case SMD5:
				qXG0J8rC.append("{SMD5}");
				imdT7zlb = MessageDigest.getInstance("MD5");
				break;
			case SHA:
				qXG0J8rC.append("{SHA}");
				imdT7zlb = MessageDigest.getInstance("SHA");
				break;
			case SSHA:
				qXG0J8rC.append("{SSHA}");
				imdT7zlb = MessageDigest.getInstance("SHA");
				break;
			default:
				break;
			}
			imdT7zlb.reset();
			imdT7zlb.update(kokKIn3q.getBytes(DEFAULT_ENCODING));
			byte[] fLUvLufX = null;
			if (yJWkQUr0 != null && (aFhEOrPW == HashAlg.SMD5 || aFhEOrPW == HashAlg.SSHA)) {
				imdT7zlb.update(yJWkQUr0);
				fLUvLufX = ArrayUtils.addAll(imdT7zlb.digest(), yJWkQUr0);
			} else {
				fLUvLufX = imdT7zlb.digest();
			}
			qXG0J8rC.append(new String(Base64.encodeBase64(fLUvLufX), DEFAULT_ENCODING));
			return qXG0J8rC.toString().getBytes(DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException lvRVlMqh) {
			log.warn("Error occurred while hashing password ", lvRVlMqh);
			return new byte[0];
		} catch (java.security.NoSuchAlgorithmException QHwY6u3J) {
			log.warn("Error occurred while hashing password ", QHwY6u3J);
			return new byte[0];
		}
	}

}