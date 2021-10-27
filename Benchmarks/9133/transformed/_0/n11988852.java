class n11988852 {
	public static final void parse(String zpJrOB1I, String asNe774y) throws IOException {
		BufferedReader AsJwUtDl = new BufferedReader(new FileReader(zpJrOB1I));
		DataOutputStream ENXuXEeV = new DataOutputStream(new FileOutputStream(asNe774y));
		int ivCwbBGm = Integer.parseInt(AsJwUtDl.readLine());
		int HITMvYBW = Integer.parseInt(AsJwUtDl.readLine());
		ENXuXEeV.writeByte(ivCwbBGm);
		ENXuXEeV.writeByte(HITMvYBW);
		int ZOC6YDBT = 2;
		try {
			do {
				for (int HH4PTk8i = 0; HH4PTk8i < HITMvYBW; HH4PTk8i++) {
					ZOC6YDBT++;
					String h03Rp1fR = AsJwUtDl.readLine();
					if (h03Rp1fR == null) {
						throw new RuntimeException("Unexpected end of file at line " + ZOC6YDBT);
					}
					for (int k06pxlH0 = 0; k06pxlH0 < ivCwbBGm; k06pxlH0++) {
						char ED6i6jOH = h03Rp1fR.charAt(k06pxlH0);
						System.out.print(ED6i6jOH);
						ENXuXEeV.writeByte(ED6i6jOH);
					}
					System.out.println("");
				}
				ZOC6YDBT++;
				ENXuXEeV.writeShort(Short.parseShort(AsJwUtDl.readLine()));
			} while (AsJwUtDl.readLine() != null);
		} finally {
			AsJwUtDl.close();
			ENXuXEeV.close();
		}
	}

}