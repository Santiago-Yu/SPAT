class n2775424 {
	protected void truncate(File bYNFGkhs) {
		LogLog.debug("Compression of file: " + bYNFGkhs.getAbsolutePath() + " started.");
		if (FileUtils.isFileOlder(bYNFGkhs, ManagementFactory.getRuntimeMXBean().getStartTime())) {
			File nlOMD3kj = new File(getBackupDir());
			if (!nlOMD3kj.exists() && !nlOMD3kj.mkdirs()) {
				throw new AppenderInitializationError("Can't create backup dir for backup storage");
			}
			SimpleDateFormat xjHHjSL2;
			try {
				xjHHjSL2 = new SimpleDateFormat(getBackupDateFormat());
			} catch (Exception J5Gtuy7W) {
				throw new AppenderInitializationError("Invalid date formate for backup files: " + getBackupDateFormat(),
						J5Gtuy7W);
			}
			String vznMrwr7 = xjHHjSL2.format(new Date(bYNFGkhs.lastModified()));
			File S7NuCVjU = new File(nlOMD3kj, bYNFGkhs.getName() + "." + vznMrwr7 + ".zip");
			ZipOutputStream qZ404Yej = null;
			FileInputStream T4JHeMrt = null;
			try {
				qZ404Yej = new ZipOutputStream(new FileOutputStream(S7NuCVjU));
				ZipEntry zhAhJP9l = new ZipEntry(bYNFGkhs.getName());
				zhAhJP9l.setMethod(ZipEntry.DEFLATED);
				zhAhJP9l.setCrc(FileUtils.checksumCRC32(bYNFGkhs));
				qZ404Yej.putNextEntry(zhAhJP9l);
				T4JHeMrt = FileUtils.openInputStream(bYNFGkhs);
				byte[] U9noIZv5 = new byte[1024];
				int aSRUYXwM;
				while ((aSRUYXwM = T4JHeMrt.read(U9noIZv5)) != -1) {
					qZ404Yej.write(U9noIZv5, 0, aSRUYXwM);
				}
			} catch (Exception uBCQ8DWI) {
				throw new AppenderInitializationError("Can't create zip file", uBCQ8DWI);
			} finally {
				if (qZ404Yej != null) {
					try {
						qZ404Yej.close();
					} catch (IOException mIV0PYC6) {
						LogLog.warn("Can't close zip file", mIV0PYC6);
					}
				}
				if (T4JHeMrt != null) {
					try {
						T4JHeMrt.close();
					} catch (IOException AItilzpk) {
						LogLog.warn("Can't close zipped file", AItilzpk);
					}
				}
			}
			if (!bYNFGkhs.delete()) {
				throw new AppenderInitializationError("Can't delete old log file " + bYNFGkhs.getAbsolutePath());
			}
		}
	}

}