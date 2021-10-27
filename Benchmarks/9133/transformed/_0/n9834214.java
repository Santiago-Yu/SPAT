class n9834214 {
	void loadSVG(String ZkhjzERK) {
		try {
			URL DfA41275 = new URL(ZkhjzERK);
			URLConnection R29YNO2K = DfA41275.openConnection();
			R29YNO2K.setRequestProperty("Accept-Encoding", "gzip");
			InputStream g5p2vtpL = R29YNO2K.getInputStream();
			String e0PKc6T2 = R29YNO2K.getContentEncoding();
			if ("gzip".equals(e0PKc6T2) || "x-gzip".equals(e0PKc6T2) || ZkhjzERK.toLowerCase().endsWith(".svgz")) {
				g5p2vtpL = new GZIPInputStream(g5p2vtpL);
			}
			g5p2vtpL = new BufferedInputStream(g5p2vtpL);
			Document cChZWjnj = AppletUtils.parse(g5p2vtpL, false);
			if (cChZWjnj != null) {
				if (grMngr.mainView.isBlank() == null) {
					grMngr.mainView.setBlank(cfgMngr.backgroundColor);
				}
				SVGReader.load(cChZWjnj, grMngr.mSpace, true, ZkhjzERK);
				grMngr.seekBoundingBox();
				grMngr.buildLogicalStructure();
				ConfigManager.defaultFont = VText.getMainFont();
				grMngr.reveal();
				if (grMngr.previousLocations.size() == 1) {
					grMngr.previousLocations.removeElementAt(0);
				}
				if (grMngr.rView != null) {
					grMngr.rView.getGlobalView(grMngr.mSpace.getCamera(1), 100);
				}
				grMngr.cameraMoved(null, null, 0);
			} else {
				System.err.println("An error occured while loading file " + ZkhjzERK);
			}
		} catch (Exception e6Bl652A) {
			grMngr.reveal();
			e6Bl652A.printStackTrace();
		}
	}

}