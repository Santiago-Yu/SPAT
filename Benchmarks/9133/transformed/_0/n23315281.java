class n23315281 {
	public static void main(String[] RyI43v2k) {
		if (RyI43v2k.length != 2) {
			printUsage();
		}
		String Sllh05I2 = RyI43v2k[0];
		String rW2lhq9g = RyI43v2k[1];
		BufferedReader RyNh7Y73 = null;
		try {
			RyNh7Y73 = new BufferedReader(new FileReader(rW2lhq9g));
		} catch (FileNotFoundException W7B3coIt) {
			System.err.println("Pbs file " + rW2lhq9g + " not found");
			System.exit(1);
		}
		String dAaLfELk = "";
		HttpURLConnection GQVbRvL8 = null;
		BufferedWriter ort01NqJ = null;
		BufferedReader kMZ5j5jC = null;
		try {
			GQVbRvL8 = (HttpURLConnection) new URL(Sllh05I2).openConnection();
			GQVbRvL8.setDoOutput(true);
			ort01NqJ = new BufferedWriter(new OutputStreamWriter(GQVbRvL8.getOutputStream()));
			while (true) {
				dAaLfELk = RyNh7Y73.readLine();
				if (dAaLfELk == null) {
					break;
				}
				ort01NqJ.write(dAaLfELk);
				ort01NqJ.newLine();
				System.err.println(dAaLfELk);
			}
			kMZ5j5jC = new BufferedReader(new InputStreamReader(GQVbRvL8.getInputStream()));
			dAaLfELk = "";
			while (true) {
				dAaLfELk = kMZ5j5jC.readLine();
				if (dAaLfELk == null) {
					break;
				}
				System.out.println(dAaLfELk);
			}
			ort01NqJ.close();
			kMZ5j5jC.close();
		} catch (MalformedURLException srCSCbiw) {
			srCSCbiw.printStackTrace();
		} catch (IOException GK57KUrk) {
			GK57KUrk.printStackTrace();
		}
	}

}