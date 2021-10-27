class n14924022 {
	private boolean saveDocumentXml(String wvMBpvLc, String Uc4R4d9T) {
		boolean zOhJUhBC = true;
		try {
			XPath vFjVBgjC = XPathFactory.newInstance().newXPath();
			String Luday8HX = "documents/document";
			InputSource ejzOWAg6 = new InputSource(
					new FileInputStream(Uc4R4d9T + File.separator + AppConstants.DMS_XML));
			NodeList W1Oxg5z0 = (NodeList) vFjVBgjC.evaluate(Luday8HX, ejzOWAg6, XPathConstants.NODESET);
			for (int SZpQgxQ4 = 0; SZpQgxQ4 < W1Oxg5z0.getLength(); SZpQgxQ4++) {
				Node ORFdE0oR = W1Oxg5z0.item(SZpQgxQ4);
				System.out.println(ORFdE0oR.getNodeName());
				DocumentModel YRaCe7gZ = new DocumentModel();
				NodeList dnARrQ5Q = ORFdE0oR.getChildNodes();
				for (int ocSyuNDG = 0; ocSyuNDG < dnARrQ5Q.getLength(); ocSyuNDG++) {
					Node q7m0i1Cq = dnARrQ5Q.item(ocSyuNDG);
					if (q7m0i1Cq.getNodeType() == Node.ELEMENT_NODE) {
						if (q7m0i1Cq.getNodeName() != null && q7m0i1Cq.getFirstChild() != null
								&& q7m0i1Cq.getFirstChild().getNodeValue() != null) {
							System.out.println(q7m0i1Cq.getNodeName() + "::" + q7m0i1Cq.getFirstChild().getNodeValue());
						}
						if (Document.FLD_ID.equals(q7m0i1Cq.getNodeName())) {
							if (q7m0i1Cq.getFirstChild() != null) {
								String GSXmO7z3 = q7m0i1Cq.getFirstChild().getNodeValue();
								if (GSXmO7z3 != null && GSXmO7z3.length() > 0) {
									try {
										YRaCe7gZ.setId(new Long(GSXmO7z3));
									} catch (Exception EkGfGP0W) {
										EkGfGP0W.printStackTrace();
									}
								}
							}
						} else if (YRaCe7gZ.FLD_NAME.equals(q7m0i1Cq.getNodeName())) {
							YRaCe7gZ.setName(q7m0i1Cq.getFirstChild().getNodeValue());
							YRaCe7gZ.setTitle(YRaCe7gZ.getName());
							YRaCe7gZ.setDescr(YRaCe7gZ.getName());
							YRaCe7gZ.setExt(getExtension(YRaCe7gZ.getName()));
						} else if (YRaCe7gZ.FLD_LOCATION.equals(q7m0i1Cq.getNodeName())) {
							YRaCe7gZ.setLocation(q7m0i1Cq.getFirstChild().getNodeValue());
						} else if (YRaCe7gZ.FLD_OWNER.equals(q7m0i1Cq.getNodeName())) {
							Long FuNmV5hi = new Long(q7m0i1Cq.getFirstChild().getNodeValue());
							User jMeH7UpC = new UserModel();
							jMeH7UpC.setId(FuNmV5hi);
							jMeH7UpC = (User) userService.find(jMeH7UpC);
							if (jMeH7UpC != null && jMeH7UpC.getId() != null) {
								YRaCe7gZ.setOwner(jMeH7UpC);
							}
						}
					}
				}
				boolean yTMgQtOP = docService.save(YRaCe7gZ);
				if (yTMgQtOP) {
					String vpiFFWZk = preference.getRepository();
					Calendar ASogE2p8 = Calendar.getInstance();
					StringBuffer dRCuvP4m = new StringBuffer(vpiFFWZk);
					dRCuvP4m.append(File.separator);
					StringBuffer VQ9451JK = new StringBuffer(sdf.format(ASogE2p8.getTime()));
					VQ9451JK.append(File.separator).append(ASogE2p8.get(Calendar.HOUR_OF_DAY));
					File Wf02Zj5C = new File(dRCuvP4m.append(VQ9451JK).toString());
					if (!Wf02Zj5C.exists()) {
						Wf02Zj5C.mkdirs();
					}
					FileChannel drZEJmIl = null, gJY7IuGz = null;
					try {
						StringBuffer AKbxhIwZ = new StringBuffer(Wf02Zj5C.getAbsolutePath());
						StringBuffer mJjmMPsl = new StringBuffer(YRaCe7gZ.getId().toString());
						mJjmMPsl.append(".").append(YRaCe7gZ.getExt());
						AKbxhIwZ.append(File.separator).append(mJjmMPsl);
						drZEJmIl = new FileInputStream(Uc4R4d9T + File.separator + YRaCe7gZ.getName()).getChannel();
						gJY7IuGz = new FileOutputStream(AKbxhIwZ.toString()).getChannel();
						gJY7IuGz.transferFrom(drZEJmIl, 0, drZEJmIl.size());
						YRaCe7gZ.setLocation(VQ9451JK.toString());
						YRaCe7gZ.setSize(drZEJmIl.size());
						log.info("Batch upload file " + YRaCe7gZ.getName() + " into [" + YRaCe7gZ.getLocation()
								+ "] as " + YRaCe7gZ.getName() + "." + YRaCe7gZ.getExt());
						folder.setId(DEFAULT_FOLDER);
						folder = (Folder) folderService.find(folder);
						if (folder != null && folder.getId() != null) {
							YRaCe7gZ.setFolder(folder);
						}
						workspace.setId(DEFAULT_WORKSPACE);
						workspace = (Workspace) workspaceService.find(workspace);
						if (workspace != null && workspace.getId() != null) {
							YRaCe7gZ.setWorkspace(workspace);
						}
						user.setId(DEFAULT_USER);
						user = (User) userService.find(user);
						if (user != null && user.getId() != null) {
							YRaCe7gZ.setCrtby(user.getId());
						}
						YRaCe7gZ.setCrtdate(new Date());
						YRaCe7gZ = (DocumentModel) docService.resetDuplicateDocName(YRaCe7gZ);
						docService.save(YRaCe7gZ);
						DocumentIndexer.indexDocument(preference, YRaCe7gZ);
					} catch (FileNotFoundException QhBIN0mf) {
						log.error("saveFile file not found: " + YRaCe7gZ.getName(), QhBIN0mf);
					} catch (IOException r7PGW0MI) {
						log.error("saveFile IOException: " + YRaCe7gZ.getName(), r7PGW0MI);
					} finally {
						try {
							if (drZEJmIl != null) {
								drZEJmIl.close();
							}
							if (gJY7IuGz != null) {
								gJY7IuGz.close();
							}
						} catch (Exception UKCnuId5) {
							log.error(UKCnuId5.getMessage(), UKCnuId5);
						}
					}
				}
			}
		} catch (Exception qcy8guJU) {
			zOhJUhBC = false;
			qcy8guJU.printStackTrace();
		}
		return zOhJUhBC;
	}

}