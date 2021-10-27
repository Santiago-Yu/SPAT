class n2450 {
	public void process(String bl3tTl3m) {
		String[] DI3sS4BL = new File(bl3tTl3m).list();
		if (DI3sS4BL == null)
			return;
		int QjQ1cZ3I = DI3sS4BL.length;
		long[] pvZC8skU = new long[DI3sS4BL.length + 1];
		if (!statustext) {
			IJ.log("Current Directory is: " + bl3tTl3m);
			IJ.log(" ");
			IJ.log("DICOM File Name / " + prefix1 + " / " + prefix2 + " / " + prefix3 + " / " + pick);
			IJ.log(" ");
		}
		for (int pnCmDdYO = 0; pnCmDdYO < QjQ1cZ3I; pnCmDdYO++) {
			IJ.showStatus(pnCmDdYO + "/" + QjQ1cZ3I);
			File n0gEP7hj = new File(bl3tTl3m + DI3sS4BL[pnCmDdYO]);
			if (!n0gEP7hj.isDirectory()) {
				ImagePlus BrOvP8PI = new Opener().openImage(bl3tTl3m, DI3sS4BL[pnCmDdYO]);
				if (BrOvP8PI != null && BrOvP8PI.getStackSize() == 1) {
					if (!scoutengine(BrOvP8PI))
						return;
					if (!statustext) {
						IJ.log(DI3sS4BL[pnCmDdYO] + "/" + whichprefix1 + "/" + whichprefix2 + "/" + whichprefix3 + "/"
								+ whichcase);
					}
					int czbl7hWA = whichcase.length() - 1;
					while (czbl7hWA > 0) {
						if (!Character.isDigit(whichcase.charAt(czbl7hWA)))
							czbl7hWA -= 1;
						else
							break;
					}
					if (czbl7hWA < whichcase.length() - 1)
						whichcase = whichcase.substring(0, czbl7hWA + 1);
					pvZC8skU[pnCmDdYO] = Long.parseLong(whichcase);
				}
			}
		}
		if (statussorta || statussortd || statustext) {
			boolean rpKpjisX = false;
			while (!rpKpjisX) {
				rpKpjisX = true;
				for (int VXSlfsWw = 0; VXSlfsWw < QjQ1cZ3I - 1; VXSlfsWw++) {
					if (statussorta) {
						if (pvZC8skU[VXSlfsWw] > pvZC8skU[VXSlfsWw + 1]) {
							long vYWMQao4 = pvZC8skU[VXSlfsWw];
							tempp = DI3sS4BL[VXSlfsWw];
							pvZC8skU[VXSlfsWw] = pvZC8skU[VXSlfsWw + 1];
							DI3sS4BL[VXSlfsWw] = DI3sS4BL[VXSlfsWw + 1];
							pvZC8skU[VXSlfsWw + 1] = vYWMQao4;
							DI3sS4BL[VXSlfsWw + 1] = tempp;
							rpKpjisX = false;
						}
					} else {
						if (pvZC8skU[VXSlfsWw] < pvZC8skU[VXSlfsWw + 1]) {
							long sadzP8dJ = pvZC8skU[VXSlfsWw];
							tempp = DI3sS4BL[VXSlfsWw];
							pvZC8skU[VXSlfsWw] = pvZC8skU[VXSlfsWw + 1];
							DI3sS4BL[VXSlfsWw] = DI3sS4BL[VXSlfsWw + 1];
							pvZC8skU[VXSlfsWw + 1] = sadzP8dJ;
							DI3sS4BL[VXSlfsWw + 1] = tempp;
							rpKpjisX = false;
						}
					}
				}
			}
			IJ.log(" ");
			for (int JOTUwWli = 0; JOTUwWli < QjQ1cZ3I; JOTUwWli++) {
				if (!statustext) {
					IJ.log(DI3sS4BL[JOTUwWli] + " / " + pvZC8skU[JOTUwWli]);
				} else {
					IJ.log(bl3tTl3m + DI3sS4BL[JOTUwWli]);
				}
			}
		}
		if (open_as_stack || only_images) {
			boolean xdOYsukt = false;
			while (!xdOYsukt) {
				xdOYsukt = true;
				for (int zMMT21XO = 0; zMMT21XO < QjQ1cZ3I - 1; zMMT21XO++) {
					if (pvZC8skU[zMMT21XO] > pvZC8skU[zMMT21XO + 1]) {
						long TLbftZV3 = pvZC8skU[zMMT21XO];
						tempp = DI3sS4BL[zMMT21XO];
						pvZC8skU[zMMT21XO] = pvZC8skU[zMMT21XO + 1];
						DI3sS4BL[zMMT21XO] = DI3sS4BL[zMMT21XO + 1];
						pvZC8skU[zMMT21XO + 1] = TLbftZV3;
						DI3sS4BL[zMMT21XO + 1] = tempp;
						xdOYsukt = false;
					}
				}
			}
			if (only_images) {
				Opener Hi32EPFU = new Opener();
				int byWuLlT6 = 0;
				IJ.log(" ");
				for (int L5L4wCZx = 0; L5L4wCZx < QjQ1cZ3I; L5L4wCZx++) {
					String d7ZaSEBw = (bl3tTl3m + DI3sS4BL[L5L4wCZx]);
					if (d7ZaSEBw == null)
						break;
					else {
						ImagePlus GMfGYNvF = Hi32EPFU.openImage(d7ZaSEBw);
						byWuLlT6++;
						if (GMfGYNvF != null) {
							IJ.log(byWuLlT6 + " + " + d7ZaSEBw);
							GMfGYNvF.show();
						} else
							IJ.log(byWuLlT6 + " - " + d7ZaSEBw);
					}
				}
				return;
			}
			int izTNRzXM = 0, uS2j5Rjf = 0, XfswAils = 0;
			ImageStack F8Xn9py7 = null;
			double AXd4kXrB = Double.MAX_VALUE;
			double nlfjpWuu = -Double.MAX_VALUE;
			int RP8dFY2o = 0;
			try {
				for (int PqmHcPh3 = 0; PqmHcPh3 < QjQ1cZ3I; PqmHcPh3++) {
					String IkyRmzNf = (bl3tTl3m + DI3sS4BL[PqmHcPh3]);
					if (IkyRmzNf == null)
						break;
					if (DI3sS4BL[PqmHcPh3].endsWith(".txt"))
						continue;
					ImagePlus Nw1HirIK = new Opener().openImage(IkyRmzNf);
					if (Nw1HirIK != null && F8Xn9py7 == null) {
						izTNRzXM = Nw1HirIK.getWidth();
						uS2j5Rjf = Nw1HirIK.getHeight();
						XfswAils = Nw1HirIK.getType();
						ColorModel Y8DfwdnF = Nw1HirIK.getProcessor().getColorModel();
						if (halfSize)
							F8Xn9py7 = new ImageStack(izTNRzXM / 2, uS2j5Rjf / 2, Y8DfwdnF);
						else
							F8Xn9py7 = new ImageStack(izTNRzXM, uS2j5Rjf, Y8DfwdnF);
					}
					if (F8Xn9py7 != null)
						RP8dFY2o = F8Xn9py7.getSize() + 1;
					IJ.showStatus(RP8dFY2o + "/" + QjQ1cZ3I);
					IJ.showProgress((double) RP8dFY2o / QjQ1cZ3I);
					if (Nw1HirIK == null)
						IJ.log(DI3sS4BL[PqmHcPh3] + ": unable to open");
					else if (Nw1HirIK.getWidth() != izTNRzXM || Nw1HirIK.getHeight() != uS2j5Rjf)
						IJ.log(DI3sS4BL[PqmHcPh3] + ": wrong dimensions");
					else if (Nw1HirIK.getType() != XfswAils)
						IJ.log(DI3sS4BL[PqmHcPh3] + ": wrong type");
					else {
						ImageProcessor cXR6wgUv = Nw1HirIK.getProcessor();
						if (grayscale)
							cXR6wgUv = cXR6wgUv.convertToByte(true);
						if (halfSize)
							cXR6wgUv = cXR6wgUv.resize(izTNRzXM / 2, uS2j5Rjf / 2);
						if (cXR6wgUv.getMin() < AXd4kXrB)
							AXd4kXrB = cXR6wgUv.getMin();
						if (cXR6wgUv.getMax() > nlfjpWuu)
							nlfjpWuu = cXR6wgUv.getMax();
						String DBpJZ7vS = Nw1HirIK.getTitle();
						String HmJyGpYJ = (String) Nw1HirIK.getProperty("Info");
						if (HmJyGpYJ != null)
							DBpJZ7vS += "\n" + HmJyGpYJ;
						F8Xn9py7.addSlice(DBpJZ7vS, cXR6wgUv);
					}
					System.gc();
				}
			} catch (OutOfMemoryError tvgUsB40) {
				IJ.outOfMemory("FolderOpener");
				F8Xn9py7.trim();
			}
			if (F8Xn9py7 != null && F8Xn9py7.getSize() > 0) {
				ImagePlus F40bq9Y1 = new ImagePlus("Stack", F8Xn9py7);
				if (F40bq9Y1.getType() == ImagePlus.GRAY16 || F40bq9Y1.getType() == ImagePlus.GRAY32)
					F40bq9Y1.getProcessor().setMinAndMax(AXd4kXrB, nlfjpWuu);
				F40bq9Y1.show();
			}
			IJ.showProgress(1.0);
		}
	}

}