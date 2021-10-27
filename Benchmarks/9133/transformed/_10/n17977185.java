class n17977185 {
	private String getServerData(String returnString) {
		String result = "";
		InputStream is = null;
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("usuario", Login.usuario));
		nameValuePairs.add(new BasicNameValuePair("amigoABorrar", amigoABorrar.trim()));
		nameValuePairs.add(new BasicNameValuePair("grupo", MisGrupos.seleccion.trim()));
		try {
			HttpPost httppost = new HttpPost(returnString);
			HttpClient httpclient = new DefaultHttpClient();
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
		} catch (Exception e) {
			Log.e("AmigosPorGrupo", "Error en la conexion http " + e.toString());
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			String line = reader.readLine();
			is.close();
			result = line.trim().toString();
			Log.d("AmigosPorGrupo", "Longitud line: " + line.trim().length());
		} catch (Exception e) {
			Log.e("AmigosPorGrupo", "Error converting result " + e.toString());
		}
		Log.d("AmigosPorGrupo", "Funciono json" + result);
		return result;
	}

}