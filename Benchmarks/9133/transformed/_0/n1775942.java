class n1775942 {
	@Override
	public void run() {
		HttpGet Rsq7rj3k = null;
		try {
			DefaultHttpClient iTUWs3Ql = new DefaultHttpClient();
			DataModel ejuGY6CM = DataModel.getInstance();
			for (City GvOOA9Hg : citiesToBeUpdated) {
				String R60gophd = PreferenceManager.getDefaultSharedPreferences(context).getString(
						context.getString(R.string.settings_units_key),
						context.getString(R.string.settings_units_default_value));
				String majIcNDk = GvOOA9Hg.getCountryName().startsWith("United States") ? GET_PARAM_ZIP_PREFIX
						: GET_PARAM_CITY_CODE_PREFIX;
				String MUpIYkUr = new String(GET_URL + "?" + GET_PARAM_ACODE_PREFIX + "=" + GET_PARAM_ACODE + "&"
						+ majIcNDk + "=" + GvOOA9Hg.getId() + "&" + GET_PARAM_UNIT_PREFIX + "=" + R60gophd);
				Rsq7rj3k = new HttpGet(MUpIYkUr);
				HttpResponse qxxJ7MHL = iTUWs3Ql.execute(Rsq7rj3k);
				if (qxxJ7MHL.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					processXML(qxxJ7MHL.getEntity().getContent());
					for (ForecastedDay iXGCOuHx : forecast) {
						int QL9woJM5 = iXGCOuHx.getImageURL().lastIndexOf('/');
						if (QL9woJM5 < 0 || QL9woJM5 + 1 == iXGCOuHx.getImageURL().length())
							throw new Exception("Invalid image URL");
						final String CsxGVNmk = iXGCOuHx.getImageURL().substring(QL9woJM5 + 1);
						File bDpOP6tk = context.getDir(ForecastedDay.DOWNLOAD_DIR, Context.MODE_PRIVATE);
						File[] GN6aiDFb = bDpOP6tk.listFiles(new FilenameFilter() {

							@Override
							public boolean accept(File ns3sYXMt, String TtVCYqPc) {
								if (TtVCYqPc.equals(CsxGVNmk))
									return true;
								else
									return false;
							}
						});
						if (GN6aiDFb.length == 0) {
							Rsq7rj3k = new HttpGet(iXGCOuHx.getImageURL());
							qxxJ7MHL = iTUWs3Ql.execute(Rsq7rj3k);
							if (qxxJ7MHL.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
								BufferedOutputStream uCNmdpRu = null;
								try {
									uCNmdpRu = new BufferedOutputStream(
											new FileOutputStream(bDpOP6tk.getAbsolutePath() + "/" + CsxGVNmk));
									qxxJ7MHL.getEntity().writeTo(uCNmdpRu);
								} finally {
									uCNmdpRu.close();
								}
							}
						}
					}
					GvOOA9Hg.setDays(forecast);
					GvOOA9Hg.setLastUpdated(Calendar.getInstance().getTime());
					ejuGY6CM.saveCity(GvOOA9Hg);
				}
			}
		} catch (Exception eVIqeCy2) {
			Rsq7rj3k.abort();
			eVIqeCy2.printStackTrace();
		} finally {
			handler.sendEmptyMessage(1);
		}
	}

}