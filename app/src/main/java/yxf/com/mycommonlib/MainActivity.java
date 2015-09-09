package yxf.com.mycommonlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import yxf.com.mycommonlib.NetWork.Config;
import yxf.com.mycommonlib.NetWork.volley.AppRequestQueue;
import yxf.com.mycommonlib.NetWork.volley.OnResponseListener;
import yxf.com.mycommonlib.NetWork.volley.RequestJson;
import yxf.com.mycommonlib.debug.AppDebug;
import yxf.com.mycommonlib.entity.json.JsonTest;

public class MainActivity extends AppCompatActivity implements Response.ErrorListener, OnResponseListener<JsonTest> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		RequestJson<JsonTest> requestJson = new RequestJson<JsonTest>(Config.URL.TEST_JSON, JsonTest.class, this,
				this);
		AppRequestQueue.add(requestJson);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onErrorResponse(VolleyError volleyError) {

	}

	@Override
	public void onResponse(JsonTest response) {
		AppDebug.LOG_D(this, response);
	}
}
