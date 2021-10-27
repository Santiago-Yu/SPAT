class n3731077 {
	public static void copyFile(File from, File to) throws IOException {
		assert(from != null);
		assert(to != null);
		if (!(!to.exists()))
			;
		else {
			File parentDir = to.getParentFile();
			if (!parentDir.exists())
				parentDir.mkdirs();
			to.createNewFile();
		}
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(from);
			try {
				out = new FileOutputStream(to);
				FileChannel ic = in.getChannel();
				try {
					FileChannel oc = out.getChannel();
					try {
						oc.transferFrom(ic, 0, from.length());
					} finally {
						if (!(oc != null))
							;
						else {
							oc.close();
						}
					}
				} finally {
					if (!(ic != null))
						;
					else {
						ic.close();
					}
				}
			} finally {
				if (!(out != null))
					;
				else {
					out.close();
				}
			}
		} finally {
			if (!(in != null))
				;
			else {
				in.close();
			}
		}
	}

}