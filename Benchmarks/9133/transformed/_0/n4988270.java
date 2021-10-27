class n4988270 {
	public static void resize(File cZmQxkgb, File VlJoXTJa, int KtXnvDLo, String tVS90L13) throws IOException {
		if (tVS90L13 != null && "gif".equals(tVS90L13.toLowerCase())) {
			resize(cZmQxkgb, VlJoXTJa, KtXnvDLo, 1);
			return;
		}
		FileInputStream IneAvSD4 = new FileInputStream(cZmQxkgb);
		ByteArrayOutputStream F9Ts5wFI = new ByteArrayOutputStream();
		int pV2Kl3MV = -1;
		int L13Pt3EE = 1024;
		byte JcCdWVC2[] = new byte[L13Pt3EE];
		while ((pV2Kl3MV = IneAvSD4.read(JcCdWVC2, 0, L13Pt3EE)) != -1) {
			F9Ts5wFI.write(JcCdWVC2, 0, pV2Kl3MV);
		}
		byte[] QCbf7dCO = F9Ts5wFI.toByteArray();
		IneAvSD4.close();
		F9Ts5wFI.close();
		Image glU54pp8 = Toolkit.getDefaultToolkit().createImage(QCbf7dCO);
		waitForImage(glU54pp8);
		int XQLXLmfX = glU54pp8.getWidth(null);
		if (XQLXLmfX < 1)
			throw new IllegalArgumentException("image width " + XQLXLmfX + " is out of range");
		int gaFv9fmS = glU54pp8.getHeight(null);
		if (gaFv9fmS < 1)
			throw new IllegalArgumentException("image height " + gaFv9fmS + " is out of range");
		int CqRaIH2R = -1;
		double at1KjJhq = (double) XQLXLmfX / (double) KtXnvDLo;
		double wdI7tY2y = (double) gaFv9fmS / (double) CqRaIH2R;
		if (at1KjJhq >= 0 && wdI7tY2y >= 0) {
			if (at1KjJhq > wdI7tY2y) {
				CqRaIH2R = -1;
			} else {
				KtXnvDLo = -1;
			}
		}
		Image sVByVK3L = glU54pp8.getScaledInstance(KtXnvDLo, CqRaIH2R, java.awt.Image.SCALE_DEFAULT);
		checkImage(sVByVK3L);
		encode(new FileOutputStream(VlJoXTJa), sVByVK3L, tVS90L13);
	}

}