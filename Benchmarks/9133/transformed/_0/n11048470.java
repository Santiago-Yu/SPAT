class n11048470 {
	public static String download(String FzKcdMVx, String eHMTYR7B, String yJ4LXnwK) {
		String HkVasjOJ = "";
		try {
			long bf9uswfo = System.currentTimeMillis();
			URL lD1tBXVg = new URL(FzKcdMVx);
			lD1tBXVg.openConnection();
			InputStream wicWeRvD = lD1tBXVg.openStream();
			FileOutputStream WAUBnJZF = new FileOutputStream(eHMTYR7B + File.separator + yJ4LXnwK);
			byte[] uHKKNxbf = new byte[1024 * 1024];
			int g5cj8Q58 = 0;
			int mOjDUOYu = 0;
			while ((mOjDUOYu = wicWeRvD.read(uHKKNxbf)) > 0) {
				WAUBnJZF.write(uHKKNxbf, 0, mOjDUOYu);
				uHKKNxbf = new byte[153600];
				g5cj8Q58 += mOjDUOYu;
			}
			long XWzrpSs7 = System.currentTimeMillis();
			HkVasjOJ = "Done. " + (new Integer(g5cj8Q58).toString()) + " bytes read ("
					+ (new Long(XWzrpSs7 - bf9uswfo).toString()) + " millseconds).\n";
			WAUBnJZF.close();
			wicWeRvD.close();
		} catch (Exception XTtyF9qx) {
			HkVasjOJ = "Can not download. " + eHMTYR7B + File.separator + yJ4LXnwK + ":\n" + XTtyF9qx.getMessage();
		}
		return HkVasjOJ;
	}

}