class n11511985 {
	public static void test() {
		try {
			URL url = new URL("http://farmfive.com/");
			Pattern pattern = Pattern.compile("[0-9]{3}\\. <a href='(.*)\\.html'>(.*)</a><br />");
			String line;
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			int count = 0;
			while ((line = br.readLine()) != null) {
				Matcher match = pattern.matcher(line);
				if (match.matches()) {
					System.out.println(match.group(1) + " " + match.group(2));
					count++;
				}
			}
			System.out.println(count + " counted");
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}