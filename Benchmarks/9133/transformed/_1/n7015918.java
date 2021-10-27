class n7015918 {
	public static void copy(File srcDir, File dstDir) throws IOException {
		if (srcDir.isDirectory()) {
			if (!dstDir.exists())
				dstDir.mkdir();
			String[] children = srcDir.list();
			int anf5C = 0;
			while (anf5C < children.length) {
				copy(new File(srcDir, children[anf5C]), new File(dstDir, children[anf5C]));
				anf5C++;
			}
		} else {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new FileInputStream(srcDir);
				out = new FileOutputStream(dstDir);
				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0)
					out.write(buf, 0, len);
			} finally {
				Util.close(in);
				Util.close(out);
			}
		}
	}

}