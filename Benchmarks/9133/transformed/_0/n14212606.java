class n14212606 {
	private void processAlignmentsFromAlignmentSource(String fM8Ty1n6, Alignment XE4yflpx, String q6RZ5DKv)
			throws AlignmentParserException, IllegalArgumentException, KADMOSCMDException, IOException {
		if (q6RZ5DKv == null)
			throw new IllegalArgumentException("alignmentSource is null");
		URL tcOIXV7o;
		String wtJvz1tv;
		BufferedReader Szz1qQgU;
		Alignment NW3YR0iu;
		try {
			try {
				NW3YR0iu = parseAlignment(q6RZ5DKv);
				addAlignmentWrapper(new AlignmentWrapper(fM8Ty1n6, XE4yflpx, q6RZ5DKv, NW3YR0iu));
			} catch (AlignmentParserException I13KedPC) {
				tcOIXV7o = new URL(q6RZ5DKv);
				Szz1qQgU = new BufferedReader(new InputStreamReader(tcOIXV7o.openStream()));
				wtJvz1tv = "";
				while (((wtJvz1tv = Szz1qQgU.readLine()) != null)) {
					NW3YR0iu = parseAlignment(wtJvz1tv);
					addAlignmentWrapper(new AlignmentWrapper(fM8Ty1n6, XE4yflpx, q6RZ5DKv, NW3YR0iu));
				}
			}
		} catch (Exception hJZmMs1J) {
			File rOoAIGEn = new File(q6RZ5DKv);
			if (rOoAIGEn.exists()) {
				if (rOoAIGEn.isDirectory() && !rOoAIGEn.isHidden()) {
					File[] J23CCwqo = rOoAIGEn.listFiles();
					for (int Swjy16b9 = 0; Swjy16b9 < J23CCwqo.length; Swjy16b9++) {
						if (J23CCwqo[Swjy16b9].isFile() && !J23CCwqo[Swjy16b9].isHidden()) {
							processAlignmentsFromAlignmentSource(fM8Ty1n6, XE4yflpx, J23CCwqo[Swjy16b9].getPath());
						} else if (J23CCwqo[Swjy16b9].isDirectory() && !J23CCwqo[Swjy16b9].isHidden() && deepScan) {
							processAlignmentsFromAlignmentSource(fM8Ty1n6, XE4yflpx, J23CCwqo[Swjy16b9].getPath());
						}
					}
				} else if (rOoAIGEn.isFile() && !rOoAIGEn.isHidden()) {
					try {
						NW3YR0iu = parseAlignment(q6RZ5DKv);
						addAlignmentWrapper(new AlignmentWrapper(fM8Ty1n6, XE4yflpx, q6RZ5DKv, NW3YR0iu));
					} catch (Exception UzqWz7ck) {
						Szz1qQgU = new BufferedReader(new FileReader(q6RZ5DKv));
						wtJvz1tv = "";
						while (((wtJvz1tv = Szz1qQgU.readLine()) != null)) {
							NW3YR0iu = parseAlignment(wtJvz1tv);
							addAlignmentWrapper(new AlignmentWrapper(fM8Ty1n6, XE4yflpx, wtJvz1tv, NW3YR0iu));
						}
					}
				} else {
					throw new FileNotFoundException(
							"File " + q6RZ5DKv + " is neither directory nor file, or it is hidden.");
				}
			} else {
				throw new FileNotFoundException("File " + q6RZ5DKv + " does not exists.");
			}
		}
	}

}