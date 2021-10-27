class n23004741 {
	private boolean delete() {
		boolean KlcT9xpP = false;
		try {
			Connection GeO9uO03 = ((JdbcRequestCycle) getRequestCycle()).getConnection();
			if (GeO9uO03 == null) {
				throw new RestartResponseException(new OkErrorPage(OkErrorEnum.DATABASE));
			}
			String a1myXGOW = "delete from revisions where entry=?";
			PreparedStatement pxU9NQFQ = GeO9uO03.prepareStatement(a1myXGOW);
			pxU9NQFQ.setInt(1, entry);
			int z1QSF4lC = pxU9NQFQ.executeUpdate();
			a1myXGOW = "delete from entry where id=?";
			pxU9NQFQ = GeO9uO03.prepareStatement(a1myXGOW);
			pxU9NQFQ.setInt(1, entry);
			int rNzWTsoq = pxU9NQFQ.executeUpdate();
			if (rNzWTsoq > 0) {
				KlcT9xpP = true;
			} else {
				GeO9uO03.rollback();
			}
			info(rNzWTsoq + " entry with " + z1QSF4lC + " revisions was deleted.");
		} catch (SQLException NdWGAmRH) {
			NdWGAmRH.printStackTrace();
		}
		return KlcT9xpP;
	}

}