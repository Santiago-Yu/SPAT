class n9251223 {
	public boolean addSiteScore(ArrayList<InitScoreTable> PraBkbRe, InitScoreTable vaPC4rjm, String nApMbGwZ,
			String wfjT3UHI) {
		boolean iU9CpuGf = false;
		String vztXRYwJ = "";
		Connection UuoZgoq7 = null;
		Statement g2TsfKoP = null;
		try {
			UuoZgoq7 = db.getConnection();
			UuoZgoq7.setAutoCommit(false);
			g2TsfKoP = UuoZgoq7.createStatement();
			vztXRYwJ = "delete from t_siteScore  where strTaskId = '" + vaPC4rjm.getStrSiteScoreTaskId() + "'";
			g2TsfKoP.executeUpdate(vztXRYwJ);
			for (int X4gJOHKB = 0; X4gJOHKB < PraBkbRe.size(); X4gJOHKB++) {
				InitScoreTable qp8R1HYu = PraBkbRe.get(X4gJOHKB);
				String a73dYGx4 = "select * from t_tagConf where strTagName='" + qp8R1HYu.getStrSiteScoreTagName()
						+ "' and strTagYear='" + qp8R1HYu.getStrSiteScoreYear() + "' ";
				System.out.println(a73dYGx4);
				ResultSet wLlOq9sg = g2TsfKoP.executeQuery(a73dYGx4);
				if (wLlOq9sg.next()) {
					qp8R1HYu.setStrSiteScoreTagId(wLlOq9sg.getString("strId"));
					qp8R1HYu.setStrSiteinfoScoreParentId(wLlOq9sg.getString("strParentId"));
				}
				wLlOq9sg = null;
			}
			Iterator<InitScoreTable> Z76f1SvX = PraBkbRe.iterator();
			String joPaRWER = com.siteeval.common.Format.getDateTime();
			String gzVrjrI3 = "";
			while (Z76f1SvX.hasNext()) {
				InitScoreTable RJo2JfEL = Z76f1SvX.next();
				gzVrjrI3 = RJo2JfEL.getStrSiteScoreTaskId();
				String zn6SblP8 = UID.getID();
				vztXRYwJ = "INSERT INTO " + strTableName3 + "(strId,strTaskId,strTagId,"
						+ "strTagType,strTagName,strParentId,flaTagScore,strYear,datCreatedTime,strCreator) "
						+ "VALUES('" + zn6SblP8 + "','" + gzVrjrI3 + "','" + RJo2JfEL.getStrSiteScoreTagId() + "','"
						+ RJo2JfEL.getStrSiteScoreTagType() + "','" + RJo2JfEL.getStrSiteScoreTagName() + "','"
						+ RJo2JfEL.getStrSiteinfoScoreParentId() + "','" + RJo2JfEL.getFlaSiteScoreTagScore() + "','"
						+ RJo2JfEL.getStrSiteScoreYear() + "','" + joPaRWER + "','" + RJo2JfEL.getStrSiteScoreCreator()
						+ "')";
				g2TsfKoP.executeUpdate(vztXRYwJ);
			}
			vztXRYwJ = "update t_siteTotalScore set strSiteState=1,flaSiteScore='" + vaPC4rjm.getFlaSiteScore()
					+ "',flaInfoDisclosureScore='" + vaPC4rjm.getFlaInfoDisclosureScore() + "',flaOnlineServicesScore='"
					+ vaPC4rjm.getFlaOnlineServicesScore() + "',flaPublicParticipationSore='"
					+ vaPC4rjm.getFlaPublicParticipationSore() + "',flaWebDesignScore='"
					+ vaPC4rjm.getFlaWebDesignScore() + "',strSiteFeature='" + vaPC4rjm.getStrTotalScoreSiteFeature()
					+ "',strSiteAdvantage='" + vaPC4rjm.getStrTotalScoreSiteAdvantage() + "',strSiteFailure='"
					+ vaPC4rjm.getStrTotalScoreSiteFailure() + "' where strTaskId='" + vaPC4rjm.getStrSiteScoreTaskId()
					+ "'";
			g2TsfKoP.executeUpdate(vztXRYwJ);
			vztXRYwJ = "update " + strTableName1 + " set templateUrl='" + nApMbGwZ + "',dTaskBeginTime='" + wfjT3UHI
					+ "',dTaskEndTime='" + wfjT3UHI + "' where strid = '" + vaPC4rjm.getStrSiteScoreTaskId() + "'";
			g2TsfKoP.executeUpdate(vztXRYwJ);
			UuoZgoq7.commit();
			iU9CpuGf = true;
		} catch (Exception UcX8NpOm) {
			try {
				UuoZgoq7.rollback();
			} catch (Exception LHSmw2pK) {
			}
			System.out.println("????????????????????");
		} finally {
			try {
				UuoZgoq7.setAutoCommit(true);
				if (g2TsfKoP != null) {
					g2TsfKoP.close();
				}
				if (UuoZgoq7 != null) {
					UuoZgoq7.close();
				}
			} catch (Exception S0aniWq0) {
			}
		}
		return iU9CpuGf;
	}

}