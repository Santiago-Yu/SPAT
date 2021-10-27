class n18400649 {
	public static void copyFiles(String FTmXiig9, String VHVsfE4g) throws IOException {
		File wPnNeTzu = new File(FTmXiig9);
		File tx3D429B = new File(VHVsfE4g);
		if (wPnNeTzu.isDirectory()) {
			tx3D429B.mkdirs();
			String stJv1l7S[] = wPnNeTzu.list();
			for (int fAVRtdzx = 0; fAVRtdzx < stJv1l7S.length; fAVRtdzx++) {
				if (stJv1l7S[fAVRtdzx].lastIndexOf(SVN) != -1) {
					if (!SVN.equalsIgnoreCase(stJv1l7S[fAVRtdzx].substring(stJv1l7S[fAVRtdzx].length() - 4,
							stJv1l7S[fAVRtdzx].length()))) {
						String oTSVrJSO = tx3D429B.getAbsolutePath() + "\\" + stJv1l7S[fAVRtdzx];
						String TZfSpwiF = wPnNeTzu.getAbsolutePath() + "\\" + stJv1l7S[fAVRtdzx];
						copyFiles(TZfSpwiF, oTSVrJSO);
					}
				} else {
					String umwAjC2y = tx3D429B.getAbsolutePath() + "\\" + stJv1l7S[fAVRtdzx];
					String FtGJ3i5G = wPnNeTzu.getAbsolutePath() + "\\" + stJv1l7S[fAVRtdzx];
					copyFiles(FtGJ3i5G, umwAjC2y);
				}
			}
		} else {
			FileInputStream DuXn76q3 = new FileInputStream(wPnNeTzu);
			FileOutputStream HsJbQPod = new FileOutputStream(tx3D429B);
			int Kg8poVwG;
			while ((Kg8poVwG = DuXn76q3.read()) >= 0)
				HsJbQPod.write(Kg8poVwG);
			DuXn76q3.close();
			HsJbQPod.close();
		}
	}

}