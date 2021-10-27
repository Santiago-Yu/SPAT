class n4404642 {
	@Override
	public void onCreate(Bundle OZ9h0Ijj) {
		super.onCreate(OZ9h0Ijj);
		setContentView(R.layout.listview);
		HttpGet IoLlGql6 = new HttpGet(SERVICE_URI + "/json/getproducts");
		IoLlGql6.setHeader("Accept", "application/json");
		IoLlGql6.setHeader("Content-type", "application/json");
		DefaultHttpClient oHVssHc9 = new DefaultHttpClient();
		String xvq86nwf = new String("");
		HttpGet f9CkZqvo = new HttpGet(SERVICE_URI + "/json/getroutes/3165");
		IoLlGql6.setHeader("Accept", "application/json");
		IoLlGql6.setHeader("Content-type", "application/json");
		DefaultHttpClient TZwPtqny = new DefaultHttpClient();
		try {
			HttpResponse w1WeOq4Y = oHVssHc9.execute(IoLlGql6);
			HttpEntity T5UTAcnR = w1WeOq4Y.getEntity();
			InputStream TwgAuGUx = T5UTAcnR.getContent();
			BufferedReader J99xdABE = new BufferedReader(new InputStreamReader(TwgAuGUx));
			Vector<String> rWYPCR02 = new Vector<String>();
			String ORVfXSzL = new String();
			String mmbvEhX6 = new String();
			String qbnuRax2 = new String();
			String oDbTeeYg = new String();
			String rvQgbR3R = new String();
			StringBuilder gFtuBiVh = new StringBuilder();
			String tYXrEOkY;
			while ((tYXrEOkY = J99xdABE.readLine()) != null) {
				gFtuBiVh.append(tYXrEOkY);
			}
			TwgAuGUx.close();
			xvq86nwf = gFtuBiVh.toString();
			JSONObject c5lO6YMH = new JSONObject(xvq86nwf);
			Log.i("_GetPerson_", "<jsonobject>\n" + c5lO6YMH.toString() + "\n</jsonobject>");
			this.dm = new DataManipulator(this);
			JSONArray qcd2iQyc;
			qcd2iQyc = c5lO6YMH.getJSONArray("getProductsResult");
			for (int xkIsfSPc = 0; xkIsfSPc < qcd2iQyc.length(); xkIsfSPc++) {
				mmbvEhX6 = qcd2iQyc.getJSONObject(xkIsfSPc).getString("ID");
				qbnuRax2 = qcd2iQyc.getJSONObject(xkIsfSPc).getString("Name");
				oDbTeeYg = qcd2iQyc.getJSONObject(xkIsfSPc).getString("Price");
				rvQgbR3R = qcd2iQyc.getJSONObject(xkIsfSPc).getString("Symbol");
				this.dm.insertIntoProducts(mmbvEhX6, qbnuRax2, oDbTeeYg, rvQgbR3R);
				ORVfXSzL = qcd2iQyc.getJSONObject(xkIsfSPc).getString("Name") + "\n"
						+ qcd2iQyc.getJSONObject(xkIsfSPc).getString("Price") + "\n"
						+ qcd2iQyc.getJSONObject(xkIsfSPc).getString("Symbol");
				rWYPCR02.add(new String(ORVfXSzL));
			}
			int Zz04xo5e = rWYPCR02.size();
			String[] HUjTBbwU = new String[Zz04xo5e];
			rWYPCR02.copyInto(HUjTBbwU);
		} catch (Exception vhC9pxDI) {
			vhC9pxDI.printStackTrace();
		}
		try {
			HttpResponse K75G2lnc = TZwPtqny.execute(f9CkZqvo);
			HttpEntity KIU4EdYH = K75G2lnc.getEntity();
			InputStream wjQwQewQ = KIU4EdYH.getContent();
			BufferedReader cKEV9Kcv = new BufferedReader(new InputStreamReader(wjQwQewQ));
			Vector<String> EySRoU6J = new Vector<String>();
			String wvuXNCZK = new String();
			String h6utJx5Q = new String();
			String KkWaWOpb = new String();
			String cxnAwJ2K = new String();
			String U65sdpXc = new String();
			StringBuilder YmX0qEbX = new StringBuilder();
			String mwKBKWMP;
			while ((mwKBKWMP = cKEV9Kcv.readLine()) != null) {
				YmX0qEbX.append(mwKBKWMP);
			}
			wjQwQewQ.close();
			xvq86nwf = YmX0qEbX.toString();
			JSONObject qLbvM5lw = new JSONObject(xvq86nwf);
			Log.i("_GetPerson_", "<jsonobject>\n" + qLbvM5lw.toString() + "\n</jsonobject>");
			this.dm = new DataManipulator(this);
			JSONArray Bj5HulEv;
			Bj5HulEv = qLbvM5lw.getJSONArray("GetRoutesByAgentResult");
			for (int SndzTg9R = 0; SndzTg9R < Bj5HulEv.length(); SndzTg9R++) {
				h6utJx5Q = Bj5HulEv.getJSONObject(SndzTg9R).getString("Agent");
				KkWaWOpb = Bj5HulEv.getJSONObject(SndzTg9R).getString("Client");
				cxnAwJ2K = Bj5HulEv.getJSONObject(SndzTg9R).getString("Route");
				U65sdpXc = Bj5HulEv.getJSONObject(SndzTg9R).getString("Zone");
				this.dm.insertIntoClients(h6utJx5Q, KkWaWOpb, cxnAwJ2K, U65sdpXc);
				wvuXNCZK = Bj5HulEv.getJSONObject(SndzTg9R).getString("Client") + "\n"
						+ Bj5HulEv.getJSONObject(SndzTg9R).getString("Route") + "\n"
						+ Bj5HulEv.getJSONObject(SndzTg9R).getString("Zone");
				EySRoU6J.add(new String(wvuXNCZK));
			}
			int TmXRw7cN = EySRoU6J.size();
			String[] QkXknygX = new String[TmXRw7cN];
			EySRoU6J.copyInto(QkXknygX);
		} catch (Exception Sr519Xwd) {
			Sr519Xwd.printStackTrace();
		}
	}

}