class n6068118 {
	public byte[] exportCommunityData(String communityId) throws RepositoryException, IOException {
		Community community;
		try {
			community = getCommunityById(communityId);
		} catch (CommunityNotFoundException e1) {
			throw new GroupwareRuntimeException("Community to export not found");
		}
		String contentPath = JCRUtil.getNodeById(communityId, community.getWorkspace()).getPath();
		try {
			File zipOutFilename = File.createTempFile("exported-community", ".zip.tmp");
			TemporaryFilesHandler.register(null, zipOutFilename);
			File file = File.createTempFile("exported-community", null);
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipOutFilename));
			TemporaryFilesHandler.register(null, file);
			FileOutputStream fos = new FileOutputStream(file);
			exportCommunitySystemView(community, contentPath, fos);
			fos.close();
			File propertiesFile = File.createTempFile("exported-community-properties", null);
			TemporaryFilesHandler.register(null, propertiesFile);
			FileOutputStream fosProperties = new FileOutputStream(propertiesFile);
			fosProperties.write(("communityId=" + communityId).getBytes());
			fosProperties.write(";".getBytes());
			fosProperties.write(("externalId=" + community.getExternalId()).getBytes());
			fosProperties.write(";".getBytes());
			fosProperties.write(("title=" + I18NUtils.localize(community.getTitle())).getBytes());
			fosProperties.write(";".getBytes());
			fosProperties.write(("communityType=" + community.getType()).getBytes());
			fosProperties.write(";".getBytes());
			fosProperties.write(("communityName=" + community.getName()).getBytes());
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
			FileInputStream fisZipped = new FileInputStream(zipOutFilename);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int readOut = 0;
			byte[] bufferOut = new byte[4096];
			while ((readOut = fisZipped.read(bufferOut)) > 0) {
				baos.write(bufferOut, 0, readOut);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			String errorMessage = "Error exporting backup data, for comunnity with id " + communityId;
			log.error(errorMessage, e);
			throw new CMSRuntimeException(errorMessage, e);
		}
	}

}