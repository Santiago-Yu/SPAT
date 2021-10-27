class n9639432 {
	private static String deviceIdFromCombined_Device_ID(Context context) {
		StringBuilder builder = new StringBuilder();
		builder.append(deviceIdFromIMEI(context));
		builder.append(deviceIdFromPseudo_Unique_Id());
		builder.append(deviceIdFromAndroidId(context));
		builder.append(deviceIdFromWLAN_MAC_Address(context));
		builder.append(deviceIdFromBT_MAC_Address(context));
		MessageDigest m = null;
		String m_szLongID = builder.toString();
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		m.update(m_szLongID.getBytes(), 0, m_szLongID.length());
		String m_szUniqueID = new String();
		byte p_md5Data[] = m.digest();
		for (int i = 0; i < p_md5Data.length; i++) {
			int b = (0xFF & p_md5Data[i]);
			if (b <= 0xF)
				m_szUniqueID += "0";
			m_szUniqueID += Integer.toHexString(b);
		}
		return m_szUniqueID;
	}

}