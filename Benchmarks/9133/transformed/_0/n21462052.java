class n21462052 {
	public int deleteRecord(String NVkHPrb4) throws SQLException, CatalogIndexException {
		Connection h6N6Vs8q = null;
		boolean Z8CAtniB = true;
		PreparedStatement GIq7l9cR = null;
		ResultSet q5c9oLWc = null;
		int KkH8harm = 0;
		boolean hAyiz1dR = false;
		StringSet LlGatWRg = new StringSet();
		if (cswRemoteRepository.isActive()) {
			StringSet Jd4Fxq2f = new StringSet();
			Jd4Fxq2f.add(NVkHPrb4);
			LlGatWRg = queryFileIdentifiers(Jd4Fxq2f);
		}
		try {
			h6N6Vs8q = returnConnection().getJdbcConnection();
			Z8CAtniB = h6N6Vs8q.getAutoCommit();
			h6N6Vs8q.setAutoCommit(false);
			String DdqZdU1k = "SELECT COUNT(*) FROM " + getResourceTableName()
					+ " WHERE DOCUUID=? AND PROTOCOL_TYPE IS NOT NULL AND PROTOCOL_TYPE<>''";
			logExpression(DdqZdU1k);
			GIq7l9cR = h6N6Vs8q.prepareStatement(DdqZdU1k);
			GIq7l9cR.setString(1, NVkHPrb4);
			q5c9oLWc = GIq7l9cR.executeQuery();
			if (q5c9oLWc.next()) {
				hAyiz1dR = q5c9oLWc.getInt(1) > 0;
			}
			closeStatement(GIq7l9cR);
			DdqZdU1k = "DELETE FROM " + getResourceTableName() + " WHERE DOCUUID=?";
			logExpression(DdqZdU1k);
			GIq7l9cR = h6N6Vs8q.prepareStatement(DdqZdU1k);
			GIq7l9cR.setString(1, NVkHPrb4);
			KkH8harm = GIq7l9cR.executeUpdate();
			closeStatement(GIq7l9cR);
			DdqZdU1k = "DELETE FROM " + getResourceDataTableName() + " WHERE DOCUUID=?";
			logExpression(DdqZdU1k);
			GIq7l9cR = h6N6Vs8q.prepareStatement(DdqZdU1k);
			GIq7l9cR.setString(1, NVkHPrb4);
			GIq7l9cR.executeUpdate();
			CollectionDao NndO29oC = new CollectionDao(this.getRequestContext());
			if (NndO29oC.getUseCollections()) {
				closeStatement(GIq7l9cR);
				DdqZdU1k = "DELETE FROM " + NndO29oC.getCollectionMemberTableName() + " WHERE DOCUUID=?";
				logExpression(DdqZdU1k);
				GIq7l9cR = h6N6Vs8q.prepareStatement(DdqZdU1k);
				GIq7l9cR.setString(1, NVkHPrb4);
				GIq7l9cR.executeUpdate();
			}
			h6N6Vs8q.commit();
		} catch (SQLException Fp8FCOPE) {
			if (h6N6Vs8q != null) {
				h6N6Vs8q.rollback();
			}
			throw Fp8FCOPE;
		} finally {
			closeResultSet(q5c9oLWc);
			closeStatement(GIq7l9cR);
			if (h6N6Vs8q != null) {
				h6N6Vs8q.setAutoCommit(Z8CAtniB);
			}
		}
		CatalogIndexAdapter VqseIaYx = getCatalogIndexAdapter();
		if (VqseIaYx != null) {
			VqseIaYx.deleteDocument(NVkHPrb4);
			if (cswRemoteRepository.isActive()) {
				if (LlGatWRg.size() > 0)
					cswRemoteRepository.onRecordsDeleted(LlGatWRg);
			}
		}
		if (hAyiz1dR && getRequestContext() != null) {
			getRequestContext().getApplicationContext().getHarvestingEngine().cancel(getRequestContext(), NVkHPrb4);
		}
		return KkH8harm;
	}

}