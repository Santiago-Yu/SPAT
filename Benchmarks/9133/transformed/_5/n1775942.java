class n1775942 {
	@Override
	public void run() {
		HttpGet httpGet = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			DataModel model = DataModel.getInstance();
			for (City city : citiesToBeUpdated) {
				String preferredUnitType = PreferenceManager.getDefaultSharedPreferences(context).getString(
						context.getString(R.string.settings_units_key),
						context.getString(R.string.settings_units_default_value));
				String codePrefix;
				if (city.getCountryName().startsWith("United States"))
					codePrefix = GET_PARAM_ZIP_PREFIX;
				else
					codePrefix = GET_PARAM_CITY_CODE_PREFIX;
				String requestUri = new String(GET_URL + "?" + GET_PARAM_ACODE_PREFIX + "=" + GET_PARAM_ACODE + "&"
						+ codePrefix + "=" + city.getId() + "&" + GET_PARAM_UNIT_PREFIX + "=" + preferredUnitType);
				httpGet = new HttpGet(requestUri);
				HttpResponse response = httpClient.execute(httpGet);
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					processXML(response.getEntity().getContent());
					for (ForecastedDay day : forecast) {
						int pos = day.getImageURL().lastIndexOf('/');
						if (pos < 0 || pos + 1 == day.getImageURL().length())
							throw new Exception("Invalid image URL");
						final String imageFilename = day.getImageURL().substring(pos + 1);
						File downloadDir = context.getDir(ForecastedDay.DOWNLOAD_DIR, Context.MODE_PRIVATE);
						File[] imagesFilteredByName = downloadDir.listFiles(new FilenameFilter() {

							@Override
							public boolean accept(File dir, String filename) {
								if (filename.equals(imageFilename))
									return true;
								else
									return false;
							}
						});
						if (imagesFilteredByName.length == 0) {
							httpGet = new HttpGet(day.getImageURL());
							response = httpClient.execute(httpGet);
							if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
								BufferedOutputStream bus = null;
								try {
									bus = new BufferedOutputStream(
											new FileOutputStream(downloadDir.getAbsolutePath() + "/" + imageFilename));
									response.getEntity().writeTo(bus);
								} finally {
									bus.close();
								}
							}
						}
					}
					city.setDays(forecast);
					city.setLastUpdated(Calendar.getInstance().getTime());
					model.saveCity(city);
				}
			}
		} catch (Exception e) {
			httpGet.abort();
			e.printStackTrace();
		} finally {
			handler.sendEmptyMessage(1);
		}
	}

}