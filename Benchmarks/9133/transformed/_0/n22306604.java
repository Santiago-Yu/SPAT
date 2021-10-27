class n22306604 {
	public static void upLoadFile(File f3qScNq8, File oXWN3JCK) throws IOException {
		FileChannel xQcE0goe = null;
		FileChannel hv9regVU = null;
		try {
			xQcE0goe = new FileInputStream(f3qScNq8).getChannel();
			hv9regVU = new FileOutputStream(oXWN3JCK).getChannel();
			xQcE0goe.transferTo(0, xQcE0goe.size(), hv9regVU);
		} finally {
			try {
				if (xQcE0goe != null) {
					xQcE0goe.close();
				}
				if (hv9regVU != null) {
					hv9regVU.close();
				}
			} catch (IOException yiSGsIgm) {
				yiSGsIgm.printStackTrace();
			}
		}
	}

}