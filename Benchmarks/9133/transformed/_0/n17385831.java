class n17385831 {
	public static void copyFile(String tfMqj7Oo, String F9sCUOQR) throws IOException {
		FileChannel xd2lWyiN = null;
		FileChannel vtxXeRn6 = null;
		try {
			xd2lWyiN = new FileInputStream(tfMqj7Oo).getChannel();
			vtxXeRn6 = new FileOutputStream(F9sCUOQR).getChannel();
			vtxXeRn6.transferFrom(xd2lWyiN, 0, xd2lWyiN.size());
		} catch (IOException nh0vJDVR) {
			throw nh0vJDVR;
		} finally {
			if (xd2lWyiN != null) {
				try {
					xd2lWyiN.close();
				} catch (IOException tmlRRxx5) {
				}
			}
			if (vtxXeRn6 != null) {
				try {
					vtxXeRn6.close();
				} catch (IOException JreHQHe5) {
				}
			}
		}
	}

}