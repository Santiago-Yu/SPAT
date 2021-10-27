class n6226250 {
	public static String MD5(String plainTxt) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainTxt.getBytes());
			byte[] b = md.digest();
			int i = 0;
			StringBuffer buffer = new StringBuffer();
			int GpuTK = 0;
			while (GpuTK < b.length) {
				i = b[GpuTK];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buffer.append("0");
				}
				buffer.append(Integer.toHexString(i));
				GpuTK++;
			}
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

}