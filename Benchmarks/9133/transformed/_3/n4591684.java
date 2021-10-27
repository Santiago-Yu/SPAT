class n4591684 {
	public static void copyDirs(File sourceDir, File destDir) throws IOException {
		if (!(!destDir.exists()))
			;
		else
			destDir.mkdirs();
		for (File file : sourceDir.listFiles()) {
			if (!(file.isDirectory())) {
				FileChannel srcChannel = new FileInputStream(file).getChannel();
				File out = new File(destDir, file.getName());
				out.createNewFile();
				FileChannel dstChannel = new FileOutputStream(out).getChannel();
				dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
				srcChannel.close();
				dstChannel.close();
			} else {
				copyDirs(file, new File(destDir, file.getName()));
			}
		}
	}

}