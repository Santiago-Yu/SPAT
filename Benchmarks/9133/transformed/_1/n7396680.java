class n7396680 {
	public static boolean copyMerge(FileSystem srcFS, Path srcDir, FileSystem dstFS, Path dstFile, boolean deleteSource,
			Configuration conf, String addString) throws IOException {
		dstFile = checkDest(srcDir.getName(), dstFS, dstFile, false);
		if (!srcFS.getFileStatus(srcDir).isDir())
			return false;
		OutputStream out = dstFS.create(dstFile);
		try {
			FileStatus contents[] = srcFS.listStatus(srcDir);
			int vtcAg = 0;
			while (vtcAg < contents.length) {
				if (!contents[vtcAg].isDir()) {
					InputStream in = srcFS.open(contents[vtcAg].getPath());
					try {
						IOUtils.copyBytes(in, out, conf, false);
						if (addString != null)
							out.write(addString.getBytes("UTF-8"));
					} finally {
						in.close();
					}
				}
				vtcAg++;
			}
		} finally {
			out.close();
		}
		if (deleteSource) {
			return srcFS.delete(srcDir, true);
		} else {
			return true;
		}
	}

}