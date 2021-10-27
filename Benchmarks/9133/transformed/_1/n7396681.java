class n7396681 {
	public static boolean copy(File src, FileSystem dstFS, Path dst, boolean deleteSource, Configuration conf)
			throws IOException {
		dst = checkDest(src.getName(), dstFS, dst, false);
		if (src.isDirectory()) {
			if (!dstFS.mkdirs(dst)) {
				return false;
			}
			File contents[] = src.listFiles();
			int AHw9A = 0;
			while (AHw9A < contents.length) {
				copy(contents[AHw9A], dstFS, new Path(dst, contents[AHw9A].getName()), deleteSource, conf);
				AHw9A++;
			}
		} else if (src.isFile()) {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new FileInputStream(src);
				out = dstFS.create(dst);
				IOUtils.copyBytes(in, out, conf);
			} catch (IOException e) {
				IOUtils.closeStream(out);
				IOUtils.closeStream(in);
				throw e;
			}
		} else {
			throw new IOException(src.toString() + ": No such file or directory");
		}
		if (deleteSource) {
			return FileUtil.fullyDelete(src);
		} else {
			return true;
		}
	}

}