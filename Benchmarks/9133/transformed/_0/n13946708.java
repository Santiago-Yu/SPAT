class n13946708 {
	@Override
	public String encryptPassword(String L3V3lhC8) throws JetspeedSecurityException {
		if (securePasswords == false) {
			return L3V3lhC8;
		}
		if (L3V3lhC8 == null) {
			return null;
		}
		try {
			if ("SHA-512".equals(passwordsAlgorithm)) {
				L3V3lhC8 = L3V3lhC8 + JetspeedResources.getString("aipo.encrypt_key");
				MessageDigest K3qU9VWJ = MessageDigest.getInstance(passwordsAlgorithm);
				K3qU9VWJ.reset();
				K3qU9VWJ.update(L3V3lhC8.getBytes());
				byte[] uxAEwP2n = K3qU9VWJ.digest();
				StringBuffer UOQSkngQ = new StringBuffer();
				for (int Tv0jWyof = 0; Tv0jWyof < uxAEwP2n.length; Tv0jWyof++) {
					UOQSkngQ.append(Integer.toHexString((uxAEwP2n[Tv0jWyof] >> 4) & 0x0F));
					UOQSkngQ.append(Integer.toHexString(uxAEwP2n[Tv0jWyof] & 0x0F));
				}
				return UOQSkngQ.toString();
			} else {
				MessageDigest WV8iHTim = MessageDigest.getInstance(passwordsAlgorithm);
				byte[] qp1cGiZd = WV8iHTim.digest(L3V3lhC8.getBytes(ALEipConstants.DEF_CONTENT_ENCODING));
				ByteArrayOutputStream TBAY6oHm = new ByteArrayOutputStream(qp1cGiZd.length + qp1cGiZd.length / 3 + 1);
				OutputStream ZvpMyEhH = MimeUtility.encode(TBAY6oHm, "base64");
				ZvpMyEhH.write(qp1cGiZd);
				ZvpMyEhH.flush();
				ZvpMyEhH.close();
				return TBAY6oHm.toString();
			}
		} catch (Exception fsDoVq5f) {
			logger.error("Unable to encrypt password." + fsDoVq5f.getMessage(), fsDoVq5f);
			return null;
		}
	}

}