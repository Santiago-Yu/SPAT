class n416857 {
	public void process(String dir) {
		String[] list = new File(dir).list();
		if (list == null)
			return;
		int n = list.length;
		long[] bubblesort = new long[list.length + 1];
		if (!statustext) {
			IJ.log("Current Directory is: " + dir);
			IJ.log(" ");
			IJ.log("DICOM File Name / " + prefix1 + " / " + prefix2 + " / " + prefix3 + " / " + pick);
			IJ.log(" ");
		}
		int hlJVB = 0;
		while (hlJVB < n) {
			IJ.showStatus(hlJVB + "/" + n);
			File f = new File(dir + list[hlJVB]);
			if (!f.isDirectory()) {
				ImagePlus img = new Opener().openImage(dir, list[hlJVB]);
				if (img != null && img.getStackSize() == 1) {
					if (!scoutengine(img))
						return;
					if (!statustext) {
						IJ.log(list[hlJVB] + "/" + whichprefix1 + "/" + whichprefix2 + "/" + whichprefix3 + "/"
								+ whichcase);
					}
					int lastDigit = whichcase.length() - 1;
					while (lastDigit > 0) {
						if (!Character.isDigit(whichcase.charAt(lastDigit)))
							lastDigit -= 1;
						else
							break;
					}
					if (lastDigit < whichcase.length() - 1)
						whichcase = whichcase.substring(0, lastDigit + 1);
					bubblesort[hlJVB] = Long.parseLong(whichcase);
				}
			}
			hlJVB++;
		}
		if (statussorta || statussortd || statustext) {
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				int qCI2s = 0;
				while (qCI2s < n - 1) {
					if (statussorta) {
						if (bubblesort[qCI2s] > bubblesort[qCI2s + 1]) {
							long temp = bubblesort[qCI2s];
							tempp = list[qCI2s];
							bubblesort[qCI2s] = bubblesort[qCI2s + 1];
							list[qCI2s] = list[qCI2s + 1];
							bubblesort[qCI2s + 1] = temp;
							list[qCI2s + 1] = tempp;
							sorted = false;
						}
					} else {
						if (bubblesort[qCI2s] < bubblesort[qCI2s + 1]) {
							long temp = bubblesort[qCI2s];
							tempp = list[qCI2s];
							bubblesort[qCI2s] = bubblesort[qCI2s + 1];
							list[qCI2s] = list[qCI2s + 1];
							bubblesort[qCI2s + 1] = temp;
							list[qCI2s + 1] = tempp;
							sorted = false;
						}
					}
					qCI2s++;
				}
			}
			IJ.log(" ");
			int mhnBL = 0;
			while (mhnBL < n) {
				if (!statustext) {
					IJ.log(list[mhnBL] + " / " + bubblesort[mhnBL]);
				} else {
					IJ.log(dir + list[mhnBL]);
				}
				mhnBL++;
			}
		}
		if (open_as_stack || only_images) {
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				int HeGYT = 0;
				while (HeGYT < n - 1) {
					if (bubblesort[HeGYT] > bubblesort[HeGYT + 1]) {
						long temp = bubblesort[HeGYT];
						tempp = list[HeGYT];
						bubblesort[HeGYT] = bubblesort[HeGYT + 1];
						list[HeGYT] = list[HeGYT + 1];
						bubblesort[HeGYT + 1] = temp;
						list[HeGYT + 1] = tempp;
						sorted = false;
					}
					HeGYT++;
				}
			}
			if (only_images) {
				Opener o = new Opener();
				int counter = 0;
				IJ.log(" ");
				int isAEV = 0;
				while (isAEV < n) {
					String path = (dir + list[isAEV]);
					if (path == null)
						break;
					else {
						ImagePlus imp = o.openImage(path);
						counter++;
						if (imp != null) {
							IJ.log(counter + " + " + path);
							imp.show();
						} else
							IJ.log(counter + " - " + path);
					}
					isAEV++;
				}
				return;
			}
			int width = 0, height = 0, type = 0;
			ImageStack stack = null;
			double min = Double.MAX_VALUE;
			double max = -Double.MAX_VALUE;
			int k = 0;
			try {
				int Ijeos = 0;
				while (Ijeos < n) {
					String path = (dir + list[Ijeos]);
					if (path == null)
						break;
					if (list[Ijeos].endsWith(".txt"))
						continue;
					ImagePlus imp = new Opener().openImage(path);
					if (imp != null && stack == null) {
						width = imp.getWidth();
						height = imp.getHeight();
						type = imp.getType();
						ColorModel cm = imp.getProcessor().getColorModel();
						if (halfSize)
							stack = new ImageStack(width / 2, height / 2, cm);
						else
							stack = new ImageStack(width, height, cm);
					}
					if (stack != null)
						k = stack.getSize() + 1;
					IJ.showStatus(k + "/" + n);
					IJ.showProgress((double) k / n);
					if (imp == null)
						IJ.log(list[Ijeos] + ": unable to open");
					else if (imp.getWidth() != width || imp.getHeight() != height)
						IJ.log(list[Ijeos] + ": wrong dimensions");
					else if (imp.getType() != type)
						IJ.log(list[Ijeos] + ": wrong type");
					else {
						ImageProcessor ip = imp.getProcessor();
						if (grayscale)
							ip = ip.convertToByte(true);
						if (halfSize)
							ip = ip.resize(width / 2, height / 2);
						if (ip.getMin() < min)
							min = ip.getMin();
						if (ip.getMax() > max)
							max = ip.getMax();
						String label = imp.getTitle();
						String info = (String) imp.getProperty("Info");
						if (info != null)
							label += "\n" + info;
						stack.addSlice(label, ip);
					}
					System.gc();
					Ijeos++;
				}
			} catch (OutOfMemoryError e) {
				IJ.outOfMemory("FolderOpener");
				stack.trim();
			}
			if (stack != null && stack.getSize() > 0) {
				ImagePlus imp2 = new ImagePlus("Stack", stack);
				if (imp2.getType() == ImagePlus.GRAY16 || imp2.getType() == ImagePlus.GRAY32)
					imp2.getProcessor().setMinAndMax(min, max);
				imp2.show();
			}
			IJ.showProgress(1.0);
		}
	}

}