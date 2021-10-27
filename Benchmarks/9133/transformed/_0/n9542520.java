class n9542520 {
	@SuppressWarnings("static-access")
	public void run() {
		while (true) {
			try {
				thisThread.sleep(10000);
			} catch (InterruptedException dLvIwAdV) {
				System.out.print("no connection");
			}
			++i;
			umat.flush();
			umat = null;
			try {
				base = getDocumentBase();
				username = getParameter("username");
			} catch (Exception dbXk50TS) {
			}
			String WyB1QOpG = "data/" + username + "_l.cod";
			URL AUazUC7M = null;
			try {
				AUazUC7M = new URL(base, WyB1QOpG);
			} catch (MalformedURLException hKXyLEDR) {
			}
			InputStream FypWC5DY = null;
			try {
				FypWC5DY = AUazUC7M.openStream();
			} catch (IOException ae75d2cv) {
			}
			BufferedReader r0qAHYml = null;
			try {
				r0qAHYml = new BufferedReader(new InputStreamReader(FypWC5DY));
			} catch (Exception A4EgjnZX) {
			}
			try {
				String LFfbmhKY = r0qAHYml.readLine();
				StringTokenizer UckCRVGI = new StringTokenizer(LFfbmhKY, " ");
				int QC6pgnR9 = Integer.parseInt(UckCRVGI.nextToken().trim().toLowerCase());
				this.topol = UckCRVGI.nextToken().trim().toLowerCase();
				xunit = Integer.parseInt(UckCRVGI.nextToken().trim().toLowerCase());
				yunit = Integer.parseInt(UckCRVGI.nextToken().trim().toLowerCase());
				@SuppressWarnings("unused")
				String Rp1hCOxf = UckCRVGI.nextToken().trim().toLowerCase();
				String y4gaCJ7Z = null;
				labels = new String[xunit][yunit];
				for (int AZZoLEW3 = 0; AZZoLEW3 < yunit; AZZoLEW3++) {
					for (int zt4yN6wQ = 0; zt4yN6wQ < xunit; zt4yN6wQ++) {
						LFfbmhKY = r0qAHYml.readLine();
						StringTokenizer cNTuoSce = new StringTokenizer(LFfbmhKY, " ");
						for (int knplcD0m = 0; knplcD0m < QC6pgnR9; knplcD0m++) {
							if (cNTuoSce.countTokens() > 0)
								cNTuoSce.nextToken();
						}
						while (cNTuoSce.countTokens() > 0) {
							y4gaCJ7Z = cNTuoSce.nextToken() + " ";
						}
						if (y4gaCJ7Z == null) {
							labels[zt4yN6wQ][AZZoLEW3] = "none";
						} else {
							labels[zt4yN6wQ][AZZoLEW3] = y4gaCJ7Z;
						}
						y4gaCJ7Z = null;
					}
				}
				r0qAHYml.close();
				if (topol.equals("hexa")) {
					xposit = new int[xunit][yunit];
					yposit = new int[xunit][yunit];
					double y29vS5o6 = xunit;
					double jwkVSjzg = yunit;
					for (int mOwcvyjt = 0; mOwcvyjt < xunit; mOwcvyjt++) {
						for (int f66Okbhf = 0; f66Okbhf < yunit; f66Okbhf++) {
							if (f66Okbhf % 2 == 0) {
								double HDVEJVY1 = (mOwcvyjt * width);
								xposit[mOwcvyjt][f66Okbhf] = (int) Math.round(HDVEJVY1 / y29vS5o6);
							}
							if (f66Okbhf % 2 != 0) {
								double WSG9R3ek = (width * 0.5) + (mOwcvyjt * width);
								xposit[mOwcvyjt][f66Okbhf] = (int) Math.round(WSG9R3ek / y29vS5o6);
							}
							yposit[mOwcvyjt][f66Okbhf] = (int) Math
									.round(((height * 0.5) + f66Okbhf * height) / jwkVSjzg);
						}
					}
				}
				if (topol.equals("rect")) {
					xposit = new int[xunit][yunit];
					yposit = new int[xunit][yunit];
					double RskV2TUA = xunit;
					double DNHet2uG = yunit;
					for (int kdR137sK = 0; kdR137sK < xunit; kdR137sK++) {
						for (int ZtIYWAxi = 0; ZtIYWAxi < yunit; ZtIYWAxi++) {
							double s2ZTe0PU = (width * 0.5) + (kdR137sK * width);
							xposit[kdR137sK][ZtIYWAxi] = (int) Math.round((s2ZTe0PU / RskV2TUA));
							yposit[kdR137sK][ZtIYWAxi] = (int) Math
									.round(((height * 0.5) + ZtIYWAxi * height) / DNHet2uG);
						}
					}
				}
			} catch (IOException Id6I3ll9) {
			}
			String IAqeXFaS = "images/" + username + ".png";
			mt.removeImage(umat);
			umat = getImage(base, IAqeXFaS);
			mt.addImage(umat, 0);
			try {
				mt.waitForID(0);
			} catch (InterruptedException X0xTMtuS) {
				showStatus("Interrupted");
			}
			repaint();
		}
	}

}