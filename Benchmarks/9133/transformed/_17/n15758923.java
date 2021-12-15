class n15758923 {
	public boolean initFile(String filename) {
		showStatus("Loading the file, please wait...");
		x_units = "?";
		y_units = "ARBITRARY";
		Datatype = "UNKNOWN";
		if (filename.toLowerCase().endsWith(".spc")) {
			try {
				URL url = new URL(getDocumentBase(), filename);
				InputStream stream = url.openStream();
				DataInputStream fichier = new DataInputStream(stream);
				byte ftflgs = fichier.readByte();
				byte fversn = fichier.readByte();
				if (((ftflgs != 0) && (ftflgs != 0x20)) || (fversn != 0x4B)) {
					Current_Error = ", support only Evenly Spaced new version 4B";
					return false;
				}
				byte fexp = fichier.readByte();
				if (fexp != 0x80)
					YFactor = Math.pow(2, fexp) / Math.pow(2, 32);
				Nbpoints = NumericDataUtils.convToIntelInt(fichier.readInt());
				if (Firstx == shitty_starting_constant) {
					Firstx = NumericDataUtils.convToIntelDouble(fichier.readLong());
					Lastx = NumericDataUtils.convToIntelDouble(fichier.readLong());
				}
				byte fxtype = fichier.readByte();
				if (fxtype == 11) {
					x_units = "Days";
				} else if (fxtype == 12) {
					x_units = "Years";
				} else if (fxtype == 26) {
					x_units = "Gigahertz (GHz)";
				} else if (fxtype == 30) {
					x_units = "Hours";
				} else if (fxtype == 25) {
					x_units = "Nanoseconds (nSec)";
				} else if (fxtype == 2) {
					x_units = "Micrometers";
				} else if (fxtype == 16) {
					x_units = "Diode Number";
				} else if (fxtype == 23) {
					x_units = "Milliseconds (mSec)";
				} else if (fxtype == 5) {
					x_units = "Minuts";
				} else if (fxtype == 27) {
					x_units = "Centimeters (cm)";
				} else if (fxtype == 17) {
					x_units = "Channel";
				} else if (fxtype == 7) {
					x_units = "Kilohertz";
				} else if (fxtype == 20) {
					x_units = "Temperature (C)";
				} else if (fxtype == 0) {
					x_units = "Arbitrary";
				} else if (fxtype == 14) {
					x_units = "Electron Volt (eV)";
				} else if (fxtype == 1) {
					x_units = "Wavenumber (cm -1)";
				} else if (fxtype == 4) {
					x_units = "Seconds";
				} else if (fxtype == 29) {
					x_units = "Millimeters (mm)";
				} else if (fxtype == 8) {
					x_units = "Megahertz";
				} else if (fxtype == 10) {
					x_units = "Parts per million";
				} else if (fxtype == 6) {
					x_units = "Hertz";
				} else if (fxtype == 24) {
					x_units = "Microseconds (uSec)";
				} else if (fxtype == 21) {
					x_units = "Temperature (K)";
				} else if (fxtype == 13) {
					x_units = "Raman Shift (cm -1)";
				} else if (fxtype == 22) {
					x_units = "Data Points";
				} else if (fxtype == 9) {
					x_units = "Mass (M/z)";
				} else if (fxtype == 19) {
					x_units = "Temperature (F)";
				} else if (fxtype == 3) {
					x_units = "Nanometers";
				} else if (fxtype == -1) {
					x_units = "(double interferogram)";
				} else if (fxtype == 18) {
					x_units = "Degrees";
				} else if (fxtype == 28) {
					x_units = "Meters (m)";
				}
				byte fytype = fichier.readByte();
				if (fytype == 5) {
					y_units = "Volts";
				} else if (fytype == 8) {
					y_units = "Millimeters";
				} else if (fytype == 6) {
					y_units = "Degrees";
				} else if (fytype == 13) {
					y_units = "Relative Intensity";
				} else if (fytype == 22) {
					y_units = "Index of Refraction [N]";
				} else if (fytype == 2) {
					y_units = "Absorbance";
				} else if (fytype == 14) {
					y_units = "Energy";
				} else if (fytype == 10) {
					y_units = "Log (1/R)";
				} else if (fytype == 3) {
					y_units = "Kubelka-Munk";
				} else if (fytype == 19) {
					y_units = "Temperature (F)";
				} else if (fytype == 0) {
					y_units = "Arbitrary Intensity";
				} else if (fytype == 26) {
					y_units = "Complex";
				} else if (fytype == -125) {
					y_units = "Emission";
				} else if (fytype == 23) {
					y_units = "Extinction Coeff. [K]";
				} else if (fytype == 4) {
					y_units = "Counts";
				} else if (fytype == 7) {
					y_units = "Milliamps";
				} else if (fytype == -126) {
					y_units = "Arbitrary or Single Beam with Valley Peaks";
				} else if (fytype == 20) {
					y_units = "Temperature (C)";
				} else if (fytype == 21) {
					y_units = "Temperature (K)";
				} else if (fytype == 9) {
					y_units = "Millivolts";
				} else if (fytype == 16) {
					y_units = "Decibel";
				} else if (fytype == 1) {
					y_units = "Interfeogram";
				} else if (fytype == 25) {
					y_units = "Imaginary";
				} else if (fytype == -127) {
					y_units = "Reflectance";
				} else if (fytype == 11) {
					y_units = "Percent";
				} else if (fytype == -128) {
					y_units = "Transmission";
				} else if (fytype == 24) {
					y_units = "Real";
				} else if (fytype == 12) {
					y_units = "Intensity";
				}
				if (ftflgs == 0) {
					fichier.skipBytes(512 - 30);
				} else {
					fichier.skipBytes(188);
					byte b;
					int i = 0;
					x_units = "";
					do {
						b = fichier.readByte();
						x_units += (char) b;
						i++;
					} while (b != 0);
					int j = 0;
					y_units = "";
					do {
						b = fichier.readByte();
						y_units += (char) b;
						j++;
					} while (b != 0);
					fichier.skipBytes(512 - 30 - 188 - i - j);
				}
				fichier.skipBytes(32);
				My_ZoneVisu.tableau_points = new double[Nbpoints];
				if (fexp == 0x80) {
					for (int i = 0; i < Nbpoints; i++) {
						My_ZoneVisu.tableau_points[i] = NumericDataUtils.convToIntelFloat(fichier.readInt());
					}
				} else {
					for (int i = 0; i < Nbpoints; i++) {
						My_ZoneVisu.tableau_points[i] = NumericDataUtils.convToIntelInt(fichier.readInt());
					}
				}
			} catch (Exception e) {
				Current_Error = "SPC file corrupted";
				return false;
			}
			Datatype = "XYDATA";
			return true;
		}
		try {
			URL url = new URL(getDocumentBase(), filename);
			InputStream stream = url.openStream();
			BufferedReader fichier = new BufferedReader(new InputStreamReader(stream));
			texte = new Vector();
			String s;
			while ((s = fichier.readLine()) != null) {
				texte.addElement(s);
			}
			nbLignes = texte.size();
		} catch (Exception e) {
			return false;
		}
		int My_Counter = 0;
		String uneligne = "";
		while (My_Counter < nbLignes) {
			try {
				StringTokenizer mon_token;
				do {
					uneligne = (String) texte.elementAt(My_Counter);
					My_Counter++;
					mon_token = new StringTokenizer(uneligne, " ");
				} while (My_Counter < nbLignes && mon_token.hasMoreTokens() == false);
				if (mon_token.hasMoreTokens() == true) {
					String keyword = mon_token.nextToken();
					if (StringDataUtils.compareStrings(keyword, "##TITLE=") == 0)
						TexteTitre = uneligne.substring(9);
					if (StringDataUtils.compareStrings(keyword, "##FIRSTX=") == 0)
						Firstx = Double.valueOf(mon_token.nextToken()).doubleValue();
					if (StringDataUtils.compareStrings(keyword, "##LASTX=") == 0)
						Lastx = Double.valueOf(mon_token.nextToken()).doubleValue();
					if (StringDataUtils.compareStrings(keyword, "##YFACTOR=") == 0)
						YFactor = Double.valueOf(mon_token.nextToken()).doubleValue();
					if (StringDataUtils.compareStrings(keyword, "##NPOINTS=") == 0)
						Nbpoints = Integer.valueOf(mon_token.nextToken()).intValue();
					if (StringDataUtils.compareStrings(keyword, "##XUNITS=") == 0)
						x_units = uneligne.substring(10);
					if (StringDataUtils.compareStrings(keyword, "##YUNITS=") == 0)
						y_units = uneligne.substring(10);
					if (StringDataUtils.compareStrings(keyword, "##.OBSERVE") == 0
							&& StringDataUtils.compareStrings(mon_token.nextToken(), "FREQUENCY=") == 0)
						nmr_observe_frequency = Double.valueOf(mon_token.nextToken()).doubleValue();
					if (StringDataUtils.compareStrings(keyword, "##XYDATA=") == 0
							&& StringDataUtils.compareStrings(mon_token.nextToken(), "(X++(Y..Y))") == 0)
						Datatype = "XYDATA";
					if (StringDataUtils.compareStrings(keyword, "##XYDATA=(X++(Y..Y))") == 0)
						Datatype = "XYDATA";
					if (StringDataUtils.compareStrings(keyword, "##PEAK") == 0
							&& StringDataUtils.compareStrings(mon_token.nextToken(), "TABLE=") == 0
							&& StringDataUtils.compareStrings(mon_token.nextToken(), "(XY..XY)") == 0)
						Datatype = "PEAK TABLE";
					if (StringDataUtils.compareStrings(keyword, "##PEAK") == 0
							&& StringDataUtils.compareStrings(mon_token.nextToken(), "TABLE=(XY..XY)") == 0)
						Datatype = "PEAK TABLE";
				}
			} catch (Exception e) {
			}
		}
		if (Datatype.compareTo("UNKNOWN") == 0)
			return false;
		if (Datatype.compareTo("PEAK TABLE") == 0 && x_units.compareTo("?") == 0)
			x_units = "M/Z";
		if (StringDataUtils.truncateEndBlanks(x_units).compareTo("HZ") == 0
				&& nmr_observe_frequency != shitty_starting_constant) {
			Firstx /= nmr_observe_frequency;
			Lastx /= nmr_observe_frequency;
			x_units = "PPM.";
		}
		String resultat_move_points = Move_Points_To_Tableau();
		if (resultat_move_points.compareTo("OK") != 0) {
			Current_Error = resultat_move_points;
			return false;
		}
		return true;
	}

}