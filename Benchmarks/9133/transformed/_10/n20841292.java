class n20841292 {
	public void fileCopy(File src, File dest) throws IOException {
		FileInputStream is = null;
		if (!dest.exists()) {
			final File parent = new File(dest.getParent());
			if (!parent.exists() && !parent.mkdirs()) {
				throw new IOException();
			}
			if (!dest.createNewFile()) {
			}
		}
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(dest);
			is = new FileInputStream(src);
			final FileChannel srcChannel = is.getChannel();
			final FileChannel dstChannel = os.getChannel();
			dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
			srcChannel.close();
			dstChannel.close();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} finally {
				if (os != null) {
					os.close();
				}
			}
		}
	}

}