class n15495362 {
	public int batchTransactionUpdate(List<String> PBZLa7Xy, Connection HsTEsIq7) throws Exception {
		int YxksBNXa = 0;
		Statement j7pbeqnm;
		if (HsTEsIq7 != null) {
			HsTEsIq7.setAutoCommit(false);
			j7pbeqnm = HsTEsIq7.createStatement();
			try {
				j7pbeqnm.executeUpdate("START TRANSACTION;");
				for (int kExiDYSx = 0; kExiDYSx < PBZLa7Xy.size(); kExiDYSx++) {
					j7pbeqnm.addBatch(PBZLa7Xy.get(kExiDYSx));
				}
				int[] EcLHQ99l = j7pbeqnm.executeBatch();
				for (int TVOwzDEn = 0; TVOwzDEn < EcLHQ99l.length; TVOwzDEn++) {
					FileLogger.debug("batch update result:" + EcLHQ99l[TVOwzDEn] + ", Statement.SUCCESS_NO_INFO"
							+ Statement.SUCCESS_NO_INFO);
					if (EcLHQ99l[TVOwzDEn] == Statement.SUCCESS_NO_INFO || EcLHQ99l[TVOwzDEn] > 0) {
						YxksBNXa++;
					} else if (EcLHQ99l[TVOwzDEn] == Statement.EXECUTE_FAILED)
						;
					{
						throw new Exception("query failed, while process batch update");
					}
				}
				HsTEsIq7.commit();
			} catch (Exception ZAbiy9W0) {
				YxksBNXa = 0;
				FileLogger.debug(ZAbiy9W0.getMessage());
				HsTEsIq7.rollback();
			} finally {
				HsTEsIq7.setAutoCommit(true);
				j7pbeqnm.close();
			}
		}
		return YxksBNXa;
	}

}