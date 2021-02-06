package com.whatEver.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

public class HomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                //Toast.makeText(HomeActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(HomeActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        };
        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.CALL_PHONE, Manifest.permission.INTERNET,Manifest.permission.ACCESS_NETWORK_STATE)
                .check();

    }

    public void onClick(View view){
        Intent intent=new Intent(HomeActivity.this,IntroActivity.class);
        startActivity(intent);
    }

    public void Click_Function(View view){
        Intent intent=new Intent(HomeActivity.this, AllCourseDetails.class);
        startActivity(intent);
    }

    public void startCourseCoodinator(View view){
        Intent intent=new Intent(HomeActivity.this,CourseCoordinator.class);
        startActivity(intent);
    }
    public void teachers(View view){
        Intent intent=new Intent(HomeActivity.this,TeachersInfo.class);
        startActivity(intent);
    }
    public void startStudentInfo(View view){
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        if(user.isAnonymous()){
            startActivity(new Intent(HomeActivity.this,Authentication.class));
        }
        else{
            Intent intent=new Intent(HomeActivity.this, StudentInfoMain.class);
            startActivity(intent);
        }

    }

    public void startDirectorProfile(View view){
        Intent intent=new Intent(HomeActivity.this, DirectorProfile.class);
        startActivity(intent);
    }

    public void startAllCourse(View view){
        Intent intent=new Intent(HomeActivity.this, SyllabusMain.class);
        startActivity(intent);
    }


    public void startdeveloper(View view){
        Intent intent=new Intent(HomeActivity.this, Developers.class);
        startActivity(intent);
    }

    /*public void startSearch(View view){
        Intent intent=new Intent(HomeActivity.this, Search.class);
        startActivity(intent);
    }*/

    public void startAcademicOfficials(View view){
        Intent intent=new Intent(HomeActivity.this, Officials.class);
        startActivity(intent);
    }

    public void startNoticeBoard(View view){
        Intent intent=new Intent(HomeActivity.this, NoticeBoard.class);
        startActivity(intent);
    }
}
