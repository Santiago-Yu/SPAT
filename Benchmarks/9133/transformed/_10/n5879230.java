class n5879230 {
	public void loadFromInternet(boolean reload) {
		if (!reload && this.internetScoreGroupModel != null) {
			return;
		}
		loadingFlag = true;
		ProgressBar settingProgressBar = (ProgressBar) this.activity.findViewById(R.id.settingProgressBar);
		settingProgressBar.setVisibility(View.VISIBLE);
		final Timer timer = new Timer();
		final Handler handler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				if (loadingFlag == false) {
					ProgressBar settingProgressBar = (ProgressBar) BestScoreExpandableListAdapter.this.activity
							.findViewById(R.id.settingProgressBar);
					settingProgressBar.setVisibility(View.INVISIBLE);
					timer.cancel();
				}
				super.handleMessage(msg);
			}
		};
		final TimerTask task = new TimerTask() {

			@Override
			public void run() {
				Message message = new Message();
				handler.sendMessage(message);
			}
		};
		timer.schedule(task, 1, 50);
		String httpUrl = Constants.SERVER_URL + "/rollingcard.php?op=viewbestscore";
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet request = new HttpGet(httpUrl);
		try {
			HttpResponse response = httpClient.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String entity = EntityUtils.toString(response.getEntity());
				this.internetScoreGroupModel = new ScoreGroupModel();
				String[] itemArray = entity.split(";");
				for (int i = 0; i < itemArray.length; i++) {
					String[] itemValueArray = itemArray[i].split("\\|");
					if (itemValueArray.length != 3) {
						continue;
					}
					ScoreItemModel itemModel = new ScoreItemModel(itemValueArray[0], itemValueArray[1],
							itemValueArray[2]);
					this.internetScoreGroupModel.addItem(itemModel);
				}
			}
		} catch (ClientProtocolException e) {
			this.internetScoreGroupModel = null;
			e.printStackTrace();
		} catch (IOException e) {
			this.internetScoreGroupModel = null;
			e.printStackTrace();
		}
		loadingFlag = false;
	}

}