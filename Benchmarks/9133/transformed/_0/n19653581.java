class n19653581 {
	public List<SuspectFileProcessingStatus> retrieve() throws Exception {
		BufferedOutputStream lHuMxTAg = null;
		try {
			String NEuTSDpN = GeneralUtils.generateAbsolutePath(getDownloadDirectoryPath(), getListName(), "/");
			NEuTSDpN = NEuTSDpN.concat(".xml");
			if (!new File(getDownloadDirectoryPath()).exists()) {
				FileUtils.forceMkdir(new File(getDownloadDirectoryPath()));
			}
			FileOutputStream Uu9QNJhm = new FileOutputStream(NEuTSDpN);
			lHuMxTAg = new BufferedOutputStream(Uu9QNJhm);
			InputStream nX1q6vS5 = null;
			if (getUseProxy()) {
				nX1q6vS5 = URLUtils.getResponse(getUrl(), getUserName(), getPassword(), URLUtils.HTTP_GET_METHOD,
						getProxyHost(), getProxyPort());
				IOUtils.copyLarge(nX1q6vS5, lHuMxTAg);
			} else {
				URLUtils.getResponse(getUrl(), getUserName(), getPassword(), lHuMxTAg, null);
			}
			lHuMxTAg.flush();
			lHuMxTAg.close();
			File jHjPXFge = new File(NEuTSDpN);
			if (!jHjPXFge.exists()) {
				throw new IllegalStateException("The list file did not get created");
			}
			if (isLoggingInfo()) {
				logInfo("Downloaded list file : " + jHjPXFge);
			}
			List<SuspectFileProcessingStatus> ZOYaoRvU = new ArrayList<SuspectFileProcessingStatus>();
			String aO539qeO = GeneralConstants.LOAD_TYPE_FULL;
			String xPzXiRp6 = GeneralConstants.EMPTY_TOKEN;
			String a5qD7Kbn = getListName();
			String vvmEirg5 = "";
			String BP3LcYnx = "";
			SuspectFileProcessingStatus pTs1dqqo = getSuspectsLoaderService().storeFileIntoListIncomingDir(jHjPXFge,
					aO539qeO, xPzXiRp6, a5qD7Kbn, vvmEirg5, BP3LcYnx);
			ZOYaoRvU.add(pTs1dqqo);
			if (isLoggingInfo()) {
				logInfo("Retrieved list file with SuspectFileProcessingStatus: " + pTs1dqqo);
			}
			return ZOYaoRvU;
		} finally {
			if (null != lHuMxTAg) {
				lHuMxTAg.close();
			}
		}
	}

}