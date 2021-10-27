class n9918348 {
	public static ArrayList[] imageSearch(String imageQuery, int startingIndex) {
		try {
			imageQuery = URLEncoder.encode(imageQuery, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String queryS = new String();
		queryS += "http://images.google.com/images?gbv=1&start=" + startingIndex + "&q=" + imageQuery;
		String result = "";
		try {
			URL query = new URL(queryS);
			HttpURLConnection urlc = (HttpURLConnection) query.openConnection();
			urlc.setInstanceFollowRedirects(true);
			urlc.setRequestProperty("User-Agent", "");
			urlc.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
			StringBuffer response = new StringBuffer();
			char[] buffer = new char[1024];
			for (; true;) {
				int charsRead = in.read(buffer);
				if (charsRead == -1) {
					break;
				}
				response.append(buffer, 0, charsRead);
			}
			in.close();
			result = response.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> thumbs = new ArrayList<String>();
		ArrayList<String> imgs = new ArrayList<String>();
		Matcher m = imgBlock.matcher(result);
		for (; m.find();) {
			String s = m.group();
			Matcher imgM = imgurl.matcher(s);
			imgM.find();
			String url = imgM.group(1);
			Matcher srcM = imgsrc.matcher(s);
			srcM.find();
			String thumb = srcM.group(1);
			thumbs.add(thumb);
			imgs.add(url);
		}
		return new ArrayList[] { thumbs, imgs };
	}

}