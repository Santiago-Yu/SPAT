class n19319640 {
	private void copy(File uXwn1Jiv, File jCYSiCDm) {
		try {
			FileChannel MdgrtzYW = new FileInputStream(uXwn1Jiv).getChannel();
			FileChannel Cz84fKU9 = new FileOutputStream(jCYSiCDm).getChannel();
			try {
				MdgrtzYW.transferTo(0, MdgrtzYW.size(), Cz84fKU9);
				MdgrtzYW.close();
				Cz84fKU9.close();
			} catch (IOException yJa1zehH) {
				TestLogger.error(yJa1zehH);
			}
		} catch (FileNotFoundException xxaT24jn) {
			TestLogger.error(xxaT24jn);
		}
	}

}