package com.vihara.ecommerce_app;

import android.graphics.Color;
import android.os.Bundle;


import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;


import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageFragment extends Fragment {

    public HomePageFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;

    ///////////////////// Banner Slider

    private ViewPager2 bannerSliderViewPager;
    private SliderAdapter sliderAdapter;
    private List<SliderModel>sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME=3000;
    final private long PERIOD_TIME=3000;

    //////////////////// Banner Slider


    //////////////////// Strip Ad
    private ImageView stripAdImage;
    private ConstraintLayout stripAdContainer;
    //////////////////// Strip Ad



    ///////////////////Horizontal Item Layout

    private TextView horizontalLayoutTitle;
    private Button horizontalLayoutViewAllBtn;
    private RecyclerView horizontalRecyclerView;

    ///////////////////Horizontal Item Layout


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Clothing"));
        categoryModelList.add(new CategoryModel("link","Watches"));
        categoryModelList.add(new CategoryModel("link","Shoes"));
        categoryModelList.add(new CategoryModel("link","Bags"));
        categoryModelList.add(new CategoryModel("link","Fancy Items"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

        ///////////////////// Banner Slider



        sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.banner3,"#FFE1C0C0"));
        sliderModelList.add(new SliderModel(R.drawable.banner4,"#FFE1C0C0"));
        sliderModelList.add(new SliderModel(R.drawable.banner1,"#FFE1C0C0"));

        sliderModelList.add(new SliderModel(R.drawable.banner2,"#FFE1C0C0"));
        sliderModelList.add(new SliderModel(R.drawable.banner3,"#FFE1C0C0"));

        sliderModelList.add(new SliderModel(R.drawable.banner4,"#FFE1C0C0"));
        sliderModelList.add(new SliderModel(R.drawable.banner1,"#FFE1C0C0"));
        sliderModelList.add(new SliderModel(R.drawable.banner2,"#FFE1C0C0"));


        bannerSliderViewPager = view.findViewById(R.id.banner_slider_view_pager);
        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        //bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageTransformer(new MarginPageTransformer(20));

        bannerSliderViewPager.setCurrentItem(currentPage);


        ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                currentPage = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if(i == ViewPager2.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };

        bannerSliderViewPager.registerOnPageChangeCallback(onPageChangeCallback);

        startBannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener(){
                                                     public boolean onTouch(View v, MotionEvent event){
                                                         pageLooper();
                                                         stopBannerSlideShow();
                                                         if(event.getAction() == MotionEvent.ACTION_UP){
                                                             startBannerSlideShow();
                                                         }
                                                         return false;
                                                     }
                                                 }
        );

        //////////////////// Banner Slider


        //////////////////// Strip Ad
        stripAdImage = view.findViewById(R.id.strip_ad_image);
        stripAdContainer = view.findViewById(R.id.strip_ad_container);

        stripAdImage.setImageResource(R.drawable.add2);
        stripAdContainer.setBackgroundColor(Color.parseColor("#000000"));
        //////////////////// Strip Ad


        ///////////////////Horizontal Item Layout

        horizontalLayoutTitle = view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalLayoutViewAllBtn = view.findViewById(R.id.horizontal_scroll_view_all_btn);
        horizontalRecyclerView = view.findViewById(R.id.horizontal_scroll_layout_recycleview);

        List<HorizontalItemScrollModel>horizontalItemScrollModelList = new ArrayList<>();

        horizontalItemScrollModelList.add(new HorizontalItemScrollModel(R.drawable.tshirt1,"Women Casual T-Shirt","Long Sleeve Round Neck","Rs.1500/-"));
        horizontalItemScrollModelList.add(new HorizontalItemScrollModel(R.drawable.frock9,"Solid Maxi Dress","Women's Solid Embroidered","Rs.2400/-"));
        horizontalItemScrollModelList.add(new HorizontalItemScrollModel(R.drawable.jumpsu2,"New Loose Jumpsuit","Down Collar Fake Pocket Solid Color","Rs.2400/-"));
        horizontalItemScrollModelList.add(new HorizontalItemScrollModel(R.drawable.blouse1,"Blouse Office Lady","Single Breasted Puff Sleeve","Rs.1700/-"));
        horizontalItemScrollModelList.add(new HorizontalItemScrollModel(R.drawable.frock1,"Plus Size Loose Jumpsuit","Girls Students Long Pants","Rs.1500/-"));
        horizontalItemScrollModelList.add(new HorizontalItemScrollModel(R.drawable.jumpsu5,"Denim Jumpsuits Spring","Blue Overalls Outwear Casual","Rs.2700/-"));
        horizontalItemScrollModelList.add(new HorizontalItemScrollModel(R.drawable.frock2,"Knee-Length Casual Dress","Half Sleeve A-Line Dress","Rs.1900/-"));
        horizontalItemScrollModelList.add(new HorizontalItemScrollModel(R.drawable.tshirt4,"Short Sleeve T-shirt","Casual T-shirt Plus Size","Rs.1800/-"));
        horizontalItemScrollModelList.add(new HorizontalItemScrollModel(R.drawable.frock3,"Short Sleeve Dress Female","Retro Personality Button V Neck","Rs.3100/-"));
        horizontalItemScrollModelList.add(new HorizontalItemScrollModel(R.drawable.jumpsu1,"Chiffon Jumpsuit Casual","Irregular Office Lady Solid","Rs.3400/-"));

        HorizontalItemScrollAdapter horizontalItemScrollAdapter = new HorizontalItemScrollAdapter(horizontalItemScrollModelList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalItemScrollAdapter);
        horizontalItemScrollAdapter.notifyDataSetChanged();

        ///////////////////Horizontal Item Layout


        ////////////////// Grid Item Layout

        TextView gridLayoutTitle = view.findViewById(R.id.grid_item_layout_title);
        Button gridLayoutViewAllBtn = view.findViewById(R.id.grid_item_layout_viewall_btn);
        GridView gridView = view.findViewById(R.id.grid_item_layout_gridview);

        gridView.setAdapter(new GridItemLayoutAdapter(horizontalItemScrollModelList));

        ////////////////// Grid Item Layout

        return view;
    }

    //////////////////// Banner Slider

    private void pageLooper(){
        if(currentPage == sliderModelList.size() - 2){
            currentPage = 2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }

        if(currentPage == 1){
            currentPage = sliderModelList.size() -3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }

    }

    private void startBannerSlideShow(){
        Handler handler = new Handler();
        Runnable update = new Runnable(){
            public void run(){
                if(currentPage>= sliderModelList.size()){
                    currentPage=1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME,PERIOD_TIME);
    }
    private void stopBannerSlideShow(){
        timer.cancel();
    }




    //////////////////// Banner Slider

}