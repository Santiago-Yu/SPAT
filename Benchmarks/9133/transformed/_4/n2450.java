class n2450 {
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
		for (int i = 0; i < n; i++) {
			IJ.showStatus(i + "/" + n);
			File f = new File(dir + list[i]);
			if (!f.isDirectory()) {
				ImagePlus img = new Opener().openImage(dir, list[i]);
				if (img != null && img.getStackSize() == 1) {
					if (!scoutengine(img))
						return;
					if (!statustext) {
						IJ.log(list[i] + "/" + whichprefix1 + "/" + whichprefix2 + "/" + whichprefix3 + "/"
								+ whichcase);
					}
					int lastDigit = whichcase.length() - 1;
					while (lastDigit > 0) {
						if (!Character.isDigit(whichcase.charAt(lastDigit)))
							lastDigit -= 1;
						else
							break;
					}
					whichcase = (lastDigit < whichcase.length() - 1) ? whichcase.substring(0, lastDigit + 1)
							: whichcase;
					bubblesort[i] = Long.parseLong(whichcase);
				}
			}
		}
		if (statussorta || statussortd || statustext) {
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				for (int i = 0; i < n - 1; i++) {
					if (statussorta) {
						if (bubblesort[i] > bubblesort[i + 1]) {
							long temp = bubblesort[i];
							tempp = list[i];
							bubblesort[i] = bubblesort[i + 1];
							list[i] = list[i + 1];
							bubblesort[i + 1] = temp;
							list[i + 1] = tempp;
							sorted = false;
						}
					} else {
						if (bubblesort[i] < bubblesort[i + 1]) {
							long temp = bubblesort[i];
							tempp = list[i];
							bubblesort[i] = bubblesort[i + 1];
							list[i] = list[i + 1];
							bubblesort[i + 1] = temp;
							list[i + 1] = tempp;
							sorted = false;
						}
					}
				}
			}
			IJ.log(" ");
			for (int i = 0; i < n; i++) {
				if (!statustext) {
					IJ.log(list[i] + " / " + bubblesort[i]);
				} else {
					IJ.log(dir + list[i]);
				}
			}
		}
		if (open_as_stack || only_images) {
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				for (int i = 0; i < n - 1; i++) {
					if (bubblesort[i] > bubblesort[i + 1]) {
						long temp = bubblesort[i];
						tempp = list[i];
						bubblesort[i] = bubblesort[i + 1];
						list[i] = list[i + 1];
						bubblesort[i + 1] = temp;
						list[i + 1] = tempp;
						sorted = false;
					}
				}
			}
			if (only_images) {
				Opener o = new Opener();
				int counter = 0;
				IJ.log(" ");
				for (int i = 0; i < n; i++) {
					String path = (dir + list[i]);
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
				}
				return;
			}
			int width = 0, height = 0, type = 0;
			ImageStack stack = null;
			double min = Double.MAX_VALUE;
			double max = -Double.MAX_VALUE;
			int k = 0;
			try {
				for (int i = 0; i < n; i++) {
					String path = (dir + list[i]);
					if (path == null)
						break;
					if (list[i].endsWith(".txt"))
						continue;
					ImagePlus imp = new Opener().openImage(path);
					if (imp != null && stack == null) {
						width = imp.getWidth();
						height = imp.getHeight();
						type = imp.getType();
						ColorModel cm = imp.getProcessor().getColorModel();
						stack = (halfSize) ? new ImageStack(width / 2, height / 2, cm)
								: new ImageStack(width, height, cm);
					}
					k = (stack != null) ? stack.getSize() + 1 : k;
					IJ.showStatus(k + "/" + n);
					IJ.showProgress((double) k / n);
					if (imp == null)
						IJ.log(list[i] + ": unable to open");
					else if (imp.getWidth() != width || imp.getHeight() != height)
						IJ.log(list[i] + ": wrong dimensions");
					else if (imp.getType() != type)
						IJ.log(list[i] + ": wrong type");
					else {
						ImageProcessor ip = imp.getProcessor();
						ip = (grayscale) ? ip.convertToByte(true) : ip;
						ip = (halfSize) ? ip.resize(width / 2, height / 2) : ip;
						min = (ip.getMin() < min) ? ip.getMin() : min;
						max = (ip.getMax() > max) ? ip.getMax() : max;
						String label = imp.getTitle();
						String info = (String) imp.getProperty("Info");
						label = (info != null) ? "\n" + info : label;
						stack.addSlice(label, ip);
					}
					System.gc();
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