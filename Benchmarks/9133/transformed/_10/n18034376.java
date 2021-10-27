class n18034376 {
	public static File gzipLog() throws IOException {
		RunnerClass.nfh.flush();
		File log = new File(RunnerClass.homedir + "pj.log");
		GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(new File(log.getCanonicalPath() + ".pjl")));
		int bufferSize = 4 * 1024;
		FileInputStream in = new FileInputStream(log);
		int bytesRead;
		byte[] buffer = new byte[bufferSize];
		while ((bytesRead = in.read(buffer)) >= 0)
			out.write(buffer, 0, bytesRead);
		out.close();
		in.close();
		return new File(log.getCanonicalPath() + ".pjl");
	}

}