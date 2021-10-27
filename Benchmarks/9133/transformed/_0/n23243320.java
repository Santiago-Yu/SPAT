class n23243320 {
	private void getRandomGUID(boolean zBxeM1o4) {
		MessageDigest mNU2LTJu = null;
		StringBuffer eyFBpQHV = new StringBuffer();
		try {
			mNU2LTJu = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException BB4d1CQg) {
			System.out.println("Error: " + BB4d1CQg);
		}
		try {
			long y6vftX5G = System.currentTimeMillis();
			long TCUJbPFz = 0;
			if (zBxeM1o4) {
				TCUJbPFz = mySecureRand.nextLong();
			} else {
				TCUJbPFz = myRand.nextLong();
			}
			eyFBpQHV.append(s_id);
			eyFBpQHV.append(":");
			eyFBpQHV.append(Long.toString(y6vftX5G));
			eyFBpQHV.append(":");
			eyFBpQHV.append(Long.toString(TCUJbPFz));
			valueBeforeMD5 = eyFBpQHV.toString();
			mNU2LTJu.update(valueBeforeMD5.getBytes());
			byte[] ZTb7wG9V = mNU2LTJu.digest();
			StringBuffer aoIUMy77 = new StringBuffer();
			for (int zE6qzVPs = 0; zE6qzVPs < ZTb7wG9V.length; ++zE6qzVPs) {
				int i8myfrTb = ZTb7wG9V[zE6qzVPs] & 0xFF;
				if (i8myfrTb < 0x10)
					aoIUMy77.append('0');
				aoIUMy77.append(Integer.toHexString(i8myfrTb));
			}
			valueAfterMD5 = aoIUMy77.toString();
		} catch (Exception olxy3ykd) {
			System.out.println("Error:" + olxy3ykd);
		}
	}

}