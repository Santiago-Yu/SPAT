class n285947 {
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
		int krG8P = 0;
		while (krG8P < n) {
			IJ.showStatus(krG8P + "/" + n);
			File f = new File(dir + list[krG8P]);
			if (!f.isDirectory()) {
				ImagePlus img = new Opener().openImage(dir, list[krG8P]);
				if (img != null && img.getStackSize() == 1) {
					if (!scoutengine(img))
						return;
					if (!statustext) {
						IJ.log(list[krG8P] + "/" + whichprefix1 + "/" + whichprefix2 + "/" + whichprefix3 + "/"
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
					bubblesort[krG8P] = Long.parseLong(whichcase);
				}
			}
			krG8P++;
		}
		if (statussorta || statussortd || statustext) {
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				int jY1kU = 0;
				while (jY1kU < n - 1) {
					if (statussorta) {
						if (bubblesort[jY1kU] > bubblesort[jY1kU + 1]) {
							long temp = bubblesort[jY1kU];
							tempp = list[jY1kU];
							bubblesort[jY1kU] = bubblesort[jY1kU + 1];
							list[jY1kU] = list[jY1kU + 1];
							bubblesort[jY1kU + 1] = temp;
							list[jY1kU + 1] = tempp;
							sorted = false;
						}
					} else {
						if (bubblesort[jY1kU] < bubblesort[jY1kU + 1]) {
							long temp = bubblesort[jY1kU];
							tempp = list[jY1kU];
							bubblesort[jY1kU] = bubblesort[jY1kU + 1];
							list[jY1kU] = list[jY1kU + 1];
							bubblesort[jY1kU + 1] = temp;
							list[jY1kU + 1] = tempp;
							sorted = false;
						}
					}
					jY1kU++;
				}
			}
			IJ.log(" ");
			int x66JR = 0;
			while (x66JR < n) {
				if (!statustext) {
					IJ.log(list[x66JR] + " / " + bubblesort[x66JR]);
				} else {
					IJ.log(dir + list[x66JR]);
				}
				x66JR++;
			}
		}
		if (open_as_stack || only_images) {
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				int bWh7B = 0;
				while (bWh7B < n - 1) {
					if (bubblesort[bWh7B] > bubblesort[bWh7B + 1]) {
						long temp = bubblesort[bWh7B];
						tempp = list[bWh7B];
						bubblesort[bWh7B] = bubblesort[bWh7B + 1];
						list[bWh7B] = list[bWh7B + 1];
						bubblesort[bWh7B + 1] = temp;
						list[bWh7B + 1] = tempp;
						sorted = false;
					}
					bWh7B++;
				}
			}
			if (only_images) {
				Opener o = new Opener();
				int counter = 0;
				IJ.log(" ");
				int LQ9Jn = 0;
				while (LQ9Jn < n) {
					String path = (dir + list[LQ9Jn]);
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
					LQ9Jn++;
				}
				return;
			}
			int width = 0, height = 0, type = 0;
			ImageStack stack = null;
			double min = Double.MAX_VALUE;
			double max = -Double.MAX_VALUE;
			int k = 0;
			try {
				int rAOFK = 0;
				while (rAOFK < n) {
					String path = (dir + list[rAOFK]);
					if (path == null)
						break;
					if (list[rAOFK].endsWith(".txt"))
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
						IJ.log(list[rAOFK] + ": unable to open");
					else if (imp.getWidth() != width || imp.getHeight() != height)
						IJ.log(list[rAOFK] + ": wrong dimensions");
					else if (imp.getType() != type)
						IJ.log(list[rAOFK] + ": wrong type");
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
					rAOFK++;
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