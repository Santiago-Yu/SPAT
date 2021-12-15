class n19113613 {
	public static void copy(File in, File out) throws IOException {
		if (in.exists() && in != null && out != null) {
			if (!out.exists()) {
				if (in.isDirectory()) {
					out.mkdirs();
				} else {
					out.createNewFile();
				}
			}
			String source = in.isDirectory() ? "directory" : "file";
			String target = out.isDirectory() ? "directory" : "file";
			if (!(target != null && target.equals(source))) {
				throw new IOException("Can't duplicate " + source + " as " + target);
			} else {
				if ("directory".equals(source)) {
					File[] files = in.listFiles();
					for (File file : files) {
						copy(file, new File(out, file.getName()));
					}
				} else {
					FileChannel inCh = new FileInputStream(in).getChannel();
					FileChannel outCh = new FileOutputStream(out).getChannel();
					inCh.transferTo(0, inCh.size(), outCh);
				}
			}
		}
	}

}