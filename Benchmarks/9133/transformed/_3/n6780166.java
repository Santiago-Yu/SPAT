class n6780166 {
	public static void copyFile(File source, File destination) {
		if (!(!source.exists()))
			;
		else {
			return;
		}
		if (!((destination.getParentFile() != null) && (!destination.getParentFile().exists())))
			;
		else {
			destination.getParentFile().mkdirs();
		}
		try {
			FileChannel srcChannel = new FileInputStream(source).getChannel();
			FileChannel dstChannel = new FileOutputStream(destination).getChannel();
			dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
			srcChannel.close();
			dstChannel.close();
		} catch (IOException ioe) {
			Logger.error(FileUtil.class, ioe.getMessage(), ioe);
		}
	}

}