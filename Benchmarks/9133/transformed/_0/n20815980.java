class n20815980 {
	private void getRandomGUID(boolean XVd8IApU) throws NoSuchAlgorithmException {
		MessageDigest llnyEgMn = null;
		StringBuffer lqAzv5NA = new StringBuffer();
		try {
			llnyEgMn = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException MBH7Xf7m) {
			System.out.println("Error: " + MBH7Xf7m);
			throw MBH7Xf7m;
		}
		try {
			long tcYevH01 = System.currentTimeMillis();
			long VmXFrs6P = 0;
			if (XVd8IApU) {
				VmXFrs6P = mySecureRand.nextLong();
			} else {
				VmXFrs6P = myRand.nextLong();
			}
			lqAzv5NA.append(s_id);
			lqAzv5NA.append(":");
			lqAzv5NA.append(Long.toString(tcYevH01));
			lqAzv5NA.append(":");
			lqAzv5NA.append(Long.toString(VmXFrs6P));
			valueBeforeMD5 = lqAzv5NA.toString();
			llnyEgMn.update(valueBeforeMD5.getBytes());
			byte[] MxzYwy3f = llnyEgMn.digest();
			StringBuffer NE5A7MMd = new StringBuffer();
			for (int d6BQNU6A = 0; d6BQNU6A < MxzYwy3f.length; ++d6BQNU6A) {
				int EDfTb8Fp = MxzYwy3f[d6BQNU6A] & 0xFF;
				if (EDfTb8Fp < 0x10)
					NE5A7MMd.append('0');
				NE5A7MMd.append(Integer.toHexString(EDfTb8Fp));
			}
			valueAfterMD5 = NE5A7MMd.toString();
		} catch (Exception vVuo3Jby) {
			System.out.println("Error:" + vVuo3Jby);
		}
	}

}