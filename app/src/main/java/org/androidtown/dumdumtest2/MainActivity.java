package org.androidtown.dumdumtest2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.SwipeDirection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private CardStackView cardStackView;
    private TouristSpotCardAdapter adapter;
    private CardView cardView;

    /*
    private TextView category;
    private TextView title;
    private TextView contents;
    private TextView gukhwa;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        setup();
        reload();
    }

    private TouristSpot createTouristSpot() {
        return new TouristSpot("흑역사", "눈물이 너무 많은 나 어떻게 고칠 수 있을까", "중3인데 어렸을때부터 진짜 어른들이 조금만 나한테 뭐라고 해도 바로 눈물 폭포 개방되서 막 흘러넘치거든.... 근데 난 진짜 안울고싶은데 계속 눈물이나와 마음이 너무 약한건가?? 나한테 뭐라고 하는 어른들 앞에서 잘 받아치고 자존감 있게 대응하고싶은데 난 눈물부터 나오니까 뭐가 억울해서 우는거냐 이런 말이나 듣고 진짜 너무 속상하다 나 어떻게 해야 이거 고칠 수 있지?\n" +
                "\n" +
                "더 짜증나고 거슬리는 건 학원에서 언제 한 번 선생님이 뭐라고 해서 울면 다음에 학원갔을 때 나 쟤 2분안에 울릴 수 있다이러고 친구들은 내가 울었던 그 상황 똑같이 재연하고...... 다음부턴 강경하게 대응해야겠어", "15송이");
    }


    private List<TouristSpot> createTouristSpots() {
        List<TouristSpot> spots = new ArrayList<>();
        spots.add(new TouristSpot("흑역사 묘지", "눈물이 너무 많은 나", "중3인데 어렸을때부터 진짜 어른들이 조금만 나한테 뭐라고 해도 바로 눈물 폭포 개방되서 막 흘러넘치거든.... 근데 난 진짜 안울고싶은데 계속 눈물이나와 마음이 너무 약한건가?", "15송이"));
        spots.add(new TouristSpot("연애 묘지", "헤어진 다음에야 알았다.", "우린 만났을 때 서로에게 너무나도 상처를 주었다. 특히 넌 나에게 상처를 너무 많이 주었지.\n" +
                "\n" +
                "너에게 많은 상처를 받아 우린 결국 헤어질 사이라고 항상 생각해왔지만 막상 헤어지고 나니\n" +
                "\n" +
                "너무 힘들고 내가 너를 정말 사랑했구나라고 생각했었다. 그래서 너무나도 잡고 싶었다. 너는\n" +
                "\n" +
                "나에게 상처를 준 만큼 행복한 기억을 준 아이였으니까.\n" +
                "\n" +
                "너가 나에게 상처를 줬음에도 왜 난 이렇게 힘들어할까 고민하고 또 고민하였다. 그리고 마침내\n" +
                "\n" +
                "답을 찾았다. 난 너가 그리운게 아니라 내가 행복했던 추억들이 그리웠다는걸..", "3송이"));
        spots.add(new TouristSpot("흑역사 묘지", "눈물이 너무 많은 나", "중3인데 어렸을때부터 진짜 어른들이 조금만 나한테 뭐라고 해도 바로 눈물 폭포 개방되서 막 흘러넘치거든.... 근데 난 진짜 안울고싶은데 계속 눈물이나와 마음이 너무 약한건가?", "15송이"));
        spots.add(new TouristSpot("흑역사 묘지", "눈물이 너무 많은 나", "중3인데 어렸을때부터 진짜 어른들이 조금만 나한테 뭐라고 해도 바로 눈물 폭포 개방되서 막 흘러넘치거든.... 근데 난 진짜 안울고싶은데 계속 눈물이나와 마음이 너무 약한건가?", "15송이"));
        spots.add(new TouristSpot("흑역사 묘지", "눈물이 너무 많은 나", "중3인데 어렸을때부터 진짜 어른들이 조금만 나한테 뭐라고 해도 바로 눈물 폭포 개방되서 막 흘러넘치거든.... 근데 난 진짜 안울고싶은데 계속 눈물이나와 마음이 너무 약한건가?", "15송이"));
        spots.add(new TouristSpot("흑역사 묘지", "눈물이 너무 많은 나", "중3인데 어렸을때부터 진짜 어른들이 조금만 나한테 뭐라고 해도 바로 눈물 폭포 개방되서 막 흘러넘치거든.... 근데 난 진짜 안울고싶은데 계속 눈물이나와 마음이 너무 약한건가?", "15송이"));
        return spots;
    }


    private TouristSpotCardAdapter createTouristSpotCardAdapter() {
        final TouristSpotCardAdapter adapter = new TouristSpotCardAdapter(getApplicationContext());
        adapter.addAll(createTouristSpots());
        return adapter;
    }

    private void setup() {
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progress_bar);
        cardStackView = (CardStackView) findViewById(R.id.activity_main_card_stack_view);
        cardView = (CardView) findViewById( R.id.cardView );
        cardStackView.setCardEventListener(new CardStackView.CardEventListener() {

            @Override
            public void onCardDragging(float percentX, float percentY) {
                Log.d( "CardStackView", "onCardDragging" );
                //Toast.makeText( MainActivity.this, "드래깅", Toast.LENGTH_SHORT ).show();
                //cardView.setCardBackgroundColor( Color.TRANSPARENT );
            }

            @Override
            public void onCardSwiped(SwipeDirection direction) {
                Log.d("CardStackView", "onCardSwiped: " + direction.toString());
                Log.d("CardStackView", "topIndex: " + cardStackView.getTopIndex());
                if (cardStackView.getTopIndex() == adapter.getCount() - 5) {
                    Log.d("CardStackView", "Paginate: " + cardStackView.getTopIndex());
                    paginate();
                }

            }

            @Override
            public void onCardReversed() {
                Log.d("CardStackView", "onCardReversed");
            }

            @Override
            public void onCardMovedToOrigin() {
                Log.d("CardStackView", "onCardMovedToOrigin");
            }

            @Override
            public void onCardClicked(int index) {
                Log.d("CardStackView", "onCardClicked: " + index);
                Intent intent = new Intent( MainActivity.this, Mypage.class);
                startActivity( intent );
                Toast.makeText( MainActivity.this, "클릭", Toast.LENGTH_SHORT ).show();
            }
        });
    }

    private void reload() {
        cardStackView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                adapter = createTouristSpotCardAdapter();
                cardStackView.setAdapter(adapter);
                cardStackView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        }, 1000);
    }

    private LinkedList<TouristSpot> extractRemainingTouristSpots() {
        LinkedList<TouristSpot> spots = new LinkedList<>();
        for (int i = cardStackView.getTopIndex(); i < adapter.getCount(); i++) {
            spots.add(adapter.getItem(i));
        }
        return spots;
    }

    private void paginate() {
        cardStackView.setPaginationReserved();
        adapter.addAll(createTouristSpots());
        adapter.notifyDataSetChanged();
    }

    private void reverse() {
        cardStackView.reverse();
    }


    /*
    public void blur()
    {
        category = (TextView) findViewById( R.id.category );
        title = (TextView) findViewById( R.id.title );
        contents = (TextView) findViewById( R.id.contents );
        gukhwa = (TextView) findViewById( R.id.gukhwa );


        Paint paint = new Paint(  );
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter( 10, BlurMaskFilter.Blur.NORMAL);

        contents.getPaint().setMaskFilter( null );
        contents.getPaint().setMaskFilter( blurMaskFilter );
    }
    */






}
