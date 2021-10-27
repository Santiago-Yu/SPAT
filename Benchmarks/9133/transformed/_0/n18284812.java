class n18284812 {
	protected void discoverRegistryEntries() {
		DataSourceRegistry KyDohZPh = this;
		try {
			ClassLoader MV5pEbtA = DataSetURI.class.getClassLoader();
			Enumeration<URL> G5tPovJP;
			if (MV5pEbtA == null) {
				G5tPovJP = ClassLoader.getSystemResources("META-INF/org.virbo.datasource.DataSourceFactory.extensions");
			} else {
				G5tPovJP = MV5pEbtA.getResources("META-INF/org.virbo.datasource.DataSourceFactory.extensions");
			}
			while (G5tPovJP.hasMoreElements()) {
				URL mJn6cepC = G5tPovJP.nextElement();
				BufferedReader YQB56Aqp = new BufferedReader(new InputStreamReader(mJn6cepC.openStream()));
				String AkAen3nG = YQB56Aqp.readLine();
				while (AkAen3nG != null) {
					AkAen3nG = AkAen3nG.trim();
					if (AkAen3nG.length() > 0) {
						String[] cTCsdVap = AkAen3nG.split("\\s");
						for (int LPW2dm3u = 1; LPW2dm3u < cTCsdVap.length; LPW2dm3u++) {
							if (cTCsdVap[LPW2dm3u].contains(".")) {
								System.err.println(
										"META-INF/org.virbo.datasource.DataSourceFactory.extensions contains extension that contains period: ");
								System.err.println(cTCsdVap[0] + " " + cTCsdVap[LPW2dm3u] + " in " + mJn6cepC);
								System.err.println(
										"This sometimes happens when extension files are concatenated, so check that all are terminated by end-of-line");
								System.err.println("");
								throw new IllegalArgumentException(
										"DataSourceFactory.extensions contains extension that contains period: "
												+ mJn6cepC);
							}
							KyDohZPh.registerExtension(cTCsdVap[0], cTCsdVap[LPW2dm3u], null);
						}
					}
					AkAen3nG = YQB56Aqp.readLine();
				}
				YQB56Aqp.close();
			}
			if (MV5pEbtA == null) {
				G5tPovJP = ClassLoader.getSystemResources("META-INF/org.virbo.datasource.DataSourceFactory.mimeTypes");
			} else {
				G5tPovJP = MV5pEbtA.getResources("META-INF/org.virbo.datasource.DataSourceFactory.mimeTypes");
			}
			while (G5tPovJP.hasMoreElements()) {
				URL gr4NdrEu = G5tPovJP.nextElement();
				BufferedReader M2D7BLZc = new BufferedReader(new InputStreamReader(gr4NdrEu.openStream()));
				String brYmRNc8 = M2D7BLZc.readLine();
				while (brYmRNc8 != null) {
					brYmRNc8 = brYmRNc8.trim();
					if (brYmRNc8.length() > 0) {
						String[] sBo5qKTJ = brYmRNc8.split("\\s");
						for (int jpmG7AVx = 1; jpmG7AVx < sBo5qKTJ.length; jpmG7AVx++) {
							KyDohZPh.registerMimeType(sBo5qKTJ[0], sBo5qKTJ[jpmG7AVx]);
						}
					}
					brYmRNc8 = M2D7BLZc.readLine();
				}
				M2D7BLZc.close();
			}
			if (MV5pEbtA == null) {
				G5tPovJP = ClassLoader.getSystemResources("META-INF/org.virbo.datasource.DataSourceFormat.extensions");
			} else {
				G5tPovJP = MV5pEbtA.getResources("META-INF/org.virbo.datasource.DataSourceFormat.extensions");
			}
			while (G5tPovJP.hasMoreElements()) {
				URL Wsx7G0DI = G5tPovJP.nextElement();
				BufferedReader iK3Fg4iR = new BufferedReader(new InputStreamReader(Wsx7G0DI.openStream()));
				String a5QOFGaI = iK3Fg4iR.readLine();
				while (a5QOFGaI != null) {
					a5QOFGaI = a5QOFGaI.trim();
					if (a5QOFGaI.length() > 0) {
						String[] DMrwIEFe = a5QOFGaI.split("\\s");
						for (int yGsfhI6B = 1; yGsfhI6B < DMrwIEFe.length; yGsfhI6B++) {
							if (DMrwIEFe[yGsfhI6B].contains(".")) {
								System.err.println(
										"META-INF/org.virbo.datasource.DataSourceFormat.extensions contains extension that contains period: ");
								System.err.println(DMrwIEFe[0] + " " + DMrwIEFe[yGsfhI6B] + " in " + Wsx7G0DI);
								System.err.println(
										"This sometimes happens when extension files are concatenated, so check that all are terminated by end-of-line");
								System.err.println("");
								throw new IllegalArgumentException(
										"DataSourceFactory.extensions contains extension that contains period: "
												+ Wsx7G0DI);
							}
							KyDohZPh.registerFormatter(DMrwIEFe[0], DMrwIEFe[yGsfhI6B]);
						}
					}
					a5QOFGaI = iK3Fg4iR.readLine();
				}
				iK3Fg4iR.close();
			}
			if (MV5pEbtA == null) {
				G5tPovJP = ClassLoader
						.getSystemResources("META-INF/org.virbo.datasource.DataSourceEditorPanel.extensions");
			} else {
				G5tPovJP = MV5pEbtA.getResources("META-INF/org.virbo.datasource.DataSourceEditorPanel.extensions");
			}
			while (G5tPovJP.hasMoreElements()) {
				URL NVcg0Z7m = G5tPovJP.nextElement();
				BufferedReader G5DYGmuA = new BufferedReader(new InputStreamReader(NVcg0Z7m.openStream()));
				String gzGxiGI6 = G5DYGmuA.readLine();
				while (gzGxiGI6 != null) {
					gzGxiGI6 = gzGxiGI6.trim();
					if (gzGxiGI6.length() > 0) {
						String[] bCkz3R7S = gzGxiGI6.split("\\s");
						for (int yuchAGmj = 1; yuchAGmj < bCkz3R7S.length; yuchAGmj++) {
							if (bCkz3R7S[yuchAGmj].contains(".")) {
								System.err.println(
										"META-INF/org.virbo.datasource.DataSourceEditorPanel.extensions contains extension that contains period: ");
								System.err.println(bCkz3R7S[0] + " " + bCkz3R7S[yuchAGmj] + " in " + NVcg0Z7m);
								System.err.println(
										"This sometimes happens when extension files are concatenated, so check that all are terminated by end-of-line");
								System.err.println("");
								throw new IllegalArgumentException(
										"DataSourceFactory.extensions contains extension that contains period: "
												+ NVcg0Z7m);
							}
							KyDohZPh.registerEditor(bCkz3R7S[0], bCkz3R7S[yuchAGmj]);
						}
					}
					gzGxiGI6 = G5DYGmuA.readLine();
				}
				G5DYGmuA.close();
			}
			if (MV5pEbtA == null) {
				G5tPovJP = ClassLoader
						.getSystemResources("META-INF/org.virbo.datasource.DataSourceFormatEditorPanel.extensions");
			} else {
				G5tPovJP = MV5pEbtA
						.getResources("META-INF/org.virbo.datasource.DataSourceFormatEditorPanel.extensions");
			}
			while (G5tPovJP.hasMoreElements()) {
				URL mjIeFmF1 = G5tPovJP.nextElement();
				BufferedReader STnSBXQK = new BufferedReader(new InputStreamReader(mjIeFmF1.openStream()));
				String EvuuDxSn = STnSBXQK.readLine();
				while (EvuuDxSn != null) {
					EvuuDxSn = EvuuDxSn.trim();
					if (EvuuDxSn.length() > 0) {
						String[] wK02CeMq = EvuuDxSn.split("\\s");
						for (int Bjw6RDoq = 1; Bjw6RDoq < wK02CeMq.length; Bjw6RDoq++) {
							if (wK02CeMq[Bjw6RDoq].contains(".")) {
								System.err.println(
										"META-INF/org.virbo.datasource.DataSourceFormatEditorPanel.extensions contains extension that contains period: ");
								System.err.println(wK02CeMq[0] + " " + wK02CeMq[Bjw6RDoq] + " in " + mjIeFmF1);
								System.err.println(
										"This sometimes happens when extension files are concatenated, so check that all are terminated by end-of-line");
								System.err.println("");
								throw new IllegalArgumentException(
										"DataSourceFactory.extensions contains extension that contains period: "
												+ mjIeFmF1);
							}
							KyDohZPh.registerFormatEditor(wK02CeMq[0], wK02CeMq[Bjw6RDoq]);
						}
					}
					EvuuDxSn = STnSBXQK.readLine();
				}
				STnSBXQK.close();
			}
		} catch (IOException TsqocpfO) {
			TsqocpfO.printStackTrace();
		}
	}

}