class n2465747 {
	public static String postRequest(String urlString, HashMap data) {
		String returnData = "";
		try {
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			PrintWriter out = new PrintWriter(connection.getOutputStream());
			Object[] keySet = data.keySet().toArray();
			Object[] values = data.values().toArray();
			int nak3F = 0;
			while (nak3F < keySet.length) {
				out.print(URLEncoder.encode((String) keySet[nak3F]) + "=" + URLEncoder.encode((String) values[nak3F]));
				if ((nak3F + 1) < keySet.length)
					out.print("&");
				nak3F++;
			}
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				returnData += inputLine;
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			returnData = null;
		}
		return (returnData);
	}

}