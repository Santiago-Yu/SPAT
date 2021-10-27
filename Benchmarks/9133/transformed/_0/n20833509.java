class n20833509 {
	protected String doIt() throws java.lang.Exception {
		StringBuffer UzlTtUF5 = null;
		int mdMQcuRX = 0;
		String bkJqcncr = " AND AD_Client_ID=" + m_AD_Client_ID;
		if (m_deleteOldImported) {
			UzlTtUF5 = new StringBuffer("DELETE I_BPartner " + "WHERE I_IsImported='Y'").append(bkJqcncr);
			mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
			log.fine("Delete Old Impored =" + mdMQcuRX);
		}
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner " + "SET AD_Client_ID = COALESCE(AD_Client_ID, ")
				.append(m_AD_Client_ID)
				.append(")," + " AD_Org_ID = COALESCE(AD_Org_ID, 0)," + " IsActive = COALESCE(IsActive, 'Y'),"
						+ " Created = COALESCE(Created, current_timestamp)," + " CreatedBy = COALESCE(CreatedBy, 0),"
						+ " Updated = COALESCE(Updated, current_timestamp)," + " UpdatedBy = COALESCE(UpdatedBy, 0),"
						+ " I_ErrorMsg = ''," + " I_IsImported = 'N' "
						+ "WHERE I_IsImported<>'Y' OR I_IsImported IS NULL");
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.fine("Reset=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer(
				"UPDATE I_BPartner i " + "SET GroupValue=(SELECT Value FROM C_BP_Group g WHERE g.IsDefault='Y'"
						+ " AND g.AD_Client_ID=i.AD_Client_ID AND ROWNUM=1) "
						+ "WHERE GroupValue IS NULL AND C_BP_Group_ID IS NULL" + " AND I_IsImported<>'Y'")
								.append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.fine("Set Group Default=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner i " + "SET C_BP_Group_ID=(SELECT C_BP_Group_ID FROM C_BP_Group g"
				+ " WHERE i.GroupValue=g.Value AND g.AD_Client_ID=i.AD_Client_ID ORDER BY g.IsDefault DESC LIMIT 1) "
				+ "WHERE C_BP_Group_ID IS NULL" + " AND I_IsImported<>'Y'").append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.fine("Set Group=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'"
				+ getMsg("ImportBPInvalidGroup") + ". ' " + "WHERE C_BP_Group_ID IS NULL" + " AND I_IsImported<>'Y'")
						.append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.config("Invalid Group=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer(
				"UPDATE I_BPartner i " + "SET CountryCode=(SELECT CountryCode FROM C_Country c WHERE c.isactive='Y'"
						+ " AND c.AD_Client_ID IN (0, i.AD_Client_ID) AND ROWNUM=1) "
						+ "WHERE CountryCode IS NULL AND C_Country_ID IS NULL" + " AND I_IsImported<>'Y'")
								.append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.fine("Set Country Default=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner i " + "SET C_Country_ID=(SELECT C_Country_ID FROM C_Country c"
				+ " WHERE i.CountryCode=c.CountryCode AND c.AD_Client_ID IN (0, i.AD_Client_ID)) "
				+ "WHERE C_Country_ID IS NULL" + " AND I_IsImported<>'Y'").append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.fine("Set Country=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'"
				+ getMsg("ImportBPInvalidCountry") + ". ' " + "WHERE C_Country_ID IS NULL" + " AND I_IsImported<>'Y'")
						.append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.config("Invalid Country=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner i " + "Set RegionName=(SELECT Name FROM C_Region r"
				+ " WHERE r.IsDefault='Y' AND r.C_Country_ID=i.C_Country_ID"
				+ " AND r.AD_Client_ID IN (0, i.AD_Client_ID) AND ROWNUM=1) "
				+ "WHERE RegionName IS NULL AND C_Region_ID IS NULL" + " AND I_IsImported<>'Y'").append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.fine("Set Region Default=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner i " + "Set C_Region_ID=(SELECT C_Region_ID FROM C_Region r"
				+ " WHERE r.Name=i.RegionName AND r.C_Country_ID=i.C_Country_ID"
				+ " AND r.AD_Client_ID IN (0, i.AD_Client_ID)) " + "WHERE C_Region_ID IS NULL"
				+ " AND I_IsImported<>'Y'").append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.fine("Set Region=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'"
				+ getMsg("ImportBPInvalidRegion") + ". ' " + " WHERE C_Region_ID IS NULL "
				+ " AND EXISTS (SELECT * FROM C_Country c" + " WHERE c.C_Country_ID=i.C_Country_ID AND c.HasRegion='Y')"
				+ " AND I_IsImported<>'Y'").append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.config("Invalid Region=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner i "
				+ "SET BPContactGreeting=NULL WHERE C_Greeting_ID IS NULL AND char_length(trim(BPContactGreeting)) = 0 AND I_IsImported<>'Y'")
						.append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.fine("Reset Greeting=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner i " + "SET C_Greeting_ID=(SELECT C_Greeting_ID FROM C_Greeting g"
				+ " WHERE i.BPContactGreeting=g.Name AND g.AD_Client_ID IN (0, i.AD_Client_ID)) "
				+ "WHERE C_Greeting_ID IS NULL AND BPContactGreeting IS NOT NULL" + " AND I_IsImported<>'Y'")
						.append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.fine("Set Greeting=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'"
				+ getMsg("ImportBPInvalidGreeting") + ". ' "
				+ "WHERE C_Greeting_ID IS NULL AND BPContactGreeting IS NOT NULL" + " AND I_IsImported<>'Y'")
						.append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.config("Invalid Greeting=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner i " + "SET C_BPartner_ID=(SELECT C_BPartner_ID FROM C_BPartner p"
				+ " WHERE i.Value=p.Value AND p.AD_Client_ID=i.AD_Client_ID) "
				+ "WHERE C_BPartner_ID IS NULL AND Value IS NOT NULL" + " AND I_IsImported='N'").append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.fine("Found BPartner=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner i " + "SET AD_User_ID=(SELECT AD_User_ID FROM AD_User c"
				+ " WHERE i.ContactName=c.Name AND i.C_BPartner_ID=c.C_BPartner_ID AND c.AD_Client_ID=i.AD_Client_ID) "
				+ "WHERE C_BPartner_ID IS NOT NULL AND AD_User_ID IS NULL AND ContactName IS NOT NULL"
				+ " AND I_IsImported='N'").append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.fine("Found Contact=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner i " + "SET C_BPartner_Location_ID=(SELECT C_BPartner_Location_ID"
				+ " FROM C_BPartner_Location bpl INNER JOIN C_Location l ON (bpl.C_Location_ID=l.C_Location_ID)"
				+ " WHERE i.C_BPartner_ID=bpl.C_BPartner_ID AND bpl.AD_Client_ID=i.AD_Client_ID"
				+ " AND DUMP(i.Address1)=DUMP(l.Address1) AND DUMP(i.Address2)=DUMP(l.Address2)"
				+ " AND DUMP(i.City)=DUMP(l.City) AND DUMP(i.Postal)=DUMP(l.Postal) AND DUMP(i.Postal_Add)=DUMP(l.Postal_Add)"
				+ " AND DUMP(i.C_Region_ID)=DUMP(l.C_Region_ID) AND DUMP(i.C_Country_ID)=DUMP(l.C_Country_ID)) "
				+ "WHERE C_BPartner_ID IS NOT NULL AND C_BPartner_Location_ID IS NULL" + " AND I_IsImported='N'")
						.append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.fine("Found Location=" + mdMQcuRX);
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner i " + "SET C_Categoria_IVA_Codigo="
				+ MCategoriaIva.CONSUMIDOR_FINAL
				+ " WHERE (C_Categoria_IVA_Codigo IS NULL OR C_Categoria_IVA_Codigo = 0) " + "  AND I_IsImported='N'")
						.append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner i " + "SET C_Categoria_IVA_ID= " + " (SELECT C_Categoria_IVA_ID "
				+ "  FROM C_Categoria_IVA c "
				+ "  WHERE i.C_Categoria_IVA_Codigo=c.Codigo AND c.AD_Client_ID=i.AD_Client_ID " + " ) "
				+ "WHERE C_Categoria_IVA_ID IS NULL " + "  AND I_IsImported='N'").append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		UzlTtUF5 = new StringBuffer("UPDATE I_BPartner i " + "SET SalesRep_ID=(SELECT AD_User_ID " + "FROM AD_User u "
				+ "WHERE u.Name = i.SalesRep_Name AND u.AD_Client_ID IN (0, i.AD_Client_ID)) "
				+ "WHERE SalesRep_ID IS NULL " + "AND I_IsImported<>'Y'").append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		log.fine("Set Country=" + mdMQcuRX);
		int lfGZjUBY = 0;
		int osJkwAAv = 0;
		UzlTtUF5 = new StringBuffer("SELECT I_BPartner_ID, C_BPartner_ID,"
				+ "C_BPartner_Location_ID,COALESCE(Address1,Address2,City,RegionName,CountryCode),"
				+ "AD_User_ID,ContactName " + "FROM I_BPartner " + "WHERE I_IsImported='N'").append(bkJqcncr);
		Connection bm13bLnl = DB.createConnection(false, Connection.TRANSACTION_READ_COMMITTED);
		try {
			log.info("En importBPartbner antes de hacer el update en c_BPartner");
			PreparedStatement JSxBrPp6 = bm13bLnl.prepareStatement("UPDATE C_BPartner " + "SET Value=aux.Value"
					+ ",Name=aux.Name" + ",Name2=aux.Name2" + ",Description=aux.Description" + ",DUNS=aux.DUNS"
					+ ",TaxID=aux.TaxID" + ",NAICS=aux.NAICS" + ",C_BP_Group_ID=aux.C_BP_Group_ID"
					+ ",Updated=current_timestamp" + ",UpdatedBy=aux.UpdatedBy" + ",IIBB=aux.IIBB"
					+ " from (SELECT Value,Name,Name2,Description,DUNS,TaxID,NAICS,C_BP_Group_ID,UpdatedBy,IIBB FROM I_BPartner WHERE I_BPartner_ID=?) as aux"
					+ " WHERE C_BPartner_ID=?");
			log.info("En importBPartbner despues de hacer el update en c_BPartner");
			PreparedStatement PWp5LTXs = bm13bLnl.prepareStatement("INSERT INTO C_Location (C_Location_ID,"
					+ "AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,"
					+ "Address1,Address2,City,Postal,Postal_Add,C_Country_ID,C_Region_ID) " + "SELECT ?,"
					+ "AD_Client_ID,AD_Org_ID,'Y',current_timestamp,CreatedBy,current_timestamp,UpdatedBy,"
					+ "Address1,Address2,City,Postal,Postal_Add,C_Country_ID,C_Region_ID " + "FROM I_BPartner "
					+ "WHERE I_BPartner_ID=?");
			PreparedStatement gc8BrmPZ = bm13bLnl.prepareStatement("INSERT INTO C_BPartner_Location ( "
					+ "	C_BPartner_Location_ID," + "	AD_Client_ID," + "	AD_Org_ID," + "	IsActive," + "	Created,"
					+ "	CreatedBy," + "	Updated," + "	UpdatedBy," + "	Name," + "	IsBillTo," + "	IsShipTo,"
					+ "	IsPayFrom," + "	IsRemitTo," + "	Phone," + "	Phone2," + "	Fax," + "	C_BPartner_ID,"
					+ "	C_Location_ID) "
					+ "SELECT ?,AD_Client_ID,AD_Org_ID,'Y',current_timestamp,CreatedBy,current_timestamp,UpdatedBy,"
					+ "CASE WHEN char_length(trim(coalesce(address1,''))) > 0 THEN address1 "
					+ "     WHEN char_length(trim(coalesce(city,''))) > 0 THEN city "
					+ "     WHEN char_length(trim(coalesce(regionname,''))) > 0 THEN regionname " + "     ELSE name "
					+ "END," + "'Y','Y','Y','Y'," + "Phone,Phone2,Fax, ?,? " + "FROM I_BPartner "
					+ "WHERE I_BPartner_ID=?");
			PreparedStatement g33Rmq47 = bm13bLnl.prepareStatement("INSERT INTO AD_User (AD_User_ID,"
					+ "AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,"
					+ "C_BPartner_ID,C_BPartner_Location_ID,C_Greeting_ID,"
					+ "Name,Title,Description,Comments,Phone,Phone2,Fax,EMail,Birthday) " + "SELECT ?,"
					+ "AD_Client_ID,AD_Org_ID,'Y',current_timestamp,CreatedBy,current_timestamp,UpdatedBy,"
					+ "?,?,C_Greeting_ID,"
					+ "ContactName,Title,ContactDescription,Comments,Phone,Phone2,Fax,EMail,Birthday "
					+ "FROM I_BPartner " + " WHERE I_BPartner_ID=?");
			PreparedStatement U7qwmBEB = bm13bLnl.prepareStatement("UPDATE AD_User "
					+ "SET C_Greeting_ID=aux1.C_Greeting_ID" + ",Name=aux1.Name" + ",Title=aux1.Title"
					+ ",Description=aux1.Description" + ",Comments=aux1.Commets" + ",Phone=aux1.Phone"
					+ ",Phone2=aux1.Phone2" + ",Fax=aux1.Fax" + ",EMail=aux1.EMail" + ",Birthday=aux1.Birthaday"
					+ ",Updated=current_timestamp" + ",UpdatedBy=aux1.UpdatedBy"
					+ " from (SELECT C_Greeting_ID,ContactName,Title,ContactDescription,Comments,Phone,Phone2,Fax,EMail,Birthday,UpdatedBy FROM I_BPartner WHERE I_BPartner_ID=?) as aux1"
					+ " WHERE AD_User_ID=?");
			PreparedStatement ZoxopUTk = bm13bLnl.prepareStatement("UPDATE I_BPartner SET I_IsImported='Y',"
					+ " C_BPartner_ID=?, C_BPartner_Location_ID=?, AD_User_ID=?, "
					+ " Updated=current_timestamp, Processed='Y' WHERE I_BPartner_ID=?");
			PreparedStatement fvRD5CyG = DB.prepareStatement(UzlTtUF5.toString());
			ResultSet fpFrf97O = fvRD5CyG.executeQuery();
			while (fpFrf97O.next()) {
				int ND1XC9e7 = fpFrf97O.getInt(1);
				int vBK7OGaI = fpFrf97O.getInt(2);
				boolean rPmKmuj8 = vBK7OGaI == 0;
				int wr0CZ4aI = fpFrf97O.getInt(3);
				String gm74xNp0 = fpFrf97O.getString(4);
				boolean q1h5POQy = fpFrf97O.getString(4) != null;
				int yneIy3OC = fpFrf97O.getInt(5);
				boolean k3jr2opk = fpFrf97O.getString(6) != null;
				log.fine("I_BPartner_ID=" + ND1XC9e7 + ", C_BPartner_ID=" + vBK7OGaI + ", C_BPartner_Location_ID="
						+ wr0CZ4aI + " create=" + q1h5POQy + ", AD_User_ID=" + yneIy3OC + " create=" + k3jr2opk);
				if (rPmKmuj8) {
					X_I_BPartner jRNKNR5q = new X_I_BPartner(getCtx(), ND1XC9e7, null);
					MBPartner dEuIo1VW = new MBPartner(jRNKNR5q);
					if (dEuIo1VW.save()) {
						vBK7OGaI = dEuIo1VW.getC_BPartner_ID();
						log.finest("Insert BPartner");
						lfGZjUBY++;
					} else {
						UzlTtUF5 = new StringBuffer(
								"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||").append(
										DB.TO_STRING("Insert BPartner failed: " + CLogger.retrieveErrorAsString()))
										.append(" WHERE I_BPartner_ID=").append(ND1XC9e7);
						DB.executeUpdate(UzlTtUF5.toString());
						continue;
					}
				} else {
					JSxBrPp6.setInt(1, ND1XC9e7);
					JSxBrPp6.setInt(2, vBK7OGaI);
					try {
						mdMQcuRX = JSxBrPp6.executeUpdate();
						log.finest("Update BPartner = " + mdMQcuRX);
						osJkwAAv++;
					} catch (SQLException lzgnVJcr) {
						log.finest("Update BPartner -- " + lzgnVJcr.toString());
						UzlTtUF5 = new StringBuffer(
								"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
										.append(DB.TO_STRING("Update BPartner: " + lzgnVJcr.toString()))
										.append(" WHERE I_BPartner_ID=").append(ND1XC9e7);
						DB.executeUpdate(UzlTtUF5.toString());
						continue;
					}
				}
				if (wr0CZ4aI != 0) {
				} else if (q1h5POQy) {
					int Iw0mrFmj = 0;
					try {
						Iw0mrFmj = DB.getNextID(m_AD_Client_ID, "C_Location", null);
						if (Iw0mrFmj <= 0) {
							throw new DBException("No NextID (" + Iw0mrFmj + ")");
						}
						PWp5LTXs.setInt(1, Iw0mrFmj);
						PWp5LTXs.setInt(2, ND1XC9e7);
						mdMQcuRX = PWp5LTXs.executeUpdate();
						log.finest("Insert Location = " + mdMQcuRX);
					} catch (SQLException axjyVRkj) {
						log.finest("Insert Location - " + axjyVRkj.toString());
						bm13bLnl.rollback();
						lfGZjUBY--;
						UzlTtUF5 = new StringBuffer(
								"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
										.append(DB.TO_STRING("Insert Location: " + axjyVRkj.toString()))
										.append(" WHERE I_BPartner_ID=").append(ND1XC9e7);
						DB.executeUpdate(UzlTtUF5.toString());
						continue;
					}
					try {
						wr0CZ4aI = (DB.getNextID(m_AD_Client_ID, "C_BPartner_Location", null));
						log.finest("C_BPartner_Location_ID es : " + wr0CZ4aI);
						if (wr0CZ4aI <= 0) {
							throw new DBException("No NextID (" + wr0CZ4aI + ")");
						}
						gc8BrmPZ.setInt(1, wr0CZ4aI);
						gc8BrmPZ.setInt(2, vBK7OGaI);
						gc8BrmPZ.setInt(3, Iw0mrFmj);
						gc8BrmPZ.setInt(4, ND1XC9e7);
						mdMQcuRX = gc8BrmPZ.executeUpdate();
						log.finest("Insert BP Location = " + mdMQcuRX);
					} catch (Exception DUjQPSVY) {
						log.finest("Insert BPLocation - " + DUjQPSVY.toString());
						bm13bLnl.rollback();
						lfGZjUBY--;
						UzlTtUF5 = new StringBuffer(
								"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
										.append(DB.TO_STRING("Insert BPLocation: " + DUjQPSVY.toString()))
										.append(" WHERE I_BPartner_ID=").append(ND1XC9e7);
						DB.executeUpdate(UzlTtUF5.toString());
						continue;
					}
				}
				if (yneIy3OC != 0) {
					U7qwmBEB.setInt(1, ND1XC9e7);
					U7qwmBEB.setInt(2, yneIy3OC);
					try {
						mdMQcuRX = U7qwmBEB.executeUpdate();
						log.finest("Update BP Contact = " + mdMQcuRX);
					} catch (SQLException odE1IxJU) {
						log.finest("Update BP Contact - " + odE1IxJU.toString());
						bm13bLnl.rollback();
						lfGZjUBY--;
						UzlTtUF5 = new StringBuffer(
								"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
										.append(DB.TO_STRING("Update BP Contact: " + odE1IxJU.toString()))
										.append(" WHERE I_BPartner_ID=").append(ND1XC9e7);
						DB.executeUpdate(UzlTtUF5.toString());
						continue;
					}
				} else if (k3jr2opk) {
					try {
						yneIy3OC = DB.getNextID(m_AD_Client_ID, "AD_User", null);
						if (yneIy3OC <= 0) {
							throw new DBException("No NextID (" + yneIy3OC + ")");
						}
						g33Rmq47.setInt(1, yneIy3OC);
						g33Rmq47.setInt(2, vBK7OGaI);
						if (wr0CZ4aI == 0) {
							g33Rmq47.setNull(3, Types.NUMERIC);
						} else {
							g33Rmq47.setInt(3, wr0CZ4aI);
						}
						g33Rmq47.setInt(4, ND1XC9e7);
						mdMQcuRX = g33Rmq47.executeUpdate();
						log.finest("Insert BP Contact = " + mdMQcuRX);
					} catch (Exception NpOZ7byu) {
						log.finest("Insert BPContact - " + NpOZ7byu.toString());
						bm13bLnl.rollback();
						lfGZjUBY--;
						UzlTtUF5 = new StringBuffer(
								"UPDATE I_BPartner i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
										.append(DB.TO_STRING("Insert BPContact: " + NpOZ7byu.toString()))
										.append(" WHERE I_BPartner_ID=").append(ND1XC9e7);
						DB.executeUpdate(UzlTtUF5.toString());
						continue;
					}
				}
				ZoxopUTk.setInt(1, vBK7OGaI);
				if (wr0CZ4aI == 0) {
					ZoxopUTk.setNull(2, Types.NUMERIC);
				} else {
					ZoxopUTk.setInt(2, wr0CZ4aI);
				}
				if (yneIy3OC == 0) {
					ZoxopUTk.setNull(3, Types.NUMERIC);
				} else {
					ZoxopUTk.setInt(3, yneIy3OC);
				}
				ZoxopUTk.setInt(4, ND1XC9e7);
				mdMQcuRX = ZoxopUTk.executeUpdate();
				bm13bLnl.commit();
			}
			fpFrf97O.close();
			fvRD5CyG.close();
			JSxBrPp6.close();
			PWp5LTXs.close();
			gc8BrmPZ.close();
			g33Rmq47.close();
			U7qwmBEB.close();
			ZoxopUTk.close();
			bm13bLnl.close();
			bm13bLnl = null;
		} catch (SQLException Nz8U5HdT) {
			try {
				if (bm13bLnl != null) {
					bm13bLnl.close();
				}
				bm13bLnl = null;
			} catch (SQLException wrm3zeNZ) {
			}
			throw new Exception("ImportBPartner.doIt", Nz8U5HdT);
		} finally {
			if (bm13bLnl != null) {
				bm13bLnl.close();
			}
			bm13bLnl = null;
		}
		UzlTtUF5 = new StringBuffer(
				"UPDATE I_BPartner " + "SET I_IsImported='N', Updated=current_timestamp " + "WHERE I_IsImported<>'Y'")
						.append(bkJqcncr);
		mdMQcuRX = DB.executeUpdate(UzlTtUF5.toString());
		addLog(0, null, new BigDecimal(mdMQcuRX), "@Errors@");
		addLog(0, null, new BigDecimal(lfGZjUBY), "@C_BPartner_ID@: @Inserted@");
		addLog(0, null, new BigDecimal(osJkwAAv), "@C_BPartner_ID@: @Updated@");
		return "";
	}

}