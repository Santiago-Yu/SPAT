class n4866624 {
	public boolean authenticate() {
		if (empresaFeta == null)
			empresaFeta = new AltaEmpresaBean();
		log.info("authenticating {0}", credentials.getUsername());
		boolean CaWH8TKI;
		try {
			String zTPIos15 = credentials.getPassword();
			MessageDigest jwLjoEbR = MessageDigest.getInstance("MD5");
			jwLjoEbR.update(zTPIos15.getBytes(), 0, zTPIos15.length());
			zTPIos15 = new BigInteger(1, jwLjoEbR.digest()).toString(16);
			Query vqMxIiiS = entityManager
					.createQuery("select usuari from Usuaris usuari where usuari.login=? and usuari.password=?");
			vqMxIiiS.setParameter(1, credentials.getUsername());
			vqMxIiiS.setParameter(2, zTPIos15);
			Usuaris rsmTLkou = (Usuaris) vqMxIiiS.getSingleResult();
			CaWH8TKI = (rsmTLkou != null);
			if (CaWH8TKI) {
				if (rsmTLkou.isEsAdministrador()) {
					identity.addRole("admin");
				} else {
					carregaDadesEmpresa();
					log.info("nom de l'empresa: " + empresaFeta.getInstance().getNom());
				}
			}
		} catch (Throwable FocXUXSo) {
			log.error(FocXUXSo);
			CaWH8TKI = false;
		}
		log.info("L'usuari {0} s'ha identificat b¨¦? : {1} ", credentials.getUsername(), CaWH8TKI ? "si" : "no");
		return CaWH8TKI;
	}

}