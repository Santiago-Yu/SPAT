class n13862028 {
	public static void main(String[] NYEnTRly) {
		try {
			String BymCHwdT = null;
			String JswbUt3G = null;
			if (NYEnTRly.length == 2) {
				BymCHwdT = NYEnTRly[0];
				JswbUt3G = NYEnTRly[1];
			} else {
				System.out
						.println("Please provide complete path to training_set parent folder as an argument. EXITING");
				System.exit(0);
			}
			File pflK9YKF = new File(BymCHwdT + fSep + "SmartGRAPE" + fSep + MovieIndexFileName);
			FileChannel uB5j3EfA = new FileInputStream(pflK9YKF).getChannel();
			int Ps1dxFlX = (int) uB5j3EfA.size();
			ByteBuffer xU3gepRY = uB5j3EfA.map(FileChannel.MapMode.READ_ONLY, 0, Ps1dxFlX);
			MovieLimitsTHash = new TShortObjectHashMap(17770, 1);
			int iaACoi9T = 0, XuyJfEOk = 0;
			short dYBbg17H;
			int zwFWnNxr, uJOa4Syb;
			TIntArrayList ujXbuLS7;
			while (xU3gepRY.hasRemaining()) {
				dYBbg17H = xU3gepRY.getShort();
				zwFWnNxr = xU3gepRY.getInt();
				uJOa4Syb = xU3gepRY.getInt();
				ujXbuLS7 = new TIntArrayList(2);
				ujXbuLS7.add(zwFWnNxr);
				ujXbuLS7.add(uJOa4Syb);
				MovieLimitsTHash.put(dYBbg17H, ujXbuLS7);
			}
			uB5j3EfA.close();
			xU3gepRY = null;
			System.out.println("Loaded movie index hash");
			pflK9YKF = new File(BymCHwdT + fSep + "SmartGRAPE" + fSep + CustIndexFileName);
			uB5j3EfA = new FileInputStream(pflK9YKF).getChannel();
			Ps1dxFlX = (int) uB5j3EfA.size();
			xU3gepRY = uB5j3EfA.map(FileChannel.MapMode.READ_ONLY, 0, Ps1dxFlX);
			CustomerLimitsTHash = new TIntObjectHashMap(480189, 1);
			int OOo8YsZM;
			while (xU3gepRY.hasRemaining()) {
				OOo8YsZM = xU3gepRY.getInt();
				zwFWnNxr = xU3gepRY.getInt();
				uJOa4Syb = xU3gepRY.getInt();
				ujXbuLS7 = new TIntArrayList(2);
				ujXbuLS7.add(zwFWnNxr);
				ujXbuLS7.add(uJOa4Syb);
				CustomerLimitsTHash.put(OOo8YsZM, ujXbuLS7);
			}
			uB5j3EfA.close();
			xU3gepRY = null;
			System.out.println("Loaded customer index hash");
			MoviesAndRatingsPerCustomer = InitializeMovieRatingsForCustomerHashMap(BymCHwdT, CustomerLimitsTHash);
			System.out.println("Populated MoviesAndRatingsPerCustomer hashmap");
			File fF4Fsc0E = new File(BymCHwdT + fSep + "SmartGRAPE" + fSep + JswbUt3G);
			FileChannel yBqDiPir = new FileOutputStream(fF4Fsc0E, true).getChannel();
			pflK9YKF = new File(BymCHwdT + fSep + "SmartGRAPE" + fSep + "formattedProbeData.txt");
			uB5j3EfA = new FileInputStream(pflK9YKF).getChannel();
			Ps1dxFlX = (int) uB5j3EfA.size();
			ByteBuffer rlD1yBfF = uB5j3EfA.map(FileChannel.MapMode.READ_ONLY, 0, Ps1dxFlX);
			int TIbtRtcF = 0;
			TIntByteHashMap RfXycvcw = new TIntByteHashMap();
			int KCe5gJyB = 0;
			int sfSNWUw6 = 0;
			while (rlD1yBfF.hasRemaining()) {
				short kW4Exajc = rlD1yBfF.getShort();
				int tNqXlpE5 = rlD1yBfF.getInt();
				if ((CustomersAndRatingsPerMovie != null) && (CustomersAndRatingsPerMovie.containsKey(kW4Exajc))) {
				} else {
					CustomersAndRatingsPerMovie = InitializeCustomerRatingsForMovieHashMap(BymCHwdT, kW4Exajc);
					RfXycvcw = (TIntByteHashMap) CustomersAndRatingsPerMovie.get(kW4Exajc);
					TIbtRtcF = RfXycvcw.size();
				}
				TShortByteHashMap I3jL8JUI = (TShortByteHashMap) MoviesAndRatingsPerCustomer.get(tNqXlpE5);
				short[] yfGT0ozB = I3jL8JUI.keys();
				float nkiHqllW = 0;
				nkiHqllW = predictRating(tNqXlpE5, kW4Exajc, RfXycvcw, TIbtRtcF, yfGT0ozB, I3jL8JUI);
				System.out
						.println("prediction for movie: " + kW4Exajc + " for customer " + tNqXlpE5 + " is " + nkiHqllW);
				ByteBuffer MjH7J5MU = ByteBuffer.allocate(11);
				MjH7J5MU.putShort(kW4Exajc);
				MjH7J5MU.putInt(tNqXlpE5);
				MjH7J5MU.putFloat(nkiHqllW);
				MjH7J5MU.flip();
				yBqDiPir.write(MjH7J5MU);
				MjH7J5MU = null;
				I3jL8JUI = null;
				yfGT0ozB = null;
			}
		} catch (Exception OIZDBY86) {
			OIZDBY86.printStackTrace();
		}
	}

}