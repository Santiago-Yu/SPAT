class n726690 {
	public void process(String H9Q34Xlc) {
		String[] HnySuYDG = new File(H9Q34Xlc).list();
		if (HnySuYDG == null)
			return;
		int WFl8Tblt = HnySuYDG.length;
		long[] sKfs98mK = new long[HnySuYDG.length + 1];
		if (!statustext) {
			IJ.log("Current Directory is: " + H9Q34Xlc);
			IJ.log(" ");
			IJ.log("DICOM File Name / " + prefix1 + " / " + prefix2 + " / " + prefix3 + " / " + pick);
			IJ.log(" ");
		}
		for (int ctsXybrK = 0; ctsXybrK < WFl8Tblt; ctsXybrK++) {
			IJ.showStatus(ctsXybrK + "/" + WFl8Tblt);
			File CNJs1sUH = new File(H9Q34Xlc + HnySuYDG[ctsXybrK]);
			if (!CNJs1sUH.isDirectory()) {
				ImagePlus H2SrzJ1b = new Opener().openImage(H9Q34Xlc, HnySuYDG[ctsXybrK]);
				if (H2SrzJ1b != null && H2SrzJ1b.getStackSize() == 1) {
					if (!scoutengine(H2SrzJ1b))
						return;
					if (!statustext) {
						IJ.log(HnySuYDG[ctsXybrK] + "/" + whichprefix1 + "/" + whichprefix2 + "/" + whichprefix3 + "/"
								+ whichcase);
					}
					int SJ1kIDOc = whichcase.length() - 1;
					while (SJ1kIDOc > 0) {
						if (!Character.isDigit(whichcase.charAt(SJ1kIDOc)))
							SJ1kIDOc -= 1;
						else
							break;
					}
					if (SJ1kIDOc < whichcase.length() - 1)
						whichcase = whichcase.substring(0, SJ1kIDOc + 1);
					sKfs98mK[ctsXybrK] = Long.parseLong(whichcase);
				}
			}
		}
		if (statussorta || statussortd || statustext) {
			boolean D5afZtk0 = false;
			while (!D5afZtk0) {
				D5afZtk0 = true;
				for (int xUVFttlM = 0; xUVFttlM < WFl8Tblt - 1; xUVFttlM++) {
					if (statussorta) {
						if (sKfs98mK[xUVFttlM] > sKfs98mK[xUVFttlM + 1]) {
							long q4XoYjsY = sKfs98mK[xUVFttlM];
							tempp = HnySuYDG[xUVFttlM];
							sKfs98mK[xUVFttlM] = sKfs98mK[xUVFttlM + 1];
							HnySuYDG[xUVFttlM] = HnySuYDG[xUVFttlM + 1];
							sKfs98mK[xUVFttlM + 1] = q4XoYjsY;
							HnySuYDG[xUVFttlM + 1] = tempp;
							D5afZtk0 = false;
						}
					} else {
						if (sKfs98mK[xUVFttlM] < sKfs98mK[xUVFttlM + 1]) {
							long sG0ik8Dy = sKfs98mK[xUVFttlM];
							tempp = HnySuYDG[xUVFttlM];
							sKfs98mK[xUVFttlM] = sKfs98mK[xUVFttlM + 1];
							HnySuYDG[xUVFttlM] = HnySuYDG[xUVFttlM + 1];
							sKfs98mK[xUVFttlM + 1] = sG0ik8Dy;
							HnySuYDG[xUVFttlM + 1] = tempp;
							D5afZtk0 = false;
						}
					}
				}
			}
			IJ.log(" ");
			for (int rFfCwnl9 = 0; rFfCwnl9 < WFl8Tblt; rFfCwnl9++) {
				if (!statustext) {
					IJ.log(HnySuYDG[rFfCwnl9] + " / " + sKfs98mK[rFfCwnl9]);
				} else {
					IJ.log(H9Q34Xlc + HnySuYDG[rFfCwnl9]);
				}
			}
		}
		if (open_as_stack || only_images) {
			boolean aYbppLs5 = false;
			while (!aYbppLs5) {
				aYbppLs5 = true;
				for (int hj2ELeet = 0; hj2ELeet < WFl8Tblt - 1; hj2ELeet++) {
					if (sKfs98mK[hj2ELeet] > sKfs98mK[hj2ELeet + 1]) {
						long liieNfEw = sKfs98mK[hj2ELeet];
						tempp = HnySuYDG[hj2ELeet];
						sKfs98mK[hj2ELeet] = sKfs98mK[hj2ELeet + 1];
						HnySuYDG[hj2ELeet] = HnySuYDG[hj2ELeet + 1];
						sKfs98mK[hj2ELeet + 1] = liieNfEw;
						HnySuYDG[hj2ELeet + 1] = tempp;
						aYbppLs5 = false;
					}
				}
			}
			if (only_images) {
				Opener e6NkCb29 = new Opener();
				int NaGut8uv = 0;
				IJ.log(" ");
				for (int fYrIq0Qp = 0; fYrIq0Qp < WFl8Tblt; fYrIq0Qp++) {
					String Onmj8pQN = (H9Q34Xlc + HnySuYDG[fYrIq0Qp]);
					if (Onmj8pQN == null)
						break;
					else {
						ImagePlus jDqQ3zRw = e6NkCb29.openImage(Onmj8pQN);
						NaGut8uv++;
						if (jDqQ3zRw != null) {
							IJ.log(NaGut8uv + " + " + Onmj8pQN);
							jDqQ3zRw.show();
						} else
							IJ.log(NaGut8uv + " - " + Onmj8pQN);
					}
				}
				return;
			}
			int qxPWWkHV = 0, yMRg9tzc = 0, IpFtVgAU = 0;
			ImageStack W7XPy4CS = null;
			double n8aOnVKk = Double.MAX_VALUE;
			double ZK3HjHOC = -Double.MAX_VALUE;
			int Jy833dKG = 0;
			try {
				for (int gxPaUSXv = 0; gxPaUSXv < WFl8Tblt; gxPaUSXv++) {
					String Zw4RsrpQ = (H9Q34Xlc + HnySuYDG[gxPaUSXv]);
					if (Zw4RsrpQ == null)
						break;
					if (HnySuYDG[gxPaUSXv].endsWith(".txt"))
						continue;
					ImagePlus fkZaIyOm = new Opener().openImage(Zw4RsrpQ);
					if (fkZaIyOm != null && W7XPy4CS == null) {
						qxPWWkHV = fkZaIyOm.getWidth();
						yMRg9tzc = fkZaIyOm.getHeight();
						IpFtVgAU = fkZaIyOm.getType();
						ColorModel rhpBZPhD = fkZaIyOm.getProcessor().getColorModel();
						if (halfSize)
							W7XPy4CS = new ImageStack(qxPWWkHV / 2, yMRg9tzc / 2, rhpBZPhD);
						else
							W7XPy4CS = new ImageStack(qxPWWkHV, yMRg9tzc, rhpBZPhD);
					}
					if (W7XPy4CS != null)
						Jy833dKG = W7XPy4CS.getSize() + 1;
					IJ.showStatus(Jy833dKG + "/" + WFl8Tblt);
					IJ.showProgress((double) Jy833dKG / WFl8Tblt);
					if (fkZaIyOm == null)
						IJ.log(HnySuYDG[gxPaUSXv] + ": unable to open");
					else if (fkZaIyOm.getWidth() != qxPWWkHV || fkZaIyOm.getHeight() != yMRg9tzc)
						IJ.log(HnySuYDG[gxPaUSXv] + ": wrong dimensions");
					else if (fkZaIyOm.getType() != IpFtVgAU)
						IJ.log(HnySuYDG[gxPaUSXv] + ": wrong type");
					else {
						ImageProcessor XYwgyu9e = fkZaIyOm.getProcessor();
						if (grayscale)
							XYwgyu9e = XYwgyu9e.convertToByte(true);
						if (halfSize)
							XYwgyu9e = XYwgyu9e.resize(qxPWWkHV / 2, yMRg9tzc / 2);
						if (XYwgyu9e.getMin() < n8aOnVKk)
							n8aOnVKk = XYwgyu9e.getMin();
						if (XYwgyu9e.getMax() > ZK3HjHOC)
							ZK3HjHOC = XYwgyu9e.getMax();
						String bF50SLuP = fkZaIyOm.getTitle();
						String Ebh6cwGB = (String) fkZaIyOm.getProperty("Info");
						if (Ebh6cwGB != null)
							bF50SLuP += "\n" + Ebh6cwGB;
						W7XPy4CS.addSlice(bF50SLuP, XYwgyu9e);
					}
					System.gc();
				}
			} catch (OutOfMemoryError VU5tekEo) {
				IJ.outOfMemory("FolderOpener");
				W7XPy4CS.trim();
			}
			if (W7XPy4CS != null && W7XPy4CS.getSize() > 0) {
				ImagePlus s1QsL5FF = new ImagePlus("Stack", W7XPy4CS);
				if (s1QsL5FF.getType() == ImagePlus.GRAY16 || s1QsL5FF.getType() == ImagePlus.GRAY32)
					s1QsL5FF.getProcessor().setMinAndMax(n8aOnVKk, ZK3HjHOC);
				s1QsL5FF.show();
			}
			IJ.showProgress(1.0);
		}
	}

}