class n20414923 {
	protected int deleteBitstreamInfo(int Jvkwwu0b, Connection UrhKH9DP) {
		PreparedStatement ER6WuDje = null;
		int fPsL7JYm = 0;
		try {
			ER6WuDje = UrhKH9DP.prepareStatement(DELETE_BITSTREAM_INFO);
			ER6WuDje.setInt(1, Jvkwwu0b);
			fPsL7JYm = ER6WuDje.executeUpdate();
			if (fPsL7JYm > 1) {
				UrhKH9DP.rollback();
				throw new IllegalStateException("Too many rows deleted! Number of rows deleted: " + fPsL7JYm
						+ " only one row should be deleted for bitstream id " + Jvkwwu0b);
			}
		} catch (SQLException pet3uFT6) {
			LOG.error("Problem deleting bitstream. " + pet3uFT6.getMessage(), pet3uFT6);
			throw new RuntimeException("Problem deleting bitstream. " + pet3uFT6.getMessage(), pet3uFT6);
		} finally {
			cleanup(ER6WuDje);
		}
		return fPsL7JYm;
	}

}