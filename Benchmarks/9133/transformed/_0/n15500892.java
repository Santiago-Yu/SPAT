class n15500892 {
	private void getRandomGUID(boolean rN9ICzdV) {
		MessageDigest f5R94bZ3 = null;
		StringBuffer bF83Wnai = new StringBuffer();
		try {
			f5R94bZ3 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException xODXrVXi) {
			System.out.println("Error: " + xODXrVXi);
		}
		try {
			long Y1SGv8z9 = System.currentTimeMillis();
			long U96IdeFt = 0;
			if (rN9ICzdV) {
				U96IdeFt = mySecureRand.nextLong();
			} else {
				U96IdeFt = myRand.nextLong();
			}
			bF83Wnai.append(s_id);
			bF83Wnai.append(":");
			bF83Wnai.append(Long.toString(Y1SGv8z9));
			bF83Wnai.append(":");
			bF83Wnai.append(Long.toString(U96IdeFt));
			valueBeforeMD5 = bF83Wnai.toString();
			f5R94bZ3.update(valueBeforeMD5.getBytes());
			byte[] pojNc64R = f5R94bZ3.digest();
			StringBuffer RflpEqml = new StringBuffer();
			for (int F4gKz1qQ = 0; F4gKz1qQ < pojNc64R.length; ++F4gKz1qQ) {
				int BjrW2kl9 = pojNc64R[F4gKz1qQ] & 0xFF;
				if (BjrW2kl9 < 0x10)
					RflpEqml.append('0');
				RflpEqml.append(Integer.toHexString(BjrW2kl9));
			}
			valueAfterMD5 = RflpEqml.toString();
		} catch (Exception UasJhI00) {
			System.out.println("Error:" + UasJhI00);
		}
	}

}