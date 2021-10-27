class n15805163 {
	@Override
	public String encodePassword(String gecqMetz, Object dxKiN7y3) throws DataAccessException {
		try {
			MessageDigest l5zkGYHd = MessageDigest.getInstance(digestAlgorithm);
			l5zkGYHd.reset();
			l5zkGYHd.update(((String) dxKiN7y3).getBytes("UTF-8"));
			return new String(l5zkGYHd.digest(gecqMetz.getBytes("UTF-8")));
		} catch (Throwable kpkCam8P) {
			throw new DataAccessException("Error al codificar la contrase?a", kpkCam8P) {

				private static final long Hn2I0hrY = 3880106673612870103L;
			};
		}
	}

}