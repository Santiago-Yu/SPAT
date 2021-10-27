class n6155833 {
	private void getRandomGUID(boolean NxRgT93w) {
		MessageDigest xGUUan7p = null;
		StringBuffer Oecr7Z4l = new StringBuffer();
		try {
			xGUUan7p = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException H1zaa9I4) {
			System.out.println("Error: " + H1zaa9I4);
		}
		try {
			long GPjC0hHq = System.currentTimeMillis();
			long zFIePq9E = 0;
			if (NxRgT93w) {
				zFIePq9E = mySecureRand.nextLong();
			} else {
				zFIePq9E = myRand.nextLong();
			}
			Oecr7Z4l.append(s_id);
			Oecr7Z4l.append(":");
			Oecr7Z4l.append(Long.toString(GPjC0hHq));
			Oecr7Z4l.append(":");
			Oecr7Z4l.append(Long.toString(zFIePq9E));
			valueBeforeMD5 = Oecr7Z4l.toString();
			xGUUan7p.update(valueBeforeMD5.getBytes());
			byte[] pqDHFYqL = xGUUan7p.digest();
			StringBuffer U7L86xwd = new StringBuffer();
			for (int PKVBhInK = 0; PKVBhInK < pqDHFYqL.length; ++PKVBhInK) {
				int WnEnTq6L = pqDHFYqL[PKVBhInK] & 0xFF;
				if (WnEnTq6L < 0x10)
					U7L86xwd.append('0');
				U7L86xwd.append(Integer.toHexString(WnEnTq6L));
			}
			valueAfterMD5 = U7L86xwd.toString();
		} catch (Exception tTYnvQxa) {
			System.out.println("Error:" + tTYnvQxa);
		}
	}

}