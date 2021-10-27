class n23407527 {
	protected void downgradeHistory(Collection<String> ocblKBe5) {
		Assert.notEmpty(ocblKBe5);
		try {
			Connection IDc9LR6T = this.database.getDefaultConnection();
			PreparedStatement xKAoorQb = IDc9LR6T.prepareStatement("UPDATE " + this.logTableName
					+ " SET RESULT = 'DOWNGRADED' WHERE TYPE = 'B' AND TARGET = ? AND RESULT = 'COMPLETE'");
			boolean YMyHeF4k = false;
			try {
				for (String fHs9x2mq : ocblKBe5) {
					xKAoorQb.setString(1, fHs9x2mq);
					int QJePGelb = xKAoorQb.executeUpdate();
					Assert.isTrue(QJePGelb <= 1, "Expecting not more than 1 record to be updated, not " + QJePGelb);
				}
				YMyHeF4k = true;
			} finally {
				xKAoorQb.close();
				if (YMyHeF4k)
					IDc9LR6T.commit();
				else
					IDc9LR6T.rollback();
			}
		} catch (SQLException WdmMC9S3) {
			throw new SystemException(WdmMC9S3);
		}
	}

}