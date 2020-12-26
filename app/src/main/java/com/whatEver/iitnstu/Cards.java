package com.whatEver.iitnstu;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;


import android.annotation.SuppressLint;
import android.content.Context;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


@SuppressLint("ViewConstructor")
public class Cards extends FrameLayout {


    public Cards(@NonNull final Context context, final String name, final String id, final String phnNo, final String email) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.activity_cards, this, true);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.fromdown);
        CardView cardView=findViewById(R.id.card);
        cardView.startAnimation(animation);

        ImageView studentPic=findViewById(R.id.studentPic);
        final Context context1 = studentPic.getContext();
        int picId = context.getResources().getIdentifier(id.toLowerCase(), "drawable", context1.getPackageName());
        studentPic.setImageResource(picId);

        /*final StorageReference ref = FirebaseStorage.getInstance().getReference().child("students").child("batch-2").child(id+".png");
        UploadTask uploadTask = ref.putFile(getUriToDrawable(getContext(),picId));
        uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if (!task.isSuccessful()) {
                    throw task.getException();
                }
                return ref.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {
                    Uri downloadUri = task.getResult();
                    Log.d("debug",downloadUri.toString());

                    final HashMap<String,String> tmp=new HashMap<>();
                    tmp.put("name",name);
                    tmp.put("id",id);
                    tmp.put("phone",phnNo);
                    tmp.put("email",email);
                    tmp.put("imageLink",downloadUri.toString());

                    //HashMap<String,Object> data=new HashMap<>(list);
                    String num;
                    if(count.length()==1)num="0"+count;
                    else  num=count;
                    FirebaseFirestore.getInstance().collection("students").document("info").
                            collection("batch-2").document(num).set(tmp);
                    FirebaseFirestore.getInstance().collection("students").document("all-Students").collection("by_id").document(id).set(tmp);

                }
            }
        });*/


        TextView studentName=findViewById(R.id.studentName);
        studentName.setText(name);

        TextView studentID=findViewById(R.id.studentID);
        studentID.setText(id);

        TextView studentPhnNo=findViewById(R.id.studentPhnNo);
        studentPhnNo.setText(phnNo);
        LinearLayout phn=findViewById(R.id.phnNo);
        phn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: "+phnNo));
                v.getContext().startActivity(intent);
            }
        });

        TextView studentEmail=findViewById(R.id.studentEmail);
        studentEmail.setText(Html.fromHtml("<a href=\"mailto:"+email+"\">"+email+"</a>" ));
        studentEmail.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
