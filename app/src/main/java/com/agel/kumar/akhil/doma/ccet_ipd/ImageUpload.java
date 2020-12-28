package com.agel.kumar.akhil.doma.ccet_ipd;

/**
 * Created by Dell on 27-02-2018.
 */

public class ImageUpload {

    public String project_title;
    public String url;
    public Details Student1;
    public Details Student2;
    public Details Student3;
    public String mentor;
    public String group;


    public String getName() {
        return project_title;
    }

    public String getUrl() {
        return url;
    }

    public ImageUpload(String project_title, String url, Details student1, Details student2, Details student3, String mentor, String group) {
        this.project_title = project_title;
        this.url = url;
        Student1 = student1;
        Student2 = student2;
        Student3 = student3;
        this.mentor = mentor;
        this.group = group;
    }
}
