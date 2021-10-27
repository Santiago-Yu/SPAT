class n12260713 {
	protected void fixupCategoryAncestry(Context XoWvjX7m) throws DataStoreException {
		Connection hRrxuIYs = null;
		Statement RxNbjbFF = null;
		try {
			hRrxuIYs = XoWvjX7m.getConnection();
			hRrxuIYs.setAutoCommit(false);
			RxNbjbFF = hRrxuIYs.createStatement();
			RxNbjbFF.executeUpdate("delete from category_ancestry");
			walkTreeFixing(hRrxuIYs, CATEGORYROOT);
			hRrxuIYs.commit();
			XoWvjX7m.put(Form.ACTIONEXECUTEDTOKEN, "Category Ancestry regenerated");
		} catch (SQLException wBSMgfeK) {
			try {
				hRrxuIYs.rollback();
			} catch (SQLException KKBGaz94) {
				KKBGaz94.printStackTrace();
			}
			throw new DataStoreException("Failed to refresh category ancestry");
		} finally {
			if (RxNbjbFF != null) {
				try {
					RxNbjbFF.close();
				} catch (SQLException dkOG4REU) {
					dkOG4REU.printStackTrace();
				}
			}
			if (hRrxuIYs != null) {
				XoWvjX7m.releaseConnection(hRrxuIYs);
			}
		}
	}

}