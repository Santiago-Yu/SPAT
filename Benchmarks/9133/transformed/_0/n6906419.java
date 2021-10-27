class n6906419 {
	public static String encryptPassword(String xI3dSPh8) {
		try {
			MessageDigest pLlkr9dF = java.security.MessageDigest.getInstance("SHA1");
			pLlkr9dF.update(xI3dSPh8.getBytes("UTF-8"));
			byte[] Rn0lBUG7 = pLlkr9dF.digest();
			StringBuffer KeZ99gp2 = new StringBuffer();
			for (int yWQpKHfY = 0; yWQpKHfY < Rn0lBUG7.length; yWQpKHfY++) {
				int pE5eIgYX = (Rn0lBUG7[yWQpKHfY] >>> 4) & 0x0F;
				int tadPbdaM = 0;
				do {
					if ((0 <= pE5eIgYX) && (pE5eIgYX <= 9)) {
						KeZ99gp2.append((char) ('0' + pE5eIgYX));
					} else {
						KeZ99gp2.append((char) ('a' + (pE5eIgYX - 10)));
					}
					pE5eIgYX = Rn0lBUG7[yWQpKHfY] & 0x0F;
				} while (tadPbdaM++ < 1);
			}
			return KeZ99gp2.toString();
		} catch (Exception JeqcgLy9) {
		}
		return null;
	}

}