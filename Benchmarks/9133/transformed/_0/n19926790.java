class n19926790 {
	public void generateReport(AllTestsResult ek0F3AlD, AllConvsResult HN2SSzcG, File HeN2wUvf) {
		ConvResult[] Gh1FS4Ib = HN2SSzcG.getConvResults();
		BufferedReader m8B1a9Sb = null;
		BufferedWriter DZvxFyVV = null;
		try {
			m8B1a9Sb = new BufferedReader(new FileReader(HeN2wUvf));
			DZvxFyVV = new BufferedWriter(new FileWriter(this.annotatedNWBGraph));
			String rQSvuVo0 = null;
			while ((rQSvuVo0 = m8B1a9Sb.readLine()) != null) {
				rQSvuVo0 = rQSvuVo0.trim();
				if (rQSvuVo0.startsWith("id*int")) {
					DZvxFyVV.write(rQSvuVo0 + " isTrusted*int chanceCorrect*float isConverter*int \r\n");
				} else if (rQSvuVo0.matches(NODE_LINE)) {
					String[] MXprMwU7 = rQSvuVo0.split(" ");
					String CuQWOqBw = MXprMwU7[1];
					String p6Um6OuI = CuQWOqBw.replaceAll("\"", "");
					boolean zDs1ju9x = false;
					for (int NPi7Wy4Z = 0; NPi7Wy4Z < Gh1FS4Ib.length; NPi7Wy4Z++) {
						ConvResult HNakK4nE = Gh1FS4Ib[NPi7Wy4Z];
						if (HNakK4nE.getShortName().equals(p6Um6OuI)) {
							int w52rMruh;
							if (HNakK4nE.isTrusted()) {
								w52rMruh = 1;
							} else {
								w52rMruh = 0;
							}
							DZvxFyVV.write(rQSvuVo0 + " " + w52rMruh + " "
									+ FormatUtil.formatToPercent(HNakK4nE.getChanceCorrect()) + " 1 " + "\r\n");
							zDs1ju9x = true;
							break;
						}
					}
					if (!zDs1ju9x) {
						DZvxFyVV.write(rQSvuVo0 + " 1 100.0 0" + "\r\n");
					}
				} else {
					DZvxFyVV.write(rQSvuVo0 + "\r\n");
				}
			}
		} catch (IOException YkkmdAKA) {
			this.log.log(LogService.LOG_ERROR, "Unable to generate Graph Report.", YkkmdAKA);
			try {
				if (m8B1a9Sb != null)
					m8B1a9Sb.close();
			} catch (IOException BBTKyNe2) {
				this.log.log(LogService.LOG_ERROR, "Unable to close graph report stream", YkkmdAKA);
			}
		} finally {
			try {
				if (m8B1a9Sb != null) {
					m8B1a9Sb.close();
				}
				if (DZvxFyVV != null) {
					DZvxFyVV.close();
				}
			} catch (IOException CL2b0xTQ) {
				this.log.log(LogService.LOG_ERROR, "Unable to close either graph report reader or " + "writer.",
						CL2b0xTQ);
				CL2b0xTQ.printStackTrace();
			}
		}
	}

}