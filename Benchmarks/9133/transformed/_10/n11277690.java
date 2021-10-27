class n11277690 {
	File exportCommunityData(Community community)
			throws CommunityNotActiveException, FileNotFoundException, IOException, CommunityNotFoundException {
		try {
			String communityId = community.getId();
			if (!community.isActive()) {
				log.error("The community with id " + communityId + " is inactive");
				throw new CommunityNotActiveException("The community with id " + communityId + " is inactive");
			}
			new File(CommunityManagerImpl.EXPORTED_COMMUNITIES_PATH).mkdirs();
			String communityName = community.getName();
			String communityType = community.getType();
			File zipOutFilename;
			String communityTitle = I18NUtils.localize(community.getTitle());
			if (community.isPersonalCommunity()) {
				zipOutFilename = new File(CommunityManagerImpl.EXPORTED_COMMUNITIES_PATH + communityName + ".zip");
			} else {
				zipOutFilename = new File(CommunityManagerImpl.EXPORTED_COMMUNITIES_PATH
						+ MANUAL_EXPORTED_COMMUNITY_PREFIX + communityTitle + ".zip");
			}
			File file = File.createTempFile("exported-community", null);
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipOutFilename));
			TemporaryFilesHandler.register(null, file);
			String contentPath = JCRUtil.getNodeById(communityId).getPath();
			FileOutputStream fos = new FileOutputStream(file);
			JCRUtil.currentSession().exportSystemView(contentPath, fos, false, false);
			fos.close();
			File propertiesFile = File.createTempFile("exported-community-properties", null);
			TemporaryFilesHandler.register(null, propertiesFile);
			FileOutputStream fosProperties = new FileOutputStream(propertiesFile);
			fosProperties.write(("communityId=" + communityId).getBytes());
			fosProperties.write(";".getBytes());
			fosProperties.write(("externalId=" + community.getExternalId()).getBytes());
			fosProperties.write(";".getBytes());
			fosProperties.write(("title=" + communityTitle).getBytes());
			fosProperties.write(";".getBytes());
			fosProperties.write(("communityType=" + communityType).getBytes());
			fosProperties.write(";".getBytes());
			fosProperties.write(("communityName=" + communityName).getBytes());
			fosProperties.close();
			byte[] bufferProperties = new byte[4096];
			FileInputStream finProperties = new FileInputStream(propertiesFile);
			out.putNextEntry(new ZipEntry("properties"));
			int readProperties = 0;
			while ((readProperties = finProperties.read(bufferProperties)) > 0) {
				out.write(bufferProperties, 0, readProperties);
			}
			finProperties.close();
			byte[] buffer = new byte[4096];
			FileInputStream fin = new FileInputStream(file);
			out.putNextEntry(new ZipEntry("xmlData"));
			int read = 0;
			while ((read = fin.read(buffer)) > 0) {
				out.write(buffer, 0, read);
			}
			fin.close();
			out.close();
			community.setActive(Boolean.FALSE);
			communityPersister.saveCommunity(community);
			Collection<Community> duplicatedPersonalCommunities = communityPersister
					.searchCommunitiesByName(communityName);
			if (CommunityManager.PERSONAL_COMMUNITY_TYPE.equals(communityType)) {
				for (Community currentCommunity : duplicatedPersonalCommunities) {
					if (currentCommunity.isActive()) {
						currentCommunity.setActive(Boolean.FALSE);
						communityPersister.saveCommunity(currentCommunity);
					}
				}
			}
			return zipOutFilename;
		} catch (RepositoryException e) {
			log.error("Error getting community with id " + community.getId());
			throw new GroupwareRuntimeException("Error getting community with id " + community.getId(), e.getCause());
		}
	}

}