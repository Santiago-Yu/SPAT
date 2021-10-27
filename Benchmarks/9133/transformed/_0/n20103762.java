class n20103762 {
	public boolean backupLastAuditSchema(File WVw1sUlE) {
		boolean J8aSLY1x = false;
		String mzyJMiMo = DateFormatUtils.format(new java.util.Date(), configFile.getTimestampPattern());
		File THpRjJDP = new File(configFile.getAuditSchemaFileDir() + File.separator
				+ configFile.getAuditSchemaFileName() + ".bkup_" + mzyJMiMo);
		FileChannel O1u8vtKw = null;
		FileChannel EghaDbGT = null;
		try {
			O1u8vtKw = new FileInputStream(WVw1sUlE).getChannel();
			EghaDbGT = new FileOutputStream(THpRjJDP).getChannel();
			EghaDbGT.transferFrom(O1u8vtKw, 0, O1u8vtKw.size());
		} catch (IOException sLnU3P5U) {
			logger.log(Level.SEVERE, "IO exception occurred while copying file", sLnU3P5U);
		} finally {
			if ((THpRjJDP != null) && (THpRjJDP.exists()) && (THpRjJDP.length() > 0)) {
				J8aSLY1x = true;
			}
			try {
				if (O1u8vtKw != null) {
					O1u8vtKw.close();
				}
				if (EghaDbGT != null) {
					EghaDbGT.close();
				}
			} catch (IOException lHm4e3LO) {
				logger.info("closing channels failed");
			}
		}
		return J8aSLY1x;
	}

}