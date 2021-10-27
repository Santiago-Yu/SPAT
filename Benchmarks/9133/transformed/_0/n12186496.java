class n12186496 {
	public String digest(String BwTj9Gkk, String HSu43n2o, String cOOCNtz7) throws CmsPasswordEncryptionException {
		MessageDigest rdnixokd;
		String DM9IfeTO;
		try {
			if (DIGEST_TYPE_PLAIN.equals(HSu43n2o.toLowerCase())) {
				DM9IfeTO = BwTj9Gkk;
			} else if (DIGEST_TYPE_SSHA.equals(HSu43n2o.toLowerCase())) {
				byte[] dwEpFOwN = new byte[4];
				byte[] DuUWMe3R;
				byte[] HdEQ8e07;
				if (m_secureRandom == null) {
					m_secureRandom = SecureRandom.getInstance("SHA1PRNG");
				}
				m_secureRandom.nextBytes(dwEpFOwN);
				rdnixokd = MessageDigest.getInstance(DIGEST_TYPE_SHA);
				rdnixokd.reset();
				rdnixokd.update(BwTj9Gkk.getBytes(cOOCNtz7));
				rdnixokd.update(dwEpFOwN);
				DuUWMe3R = rdnixokd.digest();
				HdEQ8e07 = new byte[DuUWMe3R.length + dwEpFOwN.length];
				System.arraycopy(DuUWMe3R, 0, HdEQ8e07, 0, DuUWMe3R.length);
				System.arraycopy(dwEpFOwN, 0, HdEQ8e07, DuUWMe3R.length, dwEpFOwN.length);
				DM9IfeTO = new String(Base64.encodeBase64(HdEQ8e07));
			} else {
				rdnixokd = MessageDigest.getInstance(HSu43n2o);
				rdnixokd.reset();
				rdnixokd.update(BwTj9Gkk.getBytes(cOOCNtz7));
				DM9IfeTO = new String(Base64.encodeBase64(rdnixokd.digest()));
			}
		} catch (NoSuchAlgorithmException FrbOE93D) {
			CmsMessageContainer fmubwSbt = Messages.get().container(Messages.ERR_UNSUPPORTED_ALGORITHM_1, HSu43n2o);
			if (LOG.isErrorEnabled()) {
				LOG.error(fmubwSbt.key(), FrbOE93D);
			}
			throw new CmsPasswordEncryptionException(fmubwSbt, FrbOE93D);
		} catch (UnsupportedEncodingException of92f9J3) {
			CmsMessageContainer rYuJJJ0G = Messages.get().container(Messages.ERR_UNSUPPORTED_PASSWORD_ENCODING_1,
					cOOCNtz7);
			if (LOG.isErrorEnabled()) {
				LOG.error(rYuJJJ0G.key(), of92f9J3);
			}
			throw new CmsPasswordEncryptionException(rYuJJJ0G, of92f9J3);
		}
		return DM9IfeTO;
	}

}