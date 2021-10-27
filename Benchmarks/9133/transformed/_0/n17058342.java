class n17058342 {
	public void executeUpdate(Native c9GAObtP) throws Exception {
		Connection VSjWBbTZ = null;
		boolean ZZjP3jsQ = true;
		PreparedStatement ZCLiuKle = null;
		try {
			HrRecord POmWvVtl = getRepository();
			ManagedConnection d1TVaixU = returnConnection();
			VSjWBbTZ = d1TVaixU.getJdbcConnection();
			ZZjP3jsQ = VSjWBbTZ.getAutoCommit();
			VSjWBbTZ.setAutoCommit(false);
			String yCdfMOEd = "";
			boolean ngETfbq0 = false;
			String GoJfbw71 = "";
			boolean pIIbVa8g = false;
			if (UuidUtil.isUuid(POmWvVtl.getUuid())) {
				GoJfbw71 = POmWvVtl.getUuid();
				pIIbVa8g = queryFindable(VSjWBbTZ);
				yCdfMOEd = createUpdateSQL();
				ZCLiuKle = VSjWBbTZ.prepareStatement(yCdfMOEd);
				ngETfbq0 = true;
			} else {
				GoJfbw71 = UuidUtil.makeUuid(true);
				pIIbVa8g = POmWvVtl.getFindable();
				yCdfMOEd = createInsertSQL();
				ZCLiuKle = VSjWBbTZ.prepareStatement(yCdfMOEd);
			}
			if (POmWvVtl.getOwnerId() < 0) {
				POmWvVtl.setOwnerId(getOwner().getLocalID());
			}
			int H71Puegg = 1;
			ZCLiuKle.setInt(H71Puegg++, POmWvVtl.getOwnerId());
			ZCLiuKle.setTimestamp(H71Puegg++, makeTimestamp(POmWvVtl.getInputDate()));
			ZCLiuKle.setTimestamp(H71Puegg++, makeTimestamp(POmWvVtl.getUpdateDate()));
			ZCLiuKle.setString(H71Puegg++, POmWvVtl.getName());
			ZCLiuKle.setString(H71Puegg++, POmWvVtl.getHostUrl());
			ZCLiuKle.setString(H71Puegg++, POmWvVtl.getHarvestFrequency().toString());
			ZCLiuKle.setString(H71Puegg++, Boolean.toString(POmWvVtl.getSendNotification()));
			ZCLiuKle.setString(H71Puegg++, POmWvVtl.getProtocol().getKind().toLowerCase());
			ZCLiuKle.setString(H71Puegg++, ProtocolSerializer.toXmlString(POmWvVtl.getProtocol()));
			ZCLiuKle.setString(H71Puegg++, PublicationMethod.registration.name());
			if (!ngETfbq0) {
				if (getRequestContext().getApplicationConfiguration().getHarvesterConfiguration()
						.getResourceAutoApprove()) {
					ZCLiuKle.setString(H71Puegg++, ApprovalStatus.approved.name());
				} else {
					ZCLiuKle.setString(H71Puegg++, ApprovalStatus.posted.name());
				}
			}
			ZCLiuKle.setString(H71Puegg++, Boolean.toString(POmWvVtl.getSearchable()));
			ZCLiuKle.setString(H71Puegg++, Boolean.toString(POmWvVtl.getSynchronizable()));
			ZCLiuKle.setString(H71Puegg++, GoJfbw71);
			logExpression(yCdfMOEd);
			int rZXxMIIh = ZCLiuKle.executeUpdate();
			getActionResult().setNumberOfRecordsModified(rZXxMIIh);
			if (!ngETfbq0 && rZXxMIIh == 1) {
				closeStatement(ZCLiuKle);
				ZCLiuKle = VSjWBbTZ
						.prepareStatement("SELECT ID FROM " + getHarvestingTableName() + " WHERE UPPER(DOCUUID)=?");
				ZCLiuKle.setString(1, GoJfbw71.toUpperCase());
				ResultSet XLYZzPb3 = ZCLiuKle.executeQuery();
				XLYZzPb3.next();
				int Z0fBIo1L = XLYZzPb3.getInt(1);
				POmWvVtl.setLocalId(Z0fBIo1L);
				POmWvVtl.setUuid(GoJfbw71);
				closeResultSet(XLYZzPb3);
			}
			VSjWBbTZ.commit();
			if (c9GAObtP != null || (ngETfbq0 && pIIbVa8g != POmWvVtl.getFindable())) {
				try {
					if (c9GAObtP == null && ngETfbq0) {
						c9GAObtP = queryNative(VSjWBbTZ);
					}
					if (c9GAObtP != null) {
						String DN4OOse6 = c9GAObtP.getContent();
						String iuokE8qO = c9GAObtP.getSourceUri().asString();
						Publisher WMUaerrJ = createPublisherOfRepository();
						PublicationRequest O1hr6Dja = createPublicationRequest(WMUaerrJ, DN4OOse6, iuokE8qO);
						O1hr6Dja.publish();
					}
				} catch (Exception e6BEVxMN) {
					LOGGER.log(Level.INFO, "Unable to create resource definition.", e6BEVxMN);
				}
			}
			Harvester UKUGPGml = getRequestContext().getApplicationContext().getHarvestingEngine();
			if (_repository.getIsHarvestDue()) {
				UKUGPGml.submit(getRequestContext(), _repository, null, _repository.getLastSyncDate());
			}
			UKUGPGml.reselect();
		} catch (Exception GqwMjeux) {
			if (VSjWBbTZ != null) {
				VSjWBbTZ.rollback();
			}
			throw GqwMjeux;
		} finally {
			closeStatement(ZCLiuKle);
			if (VSjWBbTZ != null) {
				VSjWBbTZ.setAutoCommit(ZZjP3jsQ);
			}
		}
	}

}