class n8069594 {
	public static void copyFile(File kpVOkpp3, File VZ7ThiGY) throws IOException {
		if (kpVOkpp3.getCanonicalPath().equals(VZ7ThiGY.getCanonicalPath())) {
			return;
		}
		FileChannel tsPaMSg7 = new FileInputStream(kpVOkpp3).getChannel();
		FileChannel lhWbg7Xl = new FileOutputStream(VZ7ThiGY).getChannel();
		try {
			tsPaMSg7.transferTo(0, tsPaMSg7.size(), lhWbg7Xl);
		} catch (IOException ZTmmPlgM) {
			throw ZTmmPlgM;
		} finally {
			if (tsPaMSg7 != null) {
				tsPaMSg7.close();
			}
			if (lhWbg7Xl != null) {
				lhWbg7Xl.close();
			}
		}
	}

}