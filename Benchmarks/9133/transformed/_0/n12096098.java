class n12096098 {
	public static String calculatesMD5(String Tul16dOZ) throws NoSuchAlgorithmException {
		MessageDigest IS4UlPmJ = MessageDigest.getInstance("MD5");
		IS4UlPmJ.update(Tul16dOZ.getBytes());
		byte[] Fnqcs35p = IS4UlPmJ.digest();
		StringBuffer pG014dxM = new StringBuffer();
		for (int Yw2fiEyU = 0; Yw2fiEyU < Fnqcs35p.length; Yw2fiEyU++) {
			Tul16dOZ = Integer.toHexString(0xFF & Fnqcs35p[Yw2fiEyU]);
			if (Tul16dOZ.length() < 2) {
				Tul16dOZ = "0" + Tul16dOZ;
			}
			pG014dxM.append(Tul16dOZ);
		}
		return pG014dxM.toString();
	}

}