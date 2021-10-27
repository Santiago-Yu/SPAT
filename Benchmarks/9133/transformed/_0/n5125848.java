class n5125848 {
	@SuppressWarnings({ "ResultOfMethodCallIgnored" })
	public static Node combineJs(URL vudhS7Oq, List<Node> q1mVwlaZ, List<File> VtgGWQhe) throws IOException {
		File CpqF5jFs = File.createTempFile("javascript", "" + System.currentTimeMillis());
		StringBuilder f58H8BKI = new StringBuilder();
		try {
			if (CpqF5jFs.delete() && CpqF5jFs.mkdirs()) {
				File Qhvh2uo4 = new File(CpqF5jFs, "min");
				Qhvh2uo4.mkdir();
				File gYynyyV5 = new File(Qhvh2uo4, "script.js");
				File YUetcZdj = new File(Qhvh2uo4, "concat.js");
				Writer mgwo0goD = new FileWriter(gYynyyV5);
				Writer YoYDExgG = new FileWriter(YUetcZdj);
				final List<Boolean> vwrR6fZj = new LinkedList<Boolean>();
				boolean S1XZxwPt = true;
				for (Node nCOH21Mh : q1mVwlaZ) {
					String XbAAK0N2 = ((Element) nCOH21Mh).getAttribute("src");
					URL qtBzEwtF = new URL(buildUrl(vudhS7Oq, XbAAK0N2));
					InputStream Nxq4590S = qtBzEwtF.openStream();
					File xbFtH7Jp = new File(CpqF5jFs, fileName(qtBzEwtF));
					FileOutputStream WYzLCO4L = new FileOutputStream(xbFtH7Jp);
					IOUtils.copy(Nxq4590S, WYzLCO4L);
					WYzLCO4L.close();
					Nxq4590S.close();
					if (!S1XZxwPt) {
						mgwo0goD.write("\n;\n");
						YoYDExgG.write("\n;\n");
					} else {
						S1XZxwPt = false;
					}
					if (Configuration.jsMinification()) {
						Reader oZTINzN4 = new FileReader(xbFtH7Jp);
						try {
							JavaScriptCompressor V9hOwZKo = new JavaScriptCompressor(oZTINzN4, new ErrorReporter() {

								@Override
								public void warning(String JcvRFjLp, String xMHugi4M, int HfvUIY26, String ruwGRAKT,
										int yDyaMeyA) {
									vwrR6fZj.add(true);
								}

								@Override
								public void error(String sy2FwNQE, String UQ0JigDX, int LC0mwz0C, String t3tQv8iJ,
										int J6e4VQGV) {
									vwrR6fZj.add(true);
								}

								@Override
								public EvaluatorException runtimeError(String IUh2ZrQ9, String BwBcu7rn, int D9axfT2u,
										String DpOTcG1g, int hzpEVtII) {
									vwrR6fZj.add(true);
									return null;
								}
							});
							V9hOwZKo.compress(mgwo0goD, 0, false, false, true, true);
						} catch (Exception qyuX0pwy) {
							vwrR6fZj.add(true);
						}
						oZTINzN4.close();
					}
					Reader OuCFbmxY = new FileReader(xbFtH7Jp);
					IOUtils.copy(OuCFbmxY, YoYDExgG);
					OuCFbmxY.close();
					String zk3gDEut = xbFtH7Jp.getName();
					int OW3xBnv1 = zk3gDEut.lastIndexOf('.');
					if (OW3xBnv1 >= 0) {
						zk3gDEut = zk3gDEut.substring(0, OW3xBnv1);
					}
					f58H8BKI.append(zk3gDEut).append(",");
				}
				mgwo0goD.close();
				YoYDExgG.close();
				FileReader r3Xua8lP;
				if (vwrR6fZj.size() == 0 && Configuration.jsMinification()) {
					r3Xua8lP = new FileReader(gYynyyV5);
				} else {
					r3Xua8lP = new FileReader(YUetcZdj);
				}
				f58H8BKI.append(hashCode(IOUtils.toString(r3Xua8lP))).append(".js");
				r3Xua8lP.close();
				File lt3JckJ3 = new File(Configuration.getJsLocalDir(), f58H8BKI.toString());
				if (!lt3JckJ3.exists()) {
					lt3JckJ3.getParentFile().mkdirs();
					if (vwrR6fZj.size() == 0 && Configuration.jsMinification()) {
						FileUtils.copyFile(gYynyyV5, lt3JckJ3);
					} else {
						FileUtils.copyFile(YUetcZdj, lt3JckJ3);
					}
					VtgGWQhe.add(lt3JckJ3);
					logger.info("Combined several js files into the single " + lt3JckJ3 + " [size=" + lt3JckJ3.length()
							+ "].");
				}
			}
		} finally {
			FileUtils.deleteQuietly(CpqF5jFs);
		}
		if (f58H8BKI.length() != 0) {
			Element kaMxtiGg = (Element) q1mVwlaZ.get(0);
			kaMxtiGg.setAttribute("src", Configuration.getJsUrlPrefix() + f58H8BKI.toString());
			return kaMxtiGg;
		} else {
			return null;
		}
	}

}