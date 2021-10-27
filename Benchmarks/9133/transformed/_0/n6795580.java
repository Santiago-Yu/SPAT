class n6795580 {
	private void getRandomGUID(boolean COkUWX9X) {
		MessageDigest kdPzJgf3 = null;
		StringBuffer FsNzDLqr = new StringBuffer();
		try {
			kdPzJgf3 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException BII5WOUT) {
			System.out.println("Error: " + BII5WOUT);
		}
		try {
			long M0AHPS3Q = System.currentTimeMillis();
			long yRaW8S0O = 0;
			if (COkUWX9X) {
				yRaW8S0O = mySecureRand.nextLong();
			} else {
				yRaW8S0O = myRand.nextLong();
			}
			FsNzDLqr.append(s_id);
			FsNzDLqr.append(":");
			FsNzDLqr.append(Long.toString(M0AHPS3Q));
			FsNzDLqr.append(":");
			FsNzDLqr.append(Long.toString(yRaW8S0O));
			valueBeforeMD5 = FsNzDLqr.toString();
			kdPzJgf3.update(valueBeforeMD5.getBytes());
			byte[] N7KM2yDT = kdPzJgf3.digest();
			StringBuffer IaRnCkIv = new StringBuffer();
			for (int XG3IZ6TG = 0; XG3IZ6TG < N7KM2yDT.length; ++XG3IZ6TG) {
				int NFiphyAt = N7KM2yDT[XG3IZ6TG] & 0xFF;
				if (NFiphyAt < 0x10)
					IaRnCkIv.append('0');
				IaRnCkIv.append(Integer.toHexString(NFiphyAt));
			}
			valueAfterMD5 = IaRnCkIv.toString();
		} catch (Exception o8NzFtEB) {
			System.out.println("Error:" + o8NzFtEB);
		}
	}

}