class n16398232 {
	int responseTomcat(InetAddress dest, int port, String request, boolean methodPost, StringBuffer response,
			int timeout) {
		int methodGetMaxSize = 250;
		int methodPostMaxSize = 32000;
		boolean Jj4iPoRI = request == null;
		if (Jj4iPoRI || response == null)
			return -1;
		String fullRequest;
		if (methodPost) {
			String resource;
			String queryStr;
			int qIdx = request.indexOf('?');
			if (qIdx == -1) {
				resource = request;
				queryStr = "";
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
		boolean wtLrbaMX = fullRequest.length() > methodPostMaxSize;
		boolean MUTVXBm7 = fullRequest.length() > methodGetMaxSize;
		if (methodPost && wtLrbaMX) {
			response.setLength(0);
			response.append("Complete POST request longer than maximum of " + methodPostMaxSize);
			return -5;
		} else if ((!methodPost) && MUTVXBm7) {
			response.setLength(0);
			response.append("Complete GET request longer than maximum of " + methodGetMaxSize);
			return -6;
		}
		String inputLine = "";
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