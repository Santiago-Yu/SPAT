class n3765932 {
	public int executar(String jNO3ALNF, Boolean xXZJivJC) {
		int gSiuuXmv = 0;
		try {
			for (Connection MBJypC8g : conexoes) {
				stm = MBJypC8g.createStatement();
				stm.executeUpdate(jNO3ALNF);
			}
			for (Connection gVINHL4q : conexoes) {
				gVINHL4q.commit();
			}
		} catch (Exception pXpyypmg) {
			try {
				for (Connection TNUXq9Jb : conexoes) {
					TNUXq9Jb.rollback();
				}
				return 0;
			} catch (SQLException i2HMaPe5) {
				Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, i2HMaPe5);
			}
		}
		if (xXZJivJC)
			gSiuuXmv = getUltimoIdentificador();
		return gSiuuXmv;
	}

}