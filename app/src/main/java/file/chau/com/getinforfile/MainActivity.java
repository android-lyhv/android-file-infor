package file.chau.com.getinforfile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Intent intent;
    private TextView txtfile_path;
    private TextView txtfileName;
    private TextView txtsize;
    private TextView txtfileType;
    private TextView txtcreated;
    private TextView txtmodified;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        button = (Button) findViewById(R.id.button);
        txtfile_path = (TextView) findViewById(R.id.file_path);
        txtfileName = (TextView) findViewById(R.id.file_name);
        txtsize = (TextView) findViewById(R.id.file_size);
        txtfileType = (TextView) findViewById(R.id.file_type);
        txtcreated = (TextView) findViewById(R.id.file_created);
        txtmodified = (TextView) findViewById(R.id.file_modified);
        handlerClickButton(button);

    }

    private void handlerClickButton(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_GET_CONTENT);
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("file/*");
                startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            File file = new File(Uri.parse(data.getDataString()).getPath());
            GetDetailFile detailFile = new GetDetailFile(file);
            detailFile.configFile();
            txtfile_path.setText(detailFile.getFile_path());
            txtfileName.setText(detailFile.getFileName());
            txtfileType.setText(detailFile.getFileType());
            txtsize.setText(String.valueOf(detailFile.getSize()) +" KB");
            txtcreated.setText(String.valueOf(detailFile.getCreated()));
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
