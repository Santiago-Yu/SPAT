class n19910629 {
	public String putData(String mqN5ZsnI, String bmVeoXeF, DefaultHttpClient XGEtsh7a) {
		try {
			HttpPut kE7awkQG = new HttpPut("http://3dforandroid.appspot.com/api/v1/note/update/" + mqN5ZsnI);
			StringEntity AcB9AICA = new StringEntity(bmVeoXeF);
			AcB9AICA.setContentEncoding(HTTP.UTF_8);
			AcB9AICA.setContentType("application/json");
			kE7awkQG.setEntity(AcB9AICA);
			kE7awkQG.setHeader("Content-Type", "application/json");
			kE7awkQG.setHeader("Accept", "*/*");
			HttpResponse kwdSaIyz = XGEtsh7a.execute(kE7awkQG);
			HttpEntity qWjOMwiN = kwdSaIyz.getEntity();
			InputStream zmSHgj4c;
			zmSHgj4c = qWjOMwiN.getContent();
			responseMessage = read(zmSHgj4c);
		} catch (UnsupportedEncodingException aFhnJuqK) {
			aFhnJuqK.printStackTrace();
		} catch (ClientProtocolException bkO7Igl6) {
			bkO7Igl6.printStackTrace();
		} catch (IOException N7ckTore) {
			N7ckTore.printStackTrace();
		}
		return responseMessage;
	}

}