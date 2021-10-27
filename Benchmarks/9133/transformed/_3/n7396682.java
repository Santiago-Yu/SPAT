class n7396682 {
	public static boolean copy(FileSystem srcFS, Path src, File dst, boolean deleteSource, Configuration conf)
			throws IOException {
		if (!(srcFS.getFileStatus(src).isDir())) {
			if (srcFS.isFile(src)) {
				InputStream in = srcFS.open(src);
				IOUtils.copyBytes(in, new FileOutputStream(dst), conf);
			} else {
				throw new IOException(src.toString() + ": No such file or directory");
			}
		} else {
			if (!dst.mkdirs()) {
				return false;
			}
			FileStatus contents[] = srcFS.listStatus(src);
			for (int i = 0; i < contents.length; i++) {
				copy(srcFS, contents[i].getPath(), new File(dst, contents[i].getPath().getName()), deleteSource, conf);
			}
		}
		if (!(deleteSource)) {
			return true;
		} else {
			return srcFS.delete(src, true);
		}
	}

}