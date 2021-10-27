class n18207261 {
	private RemoteObject createRemoteObject(final VideoEntry s2A6i1Ku, final RemoteContainer DLZX4BXO)
			throws RemoteException {
		MessageDigest fIVTH5Ob;
		try {
			fIVTH5Ob = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException pQHLBnZK) {
			throw new RemoteException(StatusCreator.newStatus("Error creating MD5", pQHLBnZK));
		}
		StringWriter aVJx95ah = new StringWriter();
		YouTubeMediaGroup CC4ijUZl = s2A6i1Ku.getMediaGroup();
		if (CC4ijUZl != null) {
			if (CC4ijUZl.getDescription() != null) {
				aVJx95ah.append(CC4ijUZl.getDescription().getPlainTextContent());
			}
			List<MediaCategory> IOG7TAel = CC4ijUZl.getCategories();
			StringBuilder nsy80Gjt = new StringBuilder();
			if (IOG7TAel != null) {
				for (MediaCategory JTbpQTxf : IOG7TAel) {
					nsy80Gjt.append(JTbpQTxf.getContent());
				}
			}
		}
		fIVTH5Ob.update(aVJx95ah.toString().getBytes());
		RemoteObject Z0v16UAR = InfomngmntFactory.eINSTANCE.createRemoteObject();
		Z0v16UAR.setHash(asHex(fIVTH5Ob.digest()));
		Z0v16UAR.setId(SiteInspector.getId(s2A6i1Ku.getHtmlLink().getHref()));
		Z0v16UAR.setName(s2A6i1Ku.getTitle().getPlainText());
		Z0v16UAR.setRepositoryTypeObjectId(KEY_VIDEO);
		Z0v16UAR.setWrappedObject(s2A6i1Ku);
		setInternalUrl(Z0v16UAR, DLZX4BXO);
		return Z0v16UAR;
	}

}