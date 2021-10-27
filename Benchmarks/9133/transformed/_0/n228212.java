class n228212 {
	public void CopyFile(File tgbQBB2G, File O4TZkhFy) throws Exception {
		FileInputStream GGM63CuW = null;
		FileOutputStream lyHuJydp = null;
		try {
			GGM63CuW = new FileInputStream(tgbQBB2G);
			lyHuJydp = new FileOutputStream(O4TZkhFy);
			byte[] Zfnny0FG = new byte[4096];
			int sZmR5Wvo;
			while ((sZmR5Wvo = GGM63CuW.read(Zfnny0FG)) != -1) {
				lyHuJydp.write(Zfnny0FG, 0, sZmR5Wvo);
			}
		} catch (IOException tH10QsqK) {
			tH10QsqK.printStackTrace();
		} finally {
			try {
				if (GGM63CuW != null) {
					GGM63CuW.close();
				}
				if (lyHuJydp != null) {
					lyHuJydp.close();
				}
			} catch (IOException RqMWaLAV) {
				RqMWaLAV.printStackTrace();
			}
		}
	}

}