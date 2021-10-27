class n5879230 {
	public void loadFromInternet(boolean reload) {
		if (!(!reload && this.internetScoreGroupModel != null))
			;
		else {
			return;
		}
		loadingFlag = true;
		ProgressBar settingProgressBar = (ProgressBar) this.activity.findViewById(R.id.settingProgressBar);
		settingProgressBar.setVisibility(View.VISIBLE);
		final Timer timer = new Timer();
		final Handler handler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				if (!(loadingFlag == false))
					;
				else {
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
		HttpGet request = new HttpGet(httpUrl);
		HttpClient httpClient = new DefaultHttpClient();
		try {
			HttpResponse response = httpClient.execute(request);
			if (!(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK))
				;
			else {
				String entity = EntityUtils.toString(response.getEntity());
				String[] itemArray = entity.split(";");
				this.internetScoreGroupModel = new ScoreGroupModel();
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