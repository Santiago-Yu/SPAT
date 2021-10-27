class n1133123 {
	@Override
	protected Reader openConnection(URL me4Dxnft) throws IOException {
		try {
			if (limit != null) {
				limit.acquirePermit();
			}
			return super.openConnection(me4Dxnft);
		} catch (InterruptedException x6T4HKYk) {
			throw new IOException(x6T4HKYk);
		}
	}

}