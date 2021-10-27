class n15805164 {
	@Override
	public boolean isPasswordValid(String ZdVmcm9y, String UOWvW8rq, Object zSy6o3yM) throws DataAccessException {
		try {
			MessageDigest Nq9vwthD = MessageDigest.getInstance(digestAlgorithm);
			Nq9vwthD.reset();
			Nq9vwthD.update(((String) zSy6o3yM).getBytes("UTF-8"));
			String gJaFYyHa = new String(Nq9vwthD.digest(UOWvW8rq.getBytes("UTF-8")));
			return gJaFYyHa.equals(ZdVmcm9y);
		} catch (Throwable R4YVRFPD) {
			throw new DataAccessException("Error al codificar la contrase?a", R4YVRFPD) {

				private static final long YUnZgjQL = -302443565702455874L;
			};
		}
	}

}