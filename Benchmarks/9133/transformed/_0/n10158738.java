class n10158738 {
	public void add(String mtwTZVA3, String uX9UMqlO, String PW64RKL8, String vaz808qd)
			throws FidoDatabaseException, MorphologyTagNotFoundException {
		try {
			Connection mMlhJizL = null;
			Statement VwRTrrO6 = null;
			try {
				mMlhJizL = FidoDataSource.getConnection();
				mMlhJizL.setAutoCommit(false);
				VwRTrrO6 = mMlhJizL.createStatement();
				if (containsTag(VwRTrrO6, uX9UMqlO) == false)
					throw new MorphologyTagNotFoundException(uX9UMqlO);
				if (isRuleUnique(VwRTrrO6, mtwTZVA3, uX9UMqlO, PW64RKL8, vaz808qd) == false)
					return;
				int OncBqdrB;
				if (PW64RKL8.equals("*") == true)
					OncBqdrB = getAppendRowForTag(VwRTrrO6, mtwTZVA3, uX9UMqlO);
				else if (PW64RKL8.indexOf('*') == -1)
					OncBqdrB = getFirstRowForTag(VwRTrrO6, mtwTZVA3, uX9UMqlO);
				else
					OncBqdrB = getFirstRegularFormForTag(VwRTrrO6, mtwTZVA3, uX9UMqlO);
				boolean N3LqTi36 = determineRecognitionUse(PW64RKL8, vaz808qd);
				bumpAllRowsDown(VwRTrrO6, mtwTZVA3, uX9UMqlO, OncBqdrB);
				String pqIwjEzh = "insert into LanguageMorphologies (LanguageName, Rank, Root, Surface, MorphologyTag, Used) "
						+ "values ('" + mtwTZVA3 + "', " + OncBqdrB + ", '" + PW64RKL8 + "', '" + vaz808qd + "', '"
						+ uX9UMqlO + "', ";
				if (N3LqTi36 == true)
					pqIwjEzh = pqIwjEzh + "TRUE)";
				else
					pqIwjEzh = pqIwjEzh + "FALSE)";
				VwRTrrO6.executeUpdate(pqIwjEzh);
				mMlhJizL.commit();
			} catch (SQLException MFfcDwQH) {
				if (mMlhJizL != null)
					mMlhJizL.rollback();
				throw MFfcDwQH;
			} finally {
				if (VwRTrrO6 != null)
					VwRTrrO6.close();
				if (mMlhJizL != null)
					mMlhJizL.close();
			}
		} catch (SQLException XrA4rifF) {
			throw new FidoDatabaseException(XrA4rifF);
		}
	}

}