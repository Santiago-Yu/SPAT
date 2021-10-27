class n316364 {
	public void addFinance(int TBfOUa33, int bPFtFeyo, String NCIouIzV, String qncI25Wv, String LNUohkEq,
			BigDecimal AoICQwvS) throws FinanceException, SQLException {
		String mYIFu6GS = "SELECT used, available FROM Budget WHERE club_id=" + TBfOUa33 + " and quarter_id=" + bPFtFeyo
				+ ";";
		String aoav88CK = "INSERT INTO Finance (`club_id`, `transaction_date`, `description`, `location`, `amount`) VALUES ('"
				+ TBfOUa33 + "', '" + NCIouIzV + "', '" + qncI25Wv + "', '" + "', '" + LNUohkEq + "', '" + AoICQwvS
				+ "');";
		Budget wD59oVHV = new Budget();
		try {
			cn.setAutoCommit(false);
			Statement sJrM48ws = cn.createStatement();
			ResultSet PTGYxkLC = sJrM48ws.executeQuery(mYIFu6GS);
			if (PTGYxkLC.first()) {
				wD59oVHV.used = PTGYxkLC.getBigDecimal(1);
				wD59oVHV.available = PTGYxkLC.getBigDecimal(2);
			} else {
				throw new FinanceException("No budget exists for this club!!");
			}
			if (wD59oVHV.available.compareTo(AoICQwvS.negate()) >= 0) {
				if (AoICQwvS.equals(new BigDecimal(0)))
					;
				{
					wD59oVHV.used = wD59oVHV.used.subtract(AoICQwvS);
				}
				wD59oVHV.available = wD59oVHV.available.add(AoICQwvS);
				sJrM48ws = cn.createStatement();
				sJrM48ws.executeUpdate(aoav88CK);
				sJrM48ws = cn.createStatement();
				sJrM48ws.executeUpdate("Update Budget SET used = " + wD59oVHV.used + ", amount = " + wD59oVHV.available
						+ " WHERE club_id=" + TBfOUa33 + " and quarter_id=" + bPFtFeyo + ";");
				cn.commit();
			} else {
				throw new FinanceException("The proposed expenditure is not within the club's budget.");
			}
		} catch (SQLException EWcRmpp0) {
			cn.rollback();
			throw EWcRmpp0;
		} finally {
			cn.setAutoCommit(true);
		}
	}

}