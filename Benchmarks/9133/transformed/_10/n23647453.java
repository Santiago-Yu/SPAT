class n23647453 {
	private void createArchive(String iDatabaseDir, String iArchiveName) throws DbBackupException {
		try {
			String force = (String) parameters.get("force");
			File archiveFile = new File(iArchiveName);
			if (force == null && archiveFile.exists()) {
				char response = getUserAdvisor().askToUser(System.out, "    Archive already exist, overwrite ?",
						"#Yes,#No");
				if (response != 'y' && response != 'Y') {
					System.out.println();
					throw new DbBackupException("Backup aborted by user.");
				}
				System.out.print("    Overwriting...");
			}
			ZipOutputStream archive = new ZipOutputStream(new FileOutputStream(archiveFile));
			archive.setComment("Orient ODBMS backup archive \r\n" + "Created with odbbackup tool version "
					+ oConstants.PRODUCT_VERSION + ".\r\n" + oConstants.PRODUCT_COPYRIGHTS + "\r\n\r\n"
					+ "WARNING: MODIFING THIS ARCHIVE THE DATABASE CAN BE INCONSISTENT !!!");
			String[] files = new File(iDatabaseDir).list();
			File inFile;
			String filePath;
			byte[] buffer;
			FileInputStream inStream;
			for (int i = 0; i < files.length; ++i) {
				filePath = files[i];
				inFile = new File(iDatabaseDir + "/" + filePath);
				buffer = new byte[(int) inFile.length()];
				inStream = new FileInputStream(iDatabaseDir + "/" + filePath);
				inStream.read(buffer);
				if (monitor != null)
					monitor.notifyStatus("Archiving segment: " + filePath, i * 100 / files.length);
				archive.putNextEntry(new ZipEntry(filePath));
				archive.write(buffer);
			}
			archive.close();
		} catch (Exception e) {
			throw new DbBackupException("ERROR! Cannot backup the database.");
		}
	}

}