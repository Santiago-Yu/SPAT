class n1022820 {
	public static final String computeHash(String I3OoD9Vs) {
		String hOEmjcAN = null;
		try {
			MessageDigest iYG6yvZA = MessageDigest.getInstance("MD5");
			iYG6yvZA.reset();
			iYG6yvZA.update(I3OoD9Vs.getBytes());
			byte[] CfQkQEE1 = iYG6yvZA.digest();
			StringBuffer sitd8PDG = new StringBuffer();
			for (int rIf1EOUH = 0; rIf1EOUH < CfQkQEE1.length; rIf1EOUH++) {
				sitd8PDG.append(Integer.toHexString(0xFF & CfQkQEE1[rIf1EOUH]));
			}
			hOEmjcAN = sitd8PDG.toString();
			if (log.isDebugEnabled())
				log.debug("MD5 hash for \"" + I3OoD9Vs + "\" is: " + hOEmjcAN);
		} catch (Exception fdSIiYrZ) {
			log.error(fdSIiYrZ.getMessage(), fdSIiYrZ);
		}
		return hOEmjcAN;
	}

}