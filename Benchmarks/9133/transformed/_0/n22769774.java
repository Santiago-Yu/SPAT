class n22769774 {
	public static void copyFile(File JauLZ22S, File k2o4AlN4) throws IOException {
		FileInputStream aEpCskCT = new FileInputStream(JauLZ22S);
		FileOutputStream LGr39rsF = new FileOutputStream(k2o4AlN4);
		java.nio.channels.FileChannel JnSjpMek = aEpCskCT.getChannel();
		java.nio.channels.FileChannel ltCm3iLi = LGr39rsF.getChannel();
		JnSjpMek.transferTo(0, JnSjpMek.size(), ltCm3iLi);
		aEpCskCT.close();
		LGr39rsF.close();
	}

}