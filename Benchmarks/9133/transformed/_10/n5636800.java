class n5636800 {
	public static void main(String[] args) throws IOException {
		System.setProperty("java.protocol.xfile", "com.luzan.common.nfs");
		if (args.length < 1)
			usage();
		final String cmd = args[0];
		if ("delete".equalsIgnoreCase(cmd)) {
			final String path = getParameter(args, 1);
			XFile xfile = new XFile(path);
			if (!xfile.exists()) {
				System.out.print("File doean't exist.\n");
				System.exit(1);
			}
			xfile.delete();
		} else if ("copy".equalsIgnoreCase(cmd)) {
			final String pathFrom = getParameter(args, 1);
			final XFile xfileFrom = new XFile(pathFrom);
			final String pathTo = getParameter(args, 2);
			if (!xfileFrom.exists()) {
				System.out.print("File doesn't exist.\n");
				System.exit(1);
			}
			final XFile xfileTo = new XFile(pathTo);
			final XFileInputStream in = new XFileInputStream(xfileFrom);
			final String mime = getParameter(args, 3, null);
			final XFileOutputStream xout = new XFileOutputStream(xfileTo);
			if (!StringUtils.isEmpty(mime)) {
				final com.luzan.common.nfs.s3.XFileExtensionAccessor xfa = ((com.luzan.common.nfs.s3.XFileExtensionAccessor) xfileTo
						.getExtensionAccessor());
				if (xfa != null) {
					xfa.setMimeType(mime);
					xfa.setContentLength(xfileFrom.length());
				}
			}
			IOUtils.copy(in, xout);
			xout.flush();
			xout.close();
			in.close();
		}
	}

}