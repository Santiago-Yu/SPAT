class n23022776 {
	public Long processAddHolding(Holding holdingBean, AuthSession authSession) {
		PreparedStatement ps = null;
		if (authSession == null) {
			return null;
		}
		DatabaseAdapter dbDyn = null;
		try {
			CustomSequenceType seq = new CustomSequenceType();
			dbDyn = DatabaseAdapter.getInstance();
			seq.setSequenceName("seq_WM_LIST_HOLDING");
			seq.setTableName("WM_LIST_HOLDING");
			seq.setColumnName("ID_HOLDING");
			Long sequenceValue = dbDyn.getSequenceNextValue(seq);
			int num = 1;
			ps = dbDyn
					.prepareStatement("insert into WM_LIST_HOLDING " + "( ID_HOLDING, full_name_HOLDING, NAME_HOLDING )"
							+ "values " + (dbDyn.getIsNeedUpdateBracket() ? "(" : "") + " ?, ?, ? "
							+ (dbDyn.getIsNeedUpdateBracket() ? ")" : ""));
			RsetTools.setLong(ps, num++, sequenceValue);
			ps.setString(num++, holdingBean.getName());
			ps.setString(num++, holdingBean.getShortName());
			int i1 = ps.executeUpdate();
			HoldingBean bean = new HoldingBean(holdingBean);
			if (log.isDebugEnabled())
				log.debug("Count of inserted records - " + i1);
			bean.setId(sequenceValue);
			processInsertRelatedCompany(dbDyn, bean, authSession);
			dbDyn.commit();
			return sequenceValue;
		} catch (Exception e) {
			String es = "Error add new holding";
			try {
				if (dbDyn != null)
					dbDyn.rollback();
			} catch (Exception e001) {
			}
			log.error(es, e);
			throw new IllegalStateException(es, e);
		} finally {
			DatabaseManager.close(dbDyn, ps);
			ps = null;
			dbDyn = null;
		}
	}

}