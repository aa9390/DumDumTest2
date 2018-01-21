package org.androidtown.dumdumtest2;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        cardView = (CardView) findViewById( R.id.cardView );
        setup();
        reload();


    }

    private TouristSpot createTouristSpot() {
        return new TouristSpot("흑역사 묘지", "눈물이 너무 많은 나 어떻게 고칠 수 있을까", "15송이", "중3인데 어렸을때부터 진짜 어른들이 조금만 나한테 뭐라고 해도 바로 눈물 폭포 개방되서 막 흘러넘치거든.... 근데 난 진짜 안울고싶은데 계속 눈물이나와 마음이 너무 약한건가?? 나한테 뭐라고 하는 어른들 앞에서 잘 받아치고 자존감 있게 대응하고싶은데 난 눈물부터 나오니까 뭐가 억울해서 우는거냐 이런 말이나 듣고 진짜 너무 속상하다 나 어떻게 해야 이거 고칠 수 있지?\n" +
                "\n" +
                "더 짜증나고 거슬리는 건 학원에서 언제 한 번 선생님이 뭐라고 해서 울면 다음에 학원갔을 때 나 쟤 2분안에 울릴 수 있다이러고 친구들은 내가 울었던 그 상황 똑같이 재연하고...... 다음부턴 강경하게 대응해야겠어");
    }


    private List<TouristSpot> createTouristSpots() {
        List<TouristSpot> spots = new ArrayList<>();
        spots.add(new TouristSpot("흑역사 묘지", "눈물이 너무 많은 나 어떻게 고칠 수 있을까", "15송이", "중3인데 어렸을때부터 진짜 어른들이 조금만 나한테 뭐라고 해도 바로 눈물 폭포 개방되서 막 흘러넘치거든.... 근데 난 진짜 안울고싶은데 계속 눈물이나와 마음이 너무 약한건가?? 나한테 뭐라고 하는 어른들 앞에서 잘 받아치고 자존감 있게 대응하고싶은데 난 눈물부터 나오니까 뭐가 억울해서 우는거냐 이런 말이나 듣고 진짜 너무 속상하다 나 어떻게 해야 이거 고칠 수 있지?\n" +
                "\n" +
                "더 짜증나고 거슬리는 건 학원에서 언제 한 번 선생님이 뭐라고 해서 울면 다음에 학원갔을 때 나 쟤 2분안에 울릴 수 있다이러고 친구들은"));
        spots.add(new TouristSpot("흑역사 묘지", "눈물이 너무 많은 나 어떻게 고칠 수 있을까", "15송이", "중3인데 어렸을때부터 진짜 어른들이 조금만 나한테 뭐라고 해도 바로 눈물 폭포 개방되서 막 흘러넘치거든.... 근데 난 진짜 안울고싶은데 계속 눈물이나와 마음이 너무 약한건가?? 나한테 뭐라고 하는 어른들 앞에서 잘 받아치고 자존감 있게 대응하고싶은데 난 눈물부터 나오니까 뭐가 억울해서 우는거냐 이런 말이나 듣고 진짜 너무 속상하다 나 어떻게 해야 이거 고칠 수 있지?\n" +
                "\n" +
                "더 짜증나고 거슬리는 건 학원에서 언제 한 번 선생님이 뭐라고 해서 울면 다음에 학원갔을 때 나 쟤 2분안에 울릴 수 있다이러고 친구들은"));
        spots.add(new TouristSpot("흑역사 묘지", "눈물이 너무 많은 나 어떻게 고칠 수 있을까", "15송이", "중3인데 어렸을때부터 진짜 어른들이 조금만 나한테 뭐라고 해도 바로 눈물 폭포 개방되서 막 흘러넘치거든.... 근데 난 진짜 안울고싶은데 계속 눈물이나와 마음이 너무 약한건가?? 나한테 뭐라고 하는 어른들 앞에서 잘 받아치고 자존감 있게 대응하고싶은데 난 눈물부터 나오니까 뭐가 억울해서 우는거냐 이런 말이나 듣고 진짜 너무 속상하다 나 어떻게 해야 이거 고칠 수 있지?\n" +
                "\n" +
                "더 짜증나고 거슬리는 건 학원에서 언제 한 번 선생님이 뭐라고 해서 울면 다음에 학원갔을 때 나 쟤 2분안에 울릴 수 있다이러고 친구들은"));
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
        cardStackView.setCardEventListener(new CardStackView.CardEventListener() {
            @Override
            public void onCardDragging(float percentX, float percentY) {
                Log.d("CardStackView", "onCardDragging");
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






}
