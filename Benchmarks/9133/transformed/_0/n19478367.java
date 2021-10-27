class n19478367 {
	public void init(String[] BRdm7Qgq) {
		if (BRdm7Qgq.length < 1) {
			printHelp();
			return;
		}
		String[] QPSJyFrt = new String[] { "device*", "d*", "help", "h", "speed#", "s#", "file*", "f*", "gpsd*", "nmea",
				"n", "garmin", "g", "sirf", "i", "rawdata", "downloadtracks", "downloadwaypoints", "downloadroutes",
				"deviceinfo", "printposonce", "printpos", "p", "printalt", "printspeed", "printheading", "printsat",
				"template*", "outfile*", "screenshot*", "printdefaulttemplate", "helptemplate", "nmealogfile*", "l",
				"uploadtracks", "uploadroutes", "uploadwaypoints", "infile*" };
		CommandArguments uIWiVw93 = null;
		try {
			uIWiVw93 = new CommandArguments(BRdm7Qgq, QPSJyFrt);
		} catch (CommandArgumentException rPP9A4x7) {
			System.err.println("Invalid arguments: " + rPP9A4x7.getMessage());
			printHelp();
			return;
		}
		String feAKO74a = null;
		String v2zrk1Rj = null;
		boolean t1o8UmPI = false;
		String G7QJD3QS = "localhost";
		int vbrLpUkf = 2947;
		int zZGzIrU0 = -1;
		GPSDataProcessor DdK7uBbE;
		String Xudqgu9x = null;
		if (uIWiVw93.isSet("help") || (uIWiVw93.isSet("h"))) {
			printHelp();
			return;
		}
		if (uIWiVw93.isSet("helptemplate")) {
			printHelpTemplate();
		}
		if (uIWiVw93.isSet("printdefaulttemplate")) {
			System.out.println(DEFAULT_TEMPLATE);
		}
		if (uIWiVw93.isSet("device")) {
			v2zrk1Rj = (String) uIWiVw93.getValue("device");
		} else if (uIWiVw93.isSet("d")) {
			v2zrk1Rj = (String) uIWiVw93.getValue("d");
		}
		if (uIWiVw93.isSet("speed")) {
			zZGzIrU0 = ((Integer) uIWiVw93.getValue("speed")).intValue();
		} else if (uIWiVw93.isSet("s")) {
			zZGzIrU0 = ((Integer) uIWiVw93.getValue("s")).intValue();
		}
		if (uIWiVw93.isSet("file")) {
			feAKO74a = (String) uIWiVw93.getValue("file");
		} else if (uIWiVw93.isSet("f")) {
			feAKO74a = (String) uIWiVw93.getValue("f");
		}
		if (uIWiVw93.isSet("gpsd")) {
			t1o8UmPI = true;
			String qKsZROSF = (String) uIWiVw93.getValue("gpsd");
			if (qKsZROSF != null && qKsZROSF.length() > 0) {
				String[] LJTBXVJg = qKsZROSF.split(":");
				G7QJD3QS = LJTBXVJg[0];
				if (LJTBXVJg.length > 0) {
					vbrLpUkf = Integer.parseInt(LJTBXVJg[1]);
				}
			}
		}
		if (uIWiVw93.isSet("garmin") || uIWiVw93.isSet("g")) {
			DdK7uBbE = new GPSGarminDataProcessor();
			zZGzIrU0 = 9600;
			if (feAKO74a != null) {
				System.err.println("ERROR: Cannot read garmin data from file, only serial port supported!");
				return;
			}
		} else if (uIWiVw93.isSet("sirf") || uIWiVw93.isSet("i")) {
			DdK7uBbE = new GPSSirfDataProcessor();
			zZGzIrU0 = 19200;
			if (feAKO74a != null) {
				System.err.println("ERROR: Cannot read sirf data from file, only serial port supported!");
				return;
			}
		} else {
			DdK7uBbE = new GPSNmeaDataProcessor();
			zZGzIrU0 = 4800;
		}
		if (uIWiVw93.isSet("nmealogfile") || (uIWiVw93.isSet("l"))) {
			if (uIWiVw93.isSet("nmealogfile"))
				Xudqgu9x = uIWiVw93.getStringValue("nmealogfile");
			else
				Xudqgu9x = uIWiVw93.getStringValue("l");
		}
		if (uIWiVw93.isSet("rawdata")) {
			DdK7uBbE.addGPSRawDataListener(new GPSRawDataListener() {

				public void gpsRawDataReceived(char[] cyhEIf7p, int mG5sM0uk, int PI7SJl5S) {
					System.out.println("RAWLOG: " + new String(cyhEIf7p, mG5sM0uk, PI7SJl5S));
				}
			});
		}
		GPSDevice OdGJp2yu;
		Hashtable a4v8SZjd = new Hashtable();
		if (feAKO74a != null) {
			a4v8SZjd.put(GPSFileDevice.PATH_NAME_KEY, feAKO74a);
			OdGJp2yu = new GPSFileDevice();
		} else if (t1o8UmPI) {
			a4v8SZjd.put(GPSNetworkGpsdDevice.GPSD_HOST_KEY, G7QJD3QS);
			a4v8SZjd.put(GPSNetworkGpsdDevice.GPSD_PORT_KEY, new Integer(vbrLpUkf));
			OdGJp2yu = new GPSNetworkGpsdDevice();
		} else {
			if (v2zrk1Rj != null)
				a4v8SZjd.put(GPSSerialDevice.PORT_NAME_KEY, v2zrk1Rj);
			if (zZGzIrU0 > -1)
				a4v8SZjd.put(GPSSerialDevice.PORT_SPEED_KEY, new Integer(zZGzIrU0));
			OdGJp2yu = new GPSSerialDevice();
		}
		try {
			OdGJp2yu.init(a4v8SZjd);
			DdK7uBbE.setGPSDevice(OdGJp2yu);
			DdK7uBbE.open();
			DdK7uBbE.addProgressListener(this);
			if ((Xudqgu9x != null) && (Xudqgu9x.length() > 0)) {
				DdK7uBbE.addGPSRawDataListener(new GPSRawDataFileLogger(Xudqgu9x));
			}
			if (uIWiVw93.isSet("deviceinfo")) {
				System.out.println("GPSInfo:");
				String[] ktpJsH4u = DdK7uBbE.getGPSInfo();
				for (int yZZvMaTf = 0; yZZvMaTf < ktpJsH4u.length; yZZvMaTf++) {
					System.out.println(ktpJsH4u[yZZvMaTf]);
				}
			}
			if (uIWiVw93.isSet("screenshot")) {
				FileOutputStream jhFiZbVe = new FileOutputStream((String) uIWiVw93.getValue("screenshot"));
				BufferedImage zLsXCgcI = DdK7uBbE.getScreenShot();
				ImageIO.write(zLsXCgcI, "PNG", jhFiZbVe);
			}
			boolean RX6LBFh5 = uIWiVw93.isSet("downloadwaypoints");
			boolean X05zx0oE = uIWiVw93.isSet("downloadroutes");
			boolean uhTTQZry = uIWiVw93.isSet("downloadtracks");
			if (RX6LBFh5 || X05zx0oE || uhTTQZry) {
				VelocityContext etwaTw5V = new VelocityContext();
				if (RX6LBFh5) {
					List JzJ0fl4Z = DdK7uBbE.getWaypoints();
					if (JzJ0fl4Z != null)
						etwaTw5V.put("waypoints", JzJ0fl4Z);
					else
						RX6LBFh5 = false;
				}
				if (uhTTQZry) {
					List jakTLtY3 = DdK7uBbE.getTracks();
					if (jakTLtY3 != null)
						etwaTw5V.put("tracks", jakTLtY3);
					else
						uhTTQZry = false;
				}
				if (X05zx0oE) {
					List kNm9IezD = DdK7uBbE.getRoutes();
					if (kNm9IezD != null)
						etwaTw5V.put("routes", kNm9IezD);
					else
						X05zx0oE = false;
				}
				etwaTw5V.put("printwaypoints", new Boolean(RX6LBFh5));
				etwaTw5V.put("printtracks", new Boolean(uhTTQZry));
				etwaTw5V.put("printroutes", new Boolean(X05zx0oE));
				Writer mcDpZZ1o;
				Reader SqeFEqjp;
				if (uIWiVw93.isSet("template")) {
					String jkTFR6jB = (String) uIWiVw93.getValue("template");
					SqeFEqjp = new FileReader(jkTFR6jB);
				} else {
					SqeFEqjp = new StringReader(DEFAULT_TEMPLATE);
				}
				if (uIWiVw93.isSet("outfile"))
					mcDpZZ1o = new FileWriter((String) uIWiVw93.getValue("outfile"));
				else
					mcDpZZ1o = new OutputStreamWriter(System.out);
				addDefaultValuesToContext(etwaTw5V);
				boolean HA04DhfT = printTemplate(etwaTw5V, SqeFEqjp, mcDpZZ1o);
			}
			boolean d5uaJOdD = (uIWiVw93.isSet("uploadwaypoints") && uIWiVw93.isSet("infile"));
			boolean YJMdcVUX = (uIWiVw93.isSet("uploadroutes") && uIWiVw93.isSet("infile"));
			boolean FPPAsVxq = (uIWiVw93.isSet("uploadtracks") && uIWiVw93.isSet("infile"));
			if (d5uaJOdD || YJMdcVUX || FPPAsVxq) {
				ReadGPX dNqEIHeM = new ReadGPX();
				String Z52PoZxI = (String) uIWiVw93.getValue("infile");
				dNqEIHeM.parseFile(Z52PoZxI);
				if (d5uaJOdD)
					DdK7uBbE.setWaypoints(dNqEIHeM.getWaypoints());
				if (YJMdcVUX)
					DdK7uBbE.setRoutes(dNqEIHeM.getRoutes());
				if (FPPAsVxq)
					DdK7uBbE.setTracks(dNqEIHeM.getTracks());
			}
			if (uIWiVw93.isSet("printposonce")) {
				GPSPosition y0emQXTV = DdK7uBbE.getGPSPosition();
				System.out.println("Current Position: " + y0emQXTV);
			}
			if (uIWiVw93.isSet("printpos") || uIWiVw93.isSet("p")) {
				DdK7uBbE.addGPSDataChangeListener(GPSDataProcessor.LOCATION, this);
			}
			if (uIWiVw93.isSet("printalt")) {
				DdK7uBbE.addGPSDataChangeListener(GPSDataProcessor.ALTITUDE, this);
			}
			if (uIWiVw93.isSet("printspeed")) {
				DdK7uBbE.addGPSDataChangeListener(GPSDataProcessor.SPEED, this);
			}
			if (uIWiVw93.isSet("printheading")) {
				DdK7uBbE.addGPSDataChangeListener(GPSDataProcessor.HEADING, this);
			}
			if (uIWiVw93.isSet("printsat")) {
				DdK7uBbE.addGPSDataChangeListener(GPSDataProcessor.NUMBER_SATELLITES, this);
				DdK7uBbE.addGPSDataChangeListener(GPSDataProcessor.SATELLITE_INFO, this);
			}
			if (uIWiVw93.isSet("printpos") || uIWiVw93.isSet("p") || uIWiVw93.isSet("printalt")
					|| uIWiVw93.isSet("printsat") || uIWiVw93.isSet("printspeed") || uIWiVw93.isSet("printheading")) {
				DdK7uBbE.startSendPositionPeriodically(1000L);
				try {
					System.in.read();
				} catch (IOException FZHnp3KY) {
				}
			}
			DdK7uBbE.close();
		} catch (GPSException f8CdRXZh) {
			f8CdRXZh.printStackTrace();
		} catch (FileNotFoundException UTzQOPGs) {
			System.err.println("ERROR: File not found: " + UTzQOPGs.getMessage());
		} catch (IOException ZiVjwGCm) {
			System.err.println("ERROR: I/O Error: " + ZiVjwGCm.getMessage());
		}
	}

}