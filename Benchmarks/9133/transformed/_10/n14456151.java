class n14456151 {
	List HttpPost(URL url, List requestList) throws IOException {
		URLConnection con;
		List responseList = new ArrayList();
		OutputStreamWriter out;
		BufferedReader in;
		String line;
		StringBuffer req;
		logInfo("HTTP POST: " + url);
		con = url.openConnection();
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false);
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		req = new StringBuffer();
		out = new OutputStreamWriter(con.getOutputStream());
		for (int i = 0, n = requestList.size(); i < n; i++) {
			if (i != 0)
				req.append("&");
			req.append(((HttpHeader) requestList.get(i)).key);
			req.append("=");
			if (((HttpHeader) requestList.get(i)).unicode) {
				byte[] uniBytes = ((HttpHeader) requestList.get(i)).value.getBytes("UnicodeBigUnmarked");
				StringBuffer tmp = new StringBuffer(200);
				for (int j = 0; j < uniBytes.length; j++)
					tmp.append(Integer.toHexString(uniBytes[j]).length() == 1 ? "0" + Integer.toHexString(uniBytes[j])
							: Integer.toHexString(uniBytes[j]));
				req.append(tmp.toString().replaceAll("ff", ""));
			} else
				req.append(((HttpHeader) requestList.get(i)).value);
		}
		out.write(req.toString());
		out.flush();
		out.close();
		in = new BufferedReader(new InputStreamReader((con.getInputStream())));
		while ((line = in.readLine()) != null)
			responseList.add(line);
		in.close();
		return responseList;
	}

}