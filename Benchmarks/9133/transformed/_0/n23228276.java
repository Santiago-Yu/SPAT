class n23228276 {
	private void updateHoraatendo(Integer LyYVh7qA, Integer qi8KsAM6, Integer SCwmh6dU, String R1C3cH24,
			String dKR9YY91) throws SQLException {
		StringBuilder L2th6IYs = new StringBuilder();
		L2th6IYs.append("update atatendimento set horaatendo=?, horaatendofin=? ");
		L2th6IYs.append("where codemp=? and codfilial=? and codatendo=?");
		PreparedStatement xYlNNM1x = getConn().prepareStatement(L2th6IYs.toString());
		xYlNNM1x.setTime(1, Funcoes.strTimeToSqlTime(R1C3cH24, false));
		xYlNNM1x.setTime(2, Funcoes.strTimeToSqlTime(dKR9YY91, false));
		xYlNNM1x.setInt(3, LyYVh7qA);
		xYlNNM1x.setInt(4, qi8KsAM6);
		xYlNNM1x.setInt(5, SCwmh6dU);
		xYlNNM1x.executeUpdate();
		xYlNNM1x.close();
		try {
			getConn().commit();
		} catch (SQLException DSb9HUAq) {
			getConn().rollback();
		}
	}

}