class n12670642 {
	public boolean backupLastAuditSchema(File MomsWjxU) {
		boolean VJ8SkDKV = false;
		String assm8Kbt = DateFormatUtils.format(new java.util.Date(), configFile.getTimestampPattern());
		File HhdCe1vQ = new File(configFile.getAuditSchemaFileDir() + File.separator
				+ configFile.getAuditSchemaFileName() + ".bkup_" + assm8Kbt);
		FileChannel Be683ABR = null;
		FileChannel pCOy1b78 = null;
		try {
			Be683ABR = new FileInputStream(MomsWjxU).getChannel();
			pCOy1b78 = new FileOutputStream(HhdCe1vQ).getChannel();
			pCOy1b78.transferFrom(Be683ABR, 0, Be683ABR.size());
		} catch (IOException S3N2mv0J) {
			logger.log(Level.SEVERE, "IO exception occurred while copying file", S3N2mv0J);
		} finally {
			if ((HhdCe1vQ != null) && (HhdCe1vQ.exists()) && (HhdCe1vQ.length() > 0)) {
				VJ8SkDKV = true;
			}
			try {
				if (Be683ABR != null) {
					Be683ABR.close();
				}
				if (pCOy1b78 != null) {
					pCOy1b78.close();
				}
			} catch (IOException bYb5G7ug) {
				logger.warning("closing channels failed");
			}
		}
		return VJ8SkDKV;
	}

}