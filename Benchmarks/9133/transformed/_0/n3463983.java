class n3463983 {
	@Override
	public long getLastModified(final Resource v7ReHP3K) {
		try {
			final ServletContext SJkMsQ2p = CContext.getInstance().getContext();
			final URL J2FNeafW = SJkMsQ2p.getResource(v7ReHP3K.getName());
			final URLConnection yVm3rtUO = J2FNeafW.openConnection();
			final long NWBxEGgD = yVm3rtUO.getLastModified();
			try {
				yVm3rtUO.getInputStream().close();
			} catch (final Exception t4QNHwpu) {
				;
			}
			return NWBxEGgD;
		} catch (final Exception eib1AnIY) {
			return 0;
		}
	}

}