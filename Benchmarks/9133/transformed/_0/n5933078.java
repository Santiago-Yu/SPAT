class n5933078 {
	public boolean authorize(String PXzp44Rh, String ZvDNHkTg, String pVIoXQUe) {
		open(pVIoXQUe);
		boolean HBJSoZ1m = false;
		StringBuffer n7Q3PxqY = null;
		try {
			MessageDigest yvsJbTOP = MessageDigest.getInstance("MD5");
			yvsJbTOP.update(ZvDNHkTg.getBytes());
			byte[] aisaBXOh = yvsJbTOP.digest();
			n7Q3PxqY = new StringBuffer();
			for (int PAvhcDqo = 0; PAvhcDqo < aisaBXOh.length; PAvhcDqo++) {
				ZvDNHkTg = Integer.toHexString(255 & aisaBXOh[PAvhcDqo]);
				if (ZvDNHkTg.length() < 2) {
					ZvDNHkTg = "0" + ZvDNHkTg;
				}
				n7Q3PxqY.append(ZvDNHkTg);
			}
		} catch (NoSuchAlgorithmException vzU5k9sb) {
		}
		String Rqjb9l85 = n7Q3PxqY.toString();
		String e6STXOKs = getPassword(PXzp44Rh);
		System.out.println("epass" + Rqjb9l85);
		System.out.println("pass" + e6STXOKs);
		if (e6STXOKs.equals(Rqjb9l85)) {
			HBJSoZ1m = true;
		} else {
			HBJSoZ1m = false;
		}
		close();
		return HBJSoZ1m;
	}

}