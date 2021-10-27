class n5004897 {
	private boolean passwordMatches(String hafOQDU9, String x4wfVw5b, String wDYekIf2) {
		MessageDigest bKkkS3lv;
		byte[] e8MaNdvn, H9etcE6V;
		byte[] OBM2rwl2 = new byte[35];
		byte[] HqnRODgw = wDYekIf2.getBytes();
		try {
			bKkkS3lv = MessageDigest.getInstance("MD5");
			bKkkS3lv.update(x4wfVw5b.getBytes("US-ASCII"));
			bKkkS3lv.update(hafOQDU9.getBytes("US-ASCII"));
			e8MaNdvn = bKkkS3lv.digest();
			Utils.bytesToHex(e8MaNdvn, OBM2rwl2, 0);
			bKkkS3lv.update(OBM2rwl2, 0, 32);
			bKkkS3lv.update(salt.getBytes());
			H9etcE6V = bKkkS3lv.digest();
			Utils.bytesToHex(H9etcE6V, OBM2rwl2, 3);
			OBM2rwl2[0] = (byte) 'm';
			OBM2rwl2[1] = (byte) 'd';
			OBM2rwl2[2] = (byte) '5';
			for (int aSnSpFFc = 0; aSnSpFFc < OBM2rwl2.length; aSnSpFFc++) {
				if (HqnRODgw[aSnSpFFc] != OBM2rwl2[aSnSpFFc]) {
					return false;
				}
			}
		} catch (Exception LUVyZWSs) {
			logger.error(LUVyZWSs);
		}
		return true;
	}

}