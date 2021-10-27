class n5252227 {
	protected String doIt() throws java.lang.Exception {
		StringBuffer MmPuj83r = null;
		int odQo7J0f = 0;
		String rNNEofeV = getWhereClause();
		if (m_deleteOldImported) {
			MmPuj83r = new StringBuffer("DELETE I_BPartner " + "WHERE I_IsImported='Y'").append(rNNEofeV);
			odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
			log.fine("Delete Old Impored =" + odQo7J0f);
		}
		MmPuj83r = new StringBuffer("UPDATE I_BPartner " + "SET AD_Client_ID = COALESCE (AD_Client_ID, ")
				.append(m_AD_Client_ID)
				.append(")," + " AD_Org_ID = COALESCE (AD_Org_ID, 0)," + " IsActive = COALESCE (IsActive, 'Y'),"
						+ " Created = COALESCE (Created, SysDate)," + " CreatedBy = COALESCE (CreatedBy, 0),"
						+ " Updated = COALESCE (Updated, SysDate)," + " UpdatedBy = COALESCE (UpdatedBy, 0),"
						+ " I_ErrorMsg = ' '," + " I_IsImported = 'N' "
						+ "WHERE I_IsImported<>'Y' OR I_IsImported IS NULL");
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.fine("Reset=" + odQo7J0f);
		ModelValidationEngine.get().fireImportValidate(this, null, null, ImportValidator.TIMING_BEFORE_VALIDATE);
		MmPuj83r = new StringBuffer(
				"UPDATE I_BPartner i " + "SET GroupValue=(SELECT MAX(Value) FROM C_BP_Group g WHERE g.IsDefault='Y'"
						+ " AND g.AD_Client_ID=i.AD_Client_ID) ");
		MmPuj83r.append("WHERE GroupValue IS NULL AND C_BP_Group_ID IS NULL" + " AND I_IsImported<>'Y'")
				.append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.fine("Set Group Default=" + odQo7J0f);
		MmPuj83r = new StringBuffer("UPDATE I_BPartner i " + "SET C_BP_Group_ID=(SELECT C_BP_Group_ID FROM C_BP_Group g"
				+ " WHERE i.GroupValue=g.Value AND g.AD_Client_ID=i.AD_Client_ID) " + "WHERE C_BP_Group_ID IS NULL"
				+ " AND I_IsImported<>'Y'").append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.fine("Set Group=" + odQo7J0f);
		MmPuj83r = new StringBuffer(
				"UPDATE I_BPartner " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'ERR=Invalid Group, ' "
						+ "WHERE C_BP_Group_ID IS NULL" + " AND I_IsImported<>'Y'").append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.config("Invalid Group=" + odQo7J0f);
		MmPuj83r = new StringBuffer("UPDATE I_BPartner i " + "SET C_Country_ID=(SELECT C_Country_ID FROM C_Country c"
				+ " WHERE i.CountryCode=c.CountryCode AND c.AD_Client_ID IN (0, i.AD_Client_ID)) "
				+ "WHERE C_Country_ID IS NULL" + " AND I_IsImported<>'Y'").append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.fine("Set Country=" + odQo7J0f);
		MmPuj83r = new StringBuffer(
				"UPDATE I_BPartner " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'ERR=Invalid Country, ' "
						+ "WHERE C_Country_ID IS NULL AND (City IS NOT NULL OR Address1 IS NOT NULL)"
						+ " AND I_IsImported<>'Y'").append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.config("Invalid Country=" + odQo7J0f);
		MmPuj83r = new StringBuffer("UPDATE I_BPartner i " + "Set RegionName=(SELECT MAX(Name) FROM C_Region r"
				+ " WHERE r.IsDefault='Y' AND r.C_Country_ID=i.C_Country_ID"
				+ " AND r.AD_Client_ID IN (0, i.AD_Client_ID)) ");
		MmPuj83r.append("WHERE RegionName IS NULL AND C_Region_ID IS NULL" + " AND I_IsImported<>'Y'").append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.fine("Set Region Default=" + odQo7J0f);
		MmPuj83r = new StringBuffer("UPDATE I_BPartner i " + "Set C_Region_ID=(SELECT C_Region_ID FROM C_Region r"
				+ " WHERE r.Name=i.RegionName AND r.C_Country_ID=i.C_Country_ID"
				+ " AND r.AD_Client_ID IN (0, i.AD_Client_ID)) " + "WHERE C_Region_ID IS NULL"
				+ " AND I_IsImported<>'Y'").append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.fine("Set Region=" + odQo7J0f);
		MmPuj83r = new StringBuffer(
				"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'ERR=Invalid Region, ' "
						+ "WHERE C_Region_ID IS NULL " + " AND EXISTS (SELECT * FROM C_Country c"
						+ " WHERE c.C_Country_ID=i.C_Country_ID AND c.HasRegion='Y')" + " AND I_IsImported<>'Y'")
								.append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.config("Invalid Region=" + odQo7J0f);
		MmPuj83r = new StringBuffer("UPDATE I_BPartner i " + "SET C_Greeting_ID=(SELECT C_Greeting_ID FROM C_Greeting g"
				+ " WHERE i.BPContactGreeting=g.Name AND g.AD_Client_ID IN (0, i.AD_Client_ID)) "
				+ "WHERE C_Greeting_ID IS NULL AND BPContactGreeting IS NOT NULL" + " AND I_IsImported<>'Y'")
						.append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.fine("Set Greeting=" + odQo7J0f);
		MmPuj83r = new StringBuffer(
				"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'ERR=Invalid Greeting, ' "
						+ "WHERE C_Greeting_ID IS NULL AND BPContactGreeting IS NOT NULL" + " AND I_IsImported<>'Y'")
								.append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.config("Invalid Greeting=" + odQo7J0f);
		MmPuj83r = new StringBuffer("UPDATE I_BPartner i " + "SET (C_BPartner_ID,AD_User_ID)="
				+ "(SELECT C_BPartner_ID,AD_User_ID FROM AD_User u "
				+ "WHERE i.EMail=u.EMail AND u.AD_Client_ID=i.AD_Client_ID) "
				+ "WHERE i.EMail IS NOT NULL AND I_IsImported='N'").append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.fine("Found EMail User=" + odQo7J0f);
		MmPuj83r = new StringBuffer("UPDATE I_BPartner i " + "SET C_BPartner_ID=(SELECT C_BPartner_ID FROM C_BPartner p"
				+ " WHERE i.Value=p.Value AND p.AD_Client_ID=i.AD_Client_ID) "
				+ "WHERE C_BPartner_ID IS NULL AND Value IS NOT NULL" + " AND I_IsImported='N'").append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.fine("Found BPartner=" + odQo7J0f);
		MmPuj83r = new StringBuffer("UPDATE I_BPartner i " + "SET AD_User_ID=(SELECT AD_User_ID FROM AD_User c"
				+ " WHERE i.ContactName=c.Name AND i.C_BPartner_ID=c.C_BPartner_ID AND c.AD_Client_ID=i.AD_Client_ID) "
				+ "WHERE C_BPartner_ID IS NOT NULL AND AD_User_ID IS NULL AND ContactName IS NOT NULL"
				+ " AND I_IsImported='N'").append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.fine("Found Contact=" + odQo7J0f);
		MmPuj83r = new StringBuffer("UPDATE I_BPartner i " + "SET C_BPartner_Location_ID=(SELECT C_BPartner_Location_ID"
				+ " FROM C_BPartner_Location bpl INNER JOIN C_Location l ON (bpl.C_Location_ID=l.C_Location_ID)"
				+ " WHERE i.C_BPartner_ID=bpl.C_BPartner_ID AND bpl.AD_Client_ID=i.AD_Client_ID"
				+ " AND (i.Address1=l.Address1 OR (i.Address1 IS NULL AND l.Address1 IS NULL))"
				+ " AND (i.Address2=l.Address2 OR (i.Address2 IS NULL AND l.Address2 IS NULL))"
				+ " AND (i.City=l.City OR (i.City IS NULL AND l.City IS NULL))"
				+ " AND (i.Postal=l.Postal OR (i.Postal IS NULL AND l.Postal IS NULL))"
				+ " AND (i.Postal_Add=l.Postal_Add OR (l.Postal_Add IS NULL AND l.Postal_Add IS NULL))"
				+ " AND i.C_Region_ID=l.C_Region_ID AND i.C_Country_ID=l.C_Country_ID) "
				+ "WHERE C_BPartner_ID IS NOT NULL AND C_BPartner_Location_ID IS NULL" + " AND I_IsImported='N'")
						.append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.fine("Found Location=" + odQo7J0f);
		MmPuj83r = new StringBuffer(
				"UPDATE I_BPartner i " + "SET R_InterestArea_ID=(SELECT R_InterestArea_ID FROM R_InterestArea ia "
						+ "WHERE i.InterestAreaName=ia.Name AND ia.AD_Client_ID=i.AD_Client_ID) "
						+ "WHERE R_InterestArea_ID IS NULL AND InterestAreaName IS NOT NULL" + " AND I_IsImported='N'")
								.append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.fine("Set Interest Area=" + odQo7J0f);
		MmPuj83r = new StringBuffer(
				"UPDATE I_BPartner " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'ERR=Value is mandatory, ' "
						+ "WHERE Value IS NULL " + " AND I_IsImported<>'Y'").append(rNNEofeV);
		odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
		log.config("Value is mandatory=" + odQo7J0f);
		ModelValidationEngine.get().fireImportValidate(this, null, null, ImportValidator.TIMING_AFTER_VALIDATE);
		commitEx();
		if (p_IsValidateOnly) {
			return "Validated";
		}
		int RfjQfjHR = 0;
		int UBxbSAtY = 0;
		MmPuj83r = new StringBuffer("SELECT * FROM I_BPartner " + "WHERE I_IsImported='N'").append(rNNEofeV);
		MmPuj83r.append(" ORDER BY Value, I_BPartner_ID");
		PreparedStatement EL2wmwQt = null;
		ResultSet up26mJtu = null;
		try {
			EL2wmwQt = DB.prepareStatement(MmPuj83r.toString(), get_TrxName());
			up26mJtu = EL2wmwQt.executeQuery();
			String tCJDqKkn = "";
			MBPartner wQZW2Pj4 = null;
			MBPartnerLocation uc0iWaTa = null;
			while (up26mJtu.next()) {
				String PrRzo38A = up26mJtu.getString("Value");
				X_I_BPartner mHERgiQF = new X_I_BPartner(getCtx(), up26mJtu, get_TrxName());
				log.fine("I_BPartner_ID=" + mHERgiQF.getI_BPartner_ID() + ", C_BPartner_ID="
						+ mHERgiQF.getC_BPartner_ID() + ", C_BPartner_Location_ID="
						+ mHERgiQF.getC_BPartner_Location_ID() + ", AD_User_ID=" + mHERgiQF.getAD_User_ID());
				if (!PrRzo38A.equals(tCJDqKkn)) {
					wQZW2Pj4 = null;
					if (mHERgiQF.getC_BPartner_ID() == 0) {
						if (mHERgiQF.getName() == null || mHERgiQF.getName().length() == 0) {
							MmPuj83r = new StringBuffer(
									"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
											.append("'Invalid Name, ' ").append("WHERE I_BPartner_ID=")
											.append(mHERgiQF.getI_BPartner_ID());
							DB.executeUpdate(MmPuj83r.toString(), get_TrxName());
							continue;
						}
						wQZW2Pj4 = new MBPartner(mHERgiQF);
						if (!mHERgiQF.get_ValueAsString("AD_Language").equals(""))
							wQZW2Pj4.set_ValueOfColumn("AD_Language", mHERgiQF.get_ValueAsString("AD_Language"));
						if (!mHERgiQF.get_ValueAsString("lbr_BPTypeBR").equals(""))
							wQZW2Pj4.set_ValueOfColumn("lbr_BPTypeBR", mHERgiQF.get_ValueAsString("lbr_BPTypeBR"));
						if (!mHERgiQF.get_ValueAsString("lbr_CNPJ").equals("")) {
							Boolean UUrvTNAa = org.adempierelbr.validator.ValidatorBPartner
									.validaCNPJ(mHERgiQF.get_ValueAsString("lbr_CNPJ"));
							if (UUrvTNAa)
								wQZW2Pj4.set_ValueOfColumn("lbr_CNPJ", mHERgiQF.get_ValueAsString("lbr_CNPJ"));
							else {
								MmPuj83r = new StringBuffer(
										"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
												.append("'Invalid CNPJ, ' ").append("WHERE I_BPartner_ID=")
												.append(mHERgiQF.getI_BPartner_ID());
								DB.executeUpdate(MmPuj83r.toString(), get_TrxName());
								continue;
							}
						}
						if (!mHERgiQF.get_ValueAsString("lbr_CPF").equals("")) {
							Boolean PqQzRN9G = org.adempierelbr.validator.ValidatorBPartner
									.validaCPF(mHERgiQF.get_ValueAsString("lbr_CPF"));
							if (PqQzRN9G)
								wQZW2Pj4.set_ValueOfColumn("lbr_CPF", mHERgiQF.get_ValueAsString("lbr_CPF"));
							else {
								MmPuj83r = new StringBuffer(
										"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
												.append("'Invalid CPF, ' ").append("WHERE I_BPartner_ID=")
												.append(mHERgiQF.getI_BPartner_ID());
								DB.executeUpdate(MmPuj83r.toString(), get_TrxName());
								continue;
							}
						}
						if (!mHERgiQF.get_ValueAsString("lbr_IE").equals("")) {
							wQZW2Pj4.set_ValueOfColumn("lbr_IE", mHERgiQF.get_ValueAsString("lbr_IE"));
							wQZW2Pj4.set_ValueOfColumn("lbr_IsIEExempt", false);
						}
						if (!mHERgiQF.get_ValueAsString("lbr_CCM").equals(""))
							wQZW2Pj4.set_ValueOfColumn("lbr_CCM", mHERgiQF.get_ValueAsString("lbr_CCM"));
						if (!mHERgiQF.get_ValueAsString("lbr_RG").equals(""))
							wQZW2Pj4.set_ValueOfColumn("lbr_RG", mHERgiQF.get_ValueAsString("lbr_RG"));
						if (!mHERgiQF.get_ValueAsString("isVendor").equals(""))
							wQZW2Pj4.set_ValueOfColumn("isVendor", mHERgiQF.get_ValueAsString("isVendor"));
						if (!mHERgiQF.get_ValueAsString("isCustomer").equals(""))
							wQZW2Pj4.set_ValueOfColumn("isCustomer", mHERgiQF.get_ValueAsString("isCustomer"));
						if (!mHERgiQF.get_ValueAsString("isSalesRep").equals(""))
							wQZW2Pj4.set_ValueOfColumn("isSalesRep", mHERgiQF.get_ValueAsString("isSalesRep"));
						ModelValidationEngine.get().fireImportValidate(this, mHERgiQF, wQZW2Pj4,
								ImportValidator.TIMING_AFTER_IMPORT);
						setTypeOfBPartner(mHERgiQF, wQZW2Pj4);
						if (wQZW2Pj4.save()) {
							mHERgiQF.setC_BPartner_ID(wQZW2Pj4.getC_BPartner_ID());
							log.finest("Insert BPartner - " + wQZW2Pj4.getC_BPartner_ID());
							RfjQfjHR++;
						} else {
							MmPuj83r = new StringBuffer(
									"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||").append(
											"(CASE WHEN (SELECT COUNT(*) FROM C_BPartner WHERE lbr_CNPJ IS NOT NULL AND lbr_CNPJ='")
											.append(mHERgiQF.get_ValueAsString("lbr_CNPJ"))
											.append("') > 0 THEN 'CNPJ Duplicado, ' WHEN (SELECT COUNT(*) FROM C_BPartner WHERE lbr_CPF IS NOT NULL AND lbr_CPF='")
											.append(mHERgiQF.get_ValueAsString("lbr_CPF"))
											.append("') > 0 THEN 'CPF Duplicado, ' END) ||")
											.append("'Cannot Insert BPartner, ' ").append("WHERE I_BPartner_ID=")
											.append(mHERgiQF.getI_BPartner_ID());
							DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
							continue;
						}
					} else {
						wQZW2Pj4 = new MBPartner(getCtx(), mHERgiQF.getC_BPartner_ID(), get_TrxName());
						if (mHERgiQF.getName() != null) {
							wQZW2Pj4.setName(mHERgiQF.getName());
							wQZW2Pj4.setName2(mHERgiQF.getName2());
						}
						if (mHERgiQF.getDUNS() != null)
							wQZW2Pj4.setDUNS(mHERgiQF.getDUNS());
						if (mHERgiQF.getTaxID() != null)
							wQZW2Pj4.setTaxID(mHERgiQF.getTaxID());
						if (mHERgiQF.getNAICS() != null)
							wQZW2Pj4.setNAICS(mHERgiQF.getNAICS());
						if (mHERgiQF.getDescription() != null)
							wQZW2Pj4.setDescription(mHERgiQF.getDescription());
						if (mHERgiQF.getC_BP_Group_ID() != 0)
							wQZW2Pj4.setC_BP_Group_ID(mHERgiQF.getC_BP_Group_ID());
						ModelValidationEngine.get().fireImportValidate(this, mHERgiQF, wQZW2Pj4,
								ImportValidator.TIMING_AFTER_IMPORT);
						if (!mHERgiQF.get_ValueAsString("AD_Language").equals(""))
							wQZW2Pj4.set_ValueOfColumn("AD_Language", mHERgiQF.get_ValueAsString("AD_Language"));
						if (!mHERgiQF.get_ValueAsString("lbr_BPTypeBR").equals(""))
							wQZW2Pj4.set_ValueOfColumn("lbr_BPTypeBR", mHERgiQF.get_ValueAsString("lbr_BPTypeBR"));
						if (!mHERgiQF.get_ValueAsString("lbr_CNPJ").equals("")) {
							Boolean BD0nEQBE = org.adempierelbr.validator.ValidatorBPartner
									.validaCNPJ(mHERgiQF.get_ValueAsString("lbr_CNPJ"));
							if (BD0nEQBE)
								wQZW2Pj4.set_ValueOfColumn("lbr_CNPJ", mHERgiQF.get_ValueAsString("lbr_CNPJ"));
							else {
								MmPuj83r = new StringBuffer(
										"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
												.append("'Invalid CNPJ, ' ").append("WHERE I_BPartner_ID=")
												.append(mHERgiQF.getI_BPartner_ID());
								DB.executeUpdate(MmPuj83r.toString(), get_TrxName());
								continue;
							}
						}
						if (!mHERgiQF.get_ValueAsString("lbr_CPF").equals("")) {
							Boolean kKAGyBIO = org.adempierelbr.validator.ValidatorBPartner
									.validaCPF(mHERgiQF.get_ValueAsString("lbr_CPF"));
							if (kKAGyBIO)
								wQZW2Pj4.set_ValueOfColumn("lbr_CPF", mHERgiQF.get_ValueAsString("lbr_CPF"));
							else {
								MmPuj83r = new StringBuffer(
										"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
												.append("'Invalid CPF, ' ").append("WHERE I_BPartner_ID=")
												.append(mHERgiQF.getI_BPartner_ID());
								DB.executeUpdate(MmPuj83r.toString(), get_TrxName());
								continue;
							}
						}
						if (!mHERgiQF.get_ValueAsString("lbr_IE").equals(""))
							wQZW2Pj4.set_ValueOfColumn("lbr_IE", mHERgiQF.get_ValueAsString("lbr_IE"));
						if (!mHERgiQF.get_ValueAsString("lbr_CCM").equals(""))
							wQZW2Pj4.set_ValueOfColumn("lbr_CCM", mHERgiQF.get_ValueAsString("lbr_CCM"));
						if (!mHERgiQF.get_ValueAsString("lbr_RG").equals(""))
							wQZW2Pj4.set_ValueOfColumn("lbr_RG", mHERgiQF.get_ValueAsString("lbr_RG"));
						if (!mHERgiQF.get_ValueAsString("isVendor").equals(""))
							wQZW2Pj4.set_ValueOfColumn("isVendor", mHERgiQF.get_ValueAsString("isVendor"));
						if (!mHERgiQF.get_ValueAsString("isCustomer").equals(""))
							wQZW2Pj4.set_ValueOfColumn("isCustomer", mHERgiQF.get_ValueAsString("isCustomer"));
						if (!mHERgiQF.get_ValueAsString("isSalesRep").equals(""))
							wQZW2Pj4.set_ValueOfColumn("isSalesRep", mHERgiQF.get_ValueAsString("isSalesRep"));
						setTypeOfBPartner(mHERgiQF, wQZW2Pj4);
						if (wQZW2Pj4.save()) {
							log.finest("Update BPartner - " + wQZW2Pj4.getC_BPartner_ID());
							UBxbSAtY++;
						} else {
							MmPuj83r = new StringBuffer(
									"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
											.append("'Cannot Update BPartner, ' ").append("WHERE I_BPartner_ID=")
											.append(mHERgiQF.getI_BPartner_ID());
							DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
							continue;
						}
					}
					uc0iWaTa = null;
					if (mHERgiQF.getC_BPartner_Location_ID() != 0) {
						uc0iWaTa = new MBPartnerLocation(getCtx(), mHERgiQF.getC_BPartner_Location_ID(), get_TrxName());
						MLocation sZZuTVTa = new MLocation(getCtx(), uc0iWaTa.getC_Location_ID(), get_TrxName());
						sZZuTVTa.setC_Country_ID(mHERgiQF.getC_Country_ID());
						sZZuTVTa.setC_Region_ID(mHERgiQF.getC_Region_ID());
						sZZuTVTa.setCity(mHERgiQF.getCity());
						sZZuTVTa.setAddress1(mHERgiQF.getAddress1());
						sZZuTVTa.setAddress2(mHERgiQF.getAddress2());
						sZZuTVTa.setAddress3(mHERgiQF.get_ValueAsString("Address3"));
						sZZuTVTa.setAddress4(mHERgiQF.get_ValueAsString("Address4"));
						sZZuTVTa.setPostal(mHERgiQF.getPostal());
						sZZuTVTa.setPostal_Add(mHERgiQF.getPostal_Add());
						if (!sZZuTVTa.save())
							log.warning("Location not updated");
						else
							uc0iWaTa.setC_Location_ID(sZZuTVTa.getC_Location_ID());
						if (mHERgiQF.getPhone() != null)
							uc0iWaTa.setPhone(mHERgiQF.getPhone());
						if (mHERgiQF.getPhone2() != null)
							uc0iWaTa.setPhone2(mHERgiQF.getPhone2());
						if (mHERgiQF.getFax() != null)
							uc0iWaTa.setFax(mHERgiQF.getFax());
						ModelValidationEngine.get().fireImportValidate(this, mHERgiQF, uc0iWaTa,
								ImportValidator.TIMING_AFTER_IMPORT);
						uc0iWaTa.save();
					} else if (mHERgiQF.getC_Country_ID() != 0 && mHERgiQF.getAddress1() != null
							&& mHERgiQF.getCity() != null) {
						MLocation ouwcdH7V = new MLocation(getCtx(), mHERgiQF.getC_Country_ID(),
								mHERgiQF.getC_Region_ID(), mHERgiQF.getCity(), get_TrxName());
						ouwcdH7V.setAddress1(mHERgiQF.getAddress1());
						ouwcdH7V.setAddress2(mHERgiQF.getAddress2());
						ouwcdH7V.setAddress3(mHERgiQF.get_ValueAsString("Address3"));
						ouwcdH7V.setAddress4(mHERgiQF.get_ValueAsString("Address4"));
						ouwcdH7V.setPostal(mHERgiQF.getPostal());
						ouwcdH7V.setPostal_Add(mHERgiQF.getPostal_Add());
						if (ouwcdH7V.save())
							log.finest("Insert Location - " + ouwcdH7V.getC_Location_ID());
						else {
							rollback();
							RfjQfjHR--;
							MmPuj83r = new StringBuffer(
									"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
											.append("'Cannot Insert Location, ' ").append("WHERE I_BPartner_ID=")
											.append(mHERgiQF.getI_BPartner_ID());
							DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
							continue;
						}
						uc0iWaTa = new MBPartnerLocation(wQZW2Pj4);
						uc0iWaTa.setC_Location_ID(ouwcdH7V.getC_Location_ID());
						uc0iWaTa.setPhone(mHERgiQF.getPhone());
						uc0iWaTa.setPhone2(mHERgiQF.getPhone2());
						uc0iWaTa.setFax(mHERgiQF.getFax());
						ModelValidationEngine.get().fireImportValidate(this, mHERgiQF, uc0iWaTa,
								ImportValidator.TIMING_AFTER_IMPORT);
						if (uc0iWaTa.save()) {
							log.finest("Insert BP Location - " + uc0iWaTa.getC_BPartner_Location_ID());
							mHERgiQF.setC_BPartner_Location_ID(uc0iWaTa.getC_BPartner_Location_ID());
						} else {
							rollback();
							RfjQfjHR--;
							MmPuj83r = new StringBuffer(
									"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
											.append("'Cannot Insert BPLocation, ' ").append("WHERE I_BPartner_ID=")
											.append(mHERgiQF.getI_BPartner_ID());
							DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
							continue;
						}
					}
				}
				tCJDqKkn = PrRzo38A;
				MUser qIN5G5RQ = null;
				if (mHERgiQF.getAD_User_ID() != 0) {
					qIN5G5RQ = new MUser(getCtx(), mHERgiQF.getAD_User_ID(), get_TrxName());
					if (qIN5G5RQ.getC_BPartner_ID() == 0)
						qIN5G5RQ.setC_BPartner_ID(wQZW2Pj4.getC_BPartner_ID());
					else if (qIN5G5RQ.getC_BPartner_ID() != wQZW2Pj4.getC_BPartner_ID()) {
						rollback();
						RfjQfjHR--;
						MmPuj83r = new StringBuffer(
								"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
										.append("'BP of User <> BP, ' ").append("WHERE I_BPartner_ID=")
										.append(mHERgiQF.getI_BPartner_ID());
						DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
						continue;
					}
					if (mHERgiQF.getC_Greeting_ID() != 0)
						qIN5G5RQ.setC_Greeting_ID(mHERgiQF.getC_Greeting_ID());
					String LsWfqU7U = mHERgiQF.getContactName();
					if (LsWfqU7U == null || LsWfqU7U.length() == 0)
						LsWfqU7U = mHERgiQF.getEMail();
					qIN5G5RQ.setName(LsWfqU7U);
					if (mHERgiQF.getTitle() != null)
						qIN5G5RQ.setTitle(mHERgiQF.getTitle());
					if (mHERgiQF.getContactDescription() != null)
						qIN5G5RQ.setDescription(mHERgiQF.getContactDescription());
					if (mHERgiQF.getComments() != null)
						qIN5G5RQ.setComments(mHERgiQF.getComments());
					if (mHERgiQF.getPhone() != null)
						qIN5G5RQ.setPhone(mHERgiQF.getPhone());
					if (mHERgiQF.getPhone2() != null)
						qIN5G5RQ.setPhone2(mHERgiQF.getPhone2());
					if (mHERgiQF.getFax() != null)
						qIN5G5RQ.setFax(mHERgiQF.getFax());
					if (mHERgiQF.getEMail() != null)
						qIN5G5RQ.setEMail(mHERgiQF.getEMail());
					if (mHERgiQF.getBirthday() != null)
						qIN5G5RQ.setBirthday(mHERgiQF.getBirthday());
					if (uc0iWaTa != null)
						qIN5G5RQ.setC_BPartner_Location_ID(uc0iWaTa.getC_BPartner_Location_ID());
					ModelValidationEngine.get().fireImportValidate(this, mHERgiQF, qIN5G5RQ,
							ImportValidator.TIMING_AFTER_IMPORT);
					if (qIN5G5RQ.save()) {
						log.finest("Update BP Contact - " + qIN5G5RQ.getAD_User_ID());
					} else {
						rollback();
						RfjQfjHR--;
						MmPuj83r = new StringBuffer(
								"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
										.append("'Cannot Update BP Contact, ' ").append("WHERE I_BPartner_ID=")
										.append(mHERgiQF.getI_BPartner_ID());
						DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
						continue;
					}
				} else if (mHERgiQF.getContactName() != null || mHERgiQF.getEMail() != null) {
					qIN5G5RQ = new MUser(wQZW2Pj4);
					if (mHERgiQF.getC_Greeting_ID() != 0)
						qIN5G5RQ.setC_Greeting_ID(mHERgiQF.getC_Greeting_ID());
					String X4oNXDDG = mHERgiQF.getContactName();
					if (X4oNXDDG == null || X4oNXDDG.length() == 0)
						X4oNXDDG = mHERgiQF.getEMail();
					qIN5G5RQ.setName(X4oNXDDG);
					qIN5G5RQ.setTitle(mHERgiQF.getTitle());
					qIN5G5RQ.setDescription(mHERgiQF.getContactDescription());
					qIN5G5RQ.setComments(mHERgiQF.getComments());
					qIN5G5RQ.setPhone(mHERgiQF.getPhone());
					qIN5G5RQ.setPhone2(mHERgiQF.getPhone2());
					qIN5G5RQ.setFax(mHERgiQF.getFax());
					qIN5G5RQ.setEMail(mHERgiQF.getEMail());
					qIN5G5RQ.setBirthday(mHERgiQF.getBirthday());
					if (uc0iWaTa != null)
						qIN5G5RQ.setC_BPartner_Location_ID(uc0iWaTa.getC_BPartner_Location_ID());
					ModelValidationEngine.get().fireImportValidate(this, mHERgiQF, qIN5G5RQ,
							ImportValidator.TIMING_AFTER_IMPORT);
					if (qIN5G5RQ.save()) {
						log.finest("Insert BP Contact - " + qIN5G5RQ.getAD_User_ID());
						mHERgiQF.setAD_User_ID(qIN5G5RQ.getAD_User_ID());
					} else {
						rollback();
						RfjQfjHR--;
						MmPuj83r = new StringBuffer(
								"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
										.append("'Cannot Insert BPContact, ' ").append("WHERE I_BPartner_ID=")
										.append(mHERgiQF.getI_BPartner_ID());
						DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
						continue;
					}
				}
				if (mHERgiQF.getR_InterestArea_ID() != 0 && qIN5G5RQ != null) {
					MContactInterest PYdZBjnT = MContactInterest.get(getCtx(), mHERgiQF.getR_InterestArea_ID(),
							qIN5G5RQ.getAD_User_ID(), true, get_TrxName());
					PYdZBjnT.save();
				}
				mHERgiQF.setI_IsImported(true);
				mHERgiQF.setProcessed(true);
				mHERgiQF.setProcessing(false);
				mHERgiQF.saveEx();
				commitEx();
			}
			DB.close(up26mJtu, EL2wmwQt);
		} catch (SQLException smS26EnV) {
			rollback();
			throw new DBException(smS26EnV, MmPuj83r.toString());
		} finally {
			DB.close(up26mJtu, EL2wmwQt);
			up26mJtu = null;
			EL2wmwQt = null;
			MmPuj83r = new StringBuffer(
					"UPDATE I_BPartner " + "SET I_IsImported='N', Updated=SysDate " + "WHERE I_IsImported<>'Y'")
							.append(rNNEofeV);
			odQo7J0f = DB.executeUpdateEx(MmPuj83r.toString(), get_TrxName());
			addLog(0, null, new BigDecimal(odQo7J0f), "@Errors@");
			addLog(0, null, new BigDecimal(RfjQfjHR), "@C_BPartner_ID@: @Inserted@");
			addLog(0, null, new BigDecimal(UBxbSAtY), "@C_BPartner_ID@: @Updated@");
		}
		return "";
	}

}