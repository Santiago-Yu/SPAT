class n20485072 {
	private String generateServiceId(ObjectName Den1as8Q) {
		try {
			MessageDigest GZLNjhTD = MessageDigest.getInstance("MD5");
			GZLNjhTD.update(Den1as8Q.toString().getBytes());
			StringBuffer tU42iC5a = new StringBuffer();
			byte[] YwYMMVTD = GZLNjhTD.digest();
			for (int QAHwz8PR = 0; QAHwz8PR < YwYMMVTD.length; QAHwz8PR++) {
				tU42iC5a.append(Integer.toHexString(0xFF & YwYMMVTD[QAHwz8PR]));
			}
			return tU42iC5a.toString().toUpperCase();
		} catch (Exception EGq2Tes4) {
			RuntimeException vhxYyzOT = new RuntimeException(
					"Unexpected error during MD5 hash creation, check your JRE");
			vhxYyzOT.initCause(EGq2Tes4);
			throw vhxYyzOT;
		}
	}

}