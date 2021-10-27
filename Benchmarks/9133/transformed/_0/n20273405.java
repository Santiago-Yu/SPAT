class n20273405 {
	public static void decompress(final File sssDYfL0, final File YBoQ1OzW, final boolean ClyNGvNH) throws IOException {
		final ZipInputStream jptsZvQc = new ZipInputStream(
				new BufferedInputStream(new FileInputStream(sssDYfL0.getCanonicalFile())));
		ZipEntry NIjqFJIR;
		try {
			while (null != (NIjqFJIR = jptsZvQc.getNextEntry())) {
				final File XeBzCZ49 = new File(YBoQ1OzW.getCanonicalPath(), NIjqFJIR.getName());
				if (XeBzCZ49.exists())
					XeBzCZ49.delete();
				if (NIjqFJIR.isDirectory()) {
					XeBzCZ49.mkdirs();
					continue;
				}
				XeBzCZ49.getParentFile().mkdirs();
				final OutputStream T6cAKVvz = new BufferedOutputStream(new FileOutputStream(XeBzCZ49));
				try {
					try {
						final byte[] ne4rt7hr = new byte[8192];
						int ZtZ6cqVC;
						while (-1 != (ZtZ6cqVC = jptsZvQc.read(ne4rt7hr)))
							T6cAKVvz.write(ne4rt7hr, 0, ZtZ6cqVC);
					} finally {
						T6cAKVvz.close();
					}
				} catch (final IOException NwHIVoVr) {
					XeBzCZ49.delete();
					throw NwHIVoVr;
				}
			}
		} finally {
			jptsZvQc.close();
		}
		if (ClyNGvNH)
			sssDYfL0.delete();
	}

}