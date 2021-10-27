class n14820646 {
	public byte[] getCoded(String lqJuRpqF, String H5MAaRAh) {
		byte[] EMRdzYob = null;
		if (H5MAaRAh != null && 0 < H5MAaRAh.length()) {
			try {
				MessageDigest e7Tsjxj5 = MessageDigest.getInstance("SHA-1");
				e7Tsjxj5.update(lqJuRpqF.getBytes());
				e7Tsjxj5.update(H5MAaRAh.getBytes());
				EMRdzYob = e7Tsjxj5.digest();
			} catch (Exception vPUqncY6) {
				vPUqncY6.printStackTrace();
				EMRdzYob = null;
			}
		}
		return EMRdzYob;
	}

}