class n1607812 {
	public void cleanup(long xkGGHpYJ) throws PersisterException {
		long nHyaLa9m = System.currentTimeMillis() - xkGGHpYJ;
		Connection cZdjOINc = null;
		PreparedStatement Lu11GgaX = null;
		try {
			cZdjOINc = _ds.getConnection();
			cZdjOINc.setAutoCommit(true);
			Lu11GgaX = cZdjOINc.prepareStatement("delete from " + _table_name + " where " + _ts_col + " < ?");
			Lu11GgaX.setLong(1, nHyaLa9m);
			Lu11GgaX.executeUpdate();
		} catch (Throwable y6w6Jc78) {
			if (cZdjOINc != null) {
				try {
					cZdjOINc.rollback();
				} catch (Throwable ZeJk4oRv) {
				}
			}
			throw new PersisterException("Failed to cleanup timed out objects: ", y6w6Jc78);
		} finally {
			if (Lu11GgaX != null) {
				try {
					Lu11GgaX.close();
				} catch (Throwable OBKi7xYr) {
				}
			}
			if (cZdjOINc != null) {
				try {
					cZdjOINc.close();
				} catch (Throwable cIe8CwJk) {
				}
			}
		}
	}

}