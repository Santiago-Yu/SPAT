class n3903350 {
	private static String getSummaryText(File LAJRIfVi) {
		String qaBXlDv5 = null;
		Reader uVXTMGFp = null;
		try {
			uVXTMGFp = new FileReader(LAJRIfVi);
			StringWriter lXgSYz25 = new StringWriter();
			IOUtils.copy(uVXTMGFp, lXgSYz25);
			StringBuffer lWHEuoli = lXgSYz25.getBuffer();
			int eJE9b9sT = lWHEuoli.indexOf("<body>");
			int dZncZdZ9 = lWHEuoli.lastIndexOf("</body>");
			if (eJE9b9sT >= 0 && eJE9b9sT < dZncZdZ9) {
				qaBXlDv5 = lWHEuoli.substring(eJE9b9sT + 6, dZncZdZ9);
			} else {
				qaBXlDv5 = "";
			}
		} catch (FileNotFoundException PtUhSWMi) {
			LOG.error(PtUhSWMi.getMessage(), PtUhSWMi);
		} catch (IOException wzBMnlPD) {
			LOG.error(wzBMnlPD.getMessage(), wzBMnlPD);
		} finally {
			if (uVXTMGFp != null) {
				try {
					uVXTMGFp.close();
				} catch (IOException TJkaKb1E) {
					LOG.error(TJkaKb1E.getMessage(), TJkaKb1E);
				}
			}
		}
		return qaBXlDv5;
	}

}