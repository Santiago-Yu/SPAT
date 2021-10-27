class n22095678 {
	public static String deleteTag(String KrihyUEz) {
		String n74w9geU = OctopusErrorMessages.UNKNOWN_ERROR;
		if (KrihyUEz == null || KrihyUEz.trim().equals("")) {
			return OctopusErrorMessages.TAG_ID_CANT_BE_EMPTY;
		}
		DBConnection yBrBpETm = null;
		try {
			yBrBpETm = DBServiceManager.allocateConnection();
			yBrBpETm.setAutoCommit(false);
			String t8f21DMc = "DELETE FROM tr_translation WHERE tr_translation_trtagid=?";
			PreparedStatement inrpUxsf = yBrBpETm.prepareStatement(t8f21DMc);
			inrpUxsf.setString(1, KrihyUEz);
			inrpUxsf.executeUpdate();
			String iineoXIG = "DELETE FROM tr_tag WHERE tr_tag_id=? ";
			PreparedStatement x3LDBn70 = yBrBpETm.prepareStatement(iineoXIG);
			x3LDBn70.setString(1, KrihyUEz);
			x3LDBn70.executeUpdate();
			yBrBpETm.commit();
			n74w9geU = OctopusErrorMessages.ACTION_DONE;
		} catch (SQLException CANnQGzO) {
			try {
				yBrBpETm.rollback();
			} catch (SQLException RarwN789) {
			}
			n74w9geU = OctopusErrorMessages.ERROR_DATABASE;
		} finally {
			if (yBrBpETm != null) {
				try {
					yBrBpETm.setAutoCommit(true);
				} catch (SQLException HxWfOdr2) {
				}
				yBrBpETm.release();
			}
		}
		return n74w9geU;
	}

}