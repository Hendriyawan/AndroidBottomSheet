package com.hdev.bottomsheet.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottom_sheet_now_play)
    LinearLayout linearLayoutBottomSheet;
    @BindView(R.id.btn_show_bottom_sheet)
    Button buttonShowBottomSheet;
    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initBottomSheetBehavior();

    }

    /**
     * OnClick button show bottom sheet
     */
    @OnClick(R.id.btn_show_bottom_sheet)
    public void onClickShowBottomSheet() {
        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            buttonShowBottomSheet.setText(getResources().getString(R.string.text_button_show_bottom_sheet));
        } else {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            buttonShowBottomSheet.setText(getResources().getString(R.string.text_button_hide_bottom_sheet));
        }
    }


    /**
     * init BottomSheetBehavior
     */
    private void initBottomSheetBehavior() {
        bottomSheetBehavior = BottomSheetBehavior.from(linearLayoutBottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.d("DEBUG", "hidden");
                        buttonShowBottomSheet.setText(getResources().getString(R.string.text_button_show_bottom_sheet));
                        break;

                    case BottomSheetBehavior.STATE_EXPANDED:
                        Log.d("DEBUG", "expanded");
                        break;

                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Log.d("DEBUG", "collapsed");
                        buttonShowBottomSheet.setText(getResources().getString(R.string.text_button_hide_bottom_sheet));
                        break;

                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.d("DEBUG", "dragging");
                        break;

                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.d("DEBUG", "settling");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
    }

}
