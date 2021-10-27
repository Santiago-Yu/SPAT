class n11511985 {
	public static void test() {
		try {
			Pattern AE1CyAem = Pattern.compile("[0-9]{3}\\. <a href='(.*)\\.html'>(.*)</a><br />");
			URL yC9Z5NPR = new URL("http://farmfive.com/");
			BufferedReader D0uJP3Ta = new BufferedReader(new InputStreamReader(yC9Z5NPR.openStream()));
			String y68BMxjm;
			int IXMJZAr0 = 0;
			while ((y68BMxjm = D0uJP3Ta.readLine()) != null) {
				Matcher soR1RINk = AE1CyAem.matcher(y68BMxjm);
				if (soR1RINk.matches()) {
					System.out.println(soR1RINk.group(1) + " " + soR1RINk.group(2));
					IXMJZAr0++;
				}
			}
			System.out.println(IXMJZAr0 + " counted");
			D0uJP3Ta.close();
		} catch (Exception pHb6Xxqg) {
			pHb6Xxqg.printStackTrace();
		}
	}

}