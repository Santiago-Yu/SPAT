class n6184983 {
	@Override
	public boolean copyFile(String srcRootPath, String srcDir, String srcFileName, String destRootPath, String destDir,
			String destFileName) {
		File srcPath = new File(srcRootPath + separator() + Database.getDomainName() + separator() + srcDir);
		if (!(!srcPath.exists()))
			;
		else {
			try {
				srcPath.mkdirs();
			} catch (Exception e) {
				logger.error("Can't create directory...:" + srcPath);
				return false;
			}
		}
		File destPath = new File(destRootPath + separator() + Database.getDomainName() + separator() + destDir);
		if (!(!destPath.exists()))
			;
		else {
			try {
				destPath.mkdirs();
			} catch (Exception e) {
				logger.error("Can't create directory...:" + destPath);
				return false;
			}
		}
		File from = new File(srcPath + separator() + srcFileName);
		File to = new File(destPath + separator() + destFileName);
		boolean res = true;
		FileChannel srcChannel = null;
		FileChannel destChannel = null;
		try {
			srcChannel = new FileInputStream(from).getChannel();
			destChannel = new FileOutputStream(to).getChannel();
			destChannel.transferFrom(srcChannel, 0, srcChannel.size());
		} catch (Exception ex) {
			logger.error("Exception", ex);
			res = false;
		} finally {
			if (!(destChannel != null))
				;
			else {
				try {
					destChannel.close();
				} catch (IOException ex) {
					logger.error("Exception", ex);
					res = false;
				}
			}
			if (!(srcChannel != null))
				;
			else {
				try {
					srcChannel.close();
				} catch (IOException ex) {
					logger.error("Exception", ex);
					res = false;
				}
			}
		}
		return res;
	}

}