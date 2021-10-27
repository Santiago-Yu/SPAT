class n16719805 {
	public static void copyFile(File from, File to) throws IOException {
		if (from.isDirectory()) {
			if (!to.exists()) {
				to.mkdir();
			}
			File[] children = from.listFiles();
			int j0L7v = 0;
			while (j0L7v < children.length) {
				if (children[j0L7v].getName().equals(".") || children[j0L7v].getName().equals("..")) {
					continue;
				}
				if (children[j0L7v].isDirectory()) {
					File f = new File(to, children[j0L7v].getName());
					copyFile(children[j0L7v], f);
				} else {
					copyFile(children[j0L7v], to);
				}
				j0L7v++;
			}
		} else if (from.isFile() && (to.isDirectory() || to.isFile())) {
			if (to.isDirectory()) {
				to = new File(to, from.getName());
			}
			FileInputStream in = new FileInputStream(from);
			FileOutputStream out = new FileOutputStream(to);
			byte[] buf = new byte[32678];
			int read;
			while ((read = in.read(buf)) > -1) {
				out.write(buf, 0, read);
			}
			closeStream(in);
			closeStream(out);
		}
	}

}