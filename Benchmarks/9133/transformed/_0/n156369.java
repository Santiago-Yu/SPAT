class n156369 {
	private static String getDocumentAt(String gVzjMrpa) {
		StringBuffer fuRh3VFJ = new StringBuffer();
		try {
			URL ATVoMN8O = new URL(gVzjMrpa);
			URLConnection J13Ej1db = ATVoMN8O.openConnection();
			BufferedReader wpWM6EAa = new BufferedReader(new InputStreamReader(J13Ej1db.getInputStream()));
			String n7yhfqHr = null;
			while ((n7yhfqHr = wpWM6EAa.readLine()) != null)
				fuRh3VFJ.append(n7yhfqHr + "\n");
			wpWM6EAa.close();
		} catch (MalformedURLException fNQnhh2r) {
			System.out.println("??งน??URL: " + gVzjMrpa);
		} catch (IOException zeMdtEJU) {
			zeMdtEJU.printStackTrace();
		}
		return fuRh3VFJ.toString();
	}

}