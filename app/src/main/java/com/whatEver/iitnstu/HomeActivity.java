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

/**
 * Activity for main Home screen.
 *
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(HomeActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        };
        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.CALL_PHONE, Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE)
                .check();

    }

    /**
     * Onclick function for intro button.
     *
     * @param view: intro button
     */
    public void startIntro(View view) {
        Intent intent = new Intent(HomeActivity.this, IntroActivity.class);
        startActivity(intent);
    }

    /**
     * Onclick function for Course Coordinator button.
     *
     * @param view: Course Coordinator button
     */
    public void startCourseCoordinator(View view) {
        Intent intent = new Intent(HomeActivity.this, CourseCoordinatorActivity.class);
        startActivity(intent);
    }

    /**
     * Onclick function for Teachers Info button.
     *
     * @param view: Teachers Info button
     */
    public void startTeachersInfo(View view) {
        Intent intent = new Intent(HomeActivity.this, TeachersInfoActivity.class);
        startActivity(intent);
    }

    /**
     * Onclick function for Student Info button.
     *
     * @param view: Student Info button
     */
    public void startStudentInfo(View view) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user.isAnonymous()) {
            startActivity(new Intent(HomeActivity.this, AuthenticationActivity.class));
        } else {
            Intent intent = new Intent(HomeActivity.this, StudentInfoActivity.class);
            startActivity(intent);
        }

    }

    /**
     * Onclick function for Director Profile button.
     *
     * @param view: Director Profile button
     */
    public void startDirectorProfile(View view) {
        Intent intent = new Intent(HomeActivity.this, DirectorProfileActivity.class);
        startActivity(intent);
    }

    /**
     * Onclick function for Syllabus button.
     *
     * @param view: Syllabus button
     */
    public void startSyllabus(View view) {
        Intent intent = new Intent(HomeActivity.this, SyllabusActivity.class);
        startActivity(intent);
    }

    /**
     * Onclick function for All Course button.
     *
     * @param view: All Course button
     */
    public void startAllCourse(View view) {
        Intent intent = new Intent(HomeActivity.this, AllCourseDetailsActivity.class);
        startActivity(intent);
    }

    /**
     * Onclick function for Developer button.
     *
     * @param view: Developer button
     */
    public void startDeveloper(View view) {
        Intent intent = new Intent(HomeActivity.this, DevelopersActivity.class);
        startActivity(intent);
    }

    /**
     * Onclick function for Search button.
     *
     * @param view: Search button
     */
    public void startSearch(View view) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user.isAnonymous()) {
            startActivity(new Intent(HomeActivity.this, AuthenticationActivity.class));
        } else {
            Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Onclick function for Academic Officials button.
     *
     * @param view: Academic Officials button
     */
    public void startAcademicOfficials(View view) {
        Intent intent = new Intent(HomeActivity.this, OfficialsActivity.class);
        startActivity(intent);
    }

    /**
     * Onclick function for Notice Board button.
     *
     * @param view: Notice Board button
     */
    public void startNoticeBoard(View view) {
        Intent intent = new Intent(HomeActivity.this, NoticeBoardActivity.class);
        startActivity(intent);
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(HomeActivity.this, AuthenticationActivity.class));
        finish();
    }
}
