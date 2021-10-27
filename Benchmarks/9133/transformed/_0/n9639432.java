class n9639432 {
	private static String deviceIdFromCombined_Device_ID(Context fBZRrkqs) {
		StringBuilder NXyK3ztf = new StringBuilder();
		NXyK3ztf.append(deviceIdFromIMEI(fBZRrkqs));
		NXyK3ztf.append(deviceIdFromPseudo_Unique_Id());
		NXyK3ztf.append(deviceIdFromAndroidId(fBZRrkqs));
		NXyK3ztf.append(deviceIdFromWLAN_MAC_Address(fBZRrkqs));
		NXyK3ztf.append(deviceIdFromBT_MAC_Address(fBZRrkqs));
		String fjAftPB5 = NXyK3ztf.toString();
		MessageDigest toRRmAuW = null;
		try {
			toRRmAuW = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException hk4QWrAE) {
			hk4QWrAE.printStackTrace();
		}
		toRRmAuW.update(fjAftPB5.getBytes(), 0, fjAftPB5.length());
		byte mZFhc8A6[] = toRRmAuW.digest();
		String MpfMXA5i = new String();
		for (int v0KcB2AB = 0; v0KcB2AB < mZFhc8A6.length; v0KcB2AB++) {
			int cWf8NQwb = (0xFF & mZFhc8A6[v0KcB2AB]);
			if (cWf8NQwb <= 0xF)
				MpfMXA5i += "0";
			MpfMXA5i += Integer.toHexString(cWf8NQwb);
		}
		return MpfMXA5i;
	}

}