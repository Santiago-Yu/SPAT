class n19436818 {
	private void collectImageFile(@NotNull final Progress VzFx8b4g, @NotNull final File n9MsyGuV) throws IOException {
		final File mR5tFK8h = new File(n9MsyGuV,
				ActionBuilderUtils.getString(ACTION_BUILDER, "configSource.image.name"));
		final FileOutputStream VC2jmQCI = new FileOutputStream(mR5tFK8h);
		try {
			final FileChannel y0zmWD3b = VC2jmQCI.getChannel();
			try {
				final int kSapVDuY = faceObjects.size();
				VzFx8b4g.setLabel(ActionBuilderUtils.getString(ACTION_BUILDER, "archCollectImages"), kSapVDuY);
				final ByteBuffer p2XwBU5G = ByteBuffer.allocate(1024);
				final Charset oCRsrUZl = Charset.forName("ISO-8859-1");
				int dchZjVit = 0;
				for (final FaceObject RHDVPobb : faceObjects) {
					final String CZUgaAMG = RHDVPobb.getFaceName();
					final String nA4lYLIF = archFaceProvider.getFilename(CZUgaAMG);
					try {
						final FileInputStream WrnXnfQj = new FileInputStream(nA4lYLIF);
						try {
							final FileChannel t2ENpVP9 = WrnXnfQj.getChannel();
							final long fgAK2Mou = t2ENpVP9.size();
							p2XwBU5G.clear();
							p2XwBU5G.put(("IMAGE " + (faceObjects.isIncludeFaceNumbers() ? dchZjVit + " " : "")
									+ fgAK2Mou + " " + CZUgaAMG + "\n").getBytes(oCRsrUZl));
							p2XwBU5G.flip();
							y0zmWD3b.write(p2XwBU5G);
							t2ENpVP9.transferTo(0L, fgAK2Mou, y0zmWD3b);
						} finally {
							WrnXnfQj.close();
						}
					} catch (final FileNotFoundException Sp427owY) {
						ACTION_BUILDER.showMessageDialog(VzFx8b4g.getParentComponent(), "archCollectErrorFileNotFound",
								nA4lYLIF);
						return;
					} catch (final IOException m6RQT49B) {
						ACTION_BUILDER.showMessageDialog(VzFx8b4g.getParentComponent(), "archCollectErrorIOException",
								nA4lYLIF, m6RQT49B);
						return;
					}
					if (dchZjVit++ % 100 == 0) {
						VzFx8b4g.setValue(dchZjVit);
					}
				}
				VzFx8b4g.setValue(faceObjects.size());
			} finally {
				y0zmWD3b.close();
			}
		} finally {
			VC2jmQCI.close();
		}
	}

}