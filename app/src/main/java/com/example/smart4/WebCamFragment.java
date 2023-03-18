package com.example.smart4;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WebCamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebCamFragment extends Fragment {
    private WebView webView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WebCamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WebCamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WebCamFragment newInstance(String param1, String param2) {
        WebCamFragment fragment = new WebCamFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_web_cam, container, false);

        WebView webView = view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true); // 자바스크립트 사용여부
        webView.setWebViewClient(new WebViewClient());  // 새 창 띄우기 않기
        //webView.loadUrl("https://www.naver.com/");//웹페이지 호출
        webView.loadData("<html><head><style type='text/css'>body{margin:auto auto;text-align:center;}" + "img{width:100%25;}div{overflow: hidden;}</style></head>" + "<body><div><img src=''/></div></body></html>", "text/html", "UTF-8");//웹데이터 호출
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN){
                    if (keyCode == KeyEvent.KEYCODE_BACK){
                        if (webView!=null){
                            if (webView.canGoBack()) {
                                webView.goBack();
                            }else {
                                getActivity().onBackPressed();
                            }
                        }
                    }
                }return false;
            }
        });
        return view;
    }
}