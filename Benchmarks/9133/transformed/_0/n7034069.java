class n7034069 {
	public static String getSHA1Hash(String EMcik84D) {
		String mNdogbbv = "";
		MessageDigest rSLkkXGa;
		try {
			rSLkkXGa = MessageDigest.getInstance("SHA-1");
			rSLkkXGa.update(EMcik84D.getBytes("utf-8"));
			byte[] FQHNgvj3 = rSLkkXGa.digest();
			StringBuffer ajyiuw6N = new StringBuffer();
			for (int AjUM3D1N = 0; AjUM3D1N < FQHNgvj3.length; AjUM3D1N++) {
				int S8dHF3xf = (FQHNgvj3[AjUM3D1N] >>> 4) & 0x0F;
				int PQDP6SWD = 0;
				do {
					if ((0 <= S8dHF3xf) && (S8dHF3xf <= 9)) {
						ajyiuw6N.append((char) ('0' + S8dHF3xf));
					} else {
						ajyiuw6N.append((char) ('a' + (S8dHF3xf - 10)));
					}
					S8dHF3xf = FQHNgvj3[AjUM3D1N] & 0x0F;
				} while (PQDP6SWD++ < 1);
			}
			mNdogbbv = ajyiuw6N.toString();
		} catch (NoSuchAlgorithmException Uq976ppe) {
			Uq976ppe.printStackTrace();
		} catch (UnsupportedEncodingException ilz7GC7k) {
			ilz7GC7k.printStackTrace();
		}
		return mNdogbbv;
	}

}