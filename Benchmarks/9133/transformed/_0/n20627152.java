class n20627152 {
	public void loadLicenceText() {
		try {
			URL mlk8GQU9 = this.getClass().getResource("/licences/" + this.files[this.licence_text_id]);
			InputStreamReader pbmVCvgb = new InputStreamReader(mlk8GQU9.openStream());
			BufferedReader tV3lRBuI = new BufferedReader(pbmVCvgb);
			String TsDl6Rly;
			StringBuffer rxoEQw56 = new StringBuffer();
			while ((TsDl6Rly = tV3lRBuI.readLine()) != null) {
				rxoEQw56.append(TsDl6Rly);
			}
			this.licence_text = rxoEQw56.toString();
		} catch (Exception DaCUUyqB) {
			System.out.println("LicenceInfo::error reading. Ex: " + DaCUUyqB);
			DaCUUyqB.printStackTrace();
		}
	}

}