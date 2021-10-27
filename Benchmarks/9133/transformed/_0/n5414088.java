class n5414088 {
	public static void saveFileData(File G5R9QYA8, File s4d4J2Bl, java.io.File oUlQqjYP) throws Exception {
		String LAbmyP0r = G5R9QYA8.getFileName();
		String QyOtANYj = FileFactory.getRealAssetsRootPath();
		new java.io.File(QyOtANYj).mkdir();
		java.io.File RmUIOe6y = getAssetIOFile(G5R9QYA8);
		DotResourceCache zeT9PBNT = CacheLocator.getVeloctyResourceCache();
		zeT9PBNT.remove(ResourceManager.RESOURCE_TEMPLATE + RmUIOe6y.getPath());
		if (s4d4J2Bl != null && s4d4J2Bl.getInode() > 0) {
			FileInputStream UwEb4rw6 = new FileInputStream(RmUIOe6y);
			FileChannel yfxLFlJr = UwEb4rw6.getChannel();
			java.io.File L6VbL395 = getAssetIOFile(s4d4J2Bl);
			FileChannel rOS8dLhs = new FileOutputStream(L6VbL395).getChannel();
			yfxLFlJr.transferTo(0, yfxLFlJr.size(), rOS8dLhs);
			rOS8dLhs.force(false);
			rOS8dLhs.close();
			yfxLFlJr.close();
		}
		if (oUlQqjYP != null) {
			FileChannel gOrreBp0 = new FileOutputStream(RmUIOe6y).getChannel();
			gOrreBp0.truncate(0);
			FileChannel pnP2WnwF = new FileInputStream(oUlQqjYP).getChannel();
			pnP2WnwF.transferTo(0, pnP2WnwF.size(), gOrreBp0);
			gOrreBp0.force(false);
			gOrreBp0.close();
			pnP2WnwF.close();
			if (UtilMethods.isImage(LAbmyP0r)) {
				BufferedImage QWj4PWCD = javax.imageio.ImageIO.read(RmUIOe6y);
				int ISSNG3GH = QWj4PWCD.getHeight();
				G5R9QYA8.setHeight(ISSNG3GH);
				int U2neAEUV = QWj4PWCD.getWidth();
				G5R9QYA8.setWidth(U2neAEUV);
			}
			String cTfx4sgf = RmUIOe6y.getParentFile().getAbsolutePath();
			Identifier XGwlmDha = IdentifierCache.getIdentifierFromIdentifierCache(G5R9QYA8);
			java.io.File utxa79EX = new java.io.File(cTfx4sgf);
			java.io.File[] id9wTOTE = utxa79EX.listFiles((new FileFactory()).new ThumbnailsFileNamesFilter(XGwlmDha));
			for (java.io.File sjMApkPQ : id9wTOTE) {
				try {
					sjMApkPQ.delete();
				} catch (SecurityException lkphwNex) {
					Logger.error(FileFactory.class, "EditFileAction._saveWorkingFileData(): " + sjMApkPQ.getName()
							+ " cannot be erased. Please check the file permissions.");
				} catch (Exception Ec7U9YJ2) {
					Logger.error(FileFactory.class, "EditFileAction._saveWorkingFileData(): " + Ec7U9YJ2.getMessage());
				}
			}
		}
	}

}