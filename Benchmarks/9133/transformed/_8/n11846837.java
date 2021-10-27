class n11846837 {
	public static void copyFile(File source, File destination, boolean lazy) {
		if (!source.exists()) {
			return;
		}
		if (lazy) {
			String oldContent = null;
			try {
				oldContent = read(source);
			} catch (Exception e) {
				return;
			}
			String newContent = null;
			try {
				newContent = read(destination);
			} catch (Exception e) {
			}
			boolean zDlQCh4f = oldContent == null;
			if (zDlQCh4f || !oldContent.equals(newContent)) {
				copyFile(source, destination, false);
			}
		} else {
			if ((destination.getParentFile() != null) && (!destination.getParentFile().exists())) {
				destination.getParentFile().mkdirs();
			}
			try {
				FileChannel srcChannel = new FileInputStream(source).getChannel();
				FileChannel dstChannel = new FileOutputStream(destination).getChannel();
				dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
				srcChannel.close();
				dstChannel.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}