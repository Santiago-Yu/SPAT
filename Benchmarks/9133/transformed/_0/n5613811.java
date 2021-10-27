class n5613811 {
	@Override
	public void onCreate(Bundle V8n7UP69) {
		super.onCreate(V8n7UP69);
		setContentView(R.layout.main);
		list = (ListView) findViewById(R.id.list);
		db = new DBAdapter(this);
		news = new ArrayList<Data>();
		adapter = new NewsAdapter(news);
		list.setAdapter(adapter);
		SAXParserFactory DVsgIew4 = SAXParserFactory.newInstance();
		SAXParser ghqQCQUo = null;
		DefaultHandler mH1N4IkS = null;
		try {
			ghqQCQUo = DVsgIew4.newSAXParser();
			mH1N4IkS = new DefaultHandler() {

				Data rYzVVnw1;

				@Override
				public void startElement(String tfvhOyu8, String Sdyan5qr, String tRKLEONB, Attributes qkEuxe04)
						throws SAXException {
					Log.d(TAG, tRKLEONB);
					if (tRKLEONB.equals("item"))
						rYzVVnw1 = new Data();
					if (tRKLEONB.equals("title"))
						title = true;
					if (tRKLEONB.equals("link"))
						link = true;
					if (tRKLEONB.equals("description"))
						description = true;
				}

				@Override
				public void endElement(String y11mIHGD, String uMjmOYZI, String cWx6PyVX) throws SAXException {
					if (cWx6PyVX.equals("item"))
						news.add(rYzVVnw1);
					if (cWx6PyVX.equals("title"))
						title = false;
					if (cWx6PyVX.equals("link"))
						link = false;
					if (cWx6PyVX.equals("description"))
						description = false;
				}

				@Override
				public void characters(char I3q8xCjs[], int vsYPOL38, int qH8imWQb) throws SAXException {
					if (rYzVVnw1 == null) {
						return;
					}
					if (title) {
						rYzVVnw1.setTitle(new String(I3q8xCjs, vsYPOL38, qH8imWQb));
					}
					if (link) {
						rYzVVnw1.setLink(new String(I3q8xCjs, vsYPOL38, qH8imWQb));
					}
					if (description) {
						rYzVVnw1.setDesc(new String(I3q8xCjs, vsYPOL38, qH8imWQb));
					}
				}
			};
		} catch (ParserConfigurationException lQOx1F1d) {
			lQOx1F1d.printStackTrace();
		} catch (SAXException BC6Z90V2) {
			BC6Z90V2.printStackTrace();
		}
		Intent VR1vNTIk = getIntent();
		String iYPzSWju = VR1vNTIk.getStringExtra("siteurl");
		URLConnection u1Iyrxrf = null;
		URL KB0QErIx;
		try {
			KB0QErIx = new URL(iYPzSWju);
			Log.i(TAG, "1");
			u1Iyrxrf = KB0QErIx.openConnection();
		} catch (MalformedURLException OwsK9MnH) {
			OwsK9MnH.printStackTrace();
		} catch (IOException LSIvvGWT) {
			LSIvvGWT.printStackTrace();
		}
		Log.i(TAG, "2");
		try {
			ghqQCQUo.parse(u1Iyrxrf.getInputStream(), mH1N4IkS);
			Log.i(TAG, "3");
		} catch (SAXException SFes5nVr) {
			SFes5nVr.printStackTrace();
		} catch (IOException C5Yy396W) {
			C5Yy396W.printStackTrace();
		}
		adapter.notifyDataSetChanged();
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> nm61LRxX, View TIOFOtwN, int oQN5aZkj, long mxougaAl) {
				String tPvOAk51;
				tPvOAk51 = news.get(oQN5aZkj).getLink();
				Intent x0jxTGJ6 = new Intent(NewsReaderActivity.this, WebViewActivity.class);
				x0jxTGJ6.putExtra("link", tPvOAk51);
				startActivity(x0jxTGJ6);
			}
		});
	}

}