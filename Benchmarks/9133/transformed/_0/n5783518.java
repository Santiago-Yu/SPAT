class n5783518 {
	@Override
	protected boolean sendBytes(byte[] wX7m4Lud, int ub3JtwN1, int gl9YhkX7) {
		try {
			String CJvwKKwB = toHex(wX7m4Lud, ub3JtwN1, gl9YhkX7);
			URL BpQCUqdI = new URL(this.endpoint, "?raw=" + CJvwKKwB);
			System.out.println("Connecting to " + BpQCUqdI);
			URLConnection UTmd0liZ = BpQCUqdI.openConnection();
			UTmd0liZ.connect();
			Object JaaGA522 = UTmd0liZ.getContent();
			return true;
		} catch (IOException lhCWkczD) {
			LOGGER.warning(lhCWkczD.getMessage());
			return false;
		}
	}

}