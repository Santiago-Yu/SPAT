class n14696592 {
	public static String hashClientPassword(String H4YOihC5, String jVxKgpi5, String onQFaW7C)
			throws IllegalArgumentException, DruidSafeRuntimeException {
		if (H4YOihC5 == null) {
			throw new IllegalArgumentException("THE ALGORITHM MUST NOT BE NULL");
		}
		if (jVxKgpi5 == null) {
			throw new IllegalArgumentException("THE PASSWORD MUST NOT BE NULL");
		}
		if (onQFaW7C == null) {
			onQFaW7C = "";
		}
		String Nhcma8sK = null;
		try {
			MessageDigest xmaZe9Nf = MessageDigest.getInstance(H4YOihC5);
			xmaZe9Nf.update(jVxKgpi5.getBytes());
			xmaZe9Nf.update(onQFaW7C.getBytes());
			Nhcma8sK = SecurityHelper.byteArrayToHexString(xmaZe9Nf.digest());
		} catch (NoSuchAlgorithmException xfMfarTA) {
			throw new DruidSafeRuntimeException(xfMfarTA);
		}
		return Nhcma8sK;
	}

}