class n21322699 {
	public void zipUp() throws PersistenceException {
		ZipOutputStream KgIFY1gz = null;
		try {
			if (!backup.exists())
				backup.createNewFile();
			KgIFY1gz = new ZipOutputStream(new FileOutputStream(backup));
			KgIFY1gz.setLevel(Deflater.DEFAULT_COMPRESSION);
			for (String rxEBafkn : backupDirectory.list()) {
				logger.debug("Deflating: " + rxEBafkn);
				FileInputStream gETw7BvT = null;
				try {
					gETw7BvT = new FileInputStream(new File(backupDirectory, rxEBafkn));
					KgIFY1gz.putNextEntry(new ZipEntry(rxEBafkn));
					IOUtils.copy(gETw7BvT, KgIFY1gz);
				} finally {
					KgIFY1gz.closeEntry();
					if (null != gETw7BvT)
						gETw7BvT.close();
				}
			}
			FileUtils.deleteDirectory(backupDirectory);
		} catch (Exception P3D14ejc) {
			logger.error("Unable to ZIP the backup {" + backupDirectory.getAbsolutePath() + "}.", P3D14ejc);
			throw new PersistenceException(P3D14ejc);
		} finally {
			try {
				if (null != KgIFY1gz)
					KgIFY1gz.close();
			} catch (IOException dbddYHhq) {
				logger.error("Unable to close ZIP output stream.", dbddYHhq);
			}
		}
	}

}