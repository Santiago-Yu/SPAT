class n1768644 {
	@Override
	public void onCreate(Bundle dtp1OEgj) {
		super.onCreate(dtp1OEgj);
		setContentView(R.layout.main);
		try {
			StringBuilder OaSZGvCP = new StringBuilder();
			URL ASkRpJq1 = new URL("https://ajax.googleapis.com/ajax/services/search/news?v=1.0&q=google");
			URLConnection HAvg1pbS = ASkRpJq1.openConnection();
			String y1AZ7MWp;
			BufferedReader dOqfK8Wd = new BufferedReader(new InputStreamReader(HAvg1pbS.getInputStream()));
			while ((y1AZ7MWp = dOqfK8Wd.readLine()) != null)
				OaSZGvCP.append(y1AZ7MWp);
			JSONObject lHyWj4t5 = new JSONObject(OaSZGvCP.toString());
			OaSZGvCP.setLength(0);
			JSONObject Wj0vn8Nz = (JSONObject) lHyWj4t5.get("responseData");
			JSONArray Y9DBP1uV = (JSONArray) Wj0vn8Nz.get("results");
			for (int f1W8vAKH = 0; f1W8vAKH < Y9DBP1uV.length(); f1W8vAKH++) {
				JSONObject Mcnt2Wd9 = (JSONObject) Y9DBP1uV.get(f1W8vAKH);
				OaSZGvCP.append(Mcnt2Wd9.get("title")).append("\n\n");
			}
			TextView QHsyUQWT = (TextView) findViewById(R.id.textView);
			QHsyUQWT.setText(OaSZGvCP.toString());
		} catch (Exception QCsMk6ge) {
		}
	}

}