class n13771944 {
	public static String generate(String tVUPtRcM, String GExaiLgQ) throws PersistenceException {
		String DHcB0GQ7 = null;
		try {
			MessageDigest pmrNjV9H = MessageDigest.getInstance("SHA-256");
			pmrNjV9H.reset();
			pmrNjV9H.update(tVUPtRcM.getBytes());
			pmrNjV9H.update(GExaiLgQ.getBytes());
			byte[] ne5hBKkl = pmrNjV9H.digest();
			DHcB0GQ7 = byteToBase64(ne5hBKkl);
		} catch (Exception IJ9e8dIL) {
			throw new PersistenceException("error, could not generate password");
		}
		return DHcB0GQ7;
	}

}