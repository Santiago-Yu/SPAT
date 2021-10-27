class n21093039 {
	public ArrayList parseFile(File n5UBjXAK) throws IOException {
		String NHq7NXzc;
		String w3ULyb5h;
		String dlERLh2C;
		String gtysY2QO;
		String t6O9EoS1;
		String WQfANppC = null;
		String[] xo6Kp5ns;
		boolean lSjLZGd7 = false;
		boolean UWwNWQ92 = false;
		boolean XtBhzkIp = false;
		ArrayList URbZyEi0 = new ArrayList();
		ArrayList Dn1eSkrP = new ArrayList();
		ArrayList N3xLKmJi = new ArrayList();
		int FaiHSEog;
		URL jRzQjvEM = n5UBjXAK.toURI().toURL();
		InputStream HShFTD6o = jRzQjvEM.openStream();
		InputStreamReader fSXoi3LP = new InputStreamReader(HShFTD6o);
		BufferedReader XeUBpQ9Z = new BufferedReader(fSXoi3LP);
		NHq7NXzc = XeUBpQ9Z.readLine();
		NHq7NXzc = XeUBpQ9Z.readLine();
		NHq7NXzc = XeUBpQ9Z.readLine();
		NHq7NXzc = XeUBpQ9Z.readLine();
		NHq7NXzc = XeUBpQ9Z.readLine();
		NHq7NXzc = XeUBpQ9Z.readLine();
		NHq7NXzc = XeUBpQ9Z.readLine();
		while ((NHq7NXzc = XeUBpQ9Z.readLine()) != null) {
			xo6Kp5ns = NHq7NXzc.split("\\s+");
			FaiHSEog = xo6Kp5ns.length;
			if (FaiHSEog < 1)
				continue;
			w3ULyb5h = xo6Kp5ns[0];
			dlERLh2C = xo6Kp5ns[1];
			if (dlERLh2C.startsWith("BPM")) {
				if (lSjLZGd7)
					dumpxData(WQfANppC, URbZyEi0);
				else if (UWwNWQ92)
					dumpyData(WQfANppC, Dn1eSkrP);
				else if (XtBhzkIp)
					dumpampData(WQfANppC, N3xLKmJi);
				gtysY2QO = xo6Kp5ns[4];
				if (gtysY2QO.equals("HORIZONTAL")) {
					lSjLZGd7 = true;
					UWwNWQ92 = false;
					XtBhzkIp = false;
				}
				if (gtysY2QO.equals("VERTICAL")) {
					UWwNWQ92 = true;
					lSjLZGd7 = false;
					XtBhzkIp = false;
				}
				if (gtysY2QO.equals("AMPLITUDE")) {
					UWwNWQ92 = false;
					lSjLZGd7 = false;
					XtBhzkIp = true;
				}
				WQfANppC = xo6Kp5ns[3];
				URbZyEi0.clear();
				Dn1eSkrP.clear();
				N3xLKmJi.clear();
			}
			if (dlERLh2C.startsWith("WAVEFORM"))
				continue;
			if (FaiHSEog == 3) {
				if (lSjLZGd7)
					URbZyEi0.add(new Double(Double.parseDouble(xo6Kp5ns[2])));
				else if (UWwNWQ92)
					Dn1eSkrP.add(new Double(Double.parseDouble(xo6Kp5ns[2])));
				else if (XtBhzkIp)
					N3xLKmJi.add(new Double(Double.parseDouble(xo6Kp5ns[2])));
			}
		}
		dumpampData(WQfANppC, N3xLKmJi);
		data.add(xdatamap);
		data.add(ydatamap);
		data.add(ampdatamap);
		return data;
	}

}