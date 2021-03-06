package news.agoda.com.sample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.request.ImageRequest;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import news.agoda.com.sample.Constants.Constants;
import news.agoda.com.sample.Model.Result;

/**
 * News detail view
 */
public class DetailViewActivity extends Activity {
    @BindView(R.id.title)
    TextView titleView;
    @BindView(R.id.summary_content)
    TextView summaryView;
    @BindView(R.id.news_image)
    DraweeView imageView;
    private String mStoryURL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Result result = Parcels.unwrap(getIntent().getParcelableExtra(Constants.EXTRA_DETAILS));//Todo: make this a field variable
        String title = result.getTitle();
        String imageURL = result.getMultimedia().get(0).getUrl();
        mStoryURL = result.getUrl();
        String summary = result.getAbstract();

        titleView.setText(title);
        summaryView.setText(summary);


        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(ImageRequest.fromUri(Uri.parse(imageURL)))
                .setOldController(imageView.getController()).build();
        imageView.setController(draweeController);
    }

    public void onFullStoryClicked(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(mStoryURL));
        startActivity(intent);
    }


    @OnClick(R.id.full_story_link)
    public void onFullStoryBtnClicked(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mStoryURL));
        startActivity(browserIntent);
    }
}

