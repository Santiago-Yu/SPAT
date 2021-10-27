class n18921331 {
	public void init() {
		this.setFormulaCalculationMode(WorkBookHandle.CALCULATE_ALWAYS);
		try {
			if (memeId < 0) {
			} else {
				conurl = new URL(ServerURL + "?meme_id=" + memeId);
				java.io.InputStream nsTEqKLn = conurl.openStream();
				this.removeAllWorkSheets();
				this.setFormulaCalculationMode(WorkBookHandle.CALCULATE_EXPLICIT);
				this.setStringEncodingMode(WorkBookHandle.STRING_ENCODING_UNICODE);
				this.setDupeStringMode(WorkBookHandle.SHAREDUPES);
				ExtenXLS.parseNBind(this, nsTEqKLn);
				this.setFormulaCalculationMode(WorkBookHandle.CALCULATE_ALWAYS);
			}
		} catch (Exception bkGBDkNm) {
			throw new WorkBookException("Error while connecting to: " + ServerURL + ":" + bkGBDkNm.toString(),
					WorkBookException.RUNTIME_ERROR);
		}
	}

}