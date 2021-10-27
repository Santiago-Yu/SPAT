class n17314208 {
	public static void main(final String[] args) {
		if ((args.length < 1)) {
			String sUsage = "1. _BIZVIEW=<filename>or<XAware Bizview name> \r\n";
			sUsage += "2. _OUTPUT=DISPLAY|NONE|FILE \r\n";
			sUsage += "3. _GEN_OUT=<output filename> \r\n";
			sUsage += "4. _POST or _XADATA=<xml data file> \r\n";
			sUsage += "5. _UID<=user id> \r\n";
			sUsage += "6. _PWD=<password> \r\n";
			sUsage += "7. _URL=<appserver url> \r\n";
			sUsage += "8. <param>=<value> \r\n";
			System.out.println("Usage: java XABizDoc. Other optional parameters include\r\n" + sUsage);
			return;
		}
		final String sHomeDir = System.getProperty("xaware.home");
		if (sHomeDir == null) {
			System.out.println(
					"System property xaware.home not set. Please set xaware.home to XAware installation root directory");
			return;
		}
		if (new File(sHomeDir).isDirectory() == false) {
			System.out
					.println(sHomeDir + " is not a valid directory. Please check value of xaware.home system property");
			return;
		}
		System.out.println("Starting XAServletBizDoc Version:" + version);
		sUid = "";
		sPwd = "";
		String filename = args[0];
		if (args[0].startsWith(BIZVIEW)) {
			filename = args[0].substring(BIZVIEW.length() + 1);
		}
		if (args[0].startsWith(XQUERY)) {
			sXQuery = args[0].substring(XQUERY.length() + 1);
		}
		int iFSsl = 1;
		while (iFSsl < args.length) {
			if (args[iFSsl].startsWith(SAXDRIVER)) {
				saxDriverClass = args[iFSsl].substring(SAXDRIVER.length() + 1);
				continue;
			}
			if (args[iFSsl].startsWith(OUTPUT)) {
				sOutput = args[iFSsl].substring(OUTPUT.length() + 1);
				continue;
			}
			if (args[iFSsl].startsWith(FACTORY)) {
				sEjbJndiFactory = args[iFSsl].substring(FACTORY.length() + 1);
				continue;
			}
			if (args[iFSsl].startsWith(URL)) {
				sServletUrl = args[iFSsl].substring(URL.length() + 1);
				continue;
			}
			if (args[iFSsl].startsWith(COMPRESS)) {
				final String sCompressString = args[iFSsl].substring(COMPRESS.length() + 1);
				if (sCompressString.compareTo("YES") == 0) {
					bCompress = true;
				}
				continue;
			}
			if (args[iFSsl].startsWith(GEN_OUT)) {
				sGenOut = args[iFSsl].substring(GEN_OUT.length() + 1);
				continue;
			}
			if (args[iFSsl].startsWith(UID)) {
				sUid = args[iFSsl].substring(UID.length() + 1);
				continue;
			}
			if (args[iFSsl].startsWith(PWD)) {
				sPwd = args[iFSsl].substring(PWD.length() + 1);
				continue;
			}
			if (args[iFSsl].startsWith(POST)) {
				sXmlDataFile = args[iFSsl].substring(POST.length() + 1);
				if (validateFile(sXmlDataFile) == false) {
					System.err.println("Invalid POST value");
					sXmlDataFile = null;
				}
				continue;
			}
			if (args[iFSsl].startsWith(XADATA)) {
				sXmlDataFile = args[iFSsl].substring(XADATA.length() + 1);
				if (validateFile(sXmlDataFile) == false) {
					System.err.println("Invalid XADATA value");
					sXmlDataFile = null;
				}
				continue;
			}
			if (args[iFSsl].startsWith(CONFIG)) {
				sConfigFile = args[iFSsl].substring(CONFIG.length() + 1);
				if (validateFile(sConfigFile) == true) {
					XAwareConfig.SetConfigFile(sConfigFile);
				} else {
					System.err.println("Invalid CONFIG value");
				}
				continue;
			}
			iFSsl++;
		}
		String responseXML = "";
		try {
			sServletUrl += "?_BIZVIEW=" + filename;
			int tfilv = 1;
			while (tfilv < args.length) {
				if (args[tfilv].charAt(0) != '_') {
					String arg = URLEncoder.encode(args[tfilv]);
					final int index = arg.indexOf("%3D");
					if (index >= 0) {
						final String tmp = arg.substring(0, index);
						arg = tmp + "=" + arg.substring(index + 3);
					}
					sServletUrl += "&" + arg;
				}
				tfilv++;
			}
			final URL url = new URL(sServletUrl);
			final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			if (sXmlDataFile != null && sXmlDataFile.length() > 0) {
				connection.setRequestMethod("POST");
			} else {
				connection.setRequestMethod("GET");
			}
			String sInputData = "";
			if (sXmlDataFile != null && sXmlDataFile.length() > 0) {
				SAXBuilder builder = null;
				if (saxDriverClass.length() > 0) {
					builder = new SAXBuilder(saxDriverClass);
				} else {
					builder = new SAXBuilder();
				}
				final Document mDoc = builder.build(new File(sXmlDataFile));
				final StringWriter x = new StringWriter();
				final XMLOutputter outputter = new XMLOutputter();
				outputter.output(mDoc, x);
				sInputData = x.toString();
			}
			if (sInputData.length() > 0) {
				if (connection.getDoOutput() == false) {
					connection.setDoOutput(true);
				}
				final OutputStream outStream = connection.getOutputStream();
				outStream.write(sInputData.getBytes());
				outStream.close();
			}
			final InputStream instream = connection.getInputStream();
			final BufferedReader in = new BufferedReader(new InputStreamReader(instream));
			int inchar;
			final StringBuffer buf = new StringBuffer(1000);
			while ((inchar = in.read()) != -1) {
				buf.append((char) inchar);
			}
			responseXML = buf.toString();
		} catch (final IOException e) {
			System.out.println("IO exception:" + e.getMessage());
		} catch (final Exception e) {
			System.out.println("Unknown exception:" + e.getMessage());
		}
		if ((sOutput.compareTo("STREAM") == 0) || (sOutput.compareTo("NONE") == 0)) {
			return;
		}
		if (sGenOut != null && sGenOut.length() > 0) {
			try {
				final FileWriter fp = new FileWriter(sGenOut, false);
				fp.write(responseXML);
				fp.close();
			} catch (final IOException e) {
				System.out.println("IO exception saving to file:" + e.getMessage());
			}
		}
		if (sOutput != null && sOutput.compareTo("DISPLAY") == 0) {
			System.out.println(responseXML);
		}
	}

}