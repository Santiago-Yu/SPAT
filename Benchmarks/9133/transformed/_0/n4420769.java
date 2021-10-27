class n4420769 {
	public void _saveWebAsset(ActionRequest N88MiwHN, ActionResponse NYXFTTpI, PortletConfig xR6TXVXc,
			ActionForm Wps3ugCi, User SqtmLRMZ, String XlXlLhK2) throws WebAssetException, Exception {
		long c7mP931X = 50;
		long ENlGmcNJ = 3000;
		long KOPcoy15 = 3000;
		long JEKvGJGu = 10;
		ActionRequestImpl gyVeDkgk = (ActionRequestImpl) N88MiwHN;
		HttpServletRequest gtjUpsur = gyVeDkgk.getHttpServletRequest();
		try {
			UploadPortletRequest ggpEMTZk = PortalUtil.getUploadPortletRequest(N88MiwHN);
			String lIZa1XYe = ParamUtil.getString(N88MiwHN, "parent");
			int S8suhCwj = ParamUtil.getInteger(N88MiwHN, "countFiles");
			int l3O2iLDP = 0;
			Folder v6Dqc787 = (Folder) InodeFactory.getInode(lIZa1XYe, Folder.class);
			_checkUserPermissions(v6Dqc787, SqtmLRMZ, PERMISSION_WRITE);
			String krpaZIve = SqtmLRMZ.getUserId();
			String ETfqJj4i = "Some file does not match the filters specified by the folder: ";
			boolean YHWLiQtH = false;
			for (int b07DYHkT = 0; b07DYHkT < S8suhCwj; b07DYHkT++) {
				File BKzajFEK = new File();
				String kWcHmea5 = ParamUtil.getString(N88MiwHN, "title" + b07DYHkT);
				String HvLrQDL6 = ParamUtil.getString(N88MiwHN, "friendlyName" + b07DYHkT);
				Date Lwe9DAT6 = new Date();
				String tjHFwWjo = ParamUtil.getString(N88MiwHN, "fileName" + b07DYHkT);
				tjHFwWjo = checkMACFileName(tjHFwWjo);
				if (!FolderFactory.matchFilter(v6Dqc787, tjHFwWjo)) {
					ETfqJj4i += tjHFwWjo + ", ";
					YHWLiQtH = true;
					continue;
				}
				if (tjHFwWjo.length() > 0) {
					String EmNA6Fhn = FileFactory.getMimeType(tjHFwWjo);
					String D5LHGAqZ = v6Dqc787.getPath() + tjHFwWjo;
					String pSUhgzLv = UtilMethods.getFileExtension(tjHFwWjo);
					BKzajFEK.setTitle(kWcHmea5);
					BKzajFEK.setFileName(tjHFwWjo);
					BKzajFEK.setFriendlyName(HvLrQDL6);
					BKzajFEK.setPublishDate(Lwe9DAT6);
					BKzajFEK.setModUser(krpaZIve);
					InodeFactory.saveInode(BKzajFEK);
					String nDLiGab6 = FileFactory.getRealAssetsRootPath();
					new java.io.File(nDLiGab6).mkdir();
					java.io.File RIq6Sd7W = ggpEMTZk.getFile("uploadedFile" + b07DYHkT);
					Logger.debug(this, "bytes" + RIq6Sd7W.length());
					BKzajFEK.setSize((int) RIq6Sd7W.length() - 2);
					BKzajFEK.setMimeType(EmNA6Fhn);
					Host wuNTkRu4 = HostFactory.getCurrentHost(gtjUpsur);
					Identifier NJvbLM1D = IdentifierFactory.getIdentifierByURI(D5LHGAqZ, wuNTkRu4);
					String gKtN5Mye = "";
					if ((FileFactory.existsFileName(v6Dqc787, tjHFwWjo))) {
						InodeFactory.deleteInode(BKzajFEK);
						gKtN5Mye = "The uploaded file " + tjHFwWjo + " already exists in this folder";
						SessionMessages.add(N88MiwHN, "custommessage", gKtN5Mye);
					} else {
						String Ad5rANUN = String.valueOf(BKzajFEK.getInode());
						if (Ad5rANUN.length() == 1) {
							Ad5rANUN = Ad5rANUN + "0";
						}
						Ad5rANUN = Ad5rANUN.substring(0, 1) + java.io.File.separator + Ad5rANUN.substring(1, 2);
						new java.io.File(nDLiGab6 + java.io.File.separator + Ad5rANUN.substring(0, 1)).mkdir();
						new java.io.File(nDLiGab6 + java.io.File.separator + Ad5rANUN).mkdir();
						java.io.File xmyeJyAm = new java.io.File(nDLiGab6 + java.io.File.separator + Ad5rANUN
								+ java.io.File.separator + BKzajFEK.getInode() + "." + pSUhgzLv);
						java.io.FileOutputStream bEYqQqPn = new java.io.FileOutputStream(xmyeJyAm);
						FileChannel WF2CQnFW = bEYqQqPn.getChannel();
						FileChannel JBUpQQex = new java.io.FileInputStream(RIq6Sd7W).getChannel();
						WF2CQnFW.transferFrom(JBUpQQex, 0, JBUpQQex.size());
						WF2CQnFW.force(false);
						WF2CQnFW.close();
						JBUpQQex.close();
						Logger.debug(this, "SaveFileAction New File in =" + nDLiGab6 + java.io.File.separator + Ad5rANUN
								+ java.io.File.separator + BKzajFEK.getInode() + "." + pSUhgzLv);
						if (pSUhgzLv.equals("jpg") || pSUhgzLv.equals("gif")) {
							com.dotmarketing.util.Thumbnail.resizeImage(
									nDLiGab6 + java.io.File.separator + Ad5rANUN + java.io.File.separator,
									String.valueOf(BKzajFEK.getInode()), pSUhgzLv);
							int xlTm6ZVV = javax.imageio.ImageIO.read(xmyeJyAm).getHeight();
							BKzajFEK.setHeight(xlTm6ZVV);
							Logger.debug(this, "File height=" + xlTm6ZVV);
							int B9hq2heo = javax.imageio.ImageIO.read(xmyeJyAm).getWidth();
							BKzajFEK.setWidth(B9hq2heo);
							Logger.debug(this, "File width=" + B9hq2heo);
							long BPsPLp5Q = (xmyeJyAm.length() / 1024);
							WebAssetFactory.createAsset(BKzajFEK, krpaZIve, v6Dqc787);
						} else {
							WebAssetFactory.createAsset(BKzajFEK, krpaZIve, v6Dqc787);
						}
						WorkingCache.addToWorkingAssetToCache(BKzajFEK);
						_setFilePermissions(v6Dqc787, BKzajFEK, SqtmLRMZ);
						l3O2iLDP += 1;
						if ((XlXlLhK2 != null) && XlXlLhK2.equals(com.dotmarketing.util.Constants.PUBLISH)) {
							try {
								PublishFactory.publishAsset(BKzajFEK, gtjUpsur);
								if (l3O2iLDP > 1) {
									SessionMessages.add(N88MiwHN, "message", "message.file_asset.save");
								} else {
									SessionMessages.add(N88MiwHN, "message", "message.fileupload.save");
								}
							} catch (WebAssetException EUMgwc3n) {
								Logger.error(this, EUMgwc3n.getMessage(), EUMgwc3n);
								SessionMessages.add(N88MiwHN, "error", "message.webasset.published.failed");
							}
						}
					}
				}
			}
			if (YHWLiQtH) {
				ETfqJj4i = ETfqJj4i.substring(0, ETfqJj4i.lastIndexOf(","));
				SessionMessages.add(N88MiwHN, "custommessage", ETfqJj4i);
			}
		} catch (IOException Mt1xoYyq) {
			Logger.error(this, "Exception saving file: " + Mt1xoYyq.getMessage());
			throw new ActionException(Mt1xoYyq.getMessage());
		}
	}

}