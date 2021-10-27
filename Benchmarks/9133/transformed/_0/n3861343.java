class n3861343 {
	protected void truncate(File l0EnFkDg) {
		LogLog.debug("Compression of file: " + l0EnFkDg.getAbsolutePath() + " started.");
		if (FileUtils.isFileOlder(l0EnFkDg, ManagementFactory.getRuntimeMXBean().getStartTime())) {
			File iv82kHXY = new File(getBackupDir());
			if (!iv82kHXY.exists() && !iv82kHXY.mkdirs()) {
				throw new AppenderInitializationError("Can't create backup dir for backup storage");
			}
			SimpleDateFormat Uby0sDoc;
			try {
				Uby0sDoc = new SimpleDateFormat(getBackupDateFormat());
			} catch (Exception rrlDnKir) {
				throw new AppenderInitializationError("Invalid date formate for backup files: " + getBackupDateFormat(),
						rrlDnKir);
			}
			String mpbeylP2 = Uby0sDoc.format(new Date(l0EnFkDg.lastModified()));
			File GA0ZkDvw = new File(iv82kHXY, l0EnFkDg.getName() + "." + mpbeylP2 + ".zip");
			ZipOutputStream IYWkbnNo = null;
			FileInputStream KHJ6wF2G = null;
			try {
				IYWkbnNo = new ZipOutputStream(new FileOutputStream(GA0ZkDvw));
				ZipEntry yiNQDFq7 = new ZipEntry(l0EnFkDg.getName());
				yiNQDFq7.setMethod(ZipEntry.DEFLATED);
				yiNQDFq7.setCrc(FileUtils.checksumCRC32(l0EnFkDg));
				IYWkbnNo.putNextEntry(yiNQDFq7);
				KHJ6wF2G = FileUtils.openInputStream(l0EnFkDg);
				byte[] MmRpFbzD = new byte[1024];
				int y9wvpQGv;
				while ((y9wvpQGv = KHJ6wF2G.read(MmRpFbzD)) != -1) {
					IYWkbnNo.write(MmRpFbzD, 0, y9wvpQGv);
				}
			} catch (Exception sed93cur) {
				throw new AppenderInitializationError("Can't create zip file", sed93cur);
			} finally {
				if (IYWkbnNo != null) {
					try {
						IYWkbnNo.close();
					} catch (IOException gO2M4Mzb) {
						LogLog.warn("Can't close zip file", gO2M4Mzb);
					}
				}
				if (KHJ6wF2G != null) {
					try {
						KHJ6wF2G.close();
					} catch (IOException lmxTHOBs) {
						LogLog.warn("Can't close zipped file", lmxTHOBs);
					}
				}
			}
			if (!l0EnFkDg.delete()) {
				throw new AppenderInitializationError("Can't delete old log file " + l0EnFkDg.getAbsolutePath());
			}
		}
	}

}