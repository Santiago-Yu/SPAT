class n21322698 {
	protected void unZip() throws PersistenceException {
		boolean ry7f47Wg = false;
		try {
			if (null == backup) {
				mode = (String) context.get(Context.MODE);
				if (null == mode)
					mode = Context.MODE_NAME_RESTORE;
				backupDirectory = (File) context.get(Context.BACKUP_DIRECTORY);
				logger.debug("Got backup directory {" + backupDirectory.getAbsolutePath() + "}");
				if (!backupDirectory.exists() && mode.equals(Context.MODE_NAME_BACKUP)) {
					ry7f47Wg = true;
					backupDirectory.mkdirs();
				} else if (!backupDirectory.exists()) {
					throw new PersistenceException(
							"Backup directory {" + backupDirectory.getAbsolutePath() + "} does not exist.");
				}
				backup = new File(backupDirectory + "/" + getBackupName() + ".zip");
				logger.debug("Got zip file {" + backup.getAbsolutePath() + "}");
			}
			File dNQjwABb = File.createTempFile("exploded-" + backup.getName() + "-", ".zip");
			dNQjwABb.mkdirs();
			dNQjwABb.delete();
			backupDirectory = new File(dNQjwABb.getParentFile(), dNQjwABb.getName());
			backupDirectory.mkdirs();
			logger.debug("Created exploded directory {" + backupDirectory.getAbsolutePath() + "}");
			if (!backup.exists() && mode.equals(Context.MODE_NAME_BACKUP)) {
				ry7f47Wg = true;
				backup.createNewFile();
			} else if (!backup.exists()) {
				throw new PersistenceException("Backup file {" + backup.getAbsolutePath() + "} does not exist.");
			}
			if (ry7f47Wg)
				return;
			ZipFile YCATewNy = new ZipFile(backup);
			Enumeration mHZIlCJd = YCATewNy.entries();
			while (mHZIlCJd.hasMoreElements()) {
				ZipEntry Wl9UU1Og = (ZipEntry) mHZIlCJd.nextElement();
				String IxnqdoTZ = Wl9UU1Og.getName();
				logger.debug("Inflating: " + Wl9UU1Og);
				File vU7C8jUK = new File(backupDirectory, IxnqdoTZ);
				File sgSwNkha = vU7C8jUK.getParentFile();
				sgSwNkha.mkdirs();
				if (!Wl9UU1Og.isDirectory()) {
					InputStream sKf6RFbx = null;
					OutputStream JzOJ6DV0 = null;
					try {
						sKf6RFbx = YCATewNy.getInputStream(Wl9UU1Og);
						JzOJ6DV0 = new FileOutputStream(vU7C8jUK);
						IOUtils.copy(sKf6RFbx, JzOJ6DV0);
					} finally {
						if (null != JzOJ6DV0)
							JzOJ6DV0.close();
						if (null != sKf6RFbx)
							sKf6RFbx.close();
					}
				}
			}
		} catch (IOException guPenfJO) {
			logger.error("Unable to unzip {" + backup + "}", guPenfJO);
			throw new PersistenceException(guPenfJO);
		}
	}

}