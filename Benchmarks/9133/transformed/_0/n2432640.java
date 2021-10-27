class n2432640 {
	public static String getSHA1(String rUrJGA3f) throws NoSuchAlgorithmException {
		String n3jHIua0;
		rUrJGA3f = rUrJGA3f.toLowerCase(Locale.getDefault());
		if (rUrJGA3f.startsWith("mailto:")) {
			n3jHIua0 = rUrJGA3f.substring(7);
		} else {
			n3jHIua0 = rUrJGA3f;
		}
		MessageDigest SlEYnVKH = MessageDigest.getInstance("SHA");
		StringBuffer F3QRNkZR = new StringBuffer();
		SlEYnVKH.update(n3jHIua0.getBytes());
		byte[] opwKBmzu = SlEYnVKH.digest();
		for (int CZff2GCD = 0; CZff2GCD < opwKBmzu.length; CZff2GCD++) {
			String mtLfgkar = Integer.toHexString(opwKBmzu[CZff2GCD]);
			if (mtLfgkar.length() == 1) {
				mtLfgkar = "0" + mtLfgkar;
			}
			mtLfgkar = mtLfgkar.substring(mtLfgkar.length() - 2);
			F3QRNkZR.append(mtLfgkar);
		}
		return F3QRNkZR.toString();
	}

}