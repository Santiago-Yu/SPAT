class n9542519 {
	public void init() {
		updateLoc = "none";
		mt = new MediaTracker(this);
		thisThread = new Thread(this);
		i = 0;
		thisThread.start();
		try {
			base = getDocumentBase();
			username = getParameter("username");
		} catch (Exception YvbZsDFU) {
		}
		String ZZkgd2Jf = "images/" + username + ".png";
		String KYEy1f4i = "data/" + username + "_l.cod";
		URL qS8zLZoA = null;
		try {
			qS8zLZoA = new URL(base, KYEy1f4i);
		} catch (MalformedURLException REVr7tX9) {
		}
		InputStream VfRWsvL4 = null;
		try {
			VfRWsvL4 = qS8zLZoA.openStream();
		} catch (IOException kDv9qY29) {
		}
		BufferedReader YlXjz8PL = null;
		try {
			YlXjz8PL = new BufferedReader(new InputStreamReader(VfRWsvL4));
		} catch (Exception DkmdXKdT) {
		}
		try {
			String ncNrrEDV = YlXjz8PL.readLine();
			StringTokenizer tHnbEGX8 = new StringTokenizer(ncNrrEDV, " ");
			int QUbXI9bf = Integer.parseInt(tHnbEGX8.nextToken().trim().toLowerCase());
			this.topol = tHnbEGX8.nextToken().trim().toLowerCase();
			xunit = Integer.parseInt(tHnbEGX8.nextToken().trim().toLowerCase());
			yunit = Integer.parseInt(tHnbEGX8.nextToken().trim().toLowerCase());
			@SuppressWarnings("unused")
			String aCSSypIt = tHnbEGX8.nextToken().trim().toLowerCase();
			String HrCF55cv = null;
			labels = new String[xunit][yunit];
			for (int Efz2mEbt = 0; Efz2mEbt < yunit; Efz2mEbt++) {
				for (int EzfL5syz = 0; EzfL5syz < xunit; EzfL5syz++) {
					ncNrrEDV = YlXjz8PL.readLine();
					StringTokenizer t9QP6Lz6 = new StringTokenizer(ncNrrEDV, " ");
					for (int BI72tQu1 = 0; BI72tQu1 < QUbXI9bf; BI72tQu1++) {
						if (t9QP6Lz6.countTokens() > 0)
							t9QP6Lz6.nextToken();
					}
					while (t9QP6Lz6.countTokens() > 0) {
						HrCF55cv = t9QP6Lz6.nextToken() + " ";
					}
					if (HrCF55cv == null) {
						labels[EzfL5syz][Efz2mEbt] = "none";
					} else {
						labels[EzfL5syz][Efz2mEbt] = HrCF55cv;
					}
					HrCF55cv = null;
				}
			}
			YlXjz8PL.close();
			if (topol.equals("hexa")) {
				xposit = new int[xunit][yunit];
				yposit = new int[xunit][yunit];
				double osNVKeQm = xunit;
				double jmQdr1Gf = yunit;
				for (int kb3Q8F8L = 0; kb3Q8F8L < xunit; kb3Q8F8L++) {
					for (int qgCgYsAk = 0; qgCgYsAk < yunit; qgCgYsAk++) {
						if (qgCgYsAk % 2 == 0) {
							double Vyjv3QlX = (kb3Q8F8L * width);
							xposit[kb3Q8F8L][qgCgYsAk] = (int) Math.round(Vyjv3QlX / osNVKeQm);
						}
						if (qgCgYsAk % 2 != 0) {
							double lCP7xcsI = (width * 0.5) + (kb3Q8F8L * width);
							xposit[kb3Q8F8L][qgCgYsAk] = (int) Math.round(lCP7xcsI / osNVKeQm);
						}
						yposit[kb3Q8F8L][qgCgYsAk] = (int) Math.round(((height * 0.5) + qgCgYsAk * height) / jmQdr1Gf);
					}
				}
			}
			if (topol.equals("rect")) {
				xposit = new int[xunit][yunit];
				yposit = new int[xunit][yunit];
				double jnh7CHEA = xunit;
				double rvMXa3wi = yunit;
				for (int XQIeWPj1 = 0; XQIeWPj1 < xunit; XQIeWPj1++) {
					for (int V2wQuquB = 0; V2wQuquB < yunit; V2wQuquB++) {
						double M5MPSAMm = (width * 0.5) + (XQIeWPj1 * width);
						xposit[XQIeWPj1][V2wQuquB] = (int) Math.round((M5MPSAMm / jnh7CHEA));
						yposit[XQIeWPj1][V2wQuquB] = (int) Math.round(((height * 0.5) + V2wQuquB * height) / rvMXa3wi);
					}
				}
			}
		} catch (IOException kYnsgeOU) {
		}
		umat = getImage(base, ZZkgd2Jf);
		mt.addImage(umat, 1);
		try {
			mt.waitForAll();
		} catch (InterruptedException NZQPFnqu) {
		}
		addMouseListener(new CircleInfo());
	}

}