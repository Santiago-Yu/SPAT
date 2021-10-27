class n17314208 {
	public static void main(final String[] args) {
		if ((args.length < 1)) {
			String sUsage = "1. _BIZVIEW=<filename>or<XAware Bizview name> \r\n";
			sUsage = sUsage + ("2. _OUTPUT=DISPLAY|NONE|FILE \r\n");
			sUsage = sUsage + ("3. _GEN_OUT=<output filename> \r\n");
			sUsage = sUsage + ("4. _POST or _XADATA=<xml data file> \r\n");
			sUsage = sUsage + ("5. _UID<=user id> \r\n");
			sUsage = sUsage + ("6. _PWD=<password> \r\n");
			sUsage = sUsage + ("7. _URL=<appserver url> \r\n");
			sUsage = sUsage + ("8. <param>=<value> \r\n");
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
		for (int i = 1; i < args.length; i++) {
			if (args[i].startsWith(SAXDRIVER)) {
				saxDriverClass = args[i].substring(SAXDRIVER.length() + 1);
				continue;
			}
			if (args[i].startsWith(OUTPUT)) {
				sOutput = args[i].substring(OUTPUT.length() + 1);
				continue;
			}
			if (args[i].startsWith(FACTORY)) {
				sEjbJndiFactory = args[i].substring(FACTORY.length() + 1);
				continue;
			}
			if (args[i].startsWith(URL)) {
				sServletUrl = args[i].substring(URL.length() + 1);
				continue;
			}
			if (args[i].startsWith(COMPRESS)) {
				final String sCompressString = args[i].substring(COMPRESS.length() + 1);
				if (sCompressString.compareTo("YES") == 0) {
					bCompress = true;
				}
				continue;
			}
			if (args[i].startsWith(GEN_OUT)) {
				sGenOut = args[i].substring(GEN_OUT.length() + 1);
				continue;
			}
			if (args[i].startsWith(UID)) {
				sUid = args[i].substring(UID.length() + 1);
				continue;
			}
			if (args[i].startsWith(PWD)) {
				sPwd = args[i].substring(PWD.length() + 1);
				continue;
			}
			if (args[i].startsWith(POST)) {
				sXmlDataFile = args[i].substring(POST.length() + 1);
				if (validateFile(sXmlDataFile) == false) {
					System.err.println("Invalid POST value");
					sXmlDataFile = null;
				}
				continue;
			}
			if (args[i].startsWith(XADATA)) {
				sXmlDataFile = args[i].substring(XADATA.length() + 1);
				if (validateFile(sXmlDataFile) == false) {
					System.err.println("Invalid XADATA value");
					sXmlDataFile = null;
				}
				continue;
			}
			if (args[i].startsWith(CONFIG)) {
				sConfigFile = args[i].substring(CONFIG.length() + 1);
				if (validateFile(sConfigFile) == true) {
					XAwareConfig.SetConfigFile(sConfigFile);
				} else {
					System.err.println("Invalid CONFIG value");
				}
				continue;
			}
		}
		String responseXML = "";
		try {
			sServletUrl = sServletUrl + ("?_BIZVIEW=" + filename);
			for (int i = 1; i < args.length; i++) {
				if (args[i].charAt(0) != '_') {
					String arg = URLEncoder.encode(args[i]);
					final int index = arg.indexOf("%3D");
					if (index >= 0) {
						final String tmp = arg.substring(0, index);
						arg = tmp + "=" + arg.substring(index + 3);
					}
					sServletUrl = sServletUrl + ("&" + arg);
				}
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