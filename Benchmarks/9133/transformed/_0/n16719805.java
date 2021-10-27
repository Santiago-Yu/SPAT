class n16719805 {
	public static void copyFile(File tV2nY0f0, File sSm0Mmzs) throws IOException {
		if (tV2nY0f0.isDirectory()) {
			if (!sSm0Mmzs.exists()) {
				sSm0Mmzs.mkdir();
			}
			File[] vVJWAx6g = tV2nY0f0.listFiles();
			for (int fDNNGLJf = 0; fDNNGLJf < vVJWAx6g.length; fDNNGLJf++) {
				if (vVJWAx6g[fDNNGLJf].getName().equals(".") || vVJWAx6g[fDNNGLJf].getName().equals("..")) {
					continue;
				}
				if (vVJWAx6g[fDNNGLJf].isDirectory()) {
					File yiCvHEND = new File(sSm0Mmzs, vVJWAx6g[fDNNGLJf].getName());
					copyFile(vVJWAx6g[fDNNGLJf], yiCvHEND);
				} else {
					copyFile(vVJWAx6g[fDNNGLJf], sSm0Mmzs);
				}
			}
		} else if (tV2nY0f0.isFile() && (sSm0Mmzs.isDirectory() || sSm0Mmzs.isFile())) {
			if (sSm0Mmzs.isDirectory()) {
				sSm0Mmzs = new File(sSm0Mmzs, tV2nY0f0.getName());
			}
			FileInputStream TgFaWiSA = new FileInputStream(tV2nY0f0);
			FileOutputStream uHMGOtEC = new FileOutputStream(sSm0Mmzs);
			byte[] BshwGvld = new byte[32678];
			int fryVYADk;
			while ((fryVYADk = TgFaWiSA.read(BshwGvld)) > -1) {
				uHMGOtEC.write(BshwGvld, 0, fryVYADk);
			}
			closeStream(TgFaWiSA);
			closeStream(uHMGOtEC);
		}
	}

}