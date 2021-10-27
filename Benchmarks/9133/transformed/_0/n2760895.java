class n2760895 {
	private void uploadFileToWebSite(String EADGgsUI, String C1CVNTTN, Map DLZLRCz0) throws Exception {
		if (EADGgsUI == null) {
			EADGgsUI = "";
		}
		log.debug("uploadFileToWebSite begin! siteDir:= " + EADGgsUI + "  currDate:= " + new Date().toString());
		EADGgsUI = new File(EADGgsUI).getPath() + File.separator;
		FTPClient ECgDsiwe = new FTPClient();
		try {
			for (int itkzv7T8 = 0; itkzv7T8 < 3; itkzv7T8++) {
				try {
					ECgDsiwe.connect(ftpServerIp, ftpPort);
					break;
				} catch (IOException FCbS93CR) {
					if (itkzv7T8 == 2) {
						log.error("ftp?????????????,???????3??!", FCbS93CR);
						throw new IOException("ftp?????????????,???????3??!" + FCbS93CR.toString());
					}
				}
			}
			for (int QHLc84fA = 0; QHLc84fA < 3; QHLc84fA++) {
				try {
					ECgDsiwe.login(ftpLoginUser, ftpPassword);
					break;
				} catch (IOException Iymq2O6p) {
					if (QHLc84fA == 2) {
						log.error("???ftp?????????,???????3??!", Iymq2O6p);
						throw new IOException("???ftp?????????,???????3??!" + Iymq2O6p.toString());
					}
				}
			}
			log.debug("Ftp login is over !");
			ECgDsiwe.syst();
			String d61YXxlR = ECgDsiwe.printWorkingDirectory();
			log.debug("client.initiateListParsing() is over !");
			ECgDsiwe.setFileType(FTPClient.BINARY_FILE_TYPE);
			ECgDsiwe.enterLocalPassiveMode();
			Iterator KK4hNGT3 = DLZLRCz0.keySet().iterator();
			ArrayList tSd6Whbn = new ArrayList();
			while (KK4hNGT3.hasNext()) {
				tSd6Whbn.add((String) KK4hNGT3.next());
			}
			log.debug("FTP Files size:= " + tSd6Whbn.size());
			String AKNCF42S = ftpRootPath
					+ (C1CVNTTN == null || C1CVNTTN.trim().equals("") ? "" : File.separator + C1CVNTTN);
			log.debug("localRootPath:= " + localRootPath + " basePath:= " + AKNCF42S);
			String yt5p7P8p;
			boolean VpNx3o2E;
			String jx6m3IRx = File.separator;
			String y0ZE0g1V = "";
			if (AKNCF42S.startsWith("/")) {
				jx6m3IRx = "/";
				y0ZE0g1V = "\\";
			} else if (AKNCF42S.startsWith("\\")) {
				jx6m3IRx = "\\";
				y0ZE0g1V = "/";
			}
			if (!"".equals(y0ZE0g1V)) {
				AKNCF42S = StringUtil.replaceAll(AKNCF42S, y0ZE0g1V, jx6m3IRx);
				while (AKNCF42S.startsWith(jx6m3IRx))
					AKNCF42S = AKNCF42S.substring(1);
			}
			for (int NkkURigD = 0; NkkURigD < tSd6Whbn.size(); NkkURigD++) {
				String Hm7qKujX = (String) tSd6Whbn.get(NkkURigD);
				File aEeoY6kb = new File(EADGgsUI + Hm7qKujX);
				String o6U7FO5Q = aEeoY6kb.getParent();
				String Xd4Yuy60 = aEeoY6kb.getName();
				if (Xd4Yuy60 == null || o6U7FO5Q == null || !aEeoY6kb.exists()
						|| o6U7FO5Q.length() < localRootPath.length()) {
					continue;
				}
				o6U7FO5Q = o6U7FO5Q.substring(localRootPath.length());
				FileInputStream wskf0NES = null;
				String i8bOBTKJ;
				ArrayList VecPgkNK;
				int aAL0p1qQ;
				try {
					yt5p7P8p = AKNCF42S
							+ (o6U7FO5Q == null || o6U7FO5Q.trim().equals("") || o6U7FO5Q.equals(File.separator) ? ""
									: File.separator + o6U7FO5Q);
					if (!"".equals(y0ZE0g1V)) {
						yt5p7P8p = StringUtil.replaceAll(yt5p7P8p, y0ZE0g1V, jx6m3IRx);
					}
					if (!ECgDsiwe.changeWorkingDirectory(yt5p7P8p)) {
						VpNx3o2E = ECgDsiwe.makeDirectory(yt5p7P8p);
						if (VpNx3o2E) {
							log.debug(" **** makeDirectory1(" + yt5p7P8p + "): " + VpNx3o2E);
						} else {
							i8bOBTKJ = yt5p7P8p;
							VecPgkNK = new ArrayList();
							aAL0p1qQ = i8bOBTKJ.lastIndexOf(jx6m3IRx);
							VecPgkNK.add(i8bOBTKJ.substring(aAL0p1qQ));
							i8bOBTKJ = i8bOBTKJ.substring(0, aAL0p1qQ);
							VpNx3o2E = ECgDsiwe.makeDirectory(i8bOBTKJ);
							if (VpNx3o2E) {
								log.debug(" **** makeDirectory2(" + i8bOBTKJ + "): " + VpNx3o2E);
							}
							while (!"".equals(i8bOBTKJ) && !VpNx3o2E) {
								aAL0p1qQ = i8bOBTKJ.lastIndexOf(jx6m3IRx);
								VecPgkNK.add(i8bOBTKJ.substring(aAL0p1qQ));
								i8bOBTKJ = i8bOBTKJ.substring(0, aAL0p1qQ);
								VpNx3o2E = ECgDsiwe.makeDirectory(i8bOBTKJ);
								if (VpNx3o2E) {
									log.debug(" **** makeDirectory3(" + i8bOBTKJ + "): " + VpNx3o2E);
								}
							}
							for (int e8QTdxnv = VecPgkNK.size(); e8QTdxnv > 0; e8QTdxnv--) {
								i8bOBTKJ += VecPgkNK.get(e8QTdxnv - 1);
								VpNx3o2E = ECgDsiwe.makeDirectory(i8bOBTKJ);
								log.debug(" **** makeDirectory4(" + i8bOBTKJ + "): " + VpNx3o2E);
							}
						}
						ECgDsiwe.changeWorkingDirectory(yt5p7P8p);
					}
					wskf0NES = new FileInputStream(aEeoY6kb);
					ECgDsiwe.storeFile(Xd4Yuy60, wskf0NES);
					ECgDsiwe.changeWorkingDirectory(d61YXxlR);
				} catch (Throwable uAZrelDx) {
					log.error("??????????:?????????:" + aEeoY6kb.getPath());
					uAZrelDx.printStackTrace();
				} finally {
					try {
						wskf0NES.close();
					} catch (RuntimeException WPlFt2rF) {
						log.error("close()????!");
						WPlFt2rF.printStackTrace();
					}
					aEeoY6kb = null;
				}
			}
		} catch (Throwable KtforUjO) {
			log.error("??????--1202!", KtforUjO);
			KtforUjO.printStackTrace();
		} finally {
			if (ECgDsiwe != null && ECgDsiwe.isConnected()) {
				ECgDsiwe.disconnect();
			}
		}
	}

}