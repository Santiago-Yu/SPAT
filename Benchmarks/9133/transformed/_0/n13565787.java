class n13565787 {
	public static String encryptPassword(String sA5Rp5WI) {
		StringBuffer zWLthm7R = new StringBuffer();
		try {
			MessageDigest sQZtLhXS = MessageDigest.getInstance("MD5");
			sQZtLhXS.update(sA5Rp5WI.getBytes());
			byte[] r43FMzuP = sQZtLhXS.digest();
			String QgLhux5U = null;
			for (int wELJ16k8 = 0; wELJ16k8 < r43FMzuP.length; wELJ16k8++) {
				QgLhux5U = Integer.toHexString(0xFF & r43FMzuP[wELJ16k8]);
				if (QgLhux5U.length() < 2)
					zWLthm7R.append("0");
				zWLthm7R.append(QgLhux5U);
			}
		} catch (Exception wgbjsR4Y) {
			System.out.println(wgbjsR4Y.getMessage());
		}
		return new String(zWLthm7R);
	}

}