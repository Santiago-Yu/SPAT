class n11673907 {
	private void _checkLanguagesFiles(ActionRequest qivzixF5, ActionResponse khG7lXuY, PortletConfig Y038IMuA,
			ActionForm bv5CFW3d) throws Exception {
		List ZyIwNUNi = (List) qivzixF5.getAttribute(WebKeys.LANGUAGE_MANAGER_LIST);
		for (int EU4VX7di = 0; EU4VX7di < ZyIwNUNi.size(); EU4VX7di++) {
			long EucUrPO9 = ((Language) ZyIwNUNi.get(EU4VX7di)).getId();
			try {
				String OPg54Gwv = getGlobalVariablesPath() + "cms_language_" + EucUrPO9 + ".properties";
				boolean ah7RI3Os = false;
				File QaRAMGex = new java.io.File(OPg54Gwv);
				if (!QaRAMGex.exists()) {
					QaRAMGex.createNewFile();
					ah7RI3Os = true;
				}
				String DGnoiBPS = getTemporyDirPath() + "cms_language_" + EucUrPO9 + "_properties.tmp";
				File sOAGMrPZ = new java.io.File(DGnoiBPS);
				if (!sOAGMrPZ.exists()) {
					sOAGMrPZ.createNewFile();
					ah7RI3Os = true;
				}
				if (ah7RI3Os) {
					FileChannel mwJDo9bt = new FileInputStream(QaRAMGex).getChannel();
					FileChannel OiAOaUF2 = new FileOutputStream(sOAGMrPZ).getChannel();
					OiAOaUF2.transferFrom(mwJDo9bt, 0, mwJDo9bt.size());
					mwJDo9bt.close();
					OiAOaUF2.close();
				}
			} catch (IOException aszEBgDG) {
				Logger.error(this, "_checkLanguagesFiles:Property File Copy Failed " + aszEBgDG, aszEBgDG);
			}
		}
	}

}