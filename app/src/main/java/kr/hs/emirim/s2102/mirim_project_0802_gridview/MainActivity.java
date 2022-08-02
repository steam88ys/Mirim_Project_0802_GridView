package kr.hs.emirim.s2102.mirim_project_0802_gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView gridv;
    int[] posterId = {R.drawable.mv1, R.drawable.mv2, R.drawable.mv3, R.drawable.mv4,
                        R.drawable.mv5, R.drawable.mv6, R.drawable.mv7, R.drawable.mv8,
                        R.drawable.mv9, R.drawable.mv10,
                        R.drawable.mv1, R.drawable.mv2, R.drawable.mv3, R.drawable.mv4,
                        R.drawable.mv5, R.drawable.mv6, R.drawable.mv7, R.drawable.mv8,
                        R.drawable.mv9, R.drawable.mv10,
                        R.drawable.mv1, R.drawable.mv2, R.drawable.mv3, R.drawable.mv4,
                        R.drawable.mv5, R.drawable.mv6, R.drawable.mv7, R.drawable.mv8,
                        R.drawable.mv9, R.drawable.mv10};
    String[] posterTitle = {"타이타닉", "노트북", "세렌디피티", "유령신부", "빅피쉬",
                            "이터널선샤인", "로미오와 줄리엣", "보헤미안랩소디",
                            "Knockin' On Heaven's Door", "노인을 위한 나라는 없다",
                            "타이타닉", "노트북", "세렌디피티", "유령신부", "빅피쉬",
                            "이터널선샤인", "로미오와 줄리엣", "보헤미안랩소디",
                            "Knockin' On Heaven's Door", "노인을 위한 나라는 없다",
                            "타이타닉", "노트북", "세렌디피티", "유령신부", "빅피쉬",
                            "이터널선샤인", "로미오와 줄리엣", "보헤미안랩소디",
                            "Knockin' On Heaven's Door", "노인을 위한 나라는 없다"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("영화포스터");
        gridv = findViewById(R.id.gridv);
        PosterAdapter adapter = new PosterAdapter(this);
        gridv.setAdapter(adapter);
    }

    public class PosterAdapter extends BaseAdapter {
        Context context;
        public PosterAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            GridView.LayoutParams params = new GridView.LayoutParams(200, 300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setPadding(5, 5, 5, 5);
            imgv.setImageResource(posterId[i]);

            final int pos = i;
            imgv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle(posterTitle[i]);
                    dlg.setIcon(R.drawable.movie);
                    View dlgView = View.inflate(MainActivity.this, R.layout.dialog, null);
                    ImageView imgvDlg = dlgView.findViewById(R.id.imgv_dlg);
                    imgvDlg.setImageResource(posterId[pos]);
                    dlg.setView(dlgView);
                    dlg.setNegativeButton("close", null);
                    dlg.show();
                }
            });
            return imgv;
        }
    }

}