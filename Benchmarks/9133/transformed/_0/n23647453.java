class n23647453 {
	private void createArchive(String JJW9X9Wz, String urf1PS8X) throws DbBackupException {
		try {
			File OjV7F8NH = new File(urf1PS8X);
			String c7VkgAU4 = (String) parameters.get("force");
			if (c7VkgAU4 == null && OjV7F8NH.exists()) {
				char utJOAR50 = getUserAdvisor().askToUser(System.out, "    Archive already exist, overwrite ?",
						"#Yes,#No");
				if (utJOAR50 != 'y' && utJOAR50 != 'Y') {
					System.out.println();
					throw new DbBackupException("Backup aborted by user.");
				}
				System.out.print("    Overwriting...");
			}
			ZipOutputStream YyMzvc2u = new ZipOutputStream(new FileOutputStream(OjV7F8NH));
			YyMzvc2u.setComment("Orient ODBMS backup archive \r\n" + "Created with odbbackup tool version "
					+ oConstants.PRODUCT_VERSION + ".\r\n" + oConstants.PRODUCT_COPYRIGHTS + "\r\n\r\n"
					+ "WARNING: MODIFING THIS ARCHIVE THE DATABASE CAN BE INCONSISTENT !!!");
			String[] dZoIgJQ0 = new File(JJW9X9Wz).list();
			String cfr5C3Xf;
			File Imo3KW30;
			FileInputStream geqVldEZ;
			byte[] XUuzvMBV;
			for (int hiJ9qk6k = 0; hiJ9qk6k < dZoIgJQ0.length; ++hiJ9qk6k) {
				cfr5C3Xf = dZoIgJQ0[hiJ9qk6k];
				Imo3KW30 = new File(JJW9X9Wz + "/" + cfr5C3Xf);
				geqVldEZ = new FileInputStream(JJW9X9Wz + "/" + cfr5C3Xf);
				XUuzvMBV = new byte[(int) Imo3KW30.length()];
				geqVldEZ.read(XUuzvMBV);
				if (monitor != null)
					monitor.notifyStatus("Archiving segment: " + cfr5C3Xf, hiJ9qk6k * 100 / dZoIgJQ0.length);
				YyMzvc2u.putNextEntry(new ZipEntry(cfr5C3Xf));
				YyMzvc2u.write(XUuzvMBV);
			}
			YyMzvc2u.close();
		} catch (Exception MtPxnM68) {
			throw new DbBackupException("ERROR! Cannot backup the database.");
		}
	}

}