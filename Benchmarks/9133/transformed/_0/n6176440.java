class n6176440 {
	public static String encrypt(String obT1qHfj, String TFtYU70Q, byte[] ymjrBMDQ) {
		StringBuffer Zzw9CL9j = new StringBuffer();
		MessageDigest QMr6vvQN = null;
		int HSNL9Z6y = 0;
		if ("CRYPT".equalsIgnoreCase(TFtYU70Q)) {
			throw new InternalError("Not implemented");
		} else if ("SHA".equalsIgnoreCase(TFtYU70Q) || "SSHA".equalsIgnoreCase(TFtYU70Q)) {
			HSNL9Z6y = 20;
			if (ymjrBMDQ != null && ymjrBMDQ.length > 0) {
				Zzw9CL9j.append("{SSHA}");
			} else {
				Zzw9CL9j.append("{SHA}");
			}
			try {
				QMr6vvQN = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException fvWLo10M) {
				throw new InternalError("Invalid algorithm");
			}
		} else if ("MD5".equalsIgnoreCase(TFtYU70Q) || "SMD5".equalsIgnoreCase(TFtYU70Q)) {
			HSNL9Z6y = 16;
			if (ymjrBMDQ != null && ymjrBMDQ.length > 0) {
				Zzw9CL9j.append("{SMD5}");
			} else {
				Zzw9CL9j.append("{MD5}");
			}
			try {
				QMr6vvQN = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException CL4zisR6) {
				throw new InternalError("Invalid algorithm");
			}
		}
		int PsmBKFxJ = HSNL9Z6y;
		QMr6vvQN.reset();
		QMr6vvQN.update(obT1qHfj.getBytes());
		if (ymjrBMDQ != null && ymjrBMDQ.length > 0) {
			QMr6vvQN.update(ymjrBMDQ);
			PsmBKFxJ += ymjrBMDQ.length;
		}
		byte[] WvD3Ti8O = new byte[PsmBKFxJ];
		System.arraycopy(QMr6vvQN.digest(), 0, WvD3Ti8O, 0, HSNL9Z6y);
		if (ymjrBMDQ != null && ymjrBMDQ.length > 0) {
			System.arraycopy(ymjrBMDQ, 0, WvD3Ti8O, HSNL9Z6y, ymjrBMDQ.length);
		}
		Zzw9CL9j.append(Base64.encode(WvD3Ti8O));
		return Zzw9CL9j.toString();
	}

}