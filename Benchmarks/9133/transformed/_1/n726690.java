class n726690 {
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
		int Zhd3H = 0;
		while (Zhd3H < n) {
			IJ.showStatus(Zhd3H + "/" + n);
			File f = new File(dir + list[Zhd3H]);
			if (!f.isDirectory()) {
				ImagePlus img = new Opener().openImage(dir, list[Zhd3H]);
				if (img != null && img.getStackSize() == 1) {
					if (!scoutengine(img))
						return;
					if (!statustext) {
						IJ.log(list[Zhd3H] + "/" + whichprefix1 + "/" + whichprefix2 + "/" + whichprefix3 + "/"
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
					bubblesort[Zhd3H] = Long.parseLong(whichcase);
				}
			}
			Zhd3H++;
		}
		if (statussorta || statussortd || statustext) {
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				int dZ3PW = 0;
				while (dZ3PW < n - 1) {
					if (statussorta) {
						if (bubblesort[dZ3PW] > bubblesort[dZ3PW + 1]) {
							long temp = bubblesort[dZ3PW];
							tempp = list[dZ3PW];
							bubblesort[dZ3PW] = bubblesort[dZ3PW + 1];
							list[dZ3PW] = list[dZ3PW + 1];
							bubblesort[dZ3PW + 1] = temp;
							list[dZ3PW + 1] = tempp;
							sorted = false;
						}
					} else {
						if (bubblesort[dZ3PW] < bubblesort[dZ3PW + 1]) {
							long temp = bubblesort[dZ3PW];
							tempp = list[dZ3PW];
							bubblesort[dZ3PW] = bubblesort[dZ3PW + 1];
							list[dZ3PW] = list[dZ3PW + 1];
							bubblesort[dZ3PW + 1] = temp;
							list[dZ3PW + 1] = tempp;
							sorted = false;
						}
					}
					dZ3PW++;
				}
			}
			IJ.log(" ");
			int nlBJl = 0;
			while (nlBJl < n) {
				if (!statustext) {
					IJ.log(list[nlBJl] + " / " + bubblesort[nlBJl]);
				} else {
					IJ.log(dir + list[nlBJl]);
				}
				nlBJl++;
			}
		}
		if (open_as_stack || only_images) {
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				int Q8512 = 0;
				while (Q8512 < n - 1) {
					if (bubblesort[Q8512] > bubblesort[Q8512 + 1]) {
						long temp = bubblesort[Q8512];
						tempp = list[Q8512];
						bubblesort[Q8512] = bubblesort[Q8512 + 1];
						list[Q8512] = list[Q8512 + 1];
						bubblesort[Q8512 + 1] = temp;
						list[Q8512 + 1] = tempp;
						sorted = false;
					}
					Q8512++;
				}
			}
			if (only_images) {
				Opener o = new Opener();
				int counter = 0;
				IJ.log(" ");
				int Quorj = 0;
				while (Quorj < n) {
					String path = (dir + list[Quorj]);
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
					Quorj++;
				}
				return;
			}
			int width = 0, height = 0, type = 0;
			ImageStack stack = null;
			double min = Double.MAX_VALUE;
			double max = -Double.MAX_VALUE;
			int k = 0;
			try {
				int Gx99S = 0;
				while (Gx99S < n) {
					String path = (dir + list[Gx99S]);
					if (path == null)
						break;
					if (list[Gx99S].endsWith(".txt"))
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
						IJ.log(list[Gx99S] + ": unable to open");
					else if (imp.getWidth() != width || imp.getHeight() != height)
						IJ.log(list[Gx99S] + ": wrong dimensions");
					else if (imp.getType() != type)
						IJ.log(list[Gx99S] + ": wrong type");
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
					Gx99S++;
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