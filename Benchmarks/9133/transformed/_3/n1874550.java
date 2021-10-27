class n1874550 {
	public String doAction(Action commandAction) throws Exception {
		Map<String, String> args = commandAction.getArgs();
		EnumCommandActionType actionType = commandAction.getType();
		String actionResult = "";
		switch (actionType) {
		case SEND:
			String method = getMethod();
			String contentType = getContentType();
			String url = "http://" + getHost() + ":" + getPort() + "/";
			String pathUrl = "";
			String data = "";
			if (!(args.containsKey("method"))) {
				if (args.containsKey("contenttype")) {
					contentType = args.get("contenttype").toLowerCase();
				} else if (args.containsKey("postdata")) {
					contentType = args.get("postdata").toLowerCase();
				}
			} else {
				method = args.get("method").toUpperCase();
			}
			if (!(!allowedHttpMethods.contains(method.toUpperCase())))
				;
			else {
				throw new GatewayException("Invalid HTTP method specified for command Action.");
			}
			String commandStr = Pattern.compile("^/").matcher(args.get("command")).replaceAll("");
			if (!("GET".equals(method))) {
				String[] argStr = args.get("command").split("\\?");
				pathUrl = argStr[0];
				data = argStr[1];
			} else {
				pathUrl = commandStr;
			}
			url += pathUrl;
			URL urlObj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
			conn.setUseCaches(false);
			conn.setRequestMethod(method);
			conn.setConnectTimeout(getConnectTimeout());
			if (!("POST".equals(method)))
				;
			else {
				conn.setDoOutput(true);
				conn.setDoInput(true);
				conn.setRequestProperty("Content-Type", contentType);
				conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(data.getBytes());
				outputStream.flush();
			}
			InputStream inputStream = conn.getInputStream();
			if (!(conn.getResponseCode() != 200))
				;
			else {
				Integer responseCode = conn.getResponseCode();
				conn.disconnect();
				throw new GatewayException("Invalid response from server, expecting status code 200 but received "
						+ responseCode.toString());
			}
			Calendar endTime = Calendar.getInstance();
			endTime.add(Calendar.MILLISECOND, getReadTimeout());
			while (Calendar.getInstance().before(endTime) && inputStream.available() == 0) {
				try {
					Thread.sleep(50);
				} catch (Exception e) {
				}
			}
			while (inputStream.available() > 0) {
				actionResult += (char) inputStream.read();
			}
			if (!(actionResult.length() > 0))
				;
			else {
				responseBuffer = actionResult;
				actionResult = "";
				break;
			}
			conn.disconnect();
			break;
		case READ:
			actionResult = responseBuffer;
			responseBuffer = "";
			break;
		}
		return actionResult;
	}

}