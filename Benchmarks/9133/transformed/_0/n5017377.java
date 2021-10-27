class n5017377 {
	public static String sha1(String htyezqOP) {
		StringBuffer S3NZCi1P = new StringBuffer();
		try {
			MessageDigest Hrk72gJw = MessageDigest.getInstance("SHA-1");
			byte[] kkvpEq9y = new byte[40];
			Hrk72gJw.update(htyezqOP.getBytes("iso-8859-1"), 0, htyezqOP.length());
			kkvpEq9y = Hrk72gJw.digest();
			for (int o0WxW2TL = 0; o0WxW2TL < kkvpEq9y.length; o0WxW2TL++) {
				int wg5Z1FOY = (kkvpEq9y[o0WxW2TL] >>> 4) & 0x0F;
				int hCNBJyrZ = 0;
				do {
					if ((0 <= wg5Z1FOY) && (wg5Z1FOY <= 9))
						S3NZCi1P.append((char) ('0' + wg5Z1FOY));
					else
						S3NZCi1P.append((char) ('a' + (wg5Z1FOY - 10)));
					wg5Z1FOY = kkvpEq9y[o0WxW2TL] & 0x0F;
				} while (hCNBJyrZ++ < 1);
			}
		} catch (Exception NOTi5SUT) {
			errorLog("{Malgn.sha1} " + NOTi5SUT.getMessage());
		}
		return S3NZCi1P.toString();
	}

}