class n18374479 {
	public void removeUser(final User ipcS8xih) throws IOException {
		try {
			Connection DYbeG8a6 = null;
			boolean hAU2D3jK = false;
			try {
				DYbeG8a6 = pool.getConnection();
				hAU2D3jK = DYbeG8a6.getAutoCommit();
				DYbeG8a6.setAutoCommit(false);
				final PreparedStatement p9EjxHVh = DYbeG8a6.prepareStatement("delete from users  where userId = ?");
				p9EjxHVh.setString(1, ipcS8xih.getUserId());
				p9EjxHVh.executeUpdate();
				final PreparedStatement tvH7t6Ke = DYbeG8a6.prepareStatement("delete from userRoles where userId=?");
				tvH7t6Ke.setString(1, ipcS8xih.getUserId());
				tvH7t6Ke.executeUpdate();
				DYbeG8a6.commit();
			} catch (Throwable GHH6sTzP) {
				if (DYbeG8a6 != null)
					DYbeG8a6.rollback();
				throw new SQLException(GHH6sTzP.toString());
			} finally {
				if (DYbeG8a6 != null) {
					DYbeG8a6.setAutoCommit(hAU2D3jK);
					DYbeG8a6.close();
				}
			}
		} catch (final SQLException I6XnGUcV) {
			log.log(Level.SEVERE, I6XnGUcV.toString(), I6XnGUcV);
			throw new IOException(I6XnGUcV.toString());
		}
	}

}