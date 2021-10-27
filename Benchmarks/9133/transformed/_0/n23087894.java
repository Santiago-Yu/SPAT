class n23087894 {
	public static String digest(String JmZHk4MG) {
		StringBuffer qOpRYvjO = new StringBuffer();
		try {
			MessageDigest iAr64uUK = MessageDigest.getInstance("md5");
			iAr64uUK.update(JmZHk4MG.getBytes("ISO8859-1"));
			byte[] PxLZkkyd = iAr64uUK.digest();
			for (int h7LEfLPm = 0; h7LEfLPm < 16; h7LEfLPm++) {
				if ((PxLZkkyd[h7LEfLPm] & 0xff) < 0x10)
					qOpRYvjO.append("0");
				qOpRYvjO.append(Long.toString(PxLZkkyd[h7LEfLPm] & 0xff, 16));
			}
		} catch (Exception R0TH6lPj) {
			System.out.println(R0TH6lPj);
		}
		return qOpRYvjO.toString();
	}

}