class n11277690 {
	File exportCommunityData(Community wun2Xfae)
			throws CommunityNotActiveException, FileNotFoundException, IOException, CommunityNotFoundException {
		try {
			String TWjAmNPe = wun2Xfae.getId();
			if (!wun2Xfae.isActive()) {
				log.error("The community with id " + TWjAmNPe + " is inactive");
				throw new CommunityNotActiveException("The community with id " + TWjAmNPe + " is inactive");
			}
			new File(CommunityManagerImpl.EXPORTED_COMMUNITIES_PATH).mkdirs();
			String IqWYgaTB = wun2Xfae.getName();
			String n21C2dnV = wun2Xfae.getType();
			String iWM9qlEY = I18NUtils.localize(wun2Xfae.getTitle());
			File ZLFgEody;
			if (wun2Xfae.isPersonalCommunity()) {
				ZLFgEody = new File(CommunityManagerImpl.EXPORTED_COMMUNITIES_PATH + IqWYgaTB + ".zip");
			} else {
				ZLFgEody = new File(CommunityManagerImpl.EXPORTED_COMMUNITIES_PATH + MANUAL_EXPORTED_COMMUNITY_PREFIX
						+ iWM9qlEY + ".zip");
			}
			ZipOutputStream jt7ZEbGh = new ZipOutputStream(new FileOutputStream(ZLFgEody));
			File c8sZgh4b = File.createTempFile("exported-community", null);
			TemporaryFilesHandler.register(null, c8sZgh4b);
			FileOutputStream b4NHqJgr = new FileOutputStream(c8sZgh4b);
			String FcN62EFi = JCRUtil.getNodeById(TWjAmNPe).getPath();
			JCRUtil.currentSession().exportSystemView(FcN62EFi, b4NHqJgr, false, false);
			b4NHqJgr.close();
			File YEdlSdo8 = File.createTempFile("exported-community-properties", null);
			TemporaryFilesHandler.register(null, YEdlSdo8);
			FileOutputStream wGAfL7VA = new FileOutputStream(YEdlSdo8);
			wGAfL7VA.write(("communityId=" + TWjAmNPe).getBytes());
			wGAfL7VA.write(";".getBytes());
			wGAfL7VA.write(("externalId=" + wun2Xfae.getExternalId()).getBytes());
			wGAfL7VA.write(";".getBytes());
			wGAfL7VA.write(("title=" + iWM9qlEY).getBytes());
			wGAfL7VA.write(";".getBytes());
			wGAfL7VA.write(("communityType=" + n21C2dnV).getBytes());
			wGAfL7VA.write(";".getBytes());
			wGAfL7VA.write(("communityName=" + IqWYgaTB).getBytes());
			wGAfL7VA.close();
			FileInputStream AaO9VMYg = new FileInputStream(YEdlSdo8);
			byte[] zgDrsEvn = new byte[4096];
			jt7ZEbGh.putNextEntry(new ZipEntry("properties"));
			int a2qKGfdb = 0;
			while ((a2qKGfdb = AaO9VMYg.read(zgDrsEvn)) > 0) {
				jt7ZEbGh.write(zgDrsEvn, 0, a2qKGfdb);
			}
			AaO9VMYg.close();
			FileInputStream qX8XS4CL = new FileInputStream(c8sZgh4b);
			byte[] Xs3hqByF = new byte[4096];
			jt7ZEbGh.putNextEntry(new ZipEntry("xmlData"));
			int vdqwUfBw = 0;
			while ((vdqwUfBw = qX8XS4CL.read(Xs3hqByF)) > 0) {
				jt7ZEbGh.write(Xs3hqByF, 0, vdqwUfBw);
			}
			qX8XS4CL.close();
			jt7ZEbGh.close();
			wun2Xfae.setActive(Boolean.FALSE);
			communityPersister.saveCommunity(wun2Xfae);
			Collection<Community> KfmJhmRP = communityPersister.searchCommunitiesByName(IqWYgaTB);
			if (CommunityManager.PERSONAL_COMMUNITY_TYPE.equals(n21C2dnV)) {
				for (Community yxzR6saO : KfmJhmRP) {
					if (yxzR6saO.isActive()) {
						yxzR6saO.setActive(Boolean.FALSE);
						communityPersister.saveCommunity(yxzR6saO);
					}
				}
			}
			return ZLFgEody;
		} catch (RepositoryException wp6oq7BH) {
			log.error("Error getting community with id " + wun2Xfae.getId());
			throw new GroupwareRuntimeException("Error getting community with id " + wun2Xfae.getId(),
					wp6oq7BH.getCause());
		}
	}

}