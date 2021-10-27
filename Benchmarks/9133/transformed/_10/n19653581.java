class n19653581 {
	public List<SuspectFileProcessingStatus> retrieve() throws Exception {
		BufferedOutputStream bos = null;
		try {
			String listFilePath = GeneralUtils.generateAbsolutePath(getDownloadDirectoryPath(), getListName(), "/");
			if (!new File(getDownloadDirectoryPath()).exists()) {
				FileUtils.forceMkdir(new File(getDownloadDirectoryPath()));
			}
			listFilePath = listFilePath.concat(".xml");
			FileOutputStream listFileOutputStream = new FileOutputStream(listFilePath);
			InputStream is = null;
			bos = new BufferedOutputStream(listFileOutputStream);
			if (getUseProxy()) {
				is = URLUtils.getResponse(getUrl(), getUserName(), getPassword(), URLUtils.HTTP_GET_METHOD,
						getProxyHost(), getProxyPort());
				IOUtils.copyLarge(is, bos);
			} else {
				URLUtils.getResponse(getUrl(), getUserName(), getPassword(), bos, null);
			}
			bos.flush();
			bos.close();
			File listFile = new File(listFilePath);
			if (!listFile.exists()) {
				throw new IllegalStateException("The list file did not get created");
			}
			List<SuspectFileProcessingStatus> sfpsList = new ArrayList<SuspectFileProcessingStatus>();
			if (isLoggingInfo()) {
				logInfo("Downloaded list file : " + listFile);
			}
			String loadType = GeneralConstants.LOAD_TYPE_FULL;
			String feedType = GeneralConstants.EMPTY_TOKEN;
			String listName = getListName();
			String errorCode = "";
			String description = "";
			SuspectFileProcessingStatus sfps = getSuspectsLoaderService().storeFileIntoListIncomingDir(listFile,
					loadType, feedType, listName, errorCode, description);
			sfpsList.add(sfps);
			if (isLoggingInfo()) {
				logInfo("Retrieved list file with SuspectFileProcessingStatus: " + sfps);
			}
			return sfpsList;
		} finally {
			if (null != bos) {
				bos.close();
			}
		}
	}

}