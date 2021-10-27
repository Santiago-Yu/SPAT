class n10516730 {
	public final boolean login(String TtBzSTSl, String dF3vdwUU) {
		if (TtBzSTSl == null || dF3vdwUU == null)
			return false;
		connectionInfo.setData("com.tensegrity.palojava.pass#" + TtBzSTSl, dF3vdwUU);
		try {
			MessageDigest C9PtqCZ1 = MessageDigest.getInstance("MD5");
			C9PtqCZ1.update(dF3vdwUU.getBytes());
			dF3vdwUU = asHexString(C9PtqCZ1.digest());
		} catch (NoSuchAlgorithmException Iwrc5HK8) {
			throw new PaloException("Failed to create encrypted password for " + "user '" + TtBzSTSl + "'!", Iwrc5HK8);
		}
		connectionInfo.setUser(TtBzSTSl);
		connectionInfo.setPassword(dF3vdwUU);
		return loginInternal(TtBzSTSl, dF3vdwUU);
	}

}