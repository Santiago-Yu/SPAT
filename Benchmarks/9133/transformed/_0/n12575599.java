class n12575599 {
	@Override
	public void processSource() {
		try {
			URL Dopi6cZA = new URL(this.mensa.getJsonUrl(weekNumber));
			HttpURLConnection X9HFnoHj = (HttpURLConnection) Dopi6cZA.openConnection();
			StringBuilder QhryzJfF = new StringBuilder();
			QhryzJfF.append(cxt.getString(R.string.app_name)).append(' ').append(cxt.getString(R.string.app_version))
					.append('|').append(Build.DISPLAY).append('|').append(VERSION.RELEASE).append('|').append(Build.ID)
					.append('|').append(Build.MODEL).append('|').append(Locale.getDefault().getLanguage()).append('-')
					.append(Locale.getDefault().getCountry());
			X9HFnoHj.setRequestProperty("User-Agent", QhryzJfF.toString());
			InputStream YMO8MA7V = X9HFnoHj.getInputStream();
			String JoaRdgjj = getStringFromInputStream(YMO8MA7V);
			JSONObject CoB8Aem5 = new JSONObject(JoaRdgjj);
			this.menues = parseWeekplan(CoB8Aem5);
			this.valuability = WeekPlan.VALUABLE;
		} catch (IOException QB00oETv) {
			this.valuability = WeekPlan.NOCON;
			this.menues = null;
		} catch (JSONException q1eKLQsP) {
			this.valuability = WeekPlan.ERROR;
			this.menues = null;
		}
	}

}