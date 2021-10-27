class n17977185 {
	private String getServerData(String I3ilouIR) {
		InputStream Zdn09zP8 = null;
		String a7JdBOC3 = "";
		ArrayList<NameValuePair> KuGGfI0h = new ArrayList<NameValuePair>();
		KuGGfI0h.add(new BasicNameValuePair("usuario", Login.usuario));
		KuGGfI0h.add(new BasicNameValuePair("amigoABorrar", amigoABorrar.trim()));
		KuGGfI0h.add(new BasicNameValuePair("grupo", MisGrupos.seleccion.trim()));
		try {
			HttpClient u1UuV3Vs = new DefaultHttpClient();
			HttpPost nbDVHWEz = new HttpPost(I3ilouIR);
			nbDVHWEz.setEntity(new UrlEncodedFormEntity(KuGGfI0h));
			HttpResponse JfjgkAwA = u1UuV3Vs.execute(nbDVHWEz);
			HttpEntity Iz1rJ1w3 = JfjgkAwA.getEntity();
			Zdn09zP8 = Iz1rJ1w3.getContent();
		} catch (Exception H0AIVWKO) {
			Log.e("AmigosPorGrupo", "Error en la conexion http " + H0AIVWKO.toString());
		}
		try {
			BufferedReader E1QPAdqG = new BufferedReader(new InputStreamReader(Zdn09zP8, "iso-8859-1"), 8);
			String GyIcbmM1 = E1QPAdqG.readLine();
			Zdn09zP8.close();
			a7JdBOC3 = GyIcbmM1.trim().toString();
			Log.d("AmigosPorGrupo", "Longitud line: " + GyIcbmM1.trim().length());
		} catch (Exception RYO6RGlE) {
			Log.e("AmigosPorGrupo", "Error converting result " + RYO6RGlE.toString());
		}
		Log.d("AmigosPorGrupo", "Funciono json" + a7JdBOC3);
		return a7JdBOC3;
	}

}