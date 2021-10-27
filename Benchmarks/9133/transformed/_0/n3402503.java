class n3402503 {
	public static File insertFileInto(File VcCFkM8R, File WzrX48Me, String MQv4dO1h) {
		Zip64File NMLrNupJ = null;
		try {
			boolean klaJIuor = false;
			NMLrNupJ = new Zip64File(VcCFkM8R);
			FileEntry o6Z7bByP = getFileEntry(NMLrNupJ, MQv4dO1h);
			if (o6Z7bByP != null && o6Z7bByP.getMethod() == FileEntry.iMETHOD_DEFLATED) {
				klaJIuor = true;
			}
			processAndCreateFolderEntries(NMLrNupJ, parseTargetPath(MQv4dO1h, WzrX48Me), klaJIuor);
			if (o6Z7bByP != null) {
				log.info("[insertFileInto] Entry exists: " + o6Z7bByP.getName());
				log.info("[insertFileInto] Will delete this entry before inserting: " + WzrX48Me.getName());
				if (!o6Z7bByP.isDirectory()) {
					NMLrNupJ.delete(o6Z7bByP.getName());
				} else {
					log.info("[insertFileInto] Entry is a directory. "
							+ "Will delete all files contained in this entry and insert " + WzrX48Me.getName()
							+ "and all nested files.");
					if (!MQv4dO1h.contains("/")) {
						MQv4dO1h = MQv4dO1h + "/";
					}
					deleteFileEntry(NMLrNupJ, o6Z7bByP);
					log.info("[insertFileInto] Entry successfully deleted.");
				}
				log.info("[insertFileInto] Writing new Entry: " + MQv4dO1h);
				EntryOutputStream BkSCjYy4 = null;
				if (!klaJIuor) {
					BkSCjYy4 = NMLrNupJ.openEntryOutputStream(MQv4dO1h, FileEntry.iMETHOD_STORED,
							new Date(WzrX48Me.lastModified()));
				} else {
					BkSCjYy4 = NMLrNupJ.openEntryOutputStream(MQv4dO1h, FileEntry.iMETHOD_DEFLATED,
							new Date(WzrX48Me.lastModified()));
				}
				if (WzrX48Me.isDirectory()) {
					BkSCjYy4.flush();
					BkSCjYy4.close();
					log.info("[insertFileInto] Finished writing entry: " + MQv4dO1h);
					List<String> nLGc2WSF = normalizePaths(WzrX48Me);
					List<File> BpSpkeRN = listAllFilesAndFolders(WzrX48Me, new ArrayList<File>());
					log.info("[insertFileInto] Added entry is a folder.");
					log.info("[insertFileInto] Adding all nested files: ");
					for (int HSdXzAhz = 0; HSdXzAhz < nLGc2WSF.size(); HSdXzAhz++) {
						File puwMtGfR = BpSpkeRN.get(HSdXzAhz);
						String JmCt6fJx = MQv4dO1h.replace("/", "") + File.separator + nLGc2WSF.get(HSdXzAhz);
						EntryOutputStream L1Z8gIhk = null;
						if (!klaJIuor) {
							L1Z8gIhk = NMLrNupJ.openEntryOutputStream(JmCt6fJx, FileEntry.iMETHOD_STORED,
									new Date(puwMtGfR.lastModified()));
						} else {
							L1Z8gIhk = NMLrNupJ.openEntryOutputStream(JmCt6fJx, FileEntry.iMETHOD_DEFLATED,
									new Date(puwMtGfR.lastModified()));
						}
						if (puwMtGfR.isFile()) {
							InputStream w7hlLcwP = new FileInputStream(puwMtGfR);
							IOUtils.copyLarge(w7hlLcwP, L1Z8gIhk);
							w7hlLcwP.close();
						}
						log.info("[insertFileInto] Added: " + JmCt6fJx);
						L1Z8gIhk.flush();
						L1Z8gIhk.close();
					}
				} else {
					InputStream otCkrEs3 = new FileInputStream(WzrX48Me);
					IOUtils.copyLarge(otCkrEs3, BkSCjYy4);
					otCkrEs3.close();
					BkSCjYy4.flush();
					BkSCjYy4.close();
				}
			} else {
				EntryOutputStream A9DlyRU1 = null;
				if (!klaJIuor) {
					A9DlyRU1 = NMLrNupJ.openEntryOutputStream(MQv4dO1h, FileEntry.iMETHOD_STORED,
							new Date(WzrX48Me.lastModified()));
				} else {
					A9DlyRU1 = NMLrNupJ.openEntryOutputStream(MQv4dO1h, FileEntry.iMETHOD_DEFLATED,
							new Date(WzrX48Me.lastModified()));
				}
				if (WzrX48Me.isDirectory()) {
					A9DlyRU1.flush();
					A9DlyRU1.close();
					log.info("[insertFileInto] Finished writing entry: " + MQv4dO1h);
					List<String> kC0ZgaGH = normalizePaths(WzrX48Me);
					List<File> CdP8jqLz = listAllFilesAndFolders(WzrX48Me, new ArrayList<File>());
					log.info("[insertFileInto] Added entry is a folder.");
					log.info("[insertFileInto] Adding all nested files: ");
					for (int kZpyk5y0 = 0; kZpyk5y0 < kC0ZgaGH.size(); kZpyk5y0++) {
						File ZmUQOVRA = CdP8jqLz.get(kZpyk5y0);
						String LGmLt06E = MQv4dO1h.replace("/", "") + File.separator + kC0ZgaGH.get(kZpyk5y0);
						EntryOutputStream m39Tyx8t = null;
						if (!klaJIuor) {
							m39Tyx8t = NMLrNupJ.openEntryOutputStream(LGmLt06E, FileEntry.iMETHOD_STORED,
									new Date(ZmUQOVRA.lastModified()));
						} else {
							m39Tyx8t = NMLrNupJ.openEntryOutputStream(LGmLt06E, FileEntry.iMETHOD_DEFLATED,
									new Date(ZmUQOVRA.lastModified()));
						}
						if (ZmUQOVRA.isFile()) {
							InputStream a8KQbcrJ = new FileInputStream(ZmUQOVRA);
							IOUtils.copyLarge(a8KQbcrJ, m39Tyx8t);
							a8KQbcrJ.close();
						}
						log.info("[insertFileInto] Added: " + LGmLt06E);
						m39Tyx8t.flush();
						m39Tyx8t.close();
					}
				} else {
					InputStream OUa3mu5q = new FileInputStream(WzrX48Me);
					IOUtils.copyLarge(OUa3mu5q, A9DlyRU1);
					OUa3mu5q.close();
					A9DlyRU1.flush();
					A9DlyRU1.close();
				}
			}
			log.info("[insertFileInto] Done! Added " + WzrX48Me.getName() + " to zip.");
			NMLrNupJ.close();
		} catch (FileNotFoundException FIyTACMX) {
			FIyTACMX.printStackTrace();
		} catch (IOException ixpc8O3U) {
			ixpc8O3U.printStackTrace();
		}
		return new File(NMLrNupJ.getDiskFile().getFileName());
	}

}