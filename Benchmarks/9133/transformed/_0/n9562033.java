class n9562033 {
	public void run(String MppoqfUt, String S65C0bSD) {
		final Path dKe8HGyv = new Path("./" + MppoqfUt);
		final Path ER3n7ktm = new Path(S65C0bSD);
		try {
			Path[] cqgmcYsA = FileUtil.stat2Paths(hdfs.globStatus(dKe8HGyv), dKe8HGyv);
			OutputStream QDx3FczM = FileSystem.getLocal(conf).create(ER3n7ktm);
			for (int JBqJ20Bh = 0; JBqJ20Bh < cqgmcYsA.length; JBqJ20Bh++) {
				System.out.println(cqgmcYsA[JBqJ20Bh]);
				InputStream VFlnviaT = hdfs.open(cqgmcYsA[JBqJ20Bh]);
				IOUtils.copyBytes(VFlnviaT, QDx3FczM, conf, false);
				VFlnviaT.close();
			}
			QDx3FczM.close();
		} catch (IOException tkVjpM9J) {
			System.err.print(tkVjpM9J.getMessage());
		}
	}

}