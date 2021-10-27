class n416857 {
	public void process(String cp8mCnjY) {
		String[] YftTJodo = new File(cp8mCnjY).list();
		if (YftTJodo == null)
			return;
		int a8SpzV2U = YftTJodo.length;
		long[] M1YyTxV7 = new long[YftTJodo.length + 1];
		if (!statustext) {
			IJ.log("Current Directory is: " + cp8mCnjY);
			IJ.log(" ");
			IJ.log("DICOM File Name / " + prefix1 + " / " + prefix2 + " / " + prefix3 + " / " + pick);
			IJ.log(" ");
		}
		for (int UfzuzBzt = 0; UfzuzBzt < a8SpzV2U; UfzuzBzt++) {
			IJ.showStatus(UfzuzBzt + "/" + a8SpzV2U);
			File YNO59rBp = new File(cp8mCnjY + YftTJodo[UfzuzBzt]);
			if (!YNO59rBp.isDirectory()) {
				ImagePlus IF6nNWfI = new Opener().openImage(cp8mCnjY, YftTJodo[UfzuzBzt]);
				if (IF6nNWfI != null && IF6nNWfI.getStackSize() == 1) {
					if (!scoutengine(IF6nNWfI))
						return;
					if (!statustext) {
						IJ.log(YftTJodo[UfzuzBzt] + "/" + whichprefix1 + "/" + whichprefix2 + "/" + whichprefix3 + "/"
								+ whichcase);
					}
					int Q6wmEBjk = whichcase.length() - 1;
					while (Q6wmEBjk > 0) {
						if (!Character.isDigit(whichcase.charAt(Q6wmEBjk)))
							Q6wmEBjk -= 1;
						else
							break;
					}
					if (Q6wmEBjk < whichcase.length() - 1)
						whichcase = whichcase.substring(0, Q6wmEBjk + 1);
					M1YyTxV7[UfzuzBzt] = Long.parseLong(whichcase);
				}
			}
		}
		if (statussorta || statussortd || statustext) {
			boolean FOi4Y01Q = false;
			while (!FOi4Y01Q) {
				FOi4Y01Q = true;
				for (int lgWGpsWG = 0; lgWGpsWG < a8SpzV2U - 1; lgWGpsWG++) {
					if (statussorta) {
						if (M1YyTxV7[lgWGpsWG] > M1YyTxV7[lgWGpsWG + 1]) {
							long E0RBVrkw = M1YyTxV7[lgWGpsWG];
							tempp = YftTJodo[lgWGpsWG];
							M1YyTxV7[lgWGpsWG] = M1YyTxV7[lgWGpsWG + 1];
							YftTJodo[lgWGpsWG] = YftTJodo[lgWGpsWG + 1];
							M1YyTxV7[lgWGpsWG + 1] = E0RBVrkw;
							YftTJodo[lgWGpsWG + 1] = tempp;
							FOi4Y01Q = false;
						}
					} else {
						if (M1YyTxV7[lgWGpsWG] < M1YyTxV7[lgWGpsWG + 1]) {
							long vITe746u = M1YyTxV7[lgWGpsWG];
							tempp = YftTJodo[lgWGpsWG];
							M1YyTxV7[lgWGpsWG] = M1YyTxV7[lgWGpsWG + 1];
							YftTJodo[lgWGpsWG] = YftTJodo[lgWGpsWG + 1];
							M1YyTxV7[lgWGpsWG + 1] = vITe746u;
							YftTJodo[lgWGpsWG + 1] = tempp;
							FOi4Y01Q = false;
						}
					}
				}
			}
			IJ.log(" ");
			for (int e85gOx8x = 0; e85gOx8x < a8SpzV2U; e85gOx8x++) {
				if (!statustext) {
					IJ.log(YftTJodo[e85gOx8x] + " / " + M1YyTxV7[e85gOx8x]);
				} else {
					IJ.log(cp8mCnjY + YftTJodo[e85gOx8x]);
				}
			}
		}
		if (open_as_stack || only_images) {
			boolean EedYFW0D = false;
			while (!EedYFW0D) {
				EedYFW0D = true;
				for (int MZMS3kv9 = 0; MZMS3kv9 < a8SpzV2U - 1; MZMS3kv9++) {
					if (M1YyTxV7[MZMS3kv9] > M1YyTxV7[MZMS3kv9 + 1]) {
						long Z8719Q9c = M1YyTxV7[MZMS3kv9];
						tempp = YftTJodo[MZMS3kv9];
						M1YyTxV7[MZMS3kv9] = M1YyTxV7[MZMS3kv9 + 1];
						YftTJodo[MZMS3kv9] = YftTJodo[MZMS3kv9 + 1];
						M1YyTxV7[MZMS3kv9 + 1] = Z8719Q9c;
						YftTJodo[MZMS3kv9 + 1] = tempp;
						EedYFW0D = false;
					}
				}
			}
			if (only_images) {
				Opener g2A01qiN = new Opener();
				int VmCZqxuj = 0;
				IJ.log(" ");
				for (int arHWx5tE = 0; arHWx5tE < a8SpzV2U; arHWx5tE++) {
					String DI1DTLof = (cp8mCnjY + YftTJodo[arHWx5tE]);
					if (DI1DTLof == null)
						break;
					else {
						ImagePlus R1Oxr0wL = g2A01qiN.openImage(DI1DTLof);
						VmCZqxuj++;
						if (R1Oxr0wL != null) {
							IJ.log(VmCZqxuj + " + " + DI1DTLof);
							R1Oxr0wL.show();
						} else
							IJ.log(VmCZqxuj + " - " + DI1DTLof);
					}
				}
				return;
			}
			int mdy3ozBm = 0, nb4yqIOL = 0, AsTDPRvg = 0;
			ImageStack OTwXG5s4 = null;
			double Y78tNdHG = Double.MAX_VALUE;
			double l1yK7NkJ = -Double.MAX_VALUE;
			int vSHPNmq8 = 0;
			try {
				for (int XjLcYend = 0; XjLcYend < a8SpzV2U; XjLcYend++) {
					String cpAldoYS = (cp8mCnjY + YftTJodo[XjLcYend]);
					if (cpAldoYS == null)
						break;
					if (YftTJodo[XjLcYend].endsWith(".txt"))
						continue;
					ImagePlus YBWtQuts = new Opener().openImage(cpAldoYS);
					if (YBWtQuts != null && OTwXG5s4 == null) {
						mdy3ozBm = YBWtQuts.getWidth();
						nb4yqIOL = YBWtQuts.getHeight();
						AsTDPRvg = YBWtQuts.getType();
						ColorModel my2M9Ozo = YBWtQuts.getProcessor().getColorModel();
						if (halfSize)
							OTwXG5s4 = new ImageStack(mdy3ozBm / 2, nb4yqIOL / 2, my2M9Ozo);
						else
							OTwXG5s4 = new ImageStack(mdy3ozBm, nb4yqIOL, my2M9Ozo);
					}
					if (OTwXG5s4 != null)
						vSHPNmq8 = OTwXG5s4.getSize() + 1;
					IJ.showStatus(vSHPNmq8 + "/" + a8SpzV2U);
					IJ.showProgress((double) vSHPNmq8 / a8SpzV2U);
					if (YBWtQuts == null)
						IJ.log(YftTJodo[XjLcYend] + ": unable to open");
					else if (YBWtQuts.getWidth() != mdy3ozBm || YBWtQuts.getHeight() != nb4yqIOL)
						IJ.log(YftTJodo[XjLcYend] + ": wrong dimensions");
					else if (YBWtQuts.getType() != AsTDPRvg)
						IJ.log(YftTJodo[XjLcYend] + ": wrong type");
					else {
						ImageProcessor dn7EVux3 = YBWtQuts.getProcessor();
						if (grayscale)
							dn7EVux3 = dn7EVux3.convertToByte(true);
						if (halfSize)
							dn7EVux3 = dn7EVux3.resize(mdy3ozBm / 2, nb4yqIOL / 2);
						if (dn7EVux3.getMin() < Y78tNdHG)
							Y78tNdHG = dn7EVux3.getMin();
						if (dn7EVux3.getMax() > l1yK7NkJ)
							l1yK7NkJ = dn7EVux3.getMax();
						String H6nM6WD1 = YBWtQuts.getTitle();
						String ed5bPG8n = (String) YBWtQuts.getProperty("Info");
						if (ed5bPG8n != null)
							H6nM6WD1 += "\n" + ed5bPG8n;
						OTwXG5s4.addSlice(H6nM6WD1, dn7EVux3);
					}
					System.gc();
				}
			} catch (OutOfMemoryError aXD1ta7i) {
				IJ.outOfMemory("FolderOpener");
				OTwXG5s4.trim();
			}
			if (OTwXG5s4 != null && OTwXG5s4.getSize() > 0) {
				ImagePlus hgvw2Nt2 = new ImagePlus("Stack", OTwXG5s4);
				if (hgvw2Nt2.getType() == ImagePlus.GRAY16 || hgvw2Nt2.getType() == ImagePlus.GRAY32)
					hgvw2Nt2.getProcessor().setMinAndMax(Y78tNdHG, l1yK7NkJ);
				hgvw2Nt2.show();
			}
			IJ.showProgress(1.0);
		}
	}

}