class n14563781 {
	public static void parseString(String str, String name) {
		String zeile = null;
		BufferedReader reader;
		int lambda;
		boolean firstL = true;
		int l_b = 0;
		float intens;
		HashMap<Integer, Float> curve = new HashMap<Integer, Float>();
		int l_e = 0;
		String[] temp;
		try {
			URL url = new URL(str);
			File f = File.createTempFile("tempFile", null);
			FileOutputStream os = new FileOutputStream(f);
			InputStream is = url.openStream();
			byte[] buffer = new byte[0xFFFF];
			for (int len; (len = is.read(buffer)) != -1;)
				os.write(buffer, 0, len);
			is.close();
			os.close();
			reader = new BufferedReader(new FileReader(f));
			lambda = 0;
			zeile = reader.readLine();
			while (zeile != null) {
				if (!(zeile.length() > 0 && zeile.charAt(0) == '#')) {
					zeile = reader.readLine();
					break;
				}
				zeile = reader.readLine();
			}
			while (zeile != null) {
				if (zeile.length() > 0) {
					temp = zeile.split(" ");
					lambda = Integer.parseInt(temp[0]);
					if (firstL) {
						firstL = false;
						l_b = lambda;
					}
					intens = Float.parseFloat(temp[1]);
					curve.put(lambda, intens);
				}
				zeile = reader.readLine();
			}
			l_e = lambda;
		} catch (IOException e) {
			System.err.println("Error2 :" + e);
		}
		try {
			File file = new File("C:/spectralColors/" + name + ".sd");
			String tempV;
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("# COLOR: " + name + " Auto generated File: 02/09/2009; From " + l_b + " to " + l_e);
			bw.newLine();
			bw.write(l_b + "");
			bw.newLine();
			for (int i = l_b; i <= l_e; i++) {
				if (curve.containsKey(i)) {
					tempV = i + " " + curve.get(i);
					bw.write(tempV);
					bw.newLine();
				}
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}