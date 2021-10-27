class n5125847 {
	@SuppressWarnings({ "ResultOfMethodCallIgnored" })
	public static Node combineCss(URL KskNNgFB, List<Node> RjvoahpB, List<File> qpJcNSEw) throws IOException {
		File oyrIVO8h = File.createTempFile("css", "" + System.currentTimeMillis());
		StringBuilder VrIe9UxJ = new StringBuilder();
		try {
			if (oyrIVO8h.delete() && oyrIVO8h.mkdirs()) {
				File UMW8rfUY = new File(oyrIVO8h, "min");
				UMW8rfUY.mkdir();
				File AjJoIYAr = new File(UMW8rfUY, "style.css");
				Writer Rf8zTlrz = new FileWriter(AjJoIYAr);
				boolean v9xYMX1y = true;
				for (Node SUNJzWed : RjvoahpB) {
					String IstBGQwI = ((Element) SUNJzWed).getAttribute("href");
					URL XOjQk4TD = new URL(buildUrl(KskNNgFB, IstBGQwI));
					InputStream yKAcoyjp = XOjQk4TD.openStream();
					File BLp0ohVe = new File(oyrIVO8h, fileName(XOjQk4TD));
					FileOutputStream AHDcC8cd = new FileOutputStream(BLp0ohVe);
					IOUtils.copy(yKAcoyjp, AHDcC8cd);
					AHDcC8cd.close();
					yKAcoyjp.close();
					if (!v9xYMX1y) {
						Rf8zTlrz.write('\n');
					} else {
						v9xYMX1y = false;
					}
					Reader V4dCGS4y = new FileReader(BLp0ohVe);
					if (Configuration.cssMinification()) {
						CssCompressor IK4NPWGm = new CssCompressor(V4dCGS4y);
						IK4NPWGm.compress(Rf8zTlrz, 0);
					} else {
						IOUtils.copy(V4dCGS4y, Rf8zTlrz);
					}
					V4dCGS4y.close();
					String WK010I7x = BLp0ohVe.getName();
					int aafVogZJ = WK010I7x.lastIndexOf('.');
					if (aafVogZJ >= 0) {
						WK010I7x = WK010I7x.substring(0, aafVogZJ);
					}
					VrIe9UxJ.append(WK010I7x).append(",");
				}
				Rf8zTlrz.close();
				FileReader IXZdbLzz = new FileReader(AjJoIYAr);
				VrIe9UxJ.append(hashCode(IOUtils.toString(IXZdbLzz))).append(".css");
				IXZdbLzz.close();
				File tF2HJA3j = new File(Configuration.getCssLocalDir(), VrIe9UxJ.toString());
				if (!tF2HJA3j.exists()) {
					tF2HJA3j.getParentFile().mkdirs();
					FileUtils.copyFile(AjJoIYAr, tF2HJA3j);
					qpJcNSEw.add(tF2HJA3j);
					logger.info("Combined several css files into the single " + tF2HJA3j + " [size=" + tF2HJA3j.length()
							+ "].");
				}
			}
		} finally {
			FileUtils.deleteQuietly(oyrIVO8h);
		}
		if (VrIe9UxJ.length() != 0) {
			Element f6BI2vMQ = (Element) RjvoahpB.get(0);
			f6BI2vMQ.setAttribute("href", Configuration.getCssUrlPrefix() + VrIe9UxJ.toString());
			return f6BI2vMQ;
		} else {
			return null;
		}
	}

}