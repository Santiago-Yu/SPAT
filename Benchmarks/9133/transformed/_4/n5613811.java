class n5613811 {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		list = (ListView) findViewById(R.id.list);
		db = new DBAdapter(this);
		news = new ArrayList<Data>();
		adapter = new NewsAdapter(news);
		list.setAdapter(adapter);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		DefaultHandler handler = null;
		try {
			parser = factory.newSAXParser();
			handler = new DefaultHandler() {

				Data newsItem;

				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {
					Log.d(TAG, qName);
					newsItem = (qName.equals("item")) ? new Data() : newsItem;
					title = (qName.equals("title")) ? true : title;
					link = (qName.equals("link")) ? true : link;
					description = (qName.equals("description")) ? true : description;
				}

				@Override
				public void endElement(String uri, String localName, String qName) throws SAXException {
					if (qName.equals("item"))
						news.add(newsItem);
					title = (qName.equals("title")) ? false : title;
					link = (qName.equals("link")) ? false : link;
					description = (qName.equals("description")) ? false : description;
				}

				@Override
				public void characters(char ch[], int start, int length) throws SAXException {
					if (newsItem == null) {
						return;
					}
					if (title) {
						newsItem.setTitle(new String(ch, start, length));
					}
					if (link) {
						newsItem.setLink(new String(ch, start, length));
					}
					if (description) {
						newsItem.setDesc(new String(ch, start, length));
					}
				}
			};
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e1) {
			e1.printStackTrace();
		}
		Intent siteIntent = getIntent();
		String siteurl = siteIntent.getStringExtra("siteurl");
		URLConnection connection = null;
		URL url;
		try {
			url = new URL(siteurl);
			Log.i(TAG, "1");
			connection = url.openConnection();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Log.i(TAG, "2");
		try {
			parser.parse(connection.getInputStream(), handler);
			Log.i(TAG, "3");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		adapter.notifyDataSetChanged();
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapt, View view, int position, long id) {
				String link;
				link = news.get(position).getLink();
				Intent intent = new Intent(NewsReaderActivity.this, WebViewActivity.class);
				intent.putExtra("link", link);
				startActivity(intent);
			}
		});
	}

}