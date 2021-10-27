class n22095676 {
	public static String addTag(String S9OktyDk, String aEkhGJUd, String Vc2Sqbwp, String GviFtP5O, String IFLvteAg) {
		String tkTeHySq = OctopusErrorMessages.UNKNOWN_ERROR;
		if (S9OktyDk == null || S9OktyDk.trim().equals("")) {
			return OctopusErrorMessages.TAG_ID_CANT_BE_EMPTY;
		}
		if (S9OktyDk.trim().equals(IFLvteAg)) {
			return OctopusErrorMessages.TAG_ID_TOO_SHORT;
		}
		if (!StringUtil.isAlphaNumerical(StringUtil.replace(StringUtil.replace(S9OktyDk, "-", ""), "_", ""))) {
			return OctopusErrorMessages.TAG_ID_MUST_BE_ALPHANUMERIC;
		}
		if (!S9OktyDk.startsWith(IFLvteAg)) {
			return OctopusErrorMessages.TAG_ID_MUST_START + " " + IFLvteAg;
		}
		String NzQEeadI = exist(S9OktyDk);
		if (!NzQEeadI.equals(OctopusErrorMessages.DOESNT_ALREADY_EXIST)) {
			return NzQEeadI;
		}
		if (aEkhGJUd != null && !aEkhGJUd.trim().equals("")) {
			aEkhGJUd = StringUtil.replace(aEkhGJUd, "\n", " ");
			aEkhGJUd = StringUtil.replace(aEkhGJUd, "\r", " ");
			aEkhGJUd = StringUtil.replace(aEkhGJUd, "\t", " ");
			aEkhGJUd = StringUtil.replace(aEkhGJUd, "<", "&#60;");
			aEkhGJUd = StringUtil.replace(aEkhGJUd, ">", "&#62;");
			aEkhGJUd = StringUtil.replace(aEkhGJUd, "'", "&#39;");
		} else {
			return OctopusErrorMessages.DESCRIPTION_TEXT_EMPTY;
		}
		if (Vc2Sqbwp != null && !Vc2Sqbwp.trim().equals("")) {
			Vc2Sqbwp = StringUtil.replace(Vc2Sqbwp, "\n", " ");
			Vc2Sqbwp = StringUtil.replace(Vc2Sqbwp, "\r", " ");
			Vc2Sqbwp = StringUtil.replace(Vc2Sqbwp, "\t", " ");
			Vc2Sqbwp = StringUtil.replace(Vc2Sqbwp, "<", "&#60;");
			Vc2Sqbwp = StringUtil.replace(Vc2Sqbwp, ">", "&#62;");
			Vc2Sqbwp = StringUtil.replace(Vc2Sqbwp, "'", "&#39;");
		} else {
			return OctopusErrorMessages.TRANSLATION_TEXT_EMPTY;
		}
		if (GviFtP5O == null || GviFtP5O.trim().equals("")) {
			return OctopusErrorMessages.MAIN_PARAMETER_EMPTY;
		}
		DBConnection fblOfk0z = null;
		try {
			fblOfk0z = DBServiceManager.allocateConnection();
			fblOfk0z.setAutoCommit(false);
			String GMqCjTsO = "INSERT INTO tr_tag (tr_tag_id,tr_tag_applicationid,tr_tag_info,tr_tag_creationdate) ";
			GMqCjTsO += "VALUES (?,?,'" + aEkhGJUd + "',getdate())";
			PreparedStatement ptqM0glJ = fblOfk0z.prepareStatement(GMqCjTsO);
			ptqM0glJ.setString(1, S9OktyDk);
			ptqM0glJ.setString(2, IFLvteAg);
			ptqM0glJ.executeUpdate();
			String OffdejVf = "INSERT INTO tr_translation (tr_translation_trtagid, tr_translation_language, tr_translation_text, tr_translation_version, tr_translation_lud, tr_translation_lun ) ";
			OffdejVf += "VALUES(?,'" + OctopusApplication.MASTER_LANGUAGE + "','" + Vc2Sqbwp + "',0,getdate(),?)";
			PreparedStatement ETSqiWs7 = fblOfk0z.prepareStatement(OffdejVf);
			ETSqiWs7.setString(1, S9OktyDk);
			ETSqiWs7.setString(2, GviFtP5O);
			ETSqiWs7.executeUpdate();
			fblOfk0z.commit();
			tkTeHySq = OctopusErrorMessages.ACTION_DONE;
		} catch (SQLException OQOgmhEd) {
			try {
				fblOfk0z.rollback();
			} catch (SQLException WdnuTNOj) {
			}
			tkTeHySq = OctopusErrorMessages.ERROR_DATABASE;
		} finally {
			if (fblOfk0z != null) {
				try {
					fblOfk0z.setAutoCommit(true);
				} catch (SQLException Q8Af9yFq) {
				}
				fblOfk0z.release();
			}
		}
		return tkTeHySq;
	}

}