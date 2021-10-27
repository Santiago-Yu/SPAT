class n1695255 {
	boolean getHTML(URL url) {
		html = "";
		int r;
		BufferedInputStream in = null;
		BufferedInputStream imgIn = null;
		boolean retry;
		Vector imageRd = new Vector(0);
		do {
			retry = false;
			try {
				in = new BufferedInputStream(url.openStream(), 4096);
			} catch (IOException ioe) {
				rbe.stats.error("Unable to open URL.", url.toExternalForm());
				ioe.printStackTrace();
				retry = true;
				continue;
			}
			try {
				while ((r = in.read(buffer, 0, buffer.length)) != -1) {
					html = (r > 0) ? html + new String(buffer, 0, r) : html;
				}
			} catch (IOException ioe) {
				rbe.stats.error("Unable to read HTML from URL.", url.toExternalForm());
				retry = true;
				continue;
			}
			if (retry) {
				try {
					if (waitKey) {
						rbe.getKey();
					} else {
						sleep(1000L);
					}
				} catch (InterruptedException inte) {
					System.out.println("In getHTML, caught interrupted exception!");
					return true;
				}
			}
		} while (retry);
		try {
			in.close();
		} catch (IOException ioe) {
			rbe.stats.error("Unable to close URL.", url.toExternalForm());
		}
		if (DEBUG > 0) {
		}
		if (DEBUG > 10) {
			System.out.println(html);
		}
		int cur = 0;
		if (!RBE.getImage)
			return true;
		findImg(html, url, imgPat, srcPat, quotePat, imageRd);
		findImg(html, url, inputPat, srcPat, quotePat, imageRd);
		if (DEBUG > 2) {
			System.out.println("Found " + imageRd.size() + " images.");
		}
		while (imageRd.size() > 0) {
			int max = imageRd.size();
			int min = Math.max(max - rbe.maxImageRd, 0);
			int i;
			try {
				for (i = min; i < max; i++) {
					ImageReader rd = (ImageReader) imageRd.elementAt(i);
					if (!rd.readImage()) {
						if (DEBUG > 2) {
							System.out.println("Read " + rd.tot + " bytes from " + rd.imgURLStr);
						}
						imageRd.removeElementAt(i);
						i--;
						max--;
					}
				}
			} catch (InterruptedException inte) {
				System.out.println("In getHTML, caught interrupted exception!");
				return true;
			}
		}
		return true;
	}

}