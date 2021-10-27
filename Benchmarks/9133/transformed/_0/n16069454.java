class n16069454 {
	public int add(WebService B2OCbHAt) throws FidoDatabaseException {
		try {
			Connection bmqPAzi8 = null;
			Statement ivhMyuC3 = null;
			ResultSet xnX7BjU7 = null;
			try {
				String nUPc4AhZ = "insert into WebServices (MethodName, ServiceURI) " + "values ('"
						+ B2OCbHAt.getMethodName() + "', '" + B2OCbHAt.getServiceURI() + "')";
				bmqPAzi8 = fido.util.FidoDataSource.getConnection();
				bmqPAzi8.setAutoCommit(false);
				ivhMyuC3 = bmqPAzi8.createStatement();
				ivhMyuC3.executeUpdate(nUPc4AhZ);
				int jKZjTdAz;
				nUPc4AhZ = "select currval('webservices_webserviceid_seq')";
				xnX7BjU7 = ivhMyuC3.executeQuery(nUPc4AhZ);
				if (xnX7BjU7.next() == false)
					throw new SQLException("No rows returned from select currval() query");
				else
					jKZjTdAz = xnX7BjU7.getInt(1);
				PreparedStatement DlcrBvWK = bmqPAzi8.prepareStatement("insert into WebServiceParams "
						+ "(WebServiceId, Position, ParameterName, Type) " + "values (?, ?, ?, ?)");
				DlcrBvWK.setInt(1, jKZjTdAz);
				DlcrBvWK.setInt(2, 0);
				DlcrBvWK.setString(3, null);
				DlcrBvWK.setInt(4, B2OCbHAt.getReturnType());
				DlcrBvWK.executeUpdate();
				for (Iterator zADLO0EC = B2OCbHAt.parametersIterator(); zADLO0EC.hasNext();) {
					WebServiceParameter blWc9vZe = (WebServiceParameter) zADLO0EC.next();
					DlcrBvWK.setInt(2, blWc9vZe.getPosition());
					DlcrBvWK.setString(3, blWc9vZe.getName());
					DlcrBvWK.setInt(4, blWc9vZe.getType());
					DlcrBvWK.executeUpdate();
				}
				bmqPAzi8.commit();
				return jKZjTdAz;
			} catch (SQLException Jzj6a4JK) {
				if (bmqPAzi8 != null)
					bmqPAzi8.rollback();
				throw Jzj6a4JK;
			} finally {
				if (xnX7BjU7 != null)
					xnX7BjU7.close();
				if (ivhMyuC3 != null)
					ivhMyuC3.close();
				if (bmqPAzi8 != null)
					bmqPAzi8.close();
			}
		} catch (SQLException xRb2M0Aq) {
			xRb2M0Aq.printStackTrace();
			throw new FidoDatabaseException(xRb2M0Aq);
		}
	}

}