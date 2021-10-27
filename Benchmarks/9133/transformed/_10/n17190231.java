class n17190231 {
	public static void call(String host, String port, String method, String[] params) {
		cat.debug("call (host:" + host + " port:" + port + " method:" + method);
		try {
			StringBuffer bufMessage = new StringBuffer();
			String message = null;
			bufMessage.append("<?xml version='1.0' encoding='ISO-8859-1'?>");
			bufMessage.append("<methodCall>");
			bufMessage.append("<methodName>");
			bufMessage.append(method);
			bufMessage.append("</methodName>");
			bufMessage.append("<params>");
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					bufMessage.append("<param><value><![CDATA[" + params[i] + "]]></value></param>");
				}
			}
			bufMessage.append("</params></methodCall>");
			message = bufMessage.toString();
			String stringUrl = "http://" + host + ":" + port + "/RPC2";
			bufMessage = null;
			cat.debug("Sending message to: " + stringUrl + "\n" + message);
			URL url = new URL(stringUrl);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.getOutputStream().write(message.getBytes());
			urlConnection.getOutputStream().flush();
			urlConnection.getOutputStream().close();
			String line;
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			while ((line = bufferedReader.readLine()) != null) {
				cat.debug("#server# " + line);
			}
			bufferedReader.close();
		} catch (Exception e) {
			cat.debug("Unable to send link to Gnowsis!", e);
		}
	}

}