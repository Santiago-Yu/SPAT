class n3766029 {
	public String uploadZtree(ArrayList c) {
		try {
			String id = generateRandomId();
			Iterator iter = c.iterator();
			URL url = new URL(ZorobotSystem.props.getProperty("zoro.url") + "auplo1.jsp");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			PrintWriter out = new PrintWriter(connection.getOutputStream());
			out.print("id=" + id + "&");
			int gg = 0;
			StringBuffer sb = new StringBuffer();
			while (iter.hasNext()) {
				String st = (String) iter.next();
				if (gg++ >= 500)
					break;
				sb.append("a=");
				sb.append(URLEncoder.encode(st, "UTF-8"));
				if (iter.hasNext() && gg < 500)
					sb.append("&");
			}
			out.println(sb.toString());
			out.close();
			String inputLine;
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			if ((inputLine = in.readLine()) != null) {
				if (!inputLine.equals("OK!") && inputLine.length() > 3) {
					System.out.println("Not OK: " + inputLine);
					return "xxxxxxxxxx";
				}
			}
			in.close();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}