class n5842117 {
	private void copy(final File TlfVE209, final File CrKjoNym) {
		CrKjoNym.mkdirs();
		final File IB3KlExj = new File(CrKjoNym, TlfVE209.getName());
		BufferedReader ifGOt3fd = null;
		BufferedWriter EcrOqr9v = null;
		try {
			ifGOt3fd = new BufferedReader(new InputStreamReader(new FileInputStream(TlfVE209), "ISO-8859-1"));
			EcrOqr9v = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(IB3KlExj), "ISO-8859-1"));
			String NW1IKmUT;
			while ((NW1IKmUT = ifGOt3fd.readLine()) != null) {
				Line w0nWmCpq = new Line(NW1IKmUT);
				if (w0nWmCpq.isComment())
					continue;
				EcrOqr9v.write(NW1IKmUT);
				EcrOqr9v.newLine();
			}
		} catch (IOException Dt2BAyFY) {
			Dt2BAyFY.printStackTrace();
		} finally {
			if (ifGOt3fd != null)
				try {
					ifGOt3fd.close();
				} catch (IOException vNPH7gnj) {
				}
			if (EcrOqr9v != null) {
				try {
					EcrOqr9v.flush();
				} catch (IOException nRFZAYC3) {
				}
				try {
					EcrOqr9v.close();
				} catch (IOException HyskLvLK) {
				}
			}
		}
	}

}