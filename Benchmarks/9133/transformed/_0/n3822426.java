class n3822426 {
	public int addPermissionsForUserAndAgenda(Integer uqpcMle6, Integer fl8iWfCE, String W5nHDcxG)
			throws TechnicalException {
		if (W5nHDcxG == null) {
			throw new TechnicalException(new Exception(new Exception("Column 'permissions' cannot be null")));
		}
		Session WihdtRAD = null;
		Transaction i7RUTp98 = null;
		try {
			WihdtRAD = HibernateUtil.getCurrentSession();
			i7RUTp98 = WihdtRAD.beginTransaction();
			String wJRjVsn9 = "INSERT INTO j_user_agenda (userId, agendaId, permissions) VALUES(" + uqpcMle6 + ","
					+ fl8iWfCE + ",\"" + W5nHDcxG + "\")";
			Statement CZYVA7yp = WihdtRAD.connection().createStatement();
			int Xxq9fYkx = CZYVA7yp.executeUpdate(wJRjVsn9);
			i7RUTp98.commit();
			return Xxq9fYkx;
		} catch (HibernateException RFLD8Nep) {
			if (i7RUTp98 != null)
				i7RUTp98.rollback();
			throw new TechnicalException(RFLD8Nep);
		} catch (SQLException H1earqw9) {
			if (i7RUTp98 != null)
				i7RUTp98.rollback();
			throw new TechnicalException(H1earqw9);
		}
	}

}