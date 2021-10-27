class n16398232 {
	int responseTomcat(InetAddress dest, int port, String request, boolean methodPost, StringBuffer response,
			int timeout) {
		int methodPostMaxSize = 32000;
		int methodGetMaxSize = 250;
		String fullRequest;
		if (request == null || response == null)
			return -1;
		if (methodPost) {
			String resource;
			int qIdx = request.indexOf('?');
			String queryStr;
			if (qIdx == -1) {
				queryStr = "";
				resource = request;
			} else {
				resource = request.substring(0, qIdx);
				queryStr = request.substring(qIdx + 1);
			}
			fullRequest = "POST " + resource + " HTTP/1.1\nHost: " + dest.getHostName() + ":"
					+ (new Integer(port)).toString() + "\n\n" + queryStr;
		} else {
			fullRequest = "GET " + request + " HTTP/1.1\nHost: " + dest.getHostName() + ":"
					+ (new Integer(port)).toString() + "\n\n";
		}
		String inputLine = "";
		if (methodPost && fullRequest.length() > methodPostMaxSize) {
			response.setLength(0);
			response.append("Complete POST request longer than maximum of " + methodPostMaxSize);
			return -5;
		} else if ((!methodPost) && fullRequest.length() > methodGetMaxSize) {
			response.setLength(0);
			response.append("Complete GET request longer than maximum of " + methodGetMaxSize);
			return -6;
		}
		request = "http://" + dest.getHostName() + ":" + (new Integer(port).toString()) + request;
		try {
			URL urlAddress = new URL(request);
			URLConnection urlC = urlAddress.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlC.getInputStream()));
			while ((inputLine = in.readLine()) != null) {
				response = response.append(inputLine).append("\n");
			}
		} catch (MalformedURLException e) {
			return -4;
		} catch (IOException e) {
			return -3;
		}
		return 200;
	}

}