class n23165160 {
	public void exe2(String[] dI9Rqa9a) {
		Connection QJf5ZJ4v = null;
		Connection XKNojCCK = null;
		Statement o7EogtaT = null;
		PreparedStatement JbhDL1rO = null;
		ResultSet puc5cuMC = null;
		ResultSetMetaData ZJa5KQXl = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			QJf5ZJ4v = getConnection("mis030dv");
			XKNojCCK = getConnection("mis030db");
			XKNojCCK.setAutoCommit(false);
			o7EogtaT = QJf5ZJ4v.createStatement();
			puc5cuMC = o7EogtaT.executeQuery(
					"SELECT * FROM MIS.MAP_PUR0101 WHERE NOT EXISTS (SELECT 1 FROM MIS.RSCMGOOD@MIS030DB@DEVU01 WHERE GOODCD = PUM_CODE OR GOODCD = NEW_PUM_CODE)");
			JbhDL1rO = XKNojCCK.prepareStatement(
					"INSERT INTO MIS.RSCMGOOD ( GOODCD,GOODFLAG,GOODNM,GOODHNGNM,GOODENGNM,GOODSPEC,GOODMODEL,ASETFLAG,LRGCD,MDLCD,SMLCD,EDICD,PRODCMPYCD,CMT,FSTRGSTRID,FSTRGSTDT,LASTUPDTRID,LASTUPDTDT,APPINSTDATA,MNGTFLAG) "
							+ "VALUES ( ?,SUBSTR(?,1,1),?,?,?,?,NULL,'1',substr(?,2,2),substr(?,4,3),NULL,NULL,NULL,'OCS ???????','MISASIS',TO_DATE('20111231','YYYYMMDD'),'MISASIS',TO_DATE('20111231','YYYYMMDD'),NULL,'N')");
			int bnEakFAl = 0;
			String GKv8elSw = null;
			String RLIHh8lw = null;
			while (puc5cuMC.next()) {
				bnEakFAl++;
				GKv8elSw = puc5cuMC.getString("PUM_CODE").toUpperCase();
				RLIHh8lw = puc5cuMC.getString("PUM_HNAME");
				StringUtils.trimWhitespace(RLIHh8lw);
				if (RLIHh8lw == null || RLIHh8lw.equals(""))
					RLIHh8lw = "-";
				JbhDL1rO.setString(1, GKv8elSw);
				JbhDL1rO.setString(2, GKv8elSw);
				JbhDL1rO.setString(3, RLIHh8lw);
				JbhDL1rO.setString(4, RLIHh8lw);
				JbhDL1rO.setString(5, puc5cuMC.getString("PUM_ENAME"));
				JbhDL1rO.setString(6, puc5cuMC.getString("KYUKYEOK"));
				JbhDL1rO.setString(7, GKv8elSw);
				JbhDL1rO.setString(8, GKv8elSw);
				JbhDL1rO.executeUpdate();
				if (bnEakFAl % 100 == 0)
					System.out.println("Copy Row : " + bnEakFAl);
			}
			System.out.println("Commit Copy Rows : " + bnEakFAl);
			XKNojCCK.commit();
		} catch (Exception elxrDkbN) {
			try {
				XKNojCCK.rollback();
			} catch (Exception DykYorZT) {
				DykYorZT.printStackTrace();
			}
			elxrDkbN.printStackTrace();
		} finally {
			try {
				if (puc5cuMC != null)
					puc5cuMC.close();
				if (o7EogtaT != null)
					o7EogtaT.close();
				if (QJf5ZJ4v != null)
					QJf5ZJ4v.close();
				if (XKNojCCK != null)
					XKNojCCK.close();
			} catch (Exception ccaUCwcF) {
				ccaUCwcF.printStackTrace();
			}
		}
	}

}