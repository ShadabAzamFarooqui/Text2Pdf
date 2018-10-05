package com.example.berylsystems.myapplication.pdf;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.berylsystems.myapplication.R;

import java.io.File;
import java.util.ArrayList;


public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        android.widget.GridView gv= (android.widget.GridView) findViewById(R.id.gv);
//        gv.setAdapter(new CustomAdapter(GridViewActivity.this,getPDFs()));
        openPDFView(getPDF().getPath());
    }

    private void openPDFView(String path)
    {
        Intent i=new Intent(getApplicationContext(),PDF_Activity.class);
        i.putExtra("PATH",path);
        startActivity(i);
    }

    private ArrayList<PDFDoc> getPDFs()

    {
        ArrayList<PDFDoc> pdfDocs=new ArrayList<>();
        //TARGET FOLDER
        File downloadsFolder = new File(Environment.getExternalStorageDirectory() + "/Documents");

        PDFDoc pdfDoc;

        if(downloadsFolder.exists())
        {
            //GET ALL FILES IN DOWNLOAD FOLDER
            File[] files=downloadsFolder.listFiles();

            //LOOP THRU THOSE FILES GETTING NAME AND URI
            for (int i=0;i<files.length;i++)
            {
                File file=files[i];

                if(file.getPath().endsWith("pdf"))
                {
                    pdfDoc=new PDFDoc();
                    pdfDoc.setName(file.getName());
                    pdfDoc.setPath(file.getAbsolutePath());

                    pdfDocs.add(pdfDoc);
                }

            }
        }

        return pdfDocs;
    }


    private PDFDoc getPDF()

    {
        //TARGET FOLDER
        File downloadsFolder = new File(Environment.getExternalStorageDirectory() + "/Documents");

        PDFDoc pdfDoc = null;

        if(downloadsFolder.exists())
        {
            //GET ALL FILES IN DOWNLOAD FOLDER
            File[] files=downloadsFolder.listFiles();

            //LOOP THRU THOSE FILES GETTING NAME AND URI
            for (int i=0;i<files.length;i++)
            {
                File file=files[i];
                if(file.getPath().endsWith("A.pdf"))
                {
                    pdfDoc=new PDFDoc();
                    pdfDoc.setName(file.getName());
                    pdfDoc.setPath(file.getAbsolutePath());
                }

            }
        }

        return pdfDoc;
    }


}
