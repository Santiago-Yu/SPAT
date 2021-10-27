class n16069456 {
	public void delete(int eDJcbG0J) throws FidoDatabaseException {
		try {
			Connection NaiDLSeQ = null;
			Statement BzQ5vhPK = null;
			try {
				NaiDLSeQ = fido.util.FidoDataSource.getConnection();
				NaiDLSeQ.setAutoCommit(false);
				BzQ5vhPK = NaiDLSeQ.createStatement();
				BzQ5vhPK.executeUpdate("delete from WebServices where WebServiceId = " + eDJcbG0J);
				BzQ5vhPK.executeUpdate("delete from WebServiceParams where WebServiceId = " + eDJcbG0J);
				NaiDLSeQ.commit();
			} catch (SQLException xlWk0nmK) {
				if (NaiDLSeQ != null)
					NaiDLSeQ.rollback();
				throw xlWk0nmK;
			} finally {
				if (BzQ5vhPK != null)
					BzQ5vhPK.close();
				if (NaiDLSeQ != null)
					NaiDLSeQ.close();
			}
		} catch (SQLException Qaol3LXi) {
			throw new FidoDatabaseException(Qaol3LXi);
		}
	}

}