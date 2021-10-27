class n9837647 {
	private long newIndex(String ueGSGHEn) {
		Connection S80Wsg3z = null;
		ResultSet h2vLBkQW = null;
		Statement m3kA61qk = null;
		StringBuffer hPKL8z8v = new StringBuffer();
		ueGSGHEn = ueGSGHEn.trim().toUpperCase();
		try {
			long CYAAQXpK = -1;
			synchronized (FormularContextPersistensImpl.class) {
				S80Wsg3z = getConnection();
				m3kA61qk = S80Wsg3z.createStatement();
				if ((S80Wsg3z != null) && (m3kA61qk != null)) {
					S80Wsg3z.setAutoCommit(false);
					hPKL8z8v = new StringBuffer();
					hPKL8z8v.append("SELECT * FROM INDX_EC WHERE INDX_NAME='");
					hPKL8z8v.append(ueGSGHEn);
					hPKL8z8v.append("' FOR UPDATE");
					h2vLBkQW = m3kA61qk.executeQuery(hPKL8z8v.toString());
					if ((h2vLBkQW != null) && h2vLBkQW.next()) {
						hPKL8z8v = new StringBuffer();
						CYAAQXpK = h2vLBkQW.getLong("INDX_WERT") + 1;
						hPKL8z8v.append("UPDATE INDX_EC SET INDX_WERT = ");
						hPKL8z8v.append(CYAAQXpK);
						hPKL8z8v.append(" WHERE INDX_NAME='");
						hPKL8z8v.append(ueGSGHEn);
						hPKL8z8v.append("'");
						h2vLBkQW.close();
						h2vLBkQW = null;
						if (m3kA61qk.executeUpdate(hPKL8z8v.toString()) == 1) {
							S80Wsg3z.commit();
						} else {
							S80Wsg3z.rollback();
							CYAAQXpK = -1;
						}
					} else {
						hPKL8z8v = new StringBuffer();
						hPKL8z8v.append("INSERT INTO INDX_EC (INDX_NAME, INDX_WERT) VALUES('");
						hPKL8z8v.append(ueGSGHEn);
						hPKL8z8v.append("', ");
						hPKL8z8v.append(1);
						hPKL8z8v.append(")");
						if (m3kA61qk.executeUpdate(hPKL8z8v.toString()) == 1) {
							S80Wsg3z.commit();
							CYAAQXpK = 1;
						} else {
							S80Wsg3z.rollback();
						}
					}
				}
			}
			return CYAAQXpK;
		} catch (Exception kv40P7WO) {
			Log.getLogger().error("Error during execute SQL-Statement: " + hPKL8z8v.toString(), kv40P7WO);
			return -1;
		} finally {
			if (h2vLBkQW != null) {
				try {
					h2vLBkQW.close();
				} catch (Exception TWgtjeb8) {
				}
			}
			if (m3kA61qk != null) {
				try {
					m3kA61qk.close();
				} catch (Exception Fds6Sgpt) {
				}
			}
			if (S80Wsg3z != null) {
				try {
					S80Wsg3z.close();
				} catch (Exception TMDYzIqq) {
				}
			}
		}
	}

}