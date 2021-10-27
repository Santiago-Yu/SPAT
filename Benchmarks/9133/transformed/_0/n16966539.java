class n16966539 {
	public String MD5(String XMzXfU8d) {
		try {
			MessageDigest cU55WEFh;
			cU55WEFh = MessageDigest.getInstance("MD5");
			byte[] J1rhYbBb = new byte[32];
			cU55WEFh.update(XMzXfU8d.getBytes("iso-8859-1"), 0, XMzXfU8d.length());
			J1rhYbBb = cU55WEFh.digest();
			return convertToHex(J1rhYbBb);
		} catch (Exception RHST005m) {
			System.out.println(RHST005m.toString());
		}
		return null;
	}

}