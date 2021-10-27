class n5084569 {
	public static String generateGuid(boolean nAQgVEZj) {
		MessageDigest XX8eZgYL = null;
		String qM9OyZqA = null;
		String RFtuGLk1 = null;
		StringBuffer Pqm7Hrdl = new StringBuffer();
		try {
			XX8eZgYL = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException DPGgtIEK) {
			System.out.println("Error: " + DPGgtIEK);
		}
		try {
			long JYQabI6c = System.currentTimeMillis();
			long i4CH4zG5 = 0L;
			if (nAQgVEZj)
				i4CH4zG5 = mySecureRand.nextLong();
			else
				i4CH4zG5 = myRand.nextLong();
			Pqm7Hrdl.append(s_id);
			Pqm7Hrdl.append(":");
			Pqm7Hrdl.append(Long.toString(JYQabI6c));
			Pqm7Hrdl.append(":");
			Pqm7Hrdl.append(Long.toString(i4CH4zG5));
			qM9OyZqA = Pqm7Hrdl.toString();
			XX8eZgYL.update(qM9OyZqA.getBytes());
			byte GpqjUifO[] = XX8eZgYL.digest();
			StringBuffer K4RgRtuC = new StringBuffer();
			for (int MvBoN1PE = 0; MvBoN1PE < GpqjUifO.length; MvBoN1PE++) {
				int CGqOoGsV = GpqjUifO[MvBoN1PE] & 0xff;
				if (CGqOoGsV < 16)
					K4RgRtuC.append('0');
				K4RgRtuC.append(Integer.toHexString(CGqOoGsV));
			}
			RFtuGLk1 = K4RgRtuC.toString();
		} catch (Exception KSw9eVUN) {
			System.out.println("Error:" + KSw9eVUN);
		}
		String HOI2RQOs = RFtuGLk1.toUpperCase();
		StringBuffer JV2OEjNI = new StringBuffer();
		JV2OEjNI.append(HOI2RQOs.substring(0, 8));
		JV2OEjNI.append("-");
		JV2OEjNI.append(HOI2RQOs.substring(8, 12));
		JV2OEjNI.append("-");
		JV2OEjNI.append(HOI2RQOs.substring(12, 16));
		JV2OEjNI.append("-");
		JV2OEjNI.append(HOI2RQOs.substring(16, 20));
		JV2OEjNI.append("-");
		JV2OEjNI.append(HOI2RQOs.substring(20));
		return JV2OEjNI.toString();
	}

}