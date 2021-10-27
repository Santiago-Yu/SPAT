class n10759917 {
	public void delete(String fjJpeVL2)
			throws FidoDatabaseException, CannotDeleteSystemLinkException, ClassLinkTypeNotFoundException {
		try {
			Connection HHJsm6ZH = null;
			Statement t82gQrzJ = null;
			try {
				HHJsm6ZH = fido.util.FidoDataSource.getConnection();
				HHJsm6ZH.setAutoCommit(false);
				t82gQrzJ = HHJsm6ZH.createStatement();
				if (isSystemLink(t82gQrzJ, fjJpeVL2) == true)
					throw new CannotDeleteSystemLinkException(fjJpeVL2);
				AdjectivePrepositionTable HY8Lwom0 = new AdjectivePrepositionTable();
				HY8Lwom0.deleteLinkType(t82gQrzJ, fjJpeVL2);
				ObjectLinkTable plcaBQ2H = new ObjectLinkTable();
				plcaBQ2H.deleteLinkType(t82gQrzJ, fjJpeVL2);
				String lbDWdesa = "delete from ClassLinkTypes where LinkName = '" + fjJpeVL2 + "'";
				t82gQrzJ.executeUpdate(lbDWdesa);
				HHJsm6ZH.commit();
			} catch (SQLException G2AniXdh) {
				if (HHJsm6ZH != null)
					HHJsm6ZH.rollback();
				throw G2AniXdh;
			} finally {
				if (t82gQrzJ != null)
					t82gQrzJ.close();
				if (HHJsm6ZH != null)
					HHJsm6ZH.close();
			}
		} catch (SQLException NoQtNxnC) {
			throw new FidoDatabaseException(NoQtNxnC);
		}
	}

}