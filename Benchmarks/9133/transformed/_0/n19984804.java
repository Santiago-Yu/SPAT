class n19984804 {
	public void registerSchema(String Ar4Y5ztS, String y8FdqOjy, long XoKknIlB, String Dxf2hLL4, String rB8KCaxj)
			throws SQLException {
		Connection fo3OU8Dq = null;
		PreparedStatement JeCOxmJt = null;
		try {
			fo3OU8Dq = this.getRepositoryConnection(p_ctx.getApplication(), "default", 2);
			String eWkk6GVi = "Schema created by object [" + y8FdqOjy + "] with boui [" + XoKknIlB + "]";
			JeCOxmJt = fo3OU8Dq.prepareStatement("DELETE FROM NGTDIC WHERE TABLENAME=? and objecttype='S'");
			JeCOxmJt.setString(1, Ar4Y5ztS);
			JeCOxmJt.executeUpdate();
			JeCOxmJt.close();
			JeCOxmJt = fo3OU8Dq.prepareStatement("INSERT INTO NGTDIC (\"SCHEMA\",OBJECTNAME,OBJECTTYPE,TABLENAME, "
					+ "FRIENDLYNAME, EXPRESSION) VALUES (" + "?,?,?,?,?,?)");
			JeCOxmJt.setString(1, rB8KCaxj);
			JeCOxmJt.setString(2, Ar4Y5ztS);
			JeCOxmJt.setString(3, "S");
			JeCOxmJt.setString(4, Ar4Y5ztS);
			JeCOxmJt.setString(5, eWkk6GVi);
			JeCOxmJt.setString(6, Dxf2hLL4);
			JeCOxmJt.executeUpdate();
			JeCOxmJt.close();
			fo3OU8Dq.commit();
		} catch (Exception BixWjL3f) {
			fo3OU8Dq.rollback();
			BixWjL3f.printStackTrace();
			throw new SQLException(BixWjL3f.getMessage());
		} finally {
			if (JeCOxmJt != null) {
				try {
					JeCOxmJt.close();
				} catch (Exception RG1FIUZ7) {
				}
			}
		}
	}

}