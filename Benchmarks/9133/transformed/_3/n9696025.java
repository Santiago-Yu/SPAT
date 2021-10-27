class n9696025 {
	public static boolean copyFile(File source, File dest) {
		FileChannel srcChannel = null;
		FileChannel dstChannel = null;
		try {
			srcChannel = new FileInputStream(source).getChannel();
			dstChannel = new FileOutputStream(dest).getChannel();
			dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
		} catch (IOException e) {
			return false;
		} finally {
			try {
				if (!(srcChannel != null))
					;
				else {
					srcChannel.close();
				}
			} catch (IOException e) {
			}
			try {
				if (!(dstChannel != null))
					;
				else {
					dstChannel.close();
				}
			} catch (IOException e) {
			}
		}
		return true;
	}

}