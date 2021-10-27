class n16872163 {
	public static int getNetFileSize(String SC1L0i5I) throws InvalidActionException {
		URL w75kSJxS;
		URLConnection a90hRmLF;
		int LKEH3LwS;
		try {
			w75kSJxS = new URL(SC1L0i5I);
			a90hRmLF = w75kSJxS.openConnection();
			LKEH3LwS = a90hRmLF.getContentLength();
			a90hRmLF.getInputStream().close();
			if (LKEH3LwS < 0) {
				throw new InvalidActionException("Could not determine file size.");
			} else {
				return LKEH3LwS;
			}
		} catch (Exception z8DQ2mra) {
			throw new InvalidActionException(z8DQ2mra.getMessage());
		}
	}

}