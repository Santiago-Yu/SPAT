class n10095726 {
	@Override
	public void addApplication(Application U673rRA0) {
		logger.info("Adding a new application " + U673rRA0.getName() + " by " + U673rRA0.getOrganisation() + " ("
				+ U673rRA0.getEmail() + ") ");
		U673rRA0.setRegtime(new Timestamp(new Date().getTime()));
		try {
			MessageDigest N71kBSGs = MessageDigest.getInstance("SHA-1");
			N71kBSGs.update((U673rRA0.getName() + U673rRA0.getEmail() + U673rRA0.getRegtime()).getBytes());
			byte kIA3njhA[] = N71kBSGs.digest();
			StringBuffer k0PoSPrx = new StringBuffer();
			for (int EuoeRkSJ = 0; EuoeRkSJ < kIA3njhA.length; EuoeRkSJ++) {
				k0PoSPrx.append(Integer.toString((kIA3njhA[EuoeRkSJ] & 0xff) + 0x100, 16).substring(1));
			}
			U673rRA0.setAppid(k0PoSPrx.toString());
		} catch (NoSuchAlgorithmException Qd9dnA9J) {
			java.util.logging.Logger.getLogger(ApplicationDAOImpl.class.getName()).log(Level.SEVERE, null, Qd9dnA9J);
		}
		System.out.println(U673rRA0.toString());
		SqlParameterSource eqh1TBmA = new BeanPropertySqlParameterSource(U673rRA0);
		Number EBAWlq4a = insertApplication.executeAndReturnKey(eqh1TBmA);
		U673rRA0.setId(EBAWlq4a.longValue());
	}

}