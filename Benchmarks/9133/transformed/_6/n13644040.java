class n13644040 {
	public static void main(String[] args) throws Exception {
		String layerName = args[0];
		String layerDescription = args[1];
		String units = args[2];
		String rawDataDirPath = args[3];
		String processDirPath = args[4];
		String divaDirPath = args[5];
		String legendDirPath = args[6];
		String geotiffDirPath = args[7];
		String dbJdbcUrl = args[8];
		String dbUsername = args[9];
		String dbPassword = args[10];
		String geoserverUsername = args[11];
		String geoserverPassword = args[12];
		File rawDataDir = new File(rawDataDirPath);
		if (!rawDataDir.exists() || !rawDataDir.isDirectory()) {
			throw new RuntimeException(
					"Supplied raw data directory " + rawDataDirPath + " does not exist or is not a directory");
		}
		File processDir = new File(processDirPath);
		if (!processDir.exists() || !processDir.isDirectory()) {
			throw new RuntimeException(
					"Supplied process directory " + processDirPath + " does not exist or is not a directory");
		}
		File divaDir = new File(divaDirPath);
		if (!divaDir.exists() || !divaDir.isDirectory()) {
			throw new RuntimeException(
					"Supplied diva directory " + divaDirPath + " does not exist or is not a directory");
		}
		File legendDir = new File(legendDirPath);
		if (!legendDir.exists() || !legendDir.isDirectory()) {
			throw new RuntimeException(
					"Supplied legend directory " + legendDirPath + " does not exist or is not a directory");
		}
		File geotiffDir = new File(geotiffDirPath);
		if (!geotiffDir.exists() || !geotiffDir.isDirectory()) {
			throw new RuntimeException(
					"Supplied geotiff directory " + geotiffDirPath + " does not exist or is not a directory");
		}
		System.out.println("Beginning environmetal load");
		System.out.println("Connecting to database");
		Class.forName("org.postgresql.Driver");
		Properties props = new Properties();
		props.setProperty("user", dbUsername);
		props.setProperty("password", dbPassword);
		Connection conn = DriverManager.getConnection(dbJdbcUrl, props);
		conn.setAutoCommit(false);
		try {
			File layerProcessDir = new File(processDir, layerName);
			layerProcessDir.mkdir();
			System.out.println("Running gdalwarp");
			File hdrFile = new File(rawDataDir, "hdr.adf");
			if (!hdrFile.exists()) {
				throw new RuntimeException("Could not find hdr.adf in " + rawDataDirPath);
			}
			File bilFile = new File(layerProcessDir, layerName + ".bil");
			Process procGdalWarp = Runtime.getRuntime().exec(new String[] { "gdalwarp", "-of", "EHdr", "-ot", "Float32",
					hdrFile.getAbsolutePath(), bilFile.getAbsolutePath() });
			int gdalWarpReturnVal = procGdalWarp.waitFor();
			if (gdalWarpReturnVal != 0) {
				String gdalWarpErrorOutput = IOUtils.toString(procGdalWarp.getErrorStream());
				throw new RuntimeException("gdalwarp failed: " + gdalWarpErrorOutput);
			}
			System.out.println("Running Bil2diva");
			boolean bil2DivaSuccess = Bil2diva.bil2diva(layerProcessDir.getAbsolutePath() + File.separator + layerName,
					divaDir.getAbsolutePath() + File.separator + layerName, units);
			if (!bil2DivaSuccess) {
				throw new RuntimeException("Bil2diva Failed");
			}
			System.out.println("Running GridLegend");
			boolean gridLegendSuccess = GridLegend.generateGridLegend(
					divaDir.getAbsolutePath() + File.separator + layerName,
					legendDir.getAbsolutePath() + File.separator + layerName, 1, false);
			if (!gridLegendSuccess) {
				throw new RuntimeException("GridLegend Failed");
			}
			System.out.println("Running gdal_translate");
			File geotiffFile = new File(geotiffDir, layerName + ".tif");
			Process procGdalTranslate = Runtime.getRuntime().exec(new String[] { "gdal_translate", "-of", "GTiff",
					bilFile.getAbsolutePath(), geotiffFile.getAbsolutePath() });
			int gdalTranslateReturnVal = procGdalTranslate.waitFor();
			if (gdalTranslateReturnVal != 0) {
				String gdalTranslateErrorOutput = IOUtils.toString(procGdalTranslate.getErrorStream());
				throw new RuntimeException("gdal_translate failed: " + gdalTranslateErrorOutput);
			}
			System.out.println("Extracting extents and min/max environmental value from diva .grd file");
			File divaGrd = new File(divaDir, layerName + ".grd");
			if (!divaGrd.exists()) {
				throw new RuntimeException("Could not locate diva .grd file: " + divaGrd.toString());
			}
			String strDivaGrd = FileUtils.readFileToString(divaGrd);
			float minValue = Float.parseFloat(matchPattern(strDivaGrd, "^MinValue=(.+)$"));
			float maxValue = Float.parseFloat(matchPattern(strDivaGrd, "^MaxValue=(.+)$"));
			float minLatitude = Float.parseFloat(matchPattern(strDivaGrd, "^MinY=(.+)$"));
			float maxLatitude = Float.parseFloat(matchPattern(strDivaGrd, "^MaxY=(.+)$"));
			float minLongitude = Float.parseFloat(matchPattern(strDivaGrd, "^MinX=(.+)$"));
			float maxLongitude = Float.parseFloat(matchPattern(strDivaGrd, "^MaxX=(.+)$"));
			System.out.println("Generating ID for new layer...");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT MAX(id) from layers");
			rs.next();
			int id = 1;
			String idAsString = rs.getString(1);
			if (idAsString != null) {
				id = Integer.parseInt(idAsString);
				id += 1;
			}
			String displayPath = MessageFormat.format(GEOSERVER_QUERY_TEMPLATE, layerName);
			System.out.println("Creating layers table entry...");
			PreparedStatement createLayersStatement = createLayersInsert(conn, id, layerDescription,
					divaDir.getAbsolutePath(), layerName, displayPath, minLatitude, minLongitude, maxLatitude,
					maxLongitude, minValue, maxValue, units);
			createLayersStatement.execute();
			System.out.println("Creating fields table entry...");
			PreparedStatement createFieldsStatement = createFieldsInsert(conn, id, layerName, layerDescription);
			createFieldsStatement.execute();
			DefaultHttpClient httpClient = new DefaultHttpClient();
			httpClient.getCredentialsProvider().setCredentials(new AuthScope("localhost", 8082),
					new UsernamePasswordCredentials(geoserverUsername, geoserverPassword));
			System.out.println("Creating layer in geoserver...");
			HttpPut createLayerPut = new HttpPut(String.format(
					"http://localhost:8082/geoserver/rest/workspaces/ALA/coveragestores/%s/external.geotiff",
					layerName));
			createLayerPut.setHeader("Content-type", "text/plain");
			createLayerPut.setEntity(new StringEntity(geotiffFile.toURI().toURL().toString()));
			HttpResponse createLayerResponse = httpClient.execute(createLayerPut);
			if (createLayerResponse.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Error creating layer in geoserver: " + createLayerResponse.toString());
			}
			EntityUtils.consume(createLayerResponse.getEntity());
			System.out.println("Creating style in geoserver");
			HttpPost createStylePost = new HttpPost("http://localhost:8082/geoserver/rest/styles");
			createStylePost.setHeader("Content-type", "text/xml");
			createStylePost.setEntity(new StringEntity(String
					.format("<style><name>%s_style</name><filename>%s.sld</filename></style>", layerName, layerName)));
			HttpResponse createStyleResponse = httpClient.execute(createLayerPut);
			if (createStyleResponse.getStatusLine().getStatusCode() != 201) {
				throw new RuntimeException("Error creating style in geoserver: " + createStyleResponse.toString());
			}
			EntityUtils.consume(createStyleResponse.getEntity());
			System.out.println("Uploading sld file to geoserver");
			File sldFile = new File(legendDir, layerName + ".sld");
			String sldData = FileUtils.readFileToString(sldFile);
			HttpPut uploadSldPut = new HttpPut(
					String.format("http://localhost:8082/geoserver/rest/styles/%s_style", layerName));
			uploadSldPut.setHeader("Content-type", "application/vnd.ogc.sld+xml");
			uploadSldPut.setEntity(new StringEntity(sldData));
			HttpResponse uploadSldResponse = httpClient.execute(uploadSldPut);
			if (uploadSldResponse.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Error uploading sld file geoserver: " + uploadSldResponse.toString());
			}
			EntityUtils.consume(uploadSldResponse.getEntity());
			System.out.println("Setting default style in geoserver");
			HttpPut setDefaultStylePut = new HttpPut(
					String.format("http://localhost:8082/geoserver/rest/layers/ALA:%s", layerName));
			setDefaultStylePut.setHeader("Content-type", "text/xml");
			setDefaultStylePut.setEntity(new StringEntity(String.format(
					"<layer><enabled>true</enabled><defaultStyle><name>%s_style</name></defaultStyle></layer>",
					layerName)));
			HttpResponse setDefaultStyleResponse = httpClient.execute(createLayerPut);
			if (setDefaultStyleResponse.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Setting default style in geoserver: " + setDefaultStyleResponse.toString());
			}
			EntityUtils.consume(setDefaultStyleResponse.getEntity());
			conn.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			conn.rollback();
		}
	}

}