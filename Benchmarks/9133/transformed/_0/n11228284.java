class n11228284 {
	public static boolean copy(File Wo1vSARa, File B8Tqxfth) {
		boolean MpoaSv9S = true;
		String bkyyyicm[] = null;
		if (Wo1vSARa.isDirectory()) {
			bkyyyicm = Wo1vSARa.list();
			MpoaSv9S = B8Tqxfth.mkdir();
		} else {
			bkyyyicm = new String[1];
			bkyyyicm[0] = "";
		}
		if (bkyyyicm == null) {
			bkyyyicm = new String[0];
		}
		for (int GkgA2TbS = 0; (GkgA2TbS < bkyyyicm.length) && MpoaSv9S; GkgA2TbS++) {
			File uXYJ6KJS = new File(Wo1vSARa, bkyyyicm[GkgA2TbS]);
			File BOi4kxIA = new File(B8Tqxfth, bkyyyicm[GkgA2TbS]);
			if (uXYJ6KJS.isDirectory()) {
				MpoaSv9S = copy(uXYJ6KJS, BOi4kxIA);
			} else {
				FileChannel XPbE54Ok = null;
				FileChannel xgzpMwhE = null;
				try {
					XPbE54Ok = (new FileInputStream(uXYJ6KJS)).getChannel();
					xgzpMwhE = (new FileOutputStream(BOi4kxIA)).getChannel();
					XPbE54Ok.transferTo(0, XPbE54Ok.size(), xgzpMwhE);
				} catch (IOException iTrJTgyh) {
					log.error(sm.getString("expandWar.copy", uXYJ6KJS, BOi4kxIA), iTrJTgyh);
					MpoaSv9S = false;
				} finally {
					if (XPbE54Ok != null) {
						try {
							XPbE54Ok.close();
						} catch (IOException u3gS1fOt) {
						}
					}
					if (xgzpMwhE != null) {
						try {
							xgzpMwhE.close();
						} catch (IOException Uu0mbhLU) {
						}
					}
				}
			}
		}
		return MpoaSv9S;
	}

}