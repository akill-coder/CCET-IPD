package com.agel.kumar.akhil.doma.ccet_ipd;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.app.Activity.RESULT_OK;


public class Register extends Fragment {

    EditText s1_name;
    EditText s1_father;
    EditText s1_roll;
    EditText s1_branch;
    EditText s1_college;
    EditText s1_email;
    EditText s1_phone;

    EditText s2_name;
    EditText s2_father;
    EditText s2_roll;
    EditText s2_branch;
    EditText s2_college;
    EditText s2_email;
    EditText s2_phone;


    EditText s3_name;
    EditText s3_father;
    EditText s3_roll;
    EditText s3_branch;
    EditText s3_college;
    EditText s3_email;
    EditText s3_phone;


    Details[] a = new Details[3];


    EditText Mentor;
    EditText group;






    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private EditText txtImageName;
    private Uri imgUri;

    public static final String FB_STORAGE_PATH = "IPD/";
    public static final String FB_DATABSE_PATH = "IPD/";


    public static final int REQUEST_CODE = 1234;


    public static Register newInstance() {
        Register fragment = new Register();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }






    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {





        group = (EditText) getView().findViewById(R.id.group);


        mStorageRef = FirebaseStorage.getInstance().getReference();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference();


        txtImageName = (EditText) getView().findViewById(R.id.textImageName);


        //new--------------------------------------------------------------------------------


        s1_name = (EditText) getView().findViewById(R.id.editText);
        s1_father = (EditText) getView().findViewById(R.id.editText2);
        s1_roll = (EditText) getView().findViewById(R.id.editText3);
        s1_branch = (EditText) getView().findViewById(R.id.editText4);
        s1_college = (EditText) getView().findViewById(R.id.editText5);
        s1_email = (EditText) getView().findViewById(R.id.editText6);
        s1_phone = (EditText) getView().findViewById(R.id.editText7);


        s2_name = (EditText) getView().findViewById(R.id.editTextq2);
        s2_father = (EditText) getView().findViewById(R.id.editText22);
        s2_roll = (EditText) getView().findViewById(R.id.editText32);
        s2_branch = (EditText) getView().findViewById(R.id.editText42);
        s2_college = (EditText) getView().findViewById(R.id.editText52);
        s2_email = (EditText) getView().findViewById(R.id.editText62);
        s2_phone = (EditText) getView().findViewById(R.id.editText72);


        s3_name = (EditText) getView().findViewById(R.id.editTextq3);
        s3_father = (EditText) getView().findViewById(R.id.editText23);
        s3_roll = (EditText) getView().findViewById(R.id.editText33);
        s3_branch = (EditText) getView().findViewById(R.id.editText43);
        s3_college = (EditText) getView().findViewById(R.id.editText53);
        s3_email = (EditText) getView().findViewById(R.id.editText63);
        s3_phone = (EditText) getView().findViewById(R.id.editText73);


        final Button attachfile = getView().findViewById(R.id.button2);
        Button submit = getView().findViewById(R.id.button3);


        attachfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


 Intent intent = new Intent();
                //intent.setType("image/");

              //  intent.setType("application/vnd.openxmlformats-officedocument.wordprocessingml.document"); // ---------------------------------------------
                intent.setType("application/*"); // ---------------------------------------------
              // intent.setType("application/vnd.openxmlformats-officedocument.presentationml.presentation");


                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select File"), REQUEST_CODE);


            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("VisibleForTests")
            @Override
            public void onClick(View v) {


                Mentor = (EditText) getView().findViewById(R.id.mentor);
                group = (EditText) getView().findViewById(R.id.group);


                if (txtImageName.getText().toString().trim().isEmpty()) {

                    //Toast.makeText(SignUpActivity.this, "enter E-mail", Toast.LENGTH_SHORT).show();
                    txtImageName.setError("Required");
                    txtImageName.requestFocus();
                    return;

                }


                if (Mentor.getText().toString().trim().isEmpty()) {

                    //Toast.makeText(SignUpActivity.this, "enter E-mail", Toast.LENGTH_SHORT).show();
                    Mentor.setError("Required");
                    Mentor.requestFocus();
                    return;

                }

                if (group.getText().toString().trim().isEmpty()) {

                    //Toast.makeText(SignUpActivity.this, "enter E-mail", Toast.LENGTH_SHORT).show();
                    group.setError("Required");
                    group.requestFocus();
                    return;

                }
                if(!(group.getText().toString().trim().contentEquals("1") || group.getText().toString().trim().contentEquals("2") || group.getText().toString().trim().contentEquals("3"))){
                    group.setError("Required year 1/2/3");
                    group.requestFocus();
                    return;
                }


                CheckBox stu1 = (CheckBox) getView().findViewById(R.id.stu1);
                CheckBox stu2 = (CheckBox) getView().findViewById(R.id.stu2);
                CheckBox stu3 = (CheckBox) getView().findViewById(R.id.stu3);


                if (!stu1.isChecked() && !stu2.isChecked() && !stu3.isChecked()) {

                    Toast.makeText(getContext(), "One Student is required", Toast.LENGTH_SHORT).show();
                } else {

                    if (stu1.isChecked()) {


                        if (s1_name.getText().toString().trim().isEmpty()) {
                            s1_name.setError("Required");
                            //s1_name.requestFocus();
                            return;
                        }

                        if (s1_father.getText().toString().trim().isEmpty()) {
                            s1_father.setError("Required");
                            // s1_father.requestFocus();
                            return;
                        }


                        if (s1_roll.getText().toString().trim().isEmpty()) {
                            s1_roll.setError("Required");
                            //s1_roll.requestFocus();
                            return;
                        }

                        if (s1_branch.getText().toString().trim().isEmpty()) {
                            s1_branch.setError("Required");
                            // s1_branch.requestFocus();
                            return;
                        }

                        if (s1_college.getText().toString().trim().isEmpty()) {
                            s1_college.setError("Required");
                            //s1_college.requestFocus();
                            return;
                        }

                        if (s1_email.getText().toString().trim().isEmpty()) {
                            s1_email.setError("Required");
                            // s1_email.requestFocus();
                            return;
                        }

                        if (!Patterns.EMAIL_ADDRESS.matcher(s1_email.getText().toString().trim()).matches()) {
                            // Toast.makeText(SignUpActivity.this, "enter valid E-mail", Toast.LENGTH_SHORT).show();
                            s1_email.setError("enter valid E-mail");
                            // s1_email.requestFocus();
                            return;

                        }

                        if (s1_phone.getText().toString().trim().isEmpty()) {
                            s1_phone.setError("Required");
                            //  s1_phone.requestFocus();
                            return;
                        }


                        if (s1_phone.getText().toString().trim().length() != 10) {

                            s1_phone.setError("required 10 digit no.");
                            //  s1_phone.requestFocus();
                            return;

                        }


                    }

                    if (stu2.isChecked()) {

                        if (s2_name.getText().toString().trim().isEmpty()) {
                            s2_name.setError("Required");
                            //  s2_name.requestFocus();
                            return;
                        }

                        if (s2_father.getText().toString().trim().isEmpty()) {
                            s2_father.setError("Required");
                            //  s2_father.requestFocus();
                            return;
                        }


                        if (s2_roll.getText().toString().trim().isEmpty()) {
                            s2_roll.setError("Required");
                            //  s2_roll.requestFocus();
                            return;
                        }

                        if (s2_branch.getText().toString().trim().isEmpty()) {
                            s2_branch.setError("Required");
                            //  s2_branch.requestFocus();
                            return;
                        }

                        if (s2_college.getText().toString().trim().isEmpty()) {
                            s2_college.setError("Required");
                            //  s2_college.requestFocus();
                            return;
                        }

                        if (s2_email.getText().toString().trim().isEmpty()) {
                            s2_email.setError("Required");
                            //  s2_email.requestFocus();
                            return;
                        }

                        if (!Patterns.EMAIL_ADDRESS.matcher(s2_email.getText().toString().trim()).matches()) {
                            // Toast.makeText(SignUpActivity.this, "enter valid E-mail", Toast.LENGTH_SHORT).show();
                            s2_email.setError("enter valid E-mail");
                            // s2_email.requestFocus();
                            return;

                        }

                        if (s2_phone.getText().toString().trim().isEmpty()) {
                            s2_phone.setError("Required");
                            //   s2_phone.requestFocus();
                            return;
                        }

                        if (s2_phone.getText().toString().trim().length() != 10) {

                            s2_phone.setError("required 10 digit no.");
                            //  s2_phone.requestFocus();
                            return;

                        }


                    }


                    if (stu3.isChecked()) {


                        if (s3_name.getText().toString().trim().isEmpty()) {
                            s3_name.setError("Required");
                            //  s3_name.requestFocus();
                            return;
                        }

                        if (s3_father.getText().toString().trim().isEmpty()) {
                            s3_father.setError("Required");
                            //  s3_father.requestFocus();
                            return;
                        }


                        if (s3_roll.getText().toString().trim().isEmpty()) {
                            s3_roll.setError("Required");
                            //  s3_roll.requestFocus();
                            return;
                        }

                        if (s3_branch.getText().toString().trim().isEmpty()) {
                            s3_branch.setError("Required");
                            //  s3_branch.requestFocus();
                            return;
                        }

                        if (s3_college.getText().toString().trim().isEmpty()) {
                            s3_college.setError("Required");
                            //  s3_college.requestFocus();
                            return;
                        }


                        if (s3_email.getText().toString().trim().isEmpty()) {
                            s3_email.setError("Required");
                            //  s3_email.requestFocus();
                            return;
                        }

                        if (!Patterns.EMAIL_ADDRESS.matcher(s3_email.getText().toString().trim()).matches()) {
                            // Toast.makeText(SignUpActivity.this, "enter valid E-mail", Toast.LENGTH_SHORT).show();
                            s3_email.setError("enter valid E-mail");
                            s3_email.requestFocus();
                            return;

                        }

                        if (s3_phone.getText().toString().trim().isEmpty()) {
                            s3_phone.setError("Required");
                            //   s3_phone.requestFocus();
                            return;
                        }


                        if (s3_phone.getText().toString().trim().length() != 10) {

                            s3_phone.setError("required 10 digit no.");
                            // s3_phone.requestFocus();
                            return;

                        }


                    }


                    if (imgUri != null) {


                        openDialog();

                    /* if(agreeCheck == 1){

                         agreeCheck = 0;
                        final ProgressDialog dialog = new ProgressDialog(getContext());
                        dialog.setTitle("Uploading File");
                        dialog.show();


                        a[0] = new Details(s1_name.getText().toString().trim(), s1_father.getText().toString().trim(), s1_roll.getText().toString().trim(), s1_branch.getText().toString().trim(), s1_college.getText().toString().trim(), s1_email.getText().toString().trim(), s1_phone.getText().toString().trim());
                        a[1] = new Details(s2_name.getText().toString().trim(), s2_father.getText().toString().trim(), s2_roll.getText().toString().trim(), s2_branch.getText().toString().trim(), s2_college.getText().toString().trim(), s2_email.getText().toString().trim(), s2_phone.getText().toString().trim());
                        a[2] = new Details(s3_name.getText().toString().trim(), s3_father.getText().toString().trim(), s3_roll.getText().toString().trim(), s3_branch.getText().toString().trim(), s3_college.getText().toString().trim(), s3_email.getText().toString().trim(), s3_phone.getText().toString().trim());


                        long yourmilliseconds = System.currentTimeMillis();
                        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
                        Date resultdate = new Date(yourmilliseconds);


                        // get thr storage reference
                        StorageReference ref = mStorageRef.child(FB_STORAGE_PATH + group.getText().toString() + "/" + s1_college.getText().toString() + "---" + txtImageName.getText().toString().trim() + "   " + "(" + *//*System.currentTimeMillis()*//* sdf.format(resultdate) + ")" + "." + getImageExt(imgUri));  ///########################


                        //add file to reference

                        ref.putFile(imgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                //dismiss dialog when success
                                dialog.dismiss();
                                // displau success toast msg

                                Toast.makeText(getContext(), "File Uploaded", Toast.LENGTH_SHORT).show();
                                ImageUpload imageUpload = new ImageUpload(txtImageName.getText().toString().trim(), taskSnapshot.getDownloadUrl().toString(), a[0], a[1], a[2], Mentor.getText().toString().trim(), group.getText().toString().trim());


                                long yourmilliseconds = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
                                Date resultdate = new Date(yourmilliseconds);

                                //save image info in to firebase
                                String uploadID = mDatabaseRef.push().getKey();
                                mDatabaseRef.child(FB_DATABSE_PATH + group.getText().toString() + "/" + s1_college.getText().toString() + "----" + txtImageName.getText().toString() + "   " + "(" + *//*System.currentTimeMillis()*//* sdf.format(resultdate) + ")" + "         " + uploadID).setValue(imageUpload);

                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        //dismiss dialog when success
                                        dialog.dismiss();
                                        // displau success toast msg
                                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                })

                                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {

                                    @Override
                                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                                        //show upload progress
                                        double progress = (100 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                                        dialog.setMessage("  Uploades " + (int) progress + "%");
                                    }
                                });


                    }
                    else{

                         Toast.makeText(getContext(), "than fuck off", Toast.LENGTH_SHORT).show();
                     }*/
                    } else {

                        Toast.makeText(getContext(), "Please Select File", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }

    //###########################################################################################################

    private void openDialog() {



        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setMessage("Agree to Terms, Conditions, Rules and Regulations");
        alertDialogBuilder.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        //Toast.makeText(getContext(),"You clicked yes button",Toast.LENGTH_LONG).show();



                        {



                            final ProgressDialog dialog = new ProgressDialog(getContext());
                            dialog.setTitle("Uploading File");
                            dialog.show();
                            dialog.setCancelable(false);
                            dialog.setCanceledOnTouchOutside(false);


                            a[0] = new Details(s1_name.getText().toString().trim(), s1_father.getText().toString().trim(), s1_roll.getText().toString().trim(), s1_branch.getText().toString().trim(), s1_college.getText().toString().trim(), s1_email.getText().toString().trim(), s1_phone.getText().toString().trim());
                            a[1] = new Details(s2_name.getText().toString().trim(), s2_father.getText().toString().trim(), s2_roll.getText().toString().trim(), s2_branch.getText().toString().trim(), s2_college.getText().toString().trim(), s2_email.getText().toString().trim(), s2_phone.getText().toString().trim());
                            a[2] = new Details(s3_name.getText().toString().trim(), s3_father.getText().toString().trim(), s3_roll.getText().toString().trim(), s3_branch.getText().toString().trim(), s3_college.getText().toString().trim(), s3_email.getText().toString().trim(), s3_phone.getText().toString().trim());


                            long yourmilliseconds = System.currentTimeMillis();
                            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
                            Date resultdate = new Date(yourmilliseconds);


                            // get thr storage reference
                            StorageReference ref = mStorageRef.child(FB_STORAGE_PATH + group.getText().toString() + "/" + s1_college.getText().toString() + "---" + txtImageName.getText().toString().trim() + "   " + "(" + /*System.currentTimeMillis()*/ sdf.format(resultdate) + ")" + "." + getImageExt(imgUri));  ///########################


                            //add file to reference

                            ref.putFile(imgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @SuppressWarnings("VisibleForTests")
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                    //dismiss dialog when success
                                    dialog.dismiss();
                                    // displau success toast msg

                                    Toast.makeText(getContext(), "File Uploaded", Toast.LENGTH_SHORT).show();
                                    ImageUpload imageUpload = new ImageUpload(txtImageName.getText().toString().trim(), taskSnapshot.getDownloadUrl().toString(), a[0], a[1], a[2], Mentor.getText().toString().trim(), group.getText().toString().trim());


                                    long yourmilliseconds = System.currentTimeMillis();
                                    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
                                    Date resultdate = new Date(yourmilliseconds);

                                    //save image info in to firebase
                                    String uploadID = mDatabaseRef.push().getKey();
                                    mDatabaseRef.child(FB_DATABSE_PATH + group.getText().toString() + "/" + s1_college.getText().toString() + "----" + txtImageName.getText().toString() + "   " + "(" + /*System.currentTimeMillis()*/ sdf.format(resultdate) + ")" + "         " + uploadID).setValue(imageUpload);

                                }
                            })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {

                                            //dismiss dialog when success
                                            dialog.dismiss();
                                            // displau success toast msg
                                                    /*Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();*/
                                            Toast.makeText(getContext(), "Incorrect File Type", Toast.LENGTH_SHORT).show();
                                        }
                                    })

                                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                                        @SuppressWarnings("VisibleForTests")
                                        @Override
                                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                                            //show upload progress
                                            double progress = (100 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                                            dialog.setMessage("  Uploades " + (int) progress + "%");
                                        }
                                    });


                        }


                    }
                });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Toast.makeText(getContext(), "than fuck off", Toast.LENGTH_SHORT).show();

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


    }



    //###########################################################################################################


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView filename = (TextView) getView().findViewById(R.id.filename);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            /*Cursor returnCursor = getContext().getContentResolver().query(data.getData(), null, null, null, null);


            int sizeIndex = 0;
            if (returnCursor != null) {
                sizeIndex = returnCursor.getColumnIndex(OpenableColumns.SIZE);
            }
            if (returnCursor != null) {
                returnCursor.moveToFirst();
            }

            double a = 0;
            if (returnCursor != null) {
                a = returnCursor.getDouble(sizeIndex);
            }

            a = a / 1024.00000;

            if (returnCursor != null) {
                returnCursor.close();
            }*/

            double a = -1;
            try {
                ParcelFileDescriptor parcelFileDescriptor = getContext().getContentResolver().openFileDescriptor(data.getData(), "r");
              //  Log.i("file size", String.valueOf(parcelFileDescriptor.getStatSize()));
                if (parcelFileDescriptor != null) {
                    a = parcelFileDescriptor.getStatSize()/1024;
                }

            } catch (Exception e) {
                Toast.makeText(getContext(), "file not supported", Toast.LENGTH_SHORT).show();
            }
           // Toast.makeText(getContext(), "" + a, Toast.LENGTH_SHORT).show();



            if (a <= 3072) {
                imgUri = data.getData();

                filename.setMovementMethod(new ScrollingMovementMethod());
                filename.setText(imgUri.toString().substring(imgUri.toString().lastIndexOf('/') + 1).split("\\?")[0].split("#")[0]);   //--------------------------------------------------------


            } else {
                Toast.makeText(getContext(), "This file is too big", Toast.LENGTH_SHORT).show();
                filename.setText(".pdf file");
                imgUri = null;
            }

        }




    }




  


    public String getImageExt(Uri uri) {

        Context applicationContext = MainActivity.getContextOfApplication();
        applicationContext.getContentResolver();

        ContentResolver contentResolver = getActivity().getApplicationContext().getContentResolver();
        MimeTypeMap mimeType = MimeTypeMap.getSingleton();
        return mimeType.getExtensionFromMimeType(contentResolver.getType(uri));

    }


}
