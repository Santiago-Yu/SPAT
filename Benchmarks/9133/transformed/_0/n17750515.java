class n17750515 {
	public SukuData updatePerson(String uxx8yTpg, SukuData wF5xfc32) {
		String UJKKPyJi;
		String tKB7WcZc = Utils.toUsAscii(uxx8yTpg);
		if (tKB7WcZc != null && tKB7WcZc.length() > 16) {
			tKB7WcZc = tKB7WcZc.substring(0, 16);
		}
		StringBuilder ER6dKqN6 = new StringBuilder();
		ER6dKqN6.append("insert into unit (pid,tag,privacy,groupid,sex,sourcetext,privatetext,userrefn");
		if (tKB7WcZc != null) {
			ER6dKqN6.append(",createdby");
		}
		ER6dKqN6.append(") values (?,?,?,?,?,?,?,? ");
		if (tKB7WcZc != null) {
			ER6dKqN6.append(",'" + tKB7WcZc + "'");
		}
		ER6dKqN6.append(")");
		UJKKPyJi = ER6dKqN6.toString();
		String ZSMse4P5;
		ER6dKqN6 = new StringBuilder();
		ER6dKqN6.append(
				"update unit set privacy=?,groupid=?,sex=?,sourcetext=?," + "privatetext=?,userrefn=?,Modified=now()");
		if (tKB7WcZc != null) {
			ER6dKqN6.append(",modifiedby = '" + tKB7WcZc + "' where pid = ?");
		} else {
			ER6dKqN6.append(" where pid = ?");
		}
		ZSMse4P5 = ER6dKqN6.toString();
		ER6dKqN6 = new StringBuilder();
		String XdD3cQBo;
		ER6dKqN6.append("update unitnotice set ");
		ER6dKqN6.append("surety=?,Privacy=?,NoticeType=?,Description=?,");
		ER6dKqN6.append("DatePrefix=?,FromDate=?,ToDate=?,Place=?,");
		ER6dKqN6.append("Village=?,Farm=?,Croft=?,Address=?,");
		ER6dKqN6.append("PostalCode=?,PostOffice=?,State=?,Country=?,Email=?,");
		ER6dKqN6.append("NoteText=?,MediaFilename=?,MediaTitle=?,Prefix=?,");
		ER6dKqN6.append("Surname=?,Givenname=?,Patronym=?,PostFix=?,");
		ER6dKqN6.append("SourceText=?,PrivateText=?,RefNames=?,RefPlaces=?,Modified=now()");
		if (tKB7WcZc != null) {
			ER6dKqN6.append(",modifiedby = '" + tKB7WcZc + "'");
		}
		ER6dKqN6.append(" where pnid = ?");
		XdD3cQBo = ER6dKqN6.toString();
		ER6dKqN6 = new StringBuilder();
		String b5iuyyAm;
		ER6dKqN6.append("insert into unitnotice  (");
		ER6dKqN6.append("surety,Privacy,NoticeType,Description,");
		ER6dKqN6.append("DatePrefix,FromDate,ToDate,Place,");
		ER6dKqN6.append("Village,Farm,Croft,Address,");
		ER6dKqN6.append("PostalCode,PostOffice,State,Country,Email,");
		ER6dKqN6.append("NoteText,MediaFilename,MediaTitle,Prefix,");
		ER6dKqN6.append("Surname,Givenname,Patronym,PostFix,");
		ER6dKqN6.append("SourceText,PrivateText,RefNames,Refplaces,pnid,pid,tag");
		if (tKB7WcZc != null) {
			ER6dKqN6.append(",createdby");
		}
		ER6dKqN6.append(") values (");
		ER6dKqN6.append("?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,");
		ER6dKqN6.append("?,?,?,?,?,?,?,?");
		if (tKB7WcZc != null) {
			ER6dKqN6.append(",'" + tKB7WcZc + "'");
		}
		ER6dKqN6.append(")");
		b5iuyyAm = ER6dKqN6.toString();
		ER6dKqN6 = new StringBuilder();
		String kZMOVh1A;
		ER6dKqN6.append("update unitlanguage set ");
		ER6dKqN6.append("NoticeType=?,Description=?," + "Place=?,");
		ER6dKqN6.append("NoteText=?,MediaTitle=?,Modified=now() ");
		if (tKB7WcZc != null) {
			ER6dKqN6.append(",modifiedby = '" + tKB7WcZc + "'");
		}
		ER6dKqN6.append("where pnid=? and langCode = ?");
		kZMOVh1A = ER6dKqN6.toString();
		ER6dKqN6 = new StringBuilder();
		String P36c40vg;
		ER6dKqN6.append("insert into unitlanguage (pnid,pid,tag,langcode,");
		ER6dKqN6.append("NoticeType,Description,Place,");
		ER6dKqN6.append("NoteText,MediaTitle");
		if (tKB7WcZc != null) {
			ER6dKqN6.append(",createdby");
		}
		ER6dKqN6.append(") values (?,?,?,?,?,?,?,?,?");
		if (tKB7WcZc != null) {
			ER6dKqN6.append(",'" + tKB7WcZc + "'");
		}
		ER6dKqN6.append(")");
		P36c40vg = ER6dKqN6.toString();
		String nx2Hlg3e = "delete from unitlanguage where pnid = ? and langcode = ? ";
		String y5O0nNtu = "update unitnotice set noticerow = ? where pnid = ? ";
		String CJ4hsE6b = "delete from unitnotice where pnid = ? ";
		String qaSswUuS = "delete from Unitlanguage where pnid = ? ";
		SukuData nokF4z8i = new SukuData();
		UnitNotice[] QF7oiEcU = wF5xfc32.persLong.getNotices();
		if (QF7oiEcU != null) {
			String vJNVGAkr = "";
			String vff1wipk = "";
			for (int Wu4ObmHf = 0; Wu4ObmHf < QF7oiEcU.length; Wu4ObmHf++) {
				if (QF7oiEcU[Wu4ObmHf].getTag().equals("NAME")) {
					String jUSEevyG = Utils.nv(QF7oiEcU[Wu4ObmHf].getGivenname()) + "/"
							+ Utils.nv(QF7oiEcU[Wu4ObmHf].getPatronym()) + "/"
							+ Utils.nv(QF7oiEcU[Wu4ObmHf].getPrefix()) + "/" + Utils.nv(QF7oiEcU[Wu4ObmHf].getSurname())
							+ "/" + Utils.nv(QF7oiEcU[Wu4ObmHf].getPostfix());
					if (jUSEevyG.equals(vJNVGAkr) && !vJNVGAkr.equals("")) {
						if (QF7oiEcU[Wu4ObmHf].isToBeDeleted() == false) {
							String rDiydNzM = Resurses.getString("IDENTICAL_NAMES_ERROR") + " ["
									+ wF5xfc32.persLong.getPid() + "] idx [" + Wu4ObmHf + "] = " + jUSEevyG;
							logger.warning(rDiydNzM);
							if (wF5xfc32.persLong.getPid() > 0) {
								nokF4z8i.resu = rDiydNzM;
								return nokF4z8i;
							}
						}
					}
					vJNVGAkr = jUSEevyG;
				} else if (QF7oiEcU[Wu4ObmHf].getTag().equals("OCCU")) {
					String tUCcwnsk = Utils.nv(QF7oiEcU[Wu4ObmHf].getDescription());
					if (tUCcwnsk.equals(vff1wipk) && !vff1wipk.equals("")) {
						if (QF7oiEcU[Wu4ObmHf].isToBeDeleted() == false) {
							String tRd2RCOX = Resurses.getString("IDENTICAL_OCCU_ERROR") + " ["
									+ wF5xfc32.persLong.getPid() + "] idx [" + Wu4ObmHf + "] = '" + tUCcwnsk + "'";
							logger.warning(tRd2RCOX);
							if (wF5xfc32.persLong.getPid() > 0) {
								nokF4z8i.resu = tRd2RCOX;
								return nokF4z8i;
							}
						}
					}
					vff1wipk = tUCcwnsk;
				}
			}
		}
		int baPSgt0Z = 0;
		try {
			con.setAutoCommit(false);
			Statement JC01Ex79;
			PreparedStatement wSk1VRO4;
			if (wF5xfc32.persLong.getPid() > 0) {
				nokF4z8i.resultPid = wF5xfc32.persLong.getPid();
				baPSgt0Z = wF5xfc32.persLong.getPid();
				if (wF5xfc32.persLong.isMainModified()) {
					if (wF5xfc32.persLong.getModified() == null) {
						wSk1VRO4 = con.prepareStatement(ZSMse4P5 + " and modified is null ");
					} else {
						wSk1VRO4 = con.prepareStatement(ZSMse4P5 + " and modified = ?");
					}
					wSk1VRO4.setString(1, wF5xfc32.persLong.getPrivacy());
					wSk1VRO4.setString(2, wF5xfc32.persLong.getGroupId());
					wSk1VRO4.setString(3, wF5xfc32.persLong.getSex());
					wSk1VRO4.setString(4, wF5xfc32.persLong.getSource());
					wSk1VRO4.setString(5, wF5xfc32.persLong.getPrivateText());
					wSk1VRO4.setString(6, wF5xfc32.persLong.getRefn());
					wSk1VRO4.setInt(7, wF5xfc32.persLong.getPid());
					if (wF5xfc32.persLong.getModified() != null) {
						wSk1VRO4.setTimestamp(8, wF5xfc32.persLong.getModified());
					}
					int wobpg8L5 = wSk1VRO4.executeUpdate();
					if (wobpg8L5 != 1) {
						logger.warning(
								"Person update for pid " + baPSgt0Z + " failed [" + wobpg8L5 + "] (Should be 1)");
						throw new SQLException("TRANSACTION_ERROR_1");
					}
					String iCxqwRKf = null;
					String lBoqStWB = null;
					String MztSGhSf = null;
					String PgmIXdzT = null;
					if (wF5xfc32.persLong.getSex().equals("M")) {
						iCxqwRKf = "FATH";
						lBoqStWB = "MOTH";
						MztSGhSf = "HUSB";
						PgmIXdzT = "WIFE";
					} else if (wF5xfc32.persLong.getSex().equals("F")) {
						lBoqStWB = "FATH";
						iCxqwRKf = "MOTH";
						PgmIXdzT = "HUSB";
						MztSGhSf = "WIFE";
					}
					if (iCxqwRKf != null) {
						String xJWLzj2Y = "update relation as b set tag=? "
								+ "where b.rid in (select a.rid from relation as a "
								+ "where a.pid = ? and a.pid <> b.rid and a.tag='CHIL')	" + "and tag=?";
						PreparedStatement Vm5ivOCD = con.prepareStatement(xJWLzj2Y);
						Vm5ivOCD.setString(1, iCxqwRKf);
						Vm5ivOCD.setInt(2, wF5xfc32.persLong.getPid());
						Vm5ivOCD.setString(3, lBoqStWB);
						int r5xmEF2T = Vm5ivOCD.executeUpdate();
						logger.fine("updated count for person parent= " + r5xmEF2T);
						String gVZaAli5 = "update relation as b set tag=? " + "where b.rid in (select a.rid "
								+ "from relation as a where a.pid = ? and a.pid <> b.pid "
								+ "and a.tag in ('HUSB','WIFE')) and tag=?";
						Vm5ivOCD = con.prepareStatement(gVZaAli5);
						Vm5ivOCD.setString(1, MztSGhSf);
						Vm5ivOCD.setInt(2, wF5xfc32.persLong.getPid());
						Vm5ivOCD.setString(3, PgmIXdzT);
						r5xmEF2T = Vm5ivOCD.executeUpdate();
						logger.fine("updated count for person spouse= " + r5xmEF2T);
					}
				}
			} else {
				JC01Ex79 = con.createStatement();
				ResultSet lDfnov6y = JC01Ex79.executeQuery("select nextval('unitseq')");
				if (lDfnov6y.next()) {
					baPSgt0Z = lDfnov6y.getInt(1);
					nokF4z8i.resultPid = baPSgt0Z;
				} else {
					throw new SQLException("Sequence unitseq error");
				}
				lDfnov6y.close();
				wSk1VRO4 = con.prepareStatement(UJKKPyJi);
				wSk1VRO4.setInt(1, baPSgt0Z);
				wSk1VRO4.setString(2, wF5xfc32.persLong.getTag());
				wSk1VRO4.setString(3, wF5xfc32.persLong.getPrivacy());
				wSk1VRO4.setString(4, wF5xfc32.persLong.getGroupId());
				wSk1VRO4.setString(5, wF5xfc32.persLong.getSex());
				wSk1VRO4.setString(6, wF5xfc32.persLong.getSource());
				wSk1VRO4.setString(7, wF5xfc32.persLong.getPrivateText());
				wSk1VRO4.setString(8, wF5xfc32.persLong.getRefn());
				int TZPqg0LU = wSk1VRO4.executeUpdate();
				if (TZPqg0LU != 1) {
					logger.warning("Person created for pid " + baPSgt0Z + "  gave result " + TZPqg0LU);
				}
			}
			PreparedStatement EDvG2vE5 = con.prepareStatement(CJ4hsE6b);
			PreparedStatement ltZq84HT = con.prepareStatement(qaSswUuS);
			PreparedStatement Ii43eBDf = con.prepareStatement(y5O0nNtu);
			if (QF7oiEcU != null) {
				for (int FwEPbPLs = 0; FwEPbPLs < QF7oiEcU.length; FwEPbPLs++) {
					UnitNotice ZqSfN9ZP = QF7oiEcU[FwEPbPLs];
					int XLGR2IQZ = 0;
					if (ZqSfN9ZP.isToBeDeleted()) {
						ltZq84HT.setInt(1, ZqSfN9ZP.getPnid());
						int kT5BUtHo = ltZq84HT.executeUpdate();
						EDvG2vE5.setInt(1, ZqSfN9ZP.getPnid());
						int Lco5g1nu = EDvG2vE5.executeUpdate();
						if (Lco5g1nu != 1) {
							logger.warning("Person notice [" + ZqSfN9ZP.getTag() + "]delete for pid " + baPSgt0Z
									+ " failed [" + Lco5g1nu + "] (Should be 1)");
							throw new SQLException("TRANSACTION_ERROR_2");
						}
						String STSPc28i = "Poistettiin " + Lco5g1nu + " rivi? [" + kT5BUtHo + "] kieliversiota pid = "
								+ ZqSfN9ZP.getPid() + " tag=" + ZqSfN9ZP.getTag();
						logger.fine(STSPc28i);
					} else if (ZqSfN9ZP.getPnid() == 0 || ZqSfN9ZP.isToBeUpdated()) {
						if (ZqSfN9ZP.getPnid() == 0) {
							JC01Ex79 = con.createStatement();
							ResultSet c0Lnbty1 = JC01Ex79.executeQuery("select nextval('unitnoticeseq')");
							if (c0Lnbty1.next()) {
								XLGR2IQZ = c0Lnbty1.getInt(1);
							} else {
								throw new SQLException("Sequence unitnoticeseq error");
							}
							c0Lnbty1.close();
							wSk1VRO4 = con.prepareStatement(b5iuyyAm);
						} else {
							if (ZqSfN9ZP.getModified() == null) {
								wSk1VRO4 = con.prepareStatement(XdD3cQBo + " and modified is null ");
							} else {
								wSk1VRO4 = con.prepareStatement(XdD3cQBo + " and modified = ?");
							}
							XLGR2IQZ = ZqSfN9ZP.getPnid();
						}
						if (ZqSfN9ZP.isToBeUpdated() || ZqSfN9ZP.getPnid() == 0) {
							wSk1VRO4.setInt(1, ZqSfN9ZP.getSurety());
							wSk1VRO4.setString(2, ZqSfN9ZP.getPrivacy());
							wSk1VRO4.setString(3, ZqSfN9ZP.getNoticeType());
							wSk1VRO4.setString(4, ZqSfN9ZP.getDescription());
							wSk1VRO4.setString(5, ZqSfN9ZP.getDatePrefix());
							wSk1VRO4.setString(6, ZqSfN9ZP.getFromDate());
							wSk1VRO4.setString(7, ZqSfN9ZP.getToDate());
							wSk1VRO4.setString(8, ZqSfN9ZP.getPlace());
							wSk1VRO4.setString(9, ZqSfN9ZP.getVillage());
							wSk1VRO4.setString(10, ZqSfN9ZP.getFarm());
							wSk1VRO4.setString(11, ZqSfN9ZP.getCroft());
							wSk1VRO4.setString(12, ZqSfN9ZP.getAddress());
							wSk1VRO4.setString(13, ZqSfN9ZP.getPostalCode());
							wSk1VRO4.setString(14, ZqSfN9ZP.getPostOffice());
							wSk1VRO4.setString(15, ZqSfN9ZP.getState());
							wSk1VRO4.setString(16, ZqSfN9ZP.getCountry());
							wSk1VRO4.setString(17, ZqSfN9ZP.getEmail());
							wSk1VRO4.setString(18, ZqSfN9ZP.getNoteText());
							wSk1VRO4.setString(19, ZqSfN9ZP.getMediaFilename());
							wSk1VRO4.setString(20, ZqSfN9ZP.getMediaTitle());
							wSk1VRO4.setString(21, ZqSfN9ZP.getPrefix());
							wSk1VRO4.setString(22, ZqSfN9ZP.getSurname());
							wSk1VRO4.setString(23, ZqSfN9ZP.getGivenname());
							wSk1VRO4.setString(24, ZqSfN9ZP.getPatronym());
							wSk1VRO4.setString(25, ZqSfN9ZP.getPostfix());
							wSk1VRO4.setString(26, ZqSfN9ZP.getSource());
							wSk1VRO4.setString(27, ZqSfN9ZP.getPrivateText());
							if (ZqSfN9ZP.getRefNames() == null) {
								wSk1VRO4.setNull(28, Types.ARRAY);
							} else {
								Array aCwxh4mH = con.createArrayOf("varchar", ZqSfN9ZP.getRefNames());
								wSk1VRO4.setArray(28, aCwxh4mH);
							}
							if (ZqSfN9ZP.getRefPlaces() == null) {
								wSk1VRO4.setNull(29, Types.ARRAY);
							} else {
								Array Nkh96iW1 = con.createArrayOf("varchar", ZqSfN9ZP.getRefPlaces());
								wSk1VRO4.setArray(29, Nkh96iW1);
							}
						}
						if (ZqSfN9ZP.getPnid() > 0) {
							wSk1VRO4.setInt(30, ZqSfN9ZP.getPnid());
							if (ZqSfN9ZP.getModified() != null) {
								wSk1VRO4.setTimestamp(31, ZqSfN9ZP.getModified());
							}
							int V4G9yeVl = wSk1VRO4.executeUpdate();
							if (V4G9yeVl != 1) {
								logger.warning("Person notice [" + ZqSfN9ZP.getTag() + "] update for pid " + baPSgt0Z
										+ " failed [" + V4G9yeVl + "] (Should be 1)");
								throw new SQLException("TRANSACTION_ERROR_3");
							}
							logger.fine("P?ivitettiin " + V4G9yeVl + " tietuetta pnid=[" + ZqSfN9ZP.getPnid() + "]");
						} else {
							wSk1VRO4.setInt(30, XLGR2IQZ);
							wSk1VRO4.setInt(31, baPSgt0Z);
							wSk1VRO4.setString(32, ZqSfN9ZP.getTag());
							int H4fk0NXr = wSk1VRO4.executeUpdate();
							logger.fine("Luotiin " + H4fk0NXr + " tietue pnid=[" + XLGR2IQZ + "]");
						}
						if (ZqSfN9ZP.getMediaData() == null) {
							String fsbWu03d = "update unitnotice set mediadata = null where pnid = ?";
							wSk1VRO4 = con.prepareStatement(fsbWu03d);
							wSk1VRO4.setInt(1, XLGR2IQZ);
							int rlrjcGxj = wSk1VRO4.executeUpdate();
							if (rlrjcGxj != 1) {
								logger.warning(
										"media deleted for pnid " + ZqSfN9ZP.getPnid() + " gave result " + rlrjcGxj);
							}
						} else {
							String pVl7GM8S = "update UnitNotice set MediaData = ?,"
									+ "mediaWidth = ?,mediaheight = ? where PNID = ? ";
							PreparedStatement VPkcFCjf = this.con.prepareStatement(pVl7GM8S);
							VPkcFCjf.setBytes(1, ZqSfN9ZP.getMediaData());
							Dimension HC2sF7Ew = ZqSfN9ZP.getMediaSize();
							VPkcFCjf.setInt(2, HC2sF7Ew.width);
							VPkcFCjf.setInt(3, HC2sF7Ew.height);
							VPkcFCjf.setInt(4, XLGR2IQZ);
							VPkcFCjf.executeUpdate();
						}
					}
					if (ZqSfN9ZP.getLanguages() != null) {
						for (int XLJcSPAj = 0; XLJcSPAj < ZqSfN9ZP.getLanguages().length; XLJcSPAj++) {
							UnitLanguage JIuJNhx3 = ZqSfN9ZP.getLanguages()[XLJcSPAj];
							if (JIuJNhx3.isToBeDeleted()) {
								if (JIuJNhx3.getPnid() > 0) {
									wSk1VRO4 = con.prepareStatement(nx2Hlg3e);
									wSk1VRO4.setInt(1, JIuJNhx3.getPnid());
									wSk1VRO4.setString(2, JIuJNhx3.getLangCode());
									int hf3wOVyA = wSk1VRO4.executeUpdate();
									if (hf3wOVyA != 1) {
										logger.warning("language deleted for pnid " + ZqSfN9ZP.getPnid() + " ["
												+ JIuJNhx3.getLangCode() + "] gave result " + hf3wOVyA);
									}
								}
							}
							if (JIuJNhx3.isToBeUpdated()) {
								if (JIuJNhx3.getPnid() == 0) {
									wSk1VRO4 = con.prepareStatement(P36c40vg);
									wSk1VRO4.setInt(1, ZqSfN9ZP.getPnid());
									wSk1VRO4.setInt(2, baPSgt0Z);
									wSk1VRO4.setString(3, ZqSfN9ZP.getTag());
									wSk1VRO4.setString(4, JIuJNhx3.getLangCode());
									wSk1VRO4.setString(5, JIuJNhx3.getNoticeType());
									wSk1VRO4.setString(6, JIuJNhx3.getDescription());
									wSk1VRO4.setString(7, JIuJNhx3.getPlace());
									wSk1VRO4.setString(8, JIuJNhx3.getNoteText());
									wSk1VRO4.setString(9, JIuJNhx3.getMediaTitle());
									int fZUsNJy3 = wSk1VRO4.executeUpdate();
									if (fZUsNJy3 != 1) {
										logger.warning("language added for pnid " + ZqSfN9ZP.getPnid() + " ["
												+ JIuJNhx3.getLangCode() + "] gave result " + fZUsNJy3);
									}
								} else {
									wSk1VRO4 = con.prepareStatement(kZMOVh1A);
									wSk1VRO4.setString(1, JIuJNhx3.getNoticeType());
									wSk1VRO4.setString(2, JIuJNhx3.getDescription());
									wSk1VRO4.setString(3, JIuJNhx3.getPlace());
									wSk1VRO4.setString(4, JIuJNhx3.getNoteText());
									wSk1VRO4.setString(5, JIuJNhx3.getMediaTitle());
									wSk1VRO4.setInt(6, JIuJNhx3.getPnid());
									wSk1VRO4.setString(7, JIuJNhx3.getLangCode());
									int EgcKdNuf = wSk1VRO4.executeUpdate();
									if (EgcKdNuf != 1) {
										logger.warning("language for pnid " + JIuJNhx3.getPnid() + " ["
												+ JIuJNhx3.getLangCode() + "] gave result " + EgcKdNuf);
									}
									wSk1VRO4.close();
								}
							}
						}
					}
					if (ZqSfN9ZP.getPnid() > 0) {
						XLGR2IQZ = ZqSfN9ZP.getPnid();
					}
					Ii43eBDf.setInt(1, FwEPbPLs + 1);
					Ii43eBDf.setInt(2, XLGR2IQZ);
					Ii43eBDf.executeUpdate();
				}
			}
			if (wF5xfc32.relations != null) {
				if (wF5xfc32.persLong.getPid() == 0) {
					wF5xfc32.persLong.setPid(baPSgt0Z);
					for (int MecZbSFU = 0; MecZbSFU < wF5xfc32.relations.length; MecZbSFU++) {
						Relation WeJHKlnX = wF5xfc32.relations[MecZbSFU];
						if (WeJHKlnX.getPid() == 0) {
							WeJHKlnX.setPid(baPSgt0Z);
						}
					}
				}
				updateRelations(tKB7WcZc, wF5xfc32);
			}
			con.commit();
		} catch (Exception egqxL2Yz) {
			try {
				con.rollback();
			} catch (SQLException fRw62MFD) {
				logger.log(Level.WARNING, "Person update rollback failed", fRw62MFD);
			}
			logger.log(Level.WARNING, "person update rolled back for [" + baPSgt0Z + "]", egqxL2Yz);
			nokF4z8i.resu = egqxL2Yz.getMessage();
			return nokF4z8i;
		} finally {
			try {
				con.setAutoCommit(true);
			} catch (SQLException jzaNAwwM) {
				logger.log(Level.WARNING, "set autocommit failed", jzaNAwwM);
			}
		}
		return nokF4z8i;
	}

}