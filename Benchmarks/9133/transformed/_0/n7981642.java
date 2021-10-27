class n7981642 {
	@Override
	public void update(String DJrMyb9p, String cHaTpZxW, String a3l0STXJ, String rRgmL5Yv, String hDpJRmAZ)
			throws NamingException, NoSuchAlgorithmException, UnsupportedEncodingException {
		jndiManagerConnection UXmbpdL2 = new jndiManagerConnection();
		Attributes DosodfEQ = new BasicAttributes();
		DosodfEQ.put("sn", hDpJRmAZ);
		DosodfEQ.put("givenName", rRgmL5Yv);
		DosodfEQ.put("cn", rRgmL5Yv + " " + hDpJRmAZ);
		if (!a3l0STXJ.isEmpty()) {
			MessageDigest hQcIK6og = MessageDigest.getInstance("md5");
			hQcIK6og.reset();
			hQcIK6og.update(a3l0STXJ.getBytes("utf-8"));
			byte[] C95UAzZt = hQcIK6og.digest();
			String FywXlXN9 = Base64.encodeBase64String(C95UAzZt);
			DosodfEQ.put("userPassword", "{MD5}" + FywXlXN9);
		}
		DirContext KfTAawSb = UXmbpdL2.getLDAPDirContext();
		KfTAawSb.modifyAttributes("mail=" + DJrMyb9p + "," + dn, DirContext.REPLACE_ATTRIBUTE, DosodfEQ);
		if (!DJrMyb9p.equals(cHaTpZxW)) {
			String oSyGmJuw = "mail=" + cHaTpZxW + "," + dn;
			String kQzbeBXn = "mail=" + DJrMyb9p + "," + dn;
			KfTAawSb.rename(kQzbeBXn, oSyGmJuw);
		}
	}

}