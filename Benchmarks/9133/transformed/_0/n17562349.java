class n17562349 {
	public String digestResponse() {
		String CPxZR52W = null;
		if (null == nonce)
			return null;
		try {
			MessageDigest N09ILIWq = MessageDigest.getInstance("MD5");
			N09ILIWq.update(username.getBytes());
			N09ILIWq.update(":".getBytes());
			N09ILIWq.update(realm.getBytes());
			N09ILIWq.update(":".getBytes());
			N09ILIWq.update(password.getBytes());
			byte[] Q6kEbsxq = N09ILIWq.digest();
			if (null != algorithm && -1 != (algorithm.toLowerCase()).indexOf("md5-sess")) {
				N09ILIWq = MessageDigest.getInstance("MD5");
				N09ILIWq.update(Q6kEbsxq);
				N09ILIWq.update(":".getBytes());
				N09ILIWq.update(nonce.getBytes());
				N09ILIWq.update(":".getBytes());
				N09ILIWq.update(cnonce.getBytes());
				Q6kEbsxq = N09ILIWq.digest();
			}
			byte[] brPLG5J8 = bytesToHex(Q6kEbsxq);
			N09ILIWq = MessageDigest.getInstance("MD5");
			N09ILIWq.update(method.getBytes());
			N09ILIWq.update(":".getBytes());
			N09ILIWq.update(uri.getBytes());
			Q6kEbsxq = N09ILIWq.digest();
			byte[] bKxQ29Nj = bytesToHex(Q6kEbsxq);
			N09ILIWq = MessageDigest.getInstance("MD5");
			N09ILIWq.update(brPLG5J8);
			N09ILIWq.update(":".getBytes());
			N09ILIWq.update(nonce.getBytes());
			N09ILIWq.update(":".getBytes());
			if (null != qop) {
				N09ILIWq.update(nonceCount.getBytes());
				N09ILIWq.update(":".getBytes());
				N09ILIWq.update(cnonce.getBytes());
				N09ILIWq.update(":".getBytes());
				N09ILIWq.update(qop.getBytes());
				N09ILIWq.update(":".getBytes());
			}
			N09ILIWq.update(bKxQ29Nj);
			Q6kEbsxq = N09ILIWq.digest();
			byte[] EyjxTNPf = bytesToHex(Q6kEbsxq);
			CPxZR52W = new String(EyjxTNPf);
		} catch (Exception zCWw2XYI) {
			zCWw2XYI.printStackTrace();
		}
		return CPxZR52W;
	}

}