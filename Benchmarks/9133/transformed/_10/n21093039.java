class n21093039 {
	public ArrayList parseFile(File newfile) throws IOException {
		String s;
		String firstname;
		String secondname;
		String direction;
		String header;
		String name = null;
		boolean readingHArrays = false;
		String[] tokens;
		boolean readingAArrays = false;
		boolean readingVArrays = false;
		ArrayList yturndat = new ArrayList();
		ArrayList xturndat = new ArrayList();
		int nvalues;
		ArrayList ampturndat = new ArrayList();
		URL url = newfile.toURI().toURL();
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		s = br.readLine();
		s = br.readLine();
		s = br.readLine();
		s = br.readLine();
		s = br.readLine();
		s = br.readLine();
		s = br.readLine();
		while ((s = br.readLine()) != null) {
			tokens = s.split("\\s+");
			nvalues = tokens.length;
			firstname = tokens[0];
			if (nvalues < 1)
				continue;
			secondname = tokens[1];
			if (secondname.startsWith("BPM")) {
				direction = tokens[4];
				if (readingHArrays)
					dumpxData(name, xturndat);
				else if (readingVArrays)
					dumpyData(name, yturndat);
				else if (readingAArrays)
					dumpampData(name, ampturndat);
				if (direction.equals("HORIZONTAL")) {
					readingVArrays = false;
					readingHArrays = true;
					readingAArrays = false;
				}
				if (direction.equals("VERTICAL")) {
					readingHArrays = false;
					readingVArrays = true;
					readingAArrays = false;
				}
				name = tokens[3];
				if (direction.equals("AMPLITUDE")) {
					readingVArrays = false;
					readingHArrays = false;
					readingAArrays = true;
				}
				xturndat.clear();
				yturndat.clear();
				ampturndat.clear();
			}
			if (nvalues == 3) {
				if (readingHArrays)
					xturndat.add(new Double(Double.parseDouble(tokens[2])));
				else if (readingVArrays)
					yturndat.add(new Double(Double.parseDouble(tokens[2])));
				else if (readingAArrays)
					ampturndat.add(new Double(Double.parseDouble(tokens[2])));
			}
			if (secondname.startsWith("WAVEFORM"))
				continue;
		}
		dumpampData(name, ampturndat);
		data.add(xdatamap);
		data.add(ydatamap);
		data.add(ampdatamap);
		return data;
	}

}