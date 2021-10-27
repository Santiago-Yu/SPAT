class n7727956 {
	public static void createOutputStructure(String VUGnNWZ3) throws InterruptedException {
		try {
			VUGnNWZ3 = new File(VUGnNWZ3).getCanonicalPath();
			VUGnNWZ3 = VUGnNWZ3.replace('\\', '/');
			File rLLWI1Y1 = null;
			Paths XJs3ovHV = (Paths) GragGenerator.getObjectsFromTree(Paths.class).get(0);
			Config msrnguxu = (Config) GragGenerator.getObjectsFromTree(Config.class).get(0);
			DirectoryIterator p2ATPID2 = new DirectoryIterator(VUGnNWZ3, true, true);
			while ((rLLWI1Y1 = p2ATPID2.getNext()) != null) {
				boolean IDTK2mRF = false;
				String WxFxpB8L = rLLWI1Y1.getCanonicalPath();
				int AhFm82FC = WxFxpB8L.lastIndexOf(System.getProperty("file.separator"));
				if (CVS_DIR.equals(
						rLLWI1Y1.getCanonicalPath().substring(WxFxpB8L.length() - CVS_DIR.length(), WxFxpB8L.length()))
						|| CVS_DIR.equals(WxFxpB8L.substring(AhFm82FC - CVS_DIR.length(), AhFm82FC))) {
					continue;
				}
				if ("readme.txt".equals(rLLWI1Y1.getName())) {
					continue;
				}
				String GWEnhUg0 = outputDir.replace('\\', '/');
				String wJBSeUIO = rLLWI1Y1.getCanonicalPath().replace('\\', '/');
				if (wJBSeUIO.indexOf(VUGnNWZ3) == 0) {
					wJBSeUIO = wJBSeUIO.substring(VUGnNWZ3.length());
					if (wJBSeUIO.startsWith(Paths.CONF_GENERAL_DIR)) {
						wJBSeUIO = XJs3ovHV.getConfigOutput() + wJBSeUIO.substring(Paths.CONF_GENERAL_DIR.length());
						IDTK2mRF = true;
					} else if (wJBSeUIO.startsWith(Paths.CONF_STRUTS_DIR)) {
						wJBSeUIO = XJs3ovHV.getConfigOutput() + wJBSeUIO.substring(Paths.CONF_STRUTS_DIR.length());
						IDTK2mRF = true;
					} else if (wJBSeUIO.startsWith(Paths.CONF_TAPESTRY4_DIR)) {
						wJBSeUIO = XJs3ovHV.getConfigOutput() + wJBSeUIO.substring(Paths.CONF_TAPESTRY4_DIR.length());
						IDTK2mRF = true;
					} else if (wJBSeUIO.startsWith(Paths.CONF_SWING_DIR)) {
						wJBSeUIO = XJs3ovHV.getConfigOutput() + wJBSeUIO.substring(Paths.CONF_SWING_DIR.length());
						IDTK2mRF = true;
					} else if (wJBSeUIO.startsWith(Paths.JAVA_WEB_STRUTS_DIR)) {
						wJBSeUIO = XJs3ovHV.getJspOutput() + wJBSeUIO.substring(Paths.JAVA_WEB_STRUTS_DIR.length());
						if (msrnguxu.matchWebTier("struts").booleanValue()) {
							IDTK2mRF = true;
						}
					} else if (wJBSeUIO.startsWith(Paths.JAVA_WEB_TAPESTRY4_DIR)) {
						wJBSeUIO = XJs3ovHV.getJspOutput() + wJBSeUIO.substring(Paths.JAVA_WEB_TAPESTRY4_DIR.length());
						if (msrnguxu.matchWebTier("tapestry").booleanValue()) {
							IDTK2mRF = true;
						}
					} else if (wJBSeUIO.startsWith(Paths.JAVA_SWING_DIR)) {
						wJBSeUIO = XJs3ovHV.getSwingOutput() + wJBSeUIO.substring(Paths.JAVA_SWING_DIR.length());
						if (msrnguxu.matchWebTier("swing").booleanValue()) {
							IDTK2mRF = true;
						}
					} else if (wJBSeUIO.startsWith(Paths.JAVA_STRUTS_DIR)) {
						wJBSeUIO = XJs3ovHV.getWebOutput() + wJBSeUIO.substring(Paths.JAVA_STRUTS_DIR.length());
						if (msrnguxu.matchWebTier("struts").booleanValue()) {
							IDTK2mRF = true;
						}
					} else if (wJBSeUIO.startsWith(Paths.JAVA_TAPESTRY4_DIR)) {
						wJBSeUIO = XJs3ovHV.getWebOutput() + wJBSeUIO.substring(Paths.JAVA_TAPESTRY4_DIR.length());
						if (msrnguxu.matchWebTier("tapestry").booleanValue()) {
							IDTK2mRF = true;
						}
					} else if (wJBSeUIO.startsWith(Paths.JAVA_EJB2_DIR)) {
						wJBSeUIO = XJs3ovHV.getEjbOutput() + wJBSeUIO.substring(Paths.JAVA_EJB2_DIR.length());
						if (msrnguxu.matchBusinessTier("ejb 2").booleanValue()) {
							IDTK2mRF = true;
						}
					} else if (wJBSeUIO.startsWith(Paths.JAVA_EJB3_DIR)) {
						wJBSeUIO = XJs3ovHV.getEjbOutput() + wJBSeUIO.substring(Paths.JAVA_EJB3_DIR.length());
						if (msrnguxu.matchBusinessTier("ejb 3").booleanValue()) {
							IDTK2mRF = true;
						}
					} else if (wJBSeUIO.startsWith(Paths.JAVA_HIBERNATE2_DIR)) {
						wJBSeUIO = XJs3ovHV.getHibernateOutput()
								+ wJBSeUIO.substring(Paths.JAVA_HIBERNATE2_DIR.length());
						if (msrnguxu.matchBusinessTier("hibernate 2").booleanValue()) {
							IDTK2mRF = true;
						}
					} else if (wJBSeUIO.startsWith(Paths.JAVA_HIBERNATE3_DIR)) {
						wJBSeUIO = XJs3ovHV.getHibernateOutput()
								+ wJBSeUIO.substring(Paths.JAVA_HIBERNATE3_DIR.length());
						if (msrnguxu.matchBusinessTier("hibernate 3").booleanValue()) {
							IDTK2mRF = true;
						}
					} else if (wJBSeUIO.startsWith(Paths.JAVA_MOCK_DIR)) {
						wJBSeUIO = XJs3ovHV.getMockOutput() + wJBSeUIO.substring(Paths.JAVA_MOCK_DIR.length());
						if (msrnguxu.useMock().booleanValue()) {
							IDTK2mRF = true;
						}
					} else if (wJBSeUIO.startsWith(Paths.JAVA_SERVICE_DIR)) {
						wJBSeUIO = XJs3ovHV.getServiceOutput() + wJBSeUIO.substring(Paths.JAVA_SERVICE_DIR.length());
						IDTK2mRF = true;
					} else if (wJBSeUIO.startsWith(Paths.JAVA_TEST_DIR)) {
						wJBSeUIO = XJs3ovHV.getTestOutput() + wJBSeUIO.substring(Paths.JAVA_TEST_DIR.length());
						IDTK2mRF = true;
					} else if ((wJBSeUIO.indexOf("build.bat") != -1) || ((wJBSeUIO.indexOf("deploy.bat") != -1))) {
						IDTK2mRF = true;
					}
				}
				if (!wJBSeUIO.startsWith("/")) {
					wJBSeUIO = "/" + wJBSeUIO;
				}
				if (IDTK2mRF) {
					GWEnhUg0 += wJBSeUIO;
					wJBSeUIO = outputDir + wJBSeUIO;
					if (!rLLWI1Y1.isDirectory()) {
						String wo9Pxjda = rLLWI1Y1.getName();
						wJBSeUIO = wJBSeUIO.substring(0, (wJBSeUIO.length() - wo9Pxjda.length()));
					}
					new File(wJBSeUIO).mkdirs();
					if (!rLLWI1Y1.isDirectory()) {
						byte fbElMM69[] = new byte[1024];
						int hV3GtQnx = 0;
						try {
							BufferedInputStream th59yMUw = new BufferedInputStream(new FileInputStream(rLLWI1Y1));
							BufferedOutputStream HcMA9JY4 = new BufferedOutputStream(new FileOutputStream(GWEnhUg0));
							while ((hV3GtQnx = th59yMUw.read(fbElMM69)) != -1)
								HcMA9JY4.write(fbElMM69, 0, hV3GtQnx);
							th59yMUw.close();
							HcMA9JY4.flush();
							HcMA9JY4.close();
						} catch (Exception mtoPFJT9) {
							log("[Error] Copy output file failed : " + GWEnhUg0);
							log(mtoPFJT9.getMessage());
						}
					}
				}
			}
		} catch (Exception uLiHxBxz) {
			log.error("Error while copying files: ", uLiHxBxz);
			log(uLiHxBxz.getMessage());
		}
	}

}