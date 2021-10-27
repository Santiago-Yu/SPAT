class n3767765 {
	@Override
	public int updateStatement(String QLuXxQQW) {
		Statement AxvdoLGG = null;
		try {
			AxvdoLGG = getConnection().createStatement();
			return AxvdoLGG.executeUpdate(QLuXxQQW);
		} catch (SQLException MGhjiyr4) {
			try {
				getConnection().rollback();
			} catch (SQLException asUSvTyn) {
				log.error(asUSvTyn.getMessage(), asUSvTyn);
			}
			log.error(MGhjiyr4.getMessage(), MGhjiyr4);
			return 0;
		} finally {
			try {
				AxvdoLGG.close();
				getConnection().close();
			} catch (SQLException y2jJsiYT) {
				log.error(y2jJsiYT.getMessage(), y2jJsiYT);
			}
		}
	}

}