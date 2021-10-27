class n20019830 {
	public static void fileCopy(File fQNW2Qrg, File AATv3LzC) throws IOException {
		FileChannel uY2c7Gp8 = null;
		FileChannel RXZfAeeM = null;
		FileInputStream PNBi0Waz = null;
		FileOutputStream dgiHwltf = null;
		try {
			PNBi0Waz = new FileInputStream(fQNW2Qrg);
			dgiHwltf = new FileOutputStream(AATv3LzC);
			uY2c7Gp8 = PNBi0Waz.getChannel();
			RXZfAeeM = dgiHwltf.getChannel();
			RXZfAeeM.transferFrom(uY2c7Gp8, 0, uY2c7Gp8.size());
		} finally {
			PNBi0Waz.close();
			dgiHwltf.close();
			if (uY2c7Gp8 != null) {
				uY2c7Gp8.close();
			}
			if (RXZfAeeM != null) {
				RXZfAeeM.close();
			}
		}
	}

}