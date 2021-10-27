class n5021563 {
	private String AddAction(ResultSet ntKTrPFa, String WUJWyFBr) throws SQLException {
		Connection JSPmL1b6 = null;
		Connection uuVkqHsp = null;
		String SL8yASab = boRepository.getDefaultSchemaName(boApplication.getDefaultApplication()).toLowerCase();
		try {
			JSPmL1b6 = this.getRepositoryConnection(p_ctx.getApplication(),
					p_ctx.getBoSession().getRepository().getName(), 1);
			uuVkqHsp = this.getRepositoryConnection(p_ctx.getApplication(),
					p_ctx.getBoSession().getRepository().getName(), 2);
			String SM7Eluay = null;
			String h5KsrIRs = ntKTrPFa.getString("OBJECTTYPE");
			if (h5KsrIRs.equalsIgnoreCase("T")) {
				boolean yrYEcUNw = existsTable(p_ctx, SL8yASab, ntKTrPFa.getString("OBJECTNAME").toLowerCase());
				String[] drvW2i9o = { "SYS_USER", "SYS_ICN", "SYS_DTCREATE", "SYS_DTSAVE", "SYS_ORIGIN" };
				String[] PEVaSwKy = { "VARCHAR(25)", "NUMERIC(7)", "TIMESTAMP DEFAULT now()", "TIMESTAMP",
						"VARCHAR(30)" };
				String[] cdttSzkT = { "C", "N", "D", "D", "C" };
				String[] X5JdIDJ1 = { "25", "7", "", "", "30" };
				String[] wXvXhYVW = { "", "", "", "", "" };
				String[] VWcReoTB = { "", "", "", "", "" };
				if (!yrYEcUNw && !WUJWyFBr.equals("3")) {
					SM7Eluay = "CREATE TABLE " + ntKTrPFa.getString("OBJECTNAME") + " (";
					for (int bcWL9Mo1 = 0; bcWL9Mo1 < drvW2i9o.length; bcWL9Mo1++) {
						SM7Eluay += (drvW2i9o[bcWL9Mo1] + " " + PEVaSwKy[bcWL9Mo1]
								+ ((bcWL9Mo1 < (drvW2i9o.length - 1)) ? "," : ")"));
					}
					String ZCsSx0rr = ntKTrPFa.getString("OBJECTNAME");
					if (ntKTrPFa.getString("SCHEMA").equals("DEF")) {
						ZCsSx0rr = "NGD_" + ZCsSx0rr;
					} else if (ntKTrPFa.getString("SCHEMA").equals("SYS")) {
						ZCsSx0rr = "SYS_" + ZCsSx0rr;
					}
					executeDDL(SM7Eluay, ntKTrPFa.getString("SCHEMA"));
				}
				if (WUJWyFBr.equals("3") && yrYEcUNw) {
					executeDDL("DROP TABLE " + ntKTrPFa.getString("OBJECTNAME"), ntKTrPFa.getString("SCHEMA"));
					CallableStatement BkY2dctu = uuVkqHsp.prepareCall("DELETE FROM NGTDIC WHERE TABLENAME=?");
					BkY2dctu.setString(1, ntKTrPFa.getString("OBJECTNAME"));
					BkY2dctu.executeUpdate();
					BkY2dctu.close();
				}
				checkDicFields(ntKTrPFa.getString("OBJECTNAME"), ntKTrPFa.getString("SCHEMA"), drvW2i9o, cdttSzkT,
						X5JdIDJ1, wXvXhYVW, VWcReoTB);
			}
			if (h5KsrIRs.equalsIgnoreCase("F")) {
				boolean AVf7NEmW = false;
				boolean NDkq30ej = false;
				PreparedStatement NhPk6bC8 = JSPmL1b6.prepareStatement(
						"select column_name,udt_name,character_maximum_length,numeric_precision,numeric_scale from information_schema.columns"
								+ "  where table_name=? and column_name=? and table_schema=?");
				NhPk6bC8.setString(1, ntKTrPFa.getString("TABLENAME").toLowerCase());
				NhPk6bC8.setString(2, ntKTrPFa.getString("OBJECTNAME").toLowerCase());
				NhPk6bC8.setString(3, SL8yASab);
				ResultSet GjXuZhw0 = NhPk6bC8.executeQuery();
				if (GjXuZhw0.next()) {
					int JmtMGcd5 = GjXuZhw0.getInt(3);
					int KmFA3rAC = GjXuZhw0.getInt(5);
					if (",C,N,".indexOf("," + getNgtFieldTypeFromDDL(GjXuZhw0.getString(2)) + ",") != -1) {
						if (getNgtFieldTypeFromDDL(GjXuZhw0.getString(2)).equals("N")) {
							JmtMGcd5 = GjXuZhw0.getInt(4);
						}
						if (KmFA3rAC != 0) {
							if (!(JmtMGcd5 + "," + KmFA3rAC).equals(ntKTrPFa.getString("FIELDSIZE"))) {
								AVf7NEmW = true;
							}
						} else {
							if (!((JmtMGcd5 == 0) && ((ntKTrPFa.getString("FIELDSIZE") == null)
									|| (ntKTrPFa.getString("FIELDSIZE").length() == 0)))) {
								if (!("" + JmtMGcd5).equals(ntKTrPFa.getString("FIELDSIZE"))) {
									AVf7NEmW = true;
								}
							}
						}
					}
					NDkq30ej = true;
				} else {
					NDkq30ej = false;
				}
				GjXuZhw0.close();
				NhPk6bC8.close();
				boolean almtezpx = false;
				if (("20".indexOf(WUJWyFBr) != -1) && !NDkq30ej) {
					SM7Eluay = "ALTER TABLE " + ntKTrPFa.getString("TABLENAME") + " add \""
							+ ntKTrPFa.getString("OBJECTNAME").toLowerCase() + "\" ";
				} else if (("20".indexOf(WUJWyFBr) != -1) && NDkq30ej && AVf7NEmW) {
					SM7Eluay = "ALTER TABLE " + ntKTrPFa.getString("TABLENAME") + " ALTER COLUMN \""
							+ ntKTrPFa.getString("OBJECTNAME").toLowerCase() + "\" ";
				} else if (WUJWyFBr.equals("3") && NDkq30ej) {
					SM7Eluay = "ALTER TABLE " + ntKTrPFa.getString("TABLENAME") + " drop  COLUMN \""
							+ ntKTrPFa.getString("OBJECTNAME").toLowerCase() + "\" ";
					String BUxznBL6 = "SELECT tc.constraint_name,tc.constraint_type"
							+ " FROM information_schema.table_constraints tc"
							+ " LEFT JOIN information_schema.key_column_usage kcu"
							+ " ON tc.constraint_catalog = kcu.constraint_catalog"
							+ " AND tc.constraint_schema = kcu.constraint_schema"
							+ " AND tc.constraint_name = kcu.constraint_name"
							+ " LEFT JOIN information_schema.referential_constraints rc"
							+ " ON tc.constraint_catalog = rc.constraint_catalog"
							+ " AND tc.constraint_schema = rc.constraint_schema"
							+ " AND tc.constraint_name = rc.constraint_name"
							+ " LEFT JOIN information_schema.constraint_column_usage ccu"
							+ " ON rc.unique_constraint_catalog = ccu.constraint_catalog"
							+ " AND rc.unique_constraint_schema = ccu.constraint_schema"
							+ " AND rc.unique_constraint_name = ccu.constraint_name" + " WHERE tc.table_name = ?"
							+ " AND kcu.column_name = ?" + " and tc.table_schema=?";
					PreparedStatement VEze3FJj = JSPmL1b6.prepareStatement(BUxznBL6);
					VEze3FJj.setString(1, ntKTrPFa.getString("TABLENAME").toLowerCase());
					VEze3FJj.setString(2, ntKTrPFa.getString("OBJECTNAME").toLowerCase());
					VEze3FJj.setString(3, SL8yASab);
					ResultSet tdYKmEzT = VEze3FJj.executeQuery();
					while (tdYKmEzT.next()) {
						String EJkW80E6 = tdYKmEzT.getString(1);
						String JqzWPWyo = tdYKmEzT.getString(2);
						PreparedStatement mNVtOSuW = uuVkqHsp.prepareStatement(
								"DELETE FROM NGTDIC WHERE TABLENAME=? AND OBJECTTYPE=? AND OBJECTNAME=?");
						mNVtOSuW.setString(1, ntKTrPFa.getString("TABLENAME"));
						mNVtOSuW.setString(2, JqzWPWyo.equals("R") ? "FK" : "PK");
						mNVtOSuW.setString(3, EJkW80E6);
						int o5ja8OBN = mNVtOSuW.executeUpdate();
						NhPk6bC8.close();
						executeDDL("ALTER TABLE " + ntKTrPFa.getString("TABLENAME") + " DROP CONSTRAINT " + EJkW80E6,
								ntKTrPFa.getString("SCHEMA"));
					}
					tdYKmEzT.close();
					VEze3FJj.close();
				}
				if ((SM7Eluay != null) && (SM7Eluay.length() > 0) && !WUJWyFBr.equals("3")) {
					String IDzJe5LG = ntKTrPFa.getString("MACROFIELD");
					if ((IDzJe5LG != null) && !(!IDzJe5LG.equals("TEXTOLIVRE") && !IDzJe5LG.equals("NUMEROLIVRE")
							&& !IDzJe5LG.equals("TEXT") && !IDzJe5LG.equals("BLOB") && !IDzJe5LG.equals("MDATA"))) {
						String WW5sJQak = "";
						if (IDzJe5LG.equals("TEXTOLIVRE")) {
							WW5sJQak = "C";
						} else if (IDzJe5LG.equals("NUMEROLIVRE")) {
							WW5sJQak = "N";
						} else if (IDzJe5LG.equals("RAW")) {
							WW5sJQak = "RAW";
						} else if (IDzJe5LG.equals("TIMESTAMP")) {
							WW5sJQak = "TIMESTAMP";
						} else if (IDzJe5LG.equals("MDATA")) {
							WW5sJQak = "D";
						} else if (IDzJe5LG.equals("TEXT")) {
							WW5sJQak = "CL";
						} else if (IDzJe5LG.equals("BLOB")) {
							WW5sJQak = "BL";
						}
						SM7Eluay += getDDLFieldFromNGT(WW5sJQak, ntKTrPFa.getString("FIELDSIZE"));
					} else if ((IDzJe5LG != null) && (IDzJe5LG.length() > 0)) {
						SM7Eluay += getMacrofieldDef(uuVkqHsp, ntKTrPFa.getString("MACROFIELD"));
					} else {
						SM7Eluay += getDDLFieldFromNGT(ntKTrPFa.getString("FIELDTYPE"),
								ntKTrPFa.getString("FIELDSIZE"));
					}
				}
				String[] CE9FmPr2 = new String[1];
				CE9FmPr2[0] = ntKTrPFa.getString("OBJECTNAME");
				if (SM7Eluay != null) {
					executeDDL(SM7Eluay, ntKTrPFa.getString("SCHEMA"));
				}
			}
			if (h5KsrIRs.equalsIgnoreCase("V")) {
				String Bo9Pn8nc = null;
				PreparedStatement RMRf81MD = JSPmL1b6
						.prepareStatement("SELECT view_definition FROM information_schema.views WHERE table_name=? "
								+ "and table_schema=?");
				RMRf81MD.setString(1, ntKTrPFa.getString("OBJECTNAME").toLowerCase());
				RMRf81MD.setString(2, SL8yASab.toLowerCase());
				ResultSet z25diglm = RMRf81MD.executeQuery();
				boolean h9My9mrt = false;
				if (z25diglm.next()) {
					h9My9mrt = true;
					Bo9Pn8nc = z25diglm.getString(1);
					Bo9Pn8nc = Bo9Pn8nc.substring(0, Bo9Pn8nc.length() - 1);
				}
				z25diglm.close();
				RMRf81MD.close();
				if (!WUJWyFBr.equals("3")) {
					String tgalEukC = ntKTrPFa.getString("EXPRESSION");
					if (!tgalEukC.toLowerCase().equals(Bo9Pn8nc)) {
						SM7Eluay = "CREATE OR REPLACE VIEW \"" + ntKTrPFa.getString("OBJECTNAME") + "\" AS \n"
								+ tgalEukC;
						executeDDL(SM7Eluay, ntKTrPFa.getString("SCHEMA"));
					}
				} else {
					if (h9My9mrt) {
						SM7Eluay = "DROP VIEW " + ntKTrPFa.getString("OBJECTNAME");
						executeDDL(SM7Eluay, ntKTrPFa.getString("SCHEMA"));
						CallableStatement PmzLgREO = uuVkqHsp.prepareCall("DELETE FROM NGTDIC WHERE TABLENAME=?");
						PmzLgREO.setString(1, ntKTrPFa.getString("OBJECTNAME"));
						PmzLgREO.executeUpdate();
						PmzLgREO.close();
					}
				}
			}
			if (h5KsrIRs.startsWith("PCK")) {
				String EY6lqLwJ = ntKTrPFa.getString("EXPRESSION");
				String g5yr3q0D = "/*begin_package*/";
				String A9zpStnW = "/*end_package*/";
				if ("02".indexOf(WUJWyFBr) != -1) {
					if (EY6lqLwJ.indexOf(g5yr3q0D) != -1) {
						int YpTviH1A;
						SM7Eluay = EY6lqLwJ.substring(EY6lqLwJ.indexOf(g5yr3q0D),
								YpTviH1A = EY6lqLwJ.indexOf(A9zpStnW));
						SM7Eluay = "create or replace package " + ntKTrPFa.getString("OBJECTNAME") + " is \n" + SM7Eluay
								+ "end " + ntKTrPFa.getString("OBJECTNAME") + ";\n";
						executeDDL(SM7Eluay, ntKTrPFa.getString("SCHEMA"));
						g5yr3q0D = "/*begin_package_body*/";
						A9zpStnW = "/*end_package_body*/";
						if (EY6lqLwJ.indexOf(g5yr3q0D, YpTviH1A) != -1) {
							SM7Eluay = EY6lqLwJ.substring(EY6lqLwJ.indexOf(g5yr3q0D, YpTviH1A),
									EY6lqLwJ.indexOf(A9zpStnW, YpTviH1A));
							SM7Eluay = "create or replace package body " + ntKTrPFa.getString("OBJECTNAME") + " is \n"
									+ SM7Eluay + "end " + ntKTrPFa.getString("OBJECTNAME") + ";\n";
							executeDDL(SM7Eluay, ntKTrPFa.getString("SCHEMA"));
						}
					} else {
					}
				}
			}
			if (h5KsrIRs.startsWith("PK") || h5KsrIRs.startsWith("UN")) {
				String esswbaq5 = "SELECT kcu.column_name" + " FROM information_schema.table_constraints tc"
						+ " LEFT JOIN information_schema.key_column_usage kcu"
						+ " ON tc.constraint_catalog = kcu.constraint_catalog"
						+ " AND tc.constraint_schema = kcu.constraint_schema"
						+ " AND tc.constraint_name = kcu.constraint_name"
						+ " LEFT JOIN information_schema.referential_constraints rc"
						+ " ON tc.constraint_catalog = rc.constraint_catalog"
						+ " AND tc.constraint_schema = rc.constraint_schema"
						+ " AND tc.constraint_name = rc.constraint_name"
						+ " LEFT JOIN information_schema.constraint_column_usage ccu"
						+ " ON rc.unique_constraint_catalog = ccu.constraint_catalog"
						+ " AND rc.unique_constraint_schema = ccu.constraint_schema"
						+ " AND rc.unique_constraint_name = ccu.constraint_name" + " WHERE tc.table_name = ?"
						+ " AND tc.constraint_name = ?" + " and tc.table_schema=? order by ordinal_position";
				PreparedStatement p0FsGKGR = JSPmL1b6.prepareStatement(esswbaq5);
				p0FsGKGR.setString(1, ntKTrPFa.getString("TABLENAME").toLowerCase());
				p0FsGKGR.setString(2, ntKTrPFa.getString("OBJECTNAME").toLowerCase());
				p0FsGKGR.setString(3, SL8yASab.toLowerCase());
				boolean CrjMk08J = h5KsrIRs.startsWith("UN");
				ResultSet ZgJip0oy = p0FsGKGR.executeQuery();
				boolean KBQkcuKA = false;
				StringBuffer Hbgvxceh = new StringBuffer();
				while (ZgJip0oy.next()) {
					if (KBQkcuKA) {
						Hbgvxceh.append(',');
					}
					KBQkcuKA = true;
					Hbgvxceh.append(ZgJip0oy.getString(1));
				}
				boolean SVysrIyS = !Hbgvxceh.toString().toUpperCase().equals(ntKTrPFa.getString("EXPRESSION"));
				ZgJip0oy.close();
				p0FsGKGR.close();
				if ((WUJWyFBr.equals("3") || SVysrIyS) && KBQkcuKA) {
					esswbaq5 = "SELECT tc.constraint_name,tc.table_name"
							+ " FROM information_schema.table_constraints tc"
							+ " LEFT JOIN information_schema.key_column_usage kcu"
							+ " ON tc.constraint_catalog = kcu.constraint_catalog"
							+ " AND tc.constraint_schema = kcu.constraint_schema"
							+ " AND tc.constraint_name = kcu.constraint_name"
							+ " LEFT JOIN information_schema.referential_constraints rc"
							+ " ON tc.constraint_catalog = rc.constraint_catalog"
							+ " AND tc.constraint_schema = rc.constraint_schema"
							+ " AND tc.constraint_name = rc.constraint_name"
							+ " LEFT JOIN information_schema.constraint_column_usage ccu"
							+ " ON rc.unique_constraint_catalog = ccu.constraint_catalog"
							+ " AND rc.unique_constraint_schema = ccu.constraint_schema"
							+ " AND rc.unique_constraint_name = ccu.constraint_name" + " WHERE ccu.constraint_name = ?"
							+ " and tc.table_schema=?";
					PreparedStatement Z4yP8lyF = JSPmL1b6.prepareStatement(esswbaq5);
					Z4yP8lyF.setString(1, ntKTrPFa.getString("OBJECTNAME").toLowerCase());
					Z4yP8lyF.setString(2, SL8yASab.toLowerCase());
					ResultSet j6qwn5dd = Z4yP8lyF.executeQuery();
					while (j6qwn5dd.next()) {
						PreparedStatement sZj1dyZJ = uuVkqHsp.prepareStatement(
								"DELETE NGTDIC WHERE OBJECTNAME=? AND SCHEMA=? AND TABLENAME=? AND OBJECTTYPE='FK'");
						sZj1dyZJ.setString(1, j6qwn5dd.getString(1));
						sZj1dyZJ.setString(2, ntKTrPFa.getString("SCHEMA"));
						sZj1dyZJ.setString(3, j6qwn5dd.getString(2));
						sZj1dyZJ.executeUpdate();
						sZj1dyZJ.close();
						executeDDL(
								"alter table " + j6qwn5dd.getString(2) + "  drop constraint " + j6qwn5dd.getString(1),
								ntKTrPFa.getString("SCHEMA"));
					}
					j6qwn5dd.close();
					Z4yP8lyF.close();
					String F7JPhaIA = "'" + ntKTrPFa.getString("EXPRESSION").toLowerCase().replaceAll(",", "\\',\\'")
							+ "'";
					esswbaq5 = "SELECT tc.constraint_name" + " FROM information_schema.table_constraints tc"
							+ " LEFT JOIN information_schema.key_column_usage kcu"
							+ " ON tc.constraint_catalog = kcu.constraint_catalog"
							+ " AND tc.constraint_schema = kcu.constraint_schema"
							+ " AND tc.constraint_name = kcu.constraint_name"
							+ " LEFT JOIN information_schema.referential_constraints rc"
							+ " ON tc.constraint_catalog = rc.constraint_catalog"
							+ " AND tc.constraint_schema = rc.constraint_schema"
							+ " AND tc.constraint_name = rc.constraint_name"
							+ " LEFT JOIN information_schema.constraint_column_usage ccu"
							+ " ON rc.unique_constraint_catalog = ccu.constraint_catalog"
							+ " AND rc.unique_constraint_schema = ccu.constraint_schema"
							+ " AND rc.unique_constraint_name = ccu.constraint_name" + " WHERE tc.table_name=? and "
							+ "kcu.column_name in (" + F7JPhaIA + ")" + " and tc.table_schema=?";
					Z4yP8lyF = JSPmL1b6.prepareStatement(esswbaq5);
					Z4yP8lyF.setString(1, ntKTrPFa.getString("TABLENAME").toLowerCase());
					Z4yP8lyF.setString(2, SL8yASab.toLowerCase());
					j6qwn5dd = Z4yP8lyF.executeQuery();
					while (j6qwn5dd.next()) {
						PreparedStatement bTGXXJJO = uuVkqHsp.prepareStatement(
								"DELETE NGTDIC WHERE OBJECTNAME=? AND SCHEMA=? AND TABLENAME=? AND OBJECTTYPE='FK'");
						bTGXXJJO.setString(1, j6qwn5dd.getString(1));
						bTGXXJJO.setString(2, ntKTrPFa.getString("SCHEMA"));
						bTGXXJJO.setString(3, ntKTrPFa.getString("TABLENAME"));
						bTGXXJJO.executeUpdate();
						bTGXXJJO.close();
						executeDDL("alter table " + ntKTrPFa.getString("TABLENAME") + " drop constraint "
								+ j6qwn5dd.getString(1), ntKTrPFa.getString("SCHEMA"));
					}
					j6qwn5dd.close();
					Z4yP8lyF.close();
					if (KBQkcuKA && SVysrIyS) {
						SM7Eluay = "alter table " + ntKTrPFa.getString("TABLENAME") + " drop constraint "
								+ ntKTrPFa.getString("OBJECTNAME");
						try {
							executeDDL(SM7Eluay, ntKTrPFa.getString("SCHEMA"));
						} catch (Exception ZDpJ1V5V) {
							logger.warn(LoggerMessageLocalizer.getMessage("ERROR_EXCUTING_DDL") + " (" + SM7Eluay + ") "
									+ ZDpJ1V5V.getMessage());
						}
					}
				}
				if (!WUJWyFBr.equals("3") && (!KBQkcuKA || SVysrIyS)) {
					if (CrjMk08J) {
						SM7Eluay = "alter table " + ntKTrPFa.getString("TABLENAME") + " add constraint "
								+ ntKTrPFa.getString("OBJECTNAME") + " unique (" + ntKTrPFa.getString("EXPRESSION")
								+ ")";
					} else {
						SM7Eluay = "alter table " + ntKTrPFa.getString("TABLENAME") + " add primary key ("
								+ ntKTrPFa.getString("EXPRESSION") + ")";
					}
					executeDDL(SM7Eluay, ntKTrPFa.getString("SCHEMA"));
				}
			}
			if (h5KsrIRs.startsWith("FK")) {
				String lJjcf0bg = "SELECT kcu.column_name" + " FROM information_schema.table_constraints tc"
						+ " LEFT JOIN information_schema.key_column_usage kcu"
						+ " ON tc.constraint_catalog = kcu.constraint_catalog"
						+ " AND tc.constraint_schema = kcu.constraint_schema"
						+ " AND tc.constraint_name = kcu.constraint_name"
						+ " LEFT JOIN information_schema.referential_constraints rc"
						+ " ON tc.constraint_catalog = rc.constraint_catalog"
						+ " AND tc.constraint_schema = rc.constraint_schema"
						+ " AND tc.constraint_name = rc.constraint_name"
						+ " LEFT JOIN information_schema.constraint_column_usage ccu"
						+ " ON rc.unique_constraint_catalog = ccu.constraint_catalog"
						+ " AND rc.unique_constraint_schema = ccu.constraint_schema"
						+ " AND rc.unique_constraint_name = ccu.constraint_name" + " WHERE tc.constraint_name=?"
						+ " and tc.table_name=?" + " and tc.table_schema=? order by ordinal_position";
				PreparedStatement dHffqPyC = JSPmL1b6.prepareStatement(lJjcf0bg);
				dHffqPyC.setString(1, ntKTrPFa.getString("OBJECTNAME").toLowerCase());
				dHffqPyC.setString(2, ntKTrPFa.getString("TABLENAME").toLowerCase());
				dHffqPyC.setString(3, SL8yASab.toLowerCase());
				ResultSet k5Gg6OUK = dHffqPyC.executeQuery();
				boolean NzzyiRIc = false;
				String HwSsY5hD = "";
				String xbMGBHz2 = ntKTrPFa.getString("EXPRESSION");
				if (k5Gg6OUK.next()) {
					NzzyiRIc = true;
					if (HwSsY5hD.length() > 0)
						HwSsY5hD += ",";
					HwSsY5hD += k5Gg6OUK.getString(1);
				}
				k5Gg6OUK.close();
				dHffqPyC.close();
				if (NzzyiRIc && !xbMGBHz2.equals(HwSsY5hD)) {
					SM7Eluay = "alter table " + ntKTrPFa.getString("TABLENAME") + " drop constraint "
							+ ntKTrPFa.getString("OBJECTNAME");
					executeDDL(SM7Eluay, ntKTrPFa.getString("SCHEMA"));
				}
				if (!WUJWyFBr.equals("3") && (!NzzyiRIc || !xbMGBHz2.equals(HwSsY5hD))) {
					SM7Eluay = "alter table " + ntKTrPFa.getString("TABLENAME") + " add constraint "
							+ ntKTrPFa.getString("OBJECTNAME") + " foreign key (" + ntKTrPFa.getString("EXPRESSION")
							+ ") references " + ntKTrPFa.getString("TABLEREFERENCE") + "("
							+ ntKTrPFa.getString("FIELDREFERENCE") + ")";
					executeDDL(SM7Eluay, ntKTrPFa.getString("SCHEMA"));
				}
			}
			if (h5KsrIRs.startsWith("IDX")) {
				boolean ViP6czLK = false;
				String uY8w2Rve = "SELECT n.nspname" + " FROM pg_catalog.pg_class c"
						+ " JOIN pg_catalog.pg_index i ON i.indexrelid = c.oid"
						+ " JOIN pg_catalog.pg_class c2 ON i.indrelid = c2.oid"
						+ " LEFT JOIN pg_catalog.pg_user u ON u.usesysid = c.relowner"
						+ " LEFT JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace"
						+ " where c.relname=? and c.relkind='i' and n.nspname=?";
				PreparedStatement JQZGMl9x = JSPmL1b6.prepareStatement(uY8w2Rve);
				JQZGMl9x.setString(1, ntKTrPFa.getString("OBJECTNAME").toLowerCase());
				JQZGMl9x.setString(2, SL8yASab.toLowerCase());
				ResultSet STMMTkCw = JQZGMl9x.executeQuery();
				boolean DMAMjcL4 = false;
				boolean Jik03OBa = false;
				boolean Wf6UIELy = false;
				String APBVPs1y = "";
				String QkKUST35 = "";
				if (STMMTkCw.next()) {
					Jik03OBa = true;
					if ((ViP6czLK && !(Wf6UIELy = STMMTkCw.getString(1).equals("UNIQUE")))) {
						DMAMjcL4 = true;
					}
					STMMTkCw.close();
					JQZGMl9x.close();
					uY8w2Rve = "SELECT kcu.column_name" + " FROM information_schema.table_constraints tc"
							+ " LEFT JOIN information_schema.key_column_usage kcu"
							+ " ON tc.constraint_catalog = kcu.constraint_catalog"
							+ " AND tc.constraint_schema = kcu.constraint_schema"
							+ " AND tc.constraint_name = kcu.constraint_name"
							+ " LEFT JOIN information_schema.referential_constraints rc"
							+ " ON tc.constraint_catalog = rc.constraint_catalog"
							+ " AND tc.constraint_schema = rc.constraint_schema"
							+ " AND tc.constraint_name = rc.constraint_name"
							+ " LEFT JOIN information_schema.constraint_column_usage ccu"
							+ " ON rc.unique_constraint_catalog = ccu.constraint_catalog"
							+ " AND rc.unique_constraint_schema = ccu.constraint_schema"
							+ " AND rc.unique_constraint_name = ccu.constraint_name" + " WHERE tc.constraint_name=?"
							+ " and tc.table_name=?" + " and tc.table_schema=? and tc.constraint_type='UNIQUE'";
					JQZGMl9x = JSPmL1b6.prepareStatement(uY8w2Rve);
					JQZGMl9x.setString(1, ntKTrPFa.getString("OBJECTNAME").toLowerCase());
					JQZGMl9x.setString(2, ntKTrPFa.getString("TABLENAME").toLowerCase());
					JQZGMl9x.setString(3, SL8yASab.toLowerCase());
					STMMTkCw = JQZGMl9x.executeQuery();
					while (STMMTkCw.next()) {
						APBVPs1y += (((APBVPs1y.length() > 0) ? "," : "") + STMMTkCw.getString(1));
					}
					STMMTkCw.close();
					JQZGMl9x.close();
				} else {
					STMMTkCw.close();
					JQZGMl9x.close();
				}
				String CUjsu5Nc = ntKTrPFa.getString("EXPRESSION");
				String[] o1pmQNUU;
				if (CUjsu5Nc != null) {
					o1pmQNUU = ntKTrPFa.getString("EXPRESSION").split(",");
				} else {
					o1pmQNUU = new String[0];
				}
				for (byte S8WZta5O = 0; S8WZta5O < o1pmQNUU.length; S8WZta5O++) {
					QkKUST35 += (((QkKUST35.length() > 0) ? "," : "") + ((o1pmQNUU[S8WZta5O]).toUpperCase().trim()));
				}
				if (!DMAMjcL4) {
					DMAMjcL4 = (!QkKUST35.equals(APBVPs1y)) && !APBVPs1y.equals("");
				}
				if (Jik03OBa && (DMAMjcL4 || WUJWyFBr.equals("3"))) {
					if (!Wf6UIELy) {
						SM7Eluay = "DROP INDEX " + ntKTrPFa.getString("OBJECTNAME");
					} else {
						SM7Eluay = "ALTER TABLE " + ntKTrPFa.getString("TABLENAME") + " DROP CONSTRAINT "
								+ ntKTrPFa.getString("OBJECTNAME");
					}
					executeDDL(SM7Eluay, ntKTrPFa.getString("SCHEMA"));
					Jik03OBa = false;
				}
				if (!Jik03OBa && !WUJWyFBr.equals("3")) {
					if (!ntKTrPFa.getString("OBJECTNAME").equals("") && !QkKUST35.equals("")) {
						if (!ViP6czLK) {
							SM7Eluay = "CREATE INDEX " + ntKTrPFa.getString("OBJECTNAME") + " ON "
									+ ntKTrPFa.getString("TABLENAME") + "(" + QkKUST35 + ")";
						} else {
							SM7Eluay = "ALTER TABLE " + ntKTrPFa.getString("TABLENAME") + " ADD CONSTRAINT "
									+ ntKTrPFa.getString("OBJECTNAME") + " UNIQUE (" + QkKUST35 + ")";
						}
						executeDDL(SM7Eluay, ntKTrPFa.getString("SCHEMA"));
					}
				}
			}
			updateDictionaryTable(ntKTrPFa, WUJWyFBr);
			return SM7Eluay;
		} catch (SQLException pVa9r6ma) {
			JSPmL1b6.rollback();
			uuVkqHsp.rollback();
			throw (pVa9r6ma);
		} finally {
		}
	}

}