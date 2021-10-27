class n14050308 {
	public void deleteInstance(int DzHymFOT) throws FidoDatabaseException, ObjectNotFoundException {
		try {
			Connection GGN4FWxV = null;
			Statement sgVyCA0D = null;
			try {
				GGN4FWxV = fido.util.FidoDataSource.getConnection();
				GGN4FWxV.setAutoCommit(false);
				sgVyCA0D = GGN4FWxV.createStatement();
				if (contains(sgVyCA0D, DzHymFOT) == false)
					throw new ObjectNotFoundException(DzHymFOT);
				ObjectLinkTable YWXPl88L = new ObjectLinkTable();
				ObjectAttributeTable LXSQP2gD = new ObjectAttributeTable();
				YWXPl88L.deleteObject(sgVyCA0D, DzHymFOT);
				LXSQP2gD.deleteObject(sgVyCA0D, DzHymFOT);
				sgVyCA0D.executeUpdate("delete from Objects where ObjectId = " + DzHymFOT);
				GGN4FWxV.commit();
			} catch (SQLException lqpxCuXL) {
				if (GGN4FWxV != null)
					GGN4FWxV.rollback();
				throw lqpxCuXL;
			} finally {
				if (sgVyCA0D != null)
					sgVyCA0D.close();
				if (GGN4FWxV != null)
					GGN4FWxV.close();
			}
		} catch (SQLException Xix22Xdw) {
			throw new FidoDatabaseException(Xix22Xdw);
		}
	}

}