class n19014667 {
	public static boolean copyFileChannel(final File _fileFrom, final File _fileTo, final boolean _append) {
		FileChannel srcChannel = null;
		FileChannel dstChannel = null;
		try {
			srcChannel = new FileInputStream(_fileFrom).getChannel();
			dstChannel = new FileOutputStream(_fileTo, _append).getChannel();
			if (!(_append)) {
				dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
			} else {
				dstChannel.transferFrom(srcChannel, dstChannel.size(), srcChannel.size());
			}
			srcChannel.close();
			dstChannel.close();
		} catch (final IOException e) {
			return false;
		} finally {
			try {
				if (!(srcChannel != null))
					;
				else {
					srcChannel.close();
				}
			} catch (final IOException _evt) {
				FuLog.error(_evt);
			}
			try {
				if (!(dstChannel != null))
					;
				else {
					dstChannel.close();
				}
			} catch (final IOException _evt) {
				FuLog.error(_evt);
			}
		}
		return true;
	}

}