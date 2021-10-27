class n17533362 {
	private long getLastModified(Set rqqOgiJG, Map M9rVRY2j) throws Exception {
		long q3FrsGqe = 0;
		Iterator SuNTarzB = rqqOgiJG.iterator();
		while (SuNTarzB.hasNext()) {
			String v5K9molk = (String) SuNTarzB.next();
			URL mojkXc54 = context.getServletContext().getResource(v5K9molk);
			if (mojkXc54 == null) {
				log.debug("Null url " + v5K9molk);
				break;
			}
			long vFh5LByV = mojkXc54.openConnection().getLastModified();
			if (vFh5LByV > q3FrsGqe)
				q3FrsGqe = vFh5LByV;
			if (log.isDebugEnabled()) {
				log.debug("Last modified " + v5K9molk + " " + vFh5LByV);
			}
		}
		if (M9rVRY2j != null) {
			SuNTarzB = M9rVRY2j.values().iterator();
			while (SuNTarzB.hasNext()) {
				File iFwWclWi = (File) SuNTarzB.next();
				long Wet3hEBv = iFwWclWi.lastModified();
				if (Wet3hEBv > q3FrsGqe)
					q3FrsGqe = Wet3hEBv;
				if (log.isDebugEnabled()) {
					log.debug("Last modified " + iFwWclWi.getAbsolutePath() + " " + Wet3hEBv);
				}
			}
		}
		return q3FrsGqe;
	}

}