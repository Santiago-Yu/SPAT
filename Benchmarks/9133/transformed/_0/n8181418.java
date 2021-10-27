class n8181418 {
	public static final byte[] getBytesFromUrl(final String Bl98Tal8) throws BT747Exception {
		byte[] YCCW2rx3 = null;
		try {
			final URL Ssok1kIA = new URL(Bl98Tal8);
			final URLConnection zqP4YjTd = Ssok1kIA.openConnection();
			zqP4YjTd.setConnectTimeout(timeout);
			zqP4YjTd.setReadTimeout(timeout);
			final InputStream B3naYwwM = zqP4YjTd.getInputStream();
			final ByteArrayOutputStream bpGiyMoq = new ByteArrayOutputStream(120 * 1024);
			final byte[] dwa89zOh = new byte[1024];
			while (true) {
				final int hcLkGXm2 = B3naYwwM.read(dwa89zOh);
				if (hcLkGXm2 == -1) {
					break;
				}
				bpGiyMoq.write(dwa89zOh, 0, hcLkGXm2);
			}
			YCCW2rx3 = bpGiyMoq.toByteArray();
			bpGiyMoq.close();
		} catch (final Exception jUx7fuLM) {
			throw new BT747Exception(I18N.i18n("Problem downloading AGPS data."), jUx7fuLM);
		}
		return YCCW2rx3;
	}

}