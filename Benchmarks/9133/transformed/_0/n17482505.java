class n17482505 {
	public void createResource(String IFJpYk6n, boolean JKDSqqDz, User R8UwiZPb) throws IOException {
		PermissionAPI b4veb4R4 = APILocator.getPermissionAPI();
		Logger.debug(this.getClass(), "createResource");
		IFJpYk6n = stripMapping(IFJpYk6n);
		String lMglhfJl = getHostname(IFJpYk6n);
		String CJvwO4d1 = getPath(IFJpYk6n);
		String hp5lt6vf = getFolderName(CJvwO4d1);
		String NGOBP0DK = getFileName(CJvwO4d1);
		NGOBP0DK = deleteSpecialCharacter(NGOBP0DK);
		if (NGOBP0DK.startsWith(".")) {
			return;
		}
		Host IGtU3otR = HostFactory.getHostByHostName(lMglhfJl);
		Folder Qk3e5lk3 = FolderFactory.getFolderByPath(hp5lt6vf, IGtU3otR);
		boolean QbM2EvGE = b4veb4R4.doesUserHavePermission(Qk3e5lk3, PERMISSION_WRITE, R8UwiZPb, false);
		if (QbM2EvGE) {
			if (!checkFolderFilter(Qk3e5lk3, NGOBP0DK)) {
				throw new IOException("The file doesn't comply the folder's filter");
			}
			if (IGtU3otR.getInode() != 0 && Qk3e5lk3.getInode() != 0) {
				File Hq2b2IGd = new File();
				Hq2b2IGd.setTitle(NGOBP0DK);
				Hq2b2IGd.setFileName(NGOBP0DK);
				Hq2b2IGd.setShowOnMenu(false);
				Hq2b2IGd.setLive(JKDSqqDz);
				Hq2b2IGd.setWorking(true);
				Hq2b2IGd.setDeleted(false);
				Hq2b2IGd.setLocked(false);
				Hq2b2IGd.setModDate(new Date());
				String BpmBjACL = FileFactory.getMimeType(NGOBP0DK);
				Hq2b2IGd.setMimeType(BpmBjACL);
				String UCJ8xmeL = R8UwiZPb.getFullName();
				Hq2b2IGd.setAuthor(UCJ8xmeL);
				Hq2b2IGd.setModUser(UCJ8xmeL);
				Hq2b2IGd.setSortOrder(0);
				Hq2b2IGd.setShowOnMenu(false);
				try {
					Identifier zCo2dCzm = null;
					if (!isResource(IFJpYk6n)) {
						WebAssetFactory.createAsset(Hq2b2IGd, R8UwiZPb.getUserId(), Qk3e5lk3, JKDSqqDz);
						zCo2dCzm = IdentifierCache.getIdentifierFromIdentifierCache(Hq2b2IGd);
					} else {
						File TTTfvhEl = FileFactory.getFileByURI(CJvwO4d1, IGtU3otR, false);
						zCo2dCzm = IdentifierCache.getIdentifierFromIdentifierCache(TTTfvhEl);
						WebAssetFactory.createAsset(Hq2b2IGd, R8UwiZPb.getUserId(), Qk3e5lk3, zCo2dCzm, false, false);
						WebAssetFactory.publishAsset(Hq2b2IGd);
						String J7Ft09qR = FileFactory.getRealAssetsRootPath();
						new java.io.File(J7Ft09qR).mkdir();
						java.io.File X8ZOeppQ = FileFactory.getAssetIOFile(Hq2b2IGd);
						DotResourceCache Pr1UuzjE = CacheLocator.getVeloctyResourceCache();
						Pr1UuzjE.remove(ResourceManager.RESOURCE_TEMPLATE + X8ZOeppQ.getPath());
						if (Hq2b2IGd != null && Hq2b2IGd.getInode() > 0) {
							byte[] qfTbyVdJ = new byte[0];
							FileInputStream AX3rEk9q = new FileInputStream(X8ZOeppQ);
							int UhmLrnic = AX3rEk9q.available();
							qfTbyVdJ = new byte[UhmLrnic];
							AX3rEk9q.read(qfTbyVdJ);
							java.io.File rPx1PnxI = FileFactory.getAssetIOFile(Hq2b2IGd);
							Pr1UuzjE.remove(ResourceManager.RESOURCE_TEMPLATE + rPx1PnxI.getPath());
							FileChannel IWEEABf9 = new FileOutputStream(rPx1PnxI).getChannel();
							ByteBuffer tAT9RCB0 = ByteBuffer.allocate(qfTbyVdJ.length);
							tAT9RCB0.put(qfTbyVdJ);
							tAT9RCB0.position(0);
							IWEEABf9.write(tAT9RCB0);
							IWEEABf9.force(false);
							IWEEABf9.close();
						}
						java.util.List<Tree> qvQTJSkJ = TreeFactory.getTreesByChild(Hq2b2IGd);
						for (Tree SNRgerNr : qvQTJSkJ) {
							Tree gdv0rCui = TreeFactory.getTree(SNRgerNr.getParent(), Hq2b2IGd.getInode());
							if (gdv0rCui.getChild() == 0) {
								gdv0rCui.setParent(SNRgerNr.getParent());
								gdv0rCui.setChild(Hq2b2IGd.getInode());
								gdv0rCui.setRelationType(SNRgerNr.getRelationType());
								gdv0rCui.setTreeOrder(0);
								TreeFactory.saveTree(gdv0rCui);
							}
						}
					}
					List<Permission> OqvNX5B2 = b4veb4R4.getPermissions(Qk3e5lk3);
					for (Permission HQZh5Bm1 : OqvNX5B2) {
						Permission TmA0mWry = new Permission();
						TmA0mWry.setPermission(HQZh5Bm1.getPermission());
						TmA0mWry.setRoleId(HQZh5Bm1.getRoleId());
						TmA0mWry.setInode(zCo2dCzm.getInode());
						b4veb4R4.save(TmA0mWry);
					}
				} catch (Exception uyCdS4UD) {
					Logger.debug(this, uyCdS4UD.toString());
				}
			}
		} else {
			throw new IOException("You don't have access to add that folder/host");
		}
	}

}