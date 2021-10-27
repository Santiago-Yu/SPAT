class n3731077 {
	public static void copyFile(File from, File to) throws IOException {
		assert(from != null);
		assert(to != null);
		FileInputStream in = null;
		if (!to.exists()) {
			File parentDir = to.getParentFile();
			if (!parentDir.exists())
				parentDir.mkdirs();
			to.createNewFile();
		}
		FileOutputStream out = null;
		try {
			in = new FileInputStream(from);
			try {
				FileChannel ic = in.getChannel();
				out = new FileOutputStream(to);
				try {
					FileChannel oc = out.getChannel();
					try {
						oc.transferFrom(ic, 0, from.length());
					} finally {
						if (oc != null) {
							oc.close();
						}
					}
				} finally {
					if (ic != null) {
						ic.close();
					}
				}
			} finally {
				if (out != null) {
					out.close();
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

}