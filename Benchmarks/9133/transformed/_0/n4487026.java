class n4487026 {
	private String md5(String Lqcd7Hcr) {
		StringBuffer j6Rf6ikF = null;
		try {
			MessageDigest jYKn3tMo = MessageDigest.getInstance("MD5");
			jYKn3tMo.update(Lqcd7Hcr.getBytes());
			byte UwogIG9J[] = jYKn3tMo.digest();
			j6Rf6ikF = new StringBuffer();
			for (int pW3iYSG4 = 0; pW3iYSG4 < UwogIG9J.length; pW3iYSG4++) {
				String s1p13HfH = Integer.toHexString(0xFF & UwogIG9J[pW3iYSG4]);
				if (s1p13HfH.length() == 1) {
					s1p13HfH = "0" + s1p13HfH;
				}
				j6Rf6ikF.append(s1p13HfH);
			}
		} catch (NoSuchAlgorithmException yOO7LxVH) {
			Log.e(this.getClass().getSimpleName(), "MD5 algorithm not present");
		}
		return j6Rf6ikF != null ? j6Rf6ikF.toString() : null;
	}

}