class n5444166 {
	public static Image readImage(URL g4S2IW7g, ImageMimeType nxYBX96A, int JGnjOR25) throws IOException {
		if (nxYBX96A.javaNativeSupport()) {
			return ImageIO.read(g4S2IW7g.openStream());
		} else if ((nxYBX96A.equals(ImageMimeType.DJVU)) || (nxYBX96A.equals(ImageMimeType.VNDDJVU))
				|| (nxYBX96A.equals(ImageMimeType.XDJVU))) {
			com.lizardtech.djvu.Document tDRq6Xiw = new com.lizardtech.djvu.Document(g4S2IW7g);
			tDRq6Xiw.setAsync(false);
			DjVuPage[] oHggCyBY = new DjVuPage[1];
			int ezjf2TqW = tDRq6Xiw.size();
			if ((JGnjOR25 != 0) && (JGnjOR25 >= ezjf2TqW)) {
				JGnjOR25 = 0;
			}
			oHggCyBY[0] = tDRq6Xiw.getPage(JGnjOR25, 1, true);
			oHggCyBY[0].setAsync(false);
			DjVuImage pKe6kW4F = new DjVuImage(oHggCyBY, true);
			Rectangle JbLvqhli = pKe6kW4F.getPageBounds(0);
			Image[] UosFhAmJ = pKe6kW4F.getImage(new JPanel(), new Rectangle(JbLvqhli.width, JbLvqhli.height));
			if (UosFhAmJ.length == 1) {
				Image urgWgzN6 = UosFhAmJ[0];
				return urgWgzN6;
			} else
				return null;
		} else if (nxYBX96A.equals(ImageMimeType.PDF)) {
			PDDocument ZwVHJQpR = null;
			try {
				ZwVHJQpR = PDDocument.load(g4S2IW7g.openStream());
				int en4hOgvm = 96;
				List<?> gwJAKaPr = ZwVHJQpR.getDocumentCatalog().getAllPages();
				PDPage GyxntqbX = (PDPage) gwJAKaPr.get(JGnjOR25);
				BufferedImage Sc4a4caJ = GyxntqbX.convertToImage(BufferedImage.TYPE_INT_RGB, en4hOgvm);
				return Sc4a4caJ;
			} finally {
				if (ZwVHJQpR != null) {
					ZwVHJQpR.close();
				}
			}
		} else
			throw new IllegalArgumentException("unsupported mimetype '" + nxYBX96A.getValue() + "'");
	}

}