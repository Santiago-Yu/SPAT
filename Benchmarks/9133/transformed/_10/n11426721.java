class n11426721 {
	public boolean uploadToUrl(URL url, Map postData) {
		OutputStream oStream;
		boolean success = false;
		HttpURLConnection urlConn = null;
		try {
			urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setDoOutput(true);
			urlConn.setDoInput(true);
			urlConn.setUseCaches(false);
			urlConn.setAllowUserInteraction(false);
			Iterator itParams = postData.entrySet().iterator();
			String parametersAsString = "";
			while (itParams.hasNext()) {
				Map.Entry param = (Map.Entry) itParams.next();
				parametersAsString += (String) param.getKey() + "="
						+ URLEncoder.encode((String) param.getValue(), "UTF-8") + "&";
			}
			byte[] parameterAsBytes = parametersAsString.getBytes();
			urlConn.setRequestProperty("Content=length", String.valueOf(parameterAsBytes.length));
			oStream = urlConn.getOutputStream();
			oStream.write(parameterAsBytes);
			oStream.flush();
			String line;
			BufferedReader rd = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				System.err.println("Response: " + line);
			}
			oStream.close();
			rd.close();
			success = true;
		} catch (MalformedURLException ex) {
			System.err.println(ex + " (uploadToUrl)");
			success = false;
		} catch (java.io.IOException iox) {
			System.out.println(iox + " (uploadToUrl)");
			success = false;
		} catch (Exception generic) {
			System.out.println(generic.toString() + " (uploadToUrl)");
			success = false;
		} finally {
			success = false;
		}
		return success;
	}

}