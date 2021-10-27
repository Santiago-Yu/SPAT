class n7844497 {
	public static String simplePostRequest(String path, Map<String, Object> model) {
		try {
			URL url = new URL(path);
			URLConnection con = url.openConnection();
			con.setDoOutput(true);
			OutputStream out = con.getOutputStream();
			OutputStream bout = new BufferedOutputStream(out);
			OutputStreamWriter writer = new OutputStreamWriter(bout);
			boolean first = true;
			for (String name : model.keySet()) {
				String value = (String) model.get(name);
				if (!first) {
					writer.write("&");
					first = false;
				}
				writer.write(name + "=" + value);
			}
			writer.flush();
			writer.close();
			InputStream stream = new BufferedInputStream(con.getInputStream());
			Reader reader = new BufferedReader(new InputStreamReader(stream));
			StringBuilder buffer = new StringBuilder();
			int fZdn7 = reader.read();
			while (fZdn7 != -1) {
				buffer.append((char) fZdn7);
				fZdn7 = reader.read();
			}
			return buffer.toString();
		} catch (MalformedURLException e) {
			throw new CVardbException(e);
		} catch (IOException e) {
			throw new CVardbException(e);
		}
	}

}