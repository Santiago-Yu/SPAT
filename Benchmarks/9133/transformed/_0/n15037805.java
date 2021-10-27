class n15037805 {
	public List<String> generate(String fBI1G9md, String NwoaAJ0R, String lIHSG5Wy) {
		geronimoRepository = NwoaAJ0R + "/repository";
		Debug.logInfo("The WASCE or Geronimo Repository is " + geronimoRepository, module);
		Classpath My4AcT62 = new Classpath(System.getProperty("java.class.path"));
		List<File> cTXD99iS = My4AcT62.getElements();
		List<String> X8CWv3Qt = new ArrayList<String>();
		String FTqajt5Z = null;
		String aRC8eZnA = null;
		String RpJYdnvM = null;
		String ZrVlmo64 = null;
		String hHdE8Th3 = "1.0";
		int fcMfU2pq = -1;
		for (File xFf4RfT7 : cTXD99iS) {
			if (xFf4RfT7.exists()) {
				if (xFf4RfT7.isFile()) {
					FTqajt5Z = xFf4RfT7.getAbsolutePath();
					aRC8eZnA = xFf4RfT7.getName();
					String kZxvWDbJ = (String) aRC8eZnA.subSequence(0, aRC8eZnA.length() - 4);
					fcMfU2pq = kZxvWDbJ.lastIndexOf("-");
					if (fcMfU2pq > -1) {
						hHdE8Th3 = kZxvWDbJ.substring(fcMfU2pq + 1, kZxvWDbJ.length());
						ZrVlmo64 = kZxvWDbJ.substring(0, fcMfU2pq);
						boolean hMBxEK2y = 0 < StringUtil.removeRegex(hHdE8Th3, "[^.0123456789]").length();
						if (!hMBxEK2y) {
							hHdE8Th3 = "1.0";
							ZrVlmo64 = kZxvWDbJ;
							RpJYdnvM = kZxvWDbJ + "-" + hHdE8Th3 + ".jar";
						} else {
							RpJYdnvM = aRC8eZnA;
						}
					} else {
						hHdE8Th3 = "1.0";
						ZrVlmo64 = kZxvWDbJ;
						RpJYdnvM = kZxvWDbJ + "-" + hHdE8Th3 + ".jar";
					}
					X8CWv3Qt.add(ZrVlmo64 + "#" + hHdE8Th3);
					String U4LsZBDi = geronimoRepository + "/org/ofbiz/" + ZrVlmo64 + "/" + hHdE8Th3;
					File QNRQThof = new File(U4LsZBDi);
					if (!QNRQThof.exists()) {
						boolean Dt2Q5RlC = QNRQThof.mkdirs();
						if (!Dt2Q5RlC) {
							Debug.logFatal("Unable to create target directory - " + U4LsZBDi, module);
							return null;
						}
					}
					if (!U4LsZBDi.endsWith("/")) {
						U4LsZBDi = U4LsZBDi + "/";
					}
					String PxBeWgzH = U4LsZBDi + RpJYdnvM;
					File kH0LbZVD = new File(PxBeWgzH);
					try {
						FileChannel PypDxdgT = new FileInputStream(FTqajt5Z).getChannel();
						FileChannel jfHtD9PT = new FileOutputStream(PxBeWgzH).getChannel();
						jfHtD9PT.transferFrom(PypDxdgT, 0, PypDxdgT.size());
						Debug.log("Created jar file : " + RpJYdnvM + " in WASCE or Geronimo repository", module);
						PypDxdgT.close();
						jfHtD9PT.close();
					} catch (IOException fjl3KRKf) {
						Debug.logFatal("Unable to create jar file - " + RpJYdnvM
								+ " in WASCE or Geronimo repository (certainly already exists)", module);
						return null;
					}
				}
			}
		}
		List<ComponentConfig.WebappInfo> MzV5LeVg = ComponentConfig.getAllWebappResourceInfos();
		File HWtPxQjf = new File(
				System.getProperty("ofbiz.home") + "/framework/appserver/templates/" + fBI1G9md + "/geronimo-web.xml");
		for (ComponentConfig.WebappInfo HEXlTcEQ : MzV5LeVg) {
			if (null != HEXlTcEQ) {
				parseTemplate(HWtPxQjf, HEXlTcEQ);
			}
		}
		return X8CWv3Qt;
	}

}