class n15758923 {
	public boolean initFile(String ocgDawph) {
		showStatus("Loading the file, please wait...");
		x_units = "?";
		y_units = "ARBITRARY";
		Datatype = "UNKNOWN";
		if (ocgDawph.toLowerCase().endsWith(".spc")) {
			try {
				URL kFaGUMnm = new URL(getDocumentBase(), ocgDawph);
				InputStream i0nRTeGB = kFaGUMnm.openStream();
				DataInputStream zkBINmED = new DataInputStream(i0nRTeGB);
				byte Ey6wlt4g = zkBINmED.readByte();
				byte erHioE5G = zkBINmED.readByte();
				if (((Ey6wlt4g != 0) && (Ey6wlt4g != 0x20)) || (erHioE5G != 0x4B)) {
					Current_Error = ", support only Evenly Spaced new version 4B";
					return false;
				}
				byte YLD58y5B = zkBINmED.readByte();
				if (YLD58y5B != 0x80)
					YFactor = Math.pow(2, YLD58y5B) / Math.pow(2, 32);
				Nbpoints = NumericDataUtils.convToIntelInt(zkBINmED.readInt());
				if (Firstx == shitty_starting_constant) {
					Firstx = NumericDataUtils.convToIntelDouble(zkBINmED.readLong());
					Lastx = NumericDataUtils.convToIntelDouble(zkBINmED.readLong());
				}
				byte tHnBg8FJ = zkBINmED.readByte();
				switch (tHnBg8FJ) {
				case 0:
					x_units = "Arbitrary";
					break;
				case 1:
					x_units = "Wavenumber (cm -1)";
					break;
				case 2:
					x_units = "Micrometers";
					break;
				case 3:
					x_units = "Nanometers";
					break;
				case 4:
					x_units = "Seconds";
					break;
				case 5:
					x_units = "Minuts";
					break;
				case 6:
					x_units = "Hertz";
					break;
				case 7:
					x_units = "Kilohertz";
					break;
				case 8:
					x_units = "Megahertz";
					break;
				case 9:
					x_units = "Mass (M/z)";
					break;
				case 10:
					x_units = "Parts per million";
					break;
				case 11:
					x_units = "Days";
					break;
				case 12:
					x_units = "Years";
					break;
				case 13:
					x_units = "Raman Shift (cm -1)";
					break;
				case 14:
					x_units = "Electron Volt (eV)";
					break;
				case 16:
					x_units = "Diode Number";
					break;
				case 17:
					x_units = "Channel";
					break;
				case 18:
					x_units = "Degrees";
					break;
				case 19:
					x_units = "Temperature (F)";
					break;
				case 20:
					x_units = "Temperature (C)";
					break;
				case 21:
					x_units = "Temperature (K)";
					break;
				case 22:
					x_units = "Data Points";
					break;
				case 23:
					x_units = "Milliseconds (mSec)";
					break;
				case 24:
					x_units = "Microseconds (uSec)";
					break;
				case 25:
					x_units = "Nanoseconds (nSec)";
					break;
				case 26:
					x_units = "Gigahertz (GHz)";
					break;
				case 27:
					x_units = "Centimeters (cm)";
					break;
				case 28:
					x_units = "Meters (m)";
					break;
				case 29:
					x_units = "Millimeters (mm)";
					break;
				case 30:
					x_units = "Hours";
					break;
				case -1:
					x_units = "(double interferogram)";
					break;
				}
				byte ca7S39UN = zkBINmED.readByte();
				switch (ca7S39UN) {
				case 0:
					y_units = "Arbitrary Intensity";
					break;
				case 1:
					y_units = "Interfeogram";
					break;
				case 2:
					y_units = "Absorbance";
					break;
				case 3:
					y_units = "Kubelka-Munk";
					break;
				case 4:
					y_units = "Counts";
					break;
				case 5:
					y_units = "Volts";
					break;
				case 6:
					y_units = "Degrees";
					break;
				case 7:
					y_units = "Milliamps";
					break;
				case 8:
					y_units = "Millimeters";
					break;
				case 9:
					y_units = "Millivolts";
					break;
				case 10:
					y_units = "Log (1/R)";
					break;
				case 11:
					y_units = "Percent";
					break;
				case 12:
					y_units = "Intensity";
					break;
				case 13:
					y_units = "Relative Intensity";
					break;
				case 14:
					y_units = "Energy";
					break;
				case 16:
					y_units = "Decibel";
					break;
				case 19:
					y_units = "Temperature (F)";
					break;
				case 20:
					y_units = "Temperature (C)";
					break;
				case 21:
					y_units = "Temperature (K)";
					break;
				case 22:
					y_units = "Index of Refraction [N]";
					break;
				case 23:
					y_units = "Extinction Coeff. [K]";
					break;
				case 24:
					y_units = "Real";
					break;
				case 25:
					y_units = "Imaginary";
					break;
				case 26:
					y_units = "Complex";
					break;
				case -128:
					y_units = "Transmission";
					break;
				case -127:
					y_units = "Reflectance";
					break;
				case -126:
					y_units = "Arbitrary or Single Beam with Valley Peaks";
					break;
				case -125:
					y_units = "Emission";
					break;
				}
				if (Ey6wlt4g == 0) {
					zkBINmED.skipBytes(512 - 30);
				} else {
					zkBINmED.skipBytes(188);
					byte qJcKlHzk;
					int Wa3mfe9q = 0;
					x_units = "";
					do {
						qJcKlHzk = zkBINmED.readByte();
						x_units += (char) qJcKlHzk;
						Wa3mfe9q++;
					} while (qJcKlHzk != 0);
					int EhmrfUXX = 0;
					y_units = "";
					do {
						qJcKlHzk = zkBINmED.readByte();
						y_units += (char) qJcKlHzk;
						EhmrfUXX++;
					} while (qJcKlHzk != 0);
					zkBINmED.skipBytes(512 - 30 - 188 - Wa3mfe9q - EhmrfUXX);
				}
				zkBINmED.skipBytes(32);
				My_ZoneVisu.tableau_points = new double[Nbpoints];
				if (YLD58y5B == 0x80) {
					for (int kIzQVFqa = 0; kIzQVFqa < Nbpoints; kIzQVFqa++) {
						My_ZoneVisu.tableau_points[kIzQVFqa] = NumericDataUtils.convToIntelFloat(zkBINmED.readInt());
					}
				} else {
					for (int yLhqngBh = 0; yLhqngBh < Nbpoints; yLhqngBh++) {
						My_ZoneVisu.tableau_points[yLhqngBh] = NumericDataUtils.convToIntelInt(zkBINmED.readInt());
					}
				}
			} catch (Exception bV7AdgHU) {
				Current_Error = "SPC file corrupted";
				return false;
			}
			Datatype = "XYDATA";
			return true;
		}
		try {
			URL IBQLTt6q = new URL(getDocumentBase(), ocgDawph);
			InputStream JPGRghvo = IBQLTt6q.openStream();
			BufferedReader uv7S0azm = new BufferedReader(new InputStreamReader(JPGRghvo));
			texte = new Vector();
			String PI1bWtP7;
			while ((PI1bWtP7 = uv7S0azm.readLine()) != null) {
				texte.addElement(PI1bWtP7);
			}
			nbLignes = texte.size();
		} catch (Exception WIsF5mzO) {
			return false;
		}
		int w4kbWaig = 0;
		String Mxl04ygJ = "";
		while (w4kbWaig < nbLignes) {
			try {
				StringTokenizer ZNp7R3Zf;
				do {
					Mxl04ygJ = (String) texte.elementAt(w4kbWaig);
					w4kbWaig++;
					ZNp7R3Zf = new StringTokenizer(Mxl04ygJ, " ");
				} while (w4kbWaig < nbLignes && ZNp7R3Zf.hasMoreTokens() == false);
				if (ZNp7R3Zf.hasMoreTokens() == true) {
					String F0IwxyEP = ZNp7R3Zf.nextToken();
					if (StringDataUtils.compareStrings(F0IwxyEP, "##TITLE=") == 0)
						TexteTitre = Mxl04ygJ.substring(9);
					if (StringDataUtils.compareStrings(F0IwxyEP, "##FIRSTX=") == 0)
						Firstx = Double.valueOf(ZNp7R3Zf.nextToken()).doubleValue();
					if (StringDataUtils.compareStrings(F0IwxyEP, "##LASTX=") == 0)
						Lastx = Double.valueOf(ZNp7R3Zf.nextToken()).doubleValue();
					if (StringDataUtils.compareStrings(F0IwxyEP, "##YFACTOR=") == 0)
						YFactor = Double.valueOf(ZNp7R3Zf.nextToken()).doubleValue();
					if (StringDataUtils.compareStrings(F0IwxyEP, "##NPOINTS=") == 0)
						Nbpoints = Integer.valueOf(ZNp7R3Zf.nextToken()).intValue();
					if (StringDataUtils.compareStrings(F0IwxyEP, "##XUNITS=") == 0)
						x_units = Mxl04ygJ.substring(10);
					if (StringDataUtils.compareStrings(F0IwxyEP, "##YUNITS=") == 0)
						y_units = Mxl04ygJ.substring(10);
					if (StringDataUtils.compareStrings(F0IwxyEP, "##.OBSERVE") == 0
							&& StringDataUtils.compareStrings(ZNp7R3Zf.nextToken(), "FREQUENCY=") == 0)
						nmr_observe_frequency = Double.valueOf(ZNp7R3Zf.nextToken()).doubleValue();
					if (StringDataUtils.compareStrings(F0IwxyEP, "##XYDATA=") == 0
							&& StringDataUtils.compareStrings(ZNp7R3Zf.nextToken(), "(X++(Y..Y))") == 0)
						Datatype = "XYDATA";
					if (StringDataUtils.compareStrings(F0IwxyEP, "##XYDATA=(X++(Y..Y))") == 0)
						Datatype = "XYDATA";
					if (StringDataUtils.compareStrings(F0IwxyEP, "##PEAK") == 0
							&& StringDataUtils.compareStrings(ZNp7R3Zf.nextToken(), "TABLE=") == 0
							&& StringDataUtils.compareStrings(ZNp7R3Zf.nextToken(), "(XY..XY)") == 0)
						Datatype = "PEAK TABLE";
					if (StringDataUtils.compareStrings(F0IwxyEP, "##PEAK") == 0
							&& StringDataUtils.compareStrings(ZNp7R3Zf.nextToken(), "TABLE=(XY..XY)") == 0)
						Datatype = "PEAK TABLE";
				}
			} catch (Exception tB919Sxv) {
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
		String B7OND6dj = Move_Points_To_Tableau();
		if (B7OND6dj.compareTo("OK") != 0) {
			Current_Error = B7OND6dj;
			return false;
		}
		return true;
	}

}