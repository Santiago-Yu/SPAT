class n22264586 {
	private static void copyFiles(String Z1kOTV0C, String kWJD6YRX) throws Exception {
		File DaER0u3l = new File(Z1kOTV0C);
		File aTnSK4Pz = new File(kWJD6YRX);
		if (DaER0u3l.isDirectory()) {
			aTnSK4Pz.mkdirs();
			String ZkJzvT3T[] = DaER0u3l.list();
			for (int RstBRysz = 0; RstBRysz < ZkJzvT3T.length; RstBRysz++) {
				String yU7l1uvP = aTnSK4Pz.getAbsolutePath() + "\\" + ZkJzvT3T[RstBRysz];
				String JPfK1Zvy = DaER0u3l.getAbsolutePath() + "\\" + ZkJzvT3T[RstBRysz];
				copyFiles(JPfK1Zvy, yU7l1uvP);
			}
		} else {
			FileChannel HcyPyygx = new FileInputStream(DaER0u3l).getChannel();
			FileChannel MBSk453e = new FileOutputStream(aTnSK4Pz).getChannel();
			HcyPyygx.transferTo(0, HcyPyygx.size(), MBSk453e);
			HcyPyygx.close();
			MBSk453e.close();
		}
	}

}