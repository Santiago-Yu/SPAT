class n8701067 {
	public void markAsCachedHelper(Item IxuqhMtI, Date XXWWyPIT, Date X3x0zdZV, Map<String, Boolean> zMPITF1s) {
		if (zMPITF1s.size() == 0) {
			return;
		}
		Connection PVLVr7e8 = null;
		Iterable<Integer> O1NVOdE8 = representer.getInternalReps(zMPITF1s.keySet());
		Integer gpoW5i65 = representer.lookUpInternalRep(IxuqhMtI.getResolved().getHost());
		HashMap<Integer, long[]> stO5wDiL = new HashMap<Integer, long[]>();
		for (Map.Entry<String, Boolean> e : zMPITF1s.entrySet()) {
			stO5wDiL.put(representer.lookUpInternalRep(e.getKey()),
					new long[] { XXWWyPIT.getTime(), X3x0zdZV.getTime(), e.getValue() ? 1 : 0 });
		}
		try {
			PVLVr7e8 = getConnection();
			PVLVr7e8.setAutoCommit(false);
			PVLVr7e8.setSavepoint();
			PreparedStatement RLZH4t5I = null;
			try {
				RLZH4t5I = PVLVr7e8.prepareStatement(
						"SELECT MIN(starttime), MAX(endtime), MAX(hasvalues) FROM cachedperiods WHERE "
								+ "id = ? AND host = ? AND prop = ? AND " + "starttime <= ? AND endtime >= ?");
				RLZH4t5I.setString(1, IxuqhMtI.getResolved().getId());
				RLZH4t5I.setInt(2, gpoW5i65);
				RLZH4t5I.setLong(4, X3x0zdZV.getTime());
				RLZH4t5I.setLong(5, XXWWyPIT.getTime());
				for (Map.Entry<Integer, long[]> e1 : stO5wDiL.entrySet()) {
					RLZH4t5I.setInt(3, e1.getKey());
					ResultSet CJ75DeAW = RLZH4t5I.executeQuery();
					if (CJ75DeAW.next()) {
						e1.getValue()[0] = Math.min(CJ75DeAW.getLong(1), e1.getValue()[0]);
						e1.getValue()[1] = Math.max(CJ75DeAW.getLong(2), e1.getValue()[1]);
						e1.getValue()[2] = Math.max(CJ75DeAW.getInt(3), e1.getValue()[2]);
					}
					StorageUtils.close(CJ75DeAW);
				}
				StorageUtils.close(RLZH4t5I);
				RLZH4t5I = PVLVr7e8.prepareStatement("DELETE FROM cachedperiods WHERE " + "id = ? AND host = ? AND "
						+ "starttime <= ? AND endtime >= ? AND " + "prop IN ("
						+ StringUtils.join(O1NVOdE8.iterator(), ",") + ")");
				RLZH4t5I.setString(1, IxuqhMtI.getResolved().getId());
				RLZH4t5I.setInt(2, gpoW5i65);
				RLZH4t5I.setLong(3, X3x0zdZV.getTime());
				RLZH4t5I.setLong(4, XXWWyPIT.getTime());
				RLZH4t5I.executeUpdate();
				StorageUtils.close(RLZH4t5I);
				RLZH4t5I = PVLVr7e8.prepareStatement(
						"INSERT INTO cachedperiods (id, host, prop, starttime, endtime, hasvalues) VALUES (?, ?, ?, ?, ?, ?)");
				RLZH4t5I.setString(1, IxuqhMtI.getResolved().getId());
				RLZH4t5I.setInt(2, gpoW5i65);
				for (Map.Entry<Integer, long[]> e2 : stO5wDiL.entrySet()) {
					RLZH4t5I.setInt(3, e2.getKey());
					RLZH4t5I.setLong(4, e2.getValue()[0]);
					RLZH4t5I.setLong(5, e2.getValue()[1]);
					RLZH4t5I.setInt(6, (int) e2.getValue()[2]);
					RLZH4t5I.executeUpdate();
				}
			} finally {
				StorageUtils.close(RLZH4t5I);
			}
			PVLVr7e8.commit();
		} catch (SQLException QtQ2KyVj) {
			Logger.getLogger(MetaDataStoragerImpl.class.getName()).log(Level.SEVERE,
					"Cannot update cachedperiods table.", QtQ2KyVj);
			try {
				PVLVr7e8.rollback();
			} catch (SQLException AV555ING) {
				Logger.getLogger(MetaDataStoragerImpl.class.getName()).log(Level.SEVERE,
						"Could not roll back database, please consult system administrator.", AV555ING);
			}
		} finally {
			StorageUtils.close(PVLVr7e8);
		}
	}

}