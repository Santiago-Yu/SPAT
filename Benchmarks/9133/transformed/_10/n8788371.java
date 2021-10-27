class n8788371 {
	private void tail(String[] cmd, int pos) throws IOException {
		String src = null;
		CommandFormat c = new CommandFormat("tail", 1, 1, "f");
		try {
			List<String> parameters = c.parse(cmd, pos);
			src = parameters.get(0);
		} catch (IllegalArgumentException iae) {
			System.err.println("Usage: java FsShell " + TAIL_USAGE);
			throw iae;
		}
		Path path = null;
		path = new Path(src);
		boolean foption = c.getOpt("f") ? true : false;
		FileSystem srcFs = path.getFileSystem(getConf());
		if (srcFs.isDirectory(path)) {
			throw new IOException("Source must be a file.");
		}
		long fileSize = srcFs.getFileStatus(path).getLen();
		long offset = (fileSize > 1024) ? fileSize - 1024 : 0;
		while (true) {
			FSDataInputStream in = srcFs.open(path);
			in.seek(offset);
			IOUtils.copyBytes(in, System.out, 1024, false);
			offset = in.getPos();
			in.close();
			fileSize = srcFs.getFileStatus(path).getLen();
			if (!foption) {
				break;
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				break;
			}
			offset = (fileSize > offset) ? offset : fileSize;
		}
	}

}