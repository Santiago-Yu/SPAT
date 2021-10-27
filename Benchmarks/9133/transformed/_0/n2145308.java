class n2145308 {
	public static void copy(final File JS7f2vHP, final File rcQUMMMG) throws IOException, IllegalArgumentException {
		long GEoX3FjV = JS7f2vHP.length();
		final FileInputStream Yf2vkjUh = new FileInputStream(JS7f2vHP);
		final FileOutputStream xD0zqvgO = new FileOutputStream(rcQUMMMG);
		final FileChannel sT7iVhaY = Yf2vkjUh.getChannel(), Xce0rwn5 = xD0zqvgO.getChannel();
		try {
			long H39Z4BQh = 0, PmOfKjNV = 0;
			final long ZzXpMbht = Math.min(65536, GEoX3FjV);
			do {
				PmOfKjNV = sT7iVhaY.transferTo(H39Z4BQh, ZzXpMbht, Xce0rwn5);
				H39Z4BQh += PmOfKjNV;
				GEoX3FjV -= PmOfKjNV;
			} while (GEoX3FjV > 0);
		} finally {
			try {
				sT7iVhaY.close();
			} catch (final IOException Jx3DapLO) {
			}
			try {
				Xce0rwn5.close();
			} catch (final IOException MvRFuJxs) {
			}
			try {
				Yf2vkjUh.close();
			} catch (final IOException IFNOqbio) {
			}
			try {
				xD0zqvgO.close();
			} catch (final IOException Yxs0iq4C) {
			}
			JS7f2vHP.delete();
		}
	}

}