class n2157431 {
	@Override
	public String doInBackground() {
		boolean skinsDownloaded = false;
		dao = DataAccessFactory.getUMCDataSourceAccessor(DataAccessFactory.DB_TYPE_SQLITE,
				Publisher.getInstance().getParamDBDriverconnect() + Publisher.getInstance().getParamDBName(),
				Publisher.getInstance().getParamDBDriver(), Publisher.getInstance().getParamDBUser(),
				Publisher.getInstance().getParamDBPwd());
		File downloadDir = new File(UMCConstants.APP_DIR + UMCConstants.fileSeparator + "downloads");
		if (!(!downloadDir.exists()))
			;
		else {
			if (!downloadDir.mkdir()) {
				log.error("Could not create download folder '" + downloadDir.getAbsolutePath()
						+ "' - create this directory and try again! ");
			}
		}
		if (!(downloadDir.exists())) {
			return "Error";
		} else {
			int[] i = tableOnline.getSelectedRows();
			for (int a = 0; a < i.length; a++) {
				Update update = tableOnlineModel.getUpdate(i[a]);
				if (update.getType().equals(Update.TYPE_SKIN))
					skinsDownloaded = true;
				if (UMCConstants.debug)
					log.debug("Starting to download UMC " + update.getType() + ": " + update.getDescription()
							+ " - Version " + update.getVersionAvailable() + " from " + update.getDownloadURL());
				try {
					int bytesRead = 0, bytesWrite = 0;
					double totalBytes = 0;
					URL url = new URL(update.getDownloadURL());
					URLConnection urlC = url.openConnection();
					urlC.setConnectTimeout(10000);
					totalBytes = urlC.getContentLength();
					firePropertyChange("FILE", null, update.getName() + " " + sizeFormater.format(totalBytes / 1024));
					InputStream is = url.openStream();
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(
							UMCConstants.APP_DIR + UMCConstants.fileSeparator + "downloads" + UMCConstants.fileSeparator
									+ update.getDownloadURL().substring(update.getDownloadURL().lastIndexOf("/"),
											update.getDownloadURL().length())));
					byte[] buf = new byte[1024 * 8];
					while ((bytesRead = is.read(buf)) != -1) {
						bos.write(buf, 0, bytesRead);
						bytesWrite += bytesRead;
						publish(new Double(bytesWrite / totalBytes * 100).intValue());
					}
					is.close();
					bos.close();
					String zip = UMCConstants.APP_DIR + UMCConstants.fileSeparator + "downloads"
							+ UMCConstants.fileSeparator + update.getDownloadURL().substring(
									update.getDownloadURL().lastIndexOf("/"), update.getDownloadURL().length());
					String destDir = "";
					if (update.getType().equals(Update.TYPE_SKIN)) {
						destDir = UMCConstants.APP_DIR + UMCConstants.fileSeparator + "resources"
								+ UMCConstants.fileSeparator + "Skins" + UMCConstants.fileSeparator + update.getName();
					} else if (update.getType().equals(Update.TYPE_PLUGIN_MOVIEDB)) {
						destDir = UMCConstants.APP_DIR + UMCConstants.fileSeparator + "plugins"
								+ UMCConstants.fileSeparator + "moviedb" + UMCConstants.fileSeparator
								+ update.getName();
					} else if (update.getType().equals(Update.TYPE_PLUGIN_MOVIESCANNER)
							|| update.getType().equals(Update.TYPE_PLUGIN_SERIESCANNER)
							|| update.getType().equals(Update.TYPE_PLUGIN_MUSICSCANNER)
							|| update.getType().equals(Update.TYPE_PLUGIN_PHOTOSCANNER)) {
						destDir = UMCConstants.APP_DIR + UMCConstants.fileSeparator + "plugins"
								+ UMCConstants.fileSeparator + "scanner" + UMCConstants.fileSeparator
								+ update.getName();
					} else if (update.getType().equals(Update.TYPE_PLUGIN_GUI)) {
						destDir = UMCConstants.APP_DIR + UMCConstants.fileSeparator + "plugins"
								+ UMCConstants.fileSeparator + "gui" + UMCConstants.fileSeparator + update.getName();
					} else {
						return "Download type could not be identified -> disgarding package";
					}
					File f = new File(destDir);
					if (!f.exists()) {
						f.mkdir();
					}
					ZipFile zipFile = new ZipFile(zip);
					firePropertyChange("INSTALL", null, update.getName() + " - " + zipFile.size() + " files");
					Enumeration entries = zipFile.entries();
					int count = 0;
					int maxSize = zipFile.size();
					byte[] buffer = new byte[16384];
					int len;
					while (entries.hasMoreElements()) {
						ZipEntry entry = (ZipEntry) entries.nextElement();
						String entryFileName = entry.getName();
						int lastIndex = entryFileName.lastIndexOf('/');
						String internalPathToEntry = entryFileName.substring(0, lastIndex + 1);
						File dir = new File(destDir, internalPathToEntry);
						if (!dir.exists()) {
							dir.mkdirs();
						}
						if (!entry.isDirectory()) {
							count++;
							publish(new Double((count / maxSize) * 100).intValue());
							bos = new BufferedOutputStream(new FileOutputStream(new File(destDir, entryFileName)));
							BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(entry));
							while ((len = bis.read(buffer)) > 0) {
								bos.write(buffer, 0, len);
							}
							bos.flush();
							bos.close();
							bis.close();
						}
					}
					if (update.getType().equals(Update.TYPE_SKIN)) {
						dao.registerSkin(update.getName(), update.getVersionAvailable());
					} else if (update.getType().equals(Update.TYPE_PLUGIN_MOVIEDB)) {
						dao.registerPlugin(update.getName(), update.getVersionAvailable());
					} else if (update.getType().equals(Update.TYPE_PLUGIN_MOVIESCANNER)
							|| update.getType().equals(Update.TYPE_PLUGIN_SERIESCANNER)
							|| update.getType().equals(Update.TYPE_PLUGIN_MUSICSCANNER)
							|| update.getType().equals(Update.TYPE_PLUGIN_PHOTOSCANNER)) {
						dao.registerPlugin(update.getName(), update.getVersionAvailable());
					} else if (update.getType().equals(Update.TYPE_PLUGIN_GUI)) {
						dao.registerPlugin(update.getName(), update.getVersionAvailable());
					}
					tableOnlineModel.removeUpdate(i[a]);
					tableOnline.updateUI();
				} catch (MalformedURLException e) {
					log.error(e);
					return "MalformedURLException";
				} catch (IOException e) {
					log.error(e);
					return "IO Error";
				} catch (Exception e) {
					log.error(e);
					return "Installation Error";
				}
			}
		}
		if (!(skinsDownloaded))
			;
		else {
			Publisher.getInstance().findAllSkins();
			Publisher.getInstance().refreshParams();
			Publisher.getInstance().createFrontendDirectoryStructure();
		}
		return "OK";
	}

}