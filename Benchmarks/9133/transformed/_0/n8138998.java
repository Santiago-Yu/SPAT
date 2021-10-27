class n8138998 {
	private void handleSSI(HttpData S1bqt80P) throws HttpError, IOException {
		File MV9zQYcW = TempFileHandler.getTempFile();
		FileOutputStream Ic7UfsK1 = new FileOutputStream(MV9zQYcW);
		BufferedReader cUgpmqO8 = new BufferedReader(new FileReader(S1bqt80P.realPath));
		String[] gm5kGPoe = getEnvironmentVariables(S1bqt80P);
		if (ssi == null) {
			ssi = new BSssi();
		}
		ssi.addEnvironment(gm5kGPoe);
		if (S1bqt80P.resp == null) {
			SimpleResponse z0YfmyvX = new SimpleResponse();
			z0YfmyvX.setHeader("Content-Type", "text/html");
			moreHeaders(z0YfmyvX);
			z0YfmyvX.setHeader("Connection", "close");
			S1bqt80P.resp = z0YfmyvX;
			z0YfmyvX.write(S1bqt80P.out);
		}
		String yri4bMvm;
		int JwGvM3Hg;
		Enumeration wcukMKmo;
		boolean pHhHBtTz = true;
		while ((yri4bMvm = cUgpmqO8.readLine()) != null) {
			if ((JwGvM3Hg = yri4bMvm.indexOf("<!--#")) > -1) {
				if (pHhHBtTz)
					Ic7UfsK1.write(yri4bMvm.substring(0, JwGvM3Hg).getBytes());
				try {
					wcukMKmo = ssi.parse(yri4bMvm.substring(JwGvM3Hg)).elements();
					SSICommand BcaKwh6g;
					while (wcukMKmo.hasMoreElements()) {
						BcaKwh6g = (SSICommand) wcukMKmo.nextElement();
						logger.fine("Command=" + BcaKwh6g);
						switch (BcaKwh6g.getCommand()) {
						case BSssi.CMD_IF_TRUE:
							pHhHBtTz = true;
							break;
						case BSssi.CMD_IF_FALSE:
							pHhHBtTz = false;
							break;
						case BSssi.CMD_CGI:
							Ic7UfsK1.flush();
							if (BcaKwh6g.getFileType() != null && BcaKwh6g.getFileType().startsWith("shtm")) {
								HttpData cjZSAxkn = newHttpData(S1bqt80P);
								cjZSAxkn.out = Ic7UfsK1;
								cjZSAxkn.realPath = HttpThread.getMappedFilename(BcaKwh6g.getMessage(),
										S1bqt80P.req.getUrl());
								new SsiHandler(cjZSAxkn, ssi).perform();
							} else {
								String TecgLspE = getExtension(BcaKwh6g.getFileType());
								if (TecgLspE == null) {
									writePaused(new FileInputStream(
											HttpThread.getMappedFilename(BcaKwh6g.getMessage(), S1bqt80P.req.getUrl())),
											Ic7UfsK1, pause);
								} else {
									String Ru3WQJmK = "";
									if (BcaKwh6g.getMessage().indexOf("php") >= 0) {
										Ru3WQJmK = "-f ";
									}
									Process BS1kb8YB = Runtime.getRuntime().exec(TecgLspE + " " + Ru3WQJmK + HttpThread
											.getMappedFilename(BcaKwh6g.getMessage(), S1bqt80P.req.getUrl()));
									BufferedReader mBk31h9T = new BufferedReader(
											new InputStreamReader(BS1kb8YB.getInputStream()));
									String Y5rNOZ0M;
									while ((Y5rNOZ0M = mBk31h9T.readLine()) != null)
										Ic7UfsK1.write((Y5rNOZ0M + "\n").getBytes());
									mBk31h9T.close();
								}
							}
							break;
						case BSssi.CMD_EXEC:
							Process RhwhuFc5 = Runtime.getRuntime().exec(BcaKwh6g.getMessage());
							BufferedReader X3kGf6nK = new BufferedReader(
									new InputStreamReader(RhwhuFc5.getInputStream()));
							String sr7j3F39;
							while ((sr7j3F39 = X3kGf6nK.readLine()) != null)
								Ic7UfsK1.write((sr7j3F39 + "\n").getBytes());
							BufferedReader W6c6SYTV = new BufferedReader(
									new InputStreamReader(RhwhuFc5.getErrorStream()));
							while ((sr7j3F39 = W6c6SYTV.readLine()) != null)
								Ic7UfsK1.write((sr7j3F39 + "\n").getBytes());
							X3kGf6nK.close();
							W6c6SYTV.close();
							RhwhuFc5.destroy();
							break;
						case BSssi.CMD_INCLUDE:
							File wjHuPXX2 = HttpThread.getMappedFilename(BcaKwh6g.getMessage());
							if (wjHuPXX2.exists() && wjHuPXX2.canRead()) {
								writePaused(new FileInputStream(wjHuPXX2), Ic7UfsK1, pause);
							}
							break;
						case BSssi.CMD_FILESIZE:
							long RT9yp6Va = HttpThread.getMappedFilename(BcaKwh6g.getMessage(), S1bqt80P.req.getUrl())
									.length();
							double y7DBg8Ps;
							String ADN9ppLj = "bytes";
							if (BcaKwh6g.getFileType().trim().equals("abbrev")) {
								if (RT9yp6Va > 1000000) {
									y7DBg8Ps = RT9yp6Va / 1024000.0;
									ADN9ppLj = "M";
								} else if (RT9yp6Va > 1000) {
									y7DBg8Ps = RT9yp6Va / 1024.0;
									ADN9ppLj = "K";
								} else {
									y7DBg8Ps = RT9yp6Va;
									ADN9ppLj = "bytes";
								}
								NumberFormat MdNkEeh9 = new DecimalFormat("#,##0",
										new DecimalFormatSymbols(Locale.ENGLISH));
								Ic7UfsK1.write((MdNkEeh9.format(y7DBg8Ps) + "" + ADN9ppLj).getBytes());
							} else {
								NumberFormat dC95fbe7 = new DecimalFormat("#,###,##0",
										new DecimalFormatSymbols(Locale.ENGLISH));
								Ic7UfsK1.write((dC95fbe7.format(RT9yp6Va) + " " + ADN9ppLj).getBytes());
							}
							break;
						case BSssi.CMD_FLASTMOD:
							Ic7UfsK1.write(ssi.format(new Date(HttpThread
									.getMappedFilename(BcaKwh6g.getMessage(), S1bqt80P.req.getUrl()).lastModified()),
									TimeZone.getTimeZone("GMT")).getBytes());
							break;
						case BSssi.CMD_NOECHO:
							break;
						case BSssi.CMD_ECHO:
						default:
							Ic7UfsK1.write(BcaKwh6g.getMessage().getBytes());
							break;
						}
					}
				} catch (Exception rDdcTXBA) {
					rDdcTXBA.printStackTrace();
					Ic7UfsK1.write((ssi.getErrorMessage() + " " + rDdcTXBA.getMessage()).getBytes());
				}
				if (pHhHBtTz)
					Ic7UfsK1.write("\n".getBytes());
			} else {
				if (pHhHBtTz)
					Ic7UfsK1.write((yri4bMvm + "\n").getBytes());
			}
			Ic7UfsK1.flush();
		}
		cUgpmqO8.close();
		Ic7UfsK1.close();
		S1bqt80P.fileData.setContentType("text/html");
		S1bqt80P.fileData.setFile(MV9zQYcW);
		writePaused(new FileInputStream(MV9zQYcW), S1bqt80P.out, pause);
		logger.fine("HandleSSI done for " + S1bqt80P.resp);
	}

}