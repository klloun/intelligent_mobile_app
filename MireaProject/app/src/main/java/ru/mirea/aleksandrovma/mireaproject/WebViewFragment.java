package ru.mirea.aleksandrovma.mireaproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class WebViewFragment extends Fragment {
    private WebView webView;
    private EditText etUrl;
    private Button btnGo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web_view, container, false);

        webView = view.findViewById(R.id.webView);
        etUrl = view.findViewById(R.id.etUrl);
        btnGo = view.findViewById(R.id.btnGo);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.mirea.ru");

        btnGo.setOnClickListener(v -> {
            String url = etUrl.getText().toString();
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }
            webView.loadUrl(url);
        });

        return view;
    }
}