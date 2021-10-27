class n8973505 {
	public static void writeFileType(String ckCejbMo, String qDD3THFJ, int KpTOEScR) {
		BufferedWriter MWtqKA4D = null;
		String lhYrpbT6 = null;
		try {
			int oT7vecwV = 1;
			MWtqKA4D = new BufferedWriter(new FileWriter(qDD3THFJ));
			BufferedReader KK4IbgF1 = new BufferedReader(new FileReader(ckCejbMo));
			lhYrpbT6 = null;
			while (oT7vecwV < KpTOEScR) {
				lhYrpbT6 = KK4IbgF1.readLine();
				oT7vecwV++;
			}
			while ((lhYrpbT6 = KK4IbgF1.readLine()) != null) {
				try {
					System.err.println("working on the [" + oT7vecwV + "]th document.");
					oT7vecwV++;
					URL EYYK63Ff = new URL(lhYrpbT6);
					URLConnection hwcevX9j = EYYK63Ff.openConnection();
					BufferedReader QXsSMNdy = new BufferedReader(new InputStreamReader(hwcevX9j.getInputStream()));
					String tUX4ihbR = null;
					boolean L5HZUZGH = false;
					boolean O3oVB9qs = false;
					boolean zoCbQd7f = false;
					int cepnFxSq = 0;
					while ((tUX4ihbR = QXsSMNdy.readLine()) != null) {
						if (tUX4ihbR.indexOf("http://www.w3.org/2002/07/owl") != -1)
							L5HZUZGH = true;
						else if (tUX4ihbR.indexOf("http://www.w3.org/2000/01/rdf-schema") != -1)
							O3oVB9qs = true;
						else if (tUX4ihbR.indexOf("http://www.w3.org/1999/02/22-rdf-syntax-ns") != -1)
							zoCbQd7f = true;
						cepnFxSq++;
						if (cepnFxSq > 100)
							break;
					}
					if (L5HZUZGH)
						MWtqKA4D.write(lhYrpbT6 + "\t" + OWL);
					else if (O3oVB9qs)
						MWtqKA4D.write(lhYrpbT6 + "\t" + RDFS);
					else if (zoCbQd7f)
						MWtqKA4D.write(lhYrpbT6 + "\t" + RDF);
					else
						MWtqKA4D.write(lhYrpbT6 + "\t" + UNKNOWN);
					MWtqKA4D.newLine();
					MWtqKA4D.flush();
				} catch (Exception rdkuusu9) {
					rdkuusu9.printStackTrace();
					try {
						MWtqKA4D.write(lhYrpbT6 + "\t" + BROKEN);
						MWtqKA4D.newLine();
						MWtqKA4D.flush();
					} catch (Exception f5i7xCPe) {
						f5i7xCPe.printStackTrace();
					}
				}
			}
		} catch (Exception vFik2pgM) {
			vFik2pgM.printStackTrace();
		}
	}

}