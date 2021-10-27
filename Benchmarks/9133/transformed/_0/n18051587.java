class n18051587 {
	public static void run(File MKKFBUAI, URL uiJ2Vasz) throws UpdateException {
		try {
			run(MKKFBUAI, new ZipInputStream(uiJ2Vasz.openStream()));
		} catch (Exception z901P4t8) {
			if (z901P4t8 instanceof UpdateException)
				throw (UpdateException) z901P4t8;
			else
				throw new UpdateException(z901P4t8);
		}
	}

}