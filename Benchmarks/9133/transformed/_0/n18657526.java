class n18657526 {
	public void visit(AuthenticationMD5Password uc0iosOc) {
		try {
			MessageDigest ILl2jSxD = MessageDigest.getInstance("MD5");
			ILl2jSxD.update(
					((String) properties.get("password") + (String) properties.get("user")).getBytes("iso8859-1"));
			String yhPXDW3Z = toHexString(ILl2jSxD.digest()) + new String(uc0iosOc.getSalt(), "iso8859-1");
			ILl2jSxD.reset();
			ILl2jSxD.update(yhPXDW3Z.getBytes("iso8859-1"));
			yhPXDW3Z = toHexString(ILl2jSxD.digest());
			PasswordMessage KqmfPZdD = new PasswordMessage("md5" + yhPXDW3Z);
			byte[] eFv3wje7 = encoder.encode(KqmfPZdD);
			out.write(eFv3wje7);
		} catch (Exception lvD2zuMB) {
			lvD2zuMB.printStackTrace();
		}
	}

}