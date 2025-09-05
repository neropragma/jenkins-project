package models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class MemberPojo {
    private String name;
    private String agency;
    private String image;
    private String wikipedia;
    private ArrayList<String> launches;
    private String status;
    private String id;
}
