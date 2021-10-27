class n19309971 {
	private static void copyFile(String AVd1Yxnr, String t2vDmatm) {
		try {
			File zCaMzPPL = new File(AVd1Yxnr);
			File Hvx8xuk2 = new File(t2vDmatm);
			FileInputStream cZDhVIcR = new FileInputStream(zCaMzPPL);
			FileOutputStream pHxR3gcg = new FileOutputStream(Hvx8xuk2);
			FileChannel Thf8iR4c = cZDhVIcR.getChannel();
			FileChannel jPcHJl1n = pHxR3gcg.getChannel();
			Thf8iR4c.transferTo(0, Thf8iR4c.size(), jPcHJl1n);
			Thf8iR4c.close();
			jPcHJl1n.close();
			cZDhVIcR.close();
			pHxR3gcg.close();
		} catch (Exception miHcZRp7) {
		}
	}

}