class n2157431 {
	@Override
	public String doInBackground() {
		boolean xsrFv6Ot = false;
		dao = DataAccessFactory.getUMCDataSourceAccessor(DataAccessFactory.DB_TYPE_SQLITE,
				Publisher.getInstance().getParamDBDriverconnect() + Publisher.getInstance().getParamDBName(),
				Publisher.getInstance().getParamDBDriver(), Publisher.getInstance().getParamDBUser(),
				Publisher.getInstance().getParamDBPwd());
		File liOFW3vr = new File(UMCConstants.APP_DIR + UMCConstants.fileSeparator + "downloads");
		if (!liOFW3vr.exists()) {
			if (!liOFW3vr.mkdir()) {
				log.error("Could not create download folder '" + liOFW3vr.getAbsolutePath()
						+ "' - create this directory and try again! ");
			}
		}
		if (liOFW3vr.exists()) {
			int[] IEerwbDg = tableOnline.getSelectedRows();
			for (int pGpmNLx3 = 0; pGpmNLx3 < IEerwbDg.length; pGpmNLx3++) {
				Update VY6iO6x1 = tableOnlineModel.getUpdate(IEerwbDg[pGpmNLx3]);
				if (VY6iO6x1.getType().equals(Update.TYPE_SKIN))
					xsrFv6Ot = true;
				if (UMCConstants.debug)
					log.debug("Starting to download UMC " + VY6iO6x1.getType() + ": " + VY6iO6x1.getDescription()
							+ " - Version " + VY6iO6x1.getVersionAvailable() + " from " + VY6iO6x1.getDownloadURL());
				try {
					int zu7tDk8P = 0, hFvNYMbQ = 0;
					double AbfxBFZz = 0;
					URL PYTdbnw8 = new URL(VY6iO6x1.getDownloadURL());
					URLConnection VesUur4n = PYTdbnw8.openConnection();
					VesUur4n.setConnectTimeout(10000);
					AbfxBFZz = VesUur4n.getContentLength();
					firePropertyChange("FILE", null, VY6iO6x1.getName() + " " + sizeFormater.format(AbfxBFZz / 1024));
					InputStream gyynVcEL = PYTdbnw8.openStream();
					BufferedOutputStream OLflFB9i = new BufferedOutputStream(new FileOutputStream(
							UMCConstants.APP_DIR + UMCConstants.fileSeparator + "downloads" + UMCConstants.fileSeparator
									+ VY6iO6x1.getDownloadURL().substring(VY6iO6x1.getDownloadURL().lastIndexOf("/"),
											VY6iO6x1.getDownloadURL().length())));
					byte[] gjNvpjiQ = new byte[1024 * 8];
					while ((zu7tDk8P = gyynVcEL.read(gjNvpjiQ)) != -1) {
						OLflFB9i.write(gjNvpjiQ, 0, zu7tDk8P);
						hFvNYMbQ += zu7tDk8P;
						publish(new Double(hFvNYMbQ / AbfxBFZz * 100).intValue());
					}
					gyynVcEL.close();
					OLflFB9i.close();
					String v4ZNsuDn = UMCConstants.APP_DIR + UMCConstants.fileSeparator + "downloads"
							+ UMCConstants.fileSeparator + VY6iO6x1.getDownloadURL().substring(
									VY6iO6x1.getDownloadURL().lastIndexOf("/"), VY6iO6x1.getDownloadURL().length());
					String aZmC3Ovd = "";
					if (VY6iO6x1.getType().equals(Update.TYPE_SKIN)) {
						aZmC3Ovd = UMCConstants.APP_DIR + UMCConstants.fileSeparator + "resources"
								+ UMCConstants.fileSeparator + "Skins" + UMCConstants.fileSeparator
								+ VY6iO6x1.getName();
					} else if (VY6iO6x1.getType().equals(Update.TYPE_PLUGIN_MOVIEDB)) {
						aZmC3Ovd = UMCConstants.APP_DIR + UMCConstants.fileSeparator + "plugins"
								+ UMCConstants.fileSeparator + "moviedb" + UMCConstants.fileSeparator
								+ VY6iO6x1.getName();
					} else if (VY6iO6x1.getType().equals(Update.TYPE_PLUGIN_MOVIESCANNER)
							|| VY6iO6x1.getType().equals(Update.TYPE_PLUGIN_SERIESCANNER)
							|| VY6iO6x1.getType().equals(Update.TYPE_PLUGIN_MUSICSCANNER)
							|| VY6iO6x1.getType().equals(Update.TYPE_PLUGIN_PHOTOSCANNER)) {
						aZmC3Ovd = UMCConstants.APP_DIR + UMCConstants.fileSeparator + "plugins"
								+ UMCConstants.fileSeparator + "scanner" + UMCConstants.fileSeparator
								+ VY6iO6x1.getName();
					} else if (VY6iO6x1.getType().equals(Update.TYPE_PLUGIN_GUI)) {
						aZmC3Ovd = UMCConstants.APP_DIR + UMCConstants.fileSeparator + "plugins"
								+ UMCConstants.fileSeparator + "gui" + UMCConstants.fileSeparator + VY6iO6x1.getName();
					} else {
						return "Download type could not be identified -> disgarding package";
					}
					File FSv46Hua = new File(aZmC3Ovd);
					if (!FSv46Hua.exists()) {
						FSv46Hua.mkdir();
					}
					ZipFile FqNZgsAL = new ZipFile(v4ZNsuDn);
					firePropertyChange("INSTALL", null, VY6iO6x1.getName() + " - " + FqNZgsAL.size() + " files");
					Enumeration GnP8dVyv = FqNZgsAL.entries();
					int ofNUs6wb = 0;
					int fzWuXZok = FqNZgsAL.size();
					byte[] JkWPxppJ = new byte[16384];
					int K1MKJDDv;
					while (GnP8dVyv.hasMoreElements()) {
						ZipEntry jyoBKhD9 = (ZipEntry) GnP8dVyv.nextElement();
						String z8obw8nW = jyoBKhD9.getName();
						int dNXvjJK4 = z8obw8nW.lastIndexOf('/');
						String E6JLzVSI = z8obw8nW.substring(0, dNXvjJK4 + 1);
						File h7jDFKRi = new File(aZmC3Ovd, E6JLzVSI);
						if (!h7jDFKRi.exists()) {
							h7jDFKRi.mkdirs();
						}
						if (!jyoBKhD9.isDirectory()) {
							ofNUs6wb++;
							publish(new Double((ofNUs6wb / fzWuXZok) * 100).intValue());
							OLflFB9i = new BufferedOutputStream(new FileOutputStream(new File(aZmC3Ovd, z8obw8nW)));
							BufferedInputStream j7PmW7Ri = new BufferedInputStream(FqNZgsAL.getInputStream(jyoBKhD9));
							while ((K1MKJDDv = j7PmW7Ri.read(JkWPxppJ)) > 0) {
								OLflFB9i.write(JkWPxppJ, 0, K1MKJDDv);
							}
							OLflFB9i.flush();
							OLflFB9i.close();
							j7PmW7Ri.close();
						}
					}
					if (VY6iO6x1.getType().equals(Update.TYPE_SKIN)) {
						dao.registerSkin(VY6iO6x1.getName(), VY6iO6x1.getVersionAvailable());
					} else if (VY6iO6x1.getType().equals(Update.TYPE_PLUGIN_MOVIEDB)) {
						dao.registerPlugin(VY6iO6x1.getName(), VY6iO6x1.getVersionAvailable());
					} else if (VY6iO6x1.getType().equals(Update.TYPE_PLUGIN_MOVIESCANNER)
							|| VY6iO6x1.getType().equals(Update.TYPE_PLUGIN_SERIESCANNER)
							|| VY6iO6x1.getType().equals(Update.TYPE_PLUGIN_MUSICSCANNER)
							|| VY6iO6x1.getType().equals(Update.TYPE_PLUGIN_PHOTOSCANNER)) {
						dao.registerPlugin(VY6iO6x1.getName(), VY6iO6x1.getVersionAvailable());
					} else if (VY6iO6x1.getType().equals(Update.TYPE_PLUGIN_GUI)) {
						dao.registerPlugin(VY6iO6x1.getName(), VY6iO6x1.getVersionAvailable());
					}
					tableOnlineModel.removeUpdate(IEerwbDg[pGpmNLx3]);
					tableOnline.updateUI();
				} catch (MalformedURLException Z93YnfI4) {
					log.error(Z93YnfI4);
					return "MalformedURLException";
				} catch (IOException rBk9lkht) {
					log.error(rBk9lkht);
					return "IO Error";
				} catch (Exception jjwIEv2i) {
					log.error(jjwIEv2i);
					return "Installation Error";
				}
			}
		} else {
			return "Error";
		}
		if (xsrFv6Ot) {
			Publisher.getInstance().findAllSkins();
			Publisher.getInstance().refreshParams();
			Publisher.getInstance().createFrontendDirectoryStructure();
		}
		return "OK";
	}

}