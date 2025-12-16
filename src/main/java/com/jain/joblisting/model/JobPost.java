package com.jain.joblisting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "JobPost")
public class JobPost {

    private String profile;
    private String desc;
    private int exp;
    private String[] techs;

    /*
    _id
        "1"
    desc
        "Software engineer who can work on enterprise projects using spring boo…"
    exp
        1
    profile
        "developer"
    techs
        Array (5)
     */

    @Override
    public String toString() {
        return "JobPost{" +
                "profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}
