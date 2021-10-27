class n4764618 {
	private void getRandomGUID(boolean h5UiGrh7) {
		MessageDigest WH2uhuVQ = null;
		StringBuffer ZpuXDb5D = new StringBuffer();
		try {
			WH2uhuVQ = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException nvBp5MKO) {
			System.out.println("Error: " + nvBp5MKO);
		}
		try {
			long LxKW9u2I = System.currentTimeMillis();
			long yU9O27ra = 0;
			if (h5UiGrh7) {
				yU9O27ra = mySecureRand.nextLong();
			} else {
				yU9O27ra = myRand.nextLong();
			}
			ZpuXDb5D.append(s_id);
			ZpuXDb5D.append(":");
			ZpuXDb5D.append(Long.toString(LxKW9u2I));
			ZpuXDb5D.append(":");
			ZpuXDb5D.append(Long.toString(yU9O27ra));
			valueBeforeMD5 = ZpuXDb5D.toString();
			WH2uhuVQ.update(valueBeforeMD5.getBytes());
			byte[] VB7uuxbc = WH2uhuVQ.digest();
			StringBuffer BABG4eN4 = new StringBuffer();
			for (int KeMOix0g = 0; KeMOix0g < VB7uuxbc.length; ++KeMOix0g) {
				int ArQrFwCE = VB7uuxbc[KeMOix0g] & 0xFF;
				if (ArQrFwCE < 0x10)
					BABG4eN4.append('0');
				BABG4eN4.append(Integer.toHexString(ArQrFwCE));
			}
			valueAfterMD5 = BABG4eN4.toString();
		} catch (Exception j69ZNuME) {
			System.out.println("Error:" + j69ZNuME);
		}
	}

}