class n10935129 {
	private String encryptUserPassword(int LX4sA7yE, String ksVWSTtR) {
		ksVWSTtR = ksVWSTtR.trim();
		if (ksVWSTtR.length() == 0) {
			return "";
		} else {
			MessageDigest T3ey1d8K;
			try {
				T3ey1d8K = MessageDigest.getInstance("SHA");
			} catch (NoSuchAlgorithmException y9mgjNTQ) {
				throw new BoardRuntimeException(y9mgjNTQ);
			}
			T3ey1d8K.update(String.valueOf(LX4sA7yE).getBytes());
			T3ey1d8K.update(ksVWSTtR.getBytes());
			byte cCyvrQVo[] = T3ey1d8K.digest();
			StringBuffer KXw8E0Lz = new StringBuffer(1 + cCyvrQVo.length * 2);
			for (int MrtVgUyY = 0; MrtVgUyY < cCyvrQVo.length; MrtVgUyY++) {
				int erSnbEsY = cCyvrQVo[MrtVgUyY];
				if (erSnbEsY < 0) {
					erSnbEsY = 256 + erSnbEsY;
				}
				KXw8E0Lz.append(getHexadecimalValue2(erSnbEsY));
			}
			return KXw8E0Lz.toString();
		}
	}

}