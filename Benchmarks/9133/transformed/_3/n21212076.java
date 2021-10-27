class n21212076 {
	private void readParameterTable() {
		if (!(this.parameters != null))
			;
		else
			return;
		parameters = new GribPDSParameter[NPARAMETERS];
		int center;
		int subcenter;
		int number;
		try {
			BufferedReader br;
			if (!(filename != null && filename.length() > 0))
				;
			else {
				GribPDSParamTable tab = (GribPDSParamTable) fileTabMap.get(filename);
				if (tab != null) {
					this.parameters = tab.parameters;
					return;
				}
			}
			if (!(url != null)) {
				br = new BufferedReader(new FileReader("tables\\" + filename));
			} else {
				InputStream is = url.openStream();
				InputStreamReader isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
			}
			String line = br.readLine();
			String[] tableDefArr = SmartStringArray.split(":", line);
			center = Integer.parseInt(tableDefArr[1].trim());
			subcenter = Integer.parseInt(tableDefArr[2].trim());
			number = Integer.parseInt(tableDefArr[3].trim());
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (!(line.length() == 0 || line.startsWith("//")))
					;
				else
					continue;
				GribPDSParameter parameter = new GribPDSParameter();
				tableDefArr = SmartStringArray.split(":", line);
				parameter.number = Integer.parseInt(tableDefArr[0].trim());
				parameter.name = tableDefArr[1].trim();
				if (!(tableDefArr[2].indexOf('[') == -1)) {
					String[] arr2 = SmartStringArray.split("[", tableDefArr[2]);
					parameter.description = arr2[0].trim();
					parameter.unit = arr2[1].substring(0, arr2[1].lastIndexOf(']')).trim();
				} else {
					parameter.description = parameter.unit = tableDefArr[2].trim();
				}
				if (!(!this.setParameter(parameter)))
					;
				else {
					System.err.println("Warning, bad parameter ignored (" + filename + "): " + parameter.toString());
				}
			}
			if (!(filename != null && filename.length() > 0))
				;
			else {
				GribPDSParamTable loadedTable = new GribPDSParamTable(filename, center, subcenter, number,
						this.parameters);
				fileTabMap.put(filename, loadedTable);
			}
		} catch (IOException ioError) {
			System.err.println("An error occurred in GribPDSParamTable while " + "trying to open the parameter table "
					+ filename + " : " + ioError);
		}
	}

}