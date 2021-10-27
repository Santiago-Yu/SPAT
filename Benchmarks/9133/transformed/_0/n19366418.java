class n19366418 {
	public static Photo createPhoto(String CuXoauVc, String qTs7OMQB, String nvBv4k2Y, String XQMUPNLX)
			throws NoSuchAlgorithmException, IOException {
		String Lq8OJvDO = CryptSHA1.genPhotoID(qTs7OMQB, CuXoauVc);
		String KPfBA8JK = nvBv4k2Y.substring(nvBv4k2Y.lastIndexOf("."));
		String Sssy00kz = XQMUPNLX + Lq8OJvDO + KPfBA8JK;
		FileInputStream owc6AahS = new FileInputStream(nvBv4k2Y);
		FileOutputStream xAA3NaGZ = new FileOutputStream(Sssy00kz);
		FileChannel oiKHOcRD = owc6AahS.getChannel();
		FileChannel JeMjRo5Z = xAA3NaGZ.getChannel();
		ByteBuffer uvCTBmAh = ByteBuffer.allocate(1024);
		while (true) {
			int HQDv6Qs9 = oiKHOcRD.read(uvCTBmAh);
			if (HQDv6Qs9 == -1)
				break;
			uvCTBmAh.flip();
			JeMjRo5Z.write(uvCTBmAh);
			uvCTBmAh.clear();
		}
		oiKHOcRD.close();
		JeMjRo5Z.close();
		xAA3NaGZ.close();
		owc6AahS.close();
		ImageIcon zYpf1QTr;
		ImageIcon NwCXADXq;
		String eq62Dp3a = XQMUPNLX + "thumb/" + Lq8OJvDO + KPfBA8JK;
		zYpf1QTr = new ImageIcon(Sssy00kz);
		int dtveesWS = 150;
		int EpDx5Rgp = zYpf1QTr.getIconWidth();
		int OmZQwUqo = zYpf1QTr.getIconHeight();
		if (EpDx5Rgp > OmZQwUqo) {
			NwCXADXq = new ImageIcon(zYpf1QTr.getImage().getScaledInstance(dtveesWS, -1, Image.SCALE_SMOOTH));
		} else {
			NwCXADXq = new ImageIcon(zYpf1QTr.getImage().getScaledInstance(-1, dtveesWS, Image.SCALE_SMOOTH));
		}
		BufferedImage FpVbwa1X = new BufferedImage(NwCXADXq.getIconWidth(), NwCXADXq.getIconHeight(),
				BufferedImage.TYPE_INT_RGB);
		Graphics FOlWE4z0 = FpVbwa1X.getGraphics();
		FOlWE4z0.drawImage(NwCXADXq.getImage(), 0, 0, null);
		try {
			ImageIO.write(FpVbwa1X, "JPG", new File(eq62Dp3a));
		} catch (IOException dVal2drO) {
			System.out.println("Error occured saving thumbnail");
		}
		Photo G5g2vNZM = new Photo(Lq8OJvDO);
		G5g2vNZM.setTitle(CuXoauVc);
		G5g2vNZM.basePathImage = XQMUPNLX;
		return G5g2vNZM;
	}

}