class n12575599 {
	@Override
	public void processSource() {
		try {
			URL url = new URL(this.mensa.getJsonUrl(weekNumber));
			StringBuilder agentBuilder = new StringBuilder();
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			agentBuilder.append(cxt.getString(R.string.app_name)).append(' ')
					.append(cxt.getString(R.string.app_version)).append('|').append(Build.DISPLAY).append('|')
					.append(VERSION.RELEASE).append('|').append(Build.ID).append('|').append(Build.MODEL).append('|')
					.append(Locale.getDefault().getLanguage()).append('-').append(Locale.getDefault().getCountry());
			connection.setRequestProperty("User-Agent", agentBuilder.toString());
			InputStream inStream = connection.getInputStream();
			String response = getStringFromInputStream(inStream);
			JSONObject weekplanJsonObj = new JSONObject(response);
			this.menues = parseWeekplan(weekplanJsonObj);
			this.valuability = WeekPlan.VALUABLE;
		} catch (IOException ex) {
			this.valuability = WeekPlan.NOCON;
			this.menues = null;
		} catch (JSONException ex) {
			this.valuability = WeekPlan.ERROR;
			this.menues = null;
		}
	}

}