class n13644040 {
	public static void main(String[] UrxnkBze) throws Exception {
		String Kmek1hGp = UrxnkBze[0];
		String P13ROHVG = UrxnkBze[1];
		String fvMQPRqU = UrxnkBze[2];
		String xVa7CAJO = UrxnkBze[3];
		String uhSf0qGt = UrxnkBze[4];
		String mFHIc1PH = UrxnkBze[5];
		String dZGSxzXj = UrxnkBze[6];
		String ucpCC3wJ = UrxnkBze[7];
		String yD3qwl6K = UrxnkBze[8];
		String T8BkDpRT = UrxnkBze[9];
		String DEi55wHt = UrxnkBze[10];
		String ydK6FRvc = UrxnkBze[11];
		String NlDBticK = UrxnkBze[12];
		File OTUzJxZh = new File(xVa7CAJO);
		if (!OTUzJxZh.exists() || !OTUzJxZh.isDirectory()) {
			throw new RuntimeException(
					"Supplied raw data directory " + xVa7CAJO + " does not exist or is not a directory");
		}
		File dnQ60AO9 = new File(uhSf0qGt);
		if (!dnQ60AO9.exists() || !dnQ60AO9.isDirectory()) {
			throw new RuntimeException(
					"Supplied process directory " + uhSf0qGt + " does not exist or is not a directory");
		}
		File y1nYnnCf = new File(mFHIc1PH);
		if (!y1nYnnCf.exists() || !y1nYnnCf.isDirectory()) {
			throw new RuntimeException("Supplied diva directory " + mFHIc1PH + " does not exist or is not a directory");
		}
		File jWzglFpm = new File(dZGSxzXj);
		if (!jWzglFpm.exists() || !jWzglFpm.isDirectory()) {
			throw new RuntimeException(
					"Supplied legend directory " + dZGSxzXj + " does not exist or is not a directory");
		}
		File FBighe6G = new File(ucpCC3wJ);
		if (!FBighe6G.exists() || !FBighe6G.isDirectory()) {
			throw new RuntimeException(
					"Supplied geotiff directory " + ucpCC3wJ + " does not exist or is not a directory");
		}
		System.out.println("Beginning environmetal load");
		System.out.println("Connecting to database");
		Class.forName("org.postgresql.Driver");
		Properties NQkXPkaq = new Properties();
		NQkXPkaq.setProperty("user", T8BkDpRT);
		NQkXPkaq.setProperty("password", DEi55wHt);
		Connection OV4skues = DriverManager.getConnection(yD3qwl6K, NQkXPkaq);
		OV4skues.setAutoCommit(false);
		try {
			File yPqwTrwG = new File(dnQ60AO9, Kmek1hGp);
			yPqwTrwG.mkdir();
			System.out.println("Running gdalwarp");
			File qeWViUag = new File(OTUzJxZh, "hdr.adf");
			if (!qeWViUag.exists()) {
				throw new RuntimeException("Could not find hdr.adf in " + xVa7CAJO);
			}
			File bABU9wqD = new File(yPqwTrwG, Kmek1hGp + ".bil");
			Process PgsOy79U = Runtime.getRuntime().exec(new String[] { "gdalwarp", "-of", "EHdr", "-ot", "Float32",
					qeWViUag.getAbsolutePath(), bABU9wqD.getAbsolutePath() });
			int a1Yh7mpf = PgsOy79U.waitFor();
			if (a1Yh7mpf != 0) {
				String oJiozrJL = IOUtils.toString(PgsOy79U.getErrorStream());
				throw new RuntimeException("gdalwarp failed: " + oJiozrJL);
			}
			System.out.println("Running Bil2diva");
			boolean LkxbaEEe = Bil2diva.bil2diva(yPqwTrwG.getAbsolutePath() + File.separator + Kmek1hGp,
					y1nYnnCf.getAbsolutePath() + File.separator + Kmek1hGp, fvMQPRqU);
			if (!LkxbaEEe) {
				throw new RuntimeException("Bil2diva Failed");
			}
			System.out.println("Running GridLegend");
			boolean hulhomMS = GridLegend.generateGridLegend(y1nYnnCf.getAbsolutePath() + File.separator + Kmek1hGp,
					jWzglFpm.getAbsolutePath() + File.separator + Kmek1hGp, 1, false);
			if (!hulhomMS) {
				throw new RuntimeException("GridLegend Failed");
			}
			System.out.println("Running gdal_translate");
			File cpqWDrY4 = new File(FBighe6G, Kmek1hGp + ".tif");
			Process IXNcjOfk = Runtime.getRuntime().exec(new String[] { "gdal_translate", "-of", "GTiff",
					bABU9wqD.getAbsolutePath(), cpqWDrY4.getAbsolutePath() });
			int KMZrzT8n = IXNcjOfk.waitFor();
			if (KMZrzT8n != 0) {
				String GflYGrbd = IOUtils.toString(IXNcjOfk.getErrorStream());
				throw new RuntimeException("gdal_translate failed: " + GflYGrbd);
			}
			System.out.println("Extracting extents and min/max environmental value from diva .grd file");
			File mFhiiKaf = new File(y1nYnnCf, Kmek1hGp + ".grd");
			if (!mFhiiKaf.exists()) {
				throw new RuntimeException("Could not locate diva .grd file: " + mFhiiKaf.toString());
			}
			String Uoc60C75 = FileUtils.readFileToString(mFhiiKaf);
			float CbZiZAbn = Float.parseFloat(matchPattern(Uoc60C75, "^MinValue=(.+)$"));
			float v7u8h9JR = Float.parseFloat(matchPattern(Uoc60C75, "^MaxValue=(.+)$"));
			float WC5FUw1l = Float.parseFloat(matchPattern(Uoc60C75, "^MinY=(.+)$"));
			float KFR8UYw0 = Float.parseFloat(matchPattern(Uoc60C75, "^MaxY=(.+)$"));
			float aLrHxh06 = Float.parseFloat(matchPattern(Uoc60C75, "^MinX=(.+)$"));
			float Q9bNgFhi = Float.parseFloat(matchPattern(Uoc60C75, "^MaxX=(.+)$"));
			System.out.println("Generating ID for new layer...");
			Statement ENA2qDPv = OV4skues.createStatement();
			ResultSet AAFf74PT = ENA2qDPv.executeQuery("SELECT MAX(id) from layers");
			AAFf74PT.next();
			int NRTCbUBW = 1;
			String YwMTIYXW = AAFf74PT.getString(1);
			if (YwMTIYXW != null) {
				NRTCbUBW = Integer.parseInt(YwMTIYXW);
				NRTCbUBW++;
			}
			String hT0012hL = MessageFormat.format(GEOSERVER_QUERY_TEMPLATE, Kmek1hGp);
			System.out.println("Creating layers table entry...");
			PreparedStatement yN9aLRp7 = createLayersInsert(OV4skues, NRTCbUBW, P13ROHVG, y1nYnnCf.getAbsolutePath(),
					Kmek1hGp, hT0012hL, WC5FUw1l, aLrHxh06, KFR8UYw0, Q9bNgFhi, CbZiZAbn, v7u8h9JR, fvMQPRqU);
			yN9aLRp7.execute();
			System.out.println("Creating fields table entry...");
			PreparedStatement D4xuae3v = createFieldsInsert(OV4skues, NRTCbUBW, Kmek1hGp, P13ROHVG);
			D4xuae3v.execute();
			DefaultHttpClient nAGmrRp1 = new DefaultHttpClient();
			nAGmrRp1.getCredentialsProvider().setCredentials(new AuthScope("localhost", 8082),
					new UsernamePasswordCredentials(ydK6FRvc, NlDBticK));
			System.out.println("Creating layer in geoserver...");
			HttpPut oOFCm5pf = new HttpPut(String.format(
					"http://localhost:8082/geoserver/rest/workspaces/ALA/coveragestores/%s/external.geotiff",
					Kmek1hGp));
			oOFCm5pf.setHeader("Content-type", "text/plain");
			oOFCm5pf.setEntity(new StringEntity(cpqWDrY4.toURI().toURL().toString()));
			HttpResponse ifEyUDJx = nAGmrRp1.execute(oOFCm5pf);
			if (ifEyUDJx.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Error creating layer in geoserver: " + ifEyUDJx.toString());
			}
			EntityUtils.consume(ifEyUDJx.getEntity());
			System.out.println("Creating style in geoserver");
			HttpPost ygkRDhzy = new HttpPost("http://localhost:8082/geoserver/rest/styles");
			ygkRDhzy.setHeader("Content-type", "text/xml");
			ygkRDhzy.setEntity(new StringEntity(String
					.format("<style><name>%s_style</name><filename>%s.sld</filename></style>", Kmek1hGp, Kmek1hGp)));
			HttpResponse RmlyzVZp = nAGmrRp1.execute(oOFCm5pf);
			if (RmlyzVZp.getStatusLine().getStatusCode() != 201) {
				throw new RuntimeException("Error creating style in geoserver: " + RmlyzVZp.toString());
			}
			EntityUtils.consume(RmlyzVZp.getEntity());
			System.out.println("Uploading sld file to geoserver");
			File CxH3EvJf = new File(jWzglFpm, Kmek1hGp + ".sld");
			String wgtjbcmM = FileUtils.readFileToString(CxH3EvJf);
			HttpPut S8icjo9C = new HttpPut(
					String.format("http://localhost:8082/geoserver/rest/styles/%s_style", Kmek1hGp));
			S8icjo9C.setHeader("Content-type", "application/vnd.ogc.sld+xml");
			S8icjo9C.setEntity(new StringEntity(wgtjbcmM));
			HttpResponse DwXH1Ssk = nAGmrRp1.execute(S8icjo9C);
			if (DwXH1Ssk.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Error uploading sld file geoserver: " + DwXH1Ssk.toString());
			}
			EntityUtils.consume(DwXH1Ssk.getEntity());
			System.out.println("Setting default style in geoserver");
			HttpPut G0WQLKQw = new HttpPut(
					String.format("http://localhost:8082/geoserver/rest/layers/ALA:%s", Kmek1hGp));
			G0WQLKQw.setHeader("Content-type", "text/xml");
			G0WQLKQw.setEntity(new StringEntity(String.format(
					"<layer><enabled>true</enabled><defaultStyle><name>%s_style</name></defaultStyle></layer>",
					Kmek1hGp)));
			HttpResponse CB2QhGMq = nAGmrRp1.execute(oOFCm5pf);
			if (CB2QhGMq.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Setting default style in geoserver: " + CB2QhGMq.toString());
			}
			EntityUtils.consume(CB2QhGMq.getEntity());
			OV4skues.commit();
		} catch (Exception KHR1UlLF) {
			KHR1UlLF.printStackTrace();
			OV4skues.rollback();
		}
	}

}