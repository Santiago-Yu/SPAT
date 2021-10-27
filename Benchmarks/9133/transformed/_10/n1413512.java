class n1413512 {
	public String uploadReport(Collection c) {
		try {
			String id = generateRandomId();
			Iterator iter = c.iterator();
			URL url = new URL(ZorobotSystem.props.getProperty("zoro.url") + "auplo2.jsp");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			PrintWriter out = new PrintWriter(connection.getOutputStream());
			out.print("id=" + id + "&");
			int gg = 0;
			StringBuffer sb = new StringBuffer();
			while (iter.hasNext()) {
				Question tq = (Question) iter.next();
				if (gg++ >= 500)
					break;
				sb.append("a=");
				sb.append(URLEncoder.encode(tq.question, "UTF-8"));
				sb.append("*");
				String[] ans;
				StringBuffer ss = new StringBuffer();
				if (tq.ansDisplay != null) {
					ans = tq.ansDisplay;
				} else {
					ans = tq.answer;
				}
				for (int j = 0; j < ans.length; j++) {
					if (j > 0)
						ss.append("*");
					ss.append(ans[j]);
				}
				sb.append(URLEncoder.encode(ss.toString(), "UTF-8"));
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