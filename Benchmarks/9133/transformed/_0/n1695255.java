class n1695255 {
	boolean getHTML(URL ZADRNfxI) {
		html = "";
		int YwwJwsbR;
		BufferedInputStream Yr6jJOJh = null;
		BufferedInputStream ZbWJ0701 = null;
		boolean DO67320s;
		Vector Mw9IyWI4 = new Vector(0);
		do {
			DO67320s = false;
			try {
				Yr6jJOJh = new BufferedInputStream(ZADRNfxI.openStream(), 4096);
			} catch (IOException X1J2BZhX) {
				rbe.stats.error("Unable to open URL.", ZADRNfxI.toExternalForm());
				X1J2BZhX.printStackTrace();
				DO67320s = true;
				continue;
			}
			try {
				while ((YwwJwsbR = Yr6jJOJh.read(buffer, 0, buffer.length)) != -1) {
					if (YwwJwsbR > 0) {
						html = html + new String(buffer, 0, YwwJwsbR);
					}
				}
			} catch (IOException PunBwBOV) {
				rbe.stats.error("Unable to read HTML from URL.", ZADRNfxI.toExternalForm());
				DO67320s = true;
				continue;
			}
			if (DO67320s) {
				try {
					if (waitKey) {
						rbe.getKey();
					} else {
						sleep(1000L);
					}
				} catch (InterruptedException GeHDee3r) {
					System.out.println("In getHTML, caught interrupted exception!");
					return true;
				}
			}
		} while (DO67320s);
		try {
			Yr6jJOJh.close();
		} catch (IOException eJmXkM1h) {
			rbe.stats.error("Unable to close URL.", ZADRNfxI.toExternalForm());
		}
		if (DEBUG > 0) {
		}
		if (DEBUG > 10) {
			System.out.println(html);
		}
		int UYCxuzUw = 0;
		if (!RBE.getImage)
			return true;
		findImg(html, ZADRNfxI, imgPat, srcPat, quotePat, Mw9IyWI4);
		findImg(html, ZADRNfxI, inputPat, srcPat, quotePat, Mw9IyWI4);
		if (DEBUG > 2) {
			System.out.println("Found " + Mw9IyWI4.size() + " images.");
		}
		while (Mw9IyWI4.size() > 0) {
			int Oz7p5zN9 = Mw9IyWI4.size();
			int MhUoma2e = Math.max(Oz7p5zN9 - rbe.maxImageRd, 0);
			int VtCN03uX;
			try {
				for (VtCN03uX = MhUoma2e; VtCN03uX < Oz7p5zN9; VtCN03uX++) {
					ImageReader GJazLKK7 = (ImageReader) Mw9IyWI4.elementAt(VtCN03uX);
					if (!GJazLKK7.readImage()) {
						if (DEBUG > 2) {
							System.out.println("Read " + GJazLKK7.tot + " bytes from " + GJazLKK7.imgURLStr);
						}
						Mw9IyWI4.removeElementAt(VtCN03uX);
						VtCN03uX--;
						Oz7p5zN9--;
					}
				}
			} catch (InterruptedException hyghxa5h) {
				System.out.println("In getHTML, caught interrupted exception!");
				return true;
			}
		}
		return true;
	}

}