class n8109022 {
	public static void main(String sRppGbSM[]) throws Exception {
		currTime = getCurrentTimestamp();
		String Ot9SyHMU = "";
		String GDK6A8TD = "";
		String od8blOzf = "";
		String wRVRWXYk = "";
		String HaSL10v1 = "";
		String urmKFJ5l = "";
		java.util.Properties AlynSBYb = new java.util.Properties();
		String hCEAyhqb = new LoadDocumentData().getClass().getProtectionDomain().getCodeSource().getLocation()
				.toString().substring(6);
		if (!hCEAyhqb.endsWith("/")) {
			hCEAyhqb += "/";
		}
		hCEAyhqb += "generate.properties";
		if (!hCEAyhqb.startsWith("/")) {
			hCEAyhqb = "/" + hCEAyhqb;
		}
		java.io.FileInputStream k2CDegSP = new java.io.FileInputStream(new java.io.File(hCEAyhqb));
		AlynSBYb.load(k2CDegSP);
		author = AlynSBYb.getProperty("author");
		srcPath = AlynSBYb.getProperty("srcPath");
		driverStr = AlynSBYb.getProperty("driverStr");
		dbConnStr = AlynSBYb.getProperty("dbConnStr");
		dbUsername = AlynSBYb.getProperty("dbUsername");
		dbPassword = AlynSBYb.getProperty("dbPassword");
		openDBConn();
		stat = conn.createStatement();
		Hashtable KkWQh20v = new Hashtable();
		KkWQh20v = getTableKey(conn);
		genUserDefinedIndex(conn, KkWQh20v);
		Integer NuBKmIRL = new Integer(0);
		Integer vx91StLN = new Integer(1);
		Integer Gun5cN2Q = new Integer(1);
		Integer BPse5j2o = new Integer(1);
		Integer G2DxC8fV = new Integer(1);
		Integer Jo8gZxXC = new Integer(1);
		Integer T6J4skFs = new Integer(1);
		Integer EMVmAMXR = null;
		Integer TFD2bFus = null;
		String JIgdTBVI = "1000000001.txt";
		String UXwexzGK = "1000000001";
		if (KkWQh20v.containsKey("DMS_DOCUMENT")) {
			vx91StLN = new Integer(((Integer) KkWQh20v.get("DMS_DOCUMENT")).intValue() + 1);
		}
		if (KkWQh20v.containsKey("DMS_DOCUMENT_DETAIL")) {
			Gun5cN2Q = new Integer(((Integer) KkWQh20v.get("DMS_DOCUMENT_DETAIL")).intValue() + 1);
		}
		if (KkWQh20v.containsKey("DMS_VERSION")) {
			BPse5j2o = new Integer(((Integer) KkWQh20v.get("DMS_VERSION")).intValue() + 1);
		}
		if (KkWQh20v.containsKey("DMS_CONTENT")) {
			G2DxC8fV = new Integer(((Integer) KkWQh20v.get("DMS_CONTENT")).intValue() + 1);
		}
		if (KkWQh20v.containsKey("DMS_ROOT")) {
			Jo8gZxXC = new Integer(((Integer) KkWQh20v.get("DMS_ROOT")).intValue() + 1);
		}
		if (KkWQh20v.containsKey("MTM_DOCUMENT_VERSION")) {
			T6J4skFs = new Integer(((Integer) KkWQh20v.get("MTM_DOCUMENT_VERSION")).intValue() + 1);
		}
		int lEkQxtB9 = (new Integer(sRppGbSM[0])).intValue();
		int XP2GGJF4 = (new Integer(sRppGbSM[1])).intValue();
		EMVmAMXR = new Integer(sRppGbSM[2]);
		Integer wTHae35L = new Integer(sRppGbSM[2]);
		TFD2bFus = new Integer(sRppGbSM[3]);
		String AZ3s632O = new String(sRppGbSM[4]);
		indexPath = new String(sRppGbSM[5]);
		System.out.println("rootID : " + TFD2bFus + "  ParentID " + EMVmAMXR + " physical Loc = " + AZ3s632O);
		String lfnUAKen = "";
		PreparedStatement aodggn27 = null;
		String ZAw6RTM6 = "";
		int uArJacJF = 0;
		int sTti2eKF = 0;
		FileInputStream QAN9n5nt = new FileInputStream(new File(AZ3s632O + JIgdTBVI));
		byte[] EpNCGJXq = new byte[QAN9n5nt.available()];
		QAN9n5nt.read(EpNCGJXq);
		String TTIKqhkm = new String(EpNCGJXq);
		for (int m5PAFrmQ = lEkQxtB9; m5PAFrmQ <= XP2GGJF4; m5PAFrmQ++) {
			try {
				lfnUAKen = "REF" + m5PAFrmQ;
				ZAw6RTM6 = Calendar.getInstance().getTimeInMillis() + ".tif";
				dmsDocument.setID(vx91StLN);
				dmsDocument.setDocumentType("D");
				dmsDocument.setParentID(EMVmAMXR);
				dmsDocument.setRootID(TFD2bFus);
				dmsDocument.setCreateType("S");
				dmsDocument.setReferenceNo("Ref Num");
				dmsDocument.setDescription("desc");
				dmsDocument.setUdfDetailList(new ArrayList());
				dmsDocument.setEffectiveStartDate(currTime);
				dmsDocument.setItemSize(new Integer(20480));
				dmsDocument.setItemStatus("A");
				dmsDocument.setOwnerID(new Integer(0));
				dmsDocument.setUpdateCount(new Integer(0));
				dmsDocument.setCreatorID(new Integer(0));
				dmsDocument.setCreateDate(currTime);
				dmsDocument.setUpdaterID(new Integer(0));
				dmsDocument.setUpdateDate(currTime);
				dmsDocument.setRecordStatus("A");
				if (uArJacJF % 500 == 0) {
					ZAw6RTM6 = "TestDocument" + m5PAFrmQ;
					dmsDocument.setDocumentName(ZAw6RTM6);
					dmsDocument.setDocumentType("F");
					Ot9SyHMU = "INSERT INTO DMS_DOCUMENT VALUES(" + vx91StLN.toString() + ",'" + ZAw6RTM6 + "','F',"
							+ wTHae35L + "," + TFD2bFus.toString() + ", 'S', '" + dmsDocument.getCreateDate().toString()
							+ "', NULL, '" + NuBKmIRL
							+ "','Ref Num', 'desc', 0, 'A', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,'A',0,0,'"
							+ dmsDocument.getCreateDate().toString() + "',0,'" + dmsDocument.getCreateDate().toString()
							+ "')";
					aodggn27 = conn.prepareStatement(Ot9SyHMU);
					aodggn27.executeUpdate();
					EMVmAMXR = vx91StLN;
					vx91StLN = new Integer(vx91StLN.intValue() + 1);
				}
				sTti2eKF = uArJacJF + lEkQxtB9;
				System.out.println("xxx Count: " + sTti2eKF + " docID = " + vx91StLN);
				ZAw6RTM6 = "TestFullText" + m5PAFrmQ + ".txt";
				dmsDocument.setDocumentName(ZAw6RTM6);
				Ot9SyHMU = "INSERT INTO DMS_DOCUMENT VALUES(" + vx91StLN.toString() + ",'" + ZAw6RTM6 + "','D',"
						+ EMVmAMXR.toString() + "," + TFD2bFus.toString() + ", 'S','"
						+ dmsDocument.getCreateDate().toString() + "', NULL, '" + NuBKmIRL
						+ "','Ref Num', 'desc', 20480, 'A', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'A',0,0,'"
						+ dmsDocument.getCreateDate().toString() + "',0,'" + dmsDocument.getCreateDate().toString()
						+ "')";
				aodggn27 = conn.prepareStatement(Ot9SyHMU);
				aodggn27.executeUpdate();
				HaSL10v1 = "INSERT INTO DMS_DOCUMENT_DETAIL VALUES(" + Gun5cN2Q.toString() + "," + vx91StLN.toString()
						+ "," + sUdfID + "," + sUdfDetailID + ",'" + lfnUAKen + "', null, null, 'A',0,0,'"
						+ dmsDocument.getCreateDate().toString() + "',0,'" + dmsDocument.getCreateDate().toString()
						+ "')";
				aodggn27 = conn.prepareStatement(HaSL10v1);
				aodggn27.executeUpdate();
				dmsDocument.setUserDefinedFieldID(new Integer(sUdfID));
				wRVRWXYk = " INSERT INTO DMS_CONTENT VALUES (" + G2DxC8fV.toString() + "," + UXwexzGK
						+ ", 'IMAGE', null, 'TIF', 'A', 0,0,'" + dmsDocument.getCreateDate().toString() + "',0,'"
						+ dmsDocument.getCreateDate().toString() + "')";
				aodggn27 = conn.prepareStatement(wRVRWXYk);
				aodggn27.executeUpdate();
				dmsDocument.setContentID(G2DxC8fV);
				GDK6A8TD = "INSERT INTO DMS_VERSION VALUES(" + BPse5j2o.toString() + ", " + vx91StLN.toString()
						+ ", 1,'ROOT',0," + G2DxC8fV.toString() + ",0, 'Ref Num', 'desc', 20480, 'A', null, 'A',0,0,'"
						+ dmsDocument.getCreateDate().toString() + "',0,'" + dmsDocument.getCreateDate().toString()
						+ "')";
				aodggn27 = conn.prepareStatement(GDK6A8TD);
				aodggn27.executeUpdate();
				dmsDocument.setVersionID(BPse5j2o);
				dmsDocument.setVersionID(new Integer(1));
				dmsDocument.setVersionLabel("ROOT");
				od8blOzf = "INSERT INTO MTM_DOCUMENT_VERSION VALUES(" + T6J4skFs.toString() + "," + vx91StLN.toString()
						+ "," + BPse5j2o.toString() + ",'A', 0, 0,'" + dmsDocument.getCreateDate().toString() + "',0,'"
						+ dmsDocument.getCreateDate().toString() + "')";
				aodggn27 = conn.prepareStatement(od8blOzf);
				aodggn27.executeUpdate();
				vx91StLN = new Integer(vx91StLN.intValue() + 1);
				Gun5cN2Q = new Integer(Gun5cN2Q.intValue() + 1);
				BPse5j2o = new Integer(BPse5j2o.intValue() + 1);
				G2DxC8fV = new Integer(G2DxC8fV.intValue() + 1);
				Jo8gZxXC = new Integer(Jo8gZxXC.intValue() + 1);
				T6J4skFs = new Integer(T6J4skFs.intValue() + 1);
				SessionContainer GCfFAlFi = new SessionContainer();
				if ("D".equals(dmsDocument.getDocumentType())) {
					File LwSwvtSO = new File(AZ3s632O + "temp.txt");
					PrintStream Jh0OmUyc = new PrintStream(new FileOutputStream(LwSwvtSO, false), true);
					Jh0OmUyc.println(formatNumber(m5PAFrmQ));
					Jh0OmUyc.print(TTIKqhkm);
					try {
						Jh0OmUyc.close();
					} catch (Exception rziDM2B6) {
						Jh0OmUyc = null;
					}
					FileInputStream LnEcex6p = new FileInputStream(LwSwvtSO);
					indexDocument(dmsDocument, LnEcex6p, GlobalConstant.OP_MODE_INSERT);
					try {
						LnEcex6p.close();
					} catch (Exception MQj9SIuZ) {
						LnEcex6p = null;
					}
				}
				uArJacJF++;
			} catch (Exception WJb6a9cA) {
				log.error(WJb6a9cA, WJb6a9cA);
				conn.rollback();
			} finally {
				try {
					aodggn27.close();
					conn.rollback();
				} catch (Exception nBIys4Ay) {
				}
			}
		}
		try {
			QAN9n5nt.close();
		} catch (Exception i7LISGkS) {
			QAN9n5nt = null;
		}
		PreparedStatement gFEcfWgy = null;
		if (KkWQh20v.containsKey("DMS_DOCUMENT")) {
			gFEcfWgy = conn.prepareStatement("UPDATE SYS_TABLE_KEY SET TABLE_KEY_MAX=" + vx91StLN.toString()
					+ " WHERE TABLE_NAME='DMS_DOCUMENT'");
			gFEcfWgy.executeUpdate();
		} else {
			gFEcfWgy = conn
					.prepareStatement("INSERT INTO SYS_TABLE_KEY VALUES('DMS_DOCUMENT', " + vx91StLN.toString() + ")");
			gFEcfWgy.executeUpdate();
		}
		if (KkWQh20v.containsKey("DMS_DOCUMENT_DETAIL")) {
			gFEcfWgy = conn.prepareStatement("UPDATE SYS_TABLE_KEY SET TABLE_KEY_MAX=" + Gun5cN2Q.toString()
					+ " WHERE TABLE_NAME='DMS_DOCUMENT_DETAIL'");
			gFEcfWgy.executeUpdate();
		} else {
			gFEcfWgy = conn.prepareStatement(
					"INSERT INTO SYS_TABLE_KEY VALUES('DMS_DOCUMENT_DETAIL', " + Gun5cN2Q.toString() + ")");
			gFEcfWgy.executeUpdate();
		}
		if (KkWQh20v.containsKey("DMS_VERSION")) {
			gFEcfWgy = conn.prepareStatement("UPDATE SYS_TABLE_KEY SET TABLE_KEY_MAX=" + BPse5j2o.toString()
					+ " WHERE TABLE_NAME='DMS_VERSION'");
			gFEcfWgy.executeUpdate();
		} else {
			gFEcfWgy = conn
					.prepareStatement("INSERT INTO SYS_TABLE_KEY VALUES('DMS_VERSION', " + BPse5j2o.toString() + ")");
			gFEcfWgy.executeUpdate();
		}
		if (KkWQh20v.containsKey("DMS_CONTENT")) {
			gFEcfWgy = conn.prepareStatement("UPDATE SYS_TABLE_KEY SET TABLE_KEY_MAX=" + G2DxC8fV.toString()
					+ " WHERE TABLE_NAME='DMS_CONTENT'");
			gFEcfWgy.executeUpdate();
		} else {
			gFEcfWgy = conn
					.prepareStatement("INSERT INTO SYS_TABLE_KEY VALUES('DMS_CONTENT', " + G2DxC8fV.toString() + ")");
			gFEcfWgy.executeUpdate();
		}
		if (KkWQh20v.containsKey("MTM_DOCUMENT_VERSION")) {
			gFEcfWgy = conn.prepareStatement("UPDATE SYS_TABLE_KEY SET TABLE_KEY_MAX=" + T6J4skFs.toString()
					+ " WHERE TABLE_NAME='MTM_DOCUMENT_VERSION'");
			gFEcfWgy.executeUpdate();
		} else {
			gFEcfWgy = conn.prepareStatement(
					"INSERT INTO SYS_TABLE_KEY VALUES('MTM_DOCUMENT_VERSION', " + T6J4skFs.toString() + ")");
			gFEcfWgy.executeUpdate();
		}
		gFEcfWgy.close();
		System.out.println("final value: " + " DocumentID " + vx91StLN + " DocDetailID " + Gun5cN2Q + " DocVersion "
				+ BPse5j2o + " DocContent " + G2DxC8fV + " nMtmDocVersionID " + T6J4skFs);
		closeDBConn();
	}

}