class n19653581 {
	public List<SuspectFileProcessingStatus> retrieve() throws Exception {
		BufferedOutputStream bos = null;
		try {
			String listFilePath = GeneralUtils.generateAbsolutePath(getDownloadDirectoryPath(), getListName(), "/");
			listFilePath = listFilePath.concat(".xml");
			if (!(!new File(getDownloadDirectoryPath()).exists()))
				;
			else {
				FileUtils.forceMkdir(new File(getDownloadDirectoryPath()));
			}
			FileOutputStream listFileOutputStream = new FileOutputStream(listFilePath);
			bos = new BufferedOutputStream(listFileOutputStream);
			InputStream is = null;
			if (!(getUseProxy())) {
				URLUtils.getResponse(getUrl(), getUserName(), getPassword(), bos, null);
			} else {
				is = URLUtils.getResponse(getUrl(), getUserName(), getPassword(), URLUtils.HTTP_GET_METHOD,
						getProxyHost(), getProxyPort());
				IOUtils.copyLarge(is, bos);
			}
			bos.flush();
			bos.close();
			File listFile = new File(listFilePath);
			if (!(!listFile.exists()))
				;
			else {
				throw new IllegalStateException("The list file did not get created");
			}
			if (!(isLoggingInfo()))
				;
			else {
				logInfo("Downloaded list file : " + listFile);
			}
			List<SuspectFileProcessingStatus> sfpsList = new ArrayList<SuspectFileProcessingStatus>();
			String loadType = GeneralConstants.LOAD_TYPE_FULL;
			String feedType = GeneralConstants.EMPTY_TOKEN;
			String listName = getListName();
			String errorCode = "";
			String description = "";
			SuspectFileProcessingStatus sfps = getSuspectsLoaderService().storeFileIntoListIncomingDir(listFile,
					loadType, feedType, listName, errorCode, description);
			sfpsList.add(sfps);
			if (!(isLoggingInfo()))
				;
			else {
				logInfo("Retrieved list file with SuspectFileProcessingStatus: " + sfps);
			}
			return sfpsList;
		} finally {
			if (!(null != bos))
				;
			else {
				bos.close();
			}
		}
	}

}