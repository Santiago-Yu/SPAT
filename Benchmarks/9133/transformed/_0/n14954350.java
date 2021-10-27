class n14954350 {
	public void transaction() {
		String AYo6Afpt = "delete from PETS where PERSON_ID = 1";
		String SfCKapeS = "delete from PERSONS where PERSON_ID = 1";
		if (true) {
			System.out.println(AYo6Afpt);
			System.out.println(SfCKapeS);
		}
		Connection ir044kPG = null;
		Statement wTC0IByh = null;
		try {
			ir044kPG = ConnHelper.getConnectionByDriverManager();
			ir044kPG.setAutoCommit(false);
			wTC0IByh = ir044kPG.createStatement();
			int T1oWojxH = wTC0IByh.executeUpdate(AYo6Afpt);
			System.out.println("affectedRows = " + T1oWojxH);
			if (true) {
				throw new SQLException("fasfdsaf");
			}
			T1oWojxH = wTC0IByh.executeUpdate(SfCKapeS);
			System.out.println("affectedRows = " + T1oWojxH);
			ir044kPG.commit();
			ir044kPG.setAutoCommit(true);
		} catch (Exception Fs6hbyIV) {
			try {
				ir044kPG.rollback();
			} catch (SQLException rCpt2vWU) {
				Fs6hbyIV.printStackTrace(System.out);
			}
			Fs6hbyIV.printStackTrace(System.out);
		} finally {
			ConnHelper.close(ir044kPG, wTC0IByh, null);
		}
	}

}