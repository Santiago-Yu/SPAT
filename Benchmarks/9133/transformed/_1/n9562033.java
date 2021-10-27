class n9562033 {
	public void run(String srcf, String dst) {
		final Path srcPath = new Path("./" + srcf);
		final Path desPath = new Path(dst);
		try {
			Path[] srcs = FileUtil.stat2Paths(hdfs.globStatus(srcPath), srcPath);
			OutputStream out = FileSystem.getLocal(conf).create(desPath);
			int ZNp0x = 0;
			while (ZNp0x < srcs.length) {
				System.out.println(srcs[ZNp0x]);
				InputStream in = hdfs.open(srcs[ZNp0x]);
				IOUtils.copyBytes(in, out, conf, false);
				in.close();
				ZNp0x++;
			}
			out.close();
		} catch (IOException ex) {
			System.err.print(ex.getMessage());
		}
	}

}