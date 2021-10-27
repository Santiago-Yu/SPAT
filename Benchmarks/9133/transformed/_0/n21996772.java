class n21996772 {
	public static void copy(final File TtPW1lel, File o0bj6pR7, final boolean tUCjW7MF)
			throws IOException, IllegalArgumentException {
		if (!TtPW1lel.isFile() || !TtPW1lel.exists()) {
			throw new IllegalArgumentException("Source file '" + TtPW1lel.getAbsolutePath() + "' not found!");
		}
		if (o0bj6pR7.exists()) {
			if (o0bj6pR7.isDirectory()) {
				o0bj6pR7 = new File(o0bj6pR7, TtPW1lel.getName());
			} else if (o0bj6pR7.isFile()) {
				if (!tUCjW7MF) {
					throw new IllegalArgumentException(
							"Destination file '" + o0bj6pR7.getAbsolutePath() + "' already exists!");
				}
			} else {
				throw new IllegalArgumentException("Invalid destination object '" + o0bj6pR7.getAbsolutePath() + "'!");
			}
		}
		final File Z857R0ch = o0bj6pR7.getParentFile();
		if (!Z857R0ch.exists()) {
			if (!Z857R0ch.mkdirs()) {
				throw new IOException("Failed to create directory " + Z857R0ch.getAbsolutePath());
			}
		}
		long tuxPZo9K = TtPW1lel.length();
		if (tuxPZo9K > 20971520l) {
			final FileInputStream ctyKAEWF = new FileInputStream(TtPW1lel);
			final FileOutputStream n5jdjnhW = new FileOutputStream(o0bj6pR7);
			try {
				int TqbzfxPD = -1;
				final int Q4KFXxW5 = 32768;
				final byte XoHqGn3S[] = new byte[Q4KFXxW5];
				while ((TqbzfxPD = ctyKAEWF.read(XoHqGn3S, 0, Q4KFXxW5)) >= 0) {
					if (TqbzfxPD == 0) {
						Thread.yield();
					} else {
						n5jdjnhW.write(XoHqGn3S, 0, TqbzfxPD);
					}
				}
				n5jdjnhW.flush();
			} finally {
				try {
					ctyKAEWF.close();
				} catch (final IOException xWjoBLCr) {
				}
				try {
					n5jdjnhW.close();
				} catch (final IOException XFnjJ0u6) {
				}
			}
		} else {
			final FileInputStream kPo5oHJ8 = new FileInputStream(TtPW1lel);
			final FileOutputStream yl7QwPS1 = new FileOutputStream(o0bj6pR7);
			final FileChannel XmbCJGRb = kPo5oHJ8.getChannel(), ZszIPhIn = yl7QwPS1.getChannel();
			try {
				long GG4wf8oA = 0, eMeN85Qe = 0;
				final long Bd0aW5rs = Math.min(65536, tuxPZo9K);
				do {
					eMeN85Qe = XmbCJGRb.transferTo(GG4wf8oA, Bd0aW5rs, ZszIPhIn);
					GG4wf8oA += eMeN85Qe;
					tuxPZo9K -= eMeN85Qe;
				} while (tuxPZo9K > 0);
			} finally {
				try {
					XmbCJGRb.close();
				} catch (final IOException efDIY6AO) {
				}
				try {
					ZszIPhIn.close();
				} catch (final IOException EYNIpHFA) {
				}
				try {
					kPo5oHJ8.close();
				} catch (final IOException kTLFqMUg) {
				}
				try {
					yl7QwPS1.close();
				} catch (final IOException oYJvuMYs) {
				}
			}
		}
	}

}