class n12595519 {
	@SuppressWarnings("unchecked")
	public static void main(String[] YVoT9LBy) {
		System.out.println("Starting encoding test....");
		Properties XrCSH1aN = new Properties();
		try {
			InputStream yb50ypOx = ClassLoader.getSystemResourceAsStream("sample_weather.properties");
			XrCSH1aN.load(yb50ypOx);
		} catch (Exception nRRsPnoO) {
			System.err.println("Could not load properties file.");
			System.err.println(nRRsPnoO.getMessage());
			nRRsPnoO.printStackTrace();
			return;
		}
		if (WeatherUpdater.DEBUG) {
			System.out.println("hostname: " + XrCSH1aN.getProperty("weather.hostname"));
		}
		if (WeatherUpdater.DEBUG) {
			System.out.println("database: " + XrCSH1aN.getProperty("weather.database"));
		}
		if (WeatherUpdater.DEBUG) {
			System.out.println("username: " + XrCSH1aN.getProperty("weather.username"));
		}
		if (WeatherUpdater.DEBUG) {
			System.out.println("password: " + XrCSH1aN.getProperty("weather.password"));
		}
		SqlAccount LObNk0hw = new SqlAccount(XrCSH1aN.getProperty("weather.hostname"),
				XrCSH1aN.getProperty("weather.database"), XrCSH1aN.getProperty("weather.username"),
				XrCSH1aN.getProperty("weather.password"));
		DatabaseInterface WgcEV8sH = null;
		try {
			WgcEV8sH = new DatabaseInterface(LObNk0hw);
		} catch (Exception TwnBd6PZ) {
			System.err.println(TwnBd6PZ.getMessage());
			TwnBd6PZ.printStackTrace();
			return;
		}
		System.out.println("Established connection to database.");
		String fYxclNV8 = "SELECT * FROM Current_Weather WHERE ZipCode = '99702'";
		ResultTable iUlskPRR;
		System.out.println("Executing query: " + fYxclNV8);
		try {
			iUlskPRR = WgcEV8sH.executeQuery(fYxclNV8);
		} catch (Exception eBMDtvlu) {
			System.err.println(eBMDtvlu.getMessage());
			eBMDtvlu.printStackTrace();
			return;
		}
		System.out.println("Got results from query.");
		System.out.println("Converted results into the following table:");
		System.out.println(iUlskPRR);
		System.out.println();
		Class<? extends ResultEncoder> BTRBHEzy;
		Class<? extends ResultDecoder> E8VuXQNX;
		try {
			BTRBHEzy = (Class<? extends ResultEncoder>) Class
					.forName(XrCSH1aN.getProperty("mysms.coding.resultEncoder"));
			E8VuXQNX = (Class<? extends ResultDecoder>) Class
					.forName(XrCSH1aN.getProperty("mysms.coding.resultDecoder"));
		} catch (Exception TuBK26Mi) {
			System.err.println("Could not find specified encoder: " + XrCSH1aN.getProperty("result.encoder"));
			System.err.println(TuBK26Mi.getMessage());
			TuBK26Mi.printStackTrace();
			return;
		}
		System.out.println("Found class of encoder: " + BTRBHEzy);
		System.out.println("Found class of decoder: " + E8VuXQNX);
		ResultEncoder shi7DdAb;
		ResultDecoder VePXpGbb;
		try {
			shi7DdAb = BTRBHEzy.newInstance();
			if (BTRBHEzy.equals(E8VuXQNX) && E8VuXQNX.isInstance(shi7DdAb)) {
				VePXpGbb = (ResultDecoder) shi7DdAb;
			} else {
				VePXpGbb = E8VuXQNX.newInstance();
			}
		} catch (Exception e30zAeo6) {
			System.err.println("Could not create instances of encoder and decoder.");
			System.err.println(e30zAeo6.getMessage());
			e30zAeo6.printStackTrace();
			return;
		}
		System.out.println("Created instances of encoder and decoder.");
		if (VePXpGbb.equals(shi7DdAb)) {
			System.out.println("Decoder and encoder are same object.");
		}
		ByteBuffer jZ12CpXj;
		try {
			jZ12CpXj = shi7DdAb.encode(null, iUlskPRR);
		} catch (Exception csDTpN8X) {
			System.err.println("Could not encode results.");
			System.err.println(csDTpN8X.getMessage());
			csDTpN8X.printStackTrace();
			return;
		}
		System.out.println("Encoded results to ByteBuffer with size: " + jZ12CpXj.capacity());
		File bd0AUhs8;
		try {
			bd0AUhs8 = File.createTempFile("encoding_test", ".results");
			bd0AUhs8.deleteOnExit();
			FileChannel PFFhD1q5 = new FileOutputStream(bd0AUhs8).getChannel();
			PFFhD1q5.write(jZ12CpXj);
			PFFhD1q5.close();
		} catch (Exception aZVDkZyI) {
			System.err.println("Could not write buffer to file.");
			System.err.println(aZVDkZyI.getMessage());
			aZVDkZyI.printStackTrace();
			return;
		}
		System.out.println("Wrote buffer to file: \"" + bd0AUhs8.getName() + "\" with length: " + bd0AUhs8.length());
		ByteBuffer mquVcjyW;
		try {
			FileInputStream eQwe45We = new FileInputStream(bd0AUhs8.getAbsolutePath());
			byte[] trzCWHVS = new byte[(int) bd0AUhs8.length()];
			int UlxX7j4x = 0;
			int ymOF315n = 0;
			while (UlxX7j4x < trzCWHVS.length) {
				ymOF315n = eQwe45We.read(trzCWHVS, UlxX7j4x, trzCWHVS.length - UlxX7j4x);
				if (ymOF315n < 0) {
					break;
				} else {
					UlxX7j4x += ymOF315n;
				}
			}
			mquVcjyW = ByteBuffer.wrap(trzCWHVS);
			eQwe45We.close();
		} catch (Exception kTetmG9B) {
			System.err.println("Could not read from temporary file into buffer.");
			System.err.println(kTetmG9B.getMessage());
			kTetmG9B.printStackTrace();
			return;
		}
		System.out.println("Read file back into buffer with length: " + mquVcjyW.capacity());
		ResultTable WTeq7Tsk;
		try {
			WTeq7Tsk = VePXpGbb.decode(null, mquVcjyW);
		} catch (Exception ftW3SnQq) {
			System.err.println("Could not decode buffer into a ResultTable.");
			System.err.println(ftW3SnQq.getMessage());
			ftW3SnQq.printStackTrace();
			return;
		}
		System.out.println("Decoded buffer back into the following table:");
		System.out.println(WTeq7Tsk);
		System.out.println();
		System.out.println("... encoding test complete.");
	}

}