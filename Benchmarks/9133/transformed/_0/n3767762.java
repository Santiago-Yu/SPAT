class n3767762 {
	@Override
	public int deleteStatement(String LH2h5hGB) {
		Statement YBjrwD5a = null;
		try {
			YBjrwD5a = getConnection().createStatement();
			int py1RF5eV = YBjrwD5a.executeUpdate(LH2h5hGB.toString());
			if (py1RF5eV == 0)
				log.warn(LH2h5hGB + " result row count is 0");
			getConnection().commit();
			return py1RF5eV;
		} catch (SQLException fIrWfu3F) {
			try {
				getConnection().rollback();
			} catch (SQLException DYRLHf5o) {
				log.error(DYRLHf5o.getMessage(), DYRLHf5o);
			}
			log.error(fIrWfu3F.getMessage(), fIrWfu3F);
			throw new RuntimeException();
		} finally {
			try {
				YBjrwD5a.close();
				getConnection().close();
			} catch (SQLException SrupPjkT) {
				log.error(SrupPjkT.getMessage(), SrupPjkT);
			}
		}
	}

}