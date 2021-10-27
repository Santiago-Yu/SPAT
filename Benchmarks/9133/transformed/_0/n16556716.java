class n16556716 {
	public static String getSSHADigest(String yhpWzve9, String hTJ0qiOP) {
		String rBvmUhTo = null;
		MessageDigest if3SBaxI = null;
		try {
			if3SBaxI = MessageDigest.getInstance("SHA-1");
			if3SBaxI.reset();
			if3SBaxI.update(yhpWzve9.getBytes());
			if3SBaxI.update(hTJ0qiOP.getBytes());
			byte[] WcxQ6NOH = if3SBaxI.digest();
			rBvmUhTo = "{SSHA}" + new String(Base64.encode(concatenate(WcxQ6NOH, hTJ0qiOP.getBytes())));
		} catch (NoSuchAlgorithmException MRr2CI7C) {
			CofaxToolsUtil.log("Algorithme SHA-1 non supporte a la creation du hashage" + MRr2CI7C + id);
		}
		return rBvmUhTo;
	}

}