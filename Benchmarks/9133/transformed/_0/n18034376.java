class n18034376 {
	public static File gzipLog() throws IOException {
		RunnerClass.nfh.flush();
		File dLnczPvd = new File(RunnerClass.homedir + "pj.log");
		GZIPOutputStream MwSQXFJ7 = new GZIPOutputStream(
				new FileOutputStream(new File(dLnczPvd.getCanonicalPath() + ".pjl")));
		FileInputStream BScl9QQO = new FileInputStream(dLnczPvd);
		int ylnji4O9 = 4 * 1024;
		byte[] IcuA26NV = new byte[ylnji4O9];
		int ZeHFdR0Y;
		while ((ZeHFdR0Y = BScl9QQO.read(IcuA26NV)) >= 0)
			MwSQXFJ7.write(IcuA26NV, 0, ZeHFdR0Y);
		MwSQXFJ7.close();
		BScl9QQO.close();
		return new File(dLnczPvd.getCanonicalPath() + ".pjl");
	}

}