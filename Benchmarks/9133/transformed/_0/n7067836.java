class n7067836 {
	private String generateFilename() {
		byte[] EblHIH4Q = null;
		try {
			MessageDigest MgEk6oOd = MessageDigest.getInstance("MD5");
			try {
				MgEk6oOd.update(InetAddress.getLocalHost().toString().getBytes());
			} catch (UnknownHostException fMtyveg3) {
			}
			MgEk6oOd.update(String.valueOf(System.currentTimeMillis()).getBytes());
			MgEk6oOd.update(String.valueOf(Runtime.getRuntime().freeMemory()).getBytes());
			byte[] K8X6s7rZ = new byte[128];
			new SecureRandom().nextBytes(K8X6s7rZ);
			MgEk6oOd.update(K8X6s7rZ);
			EblHIH4Q = MgEk6oOd.digest();
		} catch (NoSuchAlgorithmException eFqFSINn) {
			Debug.assrt(false);
		}
		return hexEncode(EblHIH4Q);
	}

}