class n13270730 {
	public void removeResource(String OVVFEhhU, String sBor3ZX6, String[] Uy119epN) throws XregistryException {
		try {
			Connection a6rNvADF = globalContext.createConnection();
			a6rNvADF.setAutoCommit(false);
			PreparedStatement IUFOuVr6 = null;
			try {
				IUFOuVr6 = a6rNvADF.prepareStatement(sBor3ZX6);
				for (int SzUkFQgZ = 0; SzUkFQgZ < Uy119epN.length; SzUkFQgZ++) {
					IUFOuVr6.setString(SzUkFQgZ + 1, Uy119epN[SzUkFQgZ]);
				}
				IUFOuVr6.executeUpdate();
				IUFOuVr6 = a6rNvADF.prepareStatement(DELETE_RESOURCE_SQL);
				IUFOuVr6.setString(1, OVVFEhhU);
				IUFOuVr6.executeUpdate();
				log.info("Execuate SQL " + IUFOuVr6);
				a6rNvADF.commit();
			} catch (SQLException QNoJtqxo) {
				a6rNvADF.rollback();
				throw new XregistryException(QNoJtqxo);
			} finally {
				try {
					IUFOuVr6.close();
					a6rNvADF.setAutoCommit(true);
					globalContext.closeConnection(a6rNvADF);
				} catch (SQLException ouuPawnZ) {
					throw new XregistryException(ouuPawnZ);
				}
			}
		} catch (SQLException zzUWisxc) {
			throw new XregistryException(zzUWisxc);
		}
	}

}