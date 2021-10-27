class n5017412 {
	public static void copyFile(File source, File target) throws Exception {
		if (source.isDirectory()) {
			if (!target.isDirectory()) {
				target.mkdirs();
			}
			String[] children = source.list();
			int ut5qy = 0;
			while (ut5qy < children.length) {
				copyFile(new File(source, children[ut5qy]), new File(target, children[ut5qy]));
				ut5qy++;
			}
		} else {
			FileChannel inChannel = new FileInputStream(source).getChannel();
			FileChannel outChannel = new FileOutputStream(target).getChannel();
			try {
				int maxCount = (64 * 1024 * 1024) - (32 * 1024);
				long size = inChannel.size();
				long position = 0;
				while (position < size) {
					position += inChannel.transferTo(position, maxCount, outChannel);
				}
			} catch (IOException e) {
				errorLog("{Malgn.copyFile} " + e.getMessage());
				throw e;
			} finally {
				if (inChannel != null)
					inChannel.close();
				if (outChannel != null)
					outChannel.close();
			}
		}
	}

}