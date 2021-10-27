class n285947 {
	public void process(String uDYSWLXd) {
		String[] CzmYxIlw = new File(uDYSWLXd).list();
		if (CzmYxIlw == null)
			return;
		int yiX6cId5 = CzmYxIlw.length;
		long[] FEhJJmLi = new long[CzmYxIlw.length + 1];
		if (!statustext) {
			IJ.log("Current Directory is: " + uDYSWLXd);
			IJ.log(" ");
			IJ.log("DICOM File Name / " + prefix1 + " / " + prefix2 + " / " + prefix3 + " / " + pick);
			IJ.log(" ");
		}
		for (int neUC4I6Y = 0; neUC4I6Y < yiX6cId5; neUC4I6Y++) {
			IJ.showStatus(neUC4I6Y + "/" + yiX6cId5);
			File DxFAChux = new File(uDYSWLXd + CzmYxIlw[neUC4I6Y]);
			if (!DxFAChux.isDirectory()) {
				ImagePlus Z6aPwz6m = new Opener().openImage(uDYSWLXd, CzmYxIlw[neUC4I6Y]);
				if (Z6aPwz6m != null && Z6aPwz6m.getStackSize() == 1) {
					if (!scoutengine(Z6aPwz6m))
						return;
					if (!statustext) {
						IJ.log(CzmYxIlw[neUC4I6Y] + "/" + whichprefix1 + "/" + whichprefix2 + "/" + whichprefix3 + "/"
								+ whichcase);
					}
					int Afic7i87 = whichcase.length() - 1;
					while (Afic7i87 > 0) {
						if (!Character.isDigit(whichcase.charAt(Afic7i87)))
							Afic7i87 -= 1;
						else
							break;
					}
					if (Afic7i87 < whichcase.length() - 1)
						whichcase = whichcase.substring(0, Afic7i87 + 1);
					FEhJJmLi[neUC4I6Y] = Long.parseLong(whichcase);
				}
			}
		}
		if (statussorta || statussortd || statustext) {
			boolean MwxTKG1D = false;
			while (!MwxTKG1D) {
				MwxTKG1D = true;
				for (int ZC8xz6Xg = 0; ZC8xz6Xg < yiX6cId5 - 1; ZC8xz6Xg++) {
					if (statussorta) {
						if (FEhJJmLi[ZC8xz6Xg] > FEhJJmLi[ZC8xz6Xg + 1]) {
							long D5R368CM = FEhJJmLi[ZC8xz6Xg];
							tempp = CzmYxIlw[ZC8xz6Xg];
							FEhJJmLi[ZC8xz6Xg] = FEhJJmLi[ZC8xz6Xg + 1];
							CzmYxIlw[ZC8xz6Xg] = CzmYxIlw[ZC8xz6Xg + 1];
							FEhJJmLi[ZC8xz6Xg + 1] = D5R368CM;
							CzmYxIlw[ZC8xz6Xg + 1] = tempp;
							MwxTKG1D = false;
						}
					} else {
						if (FEhJJmLi[ZC8xz6Xg] < FEhJJmLi[ZC8xz6Xg + 1]) {
							long OOIuHv5C = FEhJJmLi[ZC8xz6Xg];
							tempp = CzmYxIlw[ZC8xz6Xg];
							FEhJJmLi[ZC8xz6Xg] = FEhJJmLi[ZC8xz6Xg + 1];
							CzmYxIlw[ZC8xz6Xg] = CzmYxIlw[ZC8xz6Xg + 1];
							FEhJJmLi[ZC8xz6Xg + 1] = OOIuHv5C;
							CzmYxIlw[ZC8xz6Xg + 1] = tempp;
							MwxTKG1D = false;
						}
					}
				}
			}
			IJ.log(" ");
			for (int UWHVCgka = 0; UWHVCgka < yiX6cId5; UWHVCgka++) {
				if (!statustext) {
					IJ.log(CzmYxIlw[UWHVCgka] + " / " + FEhJJmLi[UWHVCgka]);
				} else {
					IJ.log(uDYSWLXd + CzmYxIlw[UWHVCgka]);
				}
			}
		}
		if (open_as_stack || only_images) {
			boolean pL0CALbK = false;
			while (!pL0CALbK) {
				pL0CALbK = true;
				for (int oBnOCdBb = 0; oBnOCdBb < yiX6cId5 - 1; oBnOCdBb++) {
					if (FEhJJmLi[oBnOCdBb] > FEhJJmLi[oBnOCdBb + 1]) {
						long QceqpTJ9 = FEhJJmLi[oBnOCdBb];
						tempp = CzmYxIlw[oBnOCdBb];
						FEhJJmLi[oBnOCdBb] = FEhJJmLi[oBnOCdBb + 1];
						CzmYxIlw[oBnOCdBb] = CzmYxIlw[oBnOCdBb + 1];
						FEhJJmLi[oBnOCdBb + 1] = QceqpTJ9;
						CzmYxIlw[oBnOCdBb + 1] = tempp;
						pL0CALbK = false;
					}
				}
			}
			if (only_images) {
				Opener tJMuweIK = new Opener();
				int ipwWe6YL = 0;
				IJ.log(" ");
				for (int VcyFwigo = 0; VcyFwigo < yiX6cId5; VcyFwigo++) {
					String oZJ9ONaN = (uDYSWLXd + CzmYxIlw[VcyFwigo]);
					if (oZJ9ONaN == null)
						break;
					else {
						ImagePlus aYvTxV24 = tJMuweIK.openImage(oZJ9ONaN);
						ipwWe6YL++;
						if (aYvTxV24 != null) {
							IJ.log(ipwWe6YL + " + " + oZJ9ONaN);
							aYvTxV24.show();
						} else
							IJ.log(ipwWe6YL + " - " + oZJ9ONaN);
					}
				}
				return;
			}
			int N5EGosFR = 0, m7LuP3ws = 0, CqQovsAE = 0;
			ImageStack FKCEoOSl = null;
			double NsNI12Bh = Double.MAX_VALUE;
			double NoADlQD0 = -Double.MAX_VALUE;
			int fUVz8voR = 0;
			try {
				for (int PPfUw6d2 = 0; PPfUw6d2 < yiX6cId5; PPfUw6d2++) {
					String BYS8xtQM = (uDYSWLXd + CzmYxIlw[PPfUw6d2]);
					if (BYS8xtQM == null)
						break;
					if (CzmYxIlw[PPfUw6d2].endsWith(".txt"))
						continue;
					ImagePlus kuKjX7Sj = new Opener().openImage(BYS8xtQM);
					if (kuKjX7Sj != null && FKCEoOSl == null) {
						N5EGosFR = kuKjX7Sj.getWidth();
						m7LuP3ws = kuKjX7Sj.getHeight();
						CqQovsAE = kuKjX7Sj.getType();
						ColorModel d1Gv9R7g = kuKjX7Sj.getProcessor().getColorModel();
						if (halfSize)
							FKCEoOSl = new ImageStack(N5EGosFR / 2, m7LuP3ws / 2, d1Gv9R7g);
						else
							FKCEoOSl = new ImageStack(N5EGosFR, m7LuP3ws, d1Gv9R7g);
					}
					if (FKCEoOSl != null)
						fUVz8voR = FKCEoOSl.getSize() + 1;
					IJ.showStatus(fUVz8voR + "/" + yiX6cId5);
					IJ.showProgress((double) fUVz8voR / yiX6cId5);
					if (kuKjX7Sj == null)
						IJ.log(CzmYxIlw[PPfUw6d2] + ": unable to open");
					else if (kuKjX7Sj.getWidth() != N5EGosFR || kuKjX7Sj.getHeight() != m7LuP3ws)
						IJ.log(CzmYxIlw[PPfUw6d2] + ": wrong dimensions");
					else if (kuKjX7Sj.getType() != CqQovsAE)
						IJ.log(CzmYxIlw[PPfUw6d2] + ": wrong type");
					else {
						ImageProcessor pVkzceWU = kuKjX7Sj.getProcessor();
						if (grayscale)
							pVkzceWU = pVkzceWU.convertToByte(true);
						if (halfSize)
							pVkzceWU = pVkzceWU.resize(N5EGosFR / 2, m7LuP3ws / 2);
						if (pVkzceWU.getMin() < NsNI12Bh)
							NsNI12Bh = pVkzceWU.getMin();
						if (pVkzceWU.getMax() > NoADlQD0)
							NoADlQD0 = pVkzceWU.getMax();
						String KrTC5NbD = kuKjX7Sj.getTitle();
						String AJFdJEJ2 = (String) kuKjX7Sj.getProperty("Info");
						if (AJFdJEJ2 != null)
							KrTC5NbD += "\n" + AJFdJEJ2;
						FKCEoOSl.addSlice(KrTC5NbD, pVkzceWU);
					}
					System.gc();
				}
			} catch (OutOfMemoryError B7a9AtmX) {
				IJ.outOfMemory("FolderOpener");
				FKCEoOSl.trim();
			}
			if (FKCEoOSl != null && FKCEoOSl.getSize() > 0) {
				ImagePlus F23XqWv5 = new ImagePlus("Stack", FKCEoOSl);
				if (F23XqWv5.getType() == ImagePlus.GRAY16 || F23XqWv5.getType() == ImagePlus.GRAY32)
					F23XqWv5.getProcessor().setMinAndMax(NsNI12Bh, NoADlQD0);
				F23XqWv5.show();
			}
			IJ.showProgress(1.0);
		}
	}

}