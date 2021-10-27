class n13351146 {
	public static void copy(final File rc8kH81J, File VZErAqSg, final boolean JFjeHCIe)
			throws IOException, IllegalArgumentException {
		if (!rc8kH81J.isFile() || !rc8kH81J.exists()) {
			throw new IllegalArgumentException("Source file '" + rc8kH81J.getAbsolutePath() + "' not found!");
		}
		if (VZErAqSg.exists()) {
			if (VZErAqSg.isDirectory()) {
				VZErAqSg = new File(VZErAqSg, rc8kH81J.getName());
			} else if (VZErAqSg.isFile()) {
				if (!JFjeHCIe) {
					throw new IllegalArgumentException(
							"Destination file '" + VZErAqSg.getAbsolutePath() + "' already exists!");
				}
			} else {
				throw new IllegalArgumentException("Invalid destination object '" + VZErAqSg.getAbsolutePath() + "'!");
			}
		}
		final File LmVkoJ7O = VZErAqSg.getParentFile();
		if (!LmVkoJ7O.exists()) {
			if (!LmVkoJ7O.mkdirs()) {
				throw new IOException("Failed to create directory " + LmVkoJ7O.getAbsolutePath());
			}
		}
		long sWzHhvkB = rc8kH81J.length();
		if (sWzHhvkB > 20971520l) {
			final FileInputStream OcgD8n0M = new FileInputStream(rc8kH81J);
			final FileOutputStream lUFc1e9N = new FileOutputStream(VZErAqSg);
			try {
				int QgXU5A7V = -1;
				final int zE0eypMq = 32768;
				final byte ehUWZwa2[] = new byte[zE0eypMq];
				while ((QgXU5A7V = OcgD8n0M.read(ehUWZwa2, 0, zE0eypMq)) >= 0) {
					if (QgXU5A7V == 0) {
						Thread.yield();
					} else {
						lUFc1e9N.write(ehUWZwa2, 0, QgXU5A7V);
					}
				}
				lUFc1e9N.flush();
			} finally {
				try {
					OcgD8n0M.close();
				} catch (final IOException xvl6Zenf) {
				}
				try {
					lUFc1e9N.close();
				} catch (final IOException qJ4STq4z) {
				}
			}
		} else {
			final FileInputStream yMOCcKHj = new FileInputStream(rc8kH81J);
			final FileOutputStream gt9DApPz = new FileOutputStream(VZErAqSg);
			final FileChannel jW7HgA4n = yMOCcKHj.getChannel(), Mx5yii6c = gt9DApPz.getChannel();
			try {
				long d7L0CoEq = 0, sWcbrSzV = 0;
				final long yjsWUMKc = Math.min(65536, sWzHhvkB);
				do {
					sWcbrSzV = jW7HgA4n.transferTo(d7L0CoEq, yjsWUMKc, Mx5yii6c);
					d7L0CoEq += sWcbrSzV;
					sWzHhvkB -= sWcbrSzV;
				} while (sWzHhvkB > 0);
			} finally {
				try {
					jW7HgA4n.close();
				} catch (final IOException qgZcMLvv) {
				}
				try {
					Mx5yii6c.close();
				} catch (final IOException WVVJFtdS) {
				}
				try {
					yMOCcKHj.close();
				} catch (final IOException wGEuPeuE) {
				}
				try {
					gt9DApPz.close();
				} catch (final IOException TjGN6FID) {
				}
			}
		}
	}

}