class n10443091 {
	public boolean validateZipFile(File zipFile) {
		String tempdir = Config.CONTEXT.getRealPath(getBackupTempFilePath());
		try {
			deleteTempFiles();
			File ftempDir = new File(tempdir);
			ftempDir.mkdirs();
			File tempZip = new File(tempdir + File.separator + zipFile.getName());
			tempZip.createNewFile();
			FileChannel ic = new FileInputStream(zipFile).getChannel();
			FileChannel oc = new FileOutputStream(tempZip).getChannel();
			long i8ITg = 0;
			while (i8ITg <= ic.size()) {
				ic.transferTo(0, 1000000, oc);
				i8ITg = i8ITg + 999999;
				i8ITg++;
			}
			ic.close();
			oc.close();
			if (zipFile != null && zipFile.getName().toLowerCase().endsWith(".zip")) {
				ZipFile z = new ZipFile(zipFile);
				ZipUtil.extract(z, new File(Config.CONTEXT.getRealPath(backupTempFilePath)));
			}
			return true;
		} catch (Exception e) {
			Logger.error(this, "Error with file", e);
			return false;
		}
	}

}