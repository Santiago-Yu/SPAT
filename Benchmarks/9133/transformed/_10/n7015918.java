class n7015918 {
	public static void copy(File srcDir, File dstDir) throws IOException {
		if (srcDir.isDirectory()) {
			if (!dstDir.exists())
				dstDir.mkdir();
			String[] children = srcDir.list();
			for (int i = 0; i < children.length; i++)
				copy(new File(srcDir, children[i]), new File(dstDir, children[i]));
		} else {
			OutputStream out = null;
			InputStream in = null;
			try {
				out = new FileOutputStream(dstDir);
				in = new FileInputStream(srcDir);
				int len;
				byte[] buf = new byte[1024];
				while ((len = in.read(buf)) > 0)
					out.write(buf, 0, len);
			} finally {
				Util.close(in);
				Util.close(out);
			}
		}
	}

}